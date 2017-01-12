package connectie; /**
 * Created by MSI on 11-1-2017.
 */

import com.sun.org.apache.xpath.internal.SourceTree;

import java.sql.*;

public class driver {
        public static void main(String[] args){
            String host = "jdbc:mysql://localhost:3306/bier";
            String userName = "root";
            String passWord = "";
            String query = "select * from bier";

            try{
                //Connection is made
                Connection myConn = DriverManager.getConnection(host, userName, passWord);

                Statement myStmt = myConn.createStatement();

                //Query wordt gemaakt
                ResultSet myRs = myStmt.executeQuery(query);

                //Printen ------- moet je zelf maar veranderen...
                while (myRs.next()) {
                    System.out.println(myRs.getFloat("alcohol"));
                }
            }
            catch (Exception exc) {
                exc.printStackTrace();
            }
        }
}
