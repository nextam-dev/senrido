/**
 *
 */
package jp.co.senrido.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.csrf.MissingCsrfTokenException;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

import jp.co.senrido.auth.AuthenticationProviderImpl;
import jp.co.senrido.auth.SenridoLoginUrlAuthenticationEntryPoint;
import jp.co.senrido.common.SenridoConstant;
import jp.co.senrido.common.SenridoResources;
import jp.co.senrido.filter.CustomAuthenticationFilter;
import jp.co.senrido.handlers.LogoutPostProcess;

/**
 * @author t_hirose
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationProviderImpl authenticationProviderImpl;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/js/**", "/images/**", "/img/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
	        .authorizeRequests()
	            // 認証対象外のパスを設定する
	        .antMatchers("/", "/login", "/fail", "/Common/**", "/s002PasswordChange", "/s003PasswordReissue", "/s005CustomerInformationSearch", "/s006Reservation", "/s006ReservationCalendar/**", "/s006ReservationTimetable/**", "/s007MedicalRecord", "/s007MedicalNewRecord", "/s008Questionnaire/**").permitAll()
	            // その他のリクエストは認証が必要
				.anyRequest().authenticated().and().logout()
				// ログアウトがパス(GET)の場合設定する（CSRF対応）
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout**")).permitAll()
				// ログアウト時のクエリパラメータを引き次ぐ
				.addLogoutHandler(new LogoutPostProcess())
				// ログアウト後の遷移先
				.logoutSuccessUrl("/").deleteCookies("JSESSIONID").invalidateHttpSession(true).and().formLogin().loginProcessingUrl("/").loginPage("/")
				// セッションタイムアウト用
				.and().exceptionHandling().authenticationEntryPoint(authenticationEntryPoint()).accessDeniedHandler(accessDeniedHandler())
				// CSRF対策
				.and().csrf().ignoringAntMatchers("/login").csrfTokenRepository(csrfTokenRepository()).and()
				.addFilterAfter(csrfHeaderFilter(), CsrfFilter.class);

        CustomAuthenticationFilter filter = new CustomAuthenticationFilter();
        filter.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/login", "POST"));
        filter.setAuthenticationManager(authenticationManagerBean());
        filter.setAuthenticationSuccessHandler(new SimpleUrlAuthenticationSuccessHandler("/success"));
        filter.setAuthenticationFailureHandler(new SimpleUrlAuthenticationFailureHandler("/fail"));

        http.addFilterBefore(filter, CustomAuthenticationFilter.class);
    }

    //セッションヘッダーにCSRFトークンを設定
    private CsrfTokenRepository csrfTokenRepository(){
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setHeaderName("X-XSRF-TOKEN");
        return repository;
    }

    private Filter csrfHeaderFilter() {
        return new OncePerRequestFilter() {
            @Override
            protected void doFilterInternal(HttpServletRequest request,
                    HttpServletResponse response, FilterChain filterChain)
                    throws ServletException, IOException {
                CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class
                        .getName());
                if (csrf != null) {
                    Cookie cookie = WebUtils.getCookie(request, "XSRF-TOKEN");
                    String token = csrf.getToken();
                    if (cookie == null || token != null
                            && !token.equals(cookie.getValue())) {
                        cookie = new Cookie("XSRF-TOKEN", token);
                        String contextPath = SenridoResources.getString(SenridoConstant.Application.PROPERTIES,
                        		SenridoConstant.Application.CONTEXT_PATH);
                        cookie.setPath(contextPath);
                        response.addCookie(cookie);
                    }
                }
                filterChain.doFilter(request, response);
            }
        };
    }
    
	@Bean
	public CommonsRequestLoggingFilter requestLoggingFilter() {
		CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
		filter.setIncludePayload(true);
		filter.setMaxPayloadLength(10000);
		return filter;
	}

	@Bean
	AuthenticationEntryPoint authenticationEntryPoint() {
		return new SenridoLoginUrlAuthenticationEntryPoint("/");
	}
	
	@Bean
	AccessDeniedHandler accessDeniedHandler() {
		return new AccessDeniedHandler() {
			@Override
			public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
				if (accessDeniedException instanceof MissingCsrfTokenException) {
					authenticationEntryPoint().commence(request, response, null);
				} else {
					new AccessDeniedHandlerImpl().handle(request, response, accessDeniedException);
				}
			}
		};
	}

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // 独自認証クラスを設定する
        auth
        	.authenticationProvider(authenticationProviderImpl);
    }
}
