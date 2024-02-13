package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.Board;
import bitcamp.util.DBConnectionPool;
import bitcamp.util.Prompt;
import java.sql.Connection;

public class BoardAddHandler extends AbstractMenuHandler {

    DBConnectionPool connectionPool;
    private BoardDao boardDao;

    public BoardAddHandler(DBConnectionPool connectionPool, BoardDao boardDao) {
        this.connectionPool = connectionPool;
        this.boardDao = boardDao;
    }

    @Override
    protected void action(Prompt prompt) {
        Connection con = null;

        try {
            Board board = new Board();
            board.setTitle(prompt.input("제목? "));
            board.setContent(prompt.input("내용? "));
            board.setWriter(prompt.input("작성자? "));

            con = connectionPool.getConnection();
            con.setAutoCommit(false);

            boardDao.add(board);
            boardDao.add(board);

            Thread.sleep(10000);

            boardDao.add(board);

            con.commit();

        } catch (Exception e) {
            prompt.println("과제 입력 중 오류 발생!");
            prompt.println("다시 시도하시기 바랍니다.");
        } finally {
            // Connection은 다른 작업할 때 다시 사용해야 하기 때문에 원래 상태로 되돌림.
            try {
                con.setAutoCommit(true);
            } catch (Exception e) {
            }

            connectionPool.returnConnection(con);
        }

    }
}
