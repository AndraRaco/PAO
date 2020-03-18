package sweets;

public class Heidi extends CandyBox {
    private String shape;
    private float dimensions;

    public Heidi() {
        super();
        this.shape = "cube";
        this.dimensions = 0;
    }

    public Heidi(String flavor, String origin, float dimensions) {
        super(flavor, origin);
        this.shape = "cube";
        this.dimensions = dimensions;
    }

    @Override
    public float getVolume() {
        return this.dimensions * this.dimensions * this.dimensions;
    }

    @Override
    public String toString() {
        return "The " + super.getOrigin() + " " + super.getFlavor() + " has volume " + this.getVolume();
    }

    public void printHeidiDim()
    {
        System.out.println("Heidi dimensions: dimensions= " + this.dimensions);
    }
}
