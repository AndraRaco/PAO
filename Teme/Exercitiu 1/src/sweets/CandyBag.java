package sweets;

import java.util.Scanner;

public class CandyBag {
    CandyBox[] candyBoxes;
    private final int max_nr_candyBox;
    private int index;


    public CandyBag(int max_nr_candyBox) {
        if (max_nr_candyBox > 0) {
            this.max_nr_candyBox = max_nr_candyBox;
            this.candyBoxes = new CandyBox[max_nr_candyBox];
        } else {
            throw new RuntimeException("The number should be greater than 0.");
        }
    }

    public void add_CandyBox(CandyBox candyBox) {
        if (index < candyBoxes.length) {
            candyBoxes[index] = candyBox;
            System.out.println("Added candyBox " + candyBox.getClass() + index++);
        }
        else
            System.out.println("We cannot add this candyBox.");
    }
}
