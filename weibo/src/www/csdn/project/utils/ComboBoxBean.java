package www.csdn.project.utils;

import java.io.Serializable;

public class ComboBoxBean  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String text;
	private boolean selected;
	public ComboBoxBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ComboBoxBean(Integer id, String text, boolean selected) {
		super();
		this.id = id;
		this.text = text;
		this.selected = selected;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	
	
}
