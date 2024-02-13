package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.Board;
import bitcamp.util.DBConnectionPool;
import bitcamp.util.Prompt;
import java.sql.Connection;

public class BoardModifyHandler extends AbstractMenuHandler {

    private DBConnectionPool connectionPool;
    private BoardDao boardDao;

    public BoardModifyHandler(DBConnectionPool connectionPool, BoardDao boardDao) {
        this.connectionPool = connectionPool;
        this.boardDao = boardDao;
    }

    @Override
    protected void action(Prompt prompt) {
        Connection con = null;
        try {
            con = connectionPool.getConnection();
            int no = prompt.inputInt("번호? ");

            Board oldBoard = boardDao.findBy(no);
            if (oldBoard == null) {
                prompt.println("게시글 번호가 유효하지 않습니다.");
                return;
            }

            Board board = new Board();
            board.setNo(oldBoard.getNo()); // 기존 게시글의 번호를 그대로 설정한다.
            board.setTitle(prompt.input("제목(%s)? ", oldBoard.getTitle()));
            board.setContent(prompt.input("내용(%s)? ", oldBoard.getContent()));
            board.setWriter(prompt.input("작성자(%s)? ", oldBoard.getWriter()));
            board.setCreatedDate(oldBoard.getCreatedDate());

            boardDao.update(board);
            prompt.println("게시글을 변경했습니다.");
        } catch (NumberFormatException e) {
            prompt.println("숫자를 입력하세요!");

        } catch (IllegalArgumentException e) {
            prompt.println("과제 변경 오류!");
            prompt.println("다시 시도 하세요.");

        } catch (Exception e) {
            prompt.println("실행 오류!");
            e.printStackTrace();
        } finally {
            connectionPool.returnConnection(con);
        }
    }
}