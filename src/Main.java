import java.util.ArrayList;
public class Main {
    ArrayList<Entity> entities = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Welcome to the DnD Manager!");
        displayMenu();
        String firstAction = "";
        while (!firstAction.equalsIgnoreCase("exit")) {
            // get the input from the user
            firstAction = Console.getString("Enter a command: ");
            System.out.println();

            if (firstAction.equalsIgnoreCase("list")) {
                displayAllCustomers();
            } else if (firstAction.equalsIgnoreCase("add")) {
                displayAddMenu();
            } else if (firstAction.equalsIgnoreCase("del") || firstAction.equalsIgnoreCase("delete")) {
                displayDelMenu();
            } else if (firstAction.equalsIgnoreCase("help") || firstAction.equalsIgnoreCase("menu")) {
                displayMenu();
            } else if (firstAction.equalsIgnoreCase("exit")) {
                System.out.println("Bye.\n");
            } else {
                System.out.println("Error! Not a valid command.\n");
            }
        }
    }

    public static void displayMenu(){
        System.out.println("COMMAND MENU");
        System.out.println("list - List all characters");
        System.out.println("add  - create new entity");
        System.out.println("del  - delete an entity");
        System.out.println("help - Show this menu");
        System.out.println("exit - Exit the application\n");
    }

    public static void displayAddMenu(){
        System.out.println("NEW ENTITY MENU");
        System.out.println("player - Add new player");
        System.out.println("npc    - Add new NPC");
        System.out.println("back   - Exit New Menu");
    }

    public static void displayDelMenu(){
        System.out.println("DELETE ENTITY MENU");
        System.out.println("player - Delete player");
        System.out.println("npc    - Delete NPC");
        System.out.println("back   - Exit Delete Menu");
    }

    public static void addCharacter() {
        String firstName = Console.getString("Enter first name: ");
        String lastName = Console.getString("Enter last name: ");
        String race = Console.getString("Enter race: ");
        int strength = Console.getInt("Enter strength: ");
        int dexterity = Console.getInt("Enter dexterity: ");
        int constitution = Console.getInt("Enter constitution: ");
        int intelligence = Console.getInt("Enter intelligence: ");
        int wisdom = Console.getInt("Enter wisdom: ");
        int charisma = Console.getInt("Enter charisma: ");
        int health = Console.getInt("Enter health: ");
        int level = Console.getInt("Enter level: ");
        int EXP = Console.getInt("Enter EXP: ");

        entities.add(new Character(firstName, lastName, race, strength, dexterity, constitution, intelligence, wisdom, charisma, health, level, EXP));
    }
}
