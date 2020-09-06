package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Users extends BaseModel{
    private String test = "SELECT * FROM news_emailing.users where users.id = 5";
    public boolean isInDatabase() throws SQLException {
        Connection conn = connect();
        if(conn != null){
            ResultSet result = conn.createStatement().executeQuery(test);
            closeConnection(conn);
            return result.next();

        }
        return false;
    }
}
