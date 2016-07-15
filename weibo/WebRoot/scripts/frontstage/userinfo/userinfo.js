$(function() {

	/** 时间控件初始化* */
	var option = {
			dateFormat : "yy-mm-dd",
			changeMonth : true,
			changeYear : true,
			yearRange : "1800:" + (new Date().getFullYear() + 1),
			monthNamesShort : [ "一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月",
			                    "九月", "十月", "十一月", "十二月" ],
			                    dayNamesMin : [ "日", "一", "二", "三", "四", "五", "六" ],
			                    setOffset : function(input, offset) {

		var newOffset = {};
		newOffset.left = offset.left;
		newOffset.top = input.clientHeight + 150;
		return newOffset;
	 }
	}
	$("#birthday").datepicker(option);
 
	
	/**保存按钮**/
	$('#submitBtn').bind('click',function(){
		var id=$('#userinfoId').val();
		var trueName=$('#trueName').val();
		var sex=$('input[name="sex"]:checked').val();
		var birthday=new Date($('#birthday').val());
		var work=$('#work').val();
		var comment=$('#comment').val();
		if($.trim(trueName)==""){
			   $.ui.dialog4Info("真实姓名必输");
			return;
		}
		UserinfoService.updateUserinfo(id,trueName,sex,work,birthday,comment,
			   		{
			   	      callback : function(data){
			             $.ui.dialog4Info("保存成功");
	 		   	       },
			    	   errorHandle : function(message){
			   	    	   $.ui.dialog4Info("保存出错");
			   	      },
			    	      async : true,
	    	    });
		
		
	});
	
	
});