import java.util.ArrayList;

public class Exercise11_07 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        shuffle(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    public static void shuffle(ArrayList<Integer> list) {
        for (int i = list.size() - 1; i > 0; i--) {
            int j = (int)(Math.random() * (i + 1));

            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }
    }
}
