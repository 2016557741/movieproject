package www.csdn.project.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import www.csdn.project.dao.ReviewDao;
import www.csdn.project.domain.Affair;
import www.csdn.project.domain.Pictures;
import www.csdn.project.domain.Review;
import www.csdn.project.domain.Userinfo;
import www.csdn.project.domain.Users;

public class ReviewDaoImpl extends HibernateDaoSupport implements ReviewDao {

	@Override
	public List<Review> getReviewByUsersId(final int usersId) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().execute(new HibernateCallback<List<Review>>() {
 			public List<Review> doInHibernate(Session session)
					throws HibernateException, SQLException {
 				List<Review> list = new ArrayList<Review>();
				list = session
						.createQuery(
								"from Review where usersId='"+usersId+"'and status='0' order by createDate desc").list();
				return list;
			}

		});
	}

	@Override
	public Review saveReview(Review review) {
		// TODO Auto-generated method stub
		int id = (Integer) getHibernateTemplate().save(review);
		return getHibernateTemplate().get(Review.class, id);
	}

	@Override
	public Review updateReview(Review review) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(review);
		return getHibernateTemplate().get(Review.class, review.getId());
	}

	@Override
	public int getCount(final Review review) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				return Integer.valueOf(session.createQuery(
						"select count(*) from Review where userinfoId="+review.getUserinfoId()+" and usersId="+review.getUsersId()
						+  " and status=0")
						.uniqueResult()
						+ "");
			}
		});
  
	}

	@Override
	public Review loadReviewById(int id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Review.class, id);
	}

}
