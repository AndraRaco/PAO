package form;

public class Form {
    private String color;

    public Form() {
        color = "";
    }

    public Form(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color;
    }

    public float getArea() {
        return 0;
    }

    public String getColor() {
        return color;
    }
}
