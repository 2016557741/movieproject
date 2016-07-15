var DateUtil = {
	/** 将日期类型转换成字符串型格式yyyy-MM-dd* */
	changeDateToString : function(DateIn) {
	    if(DateIn==null){
	    	return "";
	    }
		var Year = 0;
		var Month = 0;
		var Day = 0;
		var CurrentDate = "";
		// 初始化时间
		Year = DateIn.getFullYear();
		Month = DateIn.getMonth() + 1;
		Day = DateIn.getDate();
		CurrentDate = Year + "-";
		if (Month >= 10) {
			CurrentDate = CurrentDate + Month + "-";
		} else {
			CurrentDate = CurrentDate + "0" + Month + "-";
		}
		if (Day >= 10) {
			CurrentDate = CurrentDate + Day;
		} else {
			CurrentDate = CurrentDate + "0" + Day;
		}
		return CurrentDate;
	},

	/** 将字符串格式转化日期时间  格式：yyyy-MM-dd HH:mm:ss **/
	changeStringToDate:function(str){
		var tempStrs=str.split(" ");
		
		var dateStrs=tempStrs[0].split("-");
		var year=parseInt(dateStrs[0],10);
		var month=parseInt(dateStrs[1],10)-1;
		var day=parseInt(dateStrs[2],10);
		
		var timeStrs=tempStrs[1].split(":");
		var hour=parseInt(timeStrs[0],10);
		var minute=parseInt(timeStrs[1],10);
		var second=parseInt(timeStrs[2],10);
		
		var date=new Date(year,month,day,hour,minute,second);
		return date;
		
	}
	
};