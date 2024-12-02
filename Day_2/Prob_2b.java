package Day_2;

import java.util.Scanner;
import java.io.File;
import java.util.Arrays;

public class Prob_2b {
    public static void main(String[] args) {
        int safe = 0;
        String filePath = "C:/Users/monke/OneDrive/Documents/GitHub/Advent-Of-Code-2024/Day_2/Prob_2_Input.txt";
    
        try {
            Scanner s = new Scanner(new File(filePath));
            while (s.hasNextLine()) {
                // Parse line into int array
                String[] stringLine = s.nextLine().split(" ");
                int[] line = parseLine(stringLine);
    
                // Check safety with or without dampener
                if (isLineSafeWithDampener(line)) {
                    safe++;
                }
            }
    
            System.out.println(safe);
            s.close();
        } catch (Exception e) {
            System.out.println("File not found");
        }
    }
    
    public static int[] parseLine(String[] stringLine) {
        int[] line = new int[stringLine.length];
        for (int i = 0; i < stringLine.length; i++) {
            line[i] = Integer.parseInt(stringLine[i]);
        }
        return line;
    }
    
    public static boolean isLineSafeWithDampener(int[] line) {
        // Check if the line is outright safe
        if (Increase_Decrease(line) && AdjacentIncrement(line)) {
            return true;
        }
    
        // Apply dampener: Allow skipping one "bad" element
        for (int i = 0; i < line.length; i++) {
            int[] modifiedLine = removeElement(line, i);
            if (Increase_Decrease(modifiedLine) && AdjacentIncrement(modifiedLine)) {
                return true;
            }
        }
    
        return false;
    }
    
    public static int[] removeElement(int[] array, int index) {
        int[] result = new int[array.length - 1];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (i != index) {
                result[j++] = array[i];
            }
        }
        return result;
    }
    
    public static boolean Increase_Decrease(int[] line) {
        int increasing = 0;
        int decreasing = 0;
    
        for (int i = 0; i < line.length - 1; i++) {
            if (line[i] < line[i + 1]) {
                increasing++;
            } else if (line[i] > line[i + 1]) {
                decreasing++;
            } else {
                return false; // Adjacent elements are equal, unsafe
            }
        }
    
        // Line must be either strictly increasing or strictly decreasing
        return (increasing == line.length - 1) || (decreasing == line.length - 1);
    }
    
    public static boolean AdjacentIncrement(int[] line) {
        for (int i = 0; i < line.length - 1; i++) {
            int diff = Math.abs(line[i] - line[i + 1]);
            if (diff < 1 || diff > 3) {
                return false; // Invalid difference
            }
        }
        return true;
    }
    
}