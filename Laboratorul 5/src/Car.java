public class Car implements Washable, Soakable {
    @Override
    public void wash() {
        System.out.println("washing a car");
    }

    // @Override
    // public void soak() {
    // System.out.println("soaking a car");
    // }

    // @Override
    // public boolean needsWashing() {
    // return false;
    // }
}
