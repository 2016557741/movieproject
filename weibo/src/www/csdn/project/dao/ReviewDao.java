package www.csdn.project.dao;

import java.util.List;

import www.csdn.project.domain.Review;

public interface ReviewDao {

	/**
	 * 查找邀请记录 按照邀请时间降序排列
	 * 
	 * @return
	 */
	public List<Review> getReviewByUsersId(final int usersId);

	/**
	 * 保存邀请记录
	 * 
	 * @return
	 */
	public Review saveReview(Review review);

	/**
	 * 更新邀请记录
	 * 
	 * @return
	 */
	public Review updateReview(Review review);
	/**
	 * 获取是否已经邀请（受理 未接受 要排除  受理接受 ）
	 * 
	 * @return
	 */
 	public int getCount(Review review);
 	
 	public Review loadReviewById(int id);

}
