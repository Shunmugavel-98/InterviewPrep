import java.util.Scanner;

public class MaxSubArraySum {

    private int findMaxSubArraySum(int[] array) {
        int currSum = 0, maxSum = 0;
        for (int index = 0; index < array.length; index++) {
            currSum += array[index];
            if (maxSum < currSum) {
                maxSum = currSum;
            }
            if (currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaxSubArraySum obj = new MaxSubArraySum();
        System.out.println("Enter the number of elements: ");
        Scanner scanner = new Scanner(System.in);
        int numberOfElements = scanner.nextInt();
        int[] array = new int[numberOfElements];
        System.out.println("Enter array elements: ");
        for (int index = 0; index < numberOfElements; index++) {
            array[index] = scanner.nextInt();
        }
        System.out.println("The maximum sub array sum for the given elements is: ");
        System.out.println(obj.findMaxSubArraySum(array));
    }
}
