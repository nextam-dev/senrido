/* =============================================================
 * システム名：マキノ祭典　はなこシステム
 * ファイル名：BusinessException.java
 * --------------------------------------------------------------
 * 2018(C) マキノ祭典. All Rights Reserved.
 */
package com.makino_saiten.goitai.excption;

import java.util.ArrayList;
import java.util.List;

import com.makino_saiten.goitai.message.MessageInfo;

/**
 * 業務例外クラス
 */
public class BusinessException extends RuntimeException {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** メッセージ一覧 */
	private List<MessageInfo> messageList = new ArrayList<>();

	/**
	 * メッセージ情報を追加します。
	 * 
	 * @param info メッセージ情報
	 */
	public void addMessageInfo(MessageInfo info) {
		this.messageList.add(info);
	}

	/**
	 * エラーメッセージを追加します。
	 * 
	 * @param message メッセージ
	 */
	public void addErrorMessage(String message) {
		MessageInfo info = new MessageInfo();
		info.setMessageType("E");
		info.setMessage(message);
		this.messageList.add(info);
	}

	/**
	 * エラーメッセージを追加します。
	 * 
	 * @param message メッセージ
	 * @param itemName 項目名称
	 */
	public void addErrorMessage(String message, String itemName) {
		MessageInfo info = new MessageInfo();
		info.setMessageType("E");
		info.setMessage(message);
		info.setItemName(itemName);
		this.messageList.add(info);
	}

	/**
	 * エラーメッセージを追加します。
	 * 
	 * @param message メッセージ
	 * @param itemName 項目名称
	 * @param errorCd エラーコード
	 */
	public void addErrorMessage(String message, String itemName, String errorCd) {
		MessageInfo info = new MessageInfo();
		info.setMessageType("E");
		info.setMessage(message);
		info.setItemName(itemName);
		info.setErrorCd(errorCd);
		this.messageList.add(info);
	}

	/**
	 * 警告メッセージを追加します。
	 * 
	 * @param message メッセージ
	 */
	public void addWarningMessage(String message) {
		MessageInfo info = new MessageInfo();
		info.setMessageType("W");
		info.setMessage(message);
		this.messageList.add(info);
	}

	/**
	 * 警告メッセージを追加します。
	 * 
	 * @param message メッセージ
	 * @param itemName 項目名称
	 */
	public void addWarningMessage(String message, String itemName) {
		MessageInfo info = new MessageInfo();
		info.setMessageType("W");
		info.setMessage(message);
		info.setItemName(itemName);
		this.messageList.add(info);
	}

	/**
	 * 警告メッセージを追加します。
	 * 
	 * @param message メッセージ
	 * @param itemName 項目名称
	 * @param errorCd エラーコード
	 */
	public void addWarningMessage(String message, String itemName, String errorCd) {
		MessageInfo info = new MessageInfo();
		info.setMessageType("W");
		info.setMessage(message);
		info.setItemName(itemName);
		info.setErrorCd(errorCd);
		this.messageList.add(info);
	}

	/**
	 * 通常メッセージを追加します。
	 * 
	 * @param message メッセージ
	 */
	public void addInfomationMessage(String message) {
		MessageInfo info = new MessageInfo();
		info.setMessageType("I");
		info.setMessage(message);
		this.messageList.add(info);
	}

	/**
	 * 通常メッセージを追加します。
	 * 
	 * @param message メッセージ
	 * @param itemName 項目名称
	 */
	public void addInfomationMessage(String message, String itemName) {
		MessageInfo info = new MessageInfo();
		info.setMessageType("I");
		info.setMessage(message);
		info.setItemName(itemName);
		this.messageList.add(info);
	}

	/**
	 * 通常メッセージを追加します。
	 * 
	 * @param message メッセージ
	 * @param itemName 項目名称
	 * @param errorCd エラーコード
	 */
	public void addInfomationMessage(String message, String itemName, String errorCd) {
		MessageInfo info = new MessageInfo();
		info.setMessageType("I");
		info.setMessage(message);
		info.setItemName(itemName);
		info.setErrorCd(errorCd);
		this.messageList.add(info);
	}

	/**
	 * メッセージ一覧を取得します。
	 * 
	 * @return メッセージ一覧
	 */
	public List<MessageInfo> getMessageList() {
		return this.messageList;
	}


	/**
	 * メッセージ一覧を追加します。
	 * 
	 * @param list
	 */
	public void addList(List<MessageInfo> list) {
		for(MessageInfo messageInfo : list) {
			this.messageList.add(messageInfo);
		}
	}
}
