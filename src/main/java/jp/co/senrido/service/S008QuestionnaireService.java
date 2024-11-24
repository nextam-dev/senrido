/**
 * 
 */
package jp.co.senrido.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.senrido.dto.TSurveyDto;
import jp.co.senrido.helper.SendMailHelper;

/**
 * @author takam
 *
 */
@Service
public class S008QuestionnaireService extends BaseTransactionalService {
	
	@Autowired
	private SendMailHelper mailHelper;
	
    /**
     * アンケート登録処理.
     * 
     * @param fromAddress
     * @throws Throwable
     */
	public void insertSurvey(TSurveyDto dto) throws Throwable {
		
		// お客様IDが設定されている場合、お客様情報を取得
		
		// お客様IDが設定されていない場合、お客様情報に基本情報を登録
		
		// アンケート情報を登録
		
		// アンケート結果を頭書き情報へ登録
		
		// アンケート登録後のメール送信
		
	}
}
