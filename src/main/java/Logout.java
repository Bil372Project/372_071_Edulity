import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/logout"})
public class Logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("id",null);
        session.setAttribute("type",null);
        session.setAttribute("school_name",null);
        session.setAttribute("student",null);
        session.setAttribute("teacher", null);
        session.setAttribute("hod", null);
        session.setAttribute("parent_id",null);
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
