package www.csdn.project.service.impl;

import www.csdn.project.dao.CommentsDao;
import www.csdn.project.service.CommentsService;

public class CommentsServiceImpl extends BaseServiceImpl implements CommentsService{
	private CommentsDao commentsDao;

	public void setCommentsDao(CommentsDao commentsDao) {
		this.commentsDao = commentsDao;
	}
	
}
