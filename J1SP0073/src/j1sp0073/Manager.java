package j1sp0073;

import java.util.ArrayList;

/**
 * Class to handle expense management operations.
 * Lớp để xử lý các hoạt động quản lý chi tiêu.
 */
public class Manager {

    /**
     * Adds an expense to the list.
     * Thêm một khoản chi tiêu vào danh sách.
     *
     * @param expenseList List of expenses / Danh sách các khoản chi tiêu
     * @param id ID for the new expense / ID cho khoản chi tiêu mới
     */
    public static void addExpense(ArrayList<Expenses> expenseList, int id) {
        // Nhập ngày tháng với định dạng dd-MMM-yyyy
        String date = Validate.checkInputDate("Enter Date (dd-MMM-yyyy): ");
        
        // Nhập số tiền chi tiêu
        double amount = Validate.checkInputDouble("Enter Amount: ");
        
        // Nhập nội dung chi tiêu
        String content = Validate.checkInputString("Enter Content: ");
        
        // Thêm một đối tượng chi tiêu mới vào danh sách
        expenseList.add(new Expenses(id, date, amount, content));
        
        // Thông báo thêm khoản chi tiêu thành công
        System.out.println("Expense added successfully.");
        // Thêm khoản chi tiêu thành công.
    }

    /**
     * Displays all expenses.
     * Hiển thị tất cả các khoản chi tiêu.
     *
     * @param expenseList List of expenses / Danh sách các khoản chi tiêu
     */
    public static void displayExpenses(ArrayList<Expenses> expenseList) {
        // Kiểm tra xem danh sách chi tiêu có trống không
        if (expenseList.isEmpty()) {
            // Nếu trống, in thông báo lỗi
            System.err.println("No expenses to display.");
            // Không có khoản chi tiêu nào để hiển thị.
            return;
        }
        
        // Khởi tạo biến để tính tổng chi tiêu
        double total = 0;
        
        // In tiêu đề các cột của danh sách chi tiêu
        System.out.printf("%-7s%-20s%-20s%-20s\n", "ID", "Date", "Amount", "Content");
        // ID      Ngày                 Số Tiền             Nội Dung
        
        // Duyệt qua từng khoản chi tiêu trong danh sách
        for (Expenses expense : expenseList) {
            // In thông tin chi tiêu của từng khoản
            System.out.printf("%-7d%-20s%-20.2f%-20s\n", expense.getId(), expense.getDate(), expense.getAmount(), expense.getContent());
            
            // Cộng số tiền chi tiêu của từng khoản vào tổng
            total += expense.getAmount();
        }
        
        // In tổng số tiền chi tiêu
        System.out.printf("Total: %-20.2f\n", total);
        // Tổng Cộng:
    }

    /**
     * Finds the index of an expense by its ID.
     * Tìm chỉ số của một khoản chi tiêu theo ID.
     *
     * @param expenseList List of expenses / Danh sách các khoản chi tiêu
     * @param id ID of the expense / ID của khoản chi tiêu
     * @return Index of the expense if found, otherwise -1 / Chỉ số của khoản chi tiêu nếu tìm thấy, ngược lại -1
     */
    private static int findExpenseById(ArrayList<Expenses> expenseList, int id) {
        // Duyệt qua từng khoản chi tiêu trong danh sách
        for (int i = 0; i < expenseList.size(); i++) {
            // Nếu tìm thấy khoản chi tiêu có ID trùng với ID cần tìm
            if (expenseList.get(i).getId() == id) {
                return i; // Trả về chỉ số của khoản chi tiêu đó
            }
        }
        return -1; // Nếu không tìm thấy, trả về -1
    }

    /**
     * Deletes an expense from the list by its ID.
     * Xóa một khoản chi tiêu khỏi danh sách theo ID.
     *
     * @param expenseList List of expenses / Danh sách các khoản chi tiêu
     */
    public static void deleteExpense(ArrayList<Expenses> expenseList) {
        System.out.print("Enter ID to delete: ");
        // Nhập ID để xóa:
        int id = Validate.checkIntLimit(1, Integer.MAX_VALUE);
        int index = findExpenseById(expenseList, id);
        if (index != -1) {
            // Nếu tìm thấy khoản chi tiêu, xóa nó khỏi danh sách
            expenseList.remove(index);
            System.out.println("Expense deleted successfully.");
            // Xóa khoản chi tiêu thành công.
            
            // Cập nhật lại ID của các khoản chi tiêu sau khi xóa
            for (int i = index; i < expenseList.size(); i++) {
                expenseList.get(i).setId(expenseList.get(i).getId() - 1);
            }
        } else {
            // Nếu không tìm thấy khoản chi tiêu với ID đã nhập, in thông báo lỗi
            System.err.println("Delete failed. Expense ID not found.");
            // Xóa thất bại. Không tìm thấy ID chi tiêu.
        }
    }

    /**
     * Displays the menu options.
     * Hiển thị các tùy chọn menu.
     */
    public static void displayMenu() {
        System.out.println("1. Add an expense");
        System.out.println("2. Display all expenses");
        System.out.println("3. Delete an expense");
        System.out.println("4. Quit");
        System.out.print("Your choice: ");
        // 1. Thêm một khoản chi tiêu
        // 2. Hiển thị tất cả các khoản chi tiêu
        // 3. Xóa một khoản chi tiêu
        // 4. Thoát
        // Lựa chọn của bạn:
    }
}
