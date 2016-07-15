package www.csdn.project.action;

import com.opensymphony.xwork2.ActionContext;

import www.csdn.project.domain.Admins;
import www.csdn.project.service.AdminsService;
import www.csdn.project.utils.Pagination;

/**
 * 
 * @author 侯子腾 2012-05-04 16:40
 * 
 */
public class AdminsAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AdminsService adminsService;
	private Admins admins;
	private String code;

	public void setCode(String code) {
		this.code = code;
	}

	public Admins getAdmins() {
		return admins;
	}

	public String checkName() {
	
		this.flag = baseService.checkProperty(Admins.class, "name",
				admins.getName(), admins.getId());
	
		return "check";
	}

	public void setAdmins(Admins admins) {
		this.admins = admins;
	}

	public void setAdminsService(AdminsService adminsService) {
		this.adminsService = adminsService;
	}

	public String login() {
		if (admins == null) {
			this.flag = false;
			return "logout";
		}
		boolean flg = adminsService.login(admins.getName(), admins.getPass());
		String randimg = (String) ActionContext.getContext().getSession()
				.get("randimg");
		if (!randimg.equals(code) && randimg != code) {
			this.flag = false;
			return "logout";
		}
		if (flg) {
			this.flag = true;
			ActionContext.getContext().getSession()
					.put("adminsname", admins.getName());
			return "login";
		} else {
			this.flag = false;
			return "logout";
		}
	}

	public String exit() {
		ActionContext.getContext().getSession().remove("adminsname");
		return "logout";
	}

	public String checkCode() {
		String randimg = (String) ActionContext.getContext().getSession()
				.get("randimg");
		if (!randimg.equals(code) && randimg != code) {
			this.flag = false;
		} else {
			this.flag = true;
		}
		return "check";
	}

	public String query() {

		pagination = new Pagination(this.page, this.rows);
		String sql = spliceSql();
		pagination.setTotal(baseService.getCount(Admins.class, sql));
		pagination.setRows(baseService.getObjects(Admins.class, sql,
				pagination.getFrom(), pagination.getSize(), this.order,
				this.sort));
		return "query";
	}

	private String spliceSql() {

		String whereSql = " where 1=1 ";
		if (admins != null) {
			// 序号
			Integer id = admins.getId();
			if (!"".equals(id) && (id != null)) {
				whereSql += " and  id = '" + id + "'";
			}
			// 用户名
			String name = admins.getName();
			if (!"".equals(name) && (name != null)) {
				whereSql += " and name like '%" + name + "%'";
			}

//			// 管理员类型
//			String type = admins.getType();
//			if (!"".equals(type) && (type != null)) {
//				whereSql += " and  type = '" + type + "'";
//			}
		}
		return whereSql;
	}

	public String saveOrUpdateObject() {
		this.flag = baseService.saveOrUpdateObject(admins);
		return "saveorupdate";
	}

	public String deleteObject() {
		this.flag = baseService.deleteObjects(Admins.class, ids);
		return "delete";
	}
}
