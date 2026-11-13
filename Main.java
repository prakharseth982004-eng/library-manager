import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book(1, "Java Basics", "James Gosling"));
        library.addBook(new Book(2, "Clean Code", "Robert Martin"));
        library.addBook(new Book(3, "Effective Java", "Joshua Bloch"));

        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- Library Manager ---");
            System.out.println("1. Show all books");
            System.out.println("2. Add a book");
            System.out.println("3. Issue a book");
            System.out.println("4. Return a book");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Please enter a number.");
                sc.next();
                choice = -1;
                continue;
            }
            choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1:
                        library.showAll();
                        break;
                    case 2:
                        System.out.print("Book id: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Title: ");
                        String title = sc.nextLine();
                        System.out.print("Author: ");
                        String author = sc.nextLine();
                        library.addBook(new Book(id, title, author));
                        System.out.println("Book added.");
                        break;
                    case 3:
                        System.out.print("Book id to issue: ");
                        library.issueBook(sc.nextInt());
                        break;
                    case 4:
                        System.out.print("Book id to return: ");
                        library.returnBook(sc.nextInt());
                        break;
                    case 0:
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (BookNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (choice != 0);
        sc.close();
    }
}
