package ha.otus.simple.social.network.security;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Iterator;

@Service
public class MyAccessDecisionManager implements AccessDecisionManager {

    // Метод решения - это метод принятия решения, чтобы определить, иметь ли разрешение,
    // аутентификация предназначена для объяснения сбора информации об авторизации, циклически добавляемой к объекту GrantedAuthority в CustomUserService.
    // объект содержит необходимую информацию о запросе, инициированном клиентом, который может быть преобразован в HttpServletRequest request = ((FilterInvocation) object) .getHttpRequest ();
    // configAttributes - это результат, возвращаемый методом getAttributes (Object object) MyInvocationSecurityMetadataSource. Этот метод предназначен для определения того, находится ли URL-адрес, запрошенный пользователем, в таблице разрешений. Если он находится в таблице разрешений, он возвращается в метод решения, чтобы определить, есть ли у пользователя Это разрешение. Если его нет в таблице разрешений, он будет выпущен.
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {

        if(null== configAttributes || configAttributes.size() <=0) {
            return;
        }
        ConfigAttribute c;
        String needRole;
        for(Iterator<ConfigAttribute> iter = configAttributes.iterator(); iter.hasNext(); ) {
            c = iter.next();
            needRole = c.getAttribute();
            for (GrantedAuthority ga: authentication.getAuthorities ()) {// аутентификация - это набор информации об авторизации, который циклически добавляется к объекту GrantedAuthority в Примечании 1
                if(needRole.trim().equals(ga.getAuthority())) {
                    return;
                }
            }
        }
        throw new AccessDeniedException("no right");
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
