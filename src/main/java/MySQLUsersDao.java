import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by canidmars on 6/12/17.
 */
public class MySQLUsersDao implements Users {

    private Connection connection;

    public MySQLUsersDao(Config config) throws SQLException {
        DriverManager.registerDriver(new Driver());

        connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUsername(),
                config.getPassword()
        );
    }

    @Override
    public List<User> all() throws SQLException {
        List<User> users = new ArrayList<>();

        String query = "SELECT * FROM users";

        Statement stmt = connection.createStatement();

        ResultSet rs = stmt.executeQuery(query);

        while(rs.next()) {
            String username = rs.getString("username");
            String email = rs.getString("email");
            String password = rs.getString("password");
            User u = new User(username, email, password);
            users.add(u);
        }
        return users;

    }

    @Override
    public Long insert(User user) throws SQLException {
        Statement stmt = connection.createStatement();
        Long id = null;

        String query = "INSERT INTO users(username, email, password) VALUES";
        query += "(" + user.getUsername() + ", '" + user.getEmail() + "', '" + user.getPassword() + "')";

        stmt.execute(query, Statement.RETURN_GENERATED_KEYS);

        ResultSet rs = stmt.getGeneratedKeys();
        if(rs.next()){
            id = rs.getLong(1);
        }

        return id;
    }
}
