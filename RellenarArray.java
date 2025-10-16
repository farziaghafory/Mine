
// Import the Scanner class from the java.util package to read input from the console.
import java.util.Scanner;

/**
 * The RellenarArray class contains methods to create and display
 * an array of fruits entered by the user through the console.
 *
 * This JavaDoc comment block explains the purpose of the class
 * and gives an example of how to use it.
 */
public class RellenarArray {

    /**
     * Creates an array of fruits by asking the user to type the names.
     *
     * @param scanner a Scanner object used to read user input.
     * @return a String array containing the names of the fruits entered.
     */
    public static String[] crearArrayFrutas(Scanner scanner) {
        // Create a String array with space for 5 fruits.
        String[] frutas = new String[5];

        // Print a message to tell the user what to do.
        System.out.println("Enter the names of 5 fruits:");

        // Loop runs 5 times, once for each position in the array.
        for (int i = 0; i < frutas.length; i++) {
            // Print which fruit number the user should enter next.
            System.out.print("Fruit " + (i + 1) + ": ");

            // Store the user’s input in the current position of the array.
            frutas[i] = scanner.nextLine();
        }

        // Return the filled array of fruit names.
        return frutas;
    }

    /**
     * Displays the fruits stored in the given array on the console.
     *
     * @param frutas a String array that contains the fruit names to display.
     */
    public static void mostrarArrayFrutas(String[] frutas) {
        // Print a message before listing the fruits.
        System.out.println("\nThe fruits you entered are:");

        // Loop through the entire array and print each fruit.
        for (int i = 0; i < frutas.length; i++) {
            // Print the fruit number (starting from 1) and its name.
            System.out.println((i + 1) + ". " + frutas[i]);
        }
    }

    /**
     * The main method — entry point of the program.
     * This is where the program starts running.
     */
    public static void main(String[] args) {
        // Create a Scanner object to read input from the console.
        Scanner sc = new Scanner(System.in);

        // Call crearArrayFrutas to fill the array with user input.
        String[] frutas = crearArrayFrutas(sc);

        // Call mostrarArrayFrutas to print the list of fruits.
        mostrarArrayFrutas(frutas);

        // Close the Scanner to free system resources.
        sc.close();
    }
}


