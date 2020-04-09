package collections.list.arraylist;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Collections
 * List
 * Set
 * Queue
 */
public class Ex1 {
    public static void main(String[] args) {
        // without generics
        List bulkList = new ArrayList();
        bulkList.add(1);
        bulkList.add("Ana are mere");
        bulkList.add(new Object());
        System.out.println(bulkList);

        List<String> list1 = new ArrayList<>();
        System.out.println(list1.isEmpty());
        list1.add("one");
        list1.add("two");
        list1.add(0, "111");
        list1.add(1, "1");
        System.out.println(list1.size());
        System.out.println(list1);

        if (list1.contains("one")) {
            System.out.println(list1.remove(0)); // Returns the object that was removed
            list1.remove("two");
        }
        System.out.println(list1);
//        list1.remove(2);

        List<Integer> ints = new ArrayList<>();
        ints.add(1);

        List<String> list2 = new ArrayList<String>(list1);// Nu putem pune ints, List<Integer>
        // bulkList merge adugat, apeleaza implicit toString
        System.out.println(list2); // [1,one]
        list2.addAll(list1); // Adauga in continuare [1, one, 1, one]
        System.out.println(list2);
        list2.addAll(1, list2);
        System.out.println(list2);
        list2.add("last element");

        list2.removeAll(list1);
        System.out.println("After remove all: " + list2);

        list1.clear();
        System.out.println("list1 after clear: " + list1);


    }
}
