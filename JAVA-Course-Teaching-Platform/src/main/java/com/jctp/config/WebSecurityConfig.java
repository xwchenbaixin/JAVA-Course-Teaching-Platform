package com.jctp.config;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.logout.DelegatingLogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.server.authentication.logout.HttpStatusReturningServerLogoutSuccessHandler;

import com.jctp.service.permission.LoginFailureHandler;
import com.jctp.service.permission.LoginSuccessHandler;
import com.jctp.service.permission.MyFilterSecurityInterceptor;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserDetailsService myUserDetailsService;
	
	@Autowired
    private MyFilterSecurityInterceptor myFilterSecurityInterceptor;
	
	@Autowired
	private LoginSuccessHandler loginSuccessHandler;

	@Autowired
	private LoginFailureHandler loginFailureHandler;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//System.out.println("加密后:"+new BCryptPasswordEncoder().encode("cbx318"));
		auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Override
    public void configure(WebSecurity web) {
		//主要是配置URL
        web.ignoring().antMatchers("/gentelella/**");
    }

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
			.anyRequest().authenticated()//任何请求，登录后可以访问
			.and()
			.formLogin()
			.loginPage("/login")//登录界面的URL
			//.loginProcessingUrl("/")//登陆界面发起登陆请求的URL
			.failureUrl("/login?error")
			.permitAll()//登录页面用户任意访问
			.successHandler(loginSuccessHandler)
			//.failureHandler(loginFailureHandler)
			.and()
			.logout()
			.logoutSuccessUrl("/login")  //退出登录后的默认url是"/login"
			.permitAll()//注销行为任意访问
			.and()
			.csrf().disable();
		
		http.sessionManagement()
			.maximumSessions(1)//最大session并发数量1
			//.sessionRegistry(getSessionRegistry())
			.maxSessionsPreventsLogin(false)//false之后登录踢掉之前登录,true则不允许之后登录
			//.expiredSessionStrategy(new MerryyounExpiredSessionStrategy())//登录被踢掉时的自定义操作
			.and()
			.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
			.invalidSessionUrl("/login");//session失效以后跳转的连接
		http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class);
		
	}
}
