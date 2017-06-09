public class DaoFactory {
    private static Ads adsDao;

    public static Ads getAdsDao() {
        if (adsDao == null) {
            System.out.println("Creating mysql ads dao");
            adsDao = new MySQLAdsDao();
        }
        return adsDao;
    }
}
