package www.csdn.project.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 消息信息实体
 * @author chenwc
 * 
 */
public class Messages implements Serializable {

 
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String info;
	private Date createDate;
	private Integer commentNum;
	private Integer agreeNum;
	private Integer status;
	private Integer userinfoId;
	
	public Messages() {
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

	public Integer getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(Integer commentNum) {
		this.commentNum = commentNum;
	}

	public Integer getAgreeNum() {
		return agreeNum;
	}

	public void setAgreeNum(Integer agreeNum) {
		this.agreeNum = agreeNum;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getUserinfoId() {
		return userinfoId;
	}

	public void setUserinfoId(Integer userinfoId) {
		this.userinfoId = userinfoId;
	}
 

}
