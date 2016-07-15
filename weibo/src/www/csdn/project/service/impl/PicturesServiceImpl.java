package www.csdn.project.service.impl;

import java.util.List;

import www.csdn.project.dao.PicturesDao;
import www.csdn.project.domain.Pictures;
import www.csdn.project.service.PicturesService;

public class PicturesServiceImpl extends BaseServiceImpl implements PicturesService{

	private PicturesDao picturesDao;

	public void setPicturesDao(PicturesDao picturesDao) {
		this.picturesDao = picturesDao;
	}

	@Override
	public List<Pictures> getPicturesByAlbumId(int albumId) {
		// TODO Auto-generated method stub
		List<Pictures> p= picturesDao.getPicturesByAlbumId(albumId);
	     return p;
	}

	@Override
	public Pictures savePictures(Pictures pictures) {
		// TODO Auto-generated method stub
		return picturesDao.savePictures(pictures);
	}
	
}
