public class BookstoreCheck {
    static boolean duplicate(Bookstore bookstore, Book book) {
        int count = 0;
        for (int i = 0; i < bookstore.getLength(); ++i) {
            if (book == bookstore.get(i)) {
                count++;
                if (count == 2) { // There are 2 books that are the same.
                    return true;
                }
            }
        }
        return false;
    }

    static Book thicker(Book book1, Book book2) {
        if (book1.getPageCount() > book2.getPageCount()) {
            return book1;
        } else {
            return book2;
        }
    }
}
