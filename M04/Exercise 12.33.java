import java.util.Scanner;
import java.util.ArrayList;

public class Exercise12_33 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter a word to search for: ");
    String word = input.nextLine();

    System.out.print("Enter a starting URL: ");
    String url = input.nextLine();

    crawler(url, word);
  }

  public static void crawler(String startingURL, String word) {
    ArrayList<String> listOfPendingURLs = new ArrayList<>();
    ArrayList<String> listOfTraversedURLs = new ArrayList<>();

    listOfPendingURLs.add(startingURL);

    while (!listOfPendingURLs.isEmpty() &&
           listOfTraversedURLs.size() <= 100) {

      String urlString = listOfPendingURLs.remove(0);

      if (!listOfTraversedURLs.contains(urlString)) {
        listOfTraversedURLs.add(urlString);
        System.out.println("Crawl " + urlString);

        if (containsWord(urlString, word)) {
          System.out.println("\nWord \"" + word + "\" found at:");
          System.out.println(urlString);
          return; 
        }

        for (String s : getSubURLs(urlString)) {
          if (!listOfTraversedURLs.contains(s))
            listOfPendingURLs.add(s);
        }
      }
    }

    System.out.println("\nWord \"" + word + "\" was not found.");
  }

  public static boolean containsWord(String urlString, String word) {
    try {
      java.net.URL url = new java.net.URL(urlString);
      Scanner input = new Scanner(url.openStream());

      while (input.hasNextLine()) {
        String line = input.nextLine();
        if (line.toLowerCase().contains(word.toLowerCase())) {
          input.close();
          return true;
        }
      }
      input.close();
    }
    catch (Exception ex) {
    }

    return false;
  }

  public static ArrayList<String> getSubURLs(String urlString) {
    ArrayList<String> list = new ArrayList<>();

    try {
      java.net.URL url = new java.net.URL(urlString);
      Scanner input = new Scanner(url.openStream());

      while (input.hasNextLine()) {
        String line = input.nextLine();
        int current = line.indexOf("http:");
        while (current >= 0) {
          int endIndex = line.indexOf("\"", current);
          if (endIndex > 0) {
            list.add(line.substring(current, endIndex));
            current = line.indexOf("http:", endIndex);
          } else {
            current = -1;
          }
        }
      }
      input.close();
    }
    catch (Exception ex) {
    }

    return list;
  }
}
