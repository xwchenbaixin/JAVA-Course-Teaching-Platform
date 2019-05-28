package com.jctp.service.permission;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Iterator;


@Service("myAccessDecisionManager")
public class MyAccessDecisionManager implements AccessDecisionManager {

    // decide �������ж��Ƿ�ӵ��Ȩ�޵ľ��߷�����
    // authentication ����CustomUserService��ѭ����ӵ� GrantedAuthority �����е�Ȩ����Ϣ����.
    // object �����ͻ��˷���������requset��Ϣ����ת��Ϊ HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
    // configAttributes ΪMyInvocationSecurityMetadataSource��getAttributes(Object object)����������صĽ�����˷�����Ϊ���ж��û������url �Ƿ���Ȩ�ޱ��У������Ȩ�ޱ��У��򷵻ظ� decide �����������ж��û��Ƿ��д�Ȩ�ޡ��������Ȩ�ޱ�������С�
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {

        if(null== configAttributes || configAttributes.size() <=0) {
            return;
        }
        ConfigAttribute c;
        
        String needRole;
        //������URL������Ȩ��
        for(Iterator<ConfigAttribute> iter = configAttributes.iterator(); iter.hasNext(); ) {
            c = iter.next();
            //��ȡ��ɫ����
            needRole = c.getAttribute();
            System.out.println("deciCf:"+c.getAttribute());
            //authentication ���� UserPermissionService ��ŵ�Ȩ�޼��ϣ�Ȩ�޸���Role����ȡ����ŵ���RoleName
            for(GrantedAuthority ga : authentication.getAuthorities()) {
            	//��������URL�а������û���Ȩ�ޣ����������ʣ�µ�����
            	System.out.println("deci:"+ga.getAuthority());
            	System.out.println("needRole:"+needRole);
                if(needRole.trim().equals(ga.getAuthority())) {
                    return;
                }
            }
        }
        //���������еĵ�Ȩ���Ժ���û�������Ȩ�ޡ�
        System.out.println("no Right");
        throw new AccessDeniedException("No Right");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}