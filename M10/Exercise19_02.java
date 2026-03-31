public class Exercise19_02 {
  public static void main(String[] args) {
    GenericStack<String> stack = new GenericStack<String>();
    stack.push("Ace");
    stack.push("King");
    stack.push("Jack");
    
    System.out.println("Size: " + stack.getSize());
    System.out.println("Peek: " + stack.peek());
    System.out.println("Pop: " + stack.pop());
    System.out.println("Peek after pop: " + stack.peek());
  }

  static class GenericStack<E> extends java.util.ArrayList<E> {
    public boolean isEmpty() {
      return super.isEmpty();
    }

    public int getSize() {
      return size();
    }

    public E peek() { 
      return get(getSize() - 1);
    }

    public E pop() {
      E o = get(getSize() - 1);
      remove(getSize() - 1);
      return o;
    }

    public void push(E o) {
      add(o);
    }

    @Override
    public String toString() {
      return "stack: " + super.toString(); 
    }
  }
}