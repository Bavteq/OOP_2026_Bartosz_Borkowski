public class Segment {
    public Point a, b;

    @Override
    public String toString() {
        return "Segment{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

    public double length(){
        double dx = b.x - a.x;
        double dy = b.y - a.y;
        return Math.sqrt(dx*dx + dy*dy);

    }

    public String toSvg(){
        return <line x1=""+a.x+"" y1=""+b.x+"" x2="300" y2="200" style="stroke:red;stroke-width:2" />
    }
}
