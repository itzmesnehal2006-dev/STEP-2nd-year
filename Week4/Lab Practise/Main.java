import java.util.*;

class VirtualPet {
    // 🔹 Fields
    final String petId;           // Unique ID (final, must be assigned once)
    String petName;
    String species;
    int age;
    int happiness;
    int health;
    int stageIndex;               // To track evolution stage
    
    static final String[] EVOLUTION_STAGES = {"Egg", "Baby", "Child", "Teen", "Adult", "Elder", "Ghost"};
    static int totalPetsCreated = 0;

    // 🔹 Main Constructor (all fields)
    VirtualPet(String petName, String species, int age, int happiness, int health, int stageIndex) {
        this.petId = generatePetId();
        this.petName = petName;
        this.species = species;
        this.age = age;
        this.happiness = happiness;
        this.health = health;
        this.stageIndex = stageIndex;
        totalPetsCreated++;
    }

    // 🔹 Default constructor → mysterious Egg
    VirtualPet() {
        this("Mysterious Egg", getRandomSpecies(), 0, 50, 50, 0);
    }

    // 🔹 Constructor with only name → Baby
    VirtualPet(String petName) {
        this(petName, getRandomSpecies(), 1, 60, 60, 1);
    }

    // 🔹 Constructor with name + species → Child
    VirtualPet(String petName, String species) {
        this(petName, species, 3, 70, 70, 2);
    }

    // 🔹 Generate unique Pet ID
    static String generatePetId() {
        return UUID.randomUUID().toString().substring(0, 8); // shorter ID
    }

    // 🔹 Random species generator
    static String getRandomSpecies() {
        String[] speciesList = {"Dragon", "Cat", "Dog", "Phoenix", "Dino"};
        Random rand = new Random();
        return speciesList[rand.nextInt(speciesList.length)];
    }

    // 🔹 Evolution mechanics
    void evolvePet() {
        if (stageIndex >= EVOLUTION_STAGES.length - 1) return;

        if (!EVOLUTION_STAGES[stageIndex].equals("Ghost")) {
            if (age >= 2 && stageIndex < 5) {
                stageIndex++;
                System.out.println(petName + " has evolved into " + EVOLUTION_STAGES[stageIndex] + "!");
            }
        }
    }

    // 🔹 Care methods
    void feedPet() {
        if (isDead()) return;
        happiness += 5;
        health += 5;
        System.out.println(petName + " enjoyed a meal! 🍖");
    }

    void playWithPet() {
        if (isDead()) return;
        happiness += 10;
        health -= 2; // playing consumes energy
        System.out.println(petName + " played happily! 🎮");
    }

    void healPet() {
        if (isDead()) return;
        health += 15;
        System.out.println(petName + " feels healthier! 💊");
    }

    // 🔹 Simulate one day
    void simulateDay() {
        if (isDead()) return;

        age++;
        happiness -= 5;
        health -= 5;

        if (health <= 0) {
            stageIndex = 6; // Ghost
            System.out.println(petName + " has died... 👻 Now haunting as a Ghost!");
        } else {
            evolvePet();
        }
    }

    // 🔹 Status check
    String getPetStatus() {
        return EVOLUTION_STAGES[stageIndex];
    }

    boolean isDead() {
        return EVOLUTION_STAGES[stageIndex].equals("Ghost");
    }

    void displayPet() {
        System.out.println("Pet ID: " + petId);
        System.out.println("Name: " + petName);
        System.out.println("Species: " + species);
        System.out.println("Age: " + age);
        System.out.println("Stage: " + getPetStatus());
        System.out.println("Happiness: " + happiness);
        System.out.println("Health: " + health);
        System.out.println("-------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        // 🔹 Create a daycare with multiple pets
        VirtualPet pet1 = new VirtualPet();                        // Egg
        VirtualPet pet2 = new VirtualPet("Fluffy");                // Baby
        VirtualPet pet3 = new VirtualPet("Blaze", "Dragon");       // Child
        VirtualPet pet4 = new VirtualPet("Rocky", "Dino", 5, 80, 80, 3); // Teen

        List<VirtualPet> pets = Arrays.asList(pet1, pet2, pet3, pet4);

        // 🔹 Simulate several days
        for (int day = 1; day <= 5; day++) {
            System.out.println("\n📅 Day " + day + " simulation:");
            for (VirtualPet pet : pets) {
                pet.simulateDay();
                if (!pet.isDead()) {
                    pet.feedPet();
                    pet.playWithPet();
                }
                pet.displayPet();
            }
        }

        System.out.println("Total pets created: " + VirtualPet.totalPetsCreated);
    }
}
