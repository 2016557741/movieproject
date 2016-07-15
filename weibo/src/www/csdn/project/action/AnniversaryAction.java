package www.csdn.project.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import www.csdn.project.domain.Anniversary;
import www.csdn.project.domain.Users;
import www.csdn.project.service.AnniversaryService;

public class AnniversaryAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 
	private AnniversaryService anniversaryService;
	public void setAnniversaryService(AnniversaryService anniversaryService) {
		this.anniversaryService = anniversaryService;
	}

   /**
    * 显示纪念日时间轴
    * @return
    */
	public String showTimeline() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Users users=(Users)request.getSession().getAttribute("user");
		Integer famliyId=users.getUserinfo().getFamilyId();
		List<Anniversary> anniversaryList=anniversaryService.getAnniversarysByFamliyId(famliyId);
 	    request.setAttribute("anniversaryList",anniversaryList);
 	   
 		return "showTimeline";
	}
	/**
	    * 创建纪念日
	    * @return
	    */
	public String createAnniversary()     {
		HttpServletRequest request = ServletActionContext.getRequest();
		String name=request.getParameter("name");
		String comment=request.getParameter("comment");
		String dateStr=request.getParameter("date");
		if(name==null||comment==null||dateStr==null){
			return "reflash";
		}
 		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
		    date=sf.parse(dateStr);
		} catch (Exception e) {
			new Exception("日期转换出错");
 		}
		Anniversary anniversary= new Anniversary();
		anniversary.setName(name);
		anniversary.setComment(comment);
		anniversary.setDate(date);
		Users users=(Users)request.getSession().getAttribute("user");
		anniversary.setFamilyId(users.getUserinfo().getFamilyId());
		anniversary.setUserinfoId(users.getUserinfo().getId());
 
		this.flag=baseService.saveOrUpdateObject(anniversary);
		flag=true;
		if (flag == false) {
			request.setAttribute("optionStatus", "faile");
			return "faile";			
		}
		request.setAttribute("optionStatus", "success");
		return "success";
 	}
	/**
	    * 修改纪念日
	    * @return
	    */
	public String modifyAnniversary()     {
		HttpServletRequest request = ServletActionContext.getRequest();
 		String idStr=request.getParameter("id");
		String name=request.getParameter("name");
		String comment=request.getParameter("comment");
		String dateStr=request.getParameter("date");
		if(idStr==null||name==null||comment==null||dateStr==null){
			return "reflash";
		}
		Integer id=Integer.valueOf(idStr);
 		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
		    date=sf.parse(dateStr);
		} catch (Exception e) {
			new Exception("日期转换出错");
 		}
		
		Anniversary anniversary=(Anniversary)baseService.getObjectById(Anniversary.class, id);
		anniversary.setName(name);
		anniversary.setComment(comment);
		anniversary.setDate(date);
		this.flag=baseService.saveOrUpdateObject(anniversary);
		flag=true;
		if (flag == false) {
			request.setAttribute("optionStatus", "faile");
			return "faile";			
		}
		request.setAttribute("optionStatus", "success");
		return "success";
 	}
	/**
	 * 删除
	 * @return
	 */
	public String removeAnniversary(){
		HttpServletRequest request = ServletActionContext.getRequest();
 		String idStr=request.getParameter("id");
 		if(idStr==null ){
			return "reflash";
		}
 		Integer id=Integer.valueOf(idStr);
 		try {
 		baseService.deleteObjectById(Anniversary.class, id);
 		} catch (Exception e) {
 			return "reflash";
 		}
	    request.setAttribute("optionStatus", "success");
		return "success";
 	}
}
