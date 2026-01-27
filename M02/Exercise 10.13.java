public class Exercise10_13 {
    public static void main(String[] args) {
        MyRectangle2D r1 = new MyRectangle2D(2, 2, 5.5, 4.9);

        System.out.println("Area: " + r1.getArea());
        System.out.println("Perimeter: " + r1.getPerimeter());
        
        System.out.println("r1 contains point (3, 3): " + r1.contains(3, 3));
        System.out.println("r1 contains rectangle (4, 5, 10.5, 3.2): " + 
            r1.contains(new MyRectangle2D(4, 5, 10.5, 3.2)));
        System.out.println("r1 overlaps rectangle (3, 5, 2.3, 5.4): " + 
            r1.overlaps(new MyRectangle2D(3, 5, 2.3, 5.4)));
    }
}

class MyRectangle2D {
    private double x;
    private double y;
    private double width;
    private double height;

    public double getX() { return x; }
    public void setX(double x) { this.x = x; }
    public double getY() { return y; }
    public void setY(double y) { this.y = y; }
    public double getWidth() { return width; }
    public void setWidth(double width) { this.width = width; }
    public double getHeight() { return height; }
    public void setHeight(double height) { this.height = height; }

    public MyRectangle2D() {
        this(0, 0, 1, 1);
    }

    public MyRectangle2D(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    public boolean contains(double x, double y) {
        return Math.abs(x - this.x) <= width / 2 &&
               Math.abs(y - this.y) <= height / 2;
    }

    public boolean contains(MyRectangle2D r) {
        return (Math.abs(x - r.getX()) + r.getWidth() / 2 <= width / 2) &&
               (Math.abs(y - r.getY()) + r.getHeight() / 2 <= height / 2);
    }

    public boolean overlaps(MyRectangle2D r) {
        return (Math.abs(x - r.getX()) <= (width + r.getWidth()) / 2) &&
               (Math.abs(y - r.getY()) <= (height + r.getHeight()) / 2) &&
               !contains(r);
    }
}