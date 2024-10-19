/* =============================================================
 * システム名：
 * ファイル名：
 * --------------------------------------------------------------
 */
package jp.nextam.senrido.controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.nextam.senrido.dto.CodeNameDto;
import jp.nextam.senrido.dto.UserDto;
import jp.nextam.senrido.json.CommonIO;
import jp.nextam.senrido.service.MCodeMasterService;
import jp.nextam.senrido.service.S003changeReissueService;
import jp.nextam.senrido.utils.BeanUtils;
import jp.nextam.senrido.utils.ObjectUtil;

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
	private S003changeReissueService s003changeReissueService;

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

}