package www.csdn.project.action;

import java.util.ArrayList;
import java.util.List;

import www.csdn.project.service.BaseService;
import www.csdn.project.utils.ComboBoxBean;
import www.csdn.project.utils.Pagination;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {
	// 封装jQuery easyui 中的rows和total
	protected Pagination pagination;
	// 封装jQuery easyui中当前页
	protected Integer page;
	// 封装jQuery easyui中排序字段和排序方式
	protected String sort;
	protected String order;

	// 封装每页显示的记录数
	protected Integer rows;

	// 操作信息标识是的字符串
	protected boolean flag;

	// 批量删除的ids
	protected String ids;
	protected List<ComboBoxBean> list = new ArrayList<ComboBoxBean>();

	// BaseService
	protected BaseService baseService;
	
	
	

	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}

	public List<ComboBoxBean> getList() {
		return list;
	}

	public void setList(List<ComboBoxBean> list) {
		this.list = list;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public boolean getFlag() {
		return flag;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

}
