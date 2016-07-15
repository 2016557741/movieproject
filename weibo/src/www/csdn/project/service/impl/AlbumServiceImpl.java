package www.csdn.project.service.impl;

import java.util.Date;

import www.csdn.project.dao.AlbumDao;
import www.csdn.project.dao.PicturesDao;
import www.csdn.project.domain.Album;
import www.csdn.project.domain.Users;
import www.csdn.project.service.AlbumService;

import com.opensymphony.xwork2.ActionContext;

public class AlbumServiceImpl extends BaseServiceImpl implements  AlbumService{
	private  AlbumDao albumDao;
	private  PicturesDao picturesDao;
	
	public void setAlbumDao(AlbumDao albumDao) {
		this.albumDao = albumDao;
	}

	public void setPicturesDao(PicturesDao picturesDao) {
		this.picturesDao = picturesDao;
	}

	@Override
	public Album loadAlbumById(int Id) {
		// TODO Auto-generated method stub
		return albumDao.loadAlbumById(Id);
	}
	@Override
	public Album saveAlbum(Album album) {
		// TODO Auto-generated method stub
		ActionContext ctx = ActionContext.getContext();
		Users currentUser = (Users) ctx.getSession().get("user");
		album.setFamilyId(currentUser.getUserinfo().getFamilyId());
		album.setUserinfoId(currentUser.getUserinfo().getUsersId());
		album.setCreateDate(new Date());
 		return albumDao.saveAlbum(album);
	}

 
	@Override
	public Album updateAlbum(int id,String name,String comment) {
		// TODO Auto-generated method stub
		Album updateAlbum=albumDao.loadAlbumById(id);
		updateAlbum.setName(name);
		updateAlbum.setComment(comment);
 		return albumDao.updateAlbum(updateAlbum);
	}
	

	@Override
	public void deleteAlbumById(int id) {
		// TODO Auto-generated method stub
		  picturesDao.deletePicturesByAlbumId(id);
		  albumDao.deleteAlbumById(id);
	}

 
	 
	 
}
