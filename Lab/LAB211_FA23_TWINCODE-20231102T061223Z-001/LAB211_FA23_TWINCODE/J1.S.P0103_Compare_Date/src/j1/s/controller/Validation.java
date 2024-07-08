package j1.s.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Validation {

    public Date inputDate(String msg) {
        Scanner sc = new Scanner(System.in);
        String input;
        Date date;
        while (true) {
            System.out.println(msg);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            // setLinient = false để cho dateFormat không tự động chỉnh lại date đúng
            dateFormat.setLenient(false);
            // nếu linient là true thì 30/2/2003 -> 1/3/2003
            // nhập vào
            input = sc.next();
            if (input.isEmpty()) {
                System.err.println("Date must not empty !!!");
                continue;
            } // nếu nó đúng cái format là số
            else if (!checkContainCharacter(input)) {
                // \d{1,2}: có thể có 1 hoặc 2 số
                // \d{4} : có 4 số
                // [/] : chứa cái kí tự /
                String patternDate = "\\d{1,2}[/]\\d{1,2}[/]\\d{4}";
                // nếu input không đúng format của pattern mình đưa vào
                if (!input.matches(patternDate)) {
                    System.err.println("Date is wrong format date !!!");
                    continue;
                }
                try {
                    date = dateFormat.parse(input);
                    return date;
                } catch (ParseException dateException) {
                    System.err.println("Date does not existed !!!");
                    continue;
                }

            }
            // nếu nó chứa chữ
            else {
                System.err.println("Input contain character !!!");
                continue;
            }

            // dd/mm/yyyy chỉ chứa số cho nên kiểm tra xem là cái sâu mình nhập vào nó có
            // chữ hay không
        }
    }

    public boolean checkContainCharacter(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (Character.isAlphabetic(input.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
