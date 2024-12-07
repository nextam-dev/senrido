/* =============================================================
 * システム名：
 * ファイル名：
 * --------------------------------------------------------------
 */
package jp.co.senrido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.co.senrido.dto.UserDto;
import jp.co.senrido.form.S002PasswordChangeForm;
import jp.co.senrido.service.MCodeMasterService;
import jp.co.senrido.service.S002PasswordChangeService;

/**
 * リクエスト制御クラス
 *
 * @author kurokawa
 */
@RestController
@RequestMapping(value = "**/s002PasswordChange")
public class S002PasswordChangeRestController {

	@Autowired
	private MCodeMasterService mCodeMasterService;

	@Autowired
	private S002PasswordChangeService s002PasswordChangeService;

	@Autowired
	private MessageSource msg;

	/**
	 * 検索条件初期化
	 *
	 * @return
	 */
	@RequestMapping(value = "/initStatus", method = RequestMethod.POST)
	public UserDto initStatus() throws Throwable {

		// ログイン社員取得
		UserDto userDto = (UserDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		return userDto;
	}
	
	/**
	 * パスワード変更
	 *
	 * @return
	 */
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public String reissuePassword(@RequestBody S002PasswordChangeForm form) throws Throwable {

		// パスワード再発行処理
		String ret = s002PasswordChangeService.changePassword(form.getPassword());

		return ret;
	}

}