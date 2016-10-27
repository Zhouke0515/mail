package zhou.mail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

public class Mail {
	
	private String mailHostQQ = "smtp.qq.com";
	private int port = 465;
	private String usernameQQ = "252356262@qq.com";
	private String passwordQQ = "hblxjjdlvhlybgfb";//"vziczvyqspcjcaae";       //首先开启QQ邮箱POP3/SMTP,得到密码校验码


	private String mailHost163 = "smtp.163.com";
	private String username163 = "zhouke_coder@163.com";
	private String password163 = "zhouke0515";
	
	public void sendEmailWithAttachment() throws EmailException {
		
		//添加附件
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath("D://小九九//小九九.jpg");
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("Picture of xiaojiu");
		attachment.setName("xiao jiu.jpg");

		// Create the email message
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName(mailHostQQ);     //发送邮件的主机
		email.setSmtpPort(465);               //端口，默认是465
		email.setAuthenticator(new DefaultAuthenticator(usernameQQ, passwordQQ));         //用户名和密码
		email.setSSLOnConnect(true);          //
		email.addTo("zhouke0515@gmail.com", "xiaojiu");   //接收人
		email.setFrom("252356262@qq.com", "Me");
		email.setSubject("The picture");     //主题
		email.setMsg("Here is the picture you wanted");      //正文

		// add the attachment
		email.attach(attachment);

		// send the email
		email.send();
	}

	public void sendTextEmail() throws EmailException {
		Email email = new SimpleEmail();
		email.setHostName(mailHost163);
		email.setSmtpPort(port);
		email.setAuthenticator(new DefaultAuthenticator(username163, password163));
		email.setSSLOnConnect(true);
		email.setFrom(username163);
		email.setSubject("TestMail");
		email.setMsg("This is a test mail ... :-)");
		email.addTo(usernameQQ);
		email.send();
	}
	public void sendHtmlEmail() throws EmailException {
		HtmlEmail email = new HtmlEmail();
		email.setCharset("UTF-8");
		email.setHostName(mailHost163);
		email.setSmtpPort(port);
		email.setAuthenticator(new DefaultAuthenticator(username163, password163));
		email.setSSLOnConnect(true);
		email.setFrom(username163);
		email.setSubject("TestMail");
		email.setHtmlMsg(getMsg());
		email.setTextMsg("This is a test mail ... :-)");
		email.addTo(usernameQQ);
		email.send();
	}

	private String getMsg() {
		//"This is a test mail ... :-)"
		StringBuffer msg = new StringBuffer();
		msg.append("<html><body>");
		msg.append("<table border=1px>");
		msg.append("<tr>");
		msg.append("<th>零件号</th>");
		msg.append("<th>供应商</th>");
		msg.append("<th>中储</th>");
		msg.append("<th>需求量</th>");
		msg.append("<th>中储库存量</th>");
		msg.append("</tr>");
		msg.append("</table>");		
		msg.append("</body></html>");
		return msg.toString();
	}
}
