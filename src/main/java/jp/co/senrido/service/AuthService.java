/**
 *
 */
package jp.co.senrido.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.senrido.dao.MPasswordDao;
import jp.co.senrido.dao.MUserDao;
import jp.co.senrido.dto.UserDto;
import jp.co.senrido.encryption.Md5Encryption;
import jp.co.senrido.entity.MPassword;
import jp.co.senrido.entity.MUser;
import jp.co.senrido.utils.StringUtil;

/**
 * @author t_hirose
 *
 */
@Service
public class AuthService {

	@Autowired
	private MUserDao mUsreDao;
	
	@Autowired
	private MPasswordDao mPasswordDao;

	/** logger */
	private static final Log log = LogFactory.getLog(AuthService.class);

	public UserDto auth(String userCd, String password) {

		UserDto dto = new UserDto();
		try {
			if (StringUtil.isEmpty(userCd) || StringUtil.isEmpty(password)) {
				// 例外はSpringSecurityにあったものを適当に使用
				return null;
			}

			MUser user = mUsreDao.selectById(userCd);
			if (user == null) {
				// 例外はSpringSecurityにあったものを適当に使用
				return null;
			}
			if (password == null) {
				// 例外はSpringSecurityにあったものを適当に使用
				return null;
			}
			// パスワードをMD5に変換する
			password = Md5Encryption.digestMd5(password);
			// パスワード取得
			MPassword pass = mPasswordDao.selectById(userCd);
			if (!password.equals(pass.getPassword())) {
				// 例外はSpringSecurityにあったものを適当に使用
				return null;
			}

			dto.setUserCd(userCd);
			dto.setName(user.getName());
			dto.setKana(user.getKana());
			dto.setShopCd(user.getShopCd());

		} catch (Exception e) {
			log.error(e.toString());
			return null;
		}

		return dto;
	}
}
