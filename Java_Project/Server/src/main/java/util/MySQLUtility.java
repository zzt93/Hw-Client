package util;

import java.sql.*;

/**
 * Created by Nifury on 2014/10/24.
 */
public class MySQLUtility {

    private final static String url = "jdbc:mysql://localhost:3306/sampdb?" +
            "user=root&password=8633515&useUnicode=true&characterEncoding=UTF8";
    private static Statement statement;

    public static void init() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url);
        statement = connection.createStatement();
    }

    private static int update(String sql) throws SQLException {
        return statement.executeUpdate(sql);
    }

    public static ResultSet query(String sql) throws SQLException {
        return statement.executeQuery(sql);
    }

    public static int insert(String table, String args) throws SQLException {
        return update("insert into " + table + " values(" + args + ");");
    }

    public static int delete(String table, String where) throws SQLException {
        return update("delete from " + table + " where " + where + ";");
    }

    public static int update(String table, String set, String where) throws SQLException {
        return update("update " + table + "set " + set + " where " + where + ";");
    }

}
