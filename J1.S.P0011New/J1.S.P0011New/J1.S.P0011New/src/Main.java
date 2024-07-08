public class Main {
    public static void main(String[] args) {
        Convert con = new Convert(); // Create an instance of Convert class. // Tạo một đối tượng của lớp Convert.
        int baseIn;
        int baseOut;
        while (true) {     
            baseIn = con.menuIn(); // Get the input base choice from user. // Lấy lựa chọn cơ số đầu vào từ người dùng.
            if(baseIn == 4){
                System.exit(0); // Exit the program if choice is 4. // Thoát chương trình nếu lựa chọn là 4.
            }
            baseOut = con.menuOut(); // Get the output base choice from user. // Lấy lựa chọn cơ số đầu ra từ người dùng.
            if(baseOut == 4){
                System.exit(0); // Exit the program if choice is 4. // Thoát chương trình nếu lựa chọn là 4.
            }
            System.out.println();
            con.inValue(baseIn); // Get the input value based on the input base. // Lấy giá trị đầu vào dựa trên cơ số đầu vào.
            System.out.println();
            System.out.print("Result Convert: ");
            con.convertResult(baseIn, baseOut); // Convert the input value and print the result. // Chuyển đổi giá trị đầu vào và in kết quả.
            System.out.println();
        }
    }
}
