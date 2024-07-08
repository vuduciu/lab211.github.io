/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank; // Khai báo package bank

import static bank.Bank.login; // Import phương thức login từ class Bank
import static bank.Bank.menu; // Import phương thức menu từ class Bank
import java.util.Locale; // Import lớp Locale để quản lý ngôn ngữ

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {
        // TODO code application logic here

        Locale vn = new Locale("vn", "VN"); // Khởi tạo đối tượng Locale cho Tiếng Việt
        Locale en = Locale.US; // Khởi tạo đối tượng Locale cho Tiếng Anh (Mỹ)
        while (true) { // Vòng lặp vô hạn để duy trì chương trình
            menu(); // Hiển thị menu
            int choice = Validation.checkMenu(1, 3); // Yêu cầu người dùng chọn lựa từ 1 đến 3

            switch (choice) { // Kiểm tra lựa chọn của người dùng
                case 1:
                    login(vn); // Nếu chọn 1, đăng nhập với ngôn ngữ Tiếng Việt
                    break;
                case 2:
                    login(en); // Nếu chọn 2, đăng nhập với ngôn ngữ Tiếng Anh
                    break;
                case 3:
                    return; // Nếu chọn 3, thoát chương trình
            }
        }
    }
}
