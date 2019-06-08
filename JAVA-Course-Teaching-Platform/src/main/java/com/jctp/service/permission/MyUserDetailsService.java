package com.jctp.service.permission;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jctp.beans.Role;
import com.jctp.beans.User;
import com.jctp.mapper.UserPermissionMapper;

@Service("userPermissionService")
public class MyUserDetailsService implements UserDetailsService{
	@Autowired
	private UserPermissionMapper userPermissionMapper;

    
	@Override
	public UserDetails loadUserByUsername(String workNo) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=userPermissionMapper.getUserByWorkNo(workNo);
		if(user==null) {
			throw new UsernameNotFoundException("账号不存在或密码错误");
		}
		Role role=userPermissionMapper.getRoleListById(user.getRoleId());
		
		List<SimpleGrantedAuthority> authorities=new ArrayList<SimpleGrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(role.getName()));
		System.out.println("role name:"+role.getName());
		
		System.out.println("username:"+user.getWorkNo());
		System.out.println("password:"+user.getPassword());
		return new org.springframework.security.core.userdetails.User(user.getWorkNo(),user.getPassword(),authorities);
	}
	
	public User getUserByWordNo(String workNo) {
		return userPermissionMapper.getUserByWorkNo(workNo);
	}
	
}
