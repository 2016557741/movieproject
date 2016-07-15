$(function() {
	
	  if(optionStatus=="success"){
          $.ui.dialog4Info("操作成功");
     }else if(optionStatus=="faile"){
      	$.ui.dialog4Info("操作失败");
     }
	
	/** 文本框弹出事件，当为用户纪念日才弹出* */
	$( "#newAnniversary" ).click(function() {
		$("#new_anniversary_name").val('');
		$("#new_anniversary_comment").val('');
		$("#new_anniversary_date").val('');
		$( "#dialog-form-new" ).dialog( "open" );
	});
	$( ".dialog_button" ).each(function(){
		if($(this).attr("userInfoId")==userInfoId){
			$(this).click(function() {
				AnniversaryService.findAnniversaryById($(this).attr("anniversaryId"),function callback(data) {
					$("#edit_anniversary_id").val(data.id);
					$("#edit_anniversary_name").val(data.name);
					$("#edit_anniversary_comment").val(data.comment);
					$("#edit_anniversary_date").val(  ChangeDateToString(data.date));
				});
				$( "#dialog-form-edit" ).dialog( "open" );
			});
		}
	});


	/** 将日期类型转换成字符串型格式yyyy-MM-dd* */
 	function ChangeDateToString(DateIn)
 	{
		var Year=0;
		var Month=0;
		var Day=0;
		var CurrentDate="";
		// 初始化时间
		Year      = DateIn.getFullYear();
		Month     = DateIn.getMonth()+1;
		Day       = DateIn.getDate();
		CurrentDate = Year + "-";
		if (Month >= 10 )
		{
			CurrentDate = CurrentDate + Month + "-";
		}
		else
		{
			CurrentDate = CurrentDate + "0" + Month + "-";
		}
		if (Day >= 10 )
		{
			CurrentDate = CurrentDate + Day ;
		}
		else
		{
			CurrentDate = CurrentDate + "0" + Day ;
		}
		return CurrentDate;
	}




	/** 弹出层初始化* */
	$( "#dialog-form-new" ).dialog({
		autoOpen: false,
		height: 270,
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
	$( "#dialog-form-edit" ).dialog({
		autoOpen: false,
		height: 270,
		width: 350,
		modal: true,
		buttons: {
		"保存": function() {
		$("#editSubmit").click();
	},
	"删除": function() {
        var id=$("#edit_anniversary_id").val();
          window.location.href="csdn/AnniversaryAction_removeAnniversary.action?id="+id;
 //    	  AnniversaryService.deleteAnniversaryById(id,
//    		{
//    	      callback : function(){
//         		  $("#dialog-form-edit").dialog( "close" );
//    		  	  $.ui.dialog4Info("删除成功");
//    		      var obj=$("#"+id+"_li").next().next().next();
//    		      $("#"+id+"_li").remove();
//    		    
//    	       },
//     	      errorHandle : function(message){
//    	    	   $.ui.dialog4Info("删除出错");
//    	      },
//     	      async : true,
//     	    });
	},
	"关闭": function() {
		$( this ).dialog( "close" );
	}
	},
	close: function() {

	}
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
		     newOffset.top=input.clientHeight;
		     return newOffset;
 		   }
           
	}
	$( "#edit_anniversary_date" ).datepicker(
			option 
	);
	$( "#new_anniversary_date" ).datepicker(
			option
	);


	/** 表单校验* */
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
		name : {
		required : true,
	},
	comment: {
		required : true,
	},
	date: {
		required : true,
		date: true
	},
	},
	messages : {
		name : {
		required : '纪念日名称必输',
	},
	comment : {
		required :'纪念日备注必输',
	},
	date : {
		required : '纪念日日期必输',
		date:'请输入有效日期',
	},
	}
	}
	$("#form-new").validate( validateOption);
	$("#form-edit").validate( validateOption);

});
