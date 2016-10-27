package zhou.mail;

import static org.junit.Assert.*;

import org.apache.commons.mail.EmailException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * author zhou
 * date 2016年10月27日 上午10:57:34
 * version 1.0
 */
public class MailTest {

	Mail mail;
	@Before
	public void setUp() throws Exception {
		mail = new Mail();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testHtmlMail() throws EmailException {		
		mail.sendHtmlEmail();
	}
	@Test
	public void testEmailWithAttachment() throws EmailException {		
		mail.sendEmailWithAttachment();	

	}
	@Test
	public void testMail() throws EmailException {
		mail.sendTextEmail();
	}

}
