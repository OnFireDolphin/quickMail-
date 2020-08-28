package utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileManipulation {
    public static void readFile(String filename) throws FileNotFoundException {
        File myFile = new File(filename);
        Scanner myReader = new Scanner(myFile);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            System.out.println(data);
        }



    }
}
