package bitcamp.myapp.listener;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@WebListener
public class ContextLoaderListener implements ServletContextListener {
    // 웹 애플리케이션이 사용할 자원을 준비시키고 해제시키는 역할


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("웹애플리케이션 자원 준비!");

        Map<String, Object> beanMap = new HashMap<>();

        try {
            // 공유 객체를 보관할 ApplicationContext 객체준비
            ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "config/application-context.xml");

            // 서블릿에서 사용할 수 있도록 웹 애플리케이션 보관소에 저장
            ServletContext 웹애플리케이션저장소 = sce.getServletContext();
            웹애플리케이션저장소.setAttribute("applicationContext", ctx);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("웹애플리케이션 자원 해제!");
    }
}
