// Main.java
package j1sp0073;

import java.util.ArrayList;

/**
 * Lớp chính để quản lý chương trình chi tiêu.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Expenses> expenseList = new ArrayList<>();
        int id = 0;
        while (true) {
            Manager.displayMenu();
            int choice = Validate.checkIntLimit(1, 4);
            switch (choice) {
                case 1:
                    Manager.addExpense(expenseList, ++id);
                    break;
                case 2:
                    Manager.displayExpenses(expenseList);
                    break;
                case 3:
                    Manager.deleteExpense(expenseList);
                    break;
                case 4:
                   System.exit(0);
                    break;
            }
        }
    }
}
