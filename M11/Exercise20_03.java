import java.util.Scanner;
import java.util.Random;

public class Exercise20_03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        String[][] statesAndCapitals = {
            {"Alabama", "Montgomery"},
            {"Alaska", "Juneau"},
            {"Arizona", "Phoenix"},
            {"Arkansas", "Little Rock"},
            {"California", "Sacramento"},
            {"Colorado", "Denver"},
            {"Connecticut", "Hartford"},
            {"Delaware", "Dover"},
            {"Florida", "Tallahassee"},
            {"Georgia", "Atlanta"},
            {"Hawaii", "Honolulu"},
            {"Idaho", "Boise"},
            {"Illinois", "Springfield"},
            {"Indiana", "Indianapolis"},
            {"Iowa", "Des Moines"},
            {"Kansas", "Topeka"},
            {"Kentucky", "Frankfort"},
            {"Louisiana", "Baton Rouge"},
            {"Maine", "Augusta"},
            {"Maryland", "Annapolis"},
            {"Massachusetts", "Boston"},
            {"Michigan", "Lansing"},
            {"Minnesota", "Saint Paul"},
            {"Mississippi", "Jackson"},
            {"Missouri", "Jefferson City"},
            {"Montana", "Helena"},
            {"Nebraska", "Lincoln"},
            {"Nevada", "Carson City"},
            {"New Hampshire", "Concord"},
            {"New Jersey", "Trenton"},
            {"New York", "Albany"},
            {"New Mexico", "Santa Fe"},
            {"North Carolina", "Raleigh"},
            {"North Dakota", "Bismarck"},
            {"Ohio", "Columbus"},
            {"Oklahoma", "Oklahoma City"},
            {"Oregon", "Salem"},
            {"Pennsylvania", "Harrisburg"},
            {"Rhode Island", "Providence"},
            {"South Carolina", "Columbia"},
            {"South Dakota", "Pierre"},
            {"Tennessee", "Nashville"},
            {"Texas", "Austin"},
            {"Utah", "Salt Lake City"},
            {"Vermont", "Montpelier"},
            {"Virginia", "Richmond"},
            {"Washington", "Olympia"},
            {"West Virginia", "Charleston"},
            {"Wisconsin", "Madison"},
            {"Wyoming", "Cheyenne"}
        };

        for (int i = statesAndCapitals.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);

            // Swap rows
            String[] temp = statesAndCapitals[i];
            statesAndCapitals[i] = statesAndCapitals[j];
            statesAndCapitals[j] = temp;
        }

        int correctCount = 0;

        for (int i = 0; i < statesAndCapitals.length; i++) {
            System.out.print("What is the capital of " 
                + statesAndCapitals[i][0] + "? ");
            String answer = input.nextLine();

            if (answer.equalsIgnoreCase(statesAndCapitals[i][1])) {
                System.out.println("Your answer is correct");
                correctCount++;
            } else {
                System.out.println("The correct answer should be " 
                    + statesAndCapitals[i][1]);
            }
        }

        System.out.println("The correct count is " + correctCount);
    }
}