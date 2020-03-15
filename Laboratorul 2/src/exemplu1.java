import java.util.Arrays;

public class exemplu1 {
    public static void main(String[] args)
    {
        byte[] bytes;
        bytes=new byte[5];//la instantiere declar si lungimea
        bytes[0]=-128;
        bytes[4]=127;

        for( byte i=0;i<bytes.length;i++)
            System.out.println(bytes[i]);

        short[] shortArray;
        boolean[] boolArray=new boolean[4];

        int[] ints=new int[]{23,35,11,22};
        int[] ints1=new int[4];
        ints1[0]=23;
        ints1[1]=35;
        ints1[2]=11;
        ints1[3]=22;

        int[] anotherIntArray={23,35,11,22};
        System.out.println(anotherIntArray);//adresa [I@adresa, [ pt ca e vector
        System.out.println(Arrays.toString(anotherIntArray));
    }
}
