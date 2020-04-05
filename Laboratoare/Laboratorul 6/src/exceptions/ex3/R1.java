package exceptions.ex3;

public class R1 implements AutoCloseable {
    public R1()
    { throw new RuntimeException();}

    @Override
    public void close() {
        throw  new RuntimeException("in close method");
    }
}
