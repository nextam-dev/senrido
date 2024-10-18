package com.makino_saiten.goitai.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.makino_saiten.goitai.utils.StringUtil;

/**
 * メール送信クラス.
 * 
 * @author t_hirose
 *
 */
public class MailSender {
	
	private static final Log log = LogFactory.getLog(MailSender.class);

	@Autowired
	private JavaMailSender javaMailSender;

	/**
	 * メール送信処理.
	 * 
	 * @param subject
	 * @param body
	 * @param toAddrs
	 * @param fromAddr
	 * @param bccAddrs
	 * @return boolean
	 */
	public boolean send(String subject, String body, String[] toAddrs, String fromAddr, String[] bccAddrs) {
		try {
			MimeMessage msg = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(msg, true);

			// メール本文設定
			helper.setText(body);
			// メール件名設定
			helper.setSubject(subject);
			// 宛先設定
			for (String to : toAddrs) {
				helper.addTo(to);
			}
			// BCC設定
			for (String bcc : bccAddrs) {
				helper.addBcc(bcc);
			}
			// 送信先設定
			if (!StringUtil.isEmpty(fromAddr)) {
				helper.setFrom(fromAddr);
			}
			
			// メール送信
			javaMailSender.send(msg);
			
		} catch (MessagingException e) {
			log.error("Mail Send Error.", e);
			return false;
		}
		return true;
	}
}
