package com.movie.model;

/**
 * Order entity. @author MyEclipse Persistence Tools
 */

public class Order implements java.io.Serializable {

	// Fields

	private Integer orderid;
	private Movie movie;
	private User user;
	private Integer movienum;
	private Double total;

	// Constructors

	/** default constructor */
	public Order() {
	}

	/** minimal constructor */
	public Order(Movie movie) {
		this.movie = movie;
	}

	/** full constructor */
	public Order(Movie movie, User user, Integer movienum, Double total) {
		this.movie = movie;
		this.user = user;
		this.movienum = movienum;
		this.total = total;
	}

	// Property accessors

	public Integer getOrderid() {
		return this.orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public Movie getMovie() {
		return this.movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getMovienum() {
		return this.movienum;
	}

	public void setMovienum(Integer movienum) {
		this.movienum = movienum;
	}

	public Double getTotal() {
		return this.total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

}