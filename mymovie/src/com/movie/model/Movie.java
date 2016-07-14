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
	private Double uintprice;
	private Set orders = new HashSet(0);

	// Constructors

	/** default constructor */
	public Movie() {
	}

	/** full constructor */
	public Movie(String moviename, Double uintprice, Set orders) {
		this.moviename = moviename;
		this.uintprice = uintprice;
		this.orders = orders;
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

	public Double getUintprice() {
		return this.uintprice;
	}

	public void setUintprice(Double uintprice) {
		this.uintprice = uintprice;
	}

	public Set getOrders() {
		return this.orders;
	}

	public void setOrders(Set orders) {
		this.orders = orders;
	}

}