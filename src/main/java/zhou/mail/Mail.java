package zhou.mail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

public class Mail {
	
	private String mailHost = "smtp.qq.com";
	private int port = 465;
	private String username = "252356262@qq.com";
	private String password = "rrnekferszrgcbdi";       //首先开启QQ邮箱POP3/SMTP,得到密码校验码
	
	public void sendEmailWithAttachment() throws EmailException {
		
		//添加附件
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath("D://小九九//小九九.jpg");
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("Picture of xiaojiu");
		attachment.setName("xiao jiu.jpg");

		// Create the email message
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName(mailHost);     //发送邮件的主机
		email.setSmtpPort(465);               //端口，默认是465
		email.setAuthenticator(new DefaultAuthenticator(username, password));         //用户名和密码
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
		email.setHostName(mailHost);
		email.setSmtpPort(port);
		email.setAuthenticator(new DefaultAuthenticator(username, password));
		email.setSSLOnConnect(true);
		email.setFrom("252356262@qq.com");
		email.setSubject("TestMail");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("zhouke0515@gmail.com");
		email.send();
	}
}
