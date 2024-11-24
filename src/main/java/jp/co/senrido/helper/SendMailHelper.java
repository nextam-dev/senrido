package jp.co.senrido.helper;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import lombok.val;

/**
 * メール送信ヘルパー
 */
@Component
public class SendMailHelper {

	private static final Log log = LogFactory.getLog(SendMailHelper.class);

	@Autowired
	JavaMailSender javaMailSender;

	/**
	 * メールを送信します。
	 * 
	 * @param fromAddress
	 * @param toAddress
	 * @param bccAddress
	 * @param subject
	 * @param body
	 */
	public void sendMail(String fromAddress, String[] toAddress, String[] bccAddress, String subject, String body) {
		val message = new SimpleMailMessage();
		message.setFrom(fromAddress);
		message.setTo(toAddress);
		message.setBcc(bccAddress);
		message.setSubject(subject);
		message.setText(body);

		try {
			javaMailSender.send(message);
			// TODO メールログを残すのであれば、ここで登録する
		} catch (MailException e) {
			log.error("failed to send mail.", e);
			// TODO メールログを残すのであれば、ここで登録する
			throw e;
		}
	}

	/**
	 * 指定したテンプレートのメール本文を返します。
	 *
	 * @param templatePath
	 * @param objects
	 * @return
	 */
	public String getMailBody(String templatePath, Map<String, Object> objects) {
		val engine = new SpringTemplateEngine();
		engine.setTemplateResolver(templateResolver());

		val context = new Context();
		context.setVariables(objects);

		return engine.process(templatePath, context);
	}

	protected ITemplateResolver templateResolver() {
		val resolver = new ClassLoaderTemplateResolver();
		resolver.setTemplateMode(TemplateMode.TEXT);
		resolver.setCharacterEncoding("UTF-8");
		resolver.setCacheable(false); // 安全をとってキャッシュしない
		return resolver;
	}
}
