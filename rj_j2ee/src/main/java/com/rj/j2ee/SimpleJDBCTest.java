
package com.rj.j2ee;

import java.sql.*;
import java.util.Enumeration;


public class SimpleJDBCTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Enumeration<Driver> driverEnumeration = DriverManager.getDrivers();
        while (driverEnumeration.hasMoreElements()){
            Driver driver = driverEnumeration.nextElement();
            System.out.println(driver);
            DriverManager.deregisterDriver(driver);
        }
        System.out.println("hello");
        /*String driverName = System.getProperty("java.Driver");
        System.out.println(driverName);
        Class c  = Class.forName(driverName);
        DriverManager.registerDriver((JdbcOdbcDriver)c.newInstance());*/
        String url = "jdbc:odbc:sqlite";
        Connection con =DriverManager.getConnection(url,"rj","rj" );
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM STUDENT");
        while (rs.next())
            System.out.println(rs.getInt("student_id")+" | "+rs.getString("student_name"));
        System.out.println("Completed");
    }
}
