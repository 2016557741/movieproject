$(function() {
	 $("#reg-truename").focus(function() { 
         $(this).next("label").text("");
         $(this).next().next().children().first().hide();
	 }).blur(function() {
	     if ($(this).val().trim() == "") {
	     	 $(this).next("label").text("真实姓名");
	     }
	 });
	 $("#reg-username").focus(function() { 
         $(this).next("label").text("");
         $(this).next().next().children().first().hide();
	 }).blur(function() {
	     if ($(this).val().trim() == "") {
	     	 $(this).next("label").text("电子邮箱");
	     }
	 });
	 $("#reg-password").focus(function() { 
         $(this).next("label").text("");
         $(this).next().next().children().first().hide();
	 }).blur(function() {
	     if ($(this).val().trim() == "") {
	     	 $(this).next("label").text("密码(6-16位字符)");
	     }
	 });
	 $("#reg-passwords").focus(function() { 
         $(this).next("label").text("");
         $(this).next().next().children().first().hide();
	 }).blur(function() {
	     if ($(this).val().trim() == "") {
	     	 $(this).next("label").text("请再次输入密码");
	     }
	 });
	 $("#reg-checkimg").focus(function() { 
         $(this).next("label").text("");
         $(this).next().next().children().first().hide();
	 }).blur(function() {
	     if ($(this).val().trim() == "") {
	     	 $(this).next("label").text("验证码");
	     }
	 });
 
	$("#register-form").validate({
		 errorElement:"div",
		 errorClass:"arrow_box",
		 errorPlacement:function(error,element) { 
		   element.next().next().show();
		   error.appendTo(element.next().next());

	     },
	     focusInvalid:false,
		rules : {
	    	 trueName : {
				required : true,
				minlength : 2,
				maxlength : 20 
			},
			email : {
				required : true,
				email : true,
				remote : {
					url : "./csdn/UsersAction_checkEmail.action?time=" + new Date().getTime(),
					type : "post",
					dataType : "json",
					data : {
						"users.email" : function() {
							return $("#reg-username").val();
						}
					}
				}
			},
			password : {
				required : true,
				minlength : 6,
				maxlength : 16
			},
			checkimg : {
				required : true,
				minlength : 4,
				maxlength : 4,
				remote : {
					url : "./csdn/UsersAction_checkCode.action?time=" + new Date().getTime(),
					type : "post",
					dataType : "json",
					data : {
						"code" : function() {
							return $("#reg-checkimg").val();
						}
					}
				}
			}
		},
		messages : {
			trueName : {
				required : '真实姓名不能为空',
				minlength : '真实姓名不能少于2位字符',
				maxlength : '真实姓名不能大于20位字符' 
			},
			email : {
				required : '邮箱不能为空',
				email : '请输入正确的邮箱格式',
				remote : '此邮箱已被注册'
			},
			password : {
				required : '密码不能为空',
				minlength : '密码长度不能少于6位字符',
				maxlength : '密码长度不能大于16位字符'
			},
			checkimg : {
				required : '验证码不能为空',
				minlength : '验证码长度只能是4位',
				maxlength : '验证码长度只能是4位',
				remote:'验证码不正确'
			}
		}
	});
});
function change(img) {
	img.src = img.src + "?time=" + new Date().getTime();
	}
	function changeValidateCode() {   
           //获取当前的时间作为参数，无具体意义   
        var timenow = new Date().getTime();   
           //每次请求需要一个不同的参数，否则可能会返回同样的验证码   
        //这和浏览器的缓存机制有关系，也可以把页面设置为不缓存，这样就不用这个参数了。   
        $("#img").attr("src","${pageContext.request.contextPath}/csdn/ImageCheck_execute.action?d="+timenow);   
    }   