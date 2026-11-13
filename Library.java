import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public Book findById(int id) throws BookNotFoundException {
        for (Book b : books) {
            if (b.getId() == id) {
                return b;
            }
        }
        throw new BookNotFoundException("No book found with id " + id);
    }

    public void issueBook(int id) throws BookNotFoundException {
        Book b = findById(id);
        if (b.isIssued()) {
            System.out.println("Book is already issued.");
        } else {
            b.setIssued(true);
            System.out.println("Book issued: " + b.getTitle());
        }
    }

    public void returnBook(int id) throws BookNotFoundException {
        Book b = findById(id);
        if (!b.isIssued()) {
            System.out.println("This book was not issued.");
        } else {
            b.setIssued(false);
            System.out.println("Book returned: " + b.getTitle());
        }
    }

    public void showAll() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        for (Book b : books) {
            System.out.println(b);
        }
    }
}
