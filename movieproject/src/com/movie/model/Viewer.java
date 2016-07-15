package com.movie.model;

/**
 * Viewer entity. @author MyEclipse Persistence Tools
 */

public class Viewer implements java.io.Serializable {

	// Fields

	private Integer viewerid;
	private User user;
	private Movie movie;
	private Double total;

	// Constructors

	/** default constructor */
	public Viewer() {
	}

	/** minimal constructor */
	public Viewer(Movie movie) {
		this.movie = movie;
	}

	/** full constructor */
	public Viewer(User user, Movie movie, Double total) {
		this.user = user;
		this.movie = movie;
		this.total = total;
	}

	// Property accessors

	public Integer getViewerid() {
		return this.viewerid;
	}

	public void setViewerid(Integer viewerid) {
		this.viewerid = viewerid;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Movie getMovie() {
		return this.movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Double getTotal() {
		return this.total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

}