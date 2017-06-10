import java.sql.SQLException;
import java.util.List;

/**
 * Created by canidmars on 6/10/17.
 */
public interface Employees {

    //get a list for all the employees
    List<Employee> all() throws SQLException;

    //get a single employee for their own profile page
    List<Employee> singleEmployee() throws SQLException;

    //insert a new employee and return their id#
    Long insert(Employee employee) throws SQLException;
}
