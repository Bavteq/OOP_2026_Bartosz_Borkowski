public class Main {
    public static void main(String[] args) {

        Point p1 = new Point(10, 10);
        Point p2 = new Point(100, 100);

        Segment s1 = new Segment(p1, p2);
        System.out.println("Utworzony segment: " + s1);

        p1.setX(999);
        System.out.println("Segment po zmianie oryginału p1: " + s1 + " (pozostaje bez zmian)");

        Segment s2 = new Segment(new Point(0, 0), new Point(200, 200));
        Segment longest = Segment.longestSegment(new Segment[]{s1, s2});
        System.out.println("Długość najdłuższego segmentu: " + longest.length());

        Point[] trójkąt = {
                new Point(50, 50),
                new Point(150, 50),
                new Point(100, 150)
        };
        Polygon poly1 = new Polygon(trójkąt);

        Point[] prostokąt = {
                new Point(200, 50),
                new Point(300, 50),
                new Point(300, 100),
                new Point(200, 100)
        };
        Polygon poly2 = new Polygon(prostokąt);

        System.out.println("\nBoundingBox trójkąta: " + poly1.boundingBox());

        SvgScene scene = new SvgScene();
        scene.addPolygon(poly1);
        scene.addPolygon(poly2);

        String plikSVG = "output.svg";
        scene.save(plikSVG);
        System.out.println("Zapisano plik SVG pomyślnie do: " + plikSVG);
    }
}