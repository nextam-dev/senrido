/**
 * 
 */
package jp.co.senrido.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jp.co.senrido.dto.UserDto;

/**
 * @author t_hirose
 *
 */
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        
        String userCd = request.getParameter("userCd");
        String password = request.getParameter("password");
        
        UserDto user = new UserDto();
        user.setUserCd(userCd);
        
        // トークンの作成
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(user, password);
        
        setDetails(request, authRequest);
        return this.getAuthenticationManager().authenticate(authRequest);
    }
}
