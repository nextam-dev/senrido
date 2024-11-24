/* =============================================================
 * システム名：
 * ファイル名：
 * --------------------------------------------------------------
 */
package jp.co.senrido.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.co.senrido.dto.CodeNameDto;
import jp.co.senrido.form.S008QuestionnaireForm;
import jp.co.senrido.json.CommonIO;
import jp.co.senrido.service.MCodeMasterService;

/**
 * リクエスト制御クラス
 *
 * @author hirose
 */
@RestController
@RequestMapping(value = "**/s008Questionnaire")
public class S008QuestionnaireRestController {

	@Autowired
	private MCodeMasterService mCodeMasterService;

	@Autowired
	private MessageSource msg;

	/**
	 * 検索条件初期化
	 *
	 * @return
	 */
	@RequestMapping(value = "/initStatus", method = RequestMethod.POST)
	public CommonIO initStatus(@RequestBody S008QuestionnaireForm form) throws Throwable {
		
		CommonIO io = new CommonIO();
		
		// お客様情報を取得
		
		// コードマスタから選択肢を取得
		// 性別
		List<CodeNameDto> sexItems = new ArrayList<CodeNameDto>();
		CodeNameDto codeNameDto = new CodeNameDto();
		codeNameDto.setCode("00001");
		codeNameDto.setName("男性");
		sexItems.add(codeNameDto);
		codeNameDto = new CodeNameDto();
		codeNameDto.setCode("00002");
		codeNameDto.setName("女性");
		sexItems.add(codeNameDto);
		codeNameDto = new CodeNameDto();
		codeNameDto.setCode("00003");
		codeNameDto.setName("回答しない");
		sexItems.add(codeNameDto);
		codeNameDto = new CodeNameDto();
		codeNameDto.setCode("00004");
		codeNameDto.setName("その他");
		sexItems.add(codeNameDto);
		io.setSexItems(sexItems);
		

		return io;
	}
	
	/**
	 * 登録処理.
	 *
	 * @return
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public CommonIO insert(@RequestBody S008QuestionnaireForm form) throws Throwable {
		
		CommonIO io = new CommonIO();
		

		return io;
	}
}