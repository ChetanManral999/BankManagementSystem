package bank.management.system;
import java.sql.*;
import java.sql.Connection;

public class conn {
    Connection c;
    Statement s;
    public conn() {
        try{
            c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root", String.valueOf(2119));
            s=c.createStatement();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
