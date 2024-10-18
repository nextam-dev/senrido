/**
 *
 */
package com.makino_saiten.goitai.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.makino_saiten.goitai.annotation.NonRequiredSession;
import com.makino_saiten.goitai.dto.UserDto;
import com.makino_saiten.goitai.excption.AuthFailException;

/**
 * @author t_hirose
 *
 */
public class GoitaiHandlerInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

    	try {
	    	HandlerMethod hm = (HandlerMethod) handler;
	        Method method = hm.getMethod();

	        if (!method.isAnnotationPresent(RequestMapping.class)) {
	        	return true;
	        }

	        if (method.isAnnotationPresent(NonRequiredSession.class)) {
	        	return true;
	        }

	        Log log = LogFactory.getLog(method.getDeclaringClass());

	        log.info("★★★★★★★★★★★★★★★★★★★★★★");
	        RequestMapping rm = method.getAnnotation(RequestMapping.class);
			String id = "";
			try {
				// 認証した情報を取得する
				UserDto userDto = (UserDto)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			} catch (AuthFailException e) {
				throw e;
	        } catch(Exception ex) {
	        	// 何もしない
	    	}
			log.info(String.format("////// request:%s, id:%s start //////", rm.value()[0], id));

    	} catch(Exception e) {
    		return true;
    	}

        // Handlerメソッドを呼び出す場合はtrueを返却する
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    	try {
	    	HandlerMethod hm = (HandlerMethod) handler;
	        Method method = hm.getMethod();

	        if (!method.isAnnotationPresent(RequestMapping.class)) {
	        	return;
	        }

	        Log log = LogFactory.getLog(method.getDeclaringClass());
	        RequestMapping rm = method.getAnnotation(RequestMapping.class);

			String id = "";
			try {
				// 認証した情報を取得する
				UserDto userDto = (UserDto)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				if (userDto != null) {
					id = userDto.getEmployeeCode();
				}

	        } catch(Exception ex) {
	        	// 何もしない
	    	}
			log.info(String.format("////// request:%s, id:%s end //////", rm.value()[0], id));

    	} catch(Exception e) {
    		// 何もしない
    	}
    }

}
