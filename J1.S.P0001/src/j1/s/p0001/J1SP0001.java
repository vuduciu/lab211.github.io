package j1.s.p0001;

import java.util.Random;
import java.util.Scanner;

public class J1SP0001 {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int numberSize = inputPositive("Enter Number Size:", 0);
        int array[] = getRandomArray(numberSize);
        display(array, "Mảng ban đầu:");
        //quickSort(array, 0, array.length - 1);
        selecTionSort(array);
        display(array, "Mảng sau khi sắp xếp:");
    }

    public static int inputPositive(String msg, int min) {
        while (true) {
            try {
                System.out.print(msg);
                String input = sc.nextLine();
                if (input.isEmpty() || input == null) {
                    throw new EmptyException("Not allow empty input! Please enter again.");
                }
                int numberOfResult = Integer.parseInt(input);
                if (numberOfResult <= min) {
                    throw new PositiveException("Not negative input! Please enter again.");
                }
                return numberOfResult;
            } catch (NumberFormatException e1) {
                System.out.println("You must enter a number");
                continue;
            } catch (EmptyException e2) {
                System.out.println(e2.getMessage());
                continue;
            } catch (PositiveException e3) {
                System.out.println(e3.getMessage());
                continue;
            }
        }
    }

    private static class EmptyException extends Exception {
        public EmptyException(String msg) {
            super(msg);
        }
    }

    private static class PositiveException extends Exception {
        public PositiveException(String message) {
            super(message);
        }
    }

    public static int[] getRandomArray(int size_range) {
        int[] array = new int[size_range];
        Random random = new Random();
        for (int i = 0; i < size_range; i++) {
            int number_size = random.nextInt(2 * size_range +1) - size_range;
            array[i] = number_size;
        }
        return array;
    }

    public static void display(int[] array, String msg) {
        int size = array.length;
        System.out.print(msg);
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i]);
            if (i < size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // Hàm hoán đổi hai phần tử trong mảng
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Hàm phân hoạch mảng với pivot ngẫu nhiên
    private static int partition(int[] arr, int low, int high) {
        int pivotIndex = low + new Random().nextInt(high - low + 1);
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, high);  // Đưa pivot về cuối mảng
        int i = low;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, high);  // Đưa pivot về vị trí đúng
        return i;
    }

    // Hàm quicksort chính được tối ưu hóa
    public static void quickSort(int[] arr, int low, int high) {
        while (low < high) {
            int pi = partition(arr, low, high);

            if (pi - low < high - pi) {
                quickSort(arr, low, pi - 1);
                low = pi + 1;
            } else {
                quickSort(arr, pi + 1, high);
                high = pi - 1;
            }
        }
    }


public static void selecTionSort(int[] array) {
        int size = array.length;
        for (int i = 0; i < size - 1; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }

            }
            if(min!=i){
            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
            }
        }
    }
public static void inserTionSort(int[] array) {
        int size = array.length;
        for (int i = 1; i < size; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j--];               
            }
            array[j + 1] = key;
        }
    }
   /* static int partition(int a[], int l, int r) {
        int i = l, j = r;
        int tmp;
        int pivot = a[(l + r) / 2];

        while (i <= j) {
            while (a[i] < pivot) {
                i++;
            }
            while (a[j] > pivot) {
                j--;
            }
            if (i <= j) {
                tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                i++;
                j--;
            }
        }
        return i;
    }

    static void quickSort(int a[], int l, int r) {
        int index = partition(a, l, r);
        if (l < index - 1) {
            quickSort(a, l, index - 1);
        }
        if (index < r) {
            quickSort(a, index, r);
        }
    }

*/
}

