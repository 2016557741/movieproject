$(function() {
	
	
	 if(optionStatus=="success"){
         $.ui.dialog4Info("操作成功");
    }else if(optionStatus=="faile"){
     	$.ui.dialog4Info("操作失败");
    }
//	$('#pk-family-tree').pk_family();//初始化
//	$('#svbtn').bind('click',function(){
//	$.send_Family({url: ''})
//	});
	$("#pk-family-tree").draggable();
	// 当有伴侣没孩子的 空孩子id
	var nextNullNodeID = (function() {
		var nodes = 0;
		return function() {
			return  'parentNoChild_node_'+nodes++;
		}
	})()
	function addPerson(p,tree){
		// addPeopleRelate(data[dkey],tree);
		var uPerson= tree.AddPerson(p.id.toString(),p);
		if(p.parentInfo!=null){
			var pPerson=tree.AddPerson(p.parentInfo.id.toString(),p.parentInfo);
			uPerson.parents.push(pPerson);
			pPerson.children.push(uPerson);
			if(p.parentInfo.spouseInfo!=null){
				var sPerson=tree.AddPerson(p.parentInfo.spouseInfo.id.toString(),p.parentInfo.spouseInfo);
				uPerson.parents.push(sPerson);
				sPerson.children.push(uPerson);
			}
		}
		if(p.spouseInfo==null){// 没有伴侣
			var childrens=p.childrens;// 孩子
			for(var ckey in childrens ){ 
				var cPerson=tree.AddPerson(childrens[ckey].id.toString(),childrens[ckey]);
				uPerson.children.push(cPerson);
				addPerson(childrens[ckey],tree);
			}
		}else{// 有伴侣
			var childrens4U=p.childrens; 
			var childrens4S=p.spouseInfo.childrens;
			if(childrens4U.length!=0){// 孩子在当前节点下
				for(var ckey in childrens4U ){ 
					var cPerson=tree.AddPerson(childrens4U[ckey].id.toString(),childrens4U[ckey]);
					uPerson.children.push(cPerson);
					addPerson(childrens4U[ckey],tree);
				} 
			}else if(childrens4S.length!=0){// 孩子在伴侣节点下
				for(var ckey in childrens4S ){ 
					var cPerson=tree.AddPerson(childrens4S[ckey].id.toString(),childrens4S[ckey]);
					uPerson.children.push(cPerson);
					addPerson(childrens4S[ckey],tree);
				} 
			}else{// 没有孩子
				var parentNochildrenConfig={// 父母没有孩子的 需虚拟孩子节点
						compressable: true,	
						node: {
					fontcolor: 'white',
					background: 'white',
					height:0,
					width: 0,
					borderwidth: 0,
					bordercolor: 'white',
					spacingVertical: 0,// 垂直间距
					spacingHorizontal: 0// 水平间距
				} ,
				line: {
					offsetY: 0,
					width: 0,
					color: 'white'
				}
				};

				var sPerson=tree.AddPerson(p.spouseInfo.id.toString(),p.spouseInfo);
				if(sPerson.children.length==0&&uPerson.children.length==0){
					var parentNoChildNodeId=nextNullNodeID();
					var cPerson=tree.AddPerson(parentNoChildNodeId,'undefined',parentNochildrenConfig);
					uPerson.children.push(cPerson);
					cPerson.parents.push(cPerson);
					sPerson.children.push(cPerson);
					cPerson.parents.push(sPerson);		    			
				}
			}
		}
	}

	UserinfoService.findAncestryTree(
			{
				callback : function(data){
				var tree = new FamilyTreeJS.FamilyTree();
				for(var dkey in data){
					addPerson(data[dkey],tree);
				}
				tree.Render(document.getElementById('pk-family-tree'));
			},
			errorHandle : function(message){
				$.ui.dialog4Info("查询出错");
			},
			async : false,
			});
	var currentUser=null;// 记录当前选择的对象
	// 添加按钮初始化
	$('.family-addbtn-bg').each(function(){
		$(this).bind('click',function(){
			currentUser= $(this).data('userinfo');

			$('#showBtnWindow_currentName').html(currentUser.trueName);// 名字信息
			// 填充
			var headUrl='';
			if(currentUser.sex==0){
				headUrl='./images/headpic/man.jpg';
			}else if(currentUser.sex==1){
				headUrl='./images/headpic/woman.jpg';
			}
			if(currentUser.headPic!=null){
				headUrl='./images/headpic/'+currentUser.headPic;
			}
			if(headUrl!=""){
				$('#showBtnWindow_headImg').attr('src',headUrl);// 头像信息 填充
			}
			// 按钮显示状态初始化

			if(currentUser.spouseInfo==null){// 无配偶
				$('#pbtn').show();
			}else{// 有配偶
				$('#pbtn').hide();
			}

			if(currentUser.parentInfo!=null){
				if(currentUser.parentInfo.sex==0){// 是父亲
					$('#fbtn').hide();
					if(currentUser.parentInfo.spouseInfo==null){// 单身
						$('#mbtn').show();
					}else {
						$('#mbtn').hide()// 已婚
					}

				}else if(currentUser.parentInfo.sex==1){// 是母亲
					$('#mbtn').hide();
					if(currentUser.parentInfo.spouseInfo==null){// 单身
						$('#pbtn').show();
					}else {
						$('#pbtn').hide()// 已婚
					}
				} 
			}else{// 无父无母
				$('#fbtn').show();
				$('#mbtn').show();
			}
			$("#showBtnWindow").show();
		});
	});
	// 背景区域 点击隐藏
	$('.modal-backdrop').click(function(){
		$("#showBtnWindow").hide();
		currentUser=null;// 记录当前选择的对象
	});
	// 添加按钮 事件绑定
	$(".abtn").each(function(){
		$(this).click(function(){
			$('#newTrueName').val('');
			$('#newBirthday').val('');

			$("input[name='active'][value='1']").click();

			$('#newWork').val('');
			$('#newDieday').val('');
			$('#newComment').val('');

			$('#newFamilyId').val('');
			$('#newParentId').val('');
			$('#newSpouseId').val('');
			$('#newLevel').val('');

			$('#newFamilyId').val(currentUser.familyId);

			var clickId=$(this).parent().attr('id');
			if(clickId=='fbtn'){
				$('#newsex').val('0');
				$('#newLevel').val(currentUser.level-1);
			}else if(clickId=='mbtn'){
				$('#newsex').val('1');
				$('#newLevel').val(currentUser.level-1);

			}else if(clickId=='pbtn'){
				if(currentUser.sex==0){
					$('#newsex').val('1');
				}else if(currentUser.sex==1){
					$('#newsex').val('0');
				}else{
					$.ui.dialog4Info("性别未知");
					return;
				}
				$('#newSpouseId').val(currentUser.id);
				$('#newLevel').val(currentUser.level);
			}else if(clickId=='sbtn'){
				$('#newsex').val('0');
				$('#newParentId').val(currentUser.id);
				$('#newLevel').val(currentUser.level+1);
			}else if(clickId=='dbtn'){
				$('#newsex').val('1');
				$('#newParentId').val(currentUser.id);
				$('#newLevel').val(currentUser.level+1);

			}else{
				$.ui.dialog4Info("按钮未知类型");
				return;
			}
			$('#referenceUserinfoId').val(currentUser.id);
			$("#showBtnWindow").hide();
			$( "#dialogFormNew" ).dialog('open');
		});
	});
	/** 时间控件初始化* */	 
	var option=  {

			dateFormat: "yy-mm-dd",
			changeMonth:true,
			changeYear:true,
			yearRange: "1900:"+(new Date().getFullYear()+1),
			monthNamesShort: ["一月","二月","三月","四月","五月","六月",
			                  "七月","八月","九月","十月","十一月","十二月"],
			                  dayNamesMin: ["日","一","二","三","四","五","六"], 
			                  setOffset: function (input,offset) {

		var newOffset={};
		newOffset.left=offset.left;
		newOffset.top=input.clientHeight+60;
		return newOffset;
	}

	}
	$( "#newBirthday" ).datepicker(
			option 
	);
	$( "#newDieday" ).datepicker(
			option
	);
	$( "#editBirthday" ).datepicker(
			option
	);
	$( "#editDieday" ).datepicker(
			option
	);
	/** 弹出层初始化* */
	/** 新增 **/
	$( "#dialogFormNew" ).dialog({
		autoOpen: false,
		height:390,
		width: 350, 
		modal: true,
		buttons: {
		"保存": function() {
		$("#newSubmit").click();
	},
	"关闭": function() {
		$( this ).dialog( "close" );
	}
	},
	close: function() {

	}
	});	 
	/** 编辑 **/
	$( "#dialogFormEdit" ).dialog({
		autoOpen: false,
		height:390,
		width: 350, 
		modal: true,
		buttons: {
		"保存": function() {
		$("#editSubmit").click();
	},
	"关闭": function() {
		$( this ).dialog( "close" );
	}
	},
	close: function() {

	}
	});	 
	/** 邀请 **/
	$( "#dialogFormInvite" ).dialog({
		autoOpen: false,
		height:150,
		width: 350, 
		modal: true,
		buttons: {
		"确定": function() {
		if($('#memberId').val()==""){			
			$.ui.dialog4Info("请输入会员");
			return;
		}
		if($('#memberId').val().length>32){			
			$.ui.dialog4Info("长度不能大于32位");
			return;
		}
		 var re = /^[1-9]+[0-9]*]*$/;  
 	     if (!re.test($('#memberId').val()))  
	    {  
 	    	$.ui.dialog4Info("请输入正整数");  
 	        return;  
	     }  
		var usersId=$('#memberId').val();
		var comeintoUserinfoId=$('#cometoId').val();
		var argument={usersId:usersId,comeintoUserinfoId:comeintoUserinfoId};

		ReviewService.saveReview(argument,
			   		{
			   	      callback : function(data){
					      if(data){
					    	  $.ui.dialog4Info("邀请成功");
					      }
	 		   	       },
			    	   errorHandle : function(message){
			   	    	   $.ui.dialog4Info(message);
			   	      },
			   	   exceptionHandler : function(message,exception){
			   	    	   $.ui.dialog4Info(message);
			   	      },
			    	      async : false,
	    	    });
 	},
	"关闭": function() {
		$( this ).dialog( "close" );
	}
	},
	close: function() {

	}
	});	 
	
	/** 校验* */
	var validateOption={
			errorPlacement:function(error,element) { 
		$.ui.dialog4Info(error[0].textContent);
	},
	focusInvalid:false,
	onfocusin:null,
	onfocusout:null,
	onkeyup:null,
	onclick:null,
	rules : {
		trueName : {
		required : true,
	 },
	    birthday: {
		required : true,
	 } 
	},
	messages : {
		trueName : {
		required : '真实姓名必输',
	   },
	    birthday : {
		required :'生日日期必输',
	  } 
	 }
	}
	$("#formNew").validate( validateOption);
	$("#formEdit").validate( validateOption);

	/** 右键菜单* */
	$('.familytree-node').contextMenu('myMenu1', 
			{
		bindings: 
		{
		'edit': function(t) {
		var userinfo=$(t).data('userinfo');
		
		$("#formEdit > div > input[name='trueName']").val(userinfo.trueName);
		$("#formEdit > div > input[name='birthday']").val(DateUtil.changeDateToString(userinfo.birthday));
 		if(userinfo.active==1){
			$("#formEdit > div > input[name='active'][value='1']").click();
		}else{
			$("#formEdit > div > input[name='active'][value='0']").click();
		}
 		$("#formEdit > div > input[name='dieday']").val(DateUtil.changeDateToString(userinfo.dieday));
		$("#formEdit > div > input[name='work']").val(userinfo.work);
		$("#formEdit > div > textarea[name='comment']").val(userinfo.comment);
		$("#formEdit > input[name='id']").val(userinfo.id);
		$( "#dialogFormEdit" ).dialog("open");
	},
	'invite': function(t) {
		var userinfo=$(t).data('userinfo');
		$('#memberId').val("");
		$('#cometoId').val(userinfo.id);
		$( "#dialogFormInvite" ).dialog('open');
	} 
		}
			});
	/** 鼠标已入节点效果* */
	$('.familytree-node').each( function(){
		var userinfo=$(this).data('userinfo');
		var active ="";

		var birthday=DateUtil.changeDateToString( $(this).data('userinfo').birthday);
		var dieday=DateUtil.changeDateToString( $(this).data('userinfo').dieday);
		var work=userinfo.work;
		if(work==null){
			work="";
		}

		var comment=userinfo.comment;
		if(comment==null){
			comment="";
		}
		var br="<br/>"
			var showText="出生日期:"+birthday+br;
		if($(this).data('userinfo').active==0){
			showText=showText+"去世日期:"+dieday+br;
		}else{
			showText=showText+"现任工作:"+work+br;
		}
		showText=showText+"介绍:"+comment+br;

		$(this).darkTooltip({
			content: showText,
			animation:'fadeIn',
			gravity:'west',
			theme:'dark',
			trigger:'hover' 
		});
	});
});