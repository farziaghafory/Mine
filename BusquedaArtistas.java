 
public class BusquedaArtistas { 
    // MAIN CLASS (the whole program)
 
/**
* Inner CLASS representing an artist (each artist has a name and followers)
*/
static class Artista { // CLASS (blueprint to create artist objects)
private final String nombre; // VARIABLE (field / attribute) - stores artist's name
private final int seguidoresMiles; // VARIABLE (field / attribute) - stores followers in thousands
 
// CONSTRUCTOR (used to create a new artist object)
public Artista(String nombre, int seguidoresMiles) {
this.nombre = nombre; // 'this.nombre' refers to the object's own variable
this.seguidoresMiles = seguidoresMiles;
}
 
// METHOD (returns the artist's name)
public String getNombre() {
return nombre;
}
 
// METHOD (returns the artist's follower count in thousands)
public int getSeguidoresMiles() {
return seguidoresMiles;
}
 
// METHOD (converts the object to readable text)
@Override
public String toString() {
return String.format("%s (%,dK seguidores)", nombre, seguidoresMiles);
}
}
 
// ------------------------------------------------------------
// STATIC METHODS (these work with arrays of Artista objects)
// ------------------------------------------------------------
 
/**
* METHOD that finds the index of the first artist with the given name.
*/
public static int indiceDe(Artista[] cartel, String nombreBuscado) {
// 'cartel' is a VARIABLE (array of Artista objects)
// 'nombreBuscado' is a VARIABLE (the name to search for)
 
// Loop through the array
for (int i = 0; i < cartel.length; i++) { // 'i' is a VARIABLE loop counter
// Compare artist names ignoring uppercase/lowercase
if (cartel[i].getNombre().equalsIgnoreCase(nombreBuscado)) {
// If found, return the index number
return i;
}
}
// If not found, return -1
return -1;
}
 
/**
* METHOD that checks if an artist exists in the array.
*/
public static boolean existe(Artista[] cartel, String nombreBuscado) {
// Uses indiceDe() to check if the artist exists
return indiceDe(cartel, nombreBuscado) != -1; // exclamacion
}
 
/**
* METHOD that returns ALL the indices where an artist with the same name exists.
*/
public static int[] indicesDeTodos(Artista[] cartel, String nombreBuscado) {
int count = 0; // VARIABLE (counts how many matches there are)
 
// First loop: count how many matches
for (int i = 0; i < cartel.length; i++) {
if (cartel[i].getNombre().equalsIgnoreCase(nombreBuscado)) {
count++;
}
}
 
// Create an int array to store all the matching indices
int[] indices = new int[count]; // VARIABLE (array of integers)
int j = 0; // VARIABLE (used to fill 'indices' array)
 
// Second loop: store the indices
for (int i = 0; i < cartel.length; i++) {
if (cartel[i].getNombre().equalsIgnoreCase(nombreBuscado)) {
indices[j]  = i;
j++; //counter to fill the array
}
}
 
return indices; // Return the array with indices
}
 
/**
* METHOD that finds artists whose names start with a given letter.
*/
public static int[] indicesPorInicial(Artista[] cartel, char inicial) {
char inicialLower = Character.toLowerCase(inicial); // VARIABLE (lowercase version of input letter)
int count = 0; // VARIABLE (counts matches)
 
// Count matches
for (int i = 0; i < cartel.length; i++) {
char firstLetter = Character.toLowerCase(cartel[i].getNombre().charAt(0)); // VARIABLE
if (firstLetter == inicialLower) {
count++;
}
}
 
// Create result array
int[] indices = new int[count]; // VARIABLE (array)
int j = 0; // VARIABLE (to fill array)
 
// Fill with matching indices
for (int i = 0; i < cartel.length; i++) {
char firstLetter = Character.toLowerCase(cartel[i].getNombre().charAt(0));
if (firstLetter == inicialLower) {
indices[j] = i;
j++;
}
}
 
return indices;
}
 
/**
* METHOD that finds artists whose name starts with a letter AND whose followers are within a range.
*/
public static int[] indicesPorInicialYSeguidores(Artista[] cartel, char inicial,
int minSeguidoresMiles, int maxSeguidoresMiles) {
char inicialLower = Character.toLowerCase(inicial); // VARIABLE
int count = 0; // VARIABLE (counter)
 
// First pass: count how many match both conditions
for (int i = 0; i < cartel.length; i++) {
char firstLetter = Character.toLowerCase(cartel[i].getNombre().charAt(0));
int seguidores = cartel[i].getSeguidoresMiles(); // VARIABLE (followers)
if (firstLetter == inicialLower &&
seguidores >= minSeguidoresMiles && seguidores <= maxSeguidoresMiles) {
count++;
}
}
 
// Create array to store indices
int[] indices = new int[count]; // VARIABLE
int j = 0; // VARIABLE
 
// Second pass: store indices
for (int i = 0; i < cartel.length; i++) {
char firstLetter = Character.toLowerCase(cartel[i].getNombre().charAt(0));
int seguidores = cartel[i].getSeguidoresMiles();
if (firstLetter == inicialLower &&
seguidores >= minSeguidoresMiles && seguidores <= maxSeguidoresMiles) {
indices[j] = i;
j++;
}
}
 
return indices;
}
 
/**
* METHOD that prints the artists using their indices.
*/
public static void mostrarArtistas(Artista[] cartel, int[] indices) {
for (int idx : indices) { // 'idx' is a VARIABLE (each index from indices array)
System.out.println(" - [" + idx + "] " + cartel[idx]); // prints artist info
}
}
 
// ------------------------------------------------------------
// MAIN METHOD (Program starts here)
// ------------------------------------------------------------
 
public static void main(String[] args) {
// Create an ARRAY of Artista OBJECTS called 'cartel'
Artista[] cartel = {
new Artista("Aitana", 1200), // OBJECT (of class Artista)
new Artista("Quevedo", 2500), // OBJECT
new Artista("Bad Gyal", 900), // OBJECT
new Artista("Rosalía", 3100), // OBJECT
new Artista("Bizarrap", 5400), // OBJECT
new Artista("Lola Índigo", 850), // OBJECT
new Artista("Rels B", 2000), // OBJECT
new Artista("Saiko", 1500), // OBJECT
new Artista("Feid", 4200), // OBJECT
new Artista("Karol G", 6800), // OBJECT
new Artista("Rauw Alejandro", 3600), // OBJECT
new Artista("Morad", 2700) // OBJECT
};
 
// CONSTANT VARIABLES (used for testing)
final String BUSCAR_UNO = "Rosalía"; // name to find
final String BUSCAR_TODOS = "Rels B"; // name to find all matches
final char INICIAL = 'R'; // first letter to search by
final char INICIAL2 = 'R'; // used for the follower filter test
final int MIN = 2000; // minimum followers (thousands)
final int MAX = 4000; // maximum followers (thousands)
 
System.out.println("=== Demo rápida (sin Scanner) ===");
 
// 1) Find first match by name
int pos = indiceDe(cartel, BUSCAR_UNO); // VARIABLE 'pos' stores index result
if (pos >= 0) {
System.out.println("✔ " + BUSCAR_UNO + " actúa. Índice: " + pos);
System.out.println(" Detalles: " + cartel[pos]);
} else {
System.out.println("✘ " + BUSCAR_UNO + " no actúa en el festival.");
}
 
// 2) Find all artists with the same name
int[] todos = indicesDeTodos(cartel, BUSCAR_TODOS); // VARIABLE 'todos' is array of indices
System.out.println("\nCoincidencias de \"" + BUSCAR_TODOS + "\": " + todos.length);
if (todos.length > 0) mostrarArtistas(cartel, todos);
 
// 3) Find artists by first letter
int[] porInicial = indicesPorInicial(cartel, INICIAL);
System.out.println("\nArtistas que empiezan por '" + Character.toUpperCase(INICIAL) + "': " + porInicial.length);
if (porInicial.length > 0) mostrarArtistas(cartel, porInicial);
 
// 4) Find artists by letter + follower range
int[] filtrados = indicesPorInicialYSeguidores(cartel, INICIAL2, MIN, MAX);
System.out.println("\nArtistas que empiezan por '" + Character.toUpperCase(INICIAL2)
+ "' y tienen entre " + MIN + "K y " + MAX + "K seguidores:");
if (filtrados.length > 0) mostrarArtistas(cartel, filtrados);
else System.out.println(" (ninguno)");
}
}