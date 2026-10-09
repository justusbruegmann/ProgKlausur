package snippets;

import java.util.ArrayList;
import java.util.List;

/*
 * ============================================================================
 * S02  INTERFACE, ABSTRAKTE KLASSE, VERERBUNG
 * ============================================================================
 * Typische Aufgabe: "Definieren Sie die Funktionalität über das Java-Interface X
 *   mit den folgenden Methoden: ..."  (meist Teilaufgabe a) oder b), schnelle Punkte!)
 * Vorkommen: SnatChatFrontend, GameClient (SpeedyQuiz), IRoom (CHORona),
 *   CoronaWarnClient, FakeTalk, ChatterGPT; Vererbung z. B. Bieter/Person
 * Folien: 21_Abstrakte_Klassen_Interfaces, 13_Vererbung
 *
 * KOPIEREN: Interface in eigene Datei, "public interface ..." davor.
 * Merke:
 *   - Interface-Methoden sind automatisch public abstract -> in der Klasse "public" schreiben!
 *   - Signatur EXAKT wie in der Aufgabe (Name, Parameter, Rückgabetyp) – wird getestet
 *   - @Override über jede implementierte Methode: der Compiler prüft dann die Signatur
 */

// ---- 1) Interface ------------------------------------------------------------
interface MessageReceiver {

    void receiveMessage(String text);

    String getAccountName();

    // seit Java 8 erlaubt (selten gefordert): Methode MIT Rumpf
    default void receiveSystemMessage(String text) {
        receiveMessage("[System] " + text);
    }
}

// ---- 2) Klasse implementiert Interface ---------------------------------------
class ConsoleReceiver implements MessageReceiver {

    private final String name;

    public ConsoleReceiver(String name) {
        this.name = name;
    }

    @Override
    public void receiveMessage(String text) {
        System.out.println(name + " empfaengt: " + text);
    }

    @Override
    public String getAccountName() {
        return name;
    }
}

// ---- 3) Abstrakte Klasse + Vererbung -----------------------------------------
abstract class Fahrzeug {

    private final String name;      // private -> Unterklassen nutzen getName()
    protected int position;         // protected -> Unterklassen dürfen direkt zugreifen

    protected Fahrzeug(String name) {
        this.name = name;
    }

    /** Abstrakte Methode: KEIN Rumpf, Unterklassen MÜSSEN sie implementieren. */
    public abstract int getSpeed();

    /** Normale Methode, die die abstrakte benutzt (Template-Prinzip). */
    public void fahre() {
        position += getSpeed();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + name + " @ " + position;
    }
}

class Auto extends Fahrzeug {

    private final int ps;

    public Auto(String name, int ps) {
        super(name);                // MUSS erste Anweisung im Konstruktor sein
        this.ps = ps;
    }

    @Override
    public int getSpeed() {
        return ps / 10;
    }

    @Override
    public String toString() {
        return super.toString() + " (" + ps + " PS)";   // Methode der Oberklasse mitbenutzen
    }
}

class Fahrrad extends Fahrzeug {

    public Fahrrad(String name) {
        super(name);
    }

    @Override
    public int getSpeed() {
        return 2;
    }
}

public class S02_InterfaceUndVererbung {

    public static void main(String[] args) {
        // Polymorphie: Variable vom Interface-Typ, Objekt einer implementierenden Klasse
        List<MessageReceiver> receivers = new ArrayList<>();
        receivers.add(new ConsoleReceiver("Anna"));
        receivers.add(new ConsoleReceiver("Ben"));
        // anonyme Klasse direkt als Implementierung
        receivers.add(new MessageReceiver() {
            @Override
            public void receiveMessage(String text) {
                System.out.println("(anonym) " + text);
            }

            @Override
            public String getAccountName() {
                return "anonym";
            }
        });
        for (MessageReceiver r : receivers) {
            r.receiveMessage("Hallo " + r.getAccountName());
        }
        receivers.get(0).receiveSystemMessage("Willkommen");

        // abstrakte Klasse: new Fahrzeug(...) geht NICHT, nur Unterklassen
        List<Fahrzeug> rennen = new ArrayList<>();
        rennen.add(new Auto("Golf", 110));
        rennen.add(new Fahrrad("BMX"));
        for (int runde = 0; runde < 3; runde++) {
            for (Fahrzeug f : rennen) {
                f.fahre();
            }
        }
        for (Fahrzeug f : rennen) {
            System.out.println(f);
        }

        // instanceof + Cast, wenn man Unterklassen-Methoden braucht
        for (Fahrzeug f : rennen) {
            if (f instanceof Auto) {
                Auto a = (Auto) f;
                System.out.println(a.getName() + " ist ein Auto mit Speed " + a.getSpeed());
            }
        }
    }
}
