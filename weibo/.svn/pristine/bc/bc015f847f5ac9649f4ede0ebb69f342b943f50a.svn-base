$(function() {
	$(".west_content a").bind('click', function() {
		var tab_title = $(this).text();
		var url = this.href;
		if ($("#tt").tabs('exists', tab_title)) {
			$("#tt").tabs("select", tab_title);
		} else {
			$("#tt").tabs('add', {
				title : tab_title,
				selected: true,
				content : createIframe(url),
				closable : true
			});
		}
		return false;
	});		
});

function createIframe(url) {
	return "<iframe scrolling='auto' frameborder='0'  src='" + url
			+ "' style='width:100%;height:100%;'></iframe>";
}