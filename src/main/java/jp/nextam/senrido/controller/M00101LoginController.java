/**
 *
 */
package jp.nextam.senrido.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.nextam.senrido.common.GoitaiConstant;

import jp.nextam.senrido.entity.MEmployee;
import jp.nextam.senrido.form.LoginForm;
import jp.nextam.senrido.service.MEmployeeService;

/**
 * @author t_hirose
 *
 */
@Controller
public class M00101LoginController {
	@Autowired
	private Environment eivironment;

	@Autowired
	MEmployeeService mEmployeeService;

	private static final Log log = LogFactory.getLog(M00101LoginController.class);

	@RequestMapping(value="/", method = RequestMethod.GET)
    public String getSample(@ModelAttribute("form") LoginForm form, Model model) {
		model.addAttribute("path", eivironment.getProperty(GoitaiConstant.Application.CONTEXT_PATH));
        return "s001Login";
    }

	@RequestMapping(value = "m00101Login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public MEmployee postGetEmp(@Valid @RequestBody LoginForm from, BindingResult result, Model model) {
		if (result.hasErrors()) {
            for(FieldError err: result.getFieldErrors()) {
            	log.error("error fieald = [" + err.getField() + "]");
                log.error("error code = [" + err.getCode() + "]");
            }
            return null;
        }
        return mEmployeeService.getEmployeeExt(from.getIdTX());
    }

	@RequestMapping(value="/login", method = RequestMethod.GET)
    public String getTop(@ModelAttribute("form") LoginForm form, Model model) {

        return "s001Login";
    }

	@RequestMapping(value="/timeout", method = RequestMethod.GET)
    public String getError(@ModelAttribute("form") LoginForm form, Model model) {

        return "timeout";
    }
}
