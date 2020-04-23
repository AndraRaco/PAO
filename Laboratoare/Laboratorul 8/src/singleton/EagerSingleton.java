package singleton;

public class EagerSingleton {
    private static EagerSingleton instance = new EagerSingleton();
    private int count;

    static {
        instance = new EagerSingleton();
//        LazySingleton ls = new LazySingleton();
//        EagerSingleton es=new EagerSingleton();
//        es.count=9;
    }

    private EagerSingleton() {
    }

    public static EagerSingleton getInstance() {
        return instance;
    }
}
