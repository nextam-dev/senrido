/**
 *
 */
package com.makino_saiten.goitai.controller;

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

import com.makino_saiten.goitai.common.GoitaiConstant;
import com.makino_saiten.goitai.entity.MEmployee;
import com.makino_saiten.goitai.form.LoginForm;
import com.makino_saiten.goitai.service.MEmployeeService;

/**
 * @author t_hirose
 *
 */
@Controller
public class G001LoginController {
	@Autowired
	MEmployeeService mEmployeeService;

	@Autowired
	private Environment eivironment;

	private static final Log log = LogFactory.getLog(G001LoginController.class);

	@RequestMapping(value="/", method = RequestMethod.GET)
    public String getSample(@ModelAttribute("form") LoginForm form, Model model) {
		// 認証した情報を取得する
		model.addAttribute("path", eivironment.getProperty(GoitaiConstant.Application.CONTEXT_PATH));

        return "g001Login";
    }

	@RequestMapping(value = "g001Login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
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
		// 認証した情報を取得する
//		UserDto userDto = (UserDto)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

//		log.debug(userDto.toString());
		// 認証した情報を取得する
		model.addAttribute("path", eivironment.getProperty(GoitaiConstant.Application.CONTEXT_PATH));

        return "g001Login";
    }
}
