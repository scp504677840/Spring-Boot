package com.ll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LlApplication {

    public static void main(String[] args) {
        SpringApplication.run(LlApplication.class, args);
    }
}
/*
MySpringApplicationRunListener#starting...
MySpringApplicationRunListener#environmentPrepared...

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.0.3.RELEASE)

MyApplicationContextInitializer#initialize: org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@338c99c8: startup date [Thu Jan 01 08:00:00 CST 1970]; root of context hierarchy
MySpringApplicationRunListener#contextPrepared: org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@338c99c8: startup date [Thu Jan 01 08:00:00 CST 1970]; root of context hierarchy
2018-07-11 15:50:48.308  INFO 1311 --- [           main] com.ll.LlApplication                     : Starting LlApplication on SCPdeiMac.local with PID 1311 (/Users/scp/Documents/Workspace/Java/ll/out/production/classes started by scp in /Users/scp/Documents/Workspace/Java/ll)
2018-07-11 15:50:48.313  INFO 1311 --- [           main] com.ll.LlApplication                     : No active profile set, falling back to default profiles: default
MySpringApplicationRunListener#contextLoaded: org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@338c99c8: startup date [Thu Jan 01 08:00:00 CST 1970]; root of context hierarchy
2018-07-11 15:50:48.359  INFO 1311 --- [           main] ConfigServletWebServerApplicationContext : Refreshing org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@338c99c8: startup date [Wed Jul 11 15:50:48 CST 2018]; root of context hierarchy
WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by org.springframework.cglib.core.ReflectUtils$1 (file:/Applications/Soft/Gradle/caches/modules-2/files-2.1/org.springframework/spring-core/5.0.7.RELEASE/54b731178d81e66eca9623df772ff32718208137/spring-core-5.0.7.RELEASE.jar) to method java.lang.ClassLoader.defineClass(java.lang.String,byte[],int,int,java.security.ProtectionDomain)
WARNING: Please consider reporting this to the maintainers of org.springframework.cglib.core.ReflectUtils$1
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
2018-07-11 15:50:49.391  INFO 1311 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2018-07-11 15:50:49.419  INFO 1311 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2018-07-11 15:50:49.419  INFO 1311 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet Engine: Apache Tomcat/8.5.31
2018-07-11 15:50:49.424  INFO 1311 --- [ost-startStop-1] o.a.catalina.core.AprLifecycleListener   : The APR based Apache Tomcat Native library which allows optimal performance in production environments was not found on the java.library.path: [/Users/scp/Library/Java/Extensions:/Library/Java/Extensions:/Network/Library/Java/Extensions:/System/Library/Java/Extensions:/usr/lib/java:.]
2018-07-11 15:50:49.502  INFO 1311 --- [ost-startStop-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2018-07-11 15:50:49.502  INFO 1311 --- [ost-startStop-1] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 1143 ms
2018-07-11 15:50:49.620  INFO 1311 --- [ost-startStop-1] o.s.b.w.servlet.ServletRegistrationBean  : Servlet dispatcherServlet mapped to [/]
2018-07-11 15:50:49.624  INFO 1311 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'characterEncodingFilter' to: [/*]
2018-07-11 15:50:49.625  INFO 1311 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'hiddenHttpMethodFilter' to: [/*]
2018-07-11 15:50:49.625  INFO 1311 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'httpPutFormContentFilter' to: [/*]
2018-07-11 15:50:49.625  INFO 1311 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'requestContextFilter' to: [/*]
2018-07-11 15:50:49.751  INFO 1311 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**/favicon.ico] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
        2018-07-11 15:50:50.008  INFO 1311 --- [           main] s.w.s.m.m.a.RequestMappingHandlerAdapter : Looking for @ControllerAdvice: org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@338c99c8: startup date [Wed Jul 11 15:50:48 CST 2018]; root of context hierarchy
        2018-07-11 15:50:50.071  INFO 1311 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error]}" onto public org.springframework.http.ResponseEntity<java.util.Map<java.lang.String, java.lang.Object>> org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController.error(javax.servlet.http.HttpServletRequest)
        2018-07-11 15:50:50.073  INFO 1311 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error],produces=[text/html]}" onto public org.springframework.web.servlet.ModelAndView org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController.errorHtml(javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse)
        2018-07-11 15:50:50.094  INFO 1311 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/webjars/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
 2018-07-11 15:50:50.095  INFO 1311 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
 2018-07-11 15:50:50.243  INFO 1311 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
 2018-07-11 15:50:50.285  INFO 1311 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
 2018-07-11 15:50:50.292  INFO 1311 --- [           main] com.ll.LlApplication                     : Started LlApplication in 2.387 seconds (JVM running for 8.375)
 MySpringApplicationRunListener#started: org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@338c99c8: startup date [Wed Jul 11 15:50:48 CST 2018]; root of context hierarchy
 MySpringApplicationRunListener#running: org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@338c99c8: startup date [Wed Jul 11 15:50:48 CST 2018]; root of context hierarchy
 */
