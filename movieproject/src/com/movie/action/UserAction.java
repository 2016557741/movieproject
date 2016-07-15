package com.movie.action;
import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;

import com.movie.dao.UserDao;
import com.movie.model.User;
import com.movie.model.User;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller @Scope("prototype")
public class UserAction extends ActionSupport implements SessionAware{
	
	private static final long serialVersionUID = 1L;

	/*业务层对象*/
    @Resource UserDao userDao;
    
    private User user;
    
    //这两个成员变量是用来做登录拦截的，记得添加setter和getter
    
	private Map<String,Object> session;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
		public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	
	
	private String errMessage;
	
	public String getErrMessage() {
		return errMessage;
	}

	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}
	
	/*
	public String reg() throws Exception{
		customerDao.AddCustomer(customer);
		session.put("curCustomer", customer);
		return "show_view";
		
	}*/
	
    //注册，并在session中加入用户名
	public String reg() throws Exception{
		UserDao userDao = null;
		userDao.AddUser(user);
		session.put("user", user);
		return "show_view";

	}
    
	/* 验证用户登录 */
/*	public String login() {
		Customer db_customer = (Customer)customerDao.QueryCustomerInfo(customer.getName()).get(0);
		if(db_customer == null) { 
			
			this.errMessage = " 账号不存在 ";
			System.out.print(this.errMessage);
			return INPUT;
			
		} else if( !db_customer.getPassword().equals(customer.getPassword())) {
			
			this.errMessage = " 密码不正确! ";
			System.out.print(this.errMessage);
			return INPUT;
			
		}else{
			return "show_view";
			
		}	

	}*/
	/* 验证用户登录 */
	public String login() {
		UserDao userDao = new UserDao();
		System.out.print(user.getName());
		ArrayList<User> listUser = userDao.QueryUserInfo(user.getName());
		if(listUser.size()==0) { 
			
			this.errMessage = " 账号不存在 ";
			System.out.print(this.errMessage);
			return "input";
			
		} 
		else{
			
		   User db_user = listUser.get(0);
			if(!db_user.getPassword().equals(user.getPassword())) {
			
				this.errMessage = " 密码不正确! ";
				System.out.print(this.errMessage);
				return "input";
			
		    }else{
			
				session.put("user", db_user);
				return "success";
		    }
		}
	}


}
