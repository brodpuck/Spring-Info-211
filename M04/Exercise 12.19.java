import java.net.URL;
import java.util.*;

public class Exercise12_19 {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://liveexample.pearsoncmg.com/data/Lincoln.txt");
        Scanner input = new Scanner(url.openStream());
        int total = 0;

        while (input.hasNext()) {
            String line = input.nextLine();
            total += getNumberOfWords(line);
        }

        System.out.println("The total number of words is " + total);
        input.close();
    }

    public static int getNumberOfWords(String s) {
        String[] tokens = s.split("[\\s\\p{P}]+");

        int count = 0;
        for (String token : tokens) {
            if (token.trim().length() > 0) {
                count++;
            }
        }
        return count;
    }
}
