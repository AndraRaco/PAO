public class Ex2 {
    public static void washIfPossible(Washable washable){
        if (washable.needsWashing())
        {
            washable.wash();
        }
    }
}
