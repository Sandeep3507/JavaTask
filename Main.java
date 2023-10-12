import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Task 1: Create an array and shuffle it
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7};
        List<Integer> numberList = Arrays.asList(numbers);
        Collections.shuffle(numberList);
        System.out.println("Shuffled array: " + Arrays.toString(numberList.toArray()));

        // Task 2: Convert a Roman Number to an integer
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a Roman Numeral: ");
        String romanNumeral = scanner.nextLine();
        int intValue = romanToInteger(romanNumeral);
        System.out.println("Integer value: " + intValue);

        // Task 3: Check if the input is a pangram
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();
        boolean isPangram = isPangram(sentence);
        System.out.println("Is it a pangram? " + isPangram);
    }

    public static int romanToInteger(String s) {
        // Implement the Roman to Integer conversion logic here
        // Example: IX = 9
        // You can use a map to define the values of Roman numerals and iterate through the input.
        // For a complete implementation, you can refer to Roman to Integer conversion algorithms online.
        // Here's a simple example for the Roman numerals I, V, X:
        int result = 0;
        int prevValue = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int currValue = getValue(s.charAt(i));
            if (currValue < prevValue) {
                result -= currValue;
            } else {
                result += currValue;
            }
            prevValue = currValue;
        }
        return result;
    }

    public static int getValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            // Add more cases for other Roman numerals as needed
            default:
                return 0;
        }
    }

    public static boolean isPangram(String sentence) {
        // Convert the sentence to lowercase and remove spaces
        sentence = sentence.toLowerCase().replaceAll(" ", "");

        // Create an array to mark the presence of each letter
        boolean[] alphabet = new boolean[26];

        // Iterate through the sentence and mark the presence of each letter
        for (char c : sentence.toCharArray()) {
            if ('a' <= c && c <= 'z') {
                alphabet[c - 'a'] = true;
            }
        }

        // Check if all letters from 'a' to 'z' are present
        for (boolean present : alphabet) {
            if (!present) {
                return false;
            }
        }
        return true;
    }
}
