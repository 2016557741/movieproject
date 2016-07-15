package www.csdn.project.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import www.csdn.project.domain.Users;
import www.csdn.project.service.BaseService;

public class CollectionsTest {
	
	BaseService service;
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	@Test
	public void save(){
		service = context.getBean("baseServiceImpl",BaseService.class);
		for(int i=0;i<20;i++){
	 
		}
	}
	
	@Test
	public void getAll(){
	 
 	 
	}
	
	@Test
	public void update(){
		
		BaseService bs = context.getBean("baseServiceImpl",BaseService.class);
		Users user = (Users) bs.getObjectById(Users.class, 2);
 
		bs.saveOrUpdateObject(user);
	}
}
