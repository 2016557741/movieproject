package www.csdn.project.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import www.csdn.project.dao.AffairDao;
import www.csdn.project.domain.Affair;

public class AffairDaoImpl extends HibernateDaoSupport implements AffairDao {

	@Override
	public List<Affair> findAffairsByCondition(String familyId,
			String comment, String trueName, String affairDateFrom,
			String affairDateTo) {
		// TODO Auto-generated method stub
		final StringBuilder sql=new StringBuilder();
		sql.append("where 1=1 ");
		if(familyId!=null&&!familyId.trim().equals("") ){
			sql.append("and familyId='"+familyId+"' ");
 		}
		if(comment!=null&&!comment.trim().equals("")){
			sql.append("and LOWER(comment) like  CONCAT('%',LOWER('"+comment.trim()+"'),'%') ");
 		}	
		if(trueName!=null&&!trueName.trim().equals("")){
			sql.append("and userinfo.trueName='"+trueName.trim()+"' ");
 		}	
		if(affairDateFrom!=null&&!affairDateFrom.trim().equals("")){
			sql.append("and  date>='"+affairDateFrom+"' ");
 		}
		if(affairDateTo!=null&&!affairDateTo.trim().equals("")){
			sql.append("and  date<='"+affairDateTo+"' ");
 		}
		return getHibernateTemplate().execute(new HibernateCallback<List<Affair>>() {

			@Override
			public List<Affair> doInHibernate(Session session)
					throws HibernateException, SQLException {
				return session.createQuery(
						"from " + Affair.class.getName() + " " + sql.toString()+" "+"order by date desc").list();
			}
		});
	}

	@Override
	public Affair saveAffair(Affair affair) {
		// TODO Auto-generated method stub
		  int id=(Integer)getHibernateTemplate().save(affair);
		  return getHibernateTemplate().get(Affair.class, id);
	}

	@Override
	public void deleteAffairById(int id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(getHibernateTemplate().get(Affair.class, id));
	}

}
