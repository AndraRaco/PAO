public class Bookstore {
    private int capacity;
    private Book[] books;
    private int index;

    public Bookstore(int capacity) {
        this.capacity = capacity;
        this.books = new Book[capacity];
        this.index = 0;
    }

    public int getLength() {
        return index;
    }

    public void add(Book book) {
        if (index == this.capacity) {
            throw new RuntimeException("Bookstore is full.");
        }
        books[index] = book;
        index++;
    }

    public Book get(int i) {
        if (i > index) {
            throw new ArrayIndexOutOfBoundsException("Book not found.");
        }
        return books[i];
    }

    public int find(Book book) {
        for (int i = 0; i < index; ++i) {
            if (books[i].equals(book)) {
                return i;
            }
        }
        return -1; // Book not found
    }

    public void remove(Book book) {
        int bookIndex = find(book);
        if (bookIndex == -1) // Book not found
            throw new RuntimeException("Book is not in the bookstore");
        else {
            for (int i = bookIndex; i < index - 1; ++i) {
                books[i] = books[i + 1];
            }
            index--;
        }
    }


}
