public class Segment {

    private Point p1;
    private Point p2;

    public Segment(Point p1, Point p2) {
        this.p1 = new Point(p1);
        this.p2 = new Point(p2);
    }

    @Override
    public String toString() {
        return "Segment[p1=" + p1 + ", p2=" + p2 + "]";
    }
}