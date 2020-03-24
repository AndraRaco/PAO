package form;

public class FormTest {
    public static void main(String[] args) {
//        Triangle triangle = new Triangle();
//        Circle circle = new Circle();
//
//        System.out.println(triangle.toString());
//        System.out.println(circle.toString());

        Form[] forms = new Form[5];
        Triangle triangle = new Triangle("red", 3, 2);
        forms[0] = triangle;
        Triangle triangle1 = new Triangle("blue", 3, 3);
        forms[1] = triangle1;
        Circle circle = new Circle("pink", 4);
        forms[2] = circle;
        Triangle triangle3 = new Triangle("red", 3, 2);
        forms[3] = triangle3;
        Circle circle2 = new Circle("blue", 1);
        forms[4] = circle2;

        for (int i = 0; i < forms.length; i++) {
            System.out.println(forms[i].toString());
        }

        System.out.println();

        for (int i = 0; i < forms.length; i++) {
            if (forms[i] instanceof Triangle)
                ((Triangle) forms[i]).printTriangleDimensions();
            if (forms[i] instanceof Circle)
                ((Circle) forms[i]).printCircleDimensions();
        }

        for (int i = 0; i < forms.length; i++) {
            if (forms[i] instanceof Triangle)
                ((Triangle) forms[i]).printTriangleDimensions();
            if (forms[i] instanceof Circle)
                ((Circle) forms[i]).printCircleDimensions();
        }
    }
}
