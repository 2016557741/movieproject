package www.csdn.project.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import www.csdn.project.dao.UserinfoDao;
import www.csdn.project.domain.Userinfo;

public class UserinfoDaoImpl extends HibernateDaoSupport implements UserinfoDao{

	@Override
	public Userinfo findUserinfoById(int Id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Userinfo.class, Id);
	}

	@Override
	public Userinfo updateUserinfo(Userinfo userinfo) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(userinfo);
		return this.findUserinfoById(userinfo.getId());
	}
	@Override
	public Userinfo saveUserinfo(Userinfo userinfo) {
		// TODO Auto-generated method stub
		 int id=(Integer)getHibernateTemplate().save(userinfo);
		  return getHibernateTemplate().get(Userinfo.class, id);
	}

	@Override
	public List<Userinfo> findAncestryTree(final int familyId) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().execute(new HibernateCallback<List<Userinfo>>() {
 			public List<Userinfo> doInHibernate(Session session)
					throws HibernateException, SQLException {
				List<Userinfo> list = new ArrayList<Userinfo>();
				list = session
						.createQuery(
								"from Userinfo where familyId='"+familyId+"' and  parent_id is null order by level ").list();
				return list;
			}
		});
	}

	@Override
	public void deleteUserinfoById(int id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(getHibernateTemplate().get(Userinfo.class, id));
	}

	@Override
	public List<Userinfo> findAllByFamilyId(final int familyId) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().execute(new HibernateCallback<List<Userinfo>>() {
 			public List<Userinfo> doInHibernate(Session session)
					throws HibernateException, SQLException {
				List<Userinfo> list = new ArrayList<Userinfo>();
				list = session
						.createQuery(
								"from Userinfo where familyId="+familyId).list();
				return list;
			}
		});
	}


}
