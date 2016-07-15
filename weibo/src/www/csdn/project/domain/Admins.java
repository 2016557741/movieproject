package www.csdn.project.domain;

import java.io.Serializable;

/**
 * 管理员实体
 * @author chenwc
 *
 */
public class Admins implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String pass;
 
	public Admins() {
		super();
	}
	
	public Admins(Integer id, String name, String pass, String type) {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
	 
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
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
 
	
}
