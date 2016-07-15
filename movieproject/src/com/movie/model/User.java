package com.movie.model;

import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer useridid;
	private String name;
	private String password;
	private Set viewers = new HashSet(0);
	private Set viewers_1 = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}

	/** full constructor */
	public User(String name, String password, Set viewers, Set viewers_1) {
		this.name = name;
		this.password = password;
		this.viewers = viewers;
		this.viewers_1 = viewers_1;
	}

	// Property accessors

	public Integer getUseridid() {
		return this.useridid;
	}

	public void setUseridid(Integer useridid) {
		this.useridid = useridid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set getViewers() {
		return this.viewers;
	}

	public void setViewers(Set viewers) {
		this.viewers = viewers;
	}

	public Set getViewers_1() {
		return this.viewers_1;
	}

	public void setViewers_1(Set viewers_1) {
		this.viewers_1 = viewers_1;
	}

}