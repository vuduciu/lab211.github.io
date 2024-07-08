package j1sp0102;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class J1SP0102 {
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false); // xu li loi nguoi dung khi nhap sai

        System.out.print("Please enter date with format [dd/mm/yyyy]: ");
        String inputDateStr = sc.nextLine();

        try {
            Date date = dateFormat.parse(inputDateStr);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            String dayOfWeekStr = getDayOfWeekAsString(dayOfWeek);

            System.out.println("Your day is " + dayOfWeekStr);
        } catch (Exception e) {
            System.out.println("Invalid date format or invalid date. Please enter a valid date in the format [dd/mm/yyyy].");
        }
    }

    public static String getDayOfWeekAsString(int dayOfWeek) {
        String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        return daysOfWeek[dayOfWeek -1];
    }
}
