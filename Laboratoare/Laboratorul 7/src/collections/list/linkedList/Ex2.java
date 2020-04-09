package collections.list.linkedList;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Ex2 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        list.offer("c");// aduga elementul la coada listei
        list.offerFirst("rr");

        System.out.println(list.element()); // ne arata inceputul listei

        // NoSuchElementException daca lista e goala
        // new LinkedList<>().element();

        LinkedList<String> empty = new LinkedList<>();

        System.out.println(list.peek()); // returneazza primul el daca lista nu e gola
        System.out.println(list.poll()); // elimina primule element
        System.out.println(list);
        System.out.println(empty); // []

        // from deque
        list.pop(); // removeFirst()
        System.out.println(list);
//        empty.pop(); // exception lista empty e goala

    }
}
