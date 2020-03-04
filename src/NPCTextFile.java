import java.util.*;
import java.io.*;
import java.nio.file.*;
public final class NPCTextFile implements DAO<NPC>{
    private List<NPC> npcs = null;
    private Path npcsPath = null;
    private File npcsFile = null;

    private final String FIELD_SEP = "\t";

    public NPCTextFile() throws FileNotFoundException, IOException {
        npcsPath = Paths.get("npcs.txt");
        npcsFile = npcsPath.toFile();
        if(!npcsFile.exists()){
            throw new FileNotFoundException();
        }
        npcs = this.getAll();
    }

    @Override
    public List<NPC> getAll() throws IOException, FileNotFoundException{
        if(npcs != null){
            return npcs;
        }

        npcs = new ArrayList<>();

        if(Files.exists(npcsPath)){
            BufferedReader in = new BufferedReader(new FileReader(npcsFile));

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

                NPC p = new NPC(firstName, lastName, race, alignment, strength, dexterity, constitution, intelligence, wisdom, charisma, health, level, EXP);

                npcs.add(p);

                line = in.readLine();
            }
        }
        return npcs;
    }

    @Override
    public NPC get(String name) throws IOException{
        for (NPC p : npcs) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public boolean add(NPC p) throws IOException{
        npcs.add(p);
        return this.saveAll();
    }

    @Override
    public boolean delete(NPC p) throws IOException{
        npcs.remove(p);
        return this.saveAll();
    }

    @Override
    public boolean update(NPC newNPC) throws IOException{

        // get the old customer and remove it
        NPC oldNPC = this.get(newNPC.getName());
        int i = npcs.indexOf(oldNPC);
        npcs.remove(i);

        // add the updated customer
        npcs.add(i, newNPC);

        return this.saveAll();
    }

    private boolean saveAll() throws IOException{
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(npcsFile)));

        // write all customers in the array list
        // to the file
        for (NPC p : npcs) {
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