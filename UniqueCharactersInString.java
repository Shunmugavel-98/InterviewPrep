import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UniqueCharactersInString {
    public static void main(String[] args) {
        System.out.println("Enter the String to find unique characters: ");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        Map<Character, Integer> map = new HashMap<>();
        for (int index = 0; index < string.length(); index++) {
            char character = string.charAt(index);
            if (map.containsKey(character)) {
                map.put(character, map.get(character) + 1);
            } else {
                map.put(character, 1);
            }
        }
        System.out.println("The unique characters are : ");
        for (int index = 0; index < string.length(); index++) {
            char character = string.charAt(index);
            if (map.get(character) == 1) {
                System.out.println(character);
            }
        }
    }
}
