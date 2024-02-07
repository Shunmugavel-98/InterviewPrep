import java.util.Scanner;

public class InsertionSort {

    private void sort(int[] arr) {
        for (int currIndex = 1; currIndex < 5; currIndex++) {
            int currValue = arr[currIndex];
            int index = currIndex - 1;
            while (index >= 0 && arr[index] > currValue) {
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = currValue; // placing current value in correct index to make array sorted
        }
    }

    public static void main(String args[]) {
        InsertionSort insertionSort = new InsertionSort();
        int[] arr = new int[5];
        System.out.println("Enter five elements: ");
        Scanner scanner = new Scanner(System.in);
        for (int iter = 0; iter < 5; iter++) {
            arr[iter] = scanner.nextInt();
        }
        insertionSort.sort(arr);
        System.out.println("Elements after sorting: ");
        for (Integer element : arr) {
            System.out.print(element + " ");
        }
    }
}
