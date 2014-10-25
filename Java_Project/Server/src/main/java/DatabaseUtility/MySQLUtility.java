package nifury.mysql;

import java.sql.*;

/**
 * Created by Nifury on 2014/10/24.
 */
public class MySQLUtility {

    private final static String url = "jdbc:mysql://localhost:3306/myuser";
    private final static String user = "root";
    private final static String pass = "root";
    private static Connection connection;
    private static Statement statement;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pass);
            statement = connection.createStatement();
        } catch (Exception e) {
            throw new ContingencyException(e.getMessage(), e);
        }
    }

    public static int update(String sql) {
        try {
            return statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new ContingencyException(e.getMessage(), e);
        }
    }

    public static ResultSet query(String sql) {
        try {
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            throw new ContingencyException(e.getMessage(), e);
        }
    }

}
