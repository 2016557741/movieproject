package www.csdn.project.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 纪念日实体
 * @author chenwc
 *
 */
public class Anniversary implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String comment;
	private Date date;
	private Integer userinfoId;
	private Integer familyId;
	
	private Userinfo userinfo;
	
	public Anniversary() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getUserinfoId() {
		return userinfoId;
	}
	public void setUserinfoId(Integer userinfoId) {
		this.userinfoId = userinfoId;
	}
	public Integer getFamilyId() {
		return familyId;
	}
	public void setFamilyId(Integer familyId) {
		this.familyId = familyId;
	}
	public Userinfo getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}
	
	 
 
	
}
