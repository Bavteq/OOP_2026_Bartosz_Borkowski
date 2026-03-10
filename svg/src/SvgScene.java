import java.io.FileWriter;
import java.io.IOException;

public class SvgScene {

    private Polygon[] polygons = new Polygon[3];
    private int currentIndex = 0;

    public void addPolygon(Polygon p) {
        polygons[currentIndex] = p;
        currentIndex = (currentIndex + 1) % polygons.length;
    }

    public String toSvg() {
        StringBuilder sb = new StringBuilder();
        for (Polygon p : polygons) {
            if (p != null) {
                sb.append("  ").append(p.toSvg()).append("\n");
            }
        }
        return sb.toString();
    }

    public void save(String path) {
        double maxWidth = 0;
        double maxHeight = 0;

        for (Polygon p : polygons) {
            if (p != null) {
                BoundingBox bb = p.boundingBox();
                double rightEdge = bb.x() + bb.width();
                double bottomEdge = bb.y() + bb.height();

                if (rightEdge > maxWidth) maxWidth = rightEdge;
                if (bottomEdge > maxHeight) maxHeight = bottomEdge;
            }
        }

        String svgStart = String.format("<svg width=\"%f\" height=\"%f\" xmlns=\"http://www.w3.org/2000/svg\">\n", maxWidth, maxHeight);
        String svgEnd = "</svg>";

        try (FileWriter writer = new FileWriter(path)) {
            writer.write(svgStart);
            writer.write(this.toSvg());
            writer.write(svgEnd);
        } catch (IOException e) {
            System.err.println("Błąd zapisu pliku: " + e.getMessage());
        }
    }
}