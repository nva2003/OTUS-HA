package ha.otus.simple.social.network.config;


import ha.otus.simple.social.network.security.MyFilterSecurityInterceptor;
import ha.otus.simple.social.network.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig2 extends WebSecurityConfigurerAdapter {
/*
    @Autowired
    private MyFilterSecurityInterceptor myFilterSecurityInterceptor;
*/

    @Bean
    UserDetailsService customUserService () {// Регистрация bean-компонента UserDetailsService
        return new UserService();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService (customUserService ()); // Проверка службы сведений о пользователе

    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // // http.authorizeRequests () Каждое сопоставление рассматривается в том порядке, в котором они объявлены.
        http
                .authorizeRequests()
                // Ресурсы доступны всем пользователям
                .antMatchers("/css/**", "/js/**", "/images/**", "/webjars/**", "**/favicon.ico").permitAll()
                .antMatchers("/register").permitAll()
                // Ресурсы, к которым может получить доступ только ROLE_USER
                .antMatchers("/user/**").hasRole("USER")
                // Любой URL, который не был найден, должен только аутентифицировать пользователя для доступа
                .anyRequest().authenticated()
                .and()
                .formLogin()
                // Указываем страницу входа и предоставляем всем пользователям доступ к странице входа
                .loginPage("/login")
                // Устанавливаем страницу входа по умолчанию для перехода к успеху, ошибка возвращается в интерфейс входа
                .defaultSuccessUrl("/index").failureUrl("/login?error").permitAll()
                .and()
                // Включение cookie для сохранения пользовательских данных
                .rememberMe()
                // Устанавливаем срок действия cookie
                .tokenValiditySeconds(60 * 60 * 24 * 7)
                // Устанавливаем закрытый ключ cookie
                .key("security")
                .and()
                .logout()
                .permitAll();
        // Вход в перехватчик
//        http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class);
                // springsecurity4 автоматически включает csrf (подделку межсайтовых запросов) конфликтует с restful
        // включаем защиту от CSRF атак
        http.csrf().disable();
    }

}
