package bitcamp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

@ComponentScan(
    value = "bitcamp.app1")

//   <context:component-scan base-package="bitcamp.web">
//    <context:exclude-filter type="regex" expression="bitcamp.web.app.*"/>
//  </context:component-scan>
public class App1Config {

    @Bean
    MultipartResolver multipartResolver() {
        StandardServletMultipartResolver mr = new StandardServletMultipartResolver();
        return mr;
    }
}
