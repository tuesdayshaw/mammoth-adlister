
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.mysql.cj.jdbc.Driver;


/**
 * Created by canidmars on 6/9/17.
 */

public class MySQLAdsDao implements Ads{

    private Connection connection;

    public MySQLAdsDao(Config config) throws SQLException {
        //Configuring a connection to mySQL database

        config = new Config();

        DriverManager.registerDriver(new Driver());

        connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUsername(),
                config.getPassword()
        );
    }

    @Override
    public List<Ad> all() throws SQLException {
        return selectAds(connection);
    }

    private List<Ad> selectAds(Connection connection) throws SQLException {
        List<Ad> ads = new ArrayList<>();

        String query = "SELECT * FROM ads";

        Statement stmt = connection.createStatement();

        ResultSet rs = stmt.executeQuery(query);

        while(rs.next()) {
            int userId = rs.getInt("user_id");
            String adTitle = rs.getString("title");
            String adDescription = rs.getString("description");
            Ad a = new Ad(userId, adTitle, adDescription);
            ads.add(a);
        }
        return ads;
    }

    @Override
    public Long insert(Ad ad) {
        Statement stmt = connection.createStatement();

        String query = "INSERT INTO ads(user_id, title, description) VALUES";
        query += "(" + user_id + ", '" + title + "', '" + description + "')";
        System.out.println(query);
        stmt.execute(query);

        return null;
    }



}