package connectie; /**
 * Created by MSI on 11-1-2017.
 */

import com.sun.org.apache.xpath.internal.SourceTree;

import java.sql.*;

public class driver {
        public static void main(String[] args){
            try{
                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bier", "root", "");

                Statement myStmt = myConn.createStatement();

                ResultSet myRs = myStmt.executeQuery("select * from bier");

                while (myRs.next()) {
                    System.out.println(myRs.getFloat("alcohol"));
                }
            }
            catch (Exception exc) {
                exc.printStackTrace();
            }
        }
}
