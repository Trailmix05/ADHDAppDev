import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DataFile {
    public static void createFile() throws IOException{
        File createFile = new File("uData.txt");
        if (createFile.createNewFile()){
            System.out.println("File created");
        }
        else{
            System.out.println("File already exists");
        }
    }

    public static void writeToFile(String dataToSave) throws IOException{
        try (FileWriter saveToFile = new FileWriter("uData.txt")) {
            saveToFile.write(dataToSave);
        }
    }
}
