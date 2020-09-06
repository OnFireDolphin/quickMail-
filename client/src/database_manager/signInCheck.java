package database_manager;

import constants.Constants;
import utils.FileManipulation;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class signInCheck {
    public static boolean check(String email, String password){
        boolean check = false;
        try{
            List<Map<String, String>> clients = FileManipulation.getClientsCredentials("example.txt");
            Map<String, String> client = null;
            for(Map<String, String> aClient : clients){
                if(aClient.get(Constants.EMAIL).equals(email)){
                    client = new HashMap<>(aClient);
                    break;
                }
            }
            if(client != null){
                if(client.get(Constants.PASSWORD).equals(password)){
                    check = true;
                }
            }

        } catch (FileNotFoundException e){
            System.out.print("An error occured " + e.getMessage());
        }

        return check;
    }
}
