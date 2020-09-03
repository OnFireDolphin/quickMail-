package utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;
import constants.Constants;

public class FileManipulation {
    public static List<Map<String, String>> getClientsCredentials(String filename) throws FileNotFoundException {
        List<Map<String, String>> clients = new ArrayList<>();
        URL url = FileManipulation.class.getClassLoader().getResource(filename);
        File myFile = new File(url.getPath());
        Scanner myReader = new Scanner(myFile);
        while (myReader.hasNext()) {
            String data = myReader.nextLine();
            Map<String, String> client = new HashMap<>();
            String[] list = data.split(" ");
            client.put(Constants.EMAIL, list[0]);
            client.put(Constants.PASSWORD, list[1]);
            clients.add(client);
        }
        myReader.close();
        return clients;
    }
    public static Map<String, String> getCurrentClient(String filename) throws FileNotFoundException {
        Map<String, String> client = new HashMap<>();
        URL url = FileManipulation.class.getClassLoader().getResource(filename);
        File myFile = new File(url.getPath());
        Scanner myReader = new Scanner(myFile);
        while (myReader.hasNext()) {
            String data = myReader.nextLine();
            String[] list = data.split(" ");
            client.put(Constants.EMAIL, list[0]);
            client.put(Constants.PASSWORD, list[1]);
            // client.put(Constants.NAME, list[2]);

        }
        myReader.close();
        return client;
    }
}
