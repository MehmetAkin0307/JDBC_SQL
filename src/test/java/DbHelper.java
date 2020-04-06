import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {

    private String username = "ignite";
    private String password = "Eh7ruY3!p@82";
    private String dbURL = "jdbc:sqlserver://192.168.1.15\\COOLSQLIGNITE;";

    public Connection getConnetcion() throws SQLException {

        return DriverManager.getConnection(dbURL, username, password);

    }
    public void showErrorMessage(SQLException exception){
        System.out.println("Error: "+exception.getMessage());
        System.out.println("Error code :"+exception.getErrorCode());

    }
}
