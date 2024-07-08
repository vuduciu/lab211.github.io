package j1sp0051;

public class Manager {
    // Display menu
    public static int menu() {
        System.out.println("1. Normal Calculator");
        System.out.println("2. BMI Calculator");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        return Validation.checkInputIntLimit(1, 3);
    }

    // Allow user to input a number
    public static double inputNumber(String prompt) {
        System.out.print(prompt);
        return Validation.checkInputDouble();
    }

    // Allow user to perform normal calculations
    public static void normalCalculator() {
        double memory = inputNumber("Enter number: ");   
        while (true) {
            String operator = Validation.checkInputOperator("Enter Operator: ");           
            if (operator.equals("=")) {
                System.out.println("Result: " + memory);
                return;
            }
            double number = inputNumber("Enter number: ");
            
            switch (operator) {
                case "+":
                    memory += number;
                    break;
                case "-":
                    memory -= number;
                    break;
                case "*":
                    memory *= number;
                    break;
                case "/":
                    memory /= number;
                    break;
                case "^":
                    memory = Math.pow(memory, number);
                    break;
            }
            System.out.println("Memory: " + memory);
        }
    }

    // Display BMI status
    public static String BMIStatus(double bmi) {
        if (bmi < 19) {
            return "Under-standard.";
        } else if (bmi < 25) {
            return "Standard.";
        } else if (bmi < 30) {
            return "Overweight.";
        } else if (bmi < 40) {
            return "Fat - should lose weight.";
        } else {
            return "Very fat - should lose weight immediately.";
        }
    }

    // Allow user to perform BMI calculations
    public static void BMICalculator() {
        double weight = inputNumber("Enter Weight (kg): ");
        double height = inputNumber("Enter Height (cm): ");
        double bmi = weight * 10000 / (height * height);
        System.out.printf("BMI number: %.2f\n", bmi);
        System.out.println("BMI Status: " + BMIStatus(bmi));
    }
}