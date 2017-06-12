
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.mysql.cj.jdbc.Driver;

import static com.sun.tools.doclets.formats.html.markup.HtmlStyle.title;


/**
 * Created by canidmars on 6/9/17.
 */

public class MySQLAdsDao implements Ads{

    private Connection connection;

    public MySQLAdsDao(Config config) throws SQLException {
        //Configuring a connection to mySQL database

//        config = new Config();

        DriverManager.registerDriver(new Driver());

        connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUsername(),
                config.getPassword()
        );
    }

    @Override
    public List<Ad> all() throws SQLException {
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
    public Long insert(Ad ad) throws SQLException {
        Statement stmt = connection.createStatement();
        Long id = null;

        String query = "INSERT INTO ads(user_id, title, description) VALUES";
        query += "(" + ad.getUserId() + ", '" + ad.getTitle() + "', '" + ad.getDescription() + "')";

        stmt.execute(query, Statement.RETURN_GENERATED_KEYS);

        ResultSet rs = stmt.getGeneratedKeys();
        if(rs.next()){
            id = rs.getLong(1);
        }

        return id;
    }



}