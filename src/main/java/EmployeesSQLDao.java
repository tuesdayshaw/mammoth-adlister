import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by canidmars on 6/10/17.
 */
public class EmployeesSQLDao implements Employees {

    private Connection connection;

    public EmployeesSQLDao(Config2 config2) throws SQLException {

        config2 = new Config2();

        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

        connection = DriverManager.getConnection(
                config2.getUrl2(),
                config2.getUsername2(),
                config2.getPassword2()
        );

    }

    @Override
    public List<Employee> all() throws SQLException {

        //new list to store our pulled info from database
        List<Employee> employees = new ArrayList<>();

        //setting up our mysql communication query
        String query = "SELECT * FROM employees";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);

        //search through db for all details until you are at the end of the db
        while (rs.next()){
             long emp_no = rs.getLong("emp_no");
             String birth_date = rs.getString("birth_date");
             String first_name = rs.getString("first_name");
             String last_name = rs.getString("last_name");
             String gender = rs.getString("gender");
             String hire_date = rs.getString("hire_date");

             //create a new instance of an employee from all these retrieved details and save to the
             //list object we created above
             Employee employee = new Employee(emp_no, birth_date, first_name, last_name, gender, hire_date);
             employees.add(employee);

        }
        return employees;
    }

    @Override
    public List<Employee> singleEmployee() throws SQLException {
        return null;
    }

    @Override
    public Long insert(Employee employee) throws SQLException {

        //setting up the connect to state to mysql we want to add an employee and return their unique id
        Statement statement = connection.createStatement();
        Long id = null;

        String query = "INSERT INTO employees(birth_date, first_name, last_name, gender, hire_date) VALUES";
        query += "(" + employee.getBirth_date() + ", '" + employee.getFirst_name() + "', '" + employee.getLast_name() + "', '" + employee.getGender() + "', '" + employee.getHire_date() + "')";

        statement.execute(query, Statement.RETURN_GENERATED_KEYS);

        ResultSet rs = statement.getGeneratedKeys();
        if(rs.next()){
            id = rs.getLong(1);
        }

        return id;
    }
}
