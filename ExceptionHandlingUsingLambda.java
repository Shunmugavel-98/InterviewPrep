import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExceptionHandlingUsingLambda {
    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(1, 2, 3, 4, 5, 0);

        // Using stream.map with exception handling
        List<Integer> results = array.stream().map(number -> {
            try {
                return 10 / number;
            } catch (ArithmeticException e) {
                System.err.println("Error: Cannot divide by zero");
                return null;
            }
        }).collect(Collectors.toList());
        System.out.println("Results: " + results);
    }
}