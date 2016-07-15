package www.csdn.project.utils;

import java.util.List;

public class Pagination{
	private final static Integer PAGE_SIZE = 10;// 每页显示的记录数
	// 结合jQuery easyUI 数据
	// 总记录
	private Integer total;
	// 显示的记录
	private List rows;

	private Integer from;
	private Integer size;

	private Integer nowpage;// 当前页
	private Integer pagesize;// 每页显示的记录数

	// 构造器
	public Pagination(Integer nowpage, Integer pagesize) {
		// 计算当前页
		if (nowpage < 0) {
			this.nowpage = 1;
		} else {
			// 当前页
			this.nowpage = nowpage;
		}
		// 计算每页显示的记录
		if (pagesize < 0) {
			this.pagesize = this.PAGE_SIZE;
		} else {
			this.pagesize = pagesize;
		}

		// 计算开始的记录和结束的记录
		this.from = (this.nowpage - 1) * this.pagesize;
		this.size = this.pagesize;

	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

	public Integer getFrom() {
		return from;
	}

	public void setFrom(Integer from) {
		this.from = from;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getNowpage() {
		return nowpage;
	}

	public void setNowpage(Integer nowpage) {
		this.nowpage = nowpage;
	}

}
