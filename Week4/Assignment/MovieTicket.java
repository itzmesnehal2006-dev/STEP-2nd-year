class MovieTicket {
    String movieName;
    String theatreName;
    int seatNumber;
    double price;

    // 1. Default constructor
    MovieTicket() {
        this("Unknown", "Unknown", -1, 0.0);
    }

    // 2. Constructor with movie name
    MovieTicket(String movieName) {
        this(movieName, "Unknown", -1, 200.0); // default price = 200
    }

    // 3. Constructor with movie name + seat number
    MovieTicket(String movieName, int seatNumber) {
        this(movieName, "PVR", seatNumber, 200.0); // default theatre = PVR
    }

    // 4. Full constructor
    MovieTicket(String movieName, String theatreName, int seatNumber, double price) {
        this.movieName = movieName;
        this.theatreName = theatreName;
        this.seatNumber = seatNumber;
        this.price = price;
    }

    // Method to print ticket
    void printTicket() {
        System.out.println("🎟️ Movie Ticket");
        System.out.println("Movie: " + movieName);
        System.out.println("Theatre: " + theatreName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price: ₹" + price);
        System.out.println("---------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        // Using different constructors
        MovieTicket t1 = new MovieTicket();
        MovieTicket t2 = new MovieTicket("Inception");
        MovieTicket t3 = new MovieTicket("Avengers", 12);
        MovieTicket t4 = new MovieTicket("Interstellar", "IMAX", 25, 450.0);

        // Print tickets
        t1.printTicket();
        t2.printTicket();
        t3.printTicket();
        t4.printTicket();
    }
}
