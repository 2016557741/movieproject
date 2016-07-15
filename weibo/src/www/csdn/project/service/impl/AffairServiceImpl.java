package www.csdn.project.service.impl;

import java.util.List;

import www.csdn.project.dao.AffairDao;
import www.csdn.project.domain.Affair;
import www.csdn.project.domain.Users;
import www.csdn.project.service.AffairService;

import com.opensymphony.xwork2.ActionContext;

public class AffairServiceImpl extends BaseServiceImpl implements  AffairService{
	private  AffairDao affairDao;

	public void setAffairDao(AffairDao affairDao) {
		this.affairDao = affairDao;
	}

	@Override
	public List<Affair> findAffairsByCondition(String familyId, String comment,
			String trueName, String affairDateFrom, String affairDateTo) {
		// TODO Auto-generated method stub
		return affairDao.findAffairsByCondition(familyId, comment, trueName, affairDateFrom, affairDateTo);
	}

	@Override
	public Affair saveAffair(Affair affair) {
		// TODO Auto-generated method stub
		ActionContext ctx = ActionContext.getContext();
		Users currentUser = (Users) ctx.getSession().get("user");
		affair.setFamilyId(currentUser.getUserinfo().getFamilyId());
		affair.setUserinfoId(currentUser.getUserinfo().getUsersId());
 		return  affairDao.saveAffair(affair);
	}

	@Override
	public void deleteAffairById(int id) {
		// TODO Auto-generated method stub
		affairDao.deleteAffairById(id);
	}

	 
	 

	 
}
