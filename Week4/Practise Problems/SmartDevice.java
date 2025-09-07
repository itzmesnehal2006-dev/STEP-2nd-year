class SmartDevice {
    String deviceName;
    String deviceType;
    boolean status;

    // Default constructor
    SmartDevice() {
        this("Unknown Device", "Generic", false); // using this() for constructor chaining
    }

    // Parameterized constructor
    SmartDevice(String deviceName, String deviceType, boolean status) {
        this.deviceName = deviceName;   // disambiguation using this
        this.deviceType = deviceType;   // disambiguation using this
        this.status = status;           // disambiguation using this
    }

    // Method to display device details
    void display() {
        System.out.println("Device: " + this.deviceName);
        System.out.println("Type: " + this.deviceType);
        System.out.println("Status: " + (this.status ? "ON" : "OFF"));
        System.out.println("-------------------------");
    }

    // Method using this to pass current object
    void connect(SmartDevice otherDevice) {
        System.out.println(this.deviceName + " connected to " + otherDevice.deviceName);
    }
}

public class Main {
    public static void main(String[] args) {
        // Using default constructor
        SmartDevice d1 = new SmartDevice();

        // Using parameterized constructor
        SmartDevice d2 = new SmartDevice("Living Room Light", "Light", true);
        SmartDevice d3 = new SmartDevice("Smart Thermostat", "Thermostat", false);

        System.out.println("Smart Device Details:\n");
        d1.display();
        d2.display();
        d3.display();

        // Demonstrating this usage in object interaction
        System.out.println("Device Connections:");
        d2.connect(d3);
        d3.connect(d2);
    }
}
