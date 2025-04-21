package com.nenu.jdbc_;
import com.mysql.jdbc.Driver;
import org.junit.Test;

import javax.swing.plaf.nimbus.State;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCConnection01 {
    public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\com\\nenu\\jdbc_\\mysql.properties"));
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        //类加载
        Class.forName(driver);
        //DriverManager建立连接
        Connection connection = DriverManager.getConnection(url, user, password);
        //执行sql

        Statement statement = connection.createStatement();
        String sql = "DROP TABLE IF EXISTS news";
        statement.executeUpdate(sql);
        sql = "create table news(id int primary key , content varchar(1024))";
        int result = statement.executeUpdate(sql);
        System.out.println(result == 0?"建表成功":"建表失败");
        //插入数据
        for (int i = 0; i < 5; i++) {
            sql="insert into news values ("+i+",'hahahah')";
            result = statement.executeUpdate(sql);
            System.out.println(result > 0?"第"+i+"条数据插入成功":"第"+i+"条数据插入失败");
        }
        //修改数据
        sql="update news set content = 'csq' where id = 1";
        result = statement.executeUpdate(sql);
        System.out.println(result > 0?"第1条修改成功":"第1条修改失败");
        sql="delete from news where id = 3";
        result = statement.executeUpdate(sql);
        System.out.println(result > 0?"第3条删除成功":"第3条删除失败");
        //关闭连接
        statement.close();
        connection.close();
    }

}

