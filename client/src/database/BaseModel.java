package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseModel {
    private final String url = "jdbc:postgresql://localhost:1080/news_emailing";
    private final String user = "news_emailing";
    private final String password = "changer_le_monde";
    private String test = "SELECT * FROM news_emailing.users";
    public BaseModel(){}
    protected Connection connect(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    private void testConnection() throws SQLException {
        Connection conn = connect();
        if(conn != null){
            ResultSet res = conn.createStatement().executeQuery(test);
            while(res.next()){
                int item = res.getInt("id");
                System.out.println(item);
            }
            closeConnection(conn);

        } else{
            System.out.println("connection is null");
        }
    }
    protected void closeConnection(Connection conn){
        try {
            conn.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

}
