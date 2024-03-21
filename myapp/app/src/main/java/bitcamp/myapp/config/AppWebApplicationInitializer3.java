package bitcamp.myapp.config;

import java.io.File;
import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

// 참고용 AbstractDispatcherServletInitializer
public class AppWebApplicationInitializer3 /*extends AbstractDispatcherServletInitializer*/ {

    ServletContext servletContext;
    AnnotationConfigWebApplicationContext rootContext;

    //    @Override
    protected WebApplicationContext createRootApplicationContext() {
        // IOC 컨테이너 준비
        rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(RootConfig.class);
        rootContext.refresh();
        return rootContext;
    }

    // DISPATCHER SERVLET이 사용할 서블릿 컨테이너 준비..
//    @Override
    protected WebApplicationContext createServletApplicationContext() {
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(AppConfig.class);
        appContext.setParent(this.rootContext);
        appContext.setServletContext(this.servletContext);
        appContext.refresh();
        return appContext;
    }

    //    @Override
    protected String[] getServletMappings() {
        return new String[]{"/app/*"};
    }

    //    @Override
    protected void customizeRegistration(Dynamic registration) {
        registration.setMultipartConfig(new MultipartConfigElement(
            new File("./temp").getAbsolutePath(),
//            new File(System.getProperty("java.io.tmpdir")).getAbsolutePath(),
            1024 * 1024 * 10,
            1024 * 1024 * 100,
            1024 * 1024 * 1
        ));
    }

    //    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{new CharacterEncodingFilter("UTF-8")};
    }

    //    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        this.servletContext = servletContext;
//        super.onStartup(servletContext);
    }
}
