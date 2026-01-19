import java.util.Date;

public class Exercise09_05 {
    public static void main(String[] args) {
     
        Date date = new Date();

        System.out.println("Current date:");
        System.out.println("Year: " + (date.getYear() + 1900));
        System.out.println("Month: " + (date.getMonth() + 1));
        System.out.println("Day: " + date.getDate());

        System.out.println();

        date.setTime(1234567898765L);

        System.out.println("Date after setting elapsed time:");
        System.out.println("Year: " + (date.getYear() + 1900));
        System.out.println("Month: " + (date.getMonth() + 1));
        System.out.println("Day: " + date.getDate());
    }
}
