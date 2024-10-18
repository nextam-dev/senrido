/**
 * 
 */
package com.makino_saiten.goitai.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.makino_saiten.goitai.dto.UserDto;
import com.makino_saiten.goitai.service.AuthService;

/**
 * @author t_hirose
 *
 */
@Component
public class AuthenticationProviderImpl implements AuthenticationProvider {
	
	@Autowired
    private AuthService authService;

    @Override
    public Authentication authenticate(Authentication auth)
            throws AuthenticationException {

        UserDto user = (UserDto)auth.getPrincipal();
        String password = auth.getCredentials().toString();

        user = authService.auth(user.getEmployeeCode(), password);
        if (user == null) {
            // 例外はSpringSecurityにあったものを適当に使用
            throw new BadCredentialsException("ログイン情報が存在しません。");
        }

        return new UsernamePasswordAuthenticationToken(user, password, auth.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
