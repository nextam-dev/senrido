/* =============================================================
 * システム名：チャットワークタスク管理システム
 * ファイル名：ChatworkRequest.java
 * --------------------------------------------------------------
 * 2016(C) nextam.,Inc. All Rights Reserved.
 */
package com.makino_saiten.goitai.http;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.makino_saiten.goitai.helper.HttpRequestHelper;

/**
 * チャットワークAPI利用クラス.
 *
 * @author t_koga
 *
 * @param <E>
 */
public class ChatworkRequest<E> extends HttpRequestHelper<E> {

	private final String DOMAIN = "api.chatwork.com";

	public final String VERSION = "/v2";

	public final String ME = VERSION + "/me";

	public final String MY_TASKS = VERSION + "/my/tasks";

	public final String ROOMS = VERSION + "/rooms";

	public final String TASKS = VERSION + "/rooms/{room_id}/tasks";

	public final String MESSAGE = VERSION + "/rooms/{room_id}/messages";

	public final String MEMBERS = VERSION + "/rooms/{room_id}/members";

	public final String FILES = VERSION + "/rooms/{room_id}/files";

	public final String CONTACTS = VERSION + "/contacts";

	/**
	 * コンストラクタ.
	 *
	 * @param clazz
	 */
	public ChatworkRequest(Class<E> clazz) {
		super(clazz);
	}

	/**
	 * 自身の情報を取得.
	 *
	 * @param address
	 * @return
	 * @throws Throwable
	 */
	public Map<String, String> getMyData(String appId) throws Throwable {
		return this.http("https", DOMAIN, ME).header("X-ChatWorkToken", appId).param("method", "GET").requestGet().getJsonMapSimple();
	}

//	/**
//	 * 自身のタスク情報を取得.
//	 *
//	 * @param address
//	 * @return
//	 * @throws Throwable
//	 */
//	public Task[] getMyTasks(String appId) throws Throwable {
//		String str = this.http("https", DOMAIN, MY_TASKS).header("X-ChatWorkToken", appId).param("method", "GET").requestGet().getString();
//
//		if (str == null) {
//			return null;
//		}
//
//		Task[] tasks = JSON.decode(str, Task[].class);
//		return tasks;
//	}

	/**
	 * 所属しているチャット一覧を取得.
	 *
	 * @param address
	 * @return
	 * @throws Throwable
	 */
	public List<Map<String, String>> getRoomesData(String appId) throws Throwable {
		return this.http("https", DOMAIN, ROOMS).header("X-ChatWorkToken", appId).param("method", "GET").requestGet().getJsonMapList();
	}

	/**
	 * タスク追加.
	 *
	 * @param address
	 * @return
	 * @throws Throwable
	 */
	public Map<String, String> postTasks(String appId, String roomId, String body, String limit, String toIds) throws Throwable {

		String url = TASKS.replace("{room_id}", roomId);

		return this.http("https", DOMAIN, url).header("X-ChatWorkToken", appId).param("method", "POST").param("body", body).param("to_ids", toIds).requestPost().getJsonMapSimple();
	}

	/**
	 * メッセージ投稿.
	 *
	 * @param address
	 * @return
	 * @throws Throwable
	 */
	public Map<String, String> postMessages(String appId, String roomId, String body) throws Throwable {

		String url = MESSAGE.replace("{room_id}", roomId);
		System.out.print(this.http("https", DOMAIN, url).header("X-ChatWorkToken", appId).param("method", "POST").param("body", body));
		return this.http("https", DOMAIN, url).header("X-ChatWorkToken", appId).param("method", "POST").param("body", body).requestPost().getJsonMapSimple();
	}

	/**
	 * ★ファイル送信★
	 *
	 * @param address
	 * @return
	 * @throws Throwable
	 */
	public Map<String,List<Map<String,String>>> postFile(String appId, String roomId, String body,File file) throws Throwable {

		String url = FILES.replace("{room_id}", roomId);
		return this.http("https", DOMAIN, url).header("X-ChatWorkToken", appId).param("method", "POST").param("file", file).param("message", "テストメッセージ").requestPostMultipart().getJsonMap();
	}

	/**
	 * チャットのメンバー一覧を取得.
	 *
	 * @param appId
	 * @param roomId
	 * @return
	 * @throws Throwable
	 */
	public List<Map<String, String>> getRoomMenbers(String appId, String roomId) throws Throwable {

		String url = MEMBERS.replace("{room_id}", roomId);

		return this.http("https", DOMAIN, url).header("X-ChatWorkToken", appId).param("method", "GET").requestGet().getJsonMapList();
	}

	/**
	 * コンタクト一覧を取得.
	 *
	 * @param appId
	 * @param roomId
	 * @return
	 * @throws Throwable
	 */
	public List<Map<String, String>> getContacts(String appId) throws Throwable {

		String url = CONTACTS;

		return this.http("https", DOMAIN, url).header("X-ChatWorkToken", appId).param("method", "GET").requestGet().getJsonMapList();
	}
	/**
	 * 添付ファイル投稿.
	 *
	 * @param address
	 * @return
	 * @throws Throwable
	 */
	public Map<String, String> postFiles(String appId, String roomId, File file, String message) throws Throwable {

		String url = FILES.replace("{room_id}", roomId);

		return this.http("https", DOMAIN, url).header("X-ChatWorkToken", appId).param("method", "POST").param("file", file).param("message", message).requestPostMultipart().getJsonMapSimple();
	}
}
