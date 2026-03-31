public class Exercise19_04 {
  public static <E extends Comparable<E>> int linearSearch(E[] list, E key) {
    for (int i = 0; i < list.length; i++)
      if (list[i].equals(key))
        return i;
    return -1;
  }
  
  public static void main(String[] args) {
    Integer[] list = {2, 6, 1, 7, -8, 3, -2};
    System.out.println(linearSearch(list, 1));
    System.out.println(linearSearch(list, 9)); 
  }
}
