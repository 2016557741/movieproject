package www.csdn.project.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import www.csdn.project.domain.Userinfo;
import www.csdn.project.domain.Users;
import www.csdn.project.service.UserinfoService;

public class UserinfoAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserinfoService userinfoService; 
	 
	public void setUserinfoService(UserinfoService userinfoService) {
		this.userinfoService = userinfoService;
	}
	
	 

	/**
	 * 显示用户信息
	 * @return
	 */
	public String showUserinfo() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Users users=(Users)request.getSession().getAttribute("user");
		Integer userinfoId=users.getUserinfo().getId();
		Userinfo userinfo=userinfoService.findUserinfoById(userinfoId);
		request.setAttribute("userinfo",userinfo);
		return "showUserinfo";
	}
   /**
    * 家族人员添加
 * @throws Exception 
    */
	public String addFamilyMember() throws Exception {
		//接受数据准备
		HttpServletRequest request = ServletActionContext.getRequest();
 		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
 		String trueName=request.getParameter("trueName");
		String birthdayStr=request.getParameter("birthday");
		Date birthday=null;
		try {
			birthday=sf.parse(birthdayStr);
		} catch (Exception e) {
			new Exception("日期转换出错");
 		}
 		String work=request.getParameter("work");
 		String diedayStr=request.getParameter("dieday");
		Date dieday=null;
		try {
			dieday=sf.parse(diedayStr);
		} catch (Exception e) {
			new Exception("日期转换出错");
 		}
		String comment=request.getParameter("comment");
		
		Integer sex=null;
		String sexStr=request.getParameter("sex");
		if(!sexStr.trim().equals("")){
			 sex=Integer.valueOf(sexStr);
		}
		Integer familyId=null;
		String familyIdStr=request.getParameter("familyId");
		if(!familyIdStr.trim().equals("")){
			familyId=Integer.valueOf(familyIdStr);
		}
		Integer active=null;
		String activeStr=request.getParameter("active");
		if(!activeStr.trim().equals("")){
			active=Integer.valueOf(activeStr);
		}
		Integer parentId=null;
		String parentIdStr=request.getParameter("parentId");
		if(!parentIdStr.trim().equals("")){
			parentId=Integer.valueOf(parentIdStr);
		}
		Integer spouseId=null;
		String spouseIdStr=request.getParameter("spouseId");
		if(!spouseIdStr.trim().equals("")){
			spouseId=Integer.valueOf(spouseIdStr);
		}
		Integer level=null;
		String levelStr=request.getParameter("level");
		if(!levelStr.trim().equals("")){
			level=Integer.valueOf(levelStr);
		}
		Integer referenceUserinfoId=null;
		String referenceUserinfoIdStr=request.getParameter("referenceUserinfoId");
		if(!referenceUserinfoIdStr.trim().equals("")){
			referenceUserinfoId=Integer.valueOf(referenceUserinfoIdStr);
		}
 	    Userinfo addUserinfo=new Userinfo();//添加信息
 		addUserinfo.setTrueName(trueName);
		addUserinfo.setSex(sex);
		addUserinfo.setBirthday(birthday);
		addUserinfo.setDieday(dieday);
		addUserinfo.setWork(work);
		addUserinfo.setActive(active);
		addUserinfo.setComment(comment);
		addUserinfo.setFamilyId(familyId);
		addUserinfo.setParentId(parentId);
		addUserinfo.setSpouseId(spouseId);
		addUserinfo.setLevel(level);
		//添加孩子  正常添加 parentId!=null spouseId==null 1.添加信息
		if(parentId!=null&&spouseId==null){
	        userinfoService.saveUserinfo(addUserinfo);
		}
		//添加伴侣  正常添加 parentId==null spouseId!=null 1.添加信息 2.更新当前的伴侣信息
		else if(parentId==null&&spouseId!=null){
			Userinfo retUserinfo= userinfoService.saveUserinfo(addUserinfo);
			Userinfo editNode=userinfoService.findUserinfoById(referenceUserinfoId);
			editNode.setSpouseId(retUserinfo.getId());
			userinfoService.updateUserinfo(editNode);
 		}
		//添加上级  spouseId==null spouseId==null
		else if( spouseId==null&&spouseId==null){
			
			Userinfo editNode=userinfoService.findUserinfoById(referenceUserinfoId);
  			//1.没有上级 ，增加上级信息，更新当前节点parentid
			if(editNode.getParentId()==null){
				Userinfo retUserinfo= userinfoService.saveUserinfo(addUserinfo);
				editNode.setParentId(retUserinfo.getId());
				userinfoService.updateUserinfo(editNode);
			}
			//1.有上级，添加上级信息，更新2个上级spouseid
			else{
				Userinfo parentUserinfo=editNode.getParentInfo();
				addUserinfo.setSpouseId(parentUserinfo.getId());
				Userinfo retUserinfo= userinfoService.saveUserinfo(addUserinfo);
				parentUserinfo.setSpouseId(retUserinfo.getSpouseId());
			}
 
		}else{
			throw new Exception("不知道你要添加什么类型的节点");
		}

		return "addFamilyMemberSuc";
	}
   /**
    * 
    */
	public String updateFamilyMember() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
		Integer id= Integer.valueOf(request.getParameter("id"));
  		String trueName=request.getParameter("trueName");
		String birthdayStr=request.getParameter("birthday");
		Date birthday=null;
		try {
			birthday=sf.parse(birthdayStr);
		} catch (Exception e) {
			new Exception("日期转换出错");
 		}
		Integer active=null;
		String activeStr=request.getParameter("active");
		if(!activeStr.trim().equals("")){
			active=Integer.valueOf(activeStr);
		}
		String work=request.getParameter("work");
 		String diedayStr=request.getParameter("dieday");
		Date dieday=null;
		try {
			dieday=sf.parse(diedayStr);
		} catch (Exception e) {
			new Exception("日期转换出错");
 		}
		String comment=request.getParameter("comment");
		Userinfo userinfo=userinfoService.findUserinfoById(id);
		userinfo.setTrueName(trueName);
		userinfo.setBirthday(birthday);
		userinfo.setActive(active);
		userinfo.setWork(work);
		userinfo.setDieday(dieday);
		userinfo.setComment(comment);
		Userinfo retUserinfo=userinfoService.updateUserinfo(userinfo);
		if(retUserinfo!=null){
 			request.setAttribute("optionStatus", "success");
		}else{
			request.setAttribute("optionStatus", "faile");
		}
 		return "updateFamilyMemberSuc";
	}
}
