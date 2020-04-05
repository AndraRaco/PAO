public class EX3 {
    public static void clean(Washable washable) {
        washable.wash();
    }

    public static void main(String[] args) {
        Cup cup=new Cup();
        clean(cup);

        Washable car=new Car();
        clean(car);

        Washable washableWindow=new Washable() {
            @Override
            public void wash() {
                System.out.println("wash anonymous object");
            }
        };
        washableWindow.wash();

        Washable w1=new Car(){
            @Override
            public void wash() {
                System.out.println("new car wash");
            }
        };
        w1.wash();
    }
}
