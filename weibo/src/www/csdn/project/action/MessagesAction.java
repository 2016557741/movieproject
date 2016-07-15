package www.csdn.project.action;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.management.relation.Relation;

import www.csdn.project.domain.Comments;
import www.csdn.project.domain.Messages;
import www.csdn.project.domain.Pictures;
import www.csdn.project.domain.Users;
import www.csdn.project.service.MessagesService;
import www.csdn.project.utils.ComboBoxBean;
import www.csdn.project.utils.Pagination;
import www.csdn.project.utils.ShowComments;
import www.csdn.project.utils.ShowMessages;

import com.opensymphony.xwork2.ActionContext;

/**
 * MessagesAction  
 * 
 * @author chenwc
 * 
 */
public class MessagesAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Messages messages;
	private MessagesService messagesService;
	private ShowMessages showMessages;
	private Integer messagesNum;
	private String lastMessages;
	private ShowComments showComments;
	private Comments comments;

	
	public ShowComments getShowComments() {
		return showComments;
	}
	public void setComments(Comments comments) {
		this.comments = comments;
	}

	public void setShowComments(ShowComments showComments) {
		this.showComments = showComments;
	}

	public void setLastMessages(String lastMessages) {
		this.lastMessages = lastMessages;
	}

	public Integer getMessagesNum() {
		return messagesNum;
	}

	public ShowMessages getShowMessages() {
		return showMessages;
	}

	public void setShowMessages(ShowMessages showMessages) {
		this.showMessages = showMessages;
	}

	public void setMessagesService(MessagesService messagesService) {
		this.messagesService = messagesService;
	}

	public Messages getMessages() {
		return messages;
	}

	public void setMessages(Messages messages) {
		this.messages = messages;
	}

	public String query() {
		System.out.println(this.page + "------------------" + this.rows);
		pagination = new Pagination(this.page, this.rows);
		String whereSql = spliceSql();
		pagination.setTotal(baseService.getCount(Messages.class, whereSql));
		pagination.setRows(baseService.getObjects(Messages.class, whereSql,
				pagination.getFrom(), pagination.getSize(), this.order,
				this.sort));

		return "query";
	}

	private String spliceSql() {

		String whereSql = " as tt where 1=1 ";

		if (messages != null) {
			// 内容
			String info = messages.getInfo();
			if (!"".equals(info) && (info != null)) {
				whereSql += " and  tt.info like '%" + info + "%'";
			}
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

	public String saveOrUpdateObject() {
		if (messages.getId() == null) {
			messages.setAgreeNum(0);
 			messages.setCommentNum(0);
 		}
 
		return "saveorupdate";
	}

	public String updateAgreeNum() {
		Users user = (Users) ActionContext.getContext().getSession()
				.get("user");
		Collections collections = null;
		messages = (Messages) baseService.getObjectById(Messages.class,
				messages.getId());
		if (user != null && messages != null) {
			List agreelist = baseService.getObjects(Collections.class,
					" where messages=" + messages.getId() + " and users="
							+ user.getId());
			if (agreelist.size() > 0) {
				collections = (Collections) agreelist.get(0);
			}
			if (collections == null) {
				messages.setAgreeNum(messages.getAgreeNum() + 1);
			 
				this.flag = baseService.saveOrUpdateObject(collections);
			} else {
				 
				messages.setAgreeNum(messages.getAgreeNum() - 1);
				this.flag = baseService.saveOrUpdateObject(messages);
			}
		}
		return "saveorupdate";
	}

	public String updateComments() {
		messages = (Messages) baseService.getObjectById(Messages.class, messages.getId());
		Users user = (Users) ActionContext.getContext().getSession()
				.get("user");
		if(messages!=null&&comments!=null&&user!=null){
			messages.setCommentNum(messages.getCommentNum()+1);
			 
			this.flag = baseService.saveOrUpdateObject(comments);
		}
		
		return "saveorupdate";
	}

	public String deleteObject() {
		List piclist = baseService.getObjects(Pictures.class,
				" where messages in (" + ids + ")");
		 
		List collist = baseService.getObjects(Collections.class,
				" where messages in (" + ids + ")");
		List comlist = baseService.getObjects(Comments.class,
				" where messages in (" + ids + ")");
		String del_ids = "";
		if (comlist.size() > 0) {
			del_ids = "";
			for (Comments com : (List<Comments>) comlist) {
				del_ids += com.getId() + ",";
			}
			del_ids = del_ids.substring(0, del_ids.length() - 1);
			baseService.deleteObjects(Comments.class, del_ids);
		}
		if (piclist.size() > 0) {
			del_ids = "";
			for (Pictures p : (List<Pictures>) piclist) {
				del_ids += p.getId() + ",";
			}
			del_ids = del_ids.substring(0, del_ids.length() - 1);
			baseService.deleteObjects(Pictures.class, del_ids);
		}
		 
		 del_ids = del_ids.substring(0, del_ids.length() - 1);
 		if (collist.size() > 0) {
			del_ids = "";
			for (Collections col : (List<Collections>) collist) {
			 
			}
			del_ids = del_ids.substring(0, del_ids.length() - 1);
			baseService.deleteObjects(Collections.class, del_ids);
		}
		
		this.flag = baseService.deleteObjects(Messages.class, ids);
		return "delete";
	}

	public String queryMessages() {
		Users user = (Users) ActionContext.getContext().getSession()
				.get("user");
		if (user != null) {
			List relationlist = baseService.getObjects(Relation.class,
					" where tusers=" + user.getId());
			String byusers = "";
			for (Relation relation : (List<Relation>) relationlist) {
 			}
			byusers = "(" + byusers + user.getId() + ")";
			showMessages.setTotal(baseService.getCount(Messages.class,
					(" where users in " + byusers)));
			List nowshow = baseService.getObjects(Messages.class,
					(" where users in " + byusers), showMessages.getFrom(),
					showMessages.getSize(), "desc", "time");
			showMessages.setMessages(nowshow);
			showMessages.setHeadphotos(baseService.getObjects(Pictures.class,
					" where users in " + byusers + " and type='头像'"));

			String nowshowMessages = "";
			for (Messages m : (List<Messages>) nowshow) {
				nowshowMessages += m.getId() + ",";
			}
			if (nowshowMessages != "") {
				nowshowMessages = "("
						+ nowshowMessages.substring(0,
								nowshowMessages.length() - 1) + ")";
				showMessages.setAgreeMessages(baseService.getObjects(
						Collections.class, " where messages in "
								+ nowshowMessages
								+ " and status=2 and users in (" + user.getId()
								+ ")"));
			}
			showMessages.setAttentionsNum(baseService.getCount(Relation.class,
					" where tusers=" + user.getId()));
			showMessages.setFansNum(baseService.getCount(Relation.class,
					" where byusers=" + user.getId()));
			showMessages.setMyMessagesNum(baseService.getCount(Messages.class,
					" where users=" + user.getId()));
			List lms = baseService.getObjects(Messages.class,
					(" where users in " + byusers), 0, 1, "desc", "time");
			if (lms.size() > 0) {
				Messages lm = (Messages) lms.get(0);
 			}
		}
		return "queryMessages";
	}

	public String queryNewMessages() {
		Users user = (Users) ActionContext.getContext().getSession()
				.get("user");
		if (user != null) {
			List relationlist = baseService.getObjects(Relation.class,
					" where tusers=" + user.getId());
			String byusers = "";
			for (Relation relation : (List<Relation>) relationlist) {
 			}
			byusers = "(" + byusers + user.getId() + ")";
			if (lastMessages != "") {
				Integer last_m = baseService.getCount(Messages.class,
						" where users in " + byusers + " and time='"
								+ lastMessages+"'" );
				messagesNum = baseService.getCount(Messages.class,
						" where users in " + byusers + " and time>'"
								+ lastMessages+"'");
				if (last_m == 0) {
					messagesNum = messagesNum - 1;
				}
			} else {
				messagesNum = 0;
			}
		}
		return "queryNewMessages";
	}

	public String queryComments() {
		Users user = (Users) ActionContext.getContext().getSession()
				.get("user");
		showComments = new ShowComments();
		if (user != null && messages != null) {
			showComments.setTotal(baseService.getCount(Comments.class,
					(" where messages= " + messages.getId())));
			List commentshow = baseService.getObjects(Comments.class,
					(" where messages= " + messages.getId()),
					showComments.getFrom(), showComments.getSize(), "desc",
					"time");
			showComments.setComments(commentshow);
			String commentsusers = "";
			if (commentshow.size() > 0) {
				for (Comments comments : (List<Comments>) commentshow) {
 				}
			}
			if (commentsusers != "") {
				commentsusers = "("
						+ commentsusers
								.substring(0, commentsusers.length() - 1) + ")";
				showComments.setHeadphotos(baseService.getObjects(
						Pictures.class, " where users in " + commentsusers
								+ " and type='头像'"));
			}
		}

		return "queryComments";
	}
	
	public String deleteComments(){
		comments = (Comments) baseService.getObjectById(Comments.class,comments.getId());
		if(comments!=null){
 			this.flag = baseService.deleteObjects(Comments.class, "("+comments.getId()+")");
 		}		
		return "delete";
	}

	public String queryMyselfMessages() {

		return "myselfmessages";
	}

}
