package j1sp0073;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * Utility class for input validation.
 * Lớp tiện ích để xác thực đầu vào.
 */
public class Validate {
    private static final Scanner in = new Scanner(System.in);
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

    /**
     * Validates and returns an integer within a specified range.
     * Xác thực và trả về một số nguyên trong một khoảng nhất định.
     *
     * @param min Minimum value (inclusive) / Giá trị nhỏ nhất (bao gồm)
     * @param max Maximum value (inclusive) / Giá trị lớn nhất (bao gồm)
     * @return Valid integer within the range / Số nguyên hợp lệ trong khoảng
     */
    public static int checkIntLimit(int min, int max) {
        while (true) {
            try {
                int number = Integer.parseInt(in.nextLine());
                if (number < min || number > max) {
                    throw new NumberFormatException();
                }
                return number;
            } catch (NumberFormatException e) {
                System.err.println("Invalid input. Please enter a number between " + min + " and " + max + ".");
                // Đầu vào không hợp lệ. Vui lòng nhập số từ " + min + " đến " + max + ".
            }
        }
    }

    /**
     * Validates and returns a date string in the format dd-MMM-yyyy.
     * Xác thực và trả về chuỗi ngày tháng theo định dạng dd-MMM-yyyy.
     *
     * @return Valid date string / Chuỗi ngày tháng hợp lệ
     */
    public static String checkInputDate(String msg) {
        while (true) {
            System.out.print(msg);
            String dateStr = in.nextLine().trim();
            try {
                LocalDate date= LocalDate.parse(dateStr, DATE_FORMATTER);
                if (date.isAfter(LocalDate.now())) {
                    System.err.println("Date cannot be in the future. Please enter a valid date.");
                    // Ngày không thể ở tương lai. Vui lòng nhập ngày hợp lệ.
                } else {
                    return dateStr;
                }
            } catch (DateTimeParseException e) {
                System.err.println("Invalid date format. Please enter the date in the format dd-MMM-yyyy.");
                // Định dạng ngày không hợp lệ. Vui lòng nhập theo định dạng dd-MMM-yyyy.
            }
        }
    }

    /**
     * Validates and returns a double value.
     * Xác thực và trả về giá trị kiểu double.
     *
     * @return Valid double value / Giá trị kiểu double hợp lệ
     */
    public static double checkInputDouble(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Double.parseDouble(in.nextLine().trim());
            } catch (NumberFormatException e) {
                System.err.println("Invalid input. Please enter a valid number.");
                // Đầu vào không hợp lệ. Vui lòng nhập số hợp lệ.
            }
        }
    }

    /**
     * Validates and returns a non-empty string.
     * Xác thực và trả về một chuỗi không rỗng.
     *
     * @return Valid non-empty string / Chuỗi không rỗng hợp lệ
     */
    public static String checkInputString(String msg) {
        while (true) {
            System.out.print(msg);
            String input = in.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            } else {
                System.err.println("Input cannot be empty. Please enter a valid content.");
                // Đầu vào không được để trống. Vui lòng nhập nội dung hợp lệ.
            }
        }
    }

    /**
     * Validates and returns an integer.
     * Xác thực và trả về một số nguyên.
     *
     * @return Valid integer / Số nguyên hợp lệ
     */
    public static int checkInputInt() {
        while (true) {
            try {
                return Integer.parseInt(in.nextLine().trim());
            } catch (NumberFormatException e) {
                System.err.println("Invalid input. Please enter a valid integer.");
                // Đầu vào không hợp lệ. Vui lòng nhập một số nguyên hợp lệ.
            }
        }
    }
}
