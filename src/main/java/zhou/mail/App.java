package zhou.mail;

import org.apache.commons.mail.EmailException;

/**
 * 发送邮件示例
 *
 */
public class App {
	public static void main(String[] args) throws EmailException {
		Mail mail = new Mail();
		mail.sendTextEmail();
		mail.sendEmailWithAttachment();
	}


}
