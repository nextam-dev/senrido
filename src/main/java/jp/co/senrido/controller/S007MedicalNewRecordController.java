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

import jp.co.senrido.form.S007MedicalRecordForm;

/**
 * @author kurokawa
 *
 */
@Controller
public class S007MedicalNewRecordController {

	@Autowired
	private Environment eivironment;

	@RequestMapping(value="/s007MedicalNewRecord", method = RequestMethod.GET)
    public String getMenu(@ModelAttribute("form") S007MedicalRecordForm form, Model model) {
		// 認証した情報を取得する
//		UserDto userDto = (UserDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		model.addAttribute("userDto",userDto);
//		model.addAttribute("path", eivironment.getProperty(GoitaiConstant.Application.CONTEXT_PATH));

        return "/s007MedicalNewRecord";
    }

}
