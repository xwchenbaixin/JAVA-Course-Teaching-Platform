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
 * @Desc ��Ҫ�����ǻ�ȡȨ�ޱ��е�Ȩ�ޣ�������Collection<ConfigAttribute> array;
 */
@Service
public class MyInvocationSecurityMetadataSourceService  implements
        FilterInvocationSecurityMetadataSource {

    @Autowired
    private UserPermissionMapper userPermissionMapper;

    private HashMap<String, Collection<ConfigAttribute>> map =null;

    /**
     * ����Ȩ�ޱ�������Ȩ��
     */
    public void loadResourceDefine(){
        map = new HashMap<>();
        Collection<ConfigAttribute> array;
        ConfigAttribute cfg;
        //��ȡ��ɫȨ�ޱ��е���������
        List<RolePermission> RolePermissionList = userPermissionMapper.getRolePermissions();
        
        for(RolePermission rp : RolePermissionList) {
 
            array = new ArrayList<>();
            cfg = new SecurityConfig(rp.getRole().getName());
            System.out.println("MyInvo:"+rp.getRole().getName());
            //�˴�ֻ������û������֣���ʵ��������Ӹ���Ȩ�޵���Ϣ���������󷽷���ConfigAttribute�ļ�����ȥ��
            //�˴���ӵ���Ϣ������ΪMyAccessDecisionManager���decide�ĵ�����������
            array.add(cfg);
            //��Ȩ�޵�getUrl() ��Ϊmap��key����ConfigAttribute�ļ�����Ϊ value��
            map.put(rp.getPermission().getUrl(), array);
        }

    }

    //�˷�����Ϊ���ж��û������url �Ƿ���Ȩ�ޱ��У������Ȩ�ޱ��У��򷵻ظ� decide �����������ж��û��Ƿ��д�Ȩ�ޡ��������Ȩ�ޱ�������С�
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        
    	//���map Ϊ�յ���������ȡ���ݿ���Ȩ�ޱ������
    	if(map ==null) loadResourceDefine();
        System.out.println("map is not null");
        //object �а����û������request ��ϢҲ���������URL
        HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
        
        AntPathRequestMatcher matcher;
        String resUrl;
        for(Iterator<String> iter = map.keySet().iterator(); iter.hasNext(); ) {
            resUrl = iter.next();
            
            System.out.println("reqUrl:"+request.getRequestURL());
            matcher = new AntPathRequestMatcher(resUrl);
            System.out.println("matcher:"+matcher);
            if(matcher.matches(request)) {
            
            	System.out.println("ƥ��ɹ�");
                return map.get(resUrl);
            }
            System.out.println("URL����Ȩ�ޱ���");
        }
        //URL����Ȩ�ޱ��� ,����Է���
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
