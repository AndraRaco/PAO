package sweets;

public class Lindt extends CandyBox {
    private String shape;
    private float height;
    private float width;
    private float length;

    public Lindt() {
        super();
        this.shape = "Rectangular Parallelepiped";
        this.height = 0;
        this.length = 0;
        this.width = 0;
    }

    public Lindt(String flavor, String origin, float height, float width, float length) {
        super(flavor, origin);
        this.shape = "Rectangular Parallelepiped";
        this.height = height;
        this.width = width;
        this.length = length;
    }

    @Override
    public float getVolume() {
        return this.height * this.width * length;
    }

    @Override
    public String toString() {
        return "The " + super.getOrigin() + " " + super.getFlavor() + " has volume " + this.getVolume();
    }

    public void printLindtDim()
    {
        System.out.println("Lindt dimensions: length= " + this.length + " width= "+ this.width + " height= " + this.height);
    }

}
