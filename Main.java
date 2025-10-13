public class Main {
    public static void main(String[] args) { // main method // Static means it belongs to class not object // String[] args measn take an array of string as input

        // ================================
        // EXERCISE 1: Overridden toString
        // ================================
        // 1. Create a VideoGame v1 with title "Minecraft" and platform "PC".
        // 2. Print v1 directly using System.out.println(v1).
        VideoGame v1 = new VideoGame("Minecraft", "PC"); // v1 Variable of videogame class , new create a new object
        System.out.println(v1);


        // ================================
        // EXERCISE 2: Default toString
        // ================================
        // 1. Create a Book l1 with title "Don Quixote" and author "Cervantes".
        // 2. Print l1 directly using System.out.println(l1).
        Book l1 = new Book("Don Quixote", "Cervantes");
        System.out.println(l1);


        // ================================
        // EXERCISE 3: Overridden equals
        // ================================
        // 1. Create two VideoGame objects with the same data: "Minecraft", "PC".
        // 2. Compare them using == and equals().
        // 3. Print the results.
        VideoGame v2 = new VideoGame("Minecraft", "PC");
        VideoGame v3 = new VideoGame("Minecraft", "PC");

        System.out.println("v2 == v3 → " + (v2 == v3));
        System.out.println("v2.equals(v3) → " + v2.equals(v3));


        // ================================
        // EXERCISE 4: Default equals
        // ================================
        // 1. Create two Book objects with the same data: "Don Quixote", "Cervantes".
        // 2. Compare them using == and equals().
        // 3. Print the results.
        Book l2 = new Book("Don Quixote", "Cervantes");
        Book l3 = new Book("Don Quixote", "Cervantes");

        System.out.println("l2 == l3 → " + (l2 == l3));
        System.out.println("l2.equals(l3) → " + l2.equals(l3));
    }
}


class VideoGame {
    private String title;
    private String platform;

    public VideoGame(String title, String platform) {
        this.title = title;
        this.platform = platform;
    }

    // Override toString to show readable text instead of memory reference
    @Override
    public String toString() {
        return "VideoGame: " + title + " (" + platform + ")";
    }

    // Override equals to compare by content (title + platform)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof VideoGame)) return false;
        VideoGame other = (VideoGame) obj;
        return this.title.equals(other.title) && this.platform.equals(other.platform);
    }
}

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

}


