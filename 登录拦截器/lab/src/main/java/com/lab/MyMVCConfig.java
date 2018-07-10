package com.lab;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * 注解@EnableWebMvc：全局接管SpringMVC；实际开发中不推荐这样做。
 * <p>
 * 我们更应该扩展SpringMVC：
 * 1.书写我们自己的配置类并加上@Configuration
 * 2.实现WebMvcConfigurer接口，实现需要扩展的自定义功能。
 * <p>
 * 以下的addCorsMappings方法就是我们扩展的Cors跨域设置。
 */
//@EnableWebMvc
@Configuration
public class MyMVCConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("index");
    }

    /**
     * 从版本4.2开始，Spring MVC 支持CORS。
     * 在Spring Boot应用程序中使用带有 注释的控制器方法CORS配置@CrossOrigin不需要任何特定配置。
     * 可以通过使用自定义方法注册bean 来定义全局CORS配置。
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

    /**
     * 添加拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                //拦截规则
                .addPathPatterns("/**")
                //排除规则，静态资源SpringBoot已经帮我们做了过滤，这里我们不必再写。
                .excludePathPatterns("/index.html", "/", "/login");
    }
}
