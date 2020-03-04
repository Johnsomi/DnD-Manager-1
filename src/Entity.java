public class Entity {
    private String firstName;
    private String lastName;
    private String race;
    private String alignment;
    private int level = 1;
    private int EXP = 0;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private int health;


    public Entity(String firstName, String lastName, String race, String alignment, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma, int health, int level, int EXP){
        this.firstName = firstName;
        this.lastName = lastName;
        this.race = race;
        this.alignment = alignment;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.level = level;
        this.EXP = EXP;
        this.health = health;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getRace() {
        return race;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setEXP(int EXP) {
        this.EXP = EXP;
    }

    public int getEXP() {
        return EXP;
    }

    public String getEntity() {
        return firstName + " " + lastName + " " + race + " " + alignment+ " " + strength + " " + dexterity + " " + constitution + " " + intelligence + " " + wisdom + " " + charisma + " " + health + " " + level + " " + EXP;
    }

}
