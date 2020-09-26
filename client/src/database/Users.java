package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Users {
    private String test = "SELECT * FROM news_emailing.users where users.username= 'Mark'";
    private Connection conn;
    public Users(){
        conn = BaseModel.getConnection();
    }
    public boolean isInDatabase() throws SQLException {
        if(conn != null){
            ResultSet result = conn.createStatement().executeQuery(test);
            return result.next();

        }
        return false;
    }
}
