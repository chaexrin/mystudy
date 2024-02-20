package bitcamp.myapp.listener;

import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.dao.AttachedFileDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.dao.mysql.AssignmentDaoImpl;
import bitcamp.myapp.dao.mysql.AttachedFileDaoImpl;
import bitcamp.myapp.dao.mysql.BoardDaoImpl;
import bitcamp.myapp.dao.mysql.MemberDaoImpl;
import bitcamp.util.DBConnectionPool;
import bitcamp.util.TransactionManager;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextLoaderListener implements ServletContextListener {
    // 웹 애플리케이션이 사용할 자원을 준비시키고 해제시키는 역할


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("웹애플리케이션 자원 준비!");
        DBConnectionPool connectionPool = new DBConnectionPool(
            "jdbc:mysql://localhost/studydb", "study", "bitcamp!@#123");
        AssignmentDao assignmentDao = new AssignmentDaoImpl(connectionPool);
        MemberDao memberDao = new MemberDaoImpl(connectionPool);
        BoardDao boardDao = new BoardDaoImpl(connectionPool);
        AttachedFileDao attachedFileDao = new AttachedFileDaoImpl(connectionPool);
        TransactionManager txManager = new TransactionManager(connectionPool);

        ServletContext 웹애플리케이션저장소 = sce.getServletContext();
        웹애플리케이션저장소.setAttribute("assignmentDao", assignmentDao);
        웹애플리케이션저장소.setAttribute("memberDao", memberDao);
        웹애플리케이션저장소.setAttribute("boardDao", boardDao);
        웹애플리케이션저장소.setAttribute("attachedFileDao", attachedFileDao);
        웹애플리케이션저장소.setAttribute("txManager", txManager);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("웹애플리케이션 자원 해제!");
    }
}
