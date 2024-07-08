package util;


import java.util.Scanner;


public class Validation {

    private static final Scanner sc = new Scanner(System.in);

    public static int getInt(String msg, int min, int max) {

        while (true) {
            System.out.print(msg);
            String s = sc.nextLine().trim();
            try {
                int n = Integer.parseInt(s);
                // if n not in range min max, re-input n
                if (n < min || n > max) {
                    System.err.println("n must be in range " + min + " -> " + max);
                    continue;
                }
                return n;
            } catch (NumberFormatException e) {
                System.err.println("Must be a number! Enter again please.");
            }
        }
    }

    public static String getString(String msg, String pattern) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine().trim();
            // if user input character without pattern then Re-input
            if (!s.matches(pattern)) {
                System.err.println("Invalid input! Please between 1(code) 0(remain) to 50 characters( letters, numbers, and/or spaces)");
                continue;
            }
            return s;
        }
    }
    public static String getYN(String msg){
        while (true) {            
            System.out.print(msg);
            String s=sc.nextLine();
            // return y or n ( yes or no )
            if(s.equalsIgnoreCase("Y")||s.equalsIgnoreCase("N")){
                return s;
            }
            else{
                System.err.println("Input Y or N please!");
            }
        }
    }

}
