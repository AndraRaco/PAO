package form;

public class Circle extends Form {
    private float radius;

    public Circle() {
        super();
        this.radius = 0;
    }

    public Circle(String color, float radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle " + super.toString() + " " + this.getArea();
    }

    @Override
    public float getArea() {
        return (float) (radius * radius * Math.PI);
    }

    public float getRadius() {
        return radius;
    }

    public void printCircleDimensions() {
        String output = "";
        output += "radius= " + this.radius;
        System.out.println(output);
    }
}
