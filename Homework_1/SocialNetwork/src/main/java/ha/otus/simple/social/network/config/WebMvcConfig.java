package ha.otus.simple.social.network.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /*
        * If you put your css in the static folder, you dont need the addResourceHandlers method.
        * */
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
//        registry.addResourceHandler("/css/**").addResourceLocations("/css/", "/static/css/");
//        registry.addResourceHandler("/css/**").addResourceLocations("/static/css/");
//        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/css/");
//        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
//        registry.addResourceHandler("/img/**").addResourceLocations("/img/");
    }

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");

        registry.addViewController("/login").setViewName("login");

    }
}
