/* =============================================================
 * システム名：マキノ祭典　はなこシステム
 * ファイル名：MCodeMasterService.java
 * --------------------------------------------------------------
 * 2018(C) マキノ祭典. All Rights Reserved.
 */
package jp.co.senrido.service;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.senrido.common.SenridoConstant;
import jp.co.senrido.common.SenridoResources;
import jp.co.senrido.dao.MPasswordDao;
import jp.co.senrido.dao.MUserDao;
import jp.co.senrido.encryption.Md5Encryption;
import jp.co.senrido.entity.MPassword;
import jp.co.senrido.entity.MUser;
import jp.co.senrido.helper.SendMailHelper;

/**
 * パスワード再発行サービスクラス.
 *
 * @author hirokawa
 *
 */
@Service
public class S003PasswordReissueService extends BaseTransactionalService {

	@Autowired
	private SendMailHelper mailHelper;
	
	@Autowired
	private MUserDao mUserDao;
	
	@Autowired
	private MPasswordDao mPasswordDao;
	
    private static final String CHAR_SET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";
    private static final int PASSWORD_LENGTH = 12; // パスワードの長さ
	
    /**
     * パスワード再発行メール送信
     * @param fromAddress
     * @throws Throwable
     */
	public String sendMail(String email) throws Throwable {

		String ret = null;
		
		String fromAddress = SenridoResources.getString(SenridoConstant.Application.PROPERTIES, SenridoConstant.Application.KEY_MAIL_FROM);
		String[] toAddress = {email};
		String subject = "【お客様情報管理システム】パスワード再発行のお知らせ";
		
		// ユーザー情報を取得
		// メールアドレスを条件に取得する
		MUser mUser = mUserDao.selectByEmail(email);
		if (mUser == null) {
			ret = "メールアドレスが登録されておりません。";
			return ret;
		}
		
		// 新規パスワード生成
		String newPassword = generateRandomPassword();
		
		// パスワード更新
		MPassword entity = mPasswordDao.selectById(mUser.getUserCd());
		entity.setPassword(Md5Encryption.digestMd5(newPassword));
		entity.setUpdateDate(this.createCurrentDate());
		entity.setUserCd(mUser.getUserCd());
		mPasswordDao.update(entity);

		Map<String, Object> mailBody = new HashMap<>();
		mailBody.put("name", mUser.getName());
		mailBody.put("password", newPassword);
		mailBody.put("url", SenridoResources.getString(SenridoConstant.Application.PROPERTIES, SenridoConstant.Application.KEY_URL));

		String body = mailHelper.getMailBody("/templates/mail/passwrod_change.txt", mailBody);

		mailHelper.sendMail(fromAddress, toAddress, null, subject, body);
		
		return ret;
	}
	
	/**
	 * パスワード生成処理.
	 * 
	 * @return　String
	 */
	private String generateRandomPassword() {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(PASSWORD_LENGTH);

        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            int randomIndex = random.nextInt(CHAR_SET.length());
            password.append(CHAR_SET.charAt(randomIndex));
        }

        return password.toString();
    }
}
