public class Segment {
    private Point p1;
    private Point p2;

    public Segment(Point p1, Point p2) {
        this.p1 = new Point(p1);
        this.p2 = new Point(p2);
    }

    public double length() {
        double dx = p1.getX() - p2.getX();
        double dy = p1.getY() - p2.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static Segment longestSegment(Segment[] segments) {
        if (segments == null || segments.length == 0) {
            return null;
        }
        Segment longest = segments[0];
        for (Segment s : segments) {
            if (s.length() > longest.length()) {
                longest = s;
            }
        }
        return longest;
    }

    @Override
    public String toString() {
        return "Segment[" + p1.toString() + " -> " + p2.toString() + "]";
    }
}