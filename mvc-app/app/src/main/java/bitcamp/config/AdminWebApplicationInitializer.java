package bitcamp.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FrameworkServlet;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

public class AdminWebApplicationInitializer extends AbstractDispatcherServletInitializer {
// AbstractDispatcherServletInitializer => DispatcherServlet 하나밖에 생성 못함.
    
    private static Log log = LogFactory.getLog(AdminWebApplicationInitializer.class);
    AnnotationConfigWebApplicationContext rootContext;

    @Override
    protected WebApplicationContext createRootApplicationContext() {
        rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(RootConfig.class);
        rootContext.refresh();
        return rootContext;
    }


    @Override
    protected WebApplicationContext createServletApplicationContext() {
        AnnotationConfigWebApplicationContext adminContext = new AnnotationConfigWebApplicationContext();
        adminContext.setParent(rootContext);
        adminContext.register(AdminConfig.class);
        adminContext.refresh();
        return adminContext;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/admin/*"};
    }

    @Override
    protected String getServletName() {
        return "admin";
    }


}
