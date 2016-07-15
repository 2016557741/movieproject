package www.csdn.project.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import www.csdn.project.domain.Affair;
import www.csdn.project.domain.Users;
import www.csdn.project.service.AffairService;

public class AffairAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 
	private AffairService affairService;

	public void setAffairService(AffairService affairService) {
		this.affairService = affairService;
	}
	 
	public String queryAffairList()  {
		HttpServletRequest request = ServletActionContext.getRequest();
		Users users=(Users)request.getSession().getAttribute("user");
 		String familyId=String.valueOf(users.getUserinfo().getFamilyId());
 		String comment=request.getParameter("comment");
 		String trueName=request.getParameter("trueName");
 		String affairDateFrom=request.getParameter("affairDateFrom");
 		String affairDateTo=request.getParameter("affairDateTo");
 		List<Affair> affairList=affairService.findAffairsByCondition(familyId, comment, trueName, affairDateFrom, affairDateTo);
 		Map<String,String> conditionMap=new HashMap<String,String>();
 		conditionMap.put("comment", comment);
 		conditionMap.put("trueName", trueName);
 		conditionMap.put("affairDateFrom", affairDateFrom);
 		conditionMap.put("affairDateTo", affairDateTo);
 		request.setAttribute("affairList", affairList);
 		request.setAttribute("conditionMap", conditionMap);
		return "showAffair";
	}
 
}
