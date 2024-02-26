// 서블릿 초기화 파라미터 - 애노테이션으로 설정하기
package com.eomcs.web.ex06;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


//@WebServlet(value = "/ex06/s4", loadOnStartup = 1)
@SuppressWarnings("serial")
public class Servlet04 extends HttpServlet {


    @Override
    public void init() throws ServletException {
        System.out.println("/ex06/s4 ==> init()");

        ServletConfig config = this.getServletConfig();

        // 이렇게 @WebInitParam()으로 설정된 값을
        // "서블릿 초기화 파라미터"라 부른다.
        String jdbcDriver = config.getInitParameter("jdbc.driver");
        String jdbcUrl = config.getInitParameter("jdbc.url");
        String username = config.getInitParameter("jdbc.username");
        String password = config.getInitParameter("jdbc.password");

        System.out.println(jdbcDriver);
        System.out.println(jdbcUrl);
        System.out.println(username);
        System.out.println(password);

    }
}

