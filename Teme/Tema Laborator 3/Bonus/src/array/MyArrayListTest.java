package array;

import java.util.Random;

public class MyArrayListTest {
    public static void main(String[] args) {
//        // b
//        MyArrayList myArrayList1 = new MyArrayList(3);
//        myArrayList1.add(0f);
//        myArrayList1.add(1f);
//        myArrayList1.add(2f);
//
//        System.out.println(myArrayList1.get(0));
//        System.out.println(myArrayList1.get(1));
//        System.out.println(myArrayList1.get(2));

        // c
        MyArrayList myArrayList2 = new MyArrayList(5);
        myArrayList2.add(0);
        myArrayList2.add(1);
        myArrayList2.add(2);
        myArrayList2.add(3);
        myArrayList2.add(4);
        System.out.println(myArrayList2.toString());

        //Adding 10 new values
        Random rand1 = new Random();
        for (int i = 0; i < 10; i++) {
            float x = rand1.nextFloat();
            myArrayList2.add(x);
        }
        System.out.println(myArrayList2.toString());

        //Removing 5 values
        for (int i = 0; i < 5; i++) {
            Random rand2 = new Random();
            int index = rand2.nextInt(myArrayList2.getIndexArray() - 1);
            myArrayList2.remove(index);
            System.out.println("Index " + index + " : " + myArrayList2.toString());
        }

    }

}
