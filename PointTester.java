import java.awt.Point;

public class PointTester {
    public static void main(String[] args) {
        Point p = new Point(2, 5);
        System.out.println(p);
        p.setLocation(p.getY(), p.getX());
        System.out.println(p);
        Point p2 = new Point(p);
        System.out.println(p == p2);
        System.out.println(p.equals(p2));
    }
}
