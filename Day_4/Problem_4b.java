package Day_4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem_4b {
    public static void main(String[] args) {
        try {
            // Read the puzzle from a file
            File file = new File("C:/Users/monke/OneDrive/Documents/GitHub/Advent-Of-Code-2024/Day_4/Problem_4_Input.txt");
            Scanner scanner = new Scanner(file);

            // Determine the dimensions of the puzzle
            int rows = 0;
            int cols = 0;
            StringBuilder inputBuilder = new StringBuilder();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                inputBuilder.append(line).append("\n");
                rows++;
                cols = Math.max(cols, line.length());
            }
            scanner.close();

            // Build the 2D array
            char[][] puzzle = new char[rows][cols];
            String[] lines = inputBuilder.toString().split("\n");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    puzzle[i][j] = (j < lines[i].length()) ? lines[i].charAt(j) : '.';
                }
            }

            // Count occurrences of "MAS" in an "X" shape
            int count = 0;

            for (int row = 0; row < puzzle.length; row++) {
                for (int col = 0; col < puzzle[row].length; col++) {
                    if (isMASXPattern(puzzle, row, col)) {
                        count++;
                    }
                }
            }

            System.out.println("Total occurrences of 'MAS' in 'X' shape: " + count);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    // Function to check if "MAS" forms an "X" pattern centered at (row, col)
    public static boolean isMASXPattern(char[][] puzzle, int row, int col) {
        // Check if the pattern fits within the bounds of the grid
        if (row - 1 < 0 || row + 1 >= puzzle.length || col - 1 < 0 || col + 1 >= puzzle[0].length) {
            return false;
        }

        // Extract the diagonals and the center
        char center = puzzle[row][col];
        char topLeft = puzzle[row - 1][col - 1];
        char topRight = puzzle[row - 1][col + 1];
        char bottomLeft = puzzle[row + 1][col - 1];
        char bottomRight = puzzle[row + 1][col + 1];

        // Debug diagonals
        //System.out.printf("Checking center (%d, %d): Center=%c, TopLeft=%c, TopRight=%c, BottomLeft=%c, BottomRight=%c%n",
            //row, col, center, topLeft, topRight, bottomLeft, bottomRight);

        // Check for the "MAS" X pattern
        boolean matches = (center == 'A' &&
                        topLeft == 'M' &&
                        topRight == 'S' &&
                        bottomLeft == 'M' &&
                        bottomRight == 'S') ||
                        (center == 'A' &&
                        topLeft == 'S' &&
                        topRight == 'M' &&
                        bottomLeft == 'S' &&
                        bottomRight == 'M') ||
                        (center == 'A' &&
                        topLeft == 'M' &&
                        topRight == 'M' &&
                        bottomLeft == 'S' &&
                        bottomRight == 'S') ||
                        (center == 'A' &&
                        topLeft == 'S' &&
                        topRight == 'S' &&
                        bottomLeft == 'M' &&
                        bottomRight == 'M'
                        );

        /*if (matches) {
            System.out.printf("Found 'MAS' in 'X' shape centered at (%d, %d)\n", row, col);
        }*/

        return matches;
    }
}
