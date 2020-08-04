package pers.jamie.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pers.jamie.filter.uerFilter;

import javax.servlet.FilterConfig;

@Configuration
public class filterConfiguration {


    @Bean
    public FilterRegistrationBean registrationBean(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new uerFilter());
        bean.addUrlPatterns(
                "/cart/*",
                "/userInfo.html");
        return bean;
    }

}
