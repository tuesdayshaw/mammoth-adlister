import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by canidmars on 6/9/17.
 */
public class JDBCexercise {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Config config = new Config();

        Connection connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUsername(),
                config.getPassword()
        );

        insertExample(connection);

        List<Ad> ads = selectExample(connection);

        for(Ad ad : ads) {
            System.out.println(ad.getUserId());
            System.out.println(ad.getTitle());
            System.out.println(ad.getDescription());
        }
    }


    public static void insertExample(Connection connection) throws SQLException {
        Statement stmt = connection.createStatement();
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter your user id: ");
        int user_id = scan.nextInt();

        System.out.println("Enter the title: ");
        String title = scan.nextLine();

        System.out.println("Enter a description: ");
        String description = scan.nextLine();

        String query = "INSERT INTO ads(user_id, title, description) VALUES";
        query += "(" + user_id + ", '" + title + "', '" + description + "')";
        System.out.println(query);
        stmt.execute(query);
    }


    public static List<Ad> selectExample(Connection connection) throws SQLException {
        String query = "SELECT * FROM ads";
        System.out.println(query);

        Statement stmt = connection.createStatement();

        ResultSet rs = stmt.executeQuery(query);

        List<Ad> ads = new ArrayList<>();

        while(rs.next()) {
            int userId = rs.getInt("user_id");
            String adTitle = rs.getString("title");
            String adDescription = rs.getString("description");
            Ad a = new Ad(userId, adTitle, adDescription);
            ads.add(a);
        }
        return ads;
    }
}
