import java.util.Scanner;

public class Exercise10_03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter an integer: ");
        int value = input.nextInt();
        MyInteger n1 = new MyInteger(value);
        System.out.println("n1 is even? " + n1.isEven());
        System.out.println("n1 is prime? " + n1.isPrime());
        
        System.out.println("15 is prime? " + MyInteger.isPrime(15));
        
        char[] chars = {'3', '5', '3', '9'};
        System.out.println(MyInteger.parseInt(chars));
        
        System.out.print("Enter a string: ");
        String s = input.next();
        System.out.println(MyInteger.parseInt(s));
        
        System.out.print("Enter an integer: ");
        int value2 = input.nextInt();
        MyInteger n2 = new MyInteger(value2);
        System.out.println("n2 is odd? " + n2.isOdd());
        System.out.println("45 is odd? " + MyInteger.isOdd(45));
        System.out.println("n1 is equal to n2? " + n1.equals(n2));
        System.out.print("n1 is equal to 5? " + n1.equals(5));
    }
}

class MyInteger {
    private int value;

    public MyInteger(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isEven() {
        return isEven(value);
    }

    public boolean isOdd() {
        return isOdd(value);
    }

    public boolean isPrime() {
        return isPrime(value);
    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static boolean isOdd(int n) {
        return n % 2 != 0;
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static boolean isEven(MyInteger n) {
        return n.isEven();
    }

    public static boolean isOdd(MyInteger n) {
        return n.isOdd();
    }

    public static boolean isPrime(MyInteger n) {
        return n.isPrime();
    }

    public boolean equals(int n) {
        return this.value == n;
    }

    public boolean equals(MyInteger n) {
        return this.value == n.getValue();
    }

    public static int parseInt(char[] chars) {
        return parseInt(new String(chars));
    }

    public static int parseInt(String s) {
        return Integer.parseInt(s);
    }
}