import java.util.Scanner;
import java.io.*;

public class FileStartTemplate {
    public static void main(String[] args) {
        String filePath = "C:/Users/monke/OneDrive/Documents/GitHub/Advent-Of-Code-2024/" // Fill in day and input fileDay_4/Problem_4_Input.txt";

        try (Scanner s = new Scanner(new File(filePath))) {

            
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
