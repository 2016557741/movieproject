;(function($){
	$.extend($.ui,{
		//动画效果
 		effects : {
			dialog : {
				show :'fade',
				hide :'fade',
				resizable : true
			}
		},
		dialogDefaultConfig : {
			show :'fade',
			hide :'fade',
		},
 
		dialog4Info : function(text){
			$('<div>').attr('title','提示').html(text).dialog({
				modal:true,
				resizable:$.ui.effects.dialog.resizable,
				show:$.ui.effects.dialog.show,
				hide:$.ui.effects.dialog.hide,
				buttons:[{
					"text":'关闭',
					"click":function(){
						$(this).dialog("close");
					}
				}]
			});
		} 
	});
})(jQuery);