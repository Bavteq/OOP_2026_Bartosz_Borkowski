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

    public String toSvg() {
        return "<line x1='" + a.x + "' y1='" + a.y + "' x2='" + b.x + "' y2='" + b.y + "' style='stroke:red;stroke-width:2' />";
    }

    public static Segment najdluzszy(Segment[] tablica) {
        if (tablica == null || tablica.length == 0) return null;

        Segment maxSeg = tablica[0];

        for (Segment s : tablica) {
            if (s.length() > maxSeg.length()) {
                maxSeg = s;
            }
        }
        return maxSeg;
    }
}