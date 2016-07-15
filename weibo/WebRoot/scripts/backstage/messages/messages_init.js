var post_param = {};
var dg_param = {};
$(function() {
	setObjName('Messages');
	setCombobox(["users"]);
	post_param = {};

	/*$("#s_id").numberbox();*/

	var messagestype = [{
		type : "原创",
		typevalue : "原创"
	}, {
		type : "转发",
		typevalue : "转发"
	}, {
		type : "分享",
		typevalue : "分享"
	}, {
		type : "图片",
		typevalue : "图片"
	}, {
		type : "视频",
		typevalue : "视频"
	}, {
		type : "音乐",
		typevalue : "音乐"
	}, {
		type : "标签",
		typevalue : "标签"
	}, {
		type : "心情",
		typevalue : "心情"
	}];

	$("#s_type").combobox({
		valueField : 'type',
		textField : 'typevalue',
		data : messagestype
	});
	/*
	 $("#s_users_email").bind("blur",function(){
	 alert($(this).val());
	 });*/

	openSearch(["s_info", "s_type[iscombobox]", "s_label", "s_users_email"]);

	/* dg_param = {columns:""}; */
	dg_param = {
		columns : [[{
			checkbox : true
		}, {
			field : 'id',
			title : '微博ID',
			width : 100,
			align : 'center'
		}, {
			field : 'info',
			title : '微博内容',
			width : 100,
			align : 'center',
			editor : {
				type : createEdit(),
				options : {
					validateRule : {
						required : true,
						validType : ["length[1,100]"]
					}
				}
			}
		}, {
			field : 'type',
			title : '微博类型',
			width : 100,
			align : 'center',
			editor : {
				type : 'combobox',
				options : {
					valueField : 'type',
					textField : 'typevalue',
					editable : false,
					data : messagestype,
					required : true
				}
			}
		}, {
			field : 'time',
			title : '发表时间',
			width : 160,
			align : 'center',
			formatter : function(value, rowData, rowIndex) {

				if (value == null) {
					return "";
				} else {
					var str = value.replace("T", " ");
					return str;
				}

			},
			editor : {
				type : createDatetimebox("time"),
				options : {
					required : true,
					editable : false
				}
			}
		}, {
			field : 'collectNum',
			title : '收藏次数'
		}, {
			field : 'commentNum',
			title : '评论次数'
		}, {
			field : 'transpondNum',
			title : '转发次数'
		}, {
			field : 'agreeNum',
			title : '赞次数'
		}, {
			field : 'readNum',
			title : '阅读次数'
		}, {
			field : 'label',
			title : '微博标签',
			editor : {
				type : createEdit(),
				options : {
					validateRule : {
						required : true,
						validType : ["length[2,20]"]
					}
				}
			}
		}, {
			field : "users",
			title : '微博用户',
			width : 100,
			align : 'center',
			editor : {
				type : createCombobox("users"),
				options : {
					required : true,
					editable : false
				}
			}
		}]]
	};

	initDg(post_param, dg_param);
});
