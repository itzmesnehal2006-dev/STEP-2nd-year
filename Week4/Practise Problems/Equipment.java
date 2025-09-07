class Equipment {
    String name;
    String brand;
    double price;

    // Default Constructor
    Equipment() {
        this("Unknown Equipment", "Generic", 0.0);
    }

    // Constructor with only name
    Equipment(String name) {
        this(name, "Generic", 0.0);
    }

    // Constructor with name and brand
    Equipment(String name, String brand) {
        this(name, brand, 0.0);
    }

    // Constructor with all three fields
    Equipment(String name, String brand, double price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    // Display method
    void display() {
        System.out.println("Equipment: " + name);
        System.out.println("Brand: " + brand);
        System.out.println("Price: ₹" + price);
        System.out.println("----------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        // Using Default Constructor
        Equipment eq1 = new Equipment();

        // Using Constructor with only name
        Equipment eq2 = new Equipment("Microphone");

        // Using Constructor with name and brand
        Equipment eq3 = new Equipment("Mixer", "Yamaha");

        // Using Full Constructor
        Equipment eq4 = new Equipment("Studio Monitor", "KRK", 45000.0);

        System.out.println("Music Production Equipment Details:\n");

        eq1.display();
        eq2.display();
        eq3.display();
        eq4.display();
    }
}
