package katabasedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class KataBaseDatos {

    private static final String URL = "jdbc:oracle:thin:@10.22.146.238:1521:orcl";
    private static final String USER = "system";
    private static final String PASSWD = "orcl";

    public static void main(String[] args) throws SQLException {
        Connection connection = createConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM CAMBIO_EUR_A");

        while (resultSet.next()) {
            System.out.print(resultSet.getString("DIVISA") + " ");
            System.out.println(resultSet.getBigDecimal("CAMBIO"));
        }
        
        connection.close();
    }

    private static Connection createConnection() throws SQLException {
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        return DriverManager.getConnection(URL, USER, PASSWD);
    }
}
