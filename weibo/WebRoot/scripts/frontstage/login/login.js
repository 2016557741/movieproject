$(document).ready(function() { 
    $("#signin-username").focus(function() { 
            $(this).next("label").text("");
    }).blur(function() {
        if ($(this).val().trim() == "") {
        	 $(this).next("label").text("电子邮箱");
        }
    });
    $("#signin-password").focus(function() {
		$(this).next("label").text("");
	}).blur(function() {
		if ($(this).val().trim() == "") {
			$(this).next("label").text("密码");
		}
	});


 

    $("#signin-username").focus(function() {
        $("#utsdiv").hide();
    });
    $("#signin-password").focus(function() {
        $("#utsdiv").hide();
    });
});

function checkLogin() {

    if ($("#signin-username").val().trim() == "") {
        $("#utsdiv").css({
            "background-position" : "0px 0px"
        }).show();
        return false;
    }
    if ($("#signin-username").val() != "" && $("#signin-password").val() == "") {
        $("#utsdiv").css({
            "background-position" : "0px -48px"
        }).show();
        return false;
    }
}
