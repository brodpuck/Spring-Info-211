import java.util.Scanner;

public class Exercise22_01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = input.nextLine();

        String maxSubstring = "";
        StringBuilder currentSubstring = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (currentSubstring.length() > 0 && 
                s.charAt(i) <= currentSubstring.charAt(currentSubstring.length() - 1)) {
                currentSubstring.setLength(0);
            }
            
            currentSubstring.append(s.charAt(i));

            if (currentSubstring.length() > maxSubstring.length()) {
                maxSubstring = currentSubstring.toString();
            }
        }

        System.out.println("Maximum consecutive increasingly ordered substring is " + maxSubstring);
    }
}