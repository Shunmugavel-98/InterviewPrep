import java.util.Arrays;
import java.util.List;

public class ExceptionHandlingUsingStreams {
    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(1, 2, 3, 4, 5, 0);

        // Using streams with exception handling
        array.stream().forEach(number -> {
            try {
                int result = 1000 / number;
                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                System.err.println("Error: Cannot divide by zero");
            }
        });
    }
}