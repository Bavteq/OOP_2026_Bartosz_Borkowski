import java.security.spec.RSAOtherPrimeInfo;

public class Main {
    public static void main(String[] args){
        Point p1 = new Point();
        p1.x = 50.0;
        p1.y = 50.0;
        System.out.println("Zadanie 1:");
        System.out.println("p1 = " + p1);
        System.out.println("\n");

        System.out.println("Zadanie 2:");
        System.out.println(p1.toSvg());
        System.out.println("\n");

        System.out.println("Zadanie 3:");
        p1.translate(10, -20);
        System.out.println("p1 = " + p1);
        System.out.println(p1.toSvg());

        Point p2 = p1.translated(-30, 40);
        System.out.println("p2 = " + p2);
        System.out.println(p2.toSvg());
        System.out.println("\n");

        System.out.println("Zadanie 4:");
        Segment s1 = new Segment();
        s1.a = p1;
        s1.b = p2;
        System.out.println("s1 = " + s1);
        System.out.println("dlugosc s1 = " +s1.length());
        System.out.println("\n");

        Point p3 = new Point();
        p3.x = 0; p3.y = 0;
        Point p4 = new Point();
        p4.x = 100; p4.y = 100;

        Segment s2 = new Segment();
        s2.a = p3;
        s2.b = p4;

        System.out.println("Zadanie 5:");
        Segment[] odcinki = new Segment[2];
        odcinki[0] = s1;
        odcinki[1] = s2;
        Segment zwyciezca = Segment.najdluzszy(odcinki);
        System.out.println("Najdłuższy odcinek to: " + zwyciezca);
        System.out.println("Jego długość: " + zwyciezca.length());
    }
}