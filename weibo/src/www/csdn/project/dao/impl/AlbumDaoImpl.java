package www.csdn.project.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import www.csdn.project.dao.AlbumDao;
import www.csdn.project.domain.Album;

/**
 * 
 * @author chenwc
 * 
 */
public class AlbumDaoImpl extends HibernateDaoSupport implements AlbumDao {

	@Override
	public Album loadAlbumById(int Id) {
		// TODO Auto-generated method stub
		Album album=(Album)getHibernateTemplate().get(Album.class, Id);
		 return album;
	}

	@Override
	public Album saveAlbum(Album album) {
		// TODO Auto-generated method stub
		  int id=(Integer)getHibernateTemplate().save(album);
		  return getHibernateTemplate().get(Album.class, id);
	}

 
	@Override
	public Album updateAlbum(Album album) {
		// TODO Auto-generated method stub
		  getHibernateTemplate().update(album);
		  return this.loadAlbumById(album.getId());
	}
	
	@Override
	public void deleteAlbumById(int id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(getHibernateTemplate().get(Album.class, id));
	}

}
