var post_param = {};
var dg_param = {};
$(function() {
	setObjName('Comments');
	setCombobox(["messages", "users"]);
	post_param = {};

	/*
	 var messagestype = [{
	 type : "鍘熷垱",
	 typevalue : "鍘熷垱"
	 }, {
	 type : "杞彂",
	 typevalue : "杞彂"
	 }];

	 $("#s_type").combobox({
	 valueField : 'type',
	 textField : 'typevalue',
	 data : messagestype
	 });*/

	/*
	 $("#s_users_email").bind("blur",function(){
	 alert($(this).val());
	 });*/
	var messagestype = [{
		id : 0,
		typevalue : "未读取"
	}, {
		id : 1,
		typevalue : "已读取"
	}];

	$("#s_infoStatus").combobox({
		valueField : 'id',
		textField : 'typevalue',
		data : messagestype
	});

	openSearch(["s_info", "s_messages_info", "s_users_email"]);

	/* dg_param = {columns:""}; */
	dg_param = {
		columns : [[{
			checkbox : true
		}, {
			field : 'id',
			title : '评论ID',
			width : 100,
			align : 'center'
		}, {
			field : 'info',
			title : '评论内容',
			width : 200,
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
			field : 'infoStatus',
			title : '评论状态',
			width : 200,
			align : 'center',
			formatter : function(value, row, index) {
				if (value != null) {
					if (value == 0) {
						return "转发";
					}
					if (value == 1) {
						return "原创";
					}
				}
				return "";
			},
			editor : {
				type : 'combobox',
				options : {
					valueField : 'id',
					textField : 'typevalue',
					editable : false,
					data : messagestype,
					required : true
				}
			}
		}, {
			field : 'time',
			title : '评论时间',
			width : 200,
			align : 'center',
			formatter : function(value, row, index) {
				if (value != null) {
					return value.replace("T", " ");
				}
				return "";
			},
			editor : {
				type : createDatetimebox("time"),
				options : {
					required : true,
					editable : false
				}
			}
		}, {
			field : 'messages',
			title : '评论微博',
			width : 200,
			align : 'center',
			editor : {
				type : createCombobox("messages"),
				options : {
					required : true,
					editable : false
				}
			}
		}, {
			field : 'users',
			title : '评论用户',
			width : 200,
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
