import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class PokemonFight {

    public static int fight(ArrayList<Pokemon> arr, Comparator<Pokemon> c, int first, int second) {
        return c.compare(arr.get(first), arr.get(second));
    }

    public static void main(String[] args) throws IOException {
        // Ask for input file
        Scanner scnr = new Scanner(System.in);
        System.out.println("Pokémon filename?: ");
        String inputFileName = scnr.nextLine();

        // For file input
        String fileName;
        FileInputStream inputFileNameStream = null;
        Scanner inputFileNameScanner = null;

        // Open the input file
        inputFileNameStream = new FileInputStream(inputFileName);
        inputFileNameScanner = new Scanner(inputFileNameStream);

        // ignore first line
        inputFileNameScanner.nextLine();

        // Pokemon ArrayList (PokeDex)
        ArrayList<Pokemon> PokeDex = new ArrayList<Pokemon>();

        // Read in file and store data in Pokemon ArrayList
        while (inputFileNameScanner.hasNext()) {
            String line = inputFileNameScanner.nextLine();
            String[] parts = line.split(",");
            Pokemon mon = new Pokemon(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3], Integer.parseInt(parts[4]), Integer.parseInt(parts[5]), Integer.parseInt(parts[6]), Integer.parseInt(parts[7]), Integer.parseInt(parts[8]), Integer.parseInt(parts[9]), Integer.parseInt(parts[10]), Integer.parseInt(parts[11]), Boolean.parseBoolean(parts[12]));
            PokeDex.add(mon);
            //System.out.println(poke); // for debugging
        }
        inputFileNameStream.close(); // because I care

        // sort Pokémon (by total base stats)
        Collections.sort(PokeDex);

        // print PokeDex for legendaries after sorting
        System.out.println("Legendaries sorted by total base stats:");
        for (Pokemon poke: PokeDex) {
            if (poke.isLegendary())
                System.out.println(poke);
        }

        // sort Pokémon by speed
        Collections.sort(PokeDex, new PokeBySpeed());

        // print PokeDex for Gen 1 after sorting
        System.out.println("Gen 1 sorted by speed:");
        for (Pokemon mon: PokeDex) {
            if (mon.getGeneration() == 1)
                System.out.println(mon);
        }

        // print PokeDex for legendaries after sorting
        System.out.println("Legendaries sorted by total base stats:");
        for (Pokemon mon: PokeDex) {
            if (mon.isLegendary())
                System.out.println(mon);
        }

        // pick two Pokémons
        Random rand = new Random();
        int first = rand.nextInt(PokeDex.size());
        int second = rand.nextInt(PokeDex.size());

        // Fight two Pokémons
        System.out.println("Let's fight:");
        System.out.println("Pokémon 1: " + PokeDex.get(first));
        System.out.println("Pokémon 2: " + PokeDex.get(second));
        int winner = fight(PokeDex, new PokeBySpeed(), first, second);
        if (winner > 0) {
            System.out.print("Winner ");
            //System.out.print("(" + winner + ")"); // for debugging
            System.out.println(": " + PokeDex.get(first));
        } else {
            System.out.print("Winner ");
            //System.out.print("(" + winner + ")"); // for debugging
            System.out.println(": " + PokeDex.get(second));
        }
    }
}
