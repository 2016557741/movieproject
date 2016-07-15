package www.csdn.project.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import www.csdn.project.domain.Admins;
import www.csdn.project.domain.Users;
import www.csdn.project.service.BaseService;
import www.csdn.project.service.UsersService;
import www.csdn.project.service.impl.UsersServiceImpl;

public class AdminsTest {

	@Test
	public void test(){
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		BaseService baseService=(BaseService) context.getBean("baseServiceImpl");
		Admins entity=new Admins(null,"root","root","高级管理员");
		baseService.saveObject(entity);
		
	}
	@Test
	public void test1(){
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		BaseService baseService=(BaseService) context.getBean("baseServiceImpl");
		Users newUsers=(Users) baseService.getObjects(Users.class, "where email='freekiteyu@qq.com' and passWord='aaaaaa'").get(0);
		//System.out.println(baseService.getObjectByProperty(Admins.class,"name","admin"));
		
	}
	@Test
	public void test2(){
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		UsersService usersService = context.getBean("usersServiceImpl",UsersService.class);
		usersService.login("aa","aaaaaa");	
	}
}
