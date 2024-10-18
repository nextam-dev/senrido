/* =============================================================
 * ファイル名：HttpRequestHelper.java
 * --------------------------------------------------------------
 */
package com.makino_saiten.goitai.helper;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

//import jp.mkeiei.partner.helper.HttpRequestHelper;
import com.makino_saiten.goitai.helper.HttpRequestHelper;
import net.arnx.jsonic.JSON;

/**
 * HTTPリクエストヘルパークラス.
 *
 * @author t_hirose
 * @version 2018/05/23
 *
 *
 */
@SuppressWarnings("deprecation")
public class HttpRequestHelper<DTO> {

	private static final String UTF8_CHARSET = "UTF-8";

	private static final Log log = LogFactory.getLog(HttpRequestHelper.class);

	private Class<DTO> dtoClass;
	private StringBuilder builder = new StringBuilder();
	private Map<String, Object> header = new HashMap<String, Object>();
	private Map<String, Object> param = new HashMap<String, Object>();
	private String jsonPostData = null;
	private byte[] responseData = null;
	private int statucCd = 200;
	//ファイルアップロード用
	private Map<String, File> paramFile = new HashMap<String, File>();

	/**
	 * コンストラクタ
	 */
	public HttpRequestHelper(Class<DTO> clazz) {
		this.dtoClass = clazz;
		begin();
	}

	/**
	 * 初期化処理.
	 *
	 */
	private void begin() {
		param = new HashMap<String, Object>();
		builder = new StringBuilder();
		responseData = null;
	}

	/**
	 * HTTPリクエスト開始処理.
	 *
	 * @param scheme
	 * @param domain
	 * @param path
	 * @return
	 */
	public HttpRequestHelper<DTO> http(String scheme, String domain, String path) {
		begin();
		builder.append(scheme);
		builder.append("://");
		builder.append(domain);
		builder.append(path);
		return this;
	}

	public HttpRequestHelper<DTO> header(String key, String value) {
		header.put(key, value);
		return this;
	}

//	/**
//	 * リクエストパラメータ設定処理. Fileを一緒に送信する。
//	 *
//	 * @param obj
//	 * @return
//	 * @throws Throwable
//	 */
//	public HttpRequestHelper<DTO> header(String key, File file) {
//		header.put(key, value);
//		header.put("file", file);
//		return this;
//	}

	/**
	 * リクエストパラメータ設定処理. POJOオブジェクトを渡すと中のプロパティをパラメータとして設定する
	 *
	 * @param obj
	 * @return
	 * @throws Throwable
	 */
	public HttpRequestHelper<DTO> param(Object obj) throws Throwable {
		BeanUtils.copyProperties(obj, param);
		return this;
	}

	/**
	 * リクエストパラメータ設定処理. MAPオブジェクトを渡すとパラメータとして設定する
	 *
	 * @param obj
	 * @return
	 * @throws Throwable
	 */
	public HttpRequestHelper<DTO> param(Map<String, Object> obj) throws Throwable {
		param = obj;
		return this;
	}

	/**
	 * ファイルパラメータ設定処理. 個別のパラメータを設定する
	 *
	 * @param key
	 * @param file
	 * @return
	 */
	public HttpRequestHelper<DTO> param(String key, File file) {
		paramFile.put(key, file);
		return this;
	}

	/**
	 * リクエストパラメータ設定処理. 個別のパラメータを設定する
	 *
	 * @param key
	 * @param value
	 * @return
	 */
	public HttpRequestHelper<DTO> param(String key, String value) {
		param.put(key, value);
		return this;
	}

	/**
	 * リクエストパラメータ設定処理. POJOオブジェクトを渡すとjsonに変換して設定する
	 *
	 * @param obj
	 * @return
	 */
	public HttpRequestHelper<DTO> paramJson(Object obj) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		this.jsonPostData = mapper.writeValueAsString(obj);
		return this;
	}

	/**
	 * GETリクエスト送信処理.
	 *
	 * @return
	 */
	public HttpRequestHelper<DTO> requestGet() {

		int cnt = 0;
		for (String key : param.keySet()) {
			if (cnt == 0) {
				builder.append("?");
			} else {
				builder.append("&");
			}
			builder.append(percentEncodeRfc3986(key));
			builder.append("=");
			builder.append(percentEncodeRfc3986((String) param.get(key)));
			cnt++;
		}

		System.out.println(builder.toString());

		HttpGet request = new HttpGet(builder.toString());

		// ヘッダ設定
		for (String key : header.keySet()) {
			request.setHeader(key, (String) header.get(key));
		}

		this.responseData = execute(request);

		return this;
	}

	/**
	 * エンコード処理
	 *
	 * @param s
	 * @return
	 */
	private String percentEncodeRfc3986(String s) {
		String out;
		try {
			out = URLEncoder.encode(s, UTF8_CHARSET).replace("+", "%20").replace("*", "%2A").replace("%7E", "~");
		} catch (UnsupportedEncodingException e) {
			out = s;
		}
		return out;
	}

	/**
	 * POSTリクエスト送信処理.
	 *
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public HttpRequestHelper<DTO> requestPost() throws UnsupportedEncodingException {
		HttpPost request = new HttpPost(builder.toString());

		List<NameValuePair> params = new ArrayList<NameValuePair>();
		for (String key : param.keySet()) {
			params.add(new BasicNameValuePair(key, String.valueOf(param.get(key))));
		}

		request.setEntity(new UrlEncodedFormEntity(params, UTF8_CHARSET));

		// ヘッダ設定
		for (String key : header.keySet()) {
			request.setHeader(key, (String) header.get(key));
		}
		log.info(request);
		this.responseData = execute(request);

		return this;
	}

	/**
	 * POSTリクエスト送信処理.
	 *
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public HttpRequestHelper<DTO> requestPostJson() throws UnsupportedEncodingException {
		HttpPost request = new HttpPost(builder.toString());

		// header設定
		request.setHeader("Content-type", "application/json; charset=UTF-8");

		log.info(this.jsonPostData);

		// body設定
		request.setEntity(new StringEntity(this.jsonPostData, UTF8_CHARSET));

		this.responseData = execute(request);

		return this;

	}

	/**
	 * レスポンスで戻された結果を文字列で取得する.
	 *
	 * @return
	 * @throws Throwable
	 */
	public String getString() throws Throwable {
		if (this.responseData == null) {
			log.debug("response data null");
			return null;
		}
		return new String(this.responseData, UTF8_CHARSET);
	}

	/**
	 * レスポンスで戻されたJSONをオブジェクトで取得する.
	 *
	 * @return
	 * @throws Throwable
	 */
	public DTO getJSON() throws Throwable {

		if (this.responseData == null) {
			log.debug("response data null");
			return null;
		}

		String jsonText = this.getString();

		System.out.println(jsonText);
		ObjectMapper mapper = new ObjectMapper();
		DTO dto = mapper.readValue(jsonText, dtoClass);

		return dto;
	}

	/**
	 * レスポンスで戻されたJSONをオブジェクトで取得する.
	 *
	 * @return
	 * @throws Throwable
	 */
	public Map<String, List<Map<String, String>>> getJsonMap() throws Throwable {

		if (this.responseData == null) {
			log.debug("response data null");
			return null;
		}

		ObjectMapper mapper = new ObjectMapper();
		Map<String, List<Map<String, String>>> map = mapper.readValue(this.getResponseStream(), new TypeReference<LinkedHashMap<String, List<Map<String, String>>>>() {
		});
		for (Iterator<Entry<String, List<Map<String, String>>>> iter = map.entrySet().iterator(); iter.hasNext();) {
			Entry<String, List<Map<String, String>>> elem1 = iter.next();
			System.out.format("key:%s%n", elem1.getKey());

			List<Map<String, String>> value = elem1.getValue();
			for (Map<String, String> it : value) {
				for (Iterator<Entry<String, String>> iterator = it.entrySet().iterator(); iterator.hasNext();) {
					Entry<String, String> elem2 = iterator.next();
					System.out.format(" key:%-15s value:%s%n", elem2.getKey(), elem2.getValue());
				}
			}
		}

		return map;
	}

	/**
	 * レスポンスで戻されたJSONをオブジェクトで取得する.
	 *
	 * @return
	 * @throws Throwable
	 */
	public Map<String, String> getJsonMapSimple() throws Throwable {

		if (this.responseData == null) {
			log.debug("response data null");
			return null;
		}

		Map<String, String> map = JSON.decode(this.getResponseStream());

		return map;
	}

	/**
	 * レスポンスで戻されたJSONをオブジェクトで取得する.
	 *
	 * @return
	 * @throws Throwable
	 */
	public List<Map<String, String>> getJsonMapList() throws Throwable {

		if (this.responseData == null) {
			log.debug("response data null");
			return null;
		}

		List<Map<String, String>> jsonList = JSON.decode(this.getResponseStream());

		return jsonList;
	}

	/**
	 * POSTリクエスト送信処理（ファイルアップロード）.
	 *
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public HttpRequestHelper<DTO> requestPostMultipart() throws Throwable {
		HttpPost request = new HttpPost(builder.toString());

		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		builder.setCharset(StandardCharsets.UTF_8);
		builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);

		// This attaches the file to the POST:
		for (String key : paramFile.keySet()) {
			builder.addBinaryBody(key, new FileInputStream(paramFile.get(key)), ContentType.APPLICATION_OCTET_STREAM, paramFile.get(key).getName());
		}

		for (String key : param.keySet()) {
			builder.addTextBody(key, String.valueOf(param.get(key)), ContentType.TEXT_PLAIN.withCharset("UTF-8"));
		}

		HttpEntity multipart = builder.build();
		request.setEntity(multipart);

		// ヘッダ設定
		for (String key : header.keySet()) {
			request.setHeader(key, (String) header.get(key));
		}

		this.responseData = execute(request);

		return this;
	}

	/**
	 * HTTPリクエスト実行処理.
	 *
	 * @param request
	 * @return
	 */
	private byte[] execute(HttpRequestBase request) {

		log.debug("execute start");

		log.info(request.getURI().toString());

		// HttpClientインタフェースではなくて、実クラスのDefaultHttpClientを使う。
		// 実クラスでないとCookieが使えないなど不都合が多い。
		DefaultHttpClient httpClient = new DefaultHttpClient();

		try {
			//ここで送信
			HttpResponse response = httpClient.execute(request);

			// ステータスコード取得
			statucCd = response.getStatusLine().getStatusCode();

			// response.getStatusLine().getStatusCode()でレスポンスコードを判定する。
			// 正常に通信できた場合、HttpStatus.SC_OK（HTTP 200）となる。
			switch (response.getStatusLine().getStatusCode()) {
			case HttpStatus.SC_OK:
				log.debug("execute end");

				// レスポンスデータを文字列として取得する。
				// byte[]として読み出したいときはEntityUtils.toByteArray()を使う。
				return EntityUtils.toByteArray(response.getEntity());

			case HttpStatus.SC_NOT_FOUND:
				throw new RuntimeException("データがありません"); // FIXME

			default:
				throw new RuntimeException("通信エラー"); // FIXME
			}

		} catch (ClientProtocolException e) {
			throw new RuntimeException(e); // FIXME
		} catch (IOException e) {
			throw new RuntimeException(e); // FIXME
		} finally {
			// ここではfinallyでshutdown()しているが、HttpClientを使い回す場合は、
			// 適切なところで行うこと。当然だがshutdown()したインスタンスは通信できなくなる。
			httpClient.getConnectionManager().shutdown();
			httpClient.close();
		}
	}

	/**
	 * レスポンスで戻されたbyte[]を取得.
	 *
	 * @return
	 */
	public byte[] getResponseData() {
		return this.responseData;
	}

	/**
	 * レスポンスで戻されたストリームを取得.
	 *
	 * @return
	 */
	public InputStream getResponseStream() {
		return new ByteArrayInputStream(this.responseData);
	}

	/**
	 * HTTP通信レスポンスコードを取得.
	 *
	 * @return
	 */
	public int getStatusCode() {
		return this.statucCd;
	}

	/**
	 * JSONデータを取得.
	 *
	 * @return
	 */
	public String getJsonPostData() {
		return this.jsonPostData;
	}
}
