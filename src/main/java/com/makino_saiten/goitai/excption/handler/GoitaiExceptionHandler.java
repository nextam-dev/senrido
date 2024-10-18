/* ======================================
 * =======================
 * システム名：マキノ祭典　はなこシステム
 * ファイル名：ExceptionHandler.java
 * --------------------------------------------------------------
 * 2018(C) マキノ祭典. All Rights Reserved.
 */
package com.makino_saiten.goitai.excption.handler;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.makino_saiten.goitai.annotation.MessageName;
import com.makino_saiten.goitai.common.GoitaiConstant;
import com.makino_saiten.goitai.excption.AuthFailException;
import com.makino_saiten.goitai.excption.BusinessException;
import com.makino_saiten.goitai.excption.SystemException;
import com.makino_saiten.goitai.json.BaseResponse;
import com.makino_saiten.goitai.message.MessageInfo;
import com.makino_saiten.goitai.utils.StringUtil;

/**
 * 例外ハンドラクラス
 */
@RestControllerAdvice
@ControllerAdvice
public class GoitaiExceptionHandler {

	/** ログ */
	private static final Log log = LogFactory.getLog(GoitaiExceptionHandler.class);

	/**
	 * 業務例外を処理します。
	 * @param ex 例外情報
	 * @param request Webリクエスト情報
	 * @return レスポンス情報
	 */
	@ExceptionHandler(BusinessException.class)
	public BaseResponse handleBusinessException(BusinessException ex, WebRequest request) {
		BaseResponse res = new BaseResponse();
		res.setResultCd(GoitaiConstant.ResultCd.BUSSINESS_ERROR);
		res.setMessageList(ex.getMessageList());
		return res;
	}

	/**
	 * システム例外を処理します。
	 *
	 * @param ex 例外情報
	 * @param request Webリクエスト情報
	 * @return レスポンス情報
	 */
	@ExceptionHandler(SystemException.class)
	public BaseResponse handleSystemException(SystemException ex, WebRequest request) {
		// TODO システムエラー時のサーバ側処理

		log.fatal("システム例外が発生しました。handleSystemException", ex);
		BaseResponse res = new BaseResponse();
		res.setResultCd(GoitaiConstant.ResultCd.SYSTEM_ERROR);
		return res;
	}

	/**
	 * Validationチェックエラー例外を処理します。（JSONリクエストの場合）
	 *
	 * @param ex 例外情報
	 * @param request Webリクエスト情報
	 * @return レスポンス情報
	 * @throws Exception 例外情報
	 *
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected BaseResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) throws Exception {
		BaseResponse res = this.createBaseResponse(ex.getBindingResult().getFieldErrors(), ex.getBindingResult().getModel());
		return res;
	}

	/**
	 * Validationチェックエラー例外を処理します。
	 * @param ex 例外情報
	 * @param request Webリクエスト情報
	 * @return レスポンス情報
	 */
	@ExceptionHandler(BindException.class)
	protected BaseResponse handleBindException(BindException ex, WebRequest request) throws Exception {
		BaseResponse res = this.createBaseResponse(ex.getFieldErrors(), ex.getModel());
		return res;
	}

	/**
	 * 認証失敗例外を処理します。
	 *
	 * @param ex 例外情報
	 * @param request Webリクエスト情報
	 * @return レスポンス情報
	 */
	@ExceptionHandler(AuthFailException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public BaseResponse handleAuthFailException(AuthFailException ex, WebRequest request) {
		BaseResponse res = new BaseResponse();
		res.setResultCd(GoitaiConstant.ResultCd.BUSSINESS_ERROR);
		return res;
	}

	/**
	 * ValidationチェックエラーとなったフィールドのMessageNameアノテーションに指定した論理名を取得します。
	 *
	 * @param fieldError フィールドエラー
	 * @param model モデル
	 * @return MessageNameアノテーションに指定した論理名
	 * @throws Exception 例外情報
	 */
	private String searchName(FieldError fieldError, Map<String, Object> model) throws Exception {
		Object form = model.get(fieldError.getObjectName());
		if (null == form) {
			return "";
		}
		String fieldName = fieldError.getField();
		int lastPeriod = fieldName.lastIndexOf(".");
		if (-1 != lastPeriod) {
			String parent = fieldName.substring(0, lastPeriod);
			fieldName = fieldName.substring(lastPeriod + 1);
			try {
				form = PropertyUtils.getProperty(form, parent);
			} catch (Exception e) {
				return "";
			}
		}

		Field field = form.getClass().getDeclaredField(fieldName);
		if (null == field) {
			return "";
		}

		MessageName annotation = field.getAnnotation(MessageName.class);
		if (null == annotation) {
			return "";
		}
		String name = annotation.value();
		if (StringUtil.isBlank(name)) {
			return "";
		}
		return name;
	}

	/**
	 * レスポンス基盤インスタンスを生成します。 // TODO 基底レスポンスのような論理名に変更したいです。
	 *
	 * @param list フィールドエラーリスト
	 * @param model モデル
	 * @return レスポンス基盤インスタンス
	 * @throws Exception 例外情報
	 */
	private BaseResponse createBaseResponse(List<FieldError> list, Map<String, Object> model) throws Exception {
		List<MessageInfo> messageList = new ArrayList<>();
		for (FieldError fieldError : list) {
			log.debug("Validationチェックエラー " + fieldError.getField() + " " + fieldError.getDefaultMessage());

			MessageInfo info = new MessageInfo();
			messageList.add(info);
			info.setMessageType("E");

			String message = fieldError.getDefaultMessage();
			String name = this.searchName(fieldError, model);
			if (message.indexOf("{0}") != -1) {
				message = message.replaceFirst("[{]0[}]", name); // TODO サニタイズが必要でしょうか。
			}

			info.setMessageName(name); // TODO サニタイズが必要でしょうか。
			info.setMessage(message);
			info.setItemName(fieldError.getField());
			info.setErrorCd(fieldError.getCode());
			System.out.println("★★★　単項目チェックエラー：" + info); // TODO 開発が進んだら、除去します。
		}

		BaseResponse res = new BaseResponse();
		res.setResultCd(GoitaiConstant.ResultCd.BUSSINESS_ERROR);
		res.setMessageList(messageList);
		return res;
	}

	/**
	 * 上記以外の例外を処理します。
	 * @param t 例外情報
	 * @return レスポンス情報
	 */
	@ExceptionHandler(Throwable.class)
	public BaseResponse handleThrowable(Throwable t) {
		// TODO システムエラー時のサーバ側処理

		log.fatal("システム例外が発生しました。handleThrowable", t);
		BaseResponse res = new BaseResponse();
		res.setResultCd(GoitaiConstant.ResultCd.SYSTEM_ERROR);
		return res;
	}
}
