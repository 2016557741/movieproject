package www.csdn.project.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class ShowMessages {
	private Integer nowpage;
	private Integer total;
	private List messages;
	private Integer from;
	private final Integer size = 10;
	private List headphotos;
	private List agreeMessages;
	private Integer fansNum;
	private Integer attentionsNum;
	private Integer myMessagesNum;
	private Date lastMessages;
	private Date nowtime = new Date();

	
	public Date getNowtime() {
		return nowtime;
	}

	public Date getLastMessages() {
		return lastMessages;
	}

	public void setLastMessages(Date lastMessages) {
		this.lastMessages = lastMessages;
	}

	public Integer getFansNum() {
		return fansNum;
	}

	public void setFansNum(Integer fansNum) {
		this.fansNum = fansNum;
	}

	public Integer getAttentionsNum() {
		return attentionsNum;
	}

	public void setAttentionsNum(Integer attentionsNum) {
		this.attentionsNum = attentionsNum;
	}

	public Integer getMyMessagesNum() {
		return myMessagesNum;
	}

	public void setMyMessagesNum(Integer myMessagesNum) {
		this.myMessagesNum = myMessagesNum;
	}

	public List getAgreeMessages() {
		return agreeMessages;
	}

	public void setAgreeMessages(List agreeMessages) {
		this.agreeMessages = agreeMessages;
	}

	public List getHeadphotos() {
		return headphotos;
	}

	public void setHeadphotos(List headphotos) {
		this.headphotos = headphotos;
	}

	public Integer getSize() {
		return size;
	}
	
	public Integer getFrom() {		
		return (nowpage-1)*size;
	}

	public List getMessages() {
		return messages;
	}
	public void setMessages(List messages) {
		this.messages = messages;
	}
	public Integer getNowpage() {
		return nowpage;
	}
	public void setNowpage(Integer nowpage) {
		this.nowpage = nowpage;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
}
