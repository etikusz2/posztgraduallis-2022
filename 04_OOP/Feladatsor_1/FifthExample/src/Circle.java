import java.awt.*;

public class Circle extends Shape {
    double radius = 1;

    public Circle(){
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public Resizable getIterator(){
        return new ResizebleImpl();
    }

    class ResizebleImpl implements Resizable {

        @Override
        public void resize(Dimension d) {
            radius = d.height;
        }
    }
}


