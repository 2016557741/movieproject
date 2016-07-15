package www.csdn.project.service.impl;

import java.util.Date;
import java.util.List;

import www.csdn.project.dao.UserinfoDao;
import www.csdn.project.domain.Userinfo;
import www.csdn.project.domain.Users;
import www.csdn.project.service.UserinfoService;

import com.opensymphony.xwork2.ActionContext;

public class UserinfoServiceImpl extends BaseServiceImpl implements UserinfoService{
	private UserinfoDao userinfoDao;

	public void setUserinfoDao(UserinfoDao userinfoDao) {
		this.userinfoDao = userinfoDao;
	}

	@Override
	public Userinfo findUserinfoById(int Id) {
		// TODO Auto-generated method stub
		return userinfoDao.findUserinfoById(Id);
	}

	@Override
	public Userinfo updateUserinfo(int id, String trueName, int sex,
			String work, Date birthday, String comment) {
		// TODO Auto-generated method stub
		Userinfo userinfo = userinfoDao.findUserinfoById(id);
		userinfo.setTrueName(trueName);
		userinfo.setSex(sex);
		userinfo.setWork(work);
		userinfo.setBirthday(birthday);
		userinfo.setComment(comment);
		return userinfoDao.updateUserinfo(userinfo);
	}

	@Override
	public List<Userinfo> findAncestryTree() {
		// TODO Auto-generated method stub
		ActionContext ctx = ActionContext.getContext();
		Users currentUser = (Users) ctx.getSession().get("user");
		List<Userinfo> userinfos=userinfoDao.findAncestryTree(currentUser.getUserinfo().getFamilyId());
		return userinfos;
	}

	@Override
	public Userinfo saveUserinfo(Userinfo userinfo) {
		// TODO Auto-generated method stub
		return userinfoDao.saveUserinfo(userinfo);
	}

	@Override
	public Userinfo updateUserinfo(Userinfo userinfo) {
		// TODO Auto-generated method stub
		return userinfoDao.updateUserinfo(userinfo);
	}
	
}
