package www.csdn.project.service.impl;

import www.csdn.project.dao.UsersDao;
import www.csdn.project.domain.Users;
import www.csdn.project.service.UsersService;

import com.opensymphony.xwork2.ActionContext;

public class UsersServiceImpl extends BaseServiceImpl implements UsersService{
	private UsersDao usersDao;

	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	@Override
	public Users login(String email, String passWord) {
		return usersDao.login(email, passWord);
	}
	
	
	public boolean checkPass(Class clazz,String property,String value, Integer id){
		return usersDao.checkPass(clazz, property, value, id);
	}
	
	public Users updateUserPassword(String oldPass,String newPass) throws Exception{
		ActionContext ctx = ActionContext.getContext();
		Users currentUser = (Users) ctx.getSession().get("user");
		if(!currentUser.getPassword().equals(oldPass)){
			throw new Exception("旧密码不正确，请重新输入");
		}
		currentUser.setPassword(newPass);
		return usersDao.updateUsers(currentUser);
		
	}
}
