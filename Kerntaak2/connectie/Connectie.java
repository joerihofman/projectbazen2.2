package connectie; /**
 * Created by MSI on 11-1-2017.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectie {
    Connection connectie = DriverManager.getConnection(localhost, root);
}
