package www.csdn.project.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
/**
 * 族人实体
 * @author chenwc
 *
 */
public class Userinfo implements Serializable{
 
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String trueName;
 	private Integer sex;
 	private Date birthday;
	private Date dieday;
	private String work;
	private Integer active;
	private String comment;
	private Integer usersId;
	private Integer familyId;
	private Integer parentId;
	private Integer spouseId;
	private Integer level;
	
	private Users users;
	private Family family;
	private Userinfo parentInfo;
	private Userinfo spouseInfo;
    private Set<Userinfo> childrens =  new  HashSet<Userinfo>();     
	
	private String headPic;
    
	public Userinfo() {
		super();
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getTrueName() {
		return trueName;
	}



	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}



	public Integer getSex() {
		return sex;
	}



	public void setSex(Integer sex) {
		this.sex = sex;
	}



 

	public Date getBirthday() {
		return birthday;
	}



	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}



	public Date getDieday() {
		return dieday;
	}



	public void setDieday(Date dieday) {
		this.dieday = dieday;
	}



	public String getWork() {
		return work;
	}



	public void setWork(String work) {
		this.work = work;
	}



	public String getComment() {
		return comment;
	}



	public void setComment(String comment) {
		this.comment = comment;
	}



	public Integer getActive() {
		return active;
	}



	public void setActive(Integer active) {
		this.active = active;
	}



	public Integer getUsersId() {
		return usersId;
	}



	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}



	public Integer getFamilyId() {
		return familyId;
	}



	public void setFamilyId(Integer familyId) {
		this.familyId = familyId;
	}



	public Integer getParentId() {
		return parentId;
	}



	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}



	public Integer getSpouseId() {
		return spouseId;
	}



	public void setSpouseId(Integer spouseId) {
		this.spouseId = spouseId;
	}



	public Integer getLevel() {
		return level;
	}



	public void setLevel(Integer level) {
		this.level = level;
	}



	public Users getUsers() {
		return users;
	}



	public void setUsers(Users users) {
		this.users = users;
	}



	public Family getFamily() {
		return family;
	}



	public void setFamily(Family family) {
		this.family = family;
	}



	public Userinfo getParentInfo() {
		return parentInfo;
	}



	public void setParentInfo(Userinfo parentInfo) {
		this.parentInfo = parentInfo;
	}



	public Userinfo getSpouseInfo() {
		return spouseInfo;
	}



	public void setSpouseInfo(Userinfo spouseInfo) {
		this.spouseInfo = spouseInfo;
	}



	public Set<Userinfo> getChildrens() {
		return childrens;
	}



	public void setChildrens(Set<Userinfo> childrens) {
		this.childrens = childrens;
	}



	public String getHeadPic() {
		return headPic;
	}



	public void setHeadPic(String headPic) {
		this.headPic = headPic;
	}


 
	
 
	
}
