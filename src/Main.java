import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
public class Main {
    static ArrayList<Entity> entities = new ArrayList<>();
    private static DAO<Character> characterDAO = null;

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to the DnD Manager!");
        try{
            characterDAO = new CharacterTextFile();
        }catch(FileNotFoundException f){
            System.out.println("Error reading data file! Exiting application.");
            System.out.println("java.io.FileNotFoundException: customers.txt (The system cannot find the file specified)");
            System.exit(0);
        }catch(IOException e){
            System.out.println("Error");
        }
        displayMenu();
    }

    public static void displayMenu(){
        System.out.println("COMMAND MENU");
        System.out.println("player - Open Player Menu");
        System.out.println("npc    - Open NPC Menu");
        System.out.println("help   - Show this menu");
        System.out.println("exit   - Exit the application\n");

        String firstAction = "";
        while (!firstAction.equalsIgnoreCase("exit")) {
            // get the input from the user
            firstAction = Console.getString("Enter a command: ");
            System.out.println();

            if (firstAction.equalsIgnoreCase("player")) {
                displayPlayerMenu();
            } else if (firstAction.equalsIgnoreCase("npc")) {
                displayNPCMenu();
            } else if (firstAction.equalsIgnoreCase("help") || firstAction.equalsIgnoreCase("menu")) {
                displayMenu();
            } else if (firstAction.equalsIgnoreCase("exit")) {
                System.out.println("Bye.\n");
                System.exit(0);
            } else {
                System.out.println("Error! Not a valid command.\n");
            }
        }
    }

    public static void displayPlayerMenu(){
        System.out.println("PLAYER MENU");
        System.out.println("list   - List all players");
        System.out.println("add    - Add new player");
        System.out.println("del    - Delete a player");
        System.out.println("edit   - Edit a player");
        System.out.println("back   - Exit Player Menu");

        String actTwo = Console.getString("Enter a command: ");
        System.out.println();

        if (actTwo.equalsIgnoreCase("list")) {
            listCharacters();
        } else if (actTwo.equalsIgnoreCase("add")) {
            addCharacter();
        } else if (actTwo.equalsIgnoreCase("del") || actTwo.equalsIgnoreCase("delete")) {
            //delCharacter();
        } else if (actTwo.equalsIgnoreCase("edit")) {
            //editCharacter();
        } else if (actTwo.equalsIgnoreCase("back")) {
            displayMenu();
        } else {
            System.out.println("Error! Not a valid command.\n");
        }
    }

    public static void displayNPCMenu(){
        System.out.println("NPC MENU");
        System.out.println("list   - List all NPC's");
        System.out.println("add    - Add new NPC");
        System.out.println("del    - Delete NPC");
        System.out.println("edit   - Edit NPC");
        System.out.println("back   - Exit NPC Menu");

        String actTwo = Console.getString("Enter a command: ");
        System.out.println();

        if (actTwo.equalsIgnoreCase("list")) {
            //list NPC's
        } else if (actTwo.equalsIgnoreCase("add")) {
            //addNPC();
        } else if (actTwo.equalsIgnoreCase("del") || actTwo.equalsIgnoreCase("delete")) {
            //delNPC();
        } else if (actTwo.equalsIgnoreCase("edit")) {
            //editNPC();
        } else if (actTwo.equalsIgnoreCase("back")) {
            displayMenu();
        } else {
            System.out.println("Error! Not a valid command.\n");
        }
    }

    public static void listCharacters() {
        /*for(int i = 0; i<entities.size(); i++){
            if(entities.get(i).getClass() == Character.class) {
                System.out.println(entities.get(i).getName());
                System.out.println();
            }
        }*/
        System.out.println("PLAYER LIST");
        try{
            List<Character> players = characterDAO.getAll();

            Character p;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < players.size(); i++) {
                p = players.get(i);
                //sb.append(StringUtils.padWithSpaces(p.getName(), 35));
                sb.append(p.getEntity());
                sb.append("\n");
            }
            System.out.println(sb.toString());
        }catch(IOException e){

        }
        displayPlayerMenu();
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

        System.out.println("Player: "+entities.get(entities.size()-1).getName() + " has been entered.\n");

        displayPlayerMenu();
    }
}
