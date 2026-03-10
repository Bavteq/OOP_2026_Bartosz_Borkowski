public class Main {
    public static void main(String[] args) {
        System.out.println("Zadanie 1 i 2: Point i Segment");

        Point p1 = new Point();
        Point p2 = new Point(50, 100);

        p1.setX(10);
        p1.setY(20);
        System.out.println("Punkt p1 po uzyciu setterow: " + p1.toString());
        System.out.println("Punkt p2: " + p2.toString());

        Segment segment = new Segment(p1, p2);
        System.out.println("Odcinek przed zmiana punktow: " + segment.toString());

        p1.setX(999);

        System.out.println("Odcinek po zmianie p1 (powinien zostac bez zmian): " + segment.toString());
        System.out.println();

        System.out.println("Zadanie 3 i 4: Polygon i BoundingBox");

        Point[] points = {
                new Point(10, 10),
                new Point(100, 10),
                new Point(50, 80)
        };

        Polygon poly1 = new Polygon(points);
        System.out.println("Wielokat 1: " + poly1.toString());

        points[0].setX(999);
        System.out.println("Wielokat 1 po zmianie oryginalnej tablicy (nie powinien sie zmienic): " + poly1.toString());

        Polygon poly2 = new Polygon(poly1);
        System.out.println("Wielokat 2 (kopia wielokata 1): " + poly2.toString());

        System.out.println("SVG dla Wielokata 1: " + poly1.toSvg());

        System.out.println("BoundingBox dla Wielokata 1: " + poly1.boundingBox().toString());
        System.out.println();

        System.out.println("Zadanie 5, 6 i 8: SvgScene");
        SvgScene scene = new SvgScene();

        Point[] points3 = {new Point(200, 200), new Point(300, 200), new Point(250, 300)};
        Polygon poly3 = new Polygon(points3);

        Point[] points4 = {new Point(5, 5), new Point(20, 5), new Point(10, 20)};
        Polygon poly4 = new Polygon(points4);

        System.out.println("Dodaje poly1, poly2, poly3...");
        scene.addPolygon(poly1);
        scene.addPolygon(poly2);
        scene.addPolygon(poly3);

        System.out.println("Dodaje poly4 (powinno nadpisac poly1 na indeksie 0)...");
        scene.addPolygon(poly4);

        System.out.println("Kod SVG calej sceny:");
        System.out.println(scene.toSvg());

        String filePath = "obrazek.svg";
        scene.save(filePath);
        System.out.println("Scena zostala zapisana do pliku: " + filePath);
    }
}