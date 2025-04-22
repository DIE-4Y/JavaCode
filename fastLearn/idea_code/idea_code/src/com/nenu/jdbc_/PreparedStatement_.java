package com.nenu.jdbc_;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class PreparedStatement_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        //读取配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\com\\nenu\\jdbc_\\mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        //建立连接
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        //建立PreparedStatement
        //1.删除并创建admin表
        String sql = "drop table if exists admin";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.execute();
        sql = "create table admin(id int unsigned primary key, name varchar(32))";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.execute();
        //2.使用preparedStatement添加5条数据
        sql = "insert into admin values (?,?)";
        preparedStatement = connection.prepareStatement(sql);
        /**
         * 假报错不用管
         */
        for (int i = 0; i < 5; i++) {
            preparedStatement.setInt(1, i);
            preparedStatement.setString(2, "admin" + i);
            preparedStatement.execute();
        }
        //修改一条记录：将admin3->king
        sql = "update admin set name=? where id = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "king");
        preparedStatement.setInt(2, 3);
        preparedStatement.execute();
        //删除一条记录
        sql = "delete from admin where id=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, 5);
        preparedStatement.execute();
        //查询记录并输出
        sql = "select * from admin";
        preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int id = resultSet.getInt(1);//获取第一列数据
            String name = resultSet.getString(2);//获取第二列数据
            System.out.println(id+"\t\t"+name);
        }
        //关闭连接
        resultSet.close();
        preparedStatement.close();
        connection.close();
    } 
}
