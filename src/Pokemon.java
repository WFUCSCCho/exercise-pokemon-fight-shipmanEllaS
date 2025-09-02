public class Pokemon implements Comparable <Pokemon> {
    //#,Name,Type 1,Type 2,Total,HP,Attack,Defense,Sp. Atk,Sp. Def,Speed,Generation,Legendary
    private int num;
    private String name;
    private String type1;
    private String type2;
    private int total;
    private int hp;
    private int attack;
    private int defense;
    private int spatt;
    private int spdef;
    private int speed;
    private int generation;
    private boolean legendary;

    // default constructor
    public Pokemon() {
        super();
    }

    // constructor
    public Pokemon(int num, String name, String type1, String type2, int total, int hp, int attack, int defense, int spatt, int spdef, int speed, int generation, boolean legendary) {
        super();
        this.num = num;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.total = total;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.spatt = spatt;
        this.spdef = spdef;
        this.speed = speed;
        this.generation = generation;
        this.legendary = legendary;
    }

    // String interface for Pokémon
    @Override
    public String toString() {
        String pokeInfo;
        pokeInfo = "(" + num + ") " + name + " [ " + type1;
        if (type2.length() > 0)
            pokeInfo += " / " + type2;
        pokeInfo += " ]: Total: " + total;
        pokeInfo += ", Speed: " + speed;
        return pokeInfo;
    }

    // Comparable interface for Pokémon total base stat
    @Override
    public int compareTo(Pokemon poke2) {
        return Integer.compare(getTotal(), poke2.getTotal());
    }

    // check total base stat
    public boolean checkBaseStat() {
        if (total != (hp + attack + defense + spatt + spdef + speed)) {
            System.err.println("Warning: Total Base Stat incorrect.");
            return false;
        } else {
            return true;
        }
    }

    // getter for total base stat
    public int getTotal() {
        return total;
    }

    // getter for speed
    public int getSpeed() {
        return speed;
    }

    // getter for generation
    public int getGeneration() {
        return generation;
    }

    // getter for legendary
    public boolean isLegendary() {
        return legendary;
    }
}

