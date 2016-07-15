/**通知按钮点击事件**/
	 function yesClick(t){
		 ReviewService.updateReview(t,true,
			   		{
			   	      callback : function(data){
					      if(data){
					    	  $( "#dialog-info" ).dialog('close');
 					    		$('<div>').attr('title','提示').html("您已经接受了邀请").dialog({
									modal:true,
									resizable:$.ui.effects.dialog.resizable,
									show:$.ui.effects.dialog.show,
									hide:$.ui.effects.dialog.hide,
									buttons:[{
										"text":'关闭',
										"click":function(){
											$(this).dialog("close");
										}
									}],
									beforeClose: function( event, ui ) {window.location.href = "./csdn/UsersAction_showIndex.action";}
								});
					    		//window.location.href = "./index.jsp";
					      }
		 			      
				   	       },
			    	   errorHandle : function(message){
			   	    	   $.ui.dialog4Info(message);
			   	      },
			   	      exceptionHandler : function(message,exception){
			   	    	   $.ui.dialog4Info(message);
			   	      },
			    	      async : false,
			    });
	 }
	 function noClick(t){
		 ReviewService.updateReview(t,false,
			   		{
			   	      callback : function(data){
					      if(data){
					    	  $( "#dialog-info" ).dialog('close');
					      }
		 			      
				   	       },
			    	   errorHandle : function(message){
			   	    	   $.ui.dialog4Info(message);
			   	      },
			   	      exceptionHandler : function(message,exception){
			   	    	   $.ui.dialog4Info(message);
			   	      },
			    	      async : false,
			    });
	 } 
$(function() {
    
	
	/**通知弹出层**/
	   $( "#dialog-info" ).dialog({
		      autoOpen: false,
		      height: 150,
		      width: 350,
		      modal: true
		    });	   
	 
	/**通知**/
	ReviewService.getReviewByUsersId(
	   		{
	   	      callback : function(data){
			      if(data.length>0){
			    	  var dialogInfo=$("#dialog-info");
			    	  for(var key in data){
			    		  var tip=data[key].userinfo.trueName+"邀请你入住家族,"+"入住节点"+data[key].comeintoUserinfo.trueName
			    		  +"。邀请时间"+DateUtil.changeDateToString(data[key].createDate);
			    		   
			    		    var infoNode=$('<div>').attr('class', 'infoNode');
			    		    var p= $('<p>').html(tip);
			    		    var div= $('<div>');
			    		    var yesBtn=$('<input type="button"  value="接受"   onclick="yesClick('+data[key].id+')"  />')
			    		    var noBtn=$('<input type="button"  value="拒绝"   onclick="noClick('+data[key].id+')" />')
			    	  
			    		    yesBtn.appendTo(div);
			    		    noBtn.appendTo(div);
			    		    p.appendTo(infoNode);
			    		    div.appendTo(infoNode);
			    		    infoNode.appendTo(dialogInfo);
			    		    $( "#dialog-info" ).dialog('open');
			    	  }
 			      }
		   	       },
	    	   errorHandle : function(message){
	   	    	   $.ui.dialog4Info(message);
	   	      },
	   	      exceptionHandler : function(message,exception){
	   	    	   $.ui.dialog4Info(message);
	   	      },
	    	      async : false,
	    });
	
	
	/*****微博字数********/
	$("#newmessage").keydown(function(event) {
		$("#messege_wn").text(140 - $(this).val().length);
		if($(this).val().length>=140){
			if(event.keyCode!=8){
				return false;	
			}
		} 
   	}).keyup(function(event) {
   		if($(this).val().length>140){
   			$(this).val($(this).val().substring(0,140));
		}
		$("#messege_wn").text(140 - $(this).val().length);
   		 
	});
	/*****时间*******/
	 $( "#search_friend" ).datepicker({dateFormat: "yy-mm-dd"})
	
	/*****qq表情*****/
	$("#facebtn").qqFace({
		id : 'facebox', 
		assign:'newmessage', 
		path:'./styles/qqface/arclist/',	//表情存放的路径
		afterChoose:'afterChooseFace',
		afterFill: 'afterFillFace'
	});
    /**上传文件弹出层**/
	   $( "#dialog-form" ).dialog({
		      autoOpen: false,
		      height: 300,
		      width: 350,
		      modal: true,
		      buttons: {
		        "上传": function() {
		   			$('#file').uploadifyUpload();  
		        },
		        "取消": function() {
		        	$('#file').uploadifyClearQueue();
		          $( this ).dialog( "close" );
		        }
		      },
		      close: function() {
		         
		      }
		    });	   
	   $( "#photobtn" )  .click(function() {
	        $( "#dialog-form" ).dialog( "open" );
	      });
	   /***文件上传配置****/
	 
	   $("#file").uploadify({  
           /*注意前面需要书写path的代码*/  
           'uploader'       : 'http://localhost:8080/weibo/images/uploadify/uploadify.swf',  
           'script'         : 'http://localhost:8080/weibo/images/UploadAction.do',  
           'cancelImg'      : 'http://localhost:8080/weibo/images/uploadify/cancel.png',  
           'queueID'        : 'fileQueue', //和存放队列的DIV的id一致  
           'fileDataName'   : 'file', //和以下input的name属性一致  
           'auto'           : false, //是否自动开始  
           'multi'          : false, //是否支持多文件上传  
           'buttonText'     : 'Browse', //按钮上的文字  
           'simUploadLimit' : 1, //一次同步上传的文件数目  
           'sizeLimit'      : 19871202, //设置单个文件大小限制  
           'queueSizeLimit' : 1, //队列中同时存在的文件个数限制  
           'fileDesc'       : '支持格式:jpg/gif/jpeg/png/bmp.', //如果配置了以下的'fileExt'属性，那么这个属性是必须的  
           'fileExt'        : '*.jpg;*.gif;*.jpeg;*.png;*.bmp',//允许的格式    
           onComplete: function (event, queueID, fileObj, response, data) {  
               $('<li></li>').appendTo('.files').text(response);  
           },  
           onError: function(event, queueID, fileObj) {  
               alert("文件:" + fileObj.name + "上传失败");  
           },  
           onCancel: function(event, queueID, fileObj){  
               alert("取消了" + fileObj.name);  
           }  
       });  
   
 
  
	 
});
//查看结果$(".sub_btn").click(function(){
//var str = $("#saytext").val();
//$("#show").html(replace_em(str));
//});
function replace_em(str){
	str = str.replace(/\</g,'&lt;');
	str = str.replace(/\>/g,'&gt;');
	str = str.replace(/\n/g,'<br/>');
	str = str.replace(/\[em_([0-9]*)\]/g,'<img src="./styles/qqface/arclist/$1.gif" border="0" />');
	return str;
}
function afterChooseFace(){
	if($("#newmessage").val().length>=134){
		 return false;	
	}
	return true;
}
function afterFillFace(){
	$("#messege_wn").text(140 - $("#newmessage").val().length);
}
