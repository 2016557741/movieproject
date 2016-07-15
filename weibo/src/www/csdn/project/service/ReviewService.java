package www.csdn.project.service;

import java.util.List;

import www.csdn.project.domain.Pictures;
import www.csdn.project.domain.Review;

/**
 * 
 * @author chenwc
 * 
 */
public interface ReviewService {
	/**
	 * 查找邀请记录 按照邀请时间降序排列
	 * 
	 * @return
	 */
	public List<Review> getReviewByUsersId();

	/**
	 * 保存邀请记录
	 * 
	 * @return
	 * @throws Exception 
	 */
	public Review saveReview(Review review) throws Exception;

	/**
	 * 更新邀请记录
	 * 
	 * @return
	 */
	public Review updateReview(int id,boolean flag);
}
