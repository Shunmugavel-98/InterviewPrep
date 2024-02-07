import java.util.Scanner;

public class MaxSubArraySumOfKLength {

    private int findMaxSubArraySumOfKLength(int[] array, int k) {
        int result = 0;
        for (int index = 0; index < k; index++) {
            result += array[index]; // First window sum
        }

        int currSum = result;
        for (int index = k; index < array.length; index++)
        {
            currSum += (array[index] - array[index - k]); // neglect first element from sub array window and check if it's greater sum
            result = Math.max(result, currSum);
        }

        return result;
    }

    public static void main(String[] args) {
        MaxSubArraySumOfKLength obj = new MaxSubArraySumOfKLength();
        System.out.println("Enter the number of elements: ");
        Scanner scanner = new Scanner(System.in);
        int numberOfElements = scanner.nextInt();
        int[] array = new int[numberOfElements];
        System.out.println("Enter array elements: ");
        for (int index = 0; index < numberOfElements; index++) {
            array[index] = scanner.nextInt();
        }
        System.out.println("Enter size of k: ");
        int k = scanner.nextInt();
        System.out.println("The maximum sub array sum of length " + k + "is: ");
        System.out.println(obj.findMaxSubArraySumOfKLength(array, k));
    }
}
