package com.movie.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.movie.model.User;
import com.movie.dao.MovieDao;
import com.movie.dao.MovieDao;
import com.movie.model.*;
import com.opensymphony.xwork2.ActionSupport;

@Controller @Scope("prototype")
public class MovieAction extends ActionSupport{
	
	 /*ҵ������*/
    @Resource MovieDao movieDao;
    private Movie movie;
    private File moviePhoto;
	
	public void setMoviePhoto(File moviePhoto) {
		this.moviePhoto = moviePhoto;
	}
	private String moviePhotoFileName;
	public String getMoviePhotoFileName() {
		return moviePhotoFileName;
	}
	public void setMoviePhotoFileName(String moviePhotoFileName) {
		this.moviePhotoFileName = moviePhotoFileName;
	}

	private String moviePhotoContentType;
	    
	    
		public String getMoviePhotoContentType() {
		return moviePhotoContentType;
	}

	public void setMoviePhotoContentType(String moviePhotoContentType) {
		this.moviePhotoContentType = moviePhotoContentType;
	}


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
    private String keyWords;
	
	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}
    private User user;
	
	public User getUser() {
		return user;
	}

	public void setCustomer(User user) {
		this.user = user;
	}
	
	/*���movie*/
	public String addMovie() throws Exception{
		String path = ServletActionContext.getServletContext().getRealPath("/upload"); 
        /*����ͼƬ�ϴ�*/
        String moviePhotoFileName = ""; 
        Object moviePhoto;
   	 	if(moviePhoto!= null) {
   	 	InputStream is = new FileInputStream((String) moviePhoto);
   			String fileContentType = this.getMoviePhotoContentType();
   			System.out.println(fileContentType);
   			if(fileContentType.equals("image/jpeg")  || fileContentType.equals("image/pjpeg"))
   				moviePhotoFileName = UUID.randomUUID().toString() +  ".jpg";
   			else if(fileContentType.equals("image/gif"))
   				moviePhotoFileName = UUID.randomUUID().toString() +  ".gif";
   			else if(fileContentType.equals("image/png"))
   				moviePhotoFileName = UUID.randomUUID().toString() +  ".png";

   			File file = new File(path, moviePhotoFileName);
   			OutputStream os = new FileOutputStream(file);
   			byte[] b = new byte[1024];
   			int bs = 0;
   			while ((bs = is.read(b)) > 0) {
   				os.write(b, 0, bs);
   			}
   			is.close();
   			os.close();
   	 	}
        if(moviePhoto != null)
        	movie.setFilepath("upload/" + moviePhotoFileName);
        else
        	movie.setFilepath("upload/NoImage.jpg");
        
        movieDao.AddMovie(movie);
		return "message";
		
	}
	/*��ʾ����Movie*/
    public String showMovie() {
        
        movieList = movieDao.QueryAllMovie();
        return "show_view";
    }

    /*��ʾĳһMovie����ϸ��Ϣ*/
    public String showDetail() {
    	movie = movieDao.GetMovieById(movie.getMovieid());
        return "detail_view";
    }
    
    /*��ʾmovie���޸���*/
    public String showEdit() throws Exception {
    	movie = movieDao.GetMovieById(movie.getMovieid());
        return "edit_view";
    }

	/*ɾ��movie*/
	public String deleteMovie() throws Exception{
		movieDao.DeleteMovie(movie.getMovieid());
		return "delete_message";
	}
	/*�༭movie*/
	public String editMovie() throws Exception{
		movieDao.UpdateMovie(movie);
		return "edit_message";
	}
	/*��ѯMovie*/
	public String queryMovies()  throws Exception {
		movieList = movieDao.QueryMovieInfo(keyWords);
		return "show_view";
		}
}