package www.csdn.project.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import www.csdn.project.dao.AdminsDao;
import www.csdn.project.domain.Admins;

/**
 * 
 * @author 曹建波 2013-5-2 下午3:15:46
 * 
 */
public class AdminsDaoImpl extends HibernateDaoSupport implements AdminsDao {

	@Override
	public boolean login(final String name, final String pass) {
		boolean flag = false;
		Admins admins = getHibernateTemplate().execute(
				new HibernateCallback<Admins>() {

					@Override
					public Admins doInHibernate(Session session)
							throws HibernateException, SQLException {
						return (Admins) session.createCriteria(Admins.class)
								.add(Restrictions.eq("name", name))
								.add(Restrictions.eq("pass", pass))
								.uniqueResult();
					}
				});
		if (admins != null) {
			flag = true;
		}
		return flag;
	}

}
