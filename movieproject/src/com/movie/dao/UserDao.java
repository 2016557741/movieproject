package com.movie.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movie.model.User;


@Service @Transactional
public class UserDao {
	@Resource SessionFactory factory;
	
	 /*娣诲姞Customer淇℃伅*/
    public void AddUser(User user) throws Exception {
    	Session s = factory.getCurrentSession();
    	s.save(user);
    }
    
    /*鍒犻櫎Customer淇℃伅*/
    public void DeleteUser (Integer userId) throws Exception {
        Session s = factory.getCurrentSession(); 
        Object user = s.load(User.class,userId);
        s.delete(user);
    }
    
    /*鏇存柊Customer淇℃伅*/
    public void UpdateUser(User user) throws Exception {
        Session s = factory.getCurrentSession();
        s.update(user);
    }
    
    /*鏌ヨ鎵�湁Customer淇℃伅*/
    public ArrayList<User> QueryAllUser() {
        Session s = factory.getCurrentSession();
        String hql = "From User";
        Query q = s.createQuery(hql);
        List userList = q.list();
        return (ArrayList<User>) userList;
    }

    /*鏍规嵁涓婚敭鑾峰彇瀵硅薄*/
    public User GetUserById(Integer userid) {
        Session s = factory.getCurrentSession();
        User user = (User)s.get(User.class, userid);
        return user;
    }
    
    /*鏍规嵁鏌ヨ鏉′欢鏌ヨ*/
    public ArrayList<User> QueryUserInfo(String name) {
    	
    	Session s = factory.getCurrentSession();
    	List userList;
    	String hql = "From User user where 1=1";
    	if(!name.equals("")){ 
    		
    		hql = hql + " and user.name like '%" + name + "%'";
	    	Query q = s.createQuery(hql);
	    	userList = q.list();
	    	
    	}else{
    		
    		userList =null;	
    	
    	}
    	return (ArrayList<User>) userList;
    }

}

