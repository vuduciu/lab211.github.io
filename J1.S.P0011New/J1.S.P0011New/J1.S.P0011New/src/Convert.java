import java.math.BigInteger;

public class Convert {

    // Initialize an instance of the Validate class for user input validation.
    // Khởi tạo một đối tượng của lớp Validate để kiểm tra đầu vào của người dùng.
    private final Validate val = new Validate();
    private String value;

    public Convert() {
    }

    // Display menu for converting from a base and get the user's choice.
    // Hiển thị menu để chuyển đổi từ một cơ số và lấy lựa chọn của người dùng.
    public int menuIn() {
        System.out.println("+===== Convert From Base =======+");
        System.out.println("1. Convert From Binary.");
        System.out.println("2. Convert From Decimal.");
        System.out.println("3. Convert From Hexadecimal.");
        System.out.println("4. Quit.");
        return val.choice();
    }

    // Display menu for converting to a base and get the user's choice.
    // Hiển thị menu để chuyển đổi sang một cơ số và lấy lựa chọn của người dùng.
    public int menuOut() {
        System.out.println("+===== Convert To Base =========+");
        System.out.println("1. Convert To Binary.");
        System.out.println("2. Convert To Decimal.");
        System.out.println("3. Convert To Hexadecimal.");
        System.out.println("4. Quit.");
        return val.choice();
    }

    // Convert a number from a specified base to decimal.
    // Chuyển đổi một số từ cơ số chỉ định sang thập phân.
    public int otherToDec(String other, int base) {
        BigInteger result = BigInteger.ZERO;
        BigInteger baseValue = BigInteger.ONE;

        // Loop through each character from right to left.
        // Vòng lặp qua từng ký tự từ phải sang trái.
        for (int i = other.length() - 1; i >= 0; i--) {
            char c = other.charAt(i); // Get the character at position i. // Lấy ký tự tại vị trí i.
            BigInteger temp;
            if (Character.isDigit(c)) {
                temp = BigInteger.valueOf(c - '0'); // Convert digit character to numeric value. // Chuyển đổi ký tự số thành giá trị số.
            } else {
                temp = BigInteger.valueOf(Character.toUpperCase(c) - 'A' + 10); // Convert letter to numeric value. // Chuyển đổi ký tự chữ cái thành giá trị số.
            }
            result = result.add(temp.multiply(baseValue)); // Add the value to the result. // Thêm giá trị vào kết quả.
            baseValue = baseValue.multiply(BigInteger.valueOf(base)); // Increase base value for next digit. // Tăng giá trị cơ số cho chữ số tiếp theo.
        }   
        return result.intValue(); // Return the final decimal result. // Trả về kết quả thập phân cuối cùng.
    }

    // Convert a decimal number to a specified base.
    // Chuyển đổi một số thập phân sang cơ số chỉ định.
    public String decToOther(int dec, int base) {
        if (dec == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        BigInteger decimalValue = BigInteger.valueOf(dec);
        // Loop until all values are converted.
        // Vòng lặp cho đến khi tất cả các giá trị được chuyển đổi.
        while (decimalValue.compareTo(BigInteger.ZERO) > 0) {
            BigInteger remainder = decimalValue.mod(BigInteger.valueOf(base)); // Get remainder of division. // Lấy phần dư của phép chia.
            if (remainder.compareTo(BigInteger.valueOf(9)) <= 0) {
                sb.insert(0, remainder); // Insert numeric value. // Chèn giá trị số.
            } else {
                char c = (char) ('A' + remainder.intValue() - 10); // Convert numeric value to character. // Chuyển đổi giá trị số thành ký tự.
                sb.insert(0, c);
            }
            decimalValue = decimalValue.divide(BigInteger.valueOf(base)); // Update the decimal value. // Cập nhật giá trị thập phân.
        }
        return sb.toString(); // Return the final result in the new base. // Trả về kết quả cuối cùng trong cơ số mới.
    }

    // Get the input value based on the input base choice.
    // Lấy giá trị đầu vào dựa trên lựa chọn cơ số đầu vào.
    public void inValue(int baseIn) {
        switch (baseIn) {
            case 1:
                value = val.inBinary(); // Get binary input. // Lấy đầu vào nhị phân.
                break;
            case 2:
                value = val.inDecimal(); // Get decimal input. // Lấy đầu vào thập phân.
                break;
            default:
                value = val.inHexadecimal(); // Get hexadecimal input. // Lấy đầu vào thập lục phân.
                break;
        }
    }

    // Convert the input value from one base to another base and print the result.
    // Chuyển đổi giá trị đầu vào từ một cơ số sang cơ số khác và in kết quả.
    public void convertResult(int baseIn, int baseOut) {
        int decimal = 0;
        String result;

        // Convert input value to decimal.
        // Chuyển đổi giá trị đầu vào sang thập phân.
        switch (baseIn) {
            case 1:
                decimal = otherToDec(value, 2); // Convert from binary to decimal. // Chuyển từ nhị phân sang thập phân.
                break;
            case 2:
                decimal = Integer.parseInt(value); // Parse the decimal input directly. // Phân tích cú pháp đầu vào thập phân trực tiếp.
                break;
            default:
                decimal = otherToDec(value, 16); // Convert from hexadecimal to decimal. // Chuyển từ thập lục phân sang thập phân.
                break;
        }

        // Convert decimal value to the target base.
        // Chuyển đổi giá trị thập phân sang cơ số đích.
        switch (baseOut) {
            case 1:
                result = decToOther(decimal, 2); // Convert from decimal to binary. // Chuyển từ thập phân sang nhị phân.
                break;
            case 2:
                result = Integer.toString(decimal); // Convert decimal to string. // Chuyển đổi thập phân sang chuỗi.
                break;
            default:
                result = decToOther(decimal, 16); // Convert from decimal to hexadecimal. // Chuyển từ thập phân sang thập lục phân.
                break;
        }
        System.out.println(result); // Print the result. // In kết quả.
    }
}
