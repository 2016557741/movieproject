package www.csdn.project.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import www.csdn.project.domain.Family;
import www.csdn.project.domain.Pictures;
import www.csdn.project.domain.Userinfo;
import www.csdn.project.domain.Users;
import www.csdn.project.service.UsersService;

import com.opensymphony.xwork2.ActionContext;

public class UsersAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Users users;//用户信息
	private String code;//验证码
	private UsersService usersService;

	public void setUsers(Users users) {
		this.users = users;
	}
 
	public void setCode(String code) {
		this.code = code;
	}
 
	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}
	

	public String checkEmail() { 
		List<Users> userList = baseService.getObjects(Users.class,
				" where email='" + users.getEmail()+"'");
 		if(userList.size()>0){
			this.flag =false;
		}else{
			this.flag =true;
		}
  		return "check";
	}
	public String checkCode() {
		String randimg = (String) ActionContext.getContext().getSession()
				.get("randimg");
		if (!randimg.equals(code) && randimg != code) {
			this.flag = false;
		} else {
			this.flag = true;
		}
		return "check";
	}


 
	public String login() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String inputEmail=request.getParameter("email");
		String inputPass=request.getParameter("password");
		if (inputEmail!=null&&inputPass!=null){
 			users = usersService.login(inputEmail, inputPass);
 			if (users != null) {
 				request.getSession().setAttribute("user", users);
 				users.setStatus(1);
 				baseService.saveOrUpdateObject(users);
 				
 				List<Pictures> pictureList =baseService.getObjects(Pictures.class, " where userinfoId ='"+users.getUserinfo().getUsersId()+"' and type="+0,0, 1, "desc","createDate" );
 				if (pictureList.size() != 0) {
					Pictures headPic = pictureList.get(0);
					request.getSession().setAttribute("headPic", headPic);
				} else {
						request.getSession().setAttribute("headPic",null);

				}
  				return "login";
			} else {
				 Map<String, String> loginErrorMap =new HashMap<String, String>();
				 loginErrorMap.put("email",inputEmail);
				 loginErrorMap.put("pass",inputPass);
				 request.setAttribute("loginErrorMap",loginErrorMap);
				return "out";
			}
		} else {
			return "out";
		}
	}
	public String showIndex() {
		//家族成员
		HttpServletRequest request = ServletActionContext.getRequest();
		Users users=(Users)request.getSession().getAttribute("user");
 		if(users==null){
			return "out";
		}
 		int familyId=users.getUserinfo().getFamilyId();
		int userinfoId=users.getUserinfo().getUsersId();
		List<Userinfo> userinfoList =baseService.getObjects(Userinfo.class,
		" WHERE usersId IS NOT NULL AND familyId="+familyId+" AND usersId<>"+userinfoId);
		request.setAttribute("familiyMember", userinfoList);
		return "showIndex";
	}
	public String logout() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Users users=(Users)request.getSession().getAttribute("user");
		if(users!=null){
		request.getSession().removeAttribute("user");
		users.setStatus(0);
		baseService.saveOrUpdateObject(users);
		}
		return "out";
	}
     /***
      * 注册信息保存
      * @return
      */
	public String saveregister() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String trueName = request.getParameter("trueName");
		Integer sex =Integer.valueOf( request.getParameter("sex"));
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		//保存用户基本信息
 		Users newUser = new Users();
 		newUser.setEmail(email);
 		newUser.setPassword(password);
 		newUser.setStatus(0);
 		newUser.setCreateDate(new Date());
 		Integer pkUser= baseService.saveObject(newUser);
 		//初始化用户家族
 		Family newFamily=new Family();
 		newFamily.setCreateDate(new Date());
 		Integer pkFamily = baseService.saveObject(newFamily);
 		//保存族人详细信息
		Userinfo newUserinfo=new Userinfo();
		newUserinfo.setTrueName(trueName);
		newUserinfo.setSex(sex);
		newUserinfo.setActive(1);
		newUserinfo.setLevel(0);
		newUserinfo.setUsersId(pkUser);
		newUserinfo.setFamilyId(pkFamily);
		Integer pkUserinfo=baseService.saveObject(newUserinfo);
		//更新家族创建人
		Family retFamily=(Family)baseService.getObjectById(Family.class, pkFamily);
 		retFamily.setUserinfoId(pkUserinfo);
 		this.flag=baseService.saveOrUpdateObject(retFamily);
		if (flag == false) {
			return "faile";
		}
		return "out";
	}
}
