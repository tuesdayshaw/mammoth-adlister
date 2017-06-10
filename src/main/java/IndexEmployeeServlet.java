import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by canidmars on 6/10/17.
 */

@WebServlet(name = "IndexEmployeeServlet", urlPatterns = "/employees")
public class IndexEmployeeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            List<Employee> employees = DaoFactory.getEmployeesDao().all();
            request.setAttribute("employees", employees);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/WEB-INF/employees/index.jsp").forward(request, response);
    }

}
