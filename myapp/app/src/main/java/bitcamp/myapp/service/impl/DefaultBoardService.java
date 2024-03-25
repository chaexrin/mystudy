package bitcamp.myapp.service.impl;

import bitcamp.myapp.dao.AttachedFileDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.service.BoardService;
import bitcamp.myapp.vo.AttachedFile;
import bitcamp.myapp.vo.Board;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefaultBoardService implements BoardService {

    private BoardDao boardDao;
    private AttachedFileDao attachedFileDao;

    public DefaultBoardService(BoardDao boardDao, AttachedFileDao attachedFileDao) {
        this.boardDao = boardDao;
        this.attachedFileDao = attachedFileDao;
    }

    @Transactional
    @Override
    public void add(Board board) {
        boardDao.add(board);
        if (board.getFiles() != null) {
            for (AttachedFile attachedFile : board.getFiles()) {
                attachedFile.setBoardNo(board.getNo());
            }
            attachedFileDao.addAll(board.getFiles());
        }
    }

    // 일관성을 위해
    // 컨트롤러는 dao를 직접 쓰지 않고 서비스객체를 이용해서 사용.
    @Override
    public List<Board> list(int category) {
        return boardDao.findAll(category);
    }

    public Board get(int no) {
        return boardDao.findBy(no);
    }

    @Transactional
    @Override
    public int update(Board board) {
        int count = boardDao.update(board);

        if (board.getFiles() != null) {
            for (AttachedFile attachedFile : board.getFiles()) {
                attachedFile.setBoardNo(board.getNo());
            }
            attachedFileDao.addAll(board.getFiles());
        }
        return count;
    }

    @Transactional // 첨부파일 지웠다가 게시글 지우는거 실패하면 첨부파일 지웠던거 취소해야하기 때문에
    @Override
    public int delete(int no) {
        attachedFileDao.deleteAll(no);
        return boardDao.delete(no);
    }

    @Override
    public List<AttachedFile> getAttachedFiles(int no) {
        return attachedFileDao.findAllByBoardNo(no);
    }

    @Override
    public AttachedFile getAttachedFile(int fileNo) {
        return attachedFileDao.findByNo(fileNo);
    }

    @Override
    public int deleteAttachedFile(int fileNo) {
        return attachedFileDao.delete(fileNo);
    }
}
