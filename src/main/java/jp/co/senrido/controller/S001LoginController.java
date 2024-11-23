/* =============================================================
 * システム名：
 * ファイル名：
 * --------------------------------------------------------------
 */
package jp.co.senrido.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.senrido.common.SenridoConstant;
import jp.co.senrido.form.LoginForm;

/**
 * @author t_hirose
 *
 */
@Controller
public class S001LoginController {
	@Autowired
	private Environment eivironment;

	private static final Log log = LogFactory.getLog(S001LoginController.class);

	@RequestMapping(value="/", method = RequestMethod.GET)
    public String getSample(@ModelAttribute("form") LoginForm form, Model model) {
		model.addAttribute("path", eivironment.getProperty(SenridoConstant.Application.CONTEXT_PATH));
        return "s001Login";
    }

	@RequestMapping(value="/timeout", method = RequestMethod.GET)
    public String getError(@ModelAttribute("form") LoginForm form, Model model) {

        return "timeout";
    }
}
