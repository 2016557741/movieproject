$(function() {
	/**
	 * 时间控件默认配置
	 */
	var option={
			changeMonth:true,
			changeYear:true,
			yearRange: "2010:"+(new Date().getFullYear()+1),
			monthNamesShort: ["一月","二月","三月","四月","五月","六月",
			                  "七月","八月","九月","十月","十一月","十二月"],
			                  dayNamesMin: ["日","一","二","三","四","五","六"], 
			                  timeText: '时间',
			                  hourText: '时',
			                  currentText: '今天',
			                  closeText: '确定',
			                  minuteText: '分',
			                  dateFormat: "yy-mm-dd",
			                  timeFormat: "HH:mm",
			                  setOffset: function (input,offset) {
		var newOffset={};
		newOffset.left=offset.left;
		newOffset.top=input.clientHeight+55;
		return newOffset;
	}
	};
	// 查询区时间
	$('#affairDateFrom').datetimepicker( option);
	$('#affairDateTo').datetimepicker( option);
	// 查询区按钮
	$('#goSearcButton').bind('click',function(){
		$('#submit1').click();
	});
	$('#clearButton').bind('click',function(){
		$('#commentSearc').val('');
		$('#trueNameSearc').val('');
		$('#affairDateFrom').val('');
		$('#affairDateTo').val('');
	});
	// 新增区时间
	$('#affairDate').datetimepicker( option);
	// 发布dialog初始化
	$( "#newActiveDialog" ).dialog({
		autoOpen: false,
		height: 240,
		width: 350,
		modal: true,
		buttons: {
		"保存": function() {
		var comment=$("#affairComment").val();
		var date=$("#affairDate").val();
		if(comment==""){
			$.ui.dialog4Info("内容必填");
			return;
		}
		if(date==""){
			$.ui.dialog4Info("时间必填");
			return;
		}
		var affair={comment:comment,date: DateUtil.changeStringToDate(date+":00")};


		AffairService.saveAffair( affair,
				{
			callback : function(data){
			$('<div>').attr('title','提示').html("发布成功").dialog({
				modal:false,
				resizable:$.ui.effects.dialog.resizable,
				show:$.ui.effects.dialog.show,
				hide:$.ui.effects.dialog.hide,
				buttons:[{
					"text":'关闭',
					"click":function(){
					$(this).dialog("close");
				}
				}],
				beforeClose: function( event, ui ) {$('#goSearcButton').click();}
			}
			);

		},
		errorHandle : function(message){
			$.ui.dialog4Info("发布出错");
		},
		async : true,
				});
	},
	"关闭": function() {
		$( this ).dialog( "close" );
	}
	},
	close: function() {

	}
	});	   
	// 打开发布dialog
	$("#newActive").bind('click',function(){
		$("#affairComment").val("");
		$("#affairDate").val("");
		$( "#newActiveDialog" ).dialog( "open" );
	});

	// 删除按钮
	$('.deleteAffairBtn').each(function(){
		$(this).click(function(){
			  affairId=$(this).attr('affairId');
			$('<div id="confirmDilog">').attr('title','提示').html('确认删除').dialog({
				modal:false,
				resizable:$.ui.effects.dialog.resizable,
				show:$.ui.effects.dialog.show,
				hide:$.ui.effects.dialog.hide,
				buttons:[{
					"text":'确认',
					"click":function(){
 					AffairService.deleteAffairById( affairId,
							{
						callback : function(data){
						$('#'+affairId+"_affair").remove();
						affairId='';
						$("#confirmDilog").dialog("close");
						$.ui.dialog4Info("删除成功");
					},
					errorHandle : function(message){
						$.ui.dialog4Info("删除出错");
					},
					async : true,
							});
				}
				}
				,{
					"text":'关闭',
					"click":function(){
					$(this).dialog("close");
				}
				}]
			});


		});
	});

});
