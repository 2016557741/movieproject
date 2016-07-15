package www.csdn.project.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author chenwc
 * 
 */
public class Pictures implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String url;
	private Integer type;
	private String comment;
	private Date createDate;
	private Integer userinfoId;
	private Integer messagesId;
	private Integer albumId;

	private Userinfo userinfo;

	public Pictures() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getUserinfoId() {
		return userinfoId;
	}

	public void setUserinfoId(Integer userinfoId) {
		this.userinfoId = userinfoId;
	}

	public Integer getMessagesId() {
		return messagesId;
	}

	public void setMessagesId(Integer messagesId) {
		this.messagesId = messagesId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getAlbumId() {
		return albumId;
	}

	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Userinfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}
	
	 
	

}
