/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank; // Khai báo package bank

import java.util.HashSet;
import java.util.Locale; // Import lớp Locale để quản lý ngôn ngữ
import java.util.Random; // Import lớp Random để sinh số ngẫu nhiên
import java.util.ResourceBundle; // Import lớp ResourceBundle để quản lý các thông điệp ngôn ngữ
import java.util.Scanner; // Import lớp Scanner để nhận input từ người dùng
import java.util.Set;

public class Bank {

    static Scanner sc = new Scanner(System.in); // Khai báo biến Scanner toàn cục để sử dụng trong các phương thức
      static Set<String> accountSet = new HashSet<>(); // Tập hợp để lưu trữ các tài khoản đã được tạo


    // Phương thức hiển thị menu
    public static void menu() {
        System.out.println("1.VietNamese"); // In ra lựa chọn ngôn ngữ Tiếng Việt
        System.out.println("2.English"); // In ra lựa chọn ngôn ngữ Tiếng Anh
        System.out.println("3.Exit"); // In ra lựa chọn thoát
        System.out.print("Enter your choice: "); // Yêu cầu người dùng nhập lựa chọn
    }

    // Phương thức đăng nhập với tham số Locale để xác định ngôn ngữ
//    public static void login(Locale l) {
//        Validation.checkAccount(l); // Kiểm tra tài khoản
//        Validation.checkPassword(l); // Kiểm tra mật khẩu
//        getCaptcha(l); // Hiển thị và kiểm tra captcha
//    }
    public static void login(Locale l) {
        String account = Validation.checkAccount(l); // Kiểm tra tài khoản
        Validation.checkPassword(l); // Kiểm tra mật khẩu
        getCaptcha(l); // Hiển thị và kiểm tra captcha

        if (accountSet.contains(account)) {
            getMessage(l, "accountExists");
            System.out.print("Enter account again: ");
            login(l);
        } else {
            accountSet.add(account); // Thêm tài khoản vào tập hợp
        }
    }

    // Phương thức sinh captcha ngẫu nhiên
    public static String showCapcha(Locale l) {
        String regex = "[A-Z0-9a-z]{5}"; // Biểu thức chính quy để kiểm tra captcha
        char[] result = new char[5]; // Mảng ký tự để lưu captcha
        Random rd = new Random(); // Đối tượng Random để sinh số ngẫu nhiên

        while (true) {
            for (int i = 0; i < 5; i++) {
                result[i] = (char) rd.nextInt(255); // Sinh ký tự ngẫu nhiên và gán vào mảng
            }
            String a = new String(result); // Tạo chuỗi từ mảng ký tự
            if (a.matches(regex)) { // Kiểm tra chuỗi có hợp lệ không
                return a; // Trả về chuỗi hợp lệ
            }
        }
    }

    // Phương thức hiển thị và kiểm tra captcha
//    public static void getCaptcha(Locale l) {
//        String captcha = showCapcha(l); // Gọi phương thức sinh captcha
//        System.out.println("Captcha: " + captcha); // In ra captcha
//        getMessage(l, "inputCaptcha"); // Yêu cầu người dùng nhập captcha
//        int attempts=0;
//        while (true) {
//            String check = sc.nextLine(); // Đọc captcha người dùng nhập
//            if (check.equals(captcha)) { // Kiểm tra captcha đúng hay sai
//                getMessage(l, "successful"); // Nếu đúng, in thông báo thành công             
//                break;
//            } else {
//                getMessage(l, "captchaError"); // Nếu sai, in thông báo lỗi
//               attempts++;
//               if(attempts==2){
//                   captcha=showCapcha(l);
//                   System.out.println("captcha: "+captcha);
//                   getMessage(l, "inputCaptcha");
//                   attempts=0;
//               }else{
//                   System.out.println("Enter captcha again: ");
//               }
//            }
//        }
//    }
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
                System.out.print("Enter captcha again: ");
                attempts++;
                if (attempts == 2) {
                    getMessage(l, "createNewAccount");
                    System.out.println("");
                    login(l);
                    return;
                }
            }
        }
    }

    // Phương thức lấy thông điệp theo ngôn ngữ
    public static void getMessage(Locale l, String str) {
        ResourceBundle rb = ResourceBundle.getBundle("bank.Language", l); // Lấy gói tài nguyên theo ngôn ngữ
        String message = rb.getString(str); // Lấy thông điệp từ gói tài nguyên
        // Kiểm tra và in ra thông điệp với màu sắc tương ứng
        if ("accountError".equals(str) || "passwordError".equals(str) || "captchaError".equals(str)) {
            //System.out.println("\033[31m" + message + "\033[0m"); // In ra thông điệp lỗi màu đỏ
            System.err.println( message );
        } else if ("successful".equals(str)) {
            System.out.println(message); // In ra thông điệp thành công
        } else {
            System.out.print(message); // In ra thông điệp bình thường
        }
    }
}
