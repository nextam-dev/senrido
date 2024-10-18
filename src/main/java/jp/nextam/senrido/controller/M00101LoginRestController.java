/**
 * 
 */
package jp.nextam.senrido.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.nextam.senrido.dto.UserDto;

/**
 * @author t_hirose
 *
 */
@RestController
public class M00101LoginRestController {
	
    @RequestMapping(value = "success", method = RequestMethod.GET)
    public String success() {
    	UserDto userDto = (UserDto)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	if(userDto.getLoginCount() == null) {
    		return "AUTH_OK";
    	}
    	String StrLoginCount = String.valueOf(userDto.getLoginCount());
    	return StrLoginCount;

    }
	
    @RequestMapping(value = "fail", method = RequestMethod.GET)
    public String fail() {
    	
		return "AUTH_NG";
    }

    /**
     * 
     * @return
     */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		// TODO @@@ Tsuruda セッションクリアみたいなものがあるのか？
		return "/";
	}
}