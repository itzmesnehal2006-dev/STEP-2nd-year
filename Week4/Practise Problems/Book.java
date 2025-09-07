class Book {
    // Attributes
    String title;
    String author;
    double price;

    // Default Constructor
    Book() {
        title = "Unknown Title";
        author = "Unknown Author";
        price = 0.0;
    }

    // Parameterized Constructor
    Book(String t, String a, double p) {
        title = t;
        author = a;
        price = p;
    }

    // Method to display book details
    void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: ₹" + price);
        System.out.println("--------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating object with Default Constructor
        Book book1 = new Book();
        
        // Creating object with Parameterized Constructor
        Book book2 = new Book("The Alchemist", "Paulo Coelho", 399.0);

        // Display book details
        System.out.println("Book 1 Details (Default Constructor):");
        book1.display();

        System.out.println("Book 2 Details (Parameterized Constructor):");
        book2.display();
    }
}
