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
	
	 /*ҵ������*/
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
	
	/*���Order*/
	public String addViewer() throws Exception{
		

		user = customerDao.QueryUserInfo(user.getName()).get(0);
		Viewer ord =new Viewer();
		ord.setUser(user);
		ord.setMovie(movie);
		//��Ϊ�ǡ���һ�ݡ���������Ϊ1
		ord.setMovienum(1);
		ord.setTotal(movieDao.GetMovieById(movie.getMovieid()).getUnitprice()*1);
		viewerDao.AddViewer(ord);
		return "order_message";
		
	}
	
	/*��ʾ����Order*/
    public String showOrder() {
    	
        //��ϵͳ�趨Ϊ�û������ظ��������ϵͳ�в�ѯ����һ���������û�����
    	System.out.println(user.getName());
        User cus= customerDao.QueryUserInfo(user.getName()).get(0);
        Object viewerDao;
        //ע�ⲻ��Ҫfood�Ĳ�ѯ����ʱ����������д����ֱ�ӽ�food��������Ϊnull
        viewerList = ((Object) viewerDao).QueryViewerInfo(cus,null);

        return "show_view";
    }

    /*��ʾĳһOrder����ϸ��Ϣ*/
    public String showDetail() {
    	System.out.print(viewer.getViewerid());
    	viewer = ViewerDao.GetViewerById(viewer.getViewerid());
        return "detail_view";
    }
    
    /*��ʾOrder���޸���*/
    /*public String showEdit() throws Exception {
    	order = orderDao.GetOrderById(order.getOrderid());
        return "edit_view";
    }*/

    /*�༭Order*/
    /*public String editOrder() throws Exception {
    	orderDao.UpdateOrder(order);
        return "edit_message";
    }*/
    
    /*ɾ��Order*/
    /*public String deleteOrder() throws Exception {
    	orderDao.DeleteOrder(food.getFoodid());
        return "delete_message";
    }*/
    
    /*��ѯOrder*/
    public String queryViewers() throws Exception {
    	viewerList = ViewerDao.QueryUserInfo(user, movie);
        return "show_view";
    }


}

