$(function($) {

	var jcrop_api, boundx, boundy,

	// Grab some information about the preview pane
	$preview = $('#preview-pane'), 
	$pcnt = $('#preview-pane .preview-container'), 
	$pimg = $('#preview-pane .preview-container img'),
 	xsize = $pcnt.width(), ysize = $pcnt.height();
    console.log('init',[xsize,ysize]);
 	$('#target').Jcrop( {
  		boxWidth:420,
 		boxHeight:420,
 		borderOpacity:0.3,
		onChange : updatePreview,
		onSelect : updatePreview,
		aspectRatio :1 
	}, function() {
		// Use the API to get the real image size
			var bounds = this.getBounds();
			boundx = bounds[0];
			boundy = bounds[1];
			// Store the API in the jcrop_api variable
			jcrop_api = this;
			// Move the preview into the jcrop container for css positioning
			$preview.appendTo(jcrop_api.ui.holder);
 
	});

	function updatePreview(c) {
		$('#width').val(c.w);  //c.w 裁剪区域的宽  
        $('#height').val(c.h); //c.h 裁剪区域的高  
        $('#x').val(c.x);  //c.x 裁剪区域左上角顶点相对于图片左上角顶点的x坐标  
        $('#y').val(c.y);  //c.y 裁剪区域顶点的y坐标
		if (parseInt(c.w) > 0) {
			var rx = xsize / c.w;
			var ry = ysize / c.h;
			$pimg.css( {
				width : Math.round(rx * boundx) + 'px',
				height : Math.round(ry * boundy) + 'px',
				marginLeft : '-' + Math.round(rx * c.x) + 'px',
				marginTop : '-' + Math.round(ry * c.y) + 'px'
			});
		}
	};
	//打开选择file框框
    $('#fileuploadBtn').bind('click',function(){
    	$('#fileupload').click();
    });
  //选择图片后立马上传
    $('#fileupload').bind('change',function(){
    	 uploadImage();
    });
    function uploadImage() {  
	    $(document)  
	            .ready(  
	                    function() {  
	                        var options = {  
	                            url : "/weibo/csdn/PicturesAction_uploadHeadPic.action",  
	                            type : "POST",  
	                            dataType : "script",  
	                            success : function(jsonObjStr) {  
	                        	   var messageMap=eval("("+jsonObjStr.substr(jsonObjStr.indexOf('"')+1,jsonObjStr.lastIndexOf('"')-1)+")"); 
	                        	   if(messageMap.flag=="success"){
	                        		  // jcrop_api.setImage("./images/headpic/"+messageMap.picName);
	                        		   $('#picName').val(messageMap.picName);
	                        		   $("#previewImg").attr("src","./images/headpic/"+messageMap.picName);
	                        		   $('#uploading').empty();  
	                        			$('#uploading').append("<img id='target' />");  
	                        		   $("#target").attr("src","./images/headpic/"+messageMap.picName);
 	                        		  $('#target').Jcrop( {
 	                        		  		boxWidth:420,
 	                        		 		boxHeight:420,
 	                        		 		borderOpacity:0.3,
 	                        				onChange : updatePreview,
 	                        				onSelect : updatePreview,
 	                        				aspectRatio :1 
 	                        			 
 	                        			}, function() {
 	                        				// Use the API to get the real image size
 	                        					var bounds = this.getBounds();
 	                        					boundx = bounds[0];
 	                        					boundy = bounds[1];
 	                        					// Store the API in the jcrop_api variable
 	                        					jcrop_api = this;
 	                        					// Move the preview into the jcrop container for css positioning
 	                        					$preview.appendTo(jcrop_api.ui.holder);
 	                        				 
 	                        			});
	 	                        		$('#width').val(0);  
	 	                                $('#height').val(0); 
	 	                                $('#x').val(0); 
	 	                                $('#y').val(0); 
	                        	   }else if(messageMap.flag=="fail"){
 	                        		   $.ui.dialog4Info(messageMap.failInfo);
	                        	   } 
	                            }  
	                        };  
	                        $("#uploadForm").ajaxSubmit(options);  
	                        return false;  
	                    });  
	};  
	 //保存按钮
    $('#submitBtn').bind('click',function(){
    	if($('#width').val()!=0&&$('#height').val()!=0&& $('#x').val()!=0&& $('#y').val()!=0){
    		saveHeadPic();	
    	}else{
    		 $.ui.dialog4Info("请剪裁图片");
    	}
    });
    function saveHeadPic() {  
	    $(document)  
	            .ready(  
	                    function() {  
	                        var options = {  
	                            url : "/weibo/csdn/PicturesAction_cutHeadPic.action",  
	                            type : "POST",  
	                            dataType : "script",  
	                            success : function(jsonObjStr) {  
	                        	  $.ui.dialog4Info("保存成功");
 	                            }  
	                        };  
	                        $("#saveHeadPicForm").ajaxSubmit(options);  
	                        return false;  
	                    });  
	};  
	
    
});