import java.awt.*;

public class Main {
    // Készítsünk egy osztályhierarchiát mértani alakzatok reprezentációjára.
    // Az alakzatok közös tulajdonságaikat (pl. pozíció, szín stb.) egy absztrakt alaposztálytól (Shape) örökölhetik,
    // ugyanez az osztály határozhatja meg közös metódusaikat (pl. kerület és terület kiszámítása absztrakt metódusok stb.
    // Hozzunk létre legalább két származtatott osztályt konkrét alakzatok reprezentációjára
    // (pl. Circle, Square, Rectangle stb.), amelyekben megfelelő módon implementáljuk az előzőleg említett metódusokat.
    // Hozzunk létre egy Resizable interfészt, amelynek resize metódusa egy Dimension objektumot kap paraméterként:
    // az újraméretezés az alakzat köré írt téglalap méretei alapján történne.
    // Az interfész megvalósítása által tegyük újraméretezhetővé legalább egy alakzatunkat.
    // Írjunk egy programot, amelyben szemléltetjük az osztályok működését.

    public static void main(String[] args) {

        Circle c = new Circle();
        Square s = new Square();
        c.setColor("white");
        s.setColor("red");

        System.out.println("Area of the circle is " + c.getArea());
        System.out.println("The perimeter of the circle is " + c.getPerimeter());
        System.out.println("Color of the circle is " + c.getColor());
        System.out.println("_________________________");
        System.out.println("Area of the square is " + s.getArea());
        System.out.println("The perimeter of the square " + s.getPerimeter());
        System.out.println("Color of the square is " + s.getColor());
        System.out.println("__________________________");

        Resizable resizableCircle = c.getIterator();
        resizableCircle.resize(new Dimension(10, 10));
        System.out.println("Area of the resizeble circle is " + c.getArea());
        System.out.println("__________________________");

        Resizable resizableSquare = s.getIterator();
        resizableSquare.resize(new Dimension(5, 5));
        System.out.println("The perimeter of the resizeble square is " + s.getPerimeter());
    }
}