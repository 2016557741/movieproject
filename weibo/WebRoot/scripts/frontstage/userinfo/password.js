$(function() {
	/** 保存按钮* */
	$('#oldPassword').val("");
	$('#submitBtn').bind('click',function(){
		var oldPassword=$('#oldPassword').val();
		var newPassword=$('#newPassword').val();
		var confirmPassword=$('#confirmPassword').val();

		if($.trim(oldPassword)==""){
			$.ui.dialog4Info("请输入旧密码");
			return;
		}
		if($.trim(newPassword)==""){
			$.ui.dialog4Info("请输入新密码");
			return;
		}
		if($.trim(confirmPassword)==""){
			$.ui.dialog4Info("请确认新密码");
			return;
		}
		if(confirmPassword!=newPassword){
			$.ui.dialog4Info("2次密码不一致");
			return;
		}
		UsersService.updateUserPassword(oldPassword,newPassword,
				{
			callback : function(data){
			if(data){
				$('<div>').attr('title','提示').html("保存成功，请重新登入").dialog({
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
					beforeClose: function( event, ui ) {
					window.location.href = "./csdn/UsersAction_logout.action";
					}
				});
			}   	     
		},
		errorHandle : function(message){
			$.ui.dialog4Info(message);
		},
		exceptionHandler:function(message){
			$.ui.dialog4Info(message);
		},
		async : true,
				});


	});


});