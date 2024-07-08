/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank; // Khai báo package bank

import static bank.Bank.getMessage; // Import phương thức getMessage từ class Bank
import static bank.Bank.sc; // Import đối tượng Scanner từ class Bank
import java.util.Locale; // Import lớp Locale để quản lý ngôn ngữ
import java.util.Scanner; // Import lớp Scanner để nhận input từ người dùng

/**
 *
 * @author duc
 */
public class Validation {
    // Phương thức kiểm tra menu, nhận vào giá trị min và max
    public static int checkMenu(int min, int max) {
        // Vòng lặp kiểm tra đầu vào của người dùng
        while (true) {
            Scanner in = new Scanner(System.in); // Khởi tạo Scanner để nhận input
            try {
                int result = Integer.parseInt(in.nextLine().trim()); // Đọc và chuyển đổi input sang số nguyên
                if (result < min || result > max) { // Kiểm tra giá trị có nằm trong khoảng cho phép không
                    throw new NumberFormatException(); // Nếu không, ném ngoại lệ
                }
                return result; // Trả về giá trị hợp lệ
            } catch (NumberFormatException e) {
                System.err.println("Please input number in range [" + min + ", " + max + "]"); // In thông báo lỗi
                System.out.print("Enter again: "); // Yêu cầu nhập lại
            }
        }
    }

    // Phương thức kiểm tra tài khoản, nhận vào đối tượng Locale
    public static String checkAccount(Locale l) {
        getMessage(l, "inputAccount"); // Yêu cầu người dùng nhập tài khoản
        String regex = "[0-9]{10}"; // Biểu thức chính quy cho tài khoản (chỉ chứa số)
        while (true) {
            String account = sc.nextLine(); // Đọc tài khoản người dùng nhập
            if (account.matches(regex)){ //&& account.length() == 10) { // Kiểm tra tài khoản hợp lệ (chỉ chứa số và có độ dài 10)
                return account; // Trả về tài khoản hợp lệ
            } else {
                getMessage(l, "accountError"); // In thông báo lỗi
                System.out.print("Enter account again: "); // Yêu cầu nhập lại
            }
        }
    }

    // Phương thức kiểm tra mật khẩu, nhận vào đối tượng Locale
    public static String checkPassword(Locale l) {
        getMessage(l, "inputPassword"); // Yêu cầu người dùng nhập mật khẩu
        String regex = "^(?=.*[a-zA-Z])(?=.*[0-9])[A-Za-z0-9!@#$%^&*]{8,31}$"; // Biểu thức chính quy cho mật khẩu (chứa cả chữ và số, độ dài 8-31)
        while (true) {
            String pass = sc.nextLine(); // Đọc mật khẩu người dùng nhập
            if (pass.matches(regex)) { // Kiểm tra mật khẩu hợp lệ
                return pass; // Trả về mật khẩu hợp lệ
            } else {
                getMessage(l, "passwordError"); // In thông báo lỗi
                System.out.print("Enter password again: "); // Yêu cầu nhập lại
            }
        }
    }
}
