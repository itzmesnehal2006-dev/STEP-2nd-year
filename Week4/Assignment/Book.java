class Book {
    String title;
    String author;
    String isbn;
    boolean isAvailable;

    // 1. Default constructor → empty book
    Book() {
        this("Unknown", "Unknown", "N/A", true);
    }

    // 2. Constructor with title and author
    Book(String title, String author) {
        this(title, author, "N/A", true);
    }

    // 3. Full constructor with all details
    Book(String title, String author, String isbn, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = isAvailable;
    }

    // Method to borrow a book
    void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(title + " has been borrowed.");
        } else {
            System.out.println(title + " is already borrowed!");
        }
    }

    // Method to return a book
    void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println(title + " has been returned.");
        } else {
            System.out.println(title + " was not borrowed.");
        }
    }

    // Method to display book info
    void displayBookInfo() {
        System.out.println("📖 Book Information");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
        System.out.println("-------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating books with different constructors
        Book b1 = new Book();  // Default
        Book b2 = new Book("1984", "George Orwell");  
        Book b3 = new Book("The Hobbit", "J.R.R. Tolkien", "978-0261103344", true);

        // Borrowing and returning
        b2.borrowBook();
        b2.borrowBook(); // Try borrowing again
        b2.returnBook();
        b2.returnBook(); // Try returning again

        // Display info
        b1.displayBookInfo();
        b2.displayBookInfo();
        b3.displayBookInfo();
    }
}
