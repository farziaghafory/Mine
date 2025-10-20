<<<<<<< HEAD



public class ResultadosAtleti {

    /**
     * Representa un partido con rival y goles a favor/en contra.
     */
    static class Partido {
        private final String rival;
        private final int golesMarcados;  // a favor
        private final int golesRecibidos; // en contra

        /**
         * Crea un nuevo partido.
         *
         * @param rival          nombre del equipo rival
         * @param golesMarcados  goles a favor del Atlético
         * @param golesRecibidos goles en contra del Atlético
         */
        public Partido(String rival, int golesMarcados, int golesRecibidos) {
            this.rival = rival;
            this.golesMarcados = golesMarcados;
            this.golesRecibidos = golesRecibidos;
        }

        /** @return rival */
        public String getRival() { return rival; }

        /** @return goles a favor */
        public int getGolesMarcados() { return golesMarcados; }

        /** @return goles en contra */
        public int getGolesRecibidos() { return golesRecibidos; }

        @Override
        public String toString() {
=======
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
            
>>>>>>> 81b0b11de8c1b399e2d8245833b47fcdc93306d1
            return String.format("vs %s (%d-%d)", rival, golesMarcados, golesRecibidos);
        }
    }

<<<<<<< HEAD
    // ---------------------------------------------------------------------
    // MÉTODOS A IMPLEMENTAR (como en el ejercicio de notas)
    // ---------------------------------------------------------------------

    /**
     * Calcula la media aritmética de los goles MARCADOS por partido.
     *
     * @param temporada array de partidos (no nulo ni vacío)
     * @return media de goles marcados
     */
    public static double mediaGolesMarcados(Partido[] temporada) {
        // TODO:
        int Suma = 0;
    

        // Use a for-each loop to iterate over every Producto in the array.
        // for-each is concise and avoids index mistakes when we only need elements.
        for (Partido p : temporada) {

           Suma += p.getGolesMarcados();
        }

        // After the loop, total holds the sum of all product prices; return it.
       return temporada.length > 0 ? (double) Suma / temporada.length : 0.0;
    }
        // 1. Inicializa una variable suma a 0.
        // 2. Recorre el array con un for-each y suma getGolesMarcados().
        // 3. Devuelve suma / temporada.length (como double).
    /**
     * Devuelve el partido con MÁS goles marcados.
     *
     * @param temporada array de partidos (no nulo ni vacío)
     * @return partido con el máximo de goles a favor
     */
    public static Partido partidoMasGolesMarcados(Partido[] temporada) {
        // TODO:
        Partido mejor = temporada[0];
        // 1. Crea una variable Partido mejor = temporada[0];

        // 2. Recorre el array desde el índice 1.
        // 3. Si temporada[i].getGolesMarcados() > mejor.getGolesMarcados(), actualiza mejor.
        // 4. Devuelve mejor.
        return null;
    }

    /**
     * Devuelve el partido con MENOS goles marcados.
     *
     * @param temporada array de partidos (no nulo ni vacío)
     * @return partido con el mínimo de goles a favor
     */
    public static Partido partidoMenosGolesMarcados(Partido[] temporada) {
        // TODO:
        // 1. Crea una variable Partido peor = temporada[0];
        // 2. Recorre el array desde el índice 1.
        // 3. Si temporada[i].getGolesMarcados() < peor.getGolesMarcados(), actualiza peor.
        // 4. Devuelve peor.
        return null;
    }

    // ---------------------------------------------------------------------
    // EXTRAS (opcional, por si quieres pedir suma de goles)
    // ---------------------------------------------------------------------

    /**
     * Suma total de goles marcados en la temporada.
     */
    public static int totalGolesMarcados(Partido[] temporada) {
        // TODO (opcional):
        // 1. Acumula getGolesMarcados() en un int y devuelve.
        return 0;
    }

    /**
     * Suma total de goles recibidos en la temporada.
     */
    public static int totalGolesRecibidos(Partido[] temporada) {
        // TODO (opcional):
        // 1. Acumula getGolesRecibidos() en un int y devuelve.
        return 0;
    }

    // ---------------------------------------------------------------------
    // MAIN
    // ---------------------------------------------------------------------

    /**
     * Método principal: crea una lista de partidos de ejemplo y usa los métodos.
     */
    public static void main(String[] args) {

        // 1️⃣ Ejemplo con datos fijos (puedes cambiarlos o leerlos con Scanner)
        Partido[] temporada = {
            new Partido("Sevilla", 3, 1),
            new Partido("Real Sociedad", 2, 1),
            new Partido("Valencia", 0, 0),
            new Partido("Barcelona", 2, 3),
            new Partido("Real Madrid", 0, 5),
            new Partido("Rayo Vallecano", 4, 2)
        };

        // 2️⃣ Llama a los métodos y muestra resultados
        // double media = mediaGolesMarcados(temporada);
        // Partido mas = partidoMasGolesMarcados(temporada);
        // Partido menos = partidoMenosGolesMarcados(temporada);
        //
        // // Extras:
        // int marcados = totalGolesMarcados(temporada);
        // int recibidos = totalGolesRecibidos(temporada);

        // 3️⃣ Muestra por pantalla (quita los comentarios al implementar)
        // System.out.printf("Media de goles marcados: %.2f%n", media);
        // System.out.printf("Partido con MÁS goles marcados: %s%n", mas);
        // System.out.printf("Partido con MENOS goles marcados: %s%n", menos);
        // System.out.printf("TOTAL goles marcados: %d | TOTAL goles recibidos: %d%n", marcados, recibidos);

        //sc.close();
         double Suma = mediaGolesMarcados(temporada);
    }
}
=======
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
>>>>>>> 81b0b11de8c1b399e2d8245833b47fcdc93306d1
