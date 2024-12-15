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
 * お客様アンケート用コントローラー.
 * 
 * @author hirose
 *
 */
@Controller
public class S008QuestionnaireController {

	@Autowired
	private Environment eivironment;

	/**
	 * お客様アンケート初回用.
	 * 
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/s008Questionnaire", method = RequestMethod.GET)
    public String init(@ModelAttribute("form") S008QuestionnaireForm form, Model model) {

        return "/s008Questionnaire";
    }
	
	/**
	 * お客様アンケート2回目以降用.
	 * 
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/s008Questionnaire/continuation", method = RequestMethod.GET)
    public String continuation(@ModelAttribute("form") S008QuestionnaireForm form, Model model) {

        return "/s008QuestionnaireContinuation";
    }
	
	/**
	 * 完了画面.
	 * 
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/s008Questionnaire/complete", method = RequestMethod.GET)
    public String complete(@ModelAttribute("form") S008QuestionnaireForm form, Model model) {

        return "/s008QuestionnaireComplete";
    }
	
	/**
	 * お客様アンケート初回表示用.
	 * 
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/s008Questionnaire/view", method = RequestMethod.GET)
    public String view(@ModelAttribute("form") S008QuestionnaireForm form, Model model) {

        return "/s008QuestionnaireDisp";
    }
	
	/**
	 * お客様アンケート2回目以降表示用.
	 * 
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/s008Questionnaire/continuation/view", method = RequestMethod.GET)
    public String viewCoutinuation(@ModelAttribute("form") S008QuestionnaireForm form, Model model) {

        return "/s008QuestionnaireCoutinuationDisp";
    }
}
