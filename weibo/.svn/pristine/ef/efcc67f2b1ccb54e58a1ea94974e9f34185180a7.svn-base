$(document).ready(function() {
	$(".bmx").hide();
	$(".yc").hide();
	$(".info").bind("mouseover", function() {
		$(".mx").hide();
		$(".bmx").show();
	});
	$(".info").bind("mouseout", function() {
		$(".mx").show();
		$(".bmx").hide();
	});
	var i = 0;
	$(".info").bind("click", function() {
		if (i == 0) {
			$(this).css({
				"border-color" : "red"
			});
			$(".yc").show();
			i = 1;
		} else {
			$(this).css({
				"border-color" : ""
			});
			$(".yc").hide();
			i = 0;
		}
	});
	$("#content_left div").bind("mouseover", function() {
		if ($(this).find("input").length > 0) {
			$(this).find("input").css({
				"background-color" : "orange",
				"color" : "white"
			});
		} else {
			if ($(this).find("span").length > 0) {
				$(this).find("span").css({
					"background-position" : "25px 0px"
				});
			}
			$(this).css({
				"background-color" : "#E6E6E6"
			});
		}
	});
	$("#content_left div").bind("mouseout", function() {
		if ($(this).find("input").length > 0) {
			$(this).find("input").css({
				"background-color" : "",
				"color" : ""
			});
		} else {
			if ($(this).find("span").length > 0) {
				$(this).find("span").css({
					"background-position" : ""
				});
			}
			$(this).css({
				"background-color" : ""
			});
		}
	});
	$("#content_left dl").bind("mouseover", function() {
		/*if ($(this).find("span").length > 0) {
				$(this).find("span").css({
					"background-color":function(index,value){
						return red;
					}
					
				});
			}*/
		$(this).css({
			"background-color" : "#E6E6E6"
		});
	});
	$("#content_left dl").bind("mouseout", function() {
		$(this).css({
			"background-color" : ""
		});
	});
});
