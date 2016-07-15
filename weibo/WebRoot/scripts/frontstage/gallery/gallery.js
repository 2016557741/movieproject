$(function() {
 	//TODO 相册点击事件
	$(".codrops-demos").children().each(function(){
	   $(this).bind('click',function(){
		   albumClick($(this));
 	   });
	});
	function albumClick(selector){
		$('.current-demo').removeClass('current-demo');
		selector.addClass('current-demo'); 
	   PicturesService.getPicturesByAlbumId(selector.attr('albumId'),
	   		{
	   	      callback : function(data){
			        $(".dg-wrapper").empty();
 			        for(var key in data){
 			        	var objHtml="<a href='javascript:void(0)'><img src='./images/famillyGallery/"+data[key].url+"' alt='"+data[key].url+"'><div>"+
 			        	data[key].comment+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;From&nbsp;&nbsp;&nbsp;&nbsp;"+data[key].userinfo.trueName+"&nbsp;&nbsp;&nbsp;"+DateUtil.changeDateToString(data[key].createDate)
 			        	+"</div></a>"     
			        	 $(".dg-wrapper").append(objHtml);
 			        }
			        if(data.length<3){
 			        	var objHtml="<a href='javascript:void(0)'><img src='./images/3DGallery/browser.png' alt='无图'><div>无图</div></a>"     
			        	for(var i=0;i<3-data.length;i++){
 			        				$(".dg-wrapper").append(objHtml);	 		    	    	 
 			        	}
			        }
 			        $("#dg-container").removeData('gallery');
			        $('#dg-container').gallery();	       
		   	       },
	    	   errorHandle : function(message){
	   	    	   $.ui.dialog4Info("查询出错");
	   	      },
	    	      async : true,
	    });
	}
	//相册双击编辑相册
	$(".codrops-demos").children().each(function(){
		   $(this).bind('dblclick',function(){
			   albumDbClick($(this));
		   });
	});
	function albumDbClick(selector){
		  AlbumService.loadAlbumById(selector.attr('albumId'),
			   		{
			   	      callback : function(data){
					       $("#editAlbumId").val(data.id);
					       $("#editAlbumName").val(data.name);
					       $("#editAlbumComment").val(data.comment);
					       $("#editAlbumCreateName").val(data.userinfo.trueName);
					       $("#editAlbumCreateDate").val(DateUtil.changeDateToString(data.createDate));
					       $("#editAlbumDialog").dialog( "open" );
	 		   	       },
			    	   errorHandle : function(message){
			   	    	   $.ui.dialog4Info("查询出错");
			   	      },
			    	      async : false,
	    	    });
		   $( "#editAlbumDialog" ).dialog( "open" );
	}
	//初始化弹出层
	//编辑相册
	$( "#editAlbumDialog" ).dialog({
		autoOpen: false,
		height: 310,
		width: 350,
		modal: true,
		buttons: {
		"保存": function() {
				 AlbumService.updateAlbum($("#editAlbumId").val(),$("#editAlbumName").val(),$("#editAlbumComment").val(),
					   		{
					   	      callback : function(data){
					              var objHtml='<a href="javascript:void(0)" class="current-demo" albumId="'+data.id+'"  title="'+data.comment+'&#10;创建人:'+data.userinfo.trueName+'&#10;创建日期:'+DateUtil.changeDateToString(data.createDate)+'" >'+data.name+'</a>'
 		 		                  $('.current-demo').replaceWith(objHtml);
					              
					              $('.current-demo').bind('click',function(){
					       		   albumClick($(this));
					        	   });
  					              $('.current-demo').bind('dblclick',function(){
					            	  albumDbClick($(this));
					              });
  		 		                  $.ui.dialog4Info("相册修改成功");
							      $("#editAlbumDialog").dialog( "close" );
			 		   	       },
					    	   errorHandle : function(message){
					   	    	   $.ui.dialog4Info("更新出错");
					   	      },
					    	      async : true,
			    	    });
	    },
		"删除": function() {
	    	  AlbumService.deleteAlbumById($("#editAlbumId").val(),
				   		{
				   	      callback : function(data){
	    		                $('.current-demo').remove();
	    		                $(".dg-wrapper").empty();
	    		                var objHtml="<a href='javascript:void(0)'><img src='./images/3DGallery/browser.png' alt='无图'><div>无图</div></a>"     
	    		 		    	for(var i=0;i<3;i++){
	    		 		    	    $(".dg-wrapper").append(objHtml);	 		    	    	 
	    		 		    	 }
	    	   		    	    $("#dg-container").removeData('gallery');
	    	 				    $('#dg-container').gallery();	  
	    		                
	    		                
	    		               $.ui.dialog4Info("相册删除成功");
						       $("#editAlbumDialog").dialog( "close" );
		 		   	       },
				    	   errorHandle : function(message){
				   	    	   $.ui.dialog4Info("删除出错");
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
	//新增相册
	$( "#newAlbumDialog" ).dialog({
		autoOpen: false,
		height: 240,
		width: 350,
		modal: true,
		buttons: {
		"保存": function() {
		     var name=$("#newAlbumName").val();
		     var comment=$("#newAlbumComment").val();
		     
		     if(name==""){
		    	  $.ui.dialog4Info("相册名必填");
		    	 return;
		     }
		     if(comment==""){
		    	  $.ui.dialog4Info("相册备注必填");
		    	 return;
		     }
	         var album={name:name,comment:comment};
		     AlbumService.saveAlbum( album,
			   		{
			   	      callback : function(data){
		    	          
				    	  $('.current-demo').removeClass('current-demo');
		    	          var objHtml='<a href="javascript:void(0)" class="current-demo" albumId="'+data.id+'"  title="'+data.comment+'&#10;创建人:我&#10;创建日期:'+DateUtil.changeDateToString(data.createDate)+'" >'+data.name+'</a>'
		    	          $('.codrops-demos').prepend(objHtml);
		    	          $('.current-demo').bind('click',function(){
		    	        	  albumClick($(this));
		    	          });
		    	          $('.current-demo').bind('dblclick',function(){
		    	        	  albumDbClick($(this));
		    	          });   	          
 		    	          $(".dg-wrapper").empty();
 		    	          var objHtml="<a href='javascript:void(0)'><img src='./images/3DGallery/browser.png' alt='无图'><div>无图</div></a>"     
	 		    	      for(var i=0;i<3;i++){
	 		    	    	 $(".dg-wrapper").append(objHtml);	 		    	    	 
	 		    	      }
   		    	          $("#dg-container").removeData('gallery');
 				          $('#dg-container').gallery();	  
		                  $.ui.dialog4Info("添加成功");
					      $("#newAlbumDialog").dialog( "close" );
	 		   	       },
			    	   errorHandle : function(message){
			   	    	   $.ui.dialog4Info("添加出错");
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
	function uploadImage() {  
	    $(document)  
	            .ready(  
	                    function() {  
	                        var options = {  
	                            url : "/weibo/csdn/PicturesAction_uploadFile.action",  
	                            type : "POST",  
	                            dataType : "script",  
	                            success : function(jsonObjStr) {  
	                        	   var picture=eval("(" + jsonObjStr + ")"); 
	                        	   $(".current-demo").click();
	                        	   $.ui.dialog4Info("上传成功");
	                        	   $("#uploadPictureDialog").dialog( "close" );
	                            }  
	                        };  
	                        $("#uploadForm").ajaxSubmit(options);  
	                        return false;  
	                    });  
	}  
	//上传dialog初始化
	$( "#uploadPictureDialog" ).dialog({
		autoOpen: false,
		height: 240,
		width: 350,
		modal: true,
		buttons: {
		"上传": function() {
		if($("#newPicAlbumId").val()==''){
			 $.ui.dialog4Info("请选择相册");
	   		return;
	   	}
	 
	   	if($("#newPicComment").val()==''){
	   	 $.ui.dialog4Info("请输入备注");
	   		return;
	   	}
		if($("#fileupload")[0].value==''){
			 $.ui.dialog4Info("请选择文件");
	   		return;
	   	}
		
		   uploadImage();
 	    },
 		"关闭": function() {
			$( this ).dialog( "close" );
		}
		},
		close: function() {
	
		}
	});	  
	
	
	//打开新增相册dialog
    $("#newAlbumButton").bind('click',function(){
    	 $("#newAlbumName").val('');
    	 $("#newAlbumComment").val('');
    	 $("#newAlbumDialog").dialog( "open" );	
    });
    // 打开上传图片dialog
    $("#uploadPictureButton").bind('click',function(){
   	 $('#newPicAlbumId').val($('.current-demo').attr('albumId'));
   	$("#newPicComment").val('');
   	$("#fileupload").val('');
   	 $("#uploadPictureDialog").dialog( "open" );	
   });
     
    
    
    //页面加载选择第一个
	 $('.current-demo').click();
});
