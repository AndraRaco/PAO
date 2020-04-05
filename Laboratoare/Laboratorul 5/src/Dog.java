public class Dog extends Animal implements BubbleBathable {

    @Override
    public void wash() {
        System.out.println("washing a dog");
    }

    @Override
    public boolean needsWashing() {
        return false;
    }

    @Override
    public void takeBubbleBath() {

    }

    @Override
    public void scrub() {

    }

    @Override
    public void soak() {

    }
}
