/**
 * 
 */
package jp.nextam.senrido.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jp.nextam.senrido.dto.UserDto;

/**
 * @author t_hirose
 *
 */
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        
        String employeeCode = request.getParameter("idTX");
        String password = request.getParameter("PasswordTX");
        
        UserDto user = new UserDto();
        user.setEmployeeCode(employeeCode);
        
        // トークンの作成
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(user, password);
        
        setDetails(request, authRequest);
        return this.getAuthenticationManager().authenticate(authRequest);
    }
}
