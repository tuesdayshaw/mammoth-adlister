import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by canidmars on 6/10/17.
 */

@WebServlet(name = "CreateEmployeeServlet", urlPatterns = "/employees/create")
public class CreateEmployeeServlet extends HttpServlet  {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/employees/create.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Employee employee = new Employee(
                request.getParameter("birth_date"),
                request.getParameter("first_name"),
                request.getParameter("last_name"),
                request.getParameter("gender"),
                request.getParameter("hire_date")
        );

        try {
            long id = DaoFactory.getEmployeesDao().insert(employee);
            System.out.println(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/employees");
    }
}
