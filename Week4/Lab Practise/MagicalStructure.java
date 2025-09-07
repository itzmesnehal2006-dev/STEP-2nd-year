import java.util.*;

// 🔹 Base abstract class
abstract class MagicalStructure {
    String structureName;
    int magicPower;
    String location;
    boolean isActive;

    // Main constructor
    MagicalStructure(String structureName, int magicPower, String location, boolean isActive) {
        this.structureName = structureName;
        this.magicPower = magicPower;
        this.location = location;
        this.isActive = isActive;
    }

    // Overloaded constructor (default active)
    MagicalStructure(String structureName, int magicPower, String location) {
        this(structureName, magicPower, location, true);
    }

    // Overloaded constructor (minimal info)
    MagicalStructure(String structureName) {
        this(structureName, 50, "Unknown", true);
    }

    // Abstract method
    abstract void castMagicSpell();
}

// 🔹 Wizard Tower
class WizardTower extends MagicalStructure {
    int spellCapacity;
    String[] knownSpells;

    WizardTower(String name) {
        this(name, 100, "Hilltop", 5, new String[]{"Fireball"});
    }

    WizardTower(String name, int spellCapacity, String[] spells) {
        this(name, 150, "Mountain Peak", spellCapacity, spells);
    }

    WizardTower(String name, int magicPower, String loc, int spellCapacity, String[] spells) {
        super(name, magicPower, loc, true);
        this.spellCapacity = spellCapacity;
        this.knownSpells = spells;
    }

    @Override
    void castMagicSpell() {
        System.out.println(structureName + " casts " + knownSpells[0] + "!");
    }
}

// 🔹 Enchanted Castle
class EnchantedCastle extends MagicalStructure {
    int defenseRating;
    boolean hasDrawbridge;

    EnchantedCastle(String name) {
        this(name, 200, "Valley", 50, true);
    }

    EnchantedCastle(String name, int defenseRating) {
        this(name, 250, "Riverbank", defenseRating, false);
    }

    EnchantedCastle(String name, int magicPower, String loc, int defenseRating, boolean drawbridge) {
        super(name, magicPower, loc, true);
        this.defenseRating = defenseRating;
        this.hasDrawbridge = drawbridge;
    }

    @Override
    void castMagicSpell() {
        System.out.println(structureName + " raises a magical shield! 🛡️");
    }
}

// 🔹 Mystic Library
class MysticLibrary extends MagicalStructure {
    int bookCount;
    String ancientLanguage;

    MysticLibrary(String name) {
        this(name, 1000, "Latin");
    }

    MysticLibrary(String name, int bookCount, String lang) {
        super(name, 120, "Town Center", true);
        this.bookCount = bookCount;
        this.ancientLanguage = lang;
    }

    @Override
    void castMagicSpell() {
        System.out.println(structureName + " whispers secrets in " + ancientLanguage + "...");
    }
}

// 🔹 Dragon Lair
class DragonLair extends MagicalStructure {
    String dragonType;
    int treasureValue;

    DragonLair(String name) {
        this(name, "Fire Dragon", 10000);
    }

    DragonLair(String name, String type, int treasure) {
        super(name, 300, "Cave", true);
        this.dragonType = type;
        this.treasureValue = treasure;
    }

    @Override
    void castMagicSpell() {
        System.out.println(dragonType + " breathes fire from " + structureName + "!");
    }
}

// 🔹 Magical Interactions
class MagicSystem {
    static boolean canStructuresInteract(MagicalStructure s1, MagicalStructure s2) {
        return !(s1 instanceof DragonLair && s2 instanceof DragonLair); // Dragons don’t like each other
    }

    static String performMagicBattle(MagicalStructure attacker, MagicalStructure defender) {
        if (attacker.magicPower > defender.magicPower) {
            return attacker.structureName + " wins the battle!";
        } else if (attacker.magicPower < defender.magicPower) {
            return defender.structureName + " defends successfully!";
        } else {
            return "The battle between " + attacker.structureName + " and " + defender.structureName + " ends in a draw!";
        }
    }

    static int calculateKingdomMagicPower(MagicalStructure[] structures) {
        int total = 0;
        for (MagicalStructure s : structures) {
            total += s.magicPower;
        }
        return total;
    }

    // 🔹 Special effects
    static void applySpecialEffects(MagicalStructure s1, MagicalStructure s2) {
        if (s1 instanceof WizardTower && s2 instanceof MysticLibrary) {
            ((WizardTower) s1).spellCapacity *= 2;
            System.out.println("Knowledge boost! " + s1.structureName + " spell capacity doubled.");
        }
        if (s1 instanceof EnchantedCastle && s2 instanceof DragonLair) {
            ((EnchantedCastle) s1).defenseRating *= 3;
            System.out.println("Dragon guard! " + s1.structureName + " defense tripled.");
        }
    }
}

// 🔹 Kingdom Manager
class KingdomManager {
    static void categorizeStructures(MagicalStructure[] structures) {
        for (MagicalStructure s : structures) {
            if (s instanceof WizardTower) {
                System.out.println(s.structureName + " is a Wizard Tower.");
            } else if (s instanceof EnchantedCastle) {
                System.out.println(s.structureName + " is an Enchanted Castle.");
            } else if (s instanceof MysticLibrary) {
                System.out.println(s.structureName + " is a Mystic Library.");
            } else if (s instanceof DragonLair) {
                System.out.println(s.structureName + " is a Dragon Lair.");
            }
        }
    }

    static void determineSpecialization(MagicalStructure[] structures) {
        int magic = 0, defense = 0;
        for (MagicalStructure s : structures) {
            if (s instanceof WizardTower || s instanceof MysticLibrary) magic++;
            if (s instanceof EnchantedCastle || s instanceof DragonLair) defense++;
        }
        if (magic > defense) {
            System.out.println("The kingdom is Magic-focused ✨");
        } else if (defense > magic) {
            System.out.println("The kingdom is Defense-focused 🛡️");
        } else {
            System.out.println("The kingdom is Balanced ⚖️");
        }
    }
}

// 🔹 Demo
public class Main {
    public static void main(String[] args) {
        MagicalStructure tower = new WizardTower("Arcane Spire");
        MagicalStructure castle = new EnchantedCastle("Moonstone Keep");
        MagicalStructure library = new MysticLibrary("Elders’ Archives", 5000, "Runic");
        MagicalStructure lair = new DragonLair("Inferno's Den", "Fire Dragon", 20000);

        MagicalStructure[] kingdom = {tower, castle, library, lair};

        // Categorize
        KingdomManager.categorizeStructures(kingdom);

        // Apply special interactions
        MagicSystem.applySpecialEffects(tower, library);
        MagicSystem.applySpecialEffects(castle, lair);

        // Cast some spells
        tower.castMagicSpell();
        castle.castMagicSpell();
        library.castMagicSpell();
        lair.castMagicSpell();

        // Magic battle
        System.out.println(MagicSystem.performMagicBattle(tower, castle));

        // Total power
        System.out.println("Total Kingdom Magic Power: " + MagicSystem.calculateKingdomMagicPower(kingdom));

        // Specialization
        KingdomManager.determineSpecialization(kingdom);
    }
}
