package www.csdn.project.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 评论实体
 * @author  陈伟超
 * 
 */
public class Comments implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String info;
	private Date createDate;
	private Integer messagesId;
	private Integer userinfoId;
	public Comments() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Integer getMessagesId() {
		return messagesId;
	}
	public void setMessagesId(Integer messagesId) {
		this.messagesId = messagesId;
	}
	public Integer getUserinfoId() {
		return userinfoId;
	}
	public void setUserinfoId(Integer userinfoId) {
		this.userinfoId = userinfoId;
	}

 

}
