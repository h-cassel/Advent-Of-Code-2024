package Day_3;

import java.util.Scanner;
import java.io.File;
import java.util.regex.*;
import java.util.ArrayList;

public class Problem_3a {
    public static void main(String[] args) {
        String filePath = "C:/Users/monke/OneDrive/Documents/GitHub/Advent-Of-Code-2024/Day_3/Problem_3_Input.txt";
        
        // Create regex pattern
        String pattern = "mul\\((\\d{1,3}),(\\d{1,3})\\)";
        Pattern p = Pattern.compile(pattern);
        Matcher m;
        ArrayList<Integer> quotients = new ArrayList<>();

        try {
            Scanner s = new Scanner(new File(filePath));
            while (s.hasNextLine()) {
                String line = s.nextLine();
                m = p.matcher(line);
                while (m.find()) {
                    int num1 = Integer.parseInt(m.group(1));
                    int num2 = Integer.parseInt(m.group(2));
                    quotients.add(num1 * num2);
                }
            }
            //System.out.println(quotients);

        } catch (Exception e) {
            System.out.println("File not found");
        }

        int totalQuotient = 0;

        for (Integer i : quotients) {
            totalQuotient += i;
        }

        System.out.println(totalQuotient);
    }
}
