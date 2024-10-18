/**
 *
 */
package com.makino_saiten.goitai.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.makino_saiten.goitai.annotation.NonRequiredSession;
import com.makino_saiten.goitai.dto.UserDto;
import com.makino_saiten.goitai.form.AuthForm;
import com.makino_saiten.goitai.json.CommonIO;

/**
 * @author t_hirose
 *
 */
@RestController
public class AuthController {

	@Autowired
	HttpSession session;

	@Autowired
	UserDto sessionUserDto;

	@NonRequiredSession
	@RequestMapping(value = "logina", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CommonIO login(@RequestBody AuthForm from) {
		CommonIO io = new CommonIO();

		BeanUtils.copyProperties(from, sessionUserDto);

		sessionUserDto.setEmployeeName("廣瀬");

		// セッションに格納
		session.setAttribute("sessionUserDto", sessionUserDto);

		io.setResultCd("001");
		return io;
	}

	@RequestMapping(value = "logouta", method = RequestMethod.GET)
	public CommonIO logout() {
		CommonIO io = new CommonIO();

		// セッション破棄
		session.invalidate();

		io.setResultCd("001");
		return io;
	}
}
