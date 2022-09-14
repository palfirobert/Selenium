package database;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;

public class databaseConnection {
    public static void main(String[] args) throws SQLException {
        String url="jdbc:mysql://"+"localhost"+":"+"3306"+"/seleniumdatabase";
        Connection con=DriverManager.getConnection(url,"root","Robertpalfi15");

        Statement s=con.createStatement();

        ResultSet rs= s.executeQuery("SELECT * FROM employeeinfo where id=2;");
        rs.next();
        System.out.println(rs.getString("name"));

    }
}
