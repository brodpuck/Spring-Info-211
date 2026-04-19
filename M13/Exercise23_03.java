import java.util.Comparator;

public class Exercise23_03 {
  public static <E extends Comparable<E>> void quickSort(E[] list) {
    quickSort(list, (e1, e2) -> e1.compareTo(e2));
  }

  public static <E> void quickSort(E[] list, Comparator<? super E> comparator) {
    quickSort(list, 0, list.length - 1, comparator);
  }

  private static <E> void quickSort(E[] list, int first, int last, 
      Comparator<? super E> comparator) {
    if (last > first) {
      int pivotIndex = partition(list, first, last, comparator);
      quickSort(list, first, pivotIndex - 1, comparator);
      quickSort(list, pivotIndex + 1, last, comparator);
    }
  }

  private static <E> int partition(E[] list, int first, int last, 
      Comparator<? super E> comparator) {
    E pivot = list[first];
    int low = first + 1;
    int high = last;

    while (high > low) {
      while (low <= high && comparator.compare(list[low], pivot) <= 0) {
        low++;
      }

      while (low <= high && comparator.compare(list[high], pivot) > 0) {
        high--;
      }

      if (high > low) {
        E temp = list[high];
        list[high] = list[low];
        list[low] = temp;
      }
    }

    while (high > first && comparator.compare(list[high], pivot) >= 0) {
      high--;
    }

    if (comparator.compare(pivot, list[high]) > 0) {
      list[first] = list[high];
      list[high] = pivot;
      return high;
    } else {
      return first;
    }
  }

  public static void main(String[] args) {
    Integer[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
    quickSort(list);
    for (int i = 0; i < list.length; i++) {
      System.out.print(list[i] + " ");
    }

    System.out.println();

    String[] list1 = {"ABC", "abc", "abm", "Anf", "Good", "Bad", "nice"};
    quickSort(list1, (s1, s2) -> s1.compareToIgnoreCase(s2));
    for (int i = 0; i < list1.length; i++) {
      System.out.print(list1[i] + " ");
    }
  }
}