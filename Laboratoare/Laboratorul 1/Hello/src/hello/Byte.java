package hello;

public class Byte {
    static byte defaultValue;

    public static void main(String[] args)
    {
        //byte --> 8=bit intear values
        byte b1=-128;// local variables must b initialized
        System.out.println(b1);

        byte b2=127;
        System.out.println(b2);
        b2++;

        System.out.println(b2++);
        System.out.println(++b2);

        //byte b3=12345; //doesn't compile
        byte b3=(byte)12345;
        System.out.println(b3);

        System.out.println(defaultValue);
    }
}
