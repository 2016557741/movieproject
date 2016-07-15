package com.movie.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Movie entity. @author MyEclipse Persistence Tools
 */

public class Movie implements java.io.Serializable {

	// Fields

	private Integer movieid;
	private String moviename;
	private Set viewers = new HashSet(0);
	private Set viewers_1 = new HashSet(0);

	// Constructors

	/** default constructor */
	public Movie() {
	}

	/** full constructor */
	public Movie(String moviename, Set viewers, Set viewers_1) {
		this.moviename = moviename;
		this.viewers = viewers;
		this.viewers_1 = viewers_1;
	}

	// Property accessors

	public Integer getMovieid() {
		return this.movieid;
	}

	public void setMovieid(Integer movieid) {
		this.movieid = movieid;
	}

	public String getMoviename() {
		return this.moviename;
	}

	public void setMoviename(String moviename) {
		this.moviename = moviename;
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