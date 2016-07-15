package www.csdn.project.utils;

public class SendMail {
	private String fromAddress;
	private String fromPassWord;
	private String toAddress;
	private String registerPass;
	private String subject;
	private String url;
	
	
	public SendMail(String fromAddress, String fromPassWord, String toAddress,
			String registerPass, String subject, String url) {
		super();
		this.fromAddress = fromAddress;
		this.fromPassWord = fromPassWord;
		this.toAddress = toAddress;
		this.registerPass = registerPass;
		this.subject = subject;
		this.url = url;
	}


	public void send(){
		 //这个类主要是设置邮件   
	     MailSenderInfo mailInfo = new MailSenderInfo();    
	     mailInfo.setMailServerHost("smtp.163.com");    
	     mailInfo.setMailServerPort("25");    
	     mailInfo.setValidate(true);    
	     mailInfo.setUserName(fromAddress);    
	     mailInfo.setPassword(fromPassWord);//您的邮箱密码    
	     mailInfo.setFromAddress(fromAddress);    
	     mailInfo.setToAddress(toAddress);    
	     mailInfo.setSubject(subject);    
	     mailInfo.setContent("<div style='margin-top: 20px;margin-bottom: 20px;display: block;margin-left:15%;'><table style='width: 800px;height: 350px;'><tr><td colspan='2' style='color: #6c6c6c;font-weight: bold;font-size: 18px;'>尊敬的"+toAddress+"您好：</td></tr><tr><td colspan='2' style='text-align: center;color:#005aa0;font-weight: bold;font-size: 20px;'>感谢您注册京东<br /><br />我们将为您提供最贴心的服务，祝您购物愉快！</td></tr><tr style='color: #6c6c6c;'><td><span style='font-size: 14px;'>您的注册邮箱：</span> <span style='font-weight: bold;font-size: 20px;color:#ce0a0c;'>"+toAddress+"</span></td><td><span style='font-size: 14px;'>您的注册密码：</span> <span style='font-weight: bold;font-size: 20px;color:#ce0a0c;'>"+registerPass+"</span></td></tr><tr><td colspan='2'><div style='border:1px;border-style:solid;border-color: #d9f4ee;background-color: #f1fcfa;width: 780px;height: 120px;line-height：120px;color:#005aa0;font-size: 15px;'><div style='display:block;margin-top: 6px;margin-left: 10px;'><span style='font-weight: bold;'>安全提示：</span><br>为了您的账户安全，我们建议您点击以下链接验证邮箱："+url+" <br>请在24小时内点击该链接，您也可以将链接复制到浏览器地址栏访问。</div></div></td></tr><tr><td colspan='2' style='color: #6c6c6c;font-size: 14px;'>邮件中包含您的个人信息，建议您保管好本邮件！ </td></tr></table></div>");    
	        //这个类主要来发送邮件   
	     SimpleMailSender sms = new SimpleMailSender();   
	     	//sms.sendTextMail(mailInfo);//发送文体格式    
	         sms.sendHtmlMail(mailInfo);//发送html格式   
	}
}
