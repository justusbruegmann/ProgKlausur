package snippets;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

/*
 * ============================================================================
 * S12  COLLECTIONS: List, Map, Set, Sortieren, Iterator, Streams
 * ============================================================================
 * Vorkommen: praktisch jedes PE (List<Auktion> getAuktionen(), Liste der Fragen,
 *   Verbindungen, Zitate ...), Ü25 Bücherei/Tankstellen/Lotto
 * Folien: 25_Datenstrukturen, 33_Java8 (Streams)
 *
 * Merke:
 *   - Nur Objekte: List<Integer>, nicht List<int>
 *   - list.remove(int index) vs. list.remove(Object o)  -> bei List<Integer> aufpassen!
 *       list.remove(Integer.valueOf(5)) entfernt die ZAHL 5
 *   - Beim Durchlaufen NICHT mit list.remove(...) löschen -> Iterator oder removeIf
 *   - HashMap/HashSet mit eigenen Klassen als Schlüssel: equals + hashCode überschreiben
 */
public class S12_Collections {

    static class Spieler {

        final String name;
        final String team;
        final int punkte;

        Spieler(String name, String team, int punkte) {
            this.name = name;
            this.team = team;
            this.punkte = punkte;
        }

        String getName() {
            return name;
        }

        String getTeam() {
            return team;
        }

        int getPunkte() {
            return punkte;
        }

        @Override
        public String toString() {
            return name + "(" + team + "," + punkte + ")";
        }
    }

    public static void main(String[] args) {
        // =====================================================================
        // LIST
        // =====================================================================
        List<Spieler> spieler = new ArrayList<>();       // LinkedList geht genauso
        spieler.add(new Spieler("Anna", "Rot", 12));
        spieler.add(new Spieler("Ben", "Blau", 7));
        spieler.add(new Spieler("Cem", "Rot", 20));
        spieler.add(new Spieler("Dana", "Blau", 12));
        spieler.add(0, new Spieler("Emil", "Gruen", 3)); // an Position einfügen

        System.out.println("Anzahl: " + spieler.size() + ", erster: " + spieler.get(0)
                + ", letzter: " + spieler.get(spieler.size() - 1));
        for (int i = 0; i < spieler.size(); i++) {        // mit Index
            System.out.print(i + ":" + spieler.get(i).getName() + " ");
        }
        System.out.println();
        for (Spieler s : spieler) {                        // for-each
            System.out.print(s.getName() + " ");
        }
        System.out.println();

        // =====================================================================
        // SORTIEREN
        // =====================================================================
        // Java 8: Comparator.comparing ... (absteigend: .reversed())
        spieler.sort(Comparator.comparing(Spieler::getPunkte).reversed()
                .thenComparing(Spieler::getName));
        System.out.println("nach Punkten absteigend, dann Name: " + spieler);

        // klassisch (geht auch in jeder Java-Version): anonymer Comparator
        Collections.sort(spieler, new Comparator<Spieler>() {
            @Override
            public int compare(Spieler a, Spieler b) {
                return a.getName().compareTo(b.getName());   // Strings: compareTo; ints: Integer.compare(a, b)
            }
        });
        System.out.println("nach Name: " + spieler);

        Spieler bester = Collections.max(spieler, Comparator.comparingInt(Spieler::getPunkte));
        System.out.println("Bester: " + bester);

        // Top 3 (nach dem Sortieren): subList(von inkl., bis exkl.)
        spieler.sort(Comparator.comparingInt(Spieler::getPunkte).reversed());
        List<Spieler> top3 = new ArrayList<>(spieler.subList(0, Math.min(3, spieler.size())));
        System.out.println("Top 3: " + top3);

        // Zufällige Reihenfolge (z. B. Fragen mischen)
        List<Spieler> gemischt = new ArrayList<>(spieler);
        Collections.shuffle(gemischt);

        // =====================================================================
        // LÖSCHEN beim Durchlaufen
        // =====================================================================
        List<Spieler> kopie = new ArrayList<>(spieler);
        Iterator<Spieler> it = kopie.iterator();
        while (it.hasNext()) {
            if (it.next().getPunkte() < 10) {
                it.remove();                               // sicher
            }
        }
        // Java 8 kürzer:
        kopie.removeIf(s -> s.getTeam().equals("Gruen"));
        System.out.println("ohne <10 Punkte: " + kopie);

        // List<Integer>: remove(index) vs remove(Objekt)
        List<Integer> zahlen = new ArrayList<>(Arrays.asList(5, 1, 7));
        zahlen.remove(Integer.valueOf(7));                 // entfernt die Zahl 7
        zahlen.remove(0);                                  // entfernt Index 0 (die 5)
        System.out.println("zahlen: " + zahlen + ", enthaelt 1? " + zahlen.contains(1));

        // Liste -> Array (z. B. für JComboBox)
        Spieler[] alsArray = spieler.toArray(new Spieler[0]);
        System.out.println("Array-Laenge: " + alsArray.length);

        // =====================================================================
        // MAP
        // =====================================================================
        Map<String, Spieler> nachName = new HashMap<>();   // TreeMap = nach Schlüssel sortiert
        for (Spieler s : spieler) {
            nachName.put(s.getName(), s);
        }
        System.out.println("Ben -> " + nachName.get("Ben") + ", Zoe -> " + nachName.get("Zoe")
                + ", enthaelt Anna? " + nachName.containsKey("Anna"));

        // Zählen pro Schlüssel
        Map<String, Integer> punkteProTeam = new TreeMap<>();
        for (Spieler s : spieler) {
            punkteProTeam.put(s.getTeam(), punkteProTeam.getOrDefault(s.getTeam(), 0) + s.getPunkte());
            // Java 8 alternativ: punkteProTeam.merge(s.getTeam(), s.getPunkte(), Integer::sum);
        }
        // Durchlaufen: entrySet
        for (Map.Entry<String, Integer> e : punkteProTeam.entrySet()) {
            System.out.println("Team " + e.getKey() + ": " + e.getValue() + " Punkte");
        }

        // Gruppieren: Map<Schlüssel, Liste>
        Map<String, List<Spieler>> proTeam = new LinkedHashMap<>();   // behält Einfügereihenfolge
        for (Spieler s : spieler) {
            proTeam.computeIfAbsent(s.getTeam(), k -> new ArrayList<>()).add(s);
        }
        System.out.println("Gruppiert: " + proTeam);

        // =====================================================================
        // SET (keine Duplikate)
        // =====================================================================
        Set<String> teams = new HashSet<>();
        for (Spieler s : spieler) {
            teams.add(s.getTeam());                        // Duplikate werden ignoriert
        }
        Set<Integer> sortiert = new TreeSet<>(Arrays.asList(5, 3, 9, 3));
        System.out.println("Teams: " + teams + ", TreeSet: " + sortiert);

        // =====================================================================
        // QUEUE (FIFO) / STACK (LIFO)
        // =====================================================================
        Deque<String> warteschlange = new ArrayDeque<>();
        warteschlange.offer("Frage 1");                   // hinten anstellen
        warteschlange.offer("Frage 2");
        System.out.println("naechste: " + warteschlange.poll() + ", danach: " + warteschlange.peek());
        Deque<String> stapel = new ArrayDeque<>();
        stapel.push("unten");
        stapel.push("oben");
        System.out.println("pop: " + stapel.pop());

        // =====================================================================
        // STREAMS (Java 8, erlaubt aber nicht gefordert)
        // =====================================================================
        List<String> namenRot = spieler.stream()
                .filter(s -> s.getTeam().equals("Rot"))
                .map(Spieler::getName)
                .sorted()
                .collect(Collectors.toList());
        int summe = spieler.stream().mapToInt(Spieler::getPunkte).sum();
        double schnitt = spieler.stream().mapToInt(Spieler::getPunkte).average().orElse(0);
        String alle = spieler.stream().map(Spieler::getName).collect(Collectors.joining(", "));
        Map<String, Long> anzahlProTeam = spieler.stream()
                .collect(Collectors.groupingBy(Spieler::getTeam, Collectors.counting()));
        System.out.println(namenRot + " | Summe " + summe + " | Schnitt " + schnitt + " | " + alle
                + " | " + anzahlProTeam);

        // Arrays-Helfer
        int[] arr = { 4, 2, 9 };
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr) + " " + new LinkedList<>(Arrays.asList("a", "b")));
    }
}
