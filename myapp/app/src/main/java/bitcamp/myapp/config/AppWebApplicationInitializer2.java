package bitcamp.myapp.config;

import java.io.File;
import java.util.EnumSet;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

// 참고용 백업2
public class AppWebApplicationInitializer2 /*extends AbstractContextLoaderInitializer*/ {

    AnnotationConfigWebApplicationContext rootContext;

    //    @Override
    protected WebApplicationContext createRootApplicationContext() {
        // IOC 컨테이너 준비
        rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(RootConfig.class);
        rootContext.refresh();
        return rootContext;
    }

    //    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // 수퍼 클래스의 onStartup에서 ContextLoaderListener를 생성하기 때문에
        // 기존의 기능을 그대로 수행하도록 수퍼 클래스의 메소드를 호출.
//        super.onStartup(servletContext);

        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(AppConfig.class);
        appContext.setParent(this.rootContext);
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
