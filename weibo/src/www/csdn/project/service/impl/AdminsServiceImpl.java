package www.csdn.project.service.impl;

import www.csdn.project.dao.AdminsDao;
import www.csdn.project.service.AdminsService;
/**
 * 
 * @author 曹建波	2013-5-2 下午3:16:11
 *
 */
public class AdminsServiceImpl extends BaseServiceImpl implements AdminsService{
	private AdminsDao adminsDao;
	

	public void setAdminsDao(AdminsDao adminsDao) {
		this.adminsDao = adminsDao;
	}


	@Override
	public boolean login(String name, String pass) {
		return adminsDao.login(name, pass);
	}



}
