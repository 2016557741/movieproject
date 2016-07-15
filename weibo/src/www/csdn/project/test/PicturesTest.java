package www.csdn.project.test;

import java.util.Date;
import java.util.UUID;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import www.csdn.project.domain.Pictures;
import www.csdn.project.service.BaseService;
import www.csdn.project.service.impl.BaseServiceImpl;

public class PicturesTest {

	@Test
	public void test(){
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		BaseService baseService=(BaseService) context.getBean("baseServiceImpl");
		for(int i=1;i<50;i++){
			Pictures pictures=new Pictures( );
			pictures.setId(Integer.valueOf(UUID.randomUUID().toString()));
			pictures.setUrl("./csdn////");
			pictures.setType(0);
			pictures.setCreateDate(new Date());
			pictures.setMessagesId(null);
			pictures.setUserinfoId(null);
			baseService.saveOrUpdateObject(pictures);
		}
		
		
		/*String whereSql = " where 1=1";
		Integer i=baseService.getCount(Pictures.class, whereSql);
		System.out.println(i);*/

	}
}
