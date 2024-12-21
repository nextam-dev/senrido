/* =============================================================
 * システム名：
 * ファイル名：
 * --------------------------------------------------------------
 */
package jp.co.senrido.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.co.senrido.common.SenridoConstant;
import jp.co.senrido.dto.CodeNameDto;
import jp.co.senrido.dto.TCustomerSearchDto;
import jp.co.senrido.dto.UserDto;
import jp.co.senrido.form.S008QuestionnaireForm;
import jp.co.senrido.form.S005CustomerInformationSearchForm;
import jp.co.senrido.form.S006CustomerInformationSearchForm;
import jp.co.senrido.json.CommonIO;
import jp.co.senrido.service.MCodeMasterService;
import jp.co.senrido.service.S003PasswordReissueService;
import jp.co.senrido.service.S005CustomerInformationSearchService;
import jp.co.senrido.utils.ObjectUtil;

/**
 * リクエスト制御クラス
 *
 * @author kurokawa
 */
@RestController
@RequestMapping(value = "**/s005CustomerInformationSearch")
public class S005CustomerInformationSearchRestController {

	@Autowired
	private MCodeMasterService mCodeMasterService;

	@Autowired
	private S003PasswordReissueService s003changeReissueService;

	@Autowired
	private S005CustomerInformationSearchService s005CustomerInformationSearchService;

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
	 * 初期表示
	 *
	 * @return
	 */
	@RequestMapping(value = "/initData", method = RequestMethod.POST)
	public CommonIO initData() throws Throwable {
		CommonIO io = new CommonIO();
		// マスタ情報取得
		io.setShopNameList(mCodeMasterService.getMCode(SenridoConstant.DivCode.SHOP_CD));
		io.setSexList(mCodeMasterService.getMCode(SenridoConstant.DivCode.SEX));
		io.setPersonInChargeList(mCodeMasterService.getMCode(SenridoConstant.DivCode.PERSON_IN_CHARGE));

		return io;
	}

	/**
	 * 検索処理
	 *
	 * @return
	 */
	@RequestMapping(value = "/selectList", method = RequestMethod.POST)
	public CommonIO select(@RequestBody S005CustomerInformationSearchForm form) throws Throwable {

		CommonIO io = new CommonIO();

		// 検索処理
		List<TCustomerSearchDto> customerList = s005CustomerInformationSearchService.searchCustomerInfo(form.getCustomerSearchList());


		io.setTCustomer(customerList);
		return io;
	}

	/**
	 * ソート処理
	 *
	 * @return
	 */
	@RequestMapping(value = "/sort", method = RequestMethod.POST)
	public CommonIO sort(@RequestBody S006CustomerInformationSearchForm form) throws Throwable {

		CommonIO io = new CommonIO();

		// 検索処理
		List<TCustomerSearchDto> customerList = s005CustomerInformationSearchService.sortCustomerInfo(form.getCustomerSearchList(),form.getConditions());


		io.setTCustomer(customerList);
		return io;
	}

}