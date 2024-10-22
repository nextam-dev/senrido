/* =============================================================
 * システム名：
 * ファイル名：
 * --------------------------------------------------------------
 */
package jp.co.senrido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.senrido.form.S008QuestionnaireForm;

/**
 * @author hirose
 *
 */
@Controller
public class S008QuestionnaireController {

	@Autowired
	private Environment eivironment;

	@RequestMapping(value="/s008Questionnaire", method = RequestMethod.GET)
    public String getInit(@ModelAttribute("form") S008QuestionnaireForm form, Model model) {
		// 認証した情報を取得する
//		UserDto userDto = (UserDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		model.addAttribute("userDto",userDto);
//		model.addAttribute("path", eivironment.getProperty(GoitaiConstant.Application.CONTEXT_PATH));

        return "/s008Questionnaire";
    }
	
	@RequestMapping(value="/s008Questionnaire/continuation", method = RequestMethod.GET)
    public String getContinuation(@ModelAttribute("form") S008QuestionnaireForm form, Model model) {
		// 認証した情報を取得する
//		UserDto userDto = (UserDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		model.addAttribute("userDto",userDto);
//		model.addAttribute("path", eivironment.getProperty(GoitaiConstant.Application.CONTEXT_PATH));

        return "/s008QuestionnaireContinuation";
    }
	
	@RequestMapping(value="/s008Questionnaire/complete", method = RequestMethod.GET)
    public String getComplete(@ModelAttribute("form") S008QuestionnaireForm form, Model model) {
		// 認証した情報を取得する
//		UserDto userDto = (UserDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		model.addAttribute("userDto",userDto);
//		model.addAttribute("path", eivironment.getProperty(GoitaiConstant.Application.CONTEXT_PATH));

        return "/s008QuestionnaireComplete";
    }

}
