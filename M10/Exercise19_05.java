import java.util.Scanner;

public class Exercise19_05 {
    public static void main(String[] args) {
        Integer[] numbers = new Integer[10];
        Scanner input = new Scanner(System.in);
        System.out.print("Enter 10 integers: ");
        for (int i = 0; i < numbers.length; i++)
            numbers[i] = input.nextInt();

        System.out.println("The max number is " + max(numbers));
    }

    public static <E extends Comparable<E>> E max(E[] list) {
        E max = list[0];

        for (int i = 1; i < list.length; i++) {
            if (max.compareTo(list[i]) < 0) {
                max = list[i];
            }
        }

        return max;
    }
}