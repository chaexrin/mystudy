package bitcamp.myapp.config;

import java.io.File;
import java.util.EnumSet;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

// 참고용으로 백업함.
public class AppWebApplicationInitializer1 /*implements WebApplicationInitializer*/ {

    //    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
// IOC 컨테이너 준비
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(RootConfig.class);
        rootContext.refresh();
        rootContext.setServletContext(servletContext);
// Ioc 컨테이너를 가지고 컨텍스트로드 리스너로 서블릿 등록
        servletContext.addListener(new ContextLoaderListener(rootContext));

        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(AppConfig.class);
        appContext.setParent(rootContext);
        appContext.setServletContext(servletContext);
        appContext.refresh();

        Dynamic registration = servletContext.addServlet("app", new DispatcherServlet(appContext));
        registration.addMapping("/app/*");
        registration.setLoadOnStartup(1);
        registration.setMultipartConfig(new MultipartConfigElement(
            new File("./temp").getAbsolutePath(),
//            new File(System.getProperty("java.io.tmpdir")).getAbsolutePath(),
            1024 * 1024 * 10,
            1024 * 1024 * 100,
            1024 * 1024 * 1
        ));

        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("UTF-8");
        FilterRegistration.Dynamic filterRegistration =
            servletContext.addFilter("characterEncodingFilter", characterEncodingFilter);
        filterRegistration.addMappingForServletNames(
            EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE),
            false,
            new String[]{"app"}
        );

    }
}
