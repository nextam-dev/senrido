/* =============================================================
 * システム名：ご遺体管理システム
 * ファイル名：GoitaiLoginUrlAuthenticationEntryPoint.java
 * --------------------------------------------------------------
 */
package com.makino_saiten.goitai.auth;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import com.makino_saiten.goitai.utils.StringConvertUtil;


/**
 * {クラスの処理内容を記載}.
 *
 * @author t_hirose
 * @version 2018/11/13
 *
 */
public class GoitaiLoginUrlAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {

	public GoitaiLoginUrlAuthenticationEntryPoint (String loginFormUrl) {
		super(loginFormUrl);
	}

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {

		// axiosでの通信の場合は、HTTPステータスで403を返却する。
		// URIのプレフィックスが「/v1/」以外も増えたら、ここに追加する
		if (!request.getRequestURI().startsWith("/view")) {
			if (Objects.equals(request.getMethod(), "GET")) {
				super.commence(request, response, authException);
				return;
			}
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			return;
		}

		super.commence(request, response, authException);
	}

	@Override
	protected String buildRedirectUrlToLoginPage(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) {

		String redirectUrl = "";
		redirectUrl = "/timeout/?kbn=timeout&url=" + request.getRequestURI() + "?" + StringConvertUtil.editNVL(request.getQueryString());
		return redirectUrl;
	}

	private boolean isRequestedSessionInvalid(HttpServletRequest request) {
		return request.getRequestedSessionId() != null && !request.isRequestedSessionIdValid();
	}
}
