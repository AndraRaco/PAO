import java.util.Scanner;

public class BookstoreTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Number of books:");
        int numberBooks = scanner.nextInt();

        Bookstore bookstore = new Bookstore(10);

        for (int i = 0; i < numberBooks; i++) {
            System.out.println("Title: ");
            String title = scanner.next();
            System.out.println("Author: ");
            String author = scanner.next();
            System.out.println("Publisher: ");
            String publisher = scanner.next();
            System.out.println("Number of pages: ");
            int pageCount = scanner.nextInt();
            bookstore.add(new Book(title, author, publisher, pageCount));
        }
        scanner.close();

        System.out.println("Books: ");
        for (int i = 0; i < bookstore.getLength(); ++i) {
            System.out.println(i + 1);
            System.out.println(bookstore.get(i));
        }

        // Test the duplicate method
        System.out.println();
        Book book1 = bookstore.get(0); // We use the first book
        bookstore.add(book1); //We add the book again, to be sure we have 2
        System.out.println("Duplicate: " + BookstoreCheck.duplicate(bookstore, book1));

        // Test the thick method
        System.out.println();
        Book book2 = bookstore.get(1);
        System.out.println("Thicker: \n" + BookstoreCheck.thicker(book1, book2));
    }


}
