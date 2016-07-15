package www.csdn.project.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import www.csdn.project.dao.PicturesDao;
import www.csdn.project.domain.Pictures;

public class PicturesDaoImpl extends HibernateDaoSupport implements PicturesDao{

	@Override
	public List<Pictures> getPicturesByAlbumId(final int albumId) {
 		return getHibernateTemplate().execute(new HibernateCallback<List<Pictures>>() {
 			public List<Pictures> doInHibernate(Session session)
					throws HibernateException, SQLException {
				List<Pictures> list = new ArrayList<Pictures>();
				list = session
						.createQuery(
								"from Pictures where albumId='"+albumId+"' order by createDate desc").list();
				return list;
			}

		});
	}

	@Override
	public void deletePicturesByAlbumId(int albumId) {
		// TODO Auto-generated method stub
		List<Pictures> pictureList=this.getPicturesByAlbumId(albumId);
		getHibernateTemplate().deleteAll(pictureList);
	}

	@Override
	public Pictures savePictures(Pictures pictures) {
		// TODO Auto-generated method stub
		  int id=(Integer)getHibernateTemplate().save(pictures);
		  return getHibernateTemplate().get(Pictures.class, id);
	}

}
