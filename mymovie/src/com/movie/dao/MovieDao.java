package com.movie.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movie.model.Movie;


@Service @Transactional
public class MovieDao {
	@Resource SessionFactory factory;
	
	 /*添加movie信息*/
    public void AddMovie(Movie movie) throws Exception {
    	Session s = factory.getCurrentSession();
    	s.save(movie);
    }
    
    /*删除movie信息*/
    public void DeleteMovie (Integer movieId) throws Exception {
        Session s = factory.getCurrentSession(); 
        Object movie = s.load(Movie.class, movieId);
        s.delete(movie);
    }
    
    /*更新movie信息*/
    public void UpdateMovie(Movie movie) throws Exception {
        Session s = factory.getCurrentSession();
        s.update(movie);
    }
    
    /*查询所以movie信息*/
    public ArrayList<Movie> QueryAllMovie() {
        Session s = factory.getCurrentSession();
        String hql = "From Movie";
        Query q = s.createQuery(hql);
        List movieList = q.list();
        return (ArrayList<Movie>) movieList;
    }

    /*根据主键获取信息*/
    public Movie GetMovieById(Integer movieid) {
        Session s = factory.getCurrentSession();
        Movie movie = (Movie)s.get(Movie.class, movieid);
        return movie;
    }
    
    /*根据查询条件查询*/
    public ArrayList<Movie> QueryMovieInfo(String moviename) { 
    	Session s = factory.getCurrentSession();
    	String hql = "From Movie movie where 1=1";
    	if(!moviename.equals("")) hql = hql + " and movie.moviename like '%" + moviename + "%'";
    	Query q = s.createQuery(hql);
    	List movieList = q.list();
    	return (ArrayList<Movie>) movieList;
    }

}
