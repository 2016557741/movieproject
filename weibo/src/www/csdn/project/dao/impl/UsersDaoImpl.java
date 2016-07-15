package www.csdn.project.dao.impl;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import www.csdn.project.dao.UsersDao;
import www.csdn.project.domain.Users;

public class UsersDaoImpl extends HibernateDaoSupport implements UsersDao{

	@Override
	public Users login(final String email, final String passWord) {
		return getHibernateTemplate().execute(new HibernateCallback<Users>() {

			@Override
			public Users doInHibernate(Session session) throws HibernateException,
					SQLException {
				return  (Users) session.createCriteria(Users.class).add(Restrictions.eq("email", email)).add(Restrictions.eq("password", passWord)).uniqueResult();
			}
		});
	}
	
	
	public boolean checkPass(final Class clazz, final String property,
			final String value, final Integer id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().execute(new HibernateCallback<Boolean>() {

			@Override
			public Boolean doInHibernate(Session session)
					throws HibernateException, SQLException {
					Object obj = session.createCriteria(clazz)
								.add(Restrictions.eq(property, value))
								.add(Restrictions.eq("id", id)).uniqueResult();
					if(obj != null){
						return true;
					}
				return false;
			}

		});

	}
	
	public Users updateUsers(Users users){
		getHibernateTemplate().update(users);
		return  getHibernateTemplate().get(Users.class, users.getId());		
	}


	@Override
	public Users getUsersById(int id) {
		// TODO Auto-generated method stub
		Users users=getHibernateTemplate().get(Users.class, id);
		return users;
	}

}
