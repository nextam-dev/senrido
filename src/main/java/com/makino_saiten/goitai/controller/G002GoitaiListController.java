/**
 *
 */
package com.makino_saiten.goitai.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.makino_saiten.goitai.common.GoitaiConstant;
import com.makino_saiten.goitai.dto.UserDto;

/**
 * @author kurokawa
 *
 */
@Controller
public class G002GoitaiListController {

	@Autowired
	private Environment eivironment;

	private static final Log log = LogFactory.getLog(G002GoitaiListController.class);

	@RequestMapping(value="/list", method = RequestMethod.GET)
    public String getMenu(Model model) {

		// 認証した情報を取得する
		UserDto userDto = (UserDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("userDto",userDto);
		model.addAttribute("path", eivironment.getProperty(GoitaiConstant.Application.CONTEXT_PATH));

        return "list";
    }

}
