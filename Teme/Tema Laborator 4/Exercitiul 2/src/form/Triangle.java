package form;

public class Triangle extends Form {
    private float height;
    private float base;

    public Triangle() {
        super();
        this.height = 0;
        this.base = 0;
    }

    public Triangle(String color, float height, float base) {
        super(color);
        this.height = height;
        this.base = base;
    }

    @Override
    public String toString() {
        return "Triangle " + super.toString() + " " + this.getArea();
    }

    @Override
    public float getArea() {
        return (float) (height * base / 2);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Triangle) {
            Triangle triangle = (Triangle) obj; //Cast
            if (triangle.getColor().equals(super.getColor())) {
                return triangle.getHeight() == this.getHeight() || triangle.getBase() == this.getBase();
            } else
                return false;
        } else
            return false;
    }

    public float getHeight() {
        return height;
    }

    public float getBase() {
        return base;
    }

    public void printTriangleDimensions() {
        String output = "";
        output += "base= " + this.base + " height= " + this.height;
        System.out.println(output);
    }
}
