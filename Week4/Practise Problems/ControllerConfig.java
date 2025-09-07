class ControllerConfig {
    // Attributes
    String layout;
    int sensitivity;
    boolean vibration;

    // Default Constructor
    ControllerConfig() {
        layout = "Default Layout";
        sensitivity = 5;
        vibration = true; // vibration ON by default
    }

    // Parameterized Constructor
    ControllerConfig(String l, int s, boolean v) {
        layout = l;
        sensitivity = s;
        vibration = v;
    }

    // Method to display config
    void display() {
        System.out.println("Controller Layout: " + layout);
        System.out.println("Sensitivity Level: " + sensitivity);
        System.out.println("Vibration Enabled: " + (vibration ? "Yes" : "No"));
        System.out.println("---------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        // Using Default Constructor
        ControllerConfig defaultConfig = new ControllerConfig();

        // Using Parameterized Constructor
        ControllerConfig customConfig = new ControllerConfig("Custom Pro Layout", 8, false);

        System.out.println("Default Controller Configuration:");
        defaultConfig.display();

        System.out.println("Custom Controller Configuration:");
        customConfig.display();
    }
}
