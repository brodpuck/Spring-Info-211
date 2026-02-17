import java.util.*;

class Complex implements Cloneable, Comparable<Complex> {

    private double real;
    private double imaginary;

    public Complex() {
        this(0, 0);
    }

    public Complex(double real) {
        this(real, 0);
    }

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getRealPart() {
        return real;
    }

    public double getImaginaryPart() {
        return imaginary;
    }

    public Complex add(Complex secondComplex) {
        return new Complex(
                real + secondComplex.real,
                imaginary + secondComplex.imaginary
        );
    }

    public Complex subtract(Complex secondComplex) {
        return new Complex(
                real - secondComplex.real,
                imaginary - secondComplex.imaginary
        );
    }

    public Complex multiply(Complex secondComplex) {
        double r = real * secondComplex.real
                - imaginary * secondComplex.imaginary;
        double i = real * secondComplex.imaginary
                + imaginary * secondComplex.real;
        return new Complex(r, i);
    }

    public Complex divide(Complex secondComplex) {
        double denominator =
                secondComplex.real * secondComplex.real +
                secondComplex.imaginary * secondComplex.imaginary;

        double r = (real * secondComplex.real +
                imaginary * secondComplex.imaginary) / denominator;

        double i = (imaginary * secondComplex.real -
                real * secondComplex.imaginary) / denominator;

        return new Complex(r, i);
    }

    public double abs() {
        return Math.sqrt(real * real + imaginary * imaginary);
    }

    @Override
    public String toString() {
        return real + " + " + imaginary + "i";
    }

    @Override
    public Object clone() {
        return new Complex(real, imaginary);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Complex)) return false;
        Complex other = (Complex) obj;
        return real == other.real &&
               imaginary == other.imaginary;
    }

    @Override
    public int compareTo(Complex other) {
        return Double.compare(this.abs(), other.abs());
    }
}

public class Exercise13_17 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first complex number: ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        Complex c1 = new Complex(a, b);

        System.out.print("Enter the second complex number: ");
        double c = input.nextDouble();
        double d = input.nextDouble();
        Complex c2 = new Complex(c, d);

        System.out.println("(" + c1 + ") + (" + c2 + ") = " + c1.add(c2));
        System.out.println("(" + c1 + ") - (" + c2 + ") = " + c1.subtract(c2));
        System.out.println("(" + c1 + ") * (" + c2 + ") = " + c1.multiply(c2));
        System.out.println("(" + c1 + ") / (" + c2 + ") = " + c1.divide(c2));

        System.out.println("|" + c1 + "| = " + c1.abs());

        System.out.println(c1.equals(c2));

        System.out.println(c1.getRealPart());
        System.out.println(c1.getImaginaryPart());

        Complex clone = (Complex) c1.clone();

        Complex[] list = {
                new Complex(4, -0.5),
                c2,
                c1,
                clone
        };

        Arrays.sort(list);

        System.out.println(Arrays.toString(list));
    }
}
