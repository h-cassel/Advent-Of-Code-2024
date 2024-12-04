package Day_4;

import java.util.Scanner;
import java.io.*;

public class Problem_4a {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        String filePath = "C:/Users/monke/OneDrive/Documents/GitHub/Advent-Of-Code-2024/Day_4/Problem_4_Input.txt";

        String word = "XMAS";
        int count = 0;
        char[][] wordSearch = null;

        try {
            Scanner s = new Scanner(new File(filePath));
            int rows = 0;
            int cols = 0;

            while (s.hasNextLine()) {
                String line = s.nextLine();
                rows++;
                cols = line.length();
            }

            wordSearch = new char[rows][cols];

            s = new Scanner(new File(filePath));

            int row = 0;
            while (s.hasNextLine()) {
                String line = s.nextLine();
                for (int col = 0; col < line.length(); col++) {
                    wordSearch[row][col] = line.charAt(col);
                }
                row++;
            }

            s.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        for (int row = 0; row < wordSearch.length; row++) {
            for (int col = 0; col < wordSearch[row].length; col++) {
                count += searchWord(wordSearch, row, col, word);
            }
        }

        System.out.println("Total occurances of '" + word + "': " + count);
    }

    public static int searchWord(char[][] wordSearch, int row, int col, String word) {
        int count = 0;

        int[][] directions = {
            {0, 1}, // right
            {0, -1}, // left
            {1, 0}, // down
            {-1, 0}, // up
            {1, 1}, // down-right (diagonal)
            {-1, -1}, // up-left (diagonal)
            {1, -1}, // down-left (diagonal)
            {-1, 1} // up-right (diagonal)
        };

        for (int[] direction : directions) {
            if (isWordInDirection(wordSearch, row, col, word, direction[0], direction[1])) {
                count++;
            }
        }

        return count;
    }

    public static boolean isWordInDirection(char[][] wordSearch, int row, int col, String word, int dRow, int dCol) {
        int wordlength = word.length();

        for (int i = 0; i < wordlength; i++) {
            int newRow = row + i * dRow;
            int newCol = col + i * dCol;

            if (newRow < 0 || newRow >= wordSearch.length || newCol < 0 || newCol >= wordSearch[0].length) {
                return false;
            }

            if (wordSearch[newRow][newCol] != word.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
