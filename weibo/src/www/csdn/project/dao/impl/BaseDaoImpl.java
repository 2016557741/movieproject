package www.csdn.project.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import www.csdn.project.dao.BaseDao;

public class BaseDaoImpl extends HibernateDaoSupport implements BaseDao {

	/*
	 * private TransactionTemplate transactionTemplate;
	 * 
	 * public void setTransactionTemplate(TransactionTemplate
	 * transactionTemplate) { this.transactionTemplate = transactionTemplate; }
	 */

	@Override
	public Object getObjectById(Class clazz, Serializable id) {
		return getHibernateTemplate().get(clazz, id);
	}

	@Override
	public Object loadObjectById(Class clazz, Serializable id) {
		return getHibernateTemplate().load(clazz, id);
	}

	@Override
	public List getAllObjects(Class clazz) {
		return getHibernateTemplate().find("from " + clazz.getName());
	}

	@Override
	public Integer saveObject(Object entity) {
		/*
		 * transactionTemplate.execute(new TransactionCallback<Boolean>() {
		 * 
		 * @Override public Boolean doInTransaction(TransactionStatus status) {
		 * try{ getHibernateTemplate().save(entity); }catch(Exception e){
		 * status.rollbackToSavepoint(null); } return null; } });
		 */
		return (Integer)getHibernateTemplate().save(entity);
  	}

	@Override
	public boolean saveOrUpdateObject(Object entity) {
		boolean flag = false;
		try {
			getHibernateTemplate().saveOrUpdate(entity);
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	@Override
	public void mergeObject(Object entity) {

		getHibernateTemplate().merge(entity);

	}

	@Override
	public void deleteObject(Object entity) {

		getHibernateTemplate().delete(entity);

	}

	@Override
	public void deleteObjectById(Class clazz, Serializable id) {

		getHibernateTemplate().delete(getHibernateTemplate().get(clazz, id));

	}

	@Override
	public List getObjects(final Class clazz, final int from, final int size,
			final String order, final String sort) {

		return getHibernateTemplate().execute(new HibernateCallback<List>() {

			@Override
			public List doInHibernate(Session session)
					throws HibernateException, SQLException {
				return session.createQuery("from " + clazz.getName())
						.setFirstResult(from).setMaxResults(size).list();
			}
		});
	}

	@Override
	public List getObjects(final Class clazz, final String sql) {

		return getHibernateTemplate().execute(new HibernateCallback<List>() {

			@Override
			public List doInHibernate(Session session)
					throws HibernateException, SQLException {
				return session.createQuery(
						"from " + clazz.getName() + " " + sql).list();
			}
		});
	}

	@Override
	public List getObjects(final Class clazz, final String whereSql,
			final int from, final int size, final String order,
			final String sort) {

		return getHibernateTemplate().execute(new HibernateCallback<List>() {

			@Override
			public List doInHibernate(Session session)
					throws HibernateException, SQLException {
				List list = new ArrayList();
				list = session
						.createQuery(
								"from " + clazz.getName() + whereSql
										+ " order by " + sort + " " + order)
						.setFirstResult(from).setMaxResults(size).list();
				return list;
			}

		});
	}

	@Override
	public int getCount(final Class clazz, final String whereSql) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				return Integer.valueOf(session.createQuery(
						"select count(*) from " + clazz.getName() + whereSql)
						.uniqueResult()
						+ "");
			}
		});

	}

	@Override
	public int getCount(final String sql) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAllCount(final Class clazz) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteObjects(final Class clazz, final String whereSql) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().execute(new HibernateCallback<Boolean>() {

			@Override
			public Boolean doInHibernate(Session session)
					throws HibernateException, SQLException {

				session.createQuery(
						"delete from " + clazz.getName() + " where id in ("
								+ whereSql + ")").executeUpdate();
				return true;
			}

		});
	}

	@Override
	public boolean checkProperty(final Class clazz, final String property,
			final String value, final Integer id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().execute(new HibernateCallback<Boolean>() {

			@Override
			public Boolean doInHibernate(Session session)
					throws HibernateException, SQLException {
				try {
					Object obj = null;
					if (id != null) {
						obj = session.createCriteria(clazz)
								.add(Restrictions.eq(property, value))
								.add(Restrictions.ne("id", id)).uniqueResult();
					} else {
						obj = session.createCriteria(clazz)
								.add(Restrictions.eq(property, value))
								.uniqueResult();
					}
					if (obj != null) {
						return false;
					} else {
						return true;
					}
				} catch (Exception e) {
				}
				return false;
			}

		});

	}

	@Override
	public Object getObjectByProperty(final Class clazz, final String property,final String whereSql) {
		return getHibernateTemplate().execute(new HibernateCallback<Object>() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				return session.createCriteria(clazz.getName()).add(Restrictions.eq(property, whereSql)).uniqueResult();
			}
		});
	}

}
