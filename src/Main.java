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
            } else if (firstAction.equalsIgnoreCase("play")) {
                //startGame();
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
            deleteCharacter();
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
            //deleteNPC();
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
                //sb.append(StringUtils.padWithSpaces(p.getEntity(), 35));
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
        String alignment = Console.getString("Enter alignment: ");
        int strength = Console.getInt("Enter strength: ");
        int dexterity = Console.getInt("Enter dexterity: ");
        int constitution = Console.getInt("Enter constitution: ");
        int intelligence = Console.getInt("Enter intelligence: ");
        int wisdom = Console.getInt("Enter wisdom: ");
        int charisma = Console.getInt("Enter charisma: ");
        int health = Console.getInt("Enter health: ");
        int level = Console.getInt("Enter level: ");
        int EXP = Console.getInt("Enter EXP: ");

        Character character = new Character();
        character.setFirstName(firstName);
        character.setLastName(lastName);
        character.setRace(race);
        character.setAlignment(alignment);
        character.setStrength(strength);
        character.setDexterity(dexterity);
        character.setConstitution(constitution);
        character.setIntelligence(intelligence);
        character.setWisdom(wisdom);
        character.setCharisma(charisma);
        character.setHealth(health);
        character.setLevel(level);
        character.setEXP(EXP);

        try{
            characterDAO.add(character);
        }catch(IOException e){
            System.out.println("Error adding player. Try again.");
            return;
        }
        System.out.println();
        System.out.println("Player " + character.getName() + " has been added.\n");
        //entities.add(new Character(firstName, lastName, race, strength, dexterity, constitution, intelligence, wisdom, charisma, health, level, EXP));
        //System.out.println("Player: "+entities.get(entities.size()-1).getName() + " has been entered.\n");

        displayPlayerMenu();
    }

    public static void deleteCharacter(){
        String name = Console.getString("Enter a name to delete: ");
        try{
            Character p = characterDAO.get(name);

            System.out.println();
            if(p != null){
                characterDAO.delete(p);
                System.out.println(p.getName() + " has been deleted.\n");
            }else{
                System.out.println("No names match.\n");
            }
        }catch(IOException e){
            System.out.println("Error deleting player. Try again.\n");
        }

        displayPlayerMenu();
    }

    public static void editCharacter(){
        String name = Console.getString("Enter a name to edit: ");

        try{
            Character p = characterDAO.get(name);

            System.out.println();
            if(p != null){
                String stat = Console.getString("First name = first\n" +
                        "Last name = last\n" +
                        "Race = race\n" +
                        "Alignment = align\n" +
                        "Strength = str\n" +
                        "Dexterity = dex\n" +
                        "Constitution = con\n" +
                        "Intelligence = int\n" +
                        "Wisdom = wis\n" +
                        "Charisma = cha\n" +
                        "Health = hp\n" +
                        "Level = lv\n" +
                        "EXP = exp\n" +
                        "Stat being edited: ");

                if(stat.equalsIgnoreCase("first")){
                    String NFN = Console.getString("New first name: ");

                }else if(stat.equalsIgnoreCase("last")){
                    String NLN = Console.getString("New last name: ");

                }else if(stat.equalsIgnoreCase("race")){
                    String NR = Console.getString("New race: ");

                }else if(stat.equalsIgnoreCase("align")){
                    String NA = Console.getString("New alignment: ");

                }else if(stat.equalsIgnoreCase("str")){
                    int NS = Console.getInt("New strength: ");

                }else if(stat.equalsIgnoreCase("dex")){
                    int ND = Console.getInt("New dexterity: ");

                }else if(stat.equalsIgnoreCase("con")){
                    int NCO = Console.getInt("New constitution: ");

                }else if(stat.equalsIgnoreCase("int")){
                    int NI = Console.getInt("New intelligence: ");

                }else if(stat.equalsIgnoreCase("wis")){
                    int NW = Console.getInt("New wisdom: ");

                }else if(stat.equalsIgnoreCase("cha")){
                    int NCH = Console.getInt("New charisma: ");

                }else if(stat.equalsIgnoreCase("hp")){
                    int NHP = Console.getInt("New health: ");

                }else if(stat.equalsIgnoreCase("lv")){
                    int NLV = Console.getInt("New level: ");

                }else if(stat.equalsIgnoreCase("exp")){
                    int NEXP = Console.getInt("New EXP: ");

                }else{
                    System.out.println("Something went wrong.");
                }

                characterDAO.update(p);

            }
        }catch(IOException e){
            System.out.println("Error editing player. Try again.\n");
        }
    }
}
