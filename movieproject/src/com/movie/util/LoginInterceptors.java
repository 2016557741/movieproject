package com.movie.util;


import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.movie.model.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.movie.model.User;
public class LoginInterceptors extends AbstractInterceptor{

	 
	   private static final long serialVersionUID = 1L;

	   private String sessionName; //�������ݵ�ǰ�û�����Ϣ

	   private String excludeName; //�����action��Ҳ���Ƿ��������action�Ͳ���Ҫ����


	   private List <String> list;

	   /*
	    * ��Ϊ�������ļ��Ĳ���excludeName�У������action���������ɸ����м��ö��ż����������ȡֵʱҪ��excludeName�ֽ�ɵ�����
	   һ����action�����֣�����һ��list�У�strlsit���������ֽ���Щaction������
	                 ���綺��ǰ���пո���ʹ��trim()����ȥ����Щ�ո�
	   */
	   public List<String>  strlsit(String str){

	     String[] s = str.split(",");

	     List <String> list = new ArrayList <String>();

	     for(String ss : s){

	        list.add(ss.trim());

	     }

	     return list;

	   }

	   @Override

	   public void init() {

	      list = strlsit(excludeName);

	   }

	   @Override

	   public String intercept(ActionInvocation invocation) throws Exception {

	     
		 System.out.println("--------����������--------");  //此语句可以用来验证是否能进入intercept方法
		 String actionName = invocation.getProxy().getActionName();   //得到跳转的action的名�?
		 Map <String,Object>  session = invocation.getInvocationContext().getSession();  //得到当前session

	     if(list.contains(actionName)){   //如果请求合法，也就是进登录或注册的action，则不拦�?
	        
	    	System.out.println(actionName + "û�б�����");
	        return invocation.invoke();     //就是通知struts2继续处理以后的事儿，也就是不加拦截器时该执行的那个action

	     }else {   //如果请求不合法，也就是需要被拦截

	        //查看session
	    	System.out.println(actionName + "��������");

	        
	        
	        //得到当前用户（当前用户在login方法中已经被放入session中，见CustomerAction中的login方法�?
	       User  user = ( User) session.get(sessionName);   
	        
	           if(user==null){   //如果customer不存在，就说明登录不成功，还转回login
	        	     // 获取HttpServletRequest对象  
	                 HttpServletRequest req = ServletActionContext.getRequest();  

	                 // 获取此请求的地址 ，也就是获取拦截前要跳转的地�?��进行跳转
	                 String path = req.getRequestURI().replaceAll("/movieproject", "");
	                 System.out.println("path:" + path);
	        
	                 // 存入session，这个参数在struts.xml中会作为参数出现  
	                 session.put("prePage", path);  
	        	     return "login";
	           }
	           else {                //如果customer存在，则登录成功
	        	
	                 return invocation.invoke();    //通知struts2跳转到action�?

	          }

	     }

	   }

	   public String getSessionName() {

	     return sessionName;

	   }

	   public void setSessionName(String sessionName) {

	     this.sessionName = sessionName;

	   }

	   public String getExcludeName() {

	     return excludeName;

	   }

	   public void setExcludeName(String excludeName) {

	     this.excludeName = excludeName;

	   }

	   public List<String> getList() {

	     return list;

	   }

	   public void setList(List<String> list) {

	     this.list = list;

	   }


	}
