package com.jctp.service.permission;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.cache.NullUserCache;
import org.springframework.stereotype.Service;

import com.jctp.beans.Role;
import com.jctp.beans.User;
import com.jctp.mapper.UserPermissionMapper;

@Service("userPermissionService")
public class MyUserDetailsService implements UserDetailsService{
	private UserCache userCache = new NullUserCache();
	
	@Autowired
	private UserPermissionMapper userPermissionMapper;
	
	public UserCache getUserCache() {
        return userCache;

    }

    public void setUserCache(UserCache userCache) {
        this.userCache = userCache;

    }
    
	@Override
	public UserDetails loadUserByUsername(String workNo) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		User user=userPermissionMapper.getUserByWorkNo(workNo);
		if(user==null) {
			throw new UsernameNotFoundException("账号不存在或密码错误");
		}
		Role role=userPermissionMapper.getRoleListById(user.getRoleId());
		
		List<SimpleGrantedAuthority> authorities=new ArrayList<SimpleGrantedAuthority>();
		//之所以要添加"ROLE_"是因为前端的thymeleaf-extras-springsecurity5校验的时候，
		//sec:authorize="hasRole('TEACHER')",只有在这里加ROLE_才能识别TEACHER
		authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getName()));
		
		System.out.println("role name:"+role.getName());
		
		System.out.println("username:"+user.getWorkNo());
		System.out.println("password:"+user.getPassword());
		/*
		UserDetails userDetails = userCache.getUserFromCache(workNo);
		if(userDetails==null)
			userDetails=new org.springframework.security.core.userdetails.User(user.getWorkNo(),user.getPassword(),authorities);
		userCache.putUserInCache(userDetails);
		*/
		user.setAuthorities(authorities);
		return user;
	}
	
	public User getUserByWordNo(String workNo) {
		return userPermissionMapper.getUserByWorkNo(workNo);
	}
	
}
