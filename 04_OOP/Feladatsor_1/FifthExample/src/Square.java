import java.awt.*;

public class Square extends Shape {
    double radius = 1;

    public Square() {
    }

    @Override
    public double getArea() {
        return radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 4 * radius;
    }

    public Resizable getIterator(){
        return new ResizebleImpl();
    }

    class ResizebleImpl implements Resizable{


        @Override
        public void resize(Dimension d) {
            radius = d.height;
        }
    }

}

