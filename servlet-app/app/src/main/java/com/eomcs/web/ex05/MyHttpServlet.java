package com.eomcs.web.ex05;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 추상클래스 -> 서브클래스에 기능을 물려주기 위해서 만든 클래스
public abstract class MyHttpServlet extends GenericServlet {

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse)
        throws ServletException, IOException {
        service((HttpServletRequest) servletRequest, (HttpServletResponse) servletResponse);
    }

    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    }


}
