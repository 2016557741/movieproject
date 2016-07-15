var mJson = null;
var post_param = {};
var dg_param = {};
var urlinputval = null;
var pathval = null;
var oldpathval = null;
$(document).ready(function() {
    setObjName('Pictures');
    post_param = {};
    setCombobox(["messages", "users"]);
    $("#s_messages_id").numberbox({
        min : 1
    });
    openSearch(["s_users_email", "s_messages_id", "s_type"]);

    beforeDelete(function() {
        var deleteData = $('#dg').datagrid('getSelected').url;
        $.post('./csdn/PicturesAction_deletePictures.action?time=' + new Date().getTime(), {
            delPicURL : deleteData
        }, function(data) {

        }, "json");
    });

    beforeUpdate(function() {
        initDg(post_param, dg_param);
    });
    beforeCancel(function() {
        var deleteData = pathval.val();
        $.post('./csdn/PicturesAction_deletePictures.action?time=' + new Date().getTime(), {
            delPicURL : deleteData
        }, function(data) {

        }, "json");
    });

    beforeErrorData(function() {
        var deleteData = pathval.val();
        $.post('./csdn/PicturesAction_deletePictures.action?time=' + new Date().getTime(), {
            delPicURL : deleteData
        }, function(data) {

        }, "json");

    });
    beforeSave(function() {
        if (oldpathval != null) {
            $.post('./csdn/PicturesAction_deletePictures.action?time=' + new Date().getTime(), {
                delPicURL : oldpathval
            }, function(data) {
            }, "json");
            getSave(function(param) {
                param["pictures.url"] = urlinputval;
            });
        }
    });
    /*
     $('#ff').form('submit', {
     url : './csdn/PicturesAction_upload.action?time=' + new Date().getTime(),
     onSubmit : function(param) {

     var usersid = null;
     var messagesid = null;
     var picturestype = null;

     //var randomNum = Math.floor(Math.random() * 10000000);

     getSave(function(param) {
     usersid = param["pictures.users.id"];
     messagesid = param["pictures.messages.id"];
     picturestype = param["pictures.type"];

     if (param["pictures.messages.id"] != null) {
     param["pictures.url"] = "/userUploadImages/" + usersid + "/" + messagesid + "/" + picturestype + "/" + randomNum + "_" + splitpath;
     } else {
     param["pictures.url"] = "/userUploadImages/" + usersid + "/" + picturestype + "/" + randomNum + "_" + splitpath;
     }

     });
     //param.randomNumber = randomNum;

     },
     success : function(data) {
     alert(data);
     getSave(function(param) {
     alert(param["pictures.url"]);
     param["pictures.url"] = data;
     });

     }
     });*/

    dg_param = {
        columns : [[{
            checkbox : true
        }, {
            field : 'id',
            title : '图片ID'
        }, {
            field : 'url',
            width : 350,
            title : '图片路径',
            editor : {
                type : createEdit(),
                options : {
                    inputEdit : false,
                    inputClick : function uploadimg() {
                        pathval = $(this);
                        $("#uploadimgshow img").attr("src", "./uploadImages" + pathval.val());
                        $("#uploadimg").dialog({
                            title : '添加图片',
                            width : 400,
                            height : 350,
                            closed : false,
                            cache : false,
                            modal : true,
                            buttons : [{
                                text : '确定',
                                handler : function() {
                                    var filepath = $("#uploadimgurl").val();
                                    var extStart = filepath.lastIndexOf(".");
                                    var ext = filepath.substring(extStart, filepath.length).toUpperCase();
                                    if (ext != ".PNG" && ext != ".GIF" && ext != ".JPG" && ext != ".BMP") {
                                        alert("请选择为(.png,.gif,.jpg,.bmp)的图片文件！");
                                    } else {
                                        var splitpath = filepath.substring(filepath.lastIndexOf("\\") + 1);
                                        oldpathval = pathval.val();
                                        pathval.val(splitpath);
                                        $('#ff').form('submit', {
                                            url : './csdn/PicturesAction_upload.action?time=' + new Date().getTime(),
                                            onSubmit : function(param) {
                                                /*var randomNum = Math.floor(Math.random() * 10000000);
                                                 param.randomNumber = randomNum;*/
                                            },
                                            success : function(data) {
                                                var spilData = data.substring(2, data.length - 1);
                                                urlinputval = spilData;
                                                pathval.val(urlinputval);
                                            }
                                        });
                                        $('#uploadimg').dialog('close');
                                    }

                                }
                            }, {
                                text : '取消',
                                handler : function() {
                                    $('#uploadimg').dialog('close');
                                }
                            }]
                        });
                    },
                    validateRule : {
                        required : true,
                        validType : "urlval"
                    },
                    myRules : {
                        type : "urlval",
                        rege : new RegExp(""),
                        message : '请选择图片'
                    }
                }
            }
        }, {
            field : 'messages',
            title : '微博ID',
            editor : {
                type : createCombobox("messages"),
                options : {
                    editable : false
                }
            }

        }, {
            field : 'users',
            title : '用户Email',
            editor : {
                type : createCombobox("users"),
                options : {
                    required : true,
                    editable : false
                }
            }

        }, {
            field : 'type',
            title : '图片类型',
            editor : {
                type : createEdit(),
                options : {
                    validateRule : {
                        required : true,
                        validType : "typeval"
                    },
                    myRules : {
                        type : "typeval",
                        rege : new RegExp("^.{2,20}$"),
                        message : '图片类型至少一个字符，至多10个汉字或20个英文字符'
                    }
                }
            }
        }, {
            field : 'time',
            title : '创建时间',
            width : 150,
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
                    editable : false,
                    value : new Date().toLocaleString(),
                }
            }

        }]]

    };

    initDg(post_param, dg_param);
});
function DrawImage(ImgD, iwidth, iheight) {
    var image = new Image();
    image.src = ImgD.src;
    if (image.width > 0 && image.height > 0) {
        flag = true;
        if (image.width / image.height >= iwidth / iheight) {
            if (image.width > iwidth) {
                ImgD.width = iwidth;
                ImgD.height = (image.height * iwidth) / image.width;
            } else {
                ImgD.width = image.width;
                ImgD.height = image.height;
            }
        } else {
            if (image.height > iheight) {
                ImgD.height = iheight;
                ImgD.width = (image.width * iheight) / image.height;
            } else {
                ImgD.width = image.width;
                ImgD.height = image.height;
            }
        }
    }
}