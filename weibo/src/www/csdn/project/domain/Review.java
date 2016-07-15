package www.csdn.project.domain;

import java.util.Date;

/**
 * 邀请实体
 * @author chenwc
 *
 */
public class Review {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer userinfoId;
	private Integer usersId;
	private Integer comeintoUserinfoId;
	private Integer status;//审核标志
	private Integer flag;//接受标志
	private Date createDate;
	
	private  Userinfo  userinfo;
	private  Userinfo comeintoUserinfo;
	
	public Review() {
		super();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getUserinfoId() {
		return userinfoId;
	}


	public void setUserinfoId(Integer userinfoId) {
		this.userinfoId = userinfoId;
	}


	public Integer getUsersId() {
		return usersId;
	}


	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}


	public Integer getComeintoUserinfoId() {
		return comeintoUserinfoId;
	}


	public void setComeintoUserinfoId(Integer comeintoUserinfoId) {
		this.comeintoUserinfoId = comeintoUserinfoId;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public Integer getFlag() {
		return flag;
	}


	public void setFlag(Integer flag) {
		this.flag = flag;
	}


	public Userinfo getUserinfo() {
		return userinfo;
	}


	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}


	public Userinfo getComeintoUserinfo() {
		return comeintoUserinfo;
	}


	public void setComeintoUserinfo(Userinfo comeintoUserinfo) {
		this.comeintoUserinfo = comeintoUserinfo;
	}


 

}
