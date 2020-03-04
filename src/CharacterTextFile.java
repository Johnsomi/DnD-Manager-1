import java.util.*;
import java.io.*;
import java.nio.file.*;
public final class CharacterTextFile implements DAO<Character>{
    private List<Character> players = null;
    private Path playersPath = null;
    private File playersFile = null;

    private final String FIELD_SEP = "\t";

    public CharacterTextFile() throws FileNotFoundException, IOException {
        playersPath = Paths.get("players.txt");
        playersFile = playersPath.toFile();
        if(!playersFile.exists()){
            throw new FileNotFoundException();
        }
        players = this.getAll();
    }

    @Override
    public List<Character> getAll() throws IOException, FileNotFoundException{
        if(players != null){
            return players;
        }

        players = new ArrayList<>();

        if(Files.exists(playersPath)){
            BufferedReader in = new BufferedReader(new FileReader(playersFile));

            String line = in.readLine();
            while (line != null) {
                String[] columns = line.split(FIELD_SEP);
                String firstName = columns[0];
                String lastName = columns[1];
                String race = columns[2];
                String alignment = columns[3];
                String str = columns[4];
                int strength = Integer.parseInt(str);
                String dex = columns[5];
                int dexterity = Integer.parseInt(dex);
                String con = columns[6];
                int constitution = Integer.parseInt(con);
                String intel = columns[7];
                int intelligence = Integer.parseInt(intel);
                String wis = columns[8];
                int wisdom = Integer.parseInt(wis);
                String cha = columns[9];
                int charisma = Integer.parseInt(cha);
                String hp = columns[10];
                int health = Integer.parseInt(hp);
                String lv = columns[11];
                int level = Integer.parseInt(lv);
                String exp = columns[12];
                int EXP = Integer.parseInt(exp);

                Character p = new Character(firstName, lastName, race, alignment, strength, dexterity, constitution, intelligence, wisdom, charisma, health, level, EXP);

                players.add(p);

                line = in.readLine();
            }
        }
        return players;
    }

    @Override
    public Character get(String name) throws IOException{
        for (Character p : players) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public boolean add(Character p) throws IOException{
        players.add(p);
        return this.saveAll();
    }

    @Override
    public boolean delete(Character p) throws IOException{
        players.remove(p);
        return this.saveAll();
    }

    @Override
    public boolean update(Character newCharacter) throws IOException{

        // get the old customer and remove it
        Character oldCharacter = this.get(newCharacter.getName());
        int i = players.indexOf(oldCharacter);
        players.remove(i);

        // add the updated customer
        players.add(i, newCharacter);

        return this.saveAll();
    }

    private boolean saveAll() throws IOException{
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(playersFile)));

        // write all customers in the array list
        // to the file
        for (Character p : players) {
            out.print(p.getFirstName() + FIELD_SEP);
            out.print(p.getLastName() + FIELD_SEP);
            out.print(p.getRace() + FIELD_SEP);
            out.print(p.getAlignment() + FIELD_SEP);
            out.print(p.getStrength() + FIELD_SEP);
            out.print(p.getDexterity() + FIELD_SEP);
            out.print(p.getConstitution() + FIELD_SEP);
            out.print(p.getIntelligence() + FIELD_SEP);
            out.print(p.getWisdom() + FIELD_SEP);
            out.print(p.getCharisma() + FIELD_SEP);
            out.print(p.getHealth() + FIELD_SEP);
            out.print(p.getLevel() + FIELD_SEP);
            out.println(p.getEXP());
        }
        out.close();

        return true;
    }
}
