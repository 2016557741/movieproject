package www.csdn.project.dao;

import java.util.List;

import www.csdn.project.domain.Userinfo;

public interface UserinfoDao {
	 /**
     * 查找用户信息ID
     * @return
     */
	public Userinfo findUserinfoById(int Id) ;
	
	 /**
     * 更新
     * @return
     */
	public Userinfo updateUserinfo(Userinfo userinfo);
	
	
	/**
	 * 保存
	 */
	public Userinfo saveUserinfo(Userinfo userinfo) ;
	 /**
     * 家族树查询
     * @return
     */
	public List<Userinfo> findAncestryTree(final int familyId);
	
	public void deleteUserinfoById(int id) ;
	
	
	public List<Userinfo> findAllByFamilyId(int id) ;
 }
