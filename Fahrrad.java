
import java.nio.file.*;
import java.util.*;

public class Fahrrad {
    record Rad(String nr, String typ, String farbe, String groesse, String foto, String status, String notiz) {}

    public static void main(String[] args) throws Exception {
        List<Rad> raeder = Files.readAllLines(Path.of("Fahrraeder_10.csv")).stream()
                .skip(1)                                            // Kopfzeile
                .map(zeile -> zeile.split(";", -1))                 // Spalten trennen
                .map(f -> new Rad(f[0], f[1], f[2], f[3], f[4], f[5], f[6]))
                .toList();

        raeder.forEach(System.out::println);
    }
}