import java.util.ArrayList;
import java.util.Scanner;

public class Exercise13_03 {

    public static void sort(ArrayList<Number> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).doubleValue() < list.get(minIndex).doubleValue()) {
                    minIndex = j;
                }
            }

            Number temp = list.get(i);
            list.set(i, list.get(minIndex));
            list.set(minIndex, temp);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Number> list = new ArrayList<>();

        System.out.print("Enter five integers and five doubles: ");

        for (int i = 0; i < 5; i++) {
            list.add(input.nextInt());
        }

        for (int i = 0; i < 5; i++) {
            list.add(input.nextDouble());
        }

        sort(list);

        for (Number n : list) {
            System.out.print(n + " ");
        }
    }
}
