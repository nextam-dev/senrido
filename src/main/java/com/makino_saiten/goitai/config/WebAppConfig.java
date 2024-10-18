/**
 *
 */
package com.makino_saiten.goitai.config;

import javax.sql.DataSource;

import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.MysqlDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.handler.MappedInterceptor;

import com.makino_saiten.goitai.interceptor.GoitaiHandlerInterceptor;

/**
 * @author t_hirose
 *
 */
@Configuration
public class WebAppConfig {

	@Autowired
	private DataSource dataSource;

	@Bean
    public GoitaiHandlerInterceptor blankpjHandlerInterceptor() {
        return new GoitaiHandlerInterceptor();
    }

    @Bean
    public MappedInterceptor interceptor() {
        return new MappedInterceptor(new String[]{"/**"}, blankpjHandlerInterceptor());
    }

    @Bean(name="validator")
    public LocalValidatorFactoryBean localValidatorFactoryBean() {
        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.setValidationMessageSource(messageSource());
        return localValidatorFactoryBean;
    }

    /**
     * ValidationのメッセージをUTF-8で管理します。
     * @return
     */
    @Bean(name = "messageSource")
    public MessageSource messageSource()
    {
        ReloadableResourceBundleMessageSource bean = new ReloadableResourceBundleMessageSource();
        bean.setBasename("classpath:messages");
        bean.setDefaultEncoding("UTF-8");
        return bean;
    }

    @Bean
    public Config domaConfig() {
        return new Config() {
            @Override
            public Dialect getDialect() {
                return new MysqlDialect();
            }

            @Override
            public DataSource getDataSource() {
                return new TransactionAwareDataSourceProxy(dataSource);
            }
        };
    }
}
