import java.util.LinkedList;
import java.util.Scanner;

class SelectionSort {

    // Swapping two indices
    private void swap(int minIndex, int currIndex, LinkedList<Integer> arr) {
        Integer tempValue = arr.get(minIndex);
        arr.set(minIndex, arr.get(currIndex));
        arr.set(currIndex, tempValue);
    }

    // Sort functionality
    private void sort(LinkedList<Integer> arr, int numberOfElements) {
        for (int index = 0; index < numberOfElements - 1; index++) {
            int minIndex = index; // Stores the minimum value index from the current index to the end of the array
            for (int iter = index + 1; iter < numberOfElements; iter++) {
                if (arr.get(iter) < arr.get(minIndex)) {
                    minIndex = iter;
                }
            }
            swap(minIndex, index, arr);
        }
    }

    public static void main(String args[]) {
        SelectionSort selectionSort = new SelectionSort();
        LinkedList<Integer> arr = new LinkedList<>();
        arr.add(1);
        arr.add(22);
        arr.add(4);
        arr.add(3);
        arr.add(6);
        selectionSort.sort(arr, 5);
        System.out.println("Elements after sorting ");
        for (Integer element : arr) {
            System.out.print(element + " ");
        }
    }
}