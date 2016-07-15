package www.csdn.project.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import www.csdn.project.dao.AnniversaryDao;
import www.csdn.project.domain.Anniversary;

public class AnniversaryDaoImpl extends HibernateDaoSupport implements AnniversaryDao{

	@Override
	public List<Anniversary> getAnniversarysByFamliyId(final Integer famliyId) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().execute(new HibernateCallback<List<Anniversary>>() {
 			@Override
			public List<Anniversary> doInHibernate(Session session)
					throws HibernateException, SQLException {
				List<Anniversary> list = new ArrayList<Anniversary>();
				list = session
						.createQuery(
								"from Anniversary where familyId='"+famliyId.toString()+"' order by date desc").list();
				return list;
			}

		});
	}

	@Override
	public Anniversary findAnniversaryById(int Id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Anniversary.class, Id);
	}

	@Override
	public void  deleteAnniversaryById(int id) {
		// TODO Auto-generated method stub
 		getHibernateTemplate().delete(getHibernateTemplate().get(Anniversary.class, id));
 	}

	 
}
