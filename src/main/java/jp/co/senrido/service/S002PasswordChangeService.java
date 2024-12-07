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
import jp.co.senrido.dto.UserDto;
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
public class S002PasswordChangeService extends BaseTransactionalService {

	@Autowired
	private SendMailHelper mailHelper;

	@Autowired
	private MUserDao mUserDao;

	@Autowired
	private MPasswordDao mPasswordDao;

    /**
     * パスワード変更
     * @param
     * @throws Throwable
     */
	public String changePassword(String password) throws Throwable {

		String ret = null;

		// ユーザ情報取得
		UserDto userDto = createUserDto();

		// パスワード更新
		MPassword entity = mPasswordDao.selectById(userDto.getUserCd());
		entity.setPassword(Md5Encryption.digestMd5(password));
		entity.setUpdateDate(this.createCurrentDate());
		entity.setUserCd(userDto.getUserCd());
		mPasswordDao.update(entity);

		return ret;
	}
}
