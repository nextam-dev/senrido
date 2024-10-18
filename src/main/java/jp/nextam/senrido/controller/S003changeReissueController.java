/**
 *
 */
package jp.nextam.senrido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.nextam.senrido.dto.UserDto;
import jp.nextam.senrido.form.S003changeReissueForm;

/**
 * @author kurokawa
 *
 */
@Controller
public class S003changeReissueController {

	@Autowired
	private Environment eivironment;

	@RequestMapping(value="**/s003changeReissue", method = RequestMethod.GET)
    public String getMenu(@ModelAttribute("form") S003changeReissueForm form, Model model) {
		// 認証した情報を取得する
		UserDto userDto = (UserDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("userDto",userDto);
		//model.addAttribute("path", eivironment.getProperty(MitsumoriConstant.Application.CONTEXT_PATH));

        return "s003changeReissue";
    }

}
