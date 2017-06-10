import jdk.nashorn.internal.ir.RuntimeNode;

import javax.servlet.http.HttpServletRequest;
import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.mysql.cj.jdbc.Driver;
import sun.plugin.dom.html.HTMLTableCaptionElement;

/**
 * Created by canidmars on 6/9/17.
 */
public class MySQLAdsDao implements Ads {
    @Override
    public List<Ad> all() throws SQLException {

        Config config = new Config();

        DriverManager.registerDriver(new Driver());

        Connection connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUsername(),
                config.getPassword()
        );

//        insert(connection, );
        return select(connection);


    }

    @Override
    public Long insert(Ad ad) {
        return null;
    }



    private void insert(Connection connection, HttpServletRequest request)throws SQLException{
        Statement statement = connection.createStatement();

        String user_id = request.getParameter("user_id");
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        String query = "INSERT INTO ads(user_id, title, description) VALUES";
               query += "(" + user_id + ", " + title + ", " + description + ")";
               statement.execute(query);
    }


    private List<Ad> select(Connection connection) throws SQLException{
        String query = "SELECT * FROM ads";

        Statement stmt = connection.createStatement();

        ResultSet rs = stmt.executeQuery(query);

        List<Ad> ads = new ArrayList<>();

        while (rs.next()) {
            long user_id = rs.getLong("user_id");
            String title = rs.getString("title");
            String description = rs.getString("description");
            Ad a = new Ad(user_id, title, description);
            ads.add(a);
        }
        return ads;

    }

}


