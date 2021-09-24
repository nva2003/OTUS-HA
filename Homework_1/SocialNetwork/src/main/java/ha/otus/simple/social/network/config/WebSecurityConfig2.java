package ha.otus.simple.social.network.config;


import ha.otus.simple.social.network.security.CustomAuthenticationSuccessHandler;
import ha.otus.simple.social.network.security.MyFilterSecurityInterceptor;
import ha.otus.simple.social.network.security.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig2 extends WebSecurityConfigurerAdapter {
/*
    @Autowired
    private MyFilterSecurityInterceptor myFilterSecurityInterceptor;
*/

    private final CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Bean
    UserDetailsService customUserService () {// Регистрация bean-компонента UserDetailsService
        return new UserService();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService (customUserService ()).passwordEncoder(passwordEncoder()); // Проверка службы сведений о пользователе
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // The pages does not require login
        http.authorizeRequests().antMatchers("/", "/login", "/logout").permitAll()
        // Ресурсы доступны всем пользователям
                .antMatchers("/static/* ","/css/**", "/js/**", "/images/**", "/webjars/**", "**/favicon.ico").permitAll()
                .antMatchers("/register").permitAll()
                // Любой URL, который не был найден, должен только аутентифицировать пользователя для доступа
                .anyRequest().authenticated()
        // Config for Login Form
                .and().formLogin()
                // Submit URL of login page.
//                .loginProcessingUrl("/j_spring_security_check") // Submit URL
                // Указываем страницу входа и предоставляем всем пользователям доступ к странице входа
                .loginPage("/login")//
                // Устанавливаем страницу входа по умолчанию для перехода к успеху, ошибка возвращается в интерфейс входа
//                .defaultSuccessUrl("/home")
                .successHandler(customAuthenticationSuccessHandler)
                .failureUrl("/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")
                // Config for Logout Page
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login")
                .and()
                // Включение cookie для сохранения пользовательских данных
                .rememberMe()
                // Устанавливаем срок действия cookie
                .tokenValiditySeconds(60 * 60 * 24 * 7)
                // Устанавливаем закрытый ключ cookie
                .key("security");;


                // springsecurity4 автоматически включает csrf (подделку межсайтовых запросов) конфликтует с restful
        // включаем защиту от CSRF атак
        http.csrf().disable();

        // When the user has logged in as XX.
        // But access a page that requires role YY,
        // AccessDeniedException will be thrown.
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

    }

    // Указываем Spring контейнеру, что надо инициализировать BCryptPasswordEncoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
