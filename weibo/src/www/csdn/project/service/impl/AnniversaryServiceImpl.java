package www.csdn.project.service.impl;

import java.util.List;

import www.csdn.project.dao.AnniversaryDao;
import www.csdn.project.domain.Anniversary;
import www.csdn.project.service.AnniversaryService;

public class AnniversaryServiceImpl extends BaseServiceImpl implements  AnniversaryService{
	private  AnniversaryDao anniversaryDao;

	public void setAnniversaryDao(AnniversaryDao anniversaryDao) {
		this.anniversaryDao = anniversaryDao;
	}

	@Override
	public List<Anniversary> getAnniversarysByFamliyId(Integer famliyId) {
		// TODO Auto-generated method stub
		return anniversaryDao.getAnniversarysByFamliyId(famliyId);
	}

	@Override
	public Anniversary findAnniversaryById(int Id) {
		// TODO Auto-generated method stub
 		Anniversary anniversary=anniversaryDao.findAnniversaryById(Id);
		return anniversary;
	}

	@Override
	public void deleteAnniversaryById(int id) {
	 
		anniversaryDao.deleteAnniversaryById(id);
 		
	}

	 
}
