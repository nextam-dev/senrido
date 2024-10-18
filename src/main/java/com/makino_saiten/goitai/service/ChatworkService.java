/* =============================================================
 * システム名：武蔵野マイページシステム
 * ファイル名：ChatworkService.java
 * --------------------------------------------------------------
 */
package com.makino_saiten.goitai.service;

import java.io.File;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.makino_saiten.goitai.http.ChatworkRequest;
import com.makino_saiten.goitai.http.dto.ChatworkInfo;

/**
 * チャットワーク関連サービス.
 *
 * @author t_hirose
 * @version 2019/03/18
 *
 *
 */
@Service

public class ChatworkService {

	//@Autowired
	//private MChatworkNoticeExtDao mChatworkNoticeExtDao;

	private static final Log log = LogFactory.getLog(ChatworkService.class);

	/**
	 * チャットワーク回覧処理
	 *
	 * @param userId
	 * @param checkerList
	 * @param body
	 * @return
	 * @throws Throwable
	 */
	//public boolean messageCircular(BigDecimal userId,  String body) throws Throwable {
	public boolean sendMessage(String apiToken,String roomId,String massage) throws Throwable {
		ChatworkRequest<ChatworkInfo> chatWorkRequest = new ChatworkRequest<ChatworkInfo>(ChatworkInfo.class);
		// チャットワークにメッセージを送信する
		try {
			chatWorkRequest.postMessages(apiToken, roomId, massage);
		} catch (Throwable e) {
			log.error("Failed to send chatwork.");
		}
		return true;
	}

	/**
	 * チャットワーク回覧処理
	 *
	 * @param userId
	 * @param checkerList
	 * @param body
	 * @return
	 * @throws Throwable
	 */
	// public boolean messageCircular(BigDecimal userId, String body) throws Throwable {
	public boolean messageSendFile(String apiToken, String roomId, File file, String massage) throws Throwable {

		ChatworkRequest<ChatworkInfo> chatWorkRequest = new ChatworkRequest<ChatworkInfo>(ChatworkInfo.class);

		// チャットワークにメッセージを送信する
		try {
			chatWorkRequest.postFiles(apiToken, roomId, file, massage);
		} catch (Throwable e) {
			log.error("Failed to send chatwork.");
		}
		return true;
	}
}
