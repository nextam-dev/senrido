/**
 *
 */
package jp.nextam.senrido.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.nextam.senrido.dao.MEmployeeDao;
import jp.nextam.senrido.dto.UserDto;
import jp.nextam.senrido.entity.MEmployeeExt;
import jp.nextam.senrido.utils.StringUtil;

/**
 * @author t_hirose
 *
 */
@Service
public class AuthService {

	@Autowired
	private MEmployeeDao mEmployeeDao;

	/** logger */
	private static final Log log = LogFactory.getLog(AuthService.class);

	public UserDto auth(String employeeCode, String password) {

		UserDto dto = new UserDto();
		try {
			if (StringUtil.isEmpty(employeeCode) || StringUtil.isEmpty(password)) {
				// 例外はSpringSecurityにあったものを適当に使用
				return null;
			}

			MEmployeeExt emp = mEmployeeDao.selectByIdExt(employeeCode);
			if (emp == null) {
				// 例外はSpringSecurityにあったものを適当に使用
				return null;
			}
			if (password == null) {
				// 例外はSpringSecurityにあったものを適当に使用
				return null;
			}
			if (!password.equals(emp.getPassword())) {
				// 例外はSpringSecurityにあったものを適当に使用
				return null;
			}

			dto.setEmployeeCode(employeeCode);
			dto.setEmployeeName(emp.getEmployeeName());
			dto.setEmployeeKana(emp.getEmployeeKana());
			dto.setSecCode(emp.getSecCode());
			dto.setGroupCode(emp.getGroupCode());

		} catch (Exception e) {
			log.error(e.toString());
			return null;
		}

		return dto;
	}
}
