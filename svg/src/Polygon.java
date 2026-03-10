public class Polygon {

    private Point[] points;

    public Polygon(Point[] points) {
        this.points = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            this.points[i] = new Point(points[i]);
        }
    }

    public Polygon(Polygon other) {
        this.points = new Point[other.points.length];
        for (int i = 0; i < other.points.length; i++) {
            this.points[i] = new Point(other.points[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Polygon[");
        for (int i = 0; i < points.length; i++) {
            sb.append(points[i].toString());
            if (i < points.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public String toSvg() {
        StringBuilder sb = new StringBuilder("<polygon points=\"");
        for (int i = 0; i < points.length; i++) {
            sb.append(points[i].getX()).append(",").append(points[i].getY());
            if (i < points.length - 1) sb.append(" ");
        }
        sb.append("\" style=\"fill:none;stroke:black;stroke-width:1\" />");
        return sb.toString();
    }

    public BoundingBox boundingBox() {
        if (points == null || points.length == 0) {
            return new BoundingBox(0, 0, 0, 0);
        }

        double minX = points[0].getX();
        double minY = points[0].getY();
        double maxX = points[0].getX();
        double maxY = points[0].getY();

        for (Point p : points) {
            if (p.getX() < minX) minX = p.getX();
            if (p.getX() > maxX) maxX = p.getX();
            if (p.getY() < minY) minY = p.getY();
            if (p.getY() > maxY) maxY = p.getY();
        }

        return new BoundingBox(minX, minY, maxX - minX, maxY - minY);
    }
}