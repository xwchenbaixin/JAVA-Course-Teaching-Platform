package com.jctp.service.permission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

import com.jctp.beans.Permission;
import com.jctp.beans.RolePermission;
import com.jctp.mapper.UserPermissionMapper;

import javax.servlet.http.HttpServletRequest;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.*;

/**
 * 
 * @author CBX
 * @Desc 主要功能是获取权限表中的权限，并返回Collection<ConfigAttribute> array;
 */
@Service
public class MyInvocationSecurityMetadataSourceService  implements
        FilterInvocationSecurityMetadataSource {

    @Autowired
    private UserPermissionMapper userPermissionMapper;

    private HashMap<String, Collection<ConfigAttribute>> map =null;

    /**
     * 加载权限表中所有权限
     */
    public void loadResourceDefine(){
        map = new HashMap<>();
        Collection<ConfigAttribute> array;
        ConfigAttribute cfg;
        //获取角色权限表中的所有数据
        List<RolePermission> RolePermissionList = userPermissionMapper.getRolePermissions();
        
        for(RolePermission rp : RolePermissionList) {
 
            array = new ArrayList<>();
            cfg = new SecurityConfig(rp.getRole().getName());
            System.out.println("MyInvo:"+rp.getRole().getName());
            //此处只添加了用户的名字，其实还可以添加更多权限的信息，例如请求方法到ConfigAttribute的集合中去。
            //此处添加的信息将会作为MyAccessDecisionManager类的decide的第三个参数。
            array.add(cfg);
            //用权限的getUrl() 作为map的key，用ConfigAttribute的集合作为 value，
            map.put(rp.getPermission().getUrl(), array);
        }

    }

    //此方法是为了判定用户请求的url 是否在权限表中，如果在权限表中，则返回给 decide 方法，用来判定用户是否有此权限。如果不在权限表中则放行。
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        
    	//如果map 为空的情况下则获取数据库中权限表的数据
    	if(map ==null) loadResourceDefine();
        System.out.println("map is not null");
        //object 中包含用户请求的request 信息也就是请求的URL
        HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
        
        AntPathRequestMatcher matcher;
        String resUrl;
        for(Iterator<String> iter = map.keySet().iterator(); iter.hasNext(); ) {
            resUrl = iter.next();
            
            System.out.println("reqUrl:"+request.getRequestURL());
            matcher = new AntPathRequestMatcher(resUrl);
            System.out.println("matcher:"+matcher);
            if(matcher.matches(request)) {
            
            	System.out.println("匹配成功");
                return map.get(resUrl);
            }
            System.out.println("URL不在权限表中");
        }
        //URL不在权限表中 ,则可以访问
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
