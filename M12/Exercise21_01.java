import java.util.*;

public class Exercise21_01 {
    public static void main(String[] args) {
        LinkedHashSet<String> set1 = new LinkedHashSet<>(Arrays.asList(
            "George", "Jim", "John", "Blake", "Kevin", "Michael"));

        LinkedHashSet<String> set2 = new LinkedHashSet<>(Arrays.asList(
            "George", "Katie", "Kevin", "Michelle", "Ryan"));

        LinkedHashSet<String> union = (LinkedHashSet<String>)set1.clone();
        union.addAll(set2);
        System.out.println("The union of the two sets is: " + union);

        LinkedHashSet<String> difference = (LinkedHashSet<String>)set1.clone();
        difference.removeAll(set2);
        System.out.println("The difference of the two sets is: " + difference);

        LinkedHashSet<String> intersection = (LinkedHashSet<String>)set1.clone();
        intersection.retainAll(set2);
        System.out.println("The intersection of the two sets is: " + intersection);
    }
}