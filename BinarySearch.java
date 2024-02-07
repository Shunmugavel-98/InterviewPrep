import java.lang.System;

class BinarySearch {
    int binarySearch(int arr[], int left, int right, int elementToBeFound)
    {
        while (left <= right) {
            // To find the middle index
            int mid = left + (right - left) / 2;
            if (arr[mid] == elementToBeFound) {
                return mid; // Element found in this index
            } else if (arr[mid] > elementToBeFound) {
                right = mid - 1;
            } else {
              left = mid + 1;
            }  
        }
        return -1;
    }

    public static void main(String args[])
    {
        BinarySearch b = new BinarySearch();
        int arr[] = { 12, 23, 44, 110, 240 };
        int numberOfElements = arr.length;
        int result = b.binarySearch(arr, 0, numberOfElements - 1, 110);
        if (result == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index " + result); 
        }
    }
}
