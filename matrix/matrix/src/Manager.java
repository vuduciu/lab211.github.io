/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 *
 */
public class Manager {

    GetData getData = new GetData();

    void DisplayMenu() {
        System.out.println("=====Calculator program====");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
    }

    int[][] getMatrix1() {
        int row = getData.getInt("Enter Row Matrix 1:", 1, Integer.MAX_VALUE);
        int column = getData.getInt("Enter Column Matrix 1:", 1, Integer.MAX_VALUE);
        int[][] matrix = new int[row][column];
        //traverse from first element of row to last element of row of matrix
        for (int i = 0; i < row; i++) {
            //traverse from first element of column to last element of column of matrix
            for (int j = 0; j < column; j++) {
                String message = String.format("Enter Matrix1" + "[%d][%d]:", i + 1, j + 1);
                matrix[i][j] = getData.getMatrix(message);
            }
        }
        return matrix;
    }

    int[][] getMatrix2(int[][] matrix1, int choice) {
        int[][] matrix2 = null;
        int rowM1 = matrix1.length;
        int colM1 = matrix1[0].length;
        int rowM2, colM2;
        if (choice == 3) {
            do {
                rowM2 = getData.getInt("Enter Row Matrix 2:", 1, Integer.MAX_VALUE);
                //check row of matrix2 equal or not column of matrix 1
                if (rowM2 != colM1) {
                    System.out.println("Row matrix 2 must be equal column matrix 1");
                    continue;
                }
                colM2 = getData.getInt("Enter Column Matrix 2:", 1, Integer.MAX_VALUE);
                break;
            } while (true);
        } else {
            do {
                rowM2 = getData.getInt("Enter Row Matrix 2:", 1, Integer.MAX_VALUE);
                //check row of matrix2 equal or not row of matrix 1
                if (rowM2 != rowM1) {
                    System.out.println("Row matrix 2 must be equal row matrix 1");
                    continue;
                } else {
                    break;
                }
            } while (true);

            do {
                colM2 = getData.getInt("Enter Column Matrix 2:", 1, Integer.MAX_VALUE);
                //check column of matrix2 equal or not column of matrix 1
                if (colM2 != colM1) {
                    System.out.println("Column matrix 2 must be equal column matrix 1");
                    continue;
                } else {
                    break;
                }
            } while (true);
        }

        matrix2 = new int[rowM2][colM2];
        //traverse from first element of row to last element of row of matrix
        for (int i = 0; i < rowM2; i++) {
            //traverse from first element of column to last element of column of matrix
            for (int j = 0; j < colM2; j++) {
                String message = String.format("Enter Matrix2" + "[%d][%d]:", i + 1, j + 1);
                matrix2[i][j] = getData.getMatrix(message);
            }
        }
        return matrix2;
    }

//    void displayMatrix(int[][] matrix) {
//        int row = matrix.length;
//        int col = matrix[0].length;
//        //traverse from first element of row to last element of row of matrix
//        for (int i = 0; i < row; i++) {
//            //traverse from first element of column to last element of column of matrix
//            for (int j = 0; j < col; j++) {
//                System.out.format("[%d]", matrix[i][j]);
//            }
//            System.out.println();
//        }
//    }
 void displayMatrix(int[][] matrix) {
    int[] colWidths = findMaxColWidths(matrix); // Tìm độ rộng tối đa của mỗi cột // Find the maximum width of each column

    for (int[] row : matrix) { // Lặp qua từng hàng trong ma trận // Loop through each row in the matrix
//         for (int i = 0; i < matrix.length; i++) { // Lặp qua từng hàng trong ma trận // Loop through each row in the matrix
//        int[] row = matrix[i];
        for (int j = 0; j < row.length; j++) { // Lặp qua từng phần tử trong hàng // Loop through each element in the row
            // In phần tử với độ rộng tương ứng // Print the element with the corresponding width
            System.out.format("%-" + colWidths[j] + "s", "[" + row[j] + "]");
        }
        System.out.println(); // Chuyển xuống dòng mới sau khi in hết hàng // Move to the next line after printing all elements in the row
    }
}
//để xác định độ rộng tối đa của mỗi cột trong ma trận matrix.
int[] findMaxColWidths(int[][] matrix) {
    int cols = matrix[0].length; // Xác định số cột // Determine the number of columns
    int[] colWidths = new int[cols]; // Khởi tạo mảng colWidths để lưu trữ độ rộng tối đa của mỗi cột // Initialize the colWidths array to store the maximum width of each column
    // Lặp qua từng hàng trong ma trận // Loop through each row in the matrix
    for (int[] row : matrix) {
        for (int j = 0; j < row.length; j++) { // Lặp qua từng phần tử trong hàng // Loop through each element in the row
            // Tính độ rộng của mỗi phần tử, bao gồm 2 ký tự cho dấu ngoặc vuông // Calculate the width of each element, including 2 characters for the square brackets
            int cellWidth = String.valueOf(row[j]).length() + 2; 
            if (cellWidth > colWidths[j]) { // Nếu độ rộng của phần tử lớn hơn độ rộng hiện tại của cột, cập nhật độ rộng // If the width of the element is greater than the current width of the column, update the width
                colWidths[j] = cellWidth;
            }
        }
    }

    // Thêm một khoảng đệm vào mỗi độ rộng cột để đảm bảo có một khoảng cách giữa các cột khi in // Add a single space padding to each column width to ensure there's a space between columns when printed
//    for (int j = 0; j < cols; j++) {
//        colWidths[j] += 1; // Thêm một khoảng trống // Add a space
//    }

    return colWidths; // Trả về mảng độ rộng của mỗi cột // Return the array of column widths
}


    void displayResult(int[][] matrix1, int[][] matrix2, int[][] result, int choice) {
        System.out.println("------- Result ----------");
        displayMatrix(matrix1);
        switch (choice) {
            case 1:
                System.out.println("+");
                break;
            case 2:
                System.out.println("-");
                break;
            case 3:
                System.out.println("*");
                break;
        }
        displayMatrix(matrix2);
        System.out.println("=");
        displayMatrix(result);
    }

    void displayAddition() {
        System.out.println("--------- Addition ------------");
    }

    void displaySubtraction() {
        System.out.println("--------- Subtraction ------------");
    }

    void displayMultiplication() {
        System.out.println("--------- Multiplication ------------");
    }
}
