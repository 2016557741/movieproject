package www.csdn.project.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import www.csdn.project.dao.ReviewDao;
import www.csdn.project.dao.UserinfoDao;
import www.csdn.project.dao.UsersDao;
import www.csdn.project.domain.Review;
import www.csdn.project.domain.Userinfo;
import www.csdn.project.domain.Users;
import www.csdn.project.service.ReviewService;

import com.opensymphony.xwork2.ActionContext;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class ReviewServiceImpl extends BaseServiceImpl implements  ReviewService{
	private   ReviewDao  reviewDao;
	private UsersDao usersDao;
	private UserinfoDao userinfoDao;
	public void setReviewDao(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
	}
	

	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}


	public void setUserinfoDao(UserinfoDao userinfoDao) {
		this.userinfoDao = userinfoDao;
	}


	@Override
	public List<Review> getReviewByUsersId() {
 
		ActionContext ctx = ActionContext.getContext();
		Users currentUser = (Users) ctx.getSession().get("user");
 		return reviewDao.getReviewByUsersId(currentUser.getId());
	}

	@Override
	public Review saveReview(Review review) throws Exception {
 		ActionContext ctx = ActionContext.getContext();
		Users currentUser = (Users) ctx.getSession().get("user");
		review.setUserinfoId(currentUser.getUserinfo().getId());
		review.setStatus(0);
		review.setFlag(0);
		review.setCreateDate(new Date());
		
		Users users=usersDao.getUsersById(review.getUsersId());//会员信息
		if(users==null){
			throw new Exception("该用户不存在，请确认会员号");
		}
 		
		if(users.getUserinfo().getId().equals(review.getComeintoUserinfoId())){
			throw new Exception("该用户已经接受入住到此节点上");
		}
		if(users.getUserinfo().getFamilyId().equals(currentUser.getUserinfo().getFamilyId())){
			throw new Exception("该用户已经对应家族中的"+users.getUserinfo().getTrueName());
		}
 
		Userinfo comeintoUserinfo= userinfoDao.findUserinfoById(review.getComeintoUserinfoId());//节点信息
 		if(comeintoUserinfo.getUsersId()!=null){
			throw new Exception("该节点已经有其他对应的用户了");
		}
 		
  		if(!users.getUserinfo().getSex().equals(comeintoUserinfo.getSex())){
			throw new Exception("邀请的人性别与节点不符合");
		}
 		
		
		if(reviewDao.getCount(review)>0){
			throw new Exception("已经邀请该用户，请等待用户受理");
		}

		Review retReview=reviewDao.saveReview(review);
		return retReview;
	}

	@Override
	public Review updateReview(int id,boolean flag) {//true 接受 false 拒绝
		// TODO Auto-generated method stub
		Review review=reviewDao.loadReviewById(id);
		review.setStatus(1);
		if(flag){//接受
			review.setFlag(1);
 			Users users=usersDao.getUsersById(review.getUsersId());//会员信息
 			Userinfo userinfo=users.getUserinfo();//会员详细信息
 			//更新节点相关信息
 			Userinfo comeintoUserinfo=userinfoDao.findUserinfoById(review.getComeintoUserinfoId());//节点信息
 			Userinfo spouseInfo=comeintoUserinfo.getSpouseInfo();//节点伴侣
 			if(spouseInfo!=null){
 				spouseInfo.setSpouseId(userinfo.getId());
 				userinfoDao.updateUserinfo(spouseInfo);
 			}
		    Set<Userinfo>	childrens=comeintoUserinfo.getChildrens();//节点孩子信息
		    Iterator<Userinfo> it = childrens.iterator();  
		    while (it.hasNext()) {  
		    	Userinfo children = it.next();  
		    	children.setParentId(userinfo.getId());
		    	userinfoDao.updateUserinfo(children);
 		    }  
		    //防止背叛家庭 导致数据脏乱
		    int userFamilyId=userinfo.getFamilyId();
		    List<Userinfo> userinfoList=userinfoDao.findAllByFamilyId(userFamilyId);
		    boolean familyHasUserFlag=false;//被邀请人原来家族是否有注册的用户
		    for(Userinfo u:userinfoList){
		    	if(u.getUsersId()!=null&&!u.getUsersId().equals(userinfo.getUsersId())){
		    		familyHasUserFlag=true;
		    	}
		    }
		    if(familyHasUserFlag){//被邀请人原来家族是否有注册的用户
		    	Userinfo cloneBean=null;
		    	try {
					  cloneBean=(Userinfo)BeanUtils.cloneBean(userinfo);
				} catch (Exception e) {
					 System.out.println("复制用户信息出现异常");
				}  
				cloneBean.setTrueName("该成员已经跳槽");
				cloneBean.setId(null);
				cloneBean.setUsers(null);
				cloneBean.setFamily(null);
				cloneBean.setParentInfo(null);
				cloneBean.setSpouseInfo(null);
				cloneBean.setChildrens(null);
				Userinfo retCloneBean=userinfoDao.saveUserinfo(cloneBean);
				
				Userinfo userinfoSpouseInfo=userinfo.getSpouseInfo();//节点伴侣
	 			if(userinfoSpouseInfo!=null){
	 				userinfoSpouseInfo.setSpouseId(retCloneBean.getId());
	 				userinfoDao.updateUserinfo(userinfoSpouseInfo);
	 			}
			    Set<Userinfo>	userinfoChildrens=userinfo.getChildrens();//节点孩子信息
			    Iterator<Userinfo> it2 = userinfoChildrens.iterator();  
			    while (it2.hasNext()) {  
			    	Userinfo children = it2.next();  
			    	children.setParentId(retCloneBean.getId());
			    	userinfoDao.updateUserinfo(children);
	 		    }  
 		    }
            //邀请导致的脏数据 后期可以使用数据库定时触发删除数据避免此处 消耗服务器性能
		    
		    userinfo.setFamilyId(comeintoUserinfo.getFamilyId());
		    userinfo.setParentId(comeintoUserinfo.getParentId());
		    userinfo.setSpouseId(comeintoUserinfo.getSpouseId());
		    userinfo.setLevel(comeintoUserinfo.getLevel());
		    Userinfo  newUserinfo =userinfoDao.updateUserinfo(userinfo);
		    userinfoDao.deleteUserinfoById(comeintoUserinfo.getId());
			ActionContext ctx = ActionContext.getContext();//更新session
			Users sessionUser =(Users)ctx.getSession().get("user");
			sessionUser.setUserinfo(newUserinfo);
  			 Map<String, Object> sessionMap =new HashMap<String, Object>();
			 sessionMap.put("user", sessionUser);
		    ctx.setSession(sessionMap);
		    
		    
		    
 		}else if(!flag){// 拒绝
			review.setFlag(0);
		}
		Review retReview=reviewDao.updateReview(review);
		return retReview;
	}

	 

 
	 

	 
}
