package com.nenu.jdbc_.dao;

import com.nenu.jdbc_.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 基础Dao 封装Dao的通用的方法
 */
public class BasicDao<T> {
    private QueryRunner queryRunner = new QueryRunner();

    //dml操作 添加、删除、修改
    public int update(String sql, Object... params) {
        Connection connection = JDBCUtilsByDruid.getConnection();
        try {
            int update = queryRunner.update(connection, sql, params);
            return update;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    /**
     * 多行查询
     *
     * @param sql    可含有？的查询语句
     * @param clazz  传入的某个类对象
     * @param params 可变形参列表
     * @return 返回一个指定类型的对象列表
     */
    public List<T> queryMulti(String sql, Class<T> clazz, Object... params) {
        Connection connection = JDBCUtilsByDruid.getConnection();
        try {
            List<T> query = queryRunner.query(connection, sql, new BeanListHandler<T>(clazz), params);
            return query;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    /**
     * 单行查询
     *
     * @param sql    可含有？的查询语句
     * @param clazz  传入的某个类对象
     * @param params 可变形参列表
     * @return 返回一个指定类型的T对象
     */
    public T querySingle(String sql, Class<T> clazz, Object... params) {
        Connection connection = JDBCUtilsByDruid.getConnection();
        try {
            T query = queryRunner.query(connection, sql, new BeanHandler<T>(clazz), params);
            return query;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    /**
     * 查询单列多行数据
     *
     * @param sql    可带有？的sql语句
     * @param params 多个参数
     * @return 返回Object列表
     */
    public List queryColumn(String sql, Object... params) {
        Connection connection = JDBCUtilsByDruid.getConnection();
        try {
            return queryRunner.query(connection, sql, new ColumnListHandler<>(), params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    /**
     * 单行单列查询
     *
     * @param sql    可含有？的查询语句
     * @param params 多个参数
     * @return 返回的是一个Object类型的数据
     */
    public Object queryScalar(String sql, Object... params) {
        Connection connection = JDBCUtilsByDruid.getConnection();
        try {
            return queryRunner.query(connection, sql, new ScalarHandler<>(), params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }
}
