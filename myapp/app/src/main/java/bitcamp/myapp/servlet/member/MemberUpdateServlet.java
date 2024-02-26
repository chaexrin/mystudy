package bitcamp.myapp.servlet.member;

import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;
import java.io.IOException;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
@WebServlet("/member/update")
public class MemberUpdateServlet extends HttpServlet {

    private MemberDao memberDao;
    private String uploadDir;

    @Override
    public void init() {
        this.memberDao = (MemberDao) this.getServletContext().getAttribute("memberDao");
        uploadDir = this.getServletContext().getRealPath("/upload");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        try {
            request.setCharacterEncoding("UTF-8");
            int no = Integer.parseInt(request.getParameter("no"));

            Member old = memberDao.findBy(no);
            if (old == null) {
                throw new Exception("<p>회원 번호가 유효하지 않습니다.</p>");
            }

            Member member = new Member();
            member.setNo(old.getNo());
            member.setEmail(request.getParameter("email"));
            member.setName(request.getParameter("name"));
            member.setPassword(request.getParameter("password"));
            member.setCreatedDate(old.getCreatedDate());

            memberDao.update(member);
            response.sendRedirect("/member/list");

            Part photoPart = request.getPart("photo");
            if (photoPart.getSize() > 0) {
                String filename = UUID.randomUUID().toString();
                member.setPhoto(filename);
                photoPart.write(this.uploadDir + "/" + filename);
            } else {
                member.setPhoto(old.getPhoto());
            }


        } catch (Exception e) {
            request.setAttribute("message", "변경 오류!");
            request.setAttribute("exception", e);
            request.getRequestDispatcher("/error").forward(request, response);
        }

    }
}
