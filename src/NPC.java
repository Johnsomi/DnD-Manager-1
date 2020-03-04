public class NPC extends Entity{

    public NPC(){
        this("","","","",0,0,0,0,0,0,0,0,0);
    }

    public NPC(String firstName, String lastName, String race, String alignment, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma, int health, int level, int EXP){
        super(firstName, lastName, race, alignment, strength, dexterity, constitution, intelligence, wisdom, charisma, health, level, EXP);
    }
}
