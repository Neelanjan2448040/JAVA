// RoyalRules class represents the unchangeable laws of the kingdom
final class RoyalRules {
    // A method that cannot be overridden
    public final void displayLaws() {
        System.out.println("Royal Laws: No one can change or override the rules of Dholakpur.");
    }
}

// King class represents the ruler with an unchangeable title
class King {
    private final String title; // The king's title is fixed

    public King(String title) {
        this.title = title;
    }

    public void showTitle() {
        System.out.println("The King of Dholakpur: " + title);
    }
}

// Warrior class represents any warrior who protects Dholakpur
class Warrior {
    protected String name;

    public Warrior(String name) {
        this.name = name;
    }

    public void fightStyle() { // General fighting style (can be overridden)
        System.out.println(name + " fights with a unique style.");
    }
}

// ChhotaBheem class extends Warrior but has a fixed fighting style
class ChhotaBheem extends Warrior {
    public ChhotaBheem() {
        super("Chhota Bheem");
    }

    @Override
    public final void fightStyle() { // Cannot be overridden
        System.out.println(name + " fights with legendary strength and technique!");
    }
}

// Kalia class extends Warrior and can have a different fighting style
class Kalia extends Warrior {
    public Kalia() {
        super("Kalia");
    }

    @Override
    public void fightStyle() { // Can be overridden
        System.out.println(name + " fights with brute force but lacks skill.");
    }
}

// Jaggu class extends Warrior and defines a unique fight style
class Jaggu extends Warrior {
    public Jaggu() {
        super("Jaggu");
    }

    @Override
    public void fightStyle() {
        System.out.println(name + " fights with speed and agility, using trees to his advantage.");
    }
}

// Raju class extends Warrior and defines a unique fight style
class Raju extends Warrior {
    public Raju() {
        super("Raju");
    }

    @Override
    public void fightStyle() {
        System.out.println(name + " fights with discipline and precision, using his slingshot.");
    }
}

// Chutki class extends Warrior and defines a unique fight style
class Chutki extends Warrior {
    public Chutki() {
        super("Chutki");
    }

    @Override
    public void fightStyle() {
        System.out.println(name + " fights with intelligence and quick reflexes.");
    }
}

// Main class to test the functionality
public class DholakpurBattle {
    public static void main(String[] args) {
        // Displaying royal laws
        RoyalRules rules = new RoyalRules();
        rules.displayLaws();
        
        // Creating the king and displaying title
        King king = new King("Raja Indraverma");
        king.showTitle();
        
        // Creating warriors and demonstrating fight styles
        ChhotaBheem bheem = new ChhotaBheem();
        bheem.fightStyle();
        
        Kalia kalia = new Kalia();
        kalia.fightStyle();
        
        // Adding other warriors
        Jaggu jaggu = new Jaggu();
        jaggu.fightStyle();

        Raju raju = new Raju();
        raju.fightStyle();

        Chutki chutki = new Chutki();
        chutki.fightStyle();
    }
}