package bitcamp.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebApplicationInitializerImpl implements WebApplicationInitializer {

    private static Log log = LogFactory.getLog(WebApplicationInitializerImpl.class);

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        log.debug("WebApplicationInitializerImpl onStartup() 실행!");

        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(RootConfig.class);
        rootContext.refresh();

        ContextLoaderListener listener = new ContextLoaderListener(rootContext);
        servletContext.addListener(listener);

        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.setParent(rootContext);
        appContext.register(AppConfig.class);
        appContext.refresh();

        Dynamic appServletRegistration = servletContext.addServlet("app", new DispatcherServlet(appContext));
        appServletRegistration.addMapping("/app/*");
        appServletRegistration.setLoadOnStartup(1);

        AnnotationConfigWebApplicationContext adminContext = new AnnotationConfigWebApplicationContext();
        adminContext.setParent(rootContext);
        adminContext.register(AdminConfig.class);
        adminContext.refresh();

        Dynamic adminServletRegistration = servletContext.addServlet("admin", new DispatcherServlet(adminContext));
        adminServletRegistration.addMapping("/admin/*");
        adminServletRegistration.setLoadOnStartup(1);
    }
}
