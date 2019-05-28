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
		//System.out.println("���ܺ�:"+new BCryptPasswordEncoder().encode("cbx318"));
		auth.userDetailsService(userPermissionService).passwordEncoder(passwordEncoder());
	}
	
	@Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/layui/**");
    }

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
			.anyRequest().authenticated()//�κ����󣬵�¼����Է���
			.and()
			.formLogin()
			.loginPage("/login")//��½����ҳ����תURL
			//.loginProcessingUrl("/")//��½���淢���½�����URL
			.failureUrl("/login?error")
			.permitAll()//��¼ҳ���û��������
			.and()
			.logout()
			.logoutSuccessUrl("/home")  //�˳���¼���Ĭ��url��"/home"
			.permitAll()//ע����Ϊ�������
			.and()
			.csrf().disable();
		http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class);
	}
}
