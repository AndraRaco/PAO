package sweets;

import java.util.Scanner;

public class CandyBagTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Max number of candy boxes: ");
        int nr_candyBoxes = scanner.nextInt();
        scanner.close();

        CandyBag candyBag = new CandyBag(nr_candyBoxes);
        addingBoxes(candyBag);
        for (int i = 0; (i < candyBag.candyBoxes.length) && (candyBag.candyBoxes[i] != null); i++) {
            CandyBox box = candyBag.candyBoxes[i];
            System.out.println(box.toString());
        }

    }

    public static void addingBoxes(CandyBag candyBag) {
        Heidi heidi = new Heidi("vanilla", "Bucharest", 2);
        candyBag.add_CandyBox(heidi);
        heidi.printHeidiDim();

        Lindt lindt = new Lindt("cherries", "Paris", 5, 2, 4);
        candyBag.add_CandyBox(lindt);
        lindt.printLindtDim();

        Milka milka = new Milka("strawberries", "London", 3, 2);
        candyBag.add_CandyBox(milka);
        milka.printMilkaDim();

        Lindt lindt2 = new Lindt("cherries", "Paris", 5, 2, 4);
        if (!lindt.equals(lindt2)) {
            candyBag.add_CandyBox(lindt2);
            lindt2.printLindtDim();
        }
        Heidi heidi2 = new Heidi("cherries", "Budapest", 10);
        candyBag.add_CandyBox(heidi2);
        heidi2.printHeidiDim();

        Lindt lindt3 = new Lindt("vanilla", "Berlin", 2, 2, 1);
        if (!lindt.equals(lindt3)) {
            candyBag.add_CandyBox(lindt3);
            lindt3.printLindtDim();
        }
    }
}
