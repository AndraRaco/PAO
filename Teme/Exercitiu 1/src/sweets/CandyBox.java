package sweets;

import java.util.Objects;

public class CandyBox {
    private String flavor;
    private String origin;

    public CandyBox() {
        this.flavor = null;
        this.origin = null;
    }

    public CandyBox(String flavor, String origin) {
        this.flavor = flavor;
        this.origin = origin;
    }

    public float getVolume() {
        return 0;
    }

    @Override
    public String toString() {
        return "CandyBox{" +
                "flavor='" + flavor + '\'' +
                ", origin='" + origin + '\'' +
                '}';
    }

    public String getFlavor() {
        return flavor;
    }

    public String getOrigin() {
        return origin;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (this == o) return true;
//        if(obj instanceof CandyBox)
//        {
//            CandyBox candyBox=(CandyBox)obj;
//            boolean cond_flavor=candyBox.getFlavor().equals(this.getFlavor());
//            boolean cond_origin=candyBox.getOrigin().equals(this.getOrigin());
//            return cond_flavor && cond_origin;
//        }
//        else
//            return False;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CandyBox)) return false;
        CandyBox candyBox = (CandyBox) o;
        return Objects.equals(getFlavor(), candyBox.getFlavor()) &&
                Objects.equals(getOrigin(), candyBox.getOrigin());
    }

}
