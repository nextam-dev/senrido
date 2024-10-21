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

import jp.co.senrido.form.S006ReservationForm;

/**
 * @author kurokawa
 *
 */
@Controller
public class S006ReservationController {

	@Autowired
	private Environment eivironment;

	@RequestMapping(value="/s006Reservation", method = RequestMethod.GET)
    public String getMenu(@ModelAttribute("form") S006ReservationForm form, Model model) {
		// 認証した情報を取得する
//		UserDto userDto = (UserDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		model.addAttribute("userDto",userDto);
//		model.addAttribute("path", eivironment.getProperty(GoitaiConstant.Application.CONTEXT_PATH));

        return "/s006Reservation";
    }

}
