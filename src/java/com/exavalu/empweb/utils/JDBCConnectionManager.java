
package com.exavalu.empweb.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCConnectionManager {

     public static Connection getMySQLConnection() {

        Connection connection = null;
        try {
           // we use use the url, userid and passowrd to ge the connection
           
           PropertyFileReader util = PropertyFileReader.getInstance();

		String user = util.getPropertyValue("user");	
		String password=util.getPropertyValue("pass");
		String url=util.getPropertyValue("url");
		String dbName=util.getPropertyValue("dbName");
		String driverName=util.getPropertyValue("driverName");
		
		Class.forName(driverName);
          
            
           connection = DriverManager.getConnection(url+dbName,user,password);
         } catch (ClassNotFoundException | SQLException ex) {
        }

        return connection;
    
     }

     }
