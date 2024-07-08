/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1sp0070_bank2;

import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Bank {

    static Scanner sc = new Scanner(System.in);

    public static void menu() {
        System.out.println("1.VietNamese");
        System.out.println("2.English");
        System.out.println("3.Exit");
    }
    public static void login(Locale l) {
        checkAccount(l);
        checkPassword(l);
        getCaptcha(l);
    }

    public static int checkMenu(int min, int max) {
        do {
            System.out.println("Enter your choice");
            try {
                int choice = Integer.parseInt(sc.nextLine());
                if (choice <= max || choice >= min) {
                    return choice;
                } else {
                    System.out.println("Number must in range " + min + " to " + max);
                }
            } catch (Exception e) {
                System.out.println("Please enter a number");
            }
        } while (true);
    }

    public static String checkAccount(Locale l) {
        getMessage(l, "inputAccount");
        String regex = "[0-9]+";
        while (true) {
            String account = sc.nextLine();
            if (account.matches(regex) && account.length() == 10) {
                return account;
            } else {
                getMessage(l, "accountError");
            }
        }
    }

    public static String checkPassword(Locale l) {
        getMessage(l, "inputPassword");
        String regex = "^(?=.*[a-zA-Z])(?=.*[0-9])[A-Za-z0-9!@#$%^&*]{8,31}$";
        while (true) {
            String pass = sc.nextLine();
            if (pass.matches(regex)) {
                return pass;
            } else {
                getMessage(l, "passwordError");
            }
        }
    }
//    static String capcha = "0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";

    public static String showCapcha(Locale l) {
        String regex = "[A-Z0-9a-z]+{5}";
        char[] result = new char[5];
        Random rd = new Random();

        while (true) {
            for (int i = 0; i < 5; i++) {
                result[i] = (char) rd.nextInt(255);
            }
            String a = new String(result);
            if (a.matches(regex)) {
                return a;
            }
        }
    }

    //        for (int i = 0; i < result.length; i++) {
//            result[i] = capcha.charAt(rd.nextInt(capcha.length()));
//
//        }
//    public static void getCaptcha(Locale l) {
//        String captcha = showCapcha(l);
//        System.out.println("Captcha: " + captcha);
//        getMessage(l, "inputCaptcha");
//        while (true) {
//            String check = sc.nextLine();
//            if (check.equals(captcha)) {
//                getMessage(l, "successful");
//                break;
//            } else {
//                getMessage(l, "captchaError");
//            }
//        }
//
//    }
    public static void getCaptcha(Locale l) {
        String captcha = showCapcha(l);
        System.out.println("Captcha: " + captcha);
        getMessage(l, "inputCaptcha");

        int attempts = 0;
        while (true) {
            String check = sc.nextLine();
            if (check.equals(captcha)) {
                getMessage(l, "successful");
                break;
            } else {
                getMessage(l, "captchaError");
                attempts++;
                if (attempts == 2) {
                    getMessage(l, "createNewAccount");
                    login(l);
                    return;
                }
            }
        }
    }

//    public static void getMessage(Locale l, String str) {
//       ResourceBundle rb = ResourceBundle.getBundle("j1sp0070_bank2.Language", l);
//
//        System.out.println(rb.getString(str));
//    }
     // Phương thức lấy thông điệp theo ngôn ngữ
    public static void getMessage(Locale l, String str) {
        ResourceBundle rb = ResourceBundle.getBundle("j1sp0070_bank2.Language", l); // Lấy gói tài nguyên theo ngôn ngữ
        String message = rb.getString(str); // Lấy thông điệp từ gói tài nguyên
        // Kiểm tra và in ra thông điệp với màu sắc tương ứng
        if ("accountError".equals(str) || "passwordError".equals(str) || "captchaError".equals(str)) {
            System.out.println("\033[31m" + message + "\033[0m"); // In ra thông điệp lỗi màu đỏ
        } else if ("successful".equals(str)) {
            System.out.println(message); // In ra thông điệp thành công
        } else {
            System.out.print(message); // In ra thông điệp bình thường
        }
    }
}
