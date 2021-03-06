package www.csdn.project.action;

import java.util.List;

import www.csdn.project.domain.Comments;
import www.csdn.project.domain.Messages;
import www.csdn.project.domain.Users;
import www.csdn.project.service.CommentsService;
import www.csdn.project.utils.ComboBoxBean;
import www.csdn.project.utils.Pagination;

public class CommentsAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CommentsService commentsService;
	private Comments comments;

	public Comments getComments() {
		return comments;
	}

	public void setComments(Comments comments) {
		this.comments = comments;
	}

	public void setCommentsService(CommentsService commentsService) {
		this.commentsService = commentsService;
	}

	public String query() {
		pagination = new Pagination(this.page, this.rows);
		String sql = spliceSql();
		pagination.setTotal(baseService.getCount(Comments.class, sql));
		pagination.setRows(baseService.getObjects(Comments.class, sql,
				pagination.getFrom(), pagination.getSize(), this.order,
				this.sort));
		return "query";
	}

	private String spliceSql() {

		String whereSql = " as tt where 1=1 ";
		if (comments != null) {
			// 内容
			String info = comments.getInfo();
			if (!"".equals(info) && (info != null)) {
				whereSql += " and  tt.info like '%" + info + "%'";
			}

			// 微博内容
			 

			// 用户邮箱
			 
		}
		return whereSql;
	}

	public String getAllUsers() {
		List<Users> lists = this.baseService.getAllObjects(Users.class);
		for (Users user : lists) {
			this.list
					.add(new ComboBoxBean(user.getId(), user.getEmail(), false));
		}
		return "queryall";
	}

	public String getAllMessages() {
		List<Messages> lists = this.baseService.getAllObjects(Messages.class);
		for (Messages messages : lists) {
			this.list.add(new ComboBoxBean(messages.getId(),
					messages.getInfo(), false));
		}
		return "queryall";
	}

	public String saveOrUpdateObject() {
	 
		this.flag = baseService.saveOrUpdateObject(comments);
		return "saveorupdate";
	}

	public String deleteObject() {
		this.flag = baseService.deleteObjects(Comments.class, ids);
		return "delete";
	}
}
