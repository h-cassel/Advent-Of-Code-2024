package Day_2;

import java.util.Scanner;
import java.io.File;
import java.util.Arrays;

public class Prob_2a {
    public static void main(String[] args) {
        
        int safe = 0;
        String filePath = "C:/Users/monke/OneDrive/Documents/GitHub/Advent-Of-Code-2024/Day_2/Prob_2_Input.txt";
        
        try {
            Scanner s = new Scanner(new File(filePath));
            String[] stringLine = s.nextLine().split(" ");
            while (s.hasNextLine()) {
                // Get data into int array
                int[] line = new int[stringLine.length];
                for (int i = 0; i < stringLine.length; i++) {
                    line[i] = Integer.parseInt(stringLine[i]);
                }
                //System.out.println(Arrays.toString(line));
                // check data
                if (Increase_Decrease(line)) {
                    if (AdjacentIncrement(line)) {
                        //System.out.println("Added to Safe");
                        safe++;
                    }
                }
                stringLine = s.nextLine().split(" ");
            }
            // final line
            int[] line = new int[stringLine.length];
                for (int i = 0; i < stringLine.length; i++) {
                    line[i] = Integer.parseInt(stringLine[i]);
                }
                //System.out.println(Arrays.toString(line));
                // check data
                if (Increase_Decrease(line)) {
                    if (AdjacentIncrement(line)) {
                        //System.out.println("Added to Safe");
                        safe++;
                    }
                }
            System.out.println(safe);
            s.close();
        } catch (Exception e) {
            System.out.println("File not found");
        }
    }

    public static boolean Increase_Decrease(int[] line) {
        int j = 0;
        if (line[0] < line[1]) {
            while (j < line.length - 1) {
                if (line[j] < line[j+1]) {
                    j++;
                } else {
                    return false;                        
                }
            }
            //System.out.println("Decreasing...");
            return true;
        } else if (line[0] > line[1]) {
            j = 0;
            while (j < line.length - 1) {
                if (line[j] > line[j+1]) {
                    j++;
                } else {
                    return false;
                }
            }
            //System.out.println("Increasing...");
            return true;
        } else { // line[0] == line[1] : unsafe
            //System.out.println("Nums were equal");
            return false;
        }
    }

    public static boolean AdjacentIncrement(int[] line) {
        int i = 0;
        // check for adjacent increment / decrement between 1-3
        // Increase_Decrease already checked for matching values
        while (i < line.length - 1) {
            if (line[i] + 1 == line[i+1]) {
                i++;
            }
            else if (line[i] + 2 == line[i + 1]) {
                i++;
            }
            else if (line[i] + 3 == line[i + 1]) {
                i++;
            }
            else if (line[i] - 1 == line[i + 1]) {
                i++;
            }
            else if (line[i] - 2 == line[i + 1]) {
                i++;
            }
            else if (line[i] - 3 == line[i + 1]) {
                i++;
            }
            else {
                return false;
            }
        }
        return true;
    }
}