import java.io.FileWriter;
import java.io.IOException;

public class SvgScene {
    private Polygon[] polygons;
    private int currentIndex;

    public SvgScene() {
        this.polygons = new Polygon[3];
        this.currentIndex = 0;
    }

    public void addPolygon(Polygon p) {
        polygons[currentIndex % 3] = p;
        currentIndex++;
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
        double maxSceneWidth = 0;
        double maxSceneHeight = 0;

        for (Polygon p : polygons) {
            if (p != null) {
                BoundingBox bb = p.boundingBox();
                double endX = bb.x() + bb.width();
                double endY = bb.y() + bb.height();

                if (endX > maxSceneWidth) maxSceneWidth = endX;
                if (endY > maxSceneHeight) maxSceneHeight = endY;
            }
        }

        try (FileWriter writer = new FileWriter(path)) {
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
            writer.write("<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"" + maxSceneWidth + "\" height=\"" + maxSceneHeight + "\">\n");
            writer.write(this.toSvg());
            writer.write("</svg>\n");
        } catch (IOException e) {
            System.err.println("Wystąpił błąd podczas zapisu pliku SVG: " + e.getMessage());
        }
    }
}