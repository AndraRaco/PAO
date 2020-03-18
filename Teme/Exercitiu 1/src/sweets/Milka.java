package sweets;

public class Milka extends CandyBox {
    private String shape;
    private float side;
    private float radius;

    public Milka() {
        super();
        this.shape = "cylinder";
        this.side = 0;
        this.radius = 0;
    }

    public Milka(String flavor, String origin, float side, float radius) {
        super(flavor, origin);
        this.shape = "cylinder";
        this.side = side;
        this.radius = radius;
    }

    @Override
    public float getVolume() {
        return (float) (this.side * this.radius * this.radius * Math.PI);
    }

    @Override
    public String toString() {
        return "The " + super.getOrigin() + " " + super.getFlavor() + " has volume " + this.getVolume();
    }

    public void printMilkaDim()
    {
        System.out.println("Milka dimensions: side= " + this.side + " radius=" + this.radius);
    }
}
