package www.csdn.project.service;

import java.util.List;

import www.csdn.project.domain.Affair;


public interface AffairService {

	 /**
     * 查询事件活动通过查询条件（=家族id like备注  =turename >=affairDateFrom <=affairDateTo）
     * @return
     */
	public List<Affair> findAffairsByCondition(
	 String familyId,
	 String comment,
	 String trueName,
	 String affairDateFrom,
	 String affairDateTo
	) ;
	
	 /**
	  * 保存事件活动
	  * @return
	  */
	public Affair saveAffair(Affair affair);
	
	 /**
	  * 删除事件
	  * @return
	  */
	public void deleteAffairById(int id) ;
}
