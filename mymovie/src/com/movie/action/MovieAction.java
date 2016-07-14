package com.movie.action;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.movie.dao.MovieDao;
import com.movie.model.Movie;
import com.opensymphony.xwork2.ActionSupport;

@Controller @Scope("prototype")
public class MovieAction extends ActionSupport{

   /*业务层对象*/
   @Resource MovieDao movieDAO;




private Movie movie;

public Movie getMovie() {
   return movie;
}

public void setMovie(Movie movie) {
  this.movie = movie;
}

private List<Movie> movieList;
	
	public List<Movie> getMovieList() {
		return movieList;
	}

public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}
    

public String addMovie() throws Exception{

    movieDAO.AddMovie(movie);
    return "message";
}


public String showMovie() {
  
   movieList = movieDAO.QueryAllMovie();
   return "show_view";
    }

  }