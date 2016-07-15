package www.csdn.project.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 纪念日实体
 * @author chenwc
 *
 */
public class Album implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String comment;
	private Integer familyId;
	private Integer userinfoId;
	private Date createDate;
	
	private Userinfo userinfo;
	
	public Album() {
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
	public Integer getFamilyId() {
		return familyId;
	}
	public void setFamilyId(Integer familyId) {
		this.familyId = familyId;
	}
	public Integer getUserinfoId() {
		return userinfoId;
	}
	public void setUserinfoId(Integer userinfoId) {
		this.userinfoId = userinfoId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Userinfo getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}
	
}
