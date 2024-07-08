package view;

import util.Validation;

public class ConsoleUI {

    public int showMenuList() {
        String[] menuLists = {
            "Add Doctor",
            "Update Doctor",
            "Delete Doctor",
            "Search Doctor",
            "Exit"
        };
        display("========= Doctor Management =========");
        //program run from index 0 to index of menuList subtract 1 unit and print
        for (int i = 0; i < menuLists.length; i++) {
            display(i + 1 + "." + menuLists[i]);

        }
        return Validation.getInt("Enter your choice: ", 1, menuLists.length + 1);
    }

    public void display(String message) {
        System.out.println(message);
    }
// obj... para = variable number of arguments
    public void display(String formatString, Object... params) {
        System.out.printf(formatString, params);
    }

    public void warn(String message) {
        System.err.println(message);
    }

    public void warn(String formatString, Object... params) {
        System.out.printf(formatString, params);
    }

    public String getName(String label) {
        return Validation.getString(label, "[a-zA-Z ]{0,50}");
    }

    public String getString(String label) {
        return Validation.getString(label, "[a-zA-Z ]{0,50}");
    }

    public String getCode(String label) {
        return Validation.getString(label, "[a-zA-Z0-9 ]{1,50}");
    }

    public String getSpecialization(String label) {
        return Validation.getString(label, "[a-zA-Z0-9 ]{0,50}");
    }

    public int getAvailability(String label) {
        return Validation.getInt(label, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public String getUserYN(String label) {
        return Validation.getYN(label);
    }

}
