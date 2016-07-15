package www.csdn.project.service;

import java.util.Date;
import java.util.List;

import www.csdn.project.domain.Userinfo;

public interface UserinfoService {
	 /**
     * 查找用户信息ID
     * @return
     */
	public Userinfo findUserinfoById(int Id) ;
	
	/**
	 * dwr更新
	 */
	public Userinfo updateUserinfo(int id,String trueName,int sex,String work,Date birthday,String comment);
	
	 /**
     * 家族树查询
     * @return
     */
	public List<Userinfo> findAncestryTree();
	
	
	/**
	 * 更新
	 */
    public Userinfo updateUserinfo(Userinfo userinfo);
	
	
	/**
	 * 保存
	 */
	public Userinfo saveUserinfo(Userinfo userinfo) ;
	
	
 	
	
}
