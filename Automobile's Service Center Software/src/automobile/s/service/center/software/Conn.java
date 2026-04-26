
package automobile.s.service.center.software;

import java.sql.*;


public class Conn {
    Connection c;
    Statement s;
    
    Conn(){
        try{
        c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs", "root", "");
        s = c.createStatement();
        } catch (SQLException e){
         e.printStackTrace();   
        }
    }
    
}





