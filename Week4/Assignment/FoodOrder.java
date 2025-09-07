class FoodOrder {
    String customerName;
    String foodItem;
    int quantity;
    double price;

    // Fixed rate per item (for simplicity)
    static final double FIXED_RATE = 150.0;

    // 1. Default constructor → "Unknown" order
    FoodOrder() {
        this("Unknown", "Unknown", 0, 0.0);
    }

    // 2. Constructor with food item → quantity = 1, price = default
    FoodOrder(String foodItem) {
        this("Unknown", foodItem, 1, FIXED_RATE);
    }

    // 3. Constructor with food item and quantity → price = quantity × fixedRate
    FoodOrder(String foodItem, int quantity) {
        this("Unknown", foodItem, quantity, quantity * FIXED_RATE);
    }

    // 4. Full constructor
    FoodOrder(String customerName, String foodItem, int quantity, double price) {
        this.customerName = customerName;
        this.foodItem = foodItem;
        this.quantity = quantity;
        this.price = price;
    }

    // Method to print the bill
    void printBill() {
        System.out.println("🍽️ Food Order Bill");
        System.out.println("Customer: " + customerName);
        System.out.println("Food Item: " + foodItem);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Price: ₹" + price);
        System.out.println("----------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        // Orders using different constructors
        FoodOrder order1 = new FoodOrder();  // Default
        FoodOrder order2 = new FoodOrder("Burger");  
        FoodOrder order3 = new FoodOrder("Pizza", 3);
        FoodOrder order4 = new FoodOrder("Snehal", "Pasta", 2, 280.0);

        // Print bills
        order1.printBill();
        order2.printBill();
        order3.printBill();
        order4.printBill();
    }
}
