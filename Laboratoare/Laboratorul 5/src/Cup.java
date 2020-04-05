public class Cup implements BubbleBathable {
    double volume;
    String color;

    public int getLevelOffFragility() {
        return Washable.FRAGILE;
    }

    @Override
    public boolean needsWashing(){return false;}

    @Override
    public void wash() {
        needsWashing();
        System.out.println("washing a cup");
    }

    @Override
    public void takeBubbleBath() {
        System.out.println("doesn't need a bubble bath");
    }

    @Override
    public void scrub() {
        System.out.println("doesn't need a scrub");

    }

    @Override
    public void soak() {

    }
}
