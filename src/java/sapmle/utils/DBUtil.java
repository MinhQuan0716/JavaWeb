package sapmle.utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author minhq
 */
public class DBUtil {
        public static Connection getConnection() throws ClassNotFoundException, SQLException, NamingException{
        Connection conn=null;
            Context context=(Context) new InitialContext();
            Context end=(Context) context.lookup("java:comp/env");
            DataSource ds=(DataSource) end.lookup("DbCon");
            conn=ds.getConnection();
        return conn;
    }
    
    
    
//    public static Connection getConnection() throws ClassNotFoundException, SQLException{
//        Connection conn=null;
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//       String connection="jdbc:sqlserver://localhost:1433;databaseName=UserManagement";
//       conn=DriverManager.getConnection(connection, "sa", "12345");
//        return conn;
//    }
    
}
