package ha.otus.simple.social.network.security;


import ha.otus.simple.social.network.mapper.UserMapper;
import ha.otus.simple.social.network.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {// Пользовательский интерфейс UserDetailsService

    @Autowired
    UserMapper userMapper;
    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername (String username) {// Перепишите метод loadUserByUsername для получения пользователей типа userdetails

        SysUser user = userMapper.findByUserName(username);
//        user.setPassword(passwordEncoder.encode(user.getPassword()));

        if (user != null) {
//            List<Permission> permissions = permissionDao.findByAdminUserId(user.getId());
            List<GrantedAuthority> grantedAuthorities = new ArrayList <>();
/*
            for (Permission permission : permissions) {
                if (permission != null && permission.getName()!=null) {

                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getName());
                    // 1: здесь информация об авторизации добавляется к объекту GrantedAuthority, а объект GrantedAuthority будет использоваться для полной проверки авторизации позже.
                    grantedAuthorities.add(grantedAuthority);
                }
            }
*/
            return new User(user.getUserName(), user.getPassword(), grantedAuthorities);
        } else {
            throw new UsernameNotFoundException("admin: " + username + " do not exist!");
        }
    }


}
