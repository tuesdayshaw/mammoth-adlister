import java.util.List;

public interface Ads {
    List<Ad> all();
    Ads getAdById(long id);
    Ads getAdByTitle(String title);
    Ads getAdByUserId(long userId);
    Ads getAdByDescription(String description);

}
