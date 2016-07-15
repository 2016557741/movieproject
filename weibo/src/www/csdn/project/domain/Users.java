package www.csdn.project.domain;

import java.io.Serializable;
import java.util.Date;
/**
 * 用户实体
 * @author chenwc 
 *
 */
public class Users implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String email;
	private String password;
 	private Date createDate;
	private Integer status;
	private Userinfo userinfo=new Userinfo();
	 
 	
	public Users() {
		super();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

 

	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public Userinfo getUserinfo() {
		return userinfo;
	}


	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	 
 
}
