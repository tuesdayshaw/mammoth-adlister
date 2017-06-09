
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.mysql.cj.jdbc.Driver;


/**
 * Created by canidmars on 6/9/17.
 */

public class MySQLAdsDao implements Ads{


    @Override
    public List<Ad> all() throws SQLException {

        //Configuring a connection to mySQL database

        Config config = new Config();

        Connection connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUsername(),
                config.getPassword()
        );






        return null;
    }

    @Override
    public Long insert(Ad ad) {
        return null;
    }



}