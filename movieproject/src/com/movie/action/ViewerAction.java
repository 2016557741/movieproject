package com.movie.action;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.movie.dao.UserDao;
import com.movie.dao.MovieDao;
import com.movie.dao.ViewerDao;
import com.movie.model.*;
import com.opensymphony.xwork2.ActionSupport;

@Controller @Scope("prototype")
public class ViewerAction extends ActionSupport{
	
	 /*业务层对象*/
    @Resource ViewerDao orderDao;
    @Resource UserDao customerDao;
    @Resource MovieDao foodDao;
    
    private Viewer viewer;
    private List<Viewer> orderList;
    private User user;
    private Movie movie;
    private Object viewerList;
    
	public Viewer getViewer() {
		return viewer;
	}

	public void setOrder(Viewer viewer) {
		this.viewer = viewer;
	}
	
	public List<Viewer> getViewerList() {
		return getViewerList();
	}

	public void setViewerList(List<Viewer> orderList) {
		Object viewerList;
		Object viewerList = null;
		this.viewerList = viewerList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public movie getMovie() {
		return  movie;
	}

	public void setMovie(Movie  movie) {
		this. movie =  movie;
	}
	
	/*添加Order*/
	public String addViewer() throws Exception{
		

		user = customerDao.QueryUserInfo(user.getName()).get(0);
		Viewer ord =new Viewer();
		ord.setUser(user);
		ord.setMovie(movie);
		//因为是“来一份”，所以置为1
		ord.setMovienum(1);
		ord.setTotal(movieDao.GetMovieById(movie.getMovieid()).getUnitprice()*1);
		viewerDao.AddViewer(ord);
		return "order_message";
		
	}
	
	/*显示所有Order*/
    public String showOrder() {
    	
        //将系统设定为用户名不重复，因此在系统中查询到第一个该名称用户即可
    	System.out.println(user.getName());
        User cus= customerDao.QueryUserInfo(user.getName()).get(0);
        Object viewerDao;
        //注意不需要food的查询条件时，下面语句的写法，直接将food的条件置为null
        viewerList = ((Object) viewerDao).QueryViewerInfo(cus,null);

        return "show_view";
    }

    /*显示某一Order的详细信息*/
    public String showDetail() {
    	System.out.print(viewer.getViewerid());
    	viewer = ViewerDao.GetViewerById(viewer.getViewerid());
        return "detail_view";
    }
    
    /*显示Order的修改项*/
    /*public String showEdit() throws Exception {
    	order = orderDao.GetOrderById(order.getOrderid());
        return "edit_view";
    }*/

    /*编辑Order*/
    /*public String editOrder() throws Exception {
    	orderDao.UpdateOrder(order);
        return "edit_message";
    }*/
    
    /*删除Order*/
    /*public String deleteOrder() throws Exception {
    	orderDao.DeleteOrder(food.getFoodid());
        return "delete_message";
    }*/
    
    /*查询Order*/
    public String queryViewers() throws Exception {
    	viewerList = ViewerDao.QueryUserInfo(user, movie);
        return "show_view";
    }


}

