import java.util.Scanner;

public class Validate {

    private final Scanner sc = new Scanner(System.in);

    // Get the user's choice and validate it.
    // Lấy lựa chọn của người dùng và kiểm tra hợp lệ.
    public int choice() {
        int i;
        while (true) {
            try {
                System.out.print("Enter your choice: ");
                i = Integer.parseInt(sc.nextLine());
                if (i > 0 && i <= 4) {
                    return i; // Return the valid choice. // Trả về lựa chọn hợp lệ.
                }
                throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("Enter choice from 1 to 4"); // Prompt user for valid input. // Yêu cầu người dùng nhập hợp lệ.
            }
        }
    }

    // Get and validate decimal input from the user.
    // Lấy và kiểm tra hợp lệ đầu vào thập phân từ người dùng.
    public String inDecimal() {
        String decimal;
        while (true) {
            try {
                System.out.print("Enter decimal number: ");
                decimal = sc.nextLine();
                if (decimal.matches("^[0-9]+$")) {
                    return decimal; // Return valid decimal input. // Trả về đầu vào thập phân hợp lệ.
                }
                throw new Exception();
            } catch (Exception e) {
                System.out.println("Enter digit and greater or equal zero"); // Prompt user for valid decimal input. // Yêu cầu người dùng nhập số hợp lệ và lớn hơn hoặc bằng không.
            }
        }
    }

    // Get and validate binary input from the user.
    // Lấy và kiểm tra hợp lệ đầu vào nhị phân từ người dùng.
    public String inBinary() {
        String binary;
        while (true) {
            try {
                System.out.print("Enter binary number: ");
                binary = sc.nextLine();
                if (binary.matches("^[01]+$")) {
                    return binary; // Return valid binary input. // Trả về đầu vào nhị phân hợp lệ.
                }
                throw new Exception();
            } catch (Exception e) {
                System.out.println("Enter all digit have 0 or 1"); // Prompt user for valid binary input. // Yêu cầu người dùng nhập tất cả chữ số là 0 hoặc 1.
            }
        }
    }

    // Get and validate hexadecimal input from the user.
    // Lấy và kiểm tra hợp lệ đầu vào thập lục phân từ người dùng.
    public String inHexadecimal() {
        String hexa;
        while (true) {
            try {
                System.out.print("Enter hexadecimal number: ");
                hexa = sc.nextLine();
                if (!hexa.isEmpty() && hexa.matches("^[0-9a-fA-F]+$")) {
                    return hexa; // Return valid hexadecimal input. // Trả về đầu vào thập lục phân hợp lệ.
                }
                throw new Exception();
            } catch (Exception e) {
                System.out.println("Must enter hexadecimal number"); // Prompt user for valid hexadecimal input. // Yêu cầu người dùng nhập số thập lục phân hợp lệ.
            }
        }
    }
}