package c.hw;

import c.hw.dao.ReservationDao;
import c.hw.dao.mysql.ReservationDaoImpl;
import c.menu.MenuGroup;
import c.util.Prompt;
import c.hw.rsrv.*;
import c.hw.vo.HelpHandler;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;

public class App {
    ReservationDao reservationDao;
    MenuGroup mainMenu;
    Socket socket;
    DataInputStream in;
    DataOutputStream out;

    Prompt prompt = new Prompt(System.in);


    App() {
        prepareDatabase();
        prepareMenu();
    }

    public static void main(String[] args) {
        System.out.println("[식당 예약 관리 시스템]");
        new App().run();
    }

    void prepareDatabase() {
        try {
            // JVM이 JDBC 드라이버 파일(.jar)에 설정된대로 자동으로 처리한다.
//            Driver driver = new com.mysql.jdbc.Driver();
//            DriverManager.registerDriver(driver);
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://db-ld27p-kr.vpc-pub-cdb.ntruss.com/studydb", "study",
                "bitcamp!@#123");

//            "jdbc:mysql://localhost/studydb", "study",
//                "bitcamp!@#123"

            reservationDao = new ReservationDaoImpl(con);


        } catch (Exception e) {
            System.out.println("통신 오류!");
            e.printStackTrace();
        }
    }

    void prepareMenu() {
        mainMenu = MenuGroup.getInstance("메인");

        MenuGroup boardMenu = mainMenu.addGroup("예약");
        boardMenu.addItem("등록", new ReservationAddHandler(reservationDao, prompt));
        boardMenu.addItem("조회", new ReservationViewHandler(reservationDao, prompt));
        boardMenu.addItem("변경", new ReservationModifyHandler(reservationDao, prompt));
        boardMenu.addItem("삭제", new ReservationDeleteHandler(reservationDao, prompt));
        boardMenu.addItem("목록", new ReservationListHandler(reservationDao, prompt));


        mainMenu.addItem("도움말", new HelpHandler(prompt));
    }

    void run() {
        while (true) {
            try {
                mainMenu.execute(prompt);
                prompt.close();

                break;
            } catch (Exception e) {
                System.out.println("예외 발생!");
            }
        }
    }

    void close() {
        try (Socket socket = this.socket;
            DataInputStream in = this.in;
            DataOutputStream out = this.out;) {

            out.writeUTF("quit");
            System.out.println(in.readUTF());

        } catch (Exception e) {
            // 서버와 연결을 끊는 과정에서 예외가 발생한 경우 무시.
            // 왜? 따로 처리할 것이 없다.
        }

    }


}
