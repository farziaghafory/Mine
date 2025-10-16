import java.util.Locale;        // Import Locale so we can set default locale for numeric input/output formatting.
import java.util.Scanner;       // Import Scanner to read user input from the console.

/**
 * CarritoSuma: demonstrates operations with arrays (summing product prices).
 * The class contains a nested Producto type, a method to compute totals,
 * and a main method demonstrating usage (fixed or user input).
 */
public class CarritoSuma {

    /**
     * Represents a product in the catalog.
     * We use a static nested class so it is logically grouped inside CarritoSuma
     * but can be instantiated without an outer instance.
     */
    static class Producto {
        private final String nombre;   // Field to store product name (final: value does not change after construction).
        private final double precio;   // Field to store product price (final: immutable once set).

        /**
         * Constructor: initializes the product name and price.
         * We pass these values when we create a new Producto object.
         *
         * @param nombre product name
         * @param precio product price in euros (should be >= 0)
         */
        public Producto(String nombre, double precio) {
            this.nombre = nombre;    // 'this.nombre' refers to the field; assign incoming parameter 'nombre'.
            this.precio = precio;    // store the price in the field.
        }

        /** Getter for the product name: returns the name so other methods can read it. */
        public String getNombre() { return nombre; }

        /** Getter for the product price: returns the price so we can sum or display it. */
        public double getPrecio() { return precio; }

        /**
         * toString override: when we print a Producto, format it like "Name - 12.34 €".
         * This helps debug and display product info easily.
         */
        @Override
        public String toString() {
            return String.format("%s - %.2f €", nombre, precio);
        }
    }

    /**
     * Sums the prices of all products in the cart.
     *
     * @param carrito array of Producto (assumed not null)
     * @return total sum in euros
     */
    public static double totalCarrito(Producto[] carrito) {
        // We initialize an accumulator variable to hold the running total.
        // double is used because prices have decimal cents.
        double total = 0.0;

        // Use a for-each loop to iterate over every Producto in the array.
        // for-each is concise and avoids index mistakes when we only need elements.
        for (Producto p : carrito) {
            // For each product, get its price and add to total.
            // p.getPrecio() reads the product price (encapsulation via getter).
            total += p.getPrecio();
        }

        // After the loop, total holds the sum of all product prices; return it.
        return total;
    }

    public static void main(String[] args) {
        // Set default locale to US so Scanner expects '.' for decimals and printf uses '.' as decimal separator.
        // Why: on some systems Locale may use comma (",") for decimals; setting Locale.US avoids input/formatting mismatch.
        Locale.setDefault(Locale.US);

        // Create a Scanner to read user input from standard input (console).
        // We keep a single Scanner instance and close it at the end to free resources.
        Scanner sc = new Scanner(System.in);

        /*
         * === OPTION A: Fixed / predefined cart ===
         * This is simple to test: we create a Producto array with known items.
         * Use this when you want a quick run without entering data each time.
         */
        Producto[] carrito = {
            new Producto("Keyboard", 24.99),    // Create a product with name and price
            new Producto("Mouse", 15.50),       // Each new Producto(...) calls the constructor above
            new Producto("Headphones", 39.90)
        };

        /*
         * === OPTION B: User input (interactive) ===
         * The block below (commented out) shows how to read N products from the user.
         * Uncomment the block if you prefer typing the products at runtime.
         *
         * Why structure it this way:
         * - sc.nextInt() reads an integer count.
         * - sc.nextLine() after nextInt() consumes the remainder newline so the next nextLine() works.
         * - We loop, prompt for name and price, and build each Producto into the array.
         */
        /*
        System.out.print("How many products? ");
        int n = sc.nextInt();      // read number of products
        sc.nextLine();             // consume the leftover newline from nextInt()

        Producto[] carrito = new Producto[n];  // create an array of length n

        for (int i = 0; i < n; i++) {
            System.out.printf("Product %d name: ", i + 1);
            String name = sc.nextLine();      // read the product name (may contain spaces)

            System.out.printf("Product %d price (€): ", i + 1);
            double price = sc.nextDouble();   // read the price as a double
            sc.nextLine();                    // consume the newline before next iteration

            carrito[i] = new Producto(name, price); // store new product in array
        }
        */

        // Compute the total price by calling our helper method totalCarrito.
        // Encapsulation: main() doesn't iterate or access internals; it delegates summing to totalCarrito.
        double total = totalCarrito(carrito);

        // Print the total using printf to format to 2 decimal places (monetary format).
        // "%.2f" prints the value with two digits after the decimal point.
        System.out.printf("Total: %.2f €%n", total);

        // === EXTRA: Ask the user for a discount percentage and apply it ===
        // We demonstrate a common operation: apply a percentage discount to the total.
        System.out.print("Enter discount percentage (%): ");
        double discount = sc.nextDouble();   // read discount as a percentage (e.g., 10 for 10%)

        // Compute discounted total: subtract discount percent of the total from total.
        // Formula: totalWithDiscount = total - (total * discount / 100)
        // Rationale: (discount / 100) converts percent to fraction; multiply by total to get amount discounted.
        double totalWithDiscount = total - (total * discount / 100.0);

        // Print the discounted total also formatted to 2 decimal places. Show the discount value too.
        System.out.printf("Total with %.2f%% discount: %.2f €%n", discount, totalWithDiscount);

        // Always close the Scanner at the end to release the underlying input stream resources.
        sc.close();
    }
}
