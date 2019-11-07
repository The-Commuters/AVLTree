package Forms;

public class Form {
    protected int type;
    protected double x1, y1, x2, y2, radius;
    protected String Content;

    //line contruktor
    public Form(double startX, double startY, double endX, double endY){
        type = 1;
        x1 = startX;
        x2 = endX;
        y1 = startY;
        y2 = endY;
    }

    //text construktor
    public Form(double x1, double y1, String content) {
        type = 2;
        this.x1 = x1;
        this.y1 = y1;
        Content = content;
    }

    //cirkle construktor
    public Form(double x1, double y1, double radius) {
        type = 3;
        this.x1 = x1;
        this.y1 = y1;
        this.radius = radius;
    }

    public int getType() {
        return type;
    }

    public double getX1() {
        return x1;
    }

    public double getY1() {
        return y1;
    }

    public double getX2() {
        return x2;
    }

    public double getY2() {
        return y2;
    }

    public double getRadius() {
        return radius;
    }
}
