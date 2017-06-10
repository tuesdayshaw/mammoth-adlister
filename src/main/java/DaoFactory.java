import java.sql.SQLException;

public class DaoFactory {

    private static Config config = new Config();
    private static Ads adsDao;

    public static Ads getAdsDao() throws SQLException {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(config);
        }
        return adsDao;
    }


    private static Config2 config2 = new Config2();
    private static Employees employeesDao;

    public static Employees getEmployeesDao() throws SQLException {
        if (employeesDao == null) {
            employeesDao = new EmployeesSQLDao(config2);
        }
        return employeesDao;
    }

}