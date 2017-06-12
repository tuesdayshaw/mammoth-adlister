import java.sql.SQLException;
import java.util.List;

/**
 * Created by canidmars on 6/12/17.
 */
public interface Users {

    List<User> all() throws SQLException;

    Long insert(User user) throws SQLException;
}
