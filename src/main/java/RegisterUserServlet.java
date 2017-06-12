import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by canidmars on 6/12/17.
 */

@WebServlet(name = "RegisterUserServlet", urlPatterns = "/register")
public class RegisterUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        User user = new User(
//                1, // for now we'll hardcode the user id
                request.getParameter("username"),
                request.getParameter("email"),
                request.getParameter("password")
        );

        try {
            long id = DaoFactory.getUsersDao().insert(user);
            System.out.println(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/login");


    }

}
