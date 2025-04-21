package com.nenu.jdbc_;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static String driver;
    private static String user;
    private static String password;
    private static String url;

    //初始化
    static{
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src\\com\\nenu\\jdbc_\\mysql.properties"));
            driver = properties.getProperty("driver");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //获取连接
    public static Connection getConnection(){
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //关闭连接
    public static void close(ResultSet resultSet, Statement statement, Connection connection){
        try {
            if (resultSet != null){
                resultSet.close();
            }
            if (statement != null){
                statement.close();
            }
            if (connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
