import java.util.*;
import java.io.*;

public class Exercise21_04 {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a filename: ");
        String filename = input.next();
        File file = new File(filename);

        if (!file.exists()) {
            System.out.println("File " + filename + " does not exist");
            return;
        }

        Set<Character> vowels = new HashSet<>(Arrays.asList('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'));
        
        int vowelCount = 0;
        int consonantCount = 0;

        try (Scanner fileInput = new Scanner(file)) {
            while (fileInput.hasNext()) {
                String line = fileInput.nextLine();
                for (char ch : line.toCharArray()) {
                    if (Character.isLetter(ch)) {
                        if (vowels.contains(ch)) {
                            vowelCount++;
                        } else {
                            consonantCount++;
                        }
                    }
                }
            }
        }

        System.out.println("The number of vowels is " + vowelCount + 
            " and consonants is " + consonantCount);
    }
}