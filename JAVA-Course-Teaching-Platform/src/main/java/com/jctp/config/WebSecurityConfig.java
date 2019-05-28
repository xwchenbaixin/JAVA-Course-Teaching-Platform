package com.jctp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import com.jctp.service.permission.MyFilterSecurityInterceptor;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserDetailsService userPermissionService;
	
	@Autowired
    private MyFilterSecurityInterceptor myFilterSecurityInterceptor;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//System.out.println("加密后:"+new BCryptPasswordEncoder().encode("cbx318"));
		auth.userDetailsService(userPermissionService).passwordEncoder(passwordEncoder());
	}
	
	@Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/layui/**");
    }

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
			.anyRequest().authenticated()//任何请求，登录后可以访问
			.and()
			.formLogin()
			.loginPage("/login")//登陆界面页面跳转URL
			//.loginProcessingUrl("/")//登陆界面发起登陆请求的URL
			.failureUrl("/login?error")
			.permitAll()//登录页面用户任意访问
			.and()
			.logout()
			.logoutSuccessUrl("/home")  //退出登录后的默认url是"/home"
			.permitAll()//注销行为任意访问
			.and()
			.csrf().disable();
		http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class);
	}
}
