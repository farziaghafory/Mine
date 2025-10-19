// We import Scanner in case we want to read input later.
// (Not used in this example, but it's okay to leave it.)
import java.util.Scanner;

// This is our main class. The program starts here.
public class ResultadosAtleti {

    // ------------------------------
    // INNER CLASS: Partido (a match)
    // ------------------------------
    // This small class represents ONE football match.
    static class Partido {

        // These are the pieces of data stored in each match:
        private final String rival;        // name of the rival team
        private final int golesMarcados;   // goals Atlético scored
        private final int golesRecibidos;  // goals the rival scored

        // This is the constructor. It runs when we create a new match.
        // It sets the values for rival, golesMarcados, and golesRecibidos.
        public Partido(String rival, int golesMarcados, int golesRecibidos) {
            this.rival = rival;               // store the rival name
            this.golesMarcados = golesMarcados; // store goals scored
            this.golesRecibidos = golesRecibidos; // store goals received
        }

        // These are "getter" methods — they return the values stored inside the object.
        public String getRival() { return rival; }               // gives back the rival name
        public int getGolesMarcados() { return golesMarcados; }  // gives back goals scored
        public int getGolesRecibidos() { return golesRecibidos; }// gives back goals received

        // This method says how to show the match as text (when we print it).
        // Example output: vs Barcelona (2-3)
        @Override
        public String toString() {
            
            return String.format("vs %s (%d-%d)", rival, golesMarcados, golesRecibidos);
        }
    }

    // ------------------------------
    // METHODS THAT USE MANY MATCHES
    // ------------------------------

    // This method finds the average (mean) number of goals Atlético scored.
    public static double mediaGolesMarcados(Partido[] temporada) {
        int suma = 0; // start with total = 0

        // Go through each match in the list (array)
        for (Partido p : temporada) {
            suma += p.getGolesMarcados(); // add the goals from this match
        }

        // Divide total goals by number of matches to get the average
        return (double) suma / temporada.length;
    }

    // This method finds the match where Atlético scored the MOST goals.
    public static Partido partidoMasGolesMarcados(Partido[] temporada) {
        Partido mejor = temporada[0]; // start by saying the first match is the best one

        // Go through all the other matches
        for (int i = 1; i < temporada.length; i++) {
            // If this match has MORE goals than the current best one...
            if (temporada[i].getGolesMarcados() > mejor.getGolesMarcados()) {
                mejor = temporada[i]; // ...then this one becomes the new "best" match
            }
        }

        // After the loop, 'mejor' is the match with most goals
        return mejor;
    }

    // This method finds the match where Atlético scored the FEWEST goals.
    public static Partido partidoMenosGolesMarcados(Partido[] temporada) {
        Partido peor = temporada[0]; // start assuming the first match is the worst

        // Check every match in the list
        for (int i = 1; i < temporada.length; i++) {
            // If this match has FEWER goals than the current worst...
            if (temporada[i].getGolesMarcados() < peor.getGolesMarcados()) {
                peor = temporada[i]; // ...then this one becomes the new "worst" match
            }
        }

        // After the loop, 'peor' is the match with fewest goals
        return peor;
    }

    // This adds up ALL the goals Atlético scored in the whole season.
    public static int totalGolesMarcados(Partido[] temporada) {
        int total = 0; // start at zero
        for (Partido p : temporada) {
            total += p.getGolesMarcados(); // add goals from each match
        }
        return total; // give back the total number
    }

    // This adds up ALL the goals Atlético received (rivals' goals).
    public static int totalGolesRecibidos(Partido[] temporada) {
        int total = 0; // start at zero
        for (Partido p : temporada) {
            total += p.getGolesRecibidos(); // add goals from each rival
        }
        return total; // give back the total
    }

    // ------------------------------
    // MAIN METHOD (program starts here)
    // ------------------------------
    public static void main(String[] args) {

        // Create an array (list) of matches.
        // Each "new Partido" is one football match.
        Partido[] temporada = {
            new Partido("Sevilla", 3, 1),         // Atlético 3 - Sevilla 1
            new Partido("Real Sociedad", 2, 1),   // Atlético 2 - Real Sociedad 1
            new Partido("Valencia", 0, 0),        // Atlético 0 - Valencia 0
            new Partido("Barcelona", 2, 3),       // Atlético 2 - Barcelona 3
            new Partido("Real Madrid", 0, 5),     // Atlético 0 - Real Madrid 5
            new Partido("Rayo Vallecano", 4, 2)   // Atlético 4 - Rayo Vallecano 2
        };

        // Call our methods to get results
        double media = mediaGolesMarcados(temporada);      // average goals scored
        Partido mas = partidoMasGolesMarcados(temporada);  // match with most goals
        Partido menos = partidoMenosGolesMarcados(temporada); // match with fewest goals
        int marcados = totalGolesMarcados(temporada);      // total goals scored
        int recibidos = totalGolesRecibidos(temporada);    // total goals received

        // Print everything to the screen
        System.out.printf("Average goals scored: %.2f%n", media);
        System.out.printf("Match with MOST goals scored: %s%n", mas);
        System.out.printf("Match with FEWEST goals scored: %s%n", menos);
        System.out.printf("TOTAL goals scored: %d | TOTAL goals received: %d%n",
                marcados, recibidos);
    }
}
