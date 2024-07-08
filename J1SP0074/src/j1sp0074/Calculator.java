package j1sp0074;

public class Calculator {
    private final MatrixHelper helper;
    private final Validation validator;

    public Calculator(MatrixHelper helper, Validation validator) {
        this.helper = helper;
        this.validator = validator;
    }

    public void addMatrices() {
    int rows1 = validator.validateMatrixSize("Enter number of rows for matrix 1: ");
    int cols1 = validator.validateMatrixSize("Enter number of columns for matrix 1: ");
    int[][] matrix1 = helper.getMatrix(rows1, cols1);

    int rows2 = validator.validateMatrixSize("Enter number of rows for matrix 2: ");
    int cols2 = validator.validateMatrixSize("Enter number of columns for matrix 2: ");

    if (rows1 != rows2 || cols1 != cols2) {
        System.out.println("Cannot add matrices. Invalid dimensions.");
        System.out.println("The dimensions of both matrices must be the same.");
        return;
    }

    int[][] matrix2 = helper.getMatrix(rows2, cols2);

    int[][] result = new int[rows1][cols1];

    for (int i = 0; i < rows1; i++) {
        for (int j = 0; j < cols1; j++) {
            result[i][j] = matrix1[i][j] + matrix2[i][j];
        }
    }

    helper.printMatrix(matrix1, rows1, cols1);
    System.out.println("+");
    helper.printMatrix(matrix2, rows2, cols2);
    System.out.println("=");
    helper.printMatrix(result, rows1, cols1);
}

public void subMatrices() {
    int rows1 = validator.validateMatrixSize("Enter number of rows for matrix 1: ");
    int cols1 = validator.validateMatrixSize("Enter number of columns for matrix 1: ");
    int[][] matrix1 = helper.getMatrix(rows1, cols1);

    int rows2 = validator.validateMatrixSize("Enter number of rows for matrix 2: ");
    int cols2 = validator.validateMatrixSize("Enter number of columns for matrix 2: ");

    if (rows1 != rows2 || cols1 != cols2) {
        System.out.println("Cannot subtract matrices. Invalid dimensions.");
        System.out.println("The dimensions of both matrices must be the same.");
        return;
    }

    int[][] matrix2 = helper.getMatrix(rows2, cols2);

    int[][] result = new int[rows1][cols1];

    for (int i = 0; i < rows1; i++) {
        for (int j = 0; j < cols1; j++) {
            result[i][j] = matrix1[i][j] - matrix2[i][j];
        }
    }

    helper.printMatrix(matrix1, rows1, cols1);
    System.out.println("-");
    helper.printMatrix(matrix2, rows2, cols2);
    System.out.println("=");
    helper.printMatrix(result, rows1, cols1);
}



    public void multiplyMatrices() {
    int rows1 = validator.validateMatrixSize("Enter number of rows for matrix 1: ");
    int cols1 = validator.validateMatrixSize("Enter number of columns for matrix 1: ");
    int[][] matrix1 = helper.getMatrix(rows1, cols1);

    int rows2 = validator.validateMatrixSize("Enter number of rows for matrix 2: ");
    int cols2 = validator.validateMatrixSize("Enter number of columns for matrix 2: ");

    while (cols1 != rows2) {
        System.out.println("Cannot multiply matrices. Invalid dimensions.");
        System.out.println("Number of columns in matrix 1 must be equal to the number of rows in matrix 2.");
        rows2 = validator.validateMatrixSize("Enter number of rows for matrix 2: ");
        cols2 = validator.validateMatrixSize("Enter number of columns for matrix 2: ");
    }

    int[][] matrix2 = helper.getMatrix(rows2, cols2);

    int[][] result = new int[rows1][cols2];

    for (int i = 0; i < rows1; i++) {
        for (int j = 0; j < cols2; j++) {
            for (int k = 0; k < cols1; k++) {
                result[i][j] += matrix1[i][k] * matrix2[k][j];
            }
        }
    }

    helper.printMatrix(matrix1, rows1, cols1);
    System.out.println("*");
    helper.printMatrix(matrix2, rows2, cols2);
    System.out.println("=");
    helper.printMatrix(result, rows1, cols2);
}

}
