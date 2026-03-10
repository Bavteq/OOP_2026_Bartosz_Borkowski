public class Point {
    private double x;
    private double y;

    // Konstruktor bezargumentowy (0, 0)
    public Point() {
        this.x = 0.0;
        this.y = 0.0;
    }

    // Konstruktor ustawiający punkt w zadanym położeniu
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Konstruktor kopiujący (głęboka kopia)
    public Point(Point other) {
        this.x = other.x;
        this.y = other.y;
    }

    public double getX() { return x; }
    public void setX(double x) { this.x = x; }
    public double getY() { return y; }
    public void setY(double y) { this.y = y; }

    public void translate(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    public Point translated(double dx, double dy) {
        return new Point(this.x + dx, this.y + dy);
    }

    @Override
    public String toString() {
        return "Point(" + x + ", " + y + ")";
    }

    public String toSvg() {
        return "<circle cx=\"" + x + "\" cy=\"" + y + "\" r=\"5\" fill=\"black\" />";
    }
}