package Day_1;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Problem_1 {
    public static void main(String[] args) {
        String filepath = "C:/Users/monke/OneDrive/Desktop/Advent of Code/2024/Day-1/Problem_1_Test.txt";
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        ArrayList<Integer> differences = new ArrayList<Integer>();
        
        try {
            Scanner input = new Scanner(new File(filepath));
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] parts = line.split("   ");
                
                list1.add(Integer.parseInt(parts[0]));
                list2.add(Integer.parseInt(parts[1]));
            }

            int counter = 0;
            int sum = 0;

            for (int i = 0; i < list1.size(); i++) {
                if (list2.contains(list1.get(i))) {
                    while(list2.contains(list1.get(i))) {
                        list2.remove(list2.indexOf(list1.get(i)));
                        counter++;
                    }
                    sum += list1.get(i) * counter;
                    counter = 0;
                }
            }

            System.out.println(sum);

            input.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}