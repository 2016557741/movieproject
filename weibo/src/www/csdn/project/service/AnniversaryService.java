package www.csdn.project.service;

import java.util.List;

import www.csdn.project.domain.Anniversary;


public interface AnniversaryService {

    /**
     * 查找所有的纪念日通过家族ID
     * @return
     */
	public List<Anniversary> getAnniversarysByFamliyId(final Integer famliyId) ;
	 /**
     * 查找纪念日通ID
     * @return
     */
	public Anniversary findAnniversaryById(int Id) ;
	 /**
     * 删除纪念日通ID
     * @return
     */
	public void deleteAnniversaryById(int id) ;
	
}
