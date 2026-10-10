package snippets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * ============================================================================
 * S16  THREADS – Grundlagen (Konsole, ohne GUI)
 * ============================================================================
 * Inhalt:
 *   1) Thread erzeugen: extends Thread / implements Runnable / Lambda; start() vs run()
 *   2) join(), sleep(), interrupt(), Daemon, Zustände
 *   3) Race Condition: unsicherer Zähler vs. synchronized vs. AtomicInteger
 *   4) synchronized-Block auf gemeinsamem Objekt (Monitor)
 *   5) Erzeuger/Verbraucher mit wait()/notifyAll()  (Ü27 "Synchronisation", Folien S. 31-37)
 *   6) Thread sauber beenden: volatile-Flag + interrupt()
 *   7) Executor-Framework: Thread-Pool, Callable, Future (Folien S. 42-43)
 *   8) Listen, die von mehreren Threads benutzt werden
 * Threads mit GUI -> S17.  Mehrere Fenster aus Threads updaten -> S18.
 *
 * Vorkommen: jBay ("jeweils gesteuert durch einen Java-Thread, sekündlich die Uhrzeit
 *   anzeigen"), SpeedyQuiz-Lösung (Countdown-Thread), Ü27 Ampel/Tanzende Schrift/
 *   Suchmaschine/Synchronisation. Threads sind laut 35_ZumProgrammentwurf PE-relevant.
 * Folien: 27_Threads
 *
 * Merke (auch für den Theorieteil!):
 *   - start() startet einen NEUEN Thread, der run() ausführt. run() direkt aufrufen
 *     läuft im AKTUELLEN Thread – nichts ist parallel.
 *   - Ein Thread-Objekt kann nur EINMAL gestartet werden (sonst IllegalThreadStateException).
 *   - sleep/join/wait werfen InterruptedException (checked) -> try/catch nötig.
 *   - wait()/notify() nur innerhalb von synchronized (sonst IllegalMonitorStateException).
 *   - wait() immer in einer while-Schleife prüfen, nicht mit if (Folie nutzt if – bei
 *     mehreren Erzeugern/Verbrauchern ist das ein Fehler).
 *   - stop()/suspend()/resume() sind deprecated -> nicht benutzen.
 *   - Reihenfolge der Ausgaben paralleler Threads ist NICHT festgelegt.
 */
public class S16_Threads {

    // =========================================================================
    // 1) Drei Arten, einen Thread zu erzeugen
    // =========================================================================

    /** (a) Unterklasse von Thread: run() überschreiben. */
    static class ZaehlThread extends Thread {

        ZaehlThread(String name) {
            super(name);                           // Thread-Name (getName())
        }

        @Override
        public void run() {
            for (int i = 1; i <= 3; i++) {
                System.out.println("  " + getName() + ": " + i);
                try {
                    Thread.sleep(50);              // 50 ms schlafen
                } catch (InterruptedException e) {
                    return;                        // unterbrochen -> beenden
                }
            }
        }
    }

    /** (b) Runnable implementieren (besser: Klasse kann noch von etwas anderem erben). */
    static class ZaehlAufgabe implements Runnable {

        private final String name;

        ZaehlAufgabe(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 3; i++) {
                System.out.println("  " + name + " (in " + Thread.currentThread().getName() + "): " + i);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }

    // =========================================================================
    // 3) Gemeinsamer Zähler: unsicher / synchronized / atomar
    // =========================================================================
    static class UnsichererZaehler {

        private int c = 0;

        void inc() {
            c++;                                   // NICHT atomar: lesen, +1, schreiben
        }

        int get() {
            return c;
        }
    }

    static class SichererZaehler {

        private int c = 0;

        synchronized void inc() {                  // Monitor von "this" -> immer nur ein Thread
            c++;
        }

        synchronized int get() {
            return c;
        }
    }

    // =========================================================================
    // 5) Erzeuger/Verbraucher-Puffer mit wait()/notifyAll()
    // =========================================================================
    static class Puffer {

        private final List<Integer> daten = new ArrayList<>();
        private final int kapazitaet;

        Puffer(int kapazitaet) {
            this.kapazitaet = kapazitaet;
        }

        public synchronized void put(int wert) throws InterruptedException {
            while (daten.size() >= kapazitaet) {   // WHILE, nicht if!
                wait();                            // gibt Monitor ab und wartet
            }
            daten.add(wert);
            notifyAll();                           // wartende Verbraucher wecken
        }

        public synchronized int get() throws InterruptedException {
            while (daten.isEmpty()) {
                wait();
            }
            int wert = daten.remove(0);
            notifyAll();                           // wartende Erzeuger wecken
            return wert;
        }
    }

    // =========================================================================
    // 6) Thread sauber beenden
    // =========================================================================
    static class Arbeiter implements Runnable {

        private volatile boolean laeuft = true;    // volatile: Änderung sofort für alle Threads sichtbar
        private int schritte = 0;

        public void stoppe() {
            laeuft = false;
        }

        @Override
        public void run() {
            while (laeuft) {
                schritte++;
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();   // Status wiederherstellen
                    break;                                // und Schleife verlassen
                }
            }
            System.out.println("  Arbeiter beendet nach " + schritte + " Schritten");
        }
    }

    // =========================================================================
    // Demo
    // =========================================================================
    public static void main(String[] args) throws Exception {

        System.out.println("== 1) Threads erzeugen und starten");
        Thread t1 = new ZaehlThread("Thread-A");                     // (a)
        Thread t2 = new Thread(new ZaehlAufgabe("Runnable-B"));      // (b)
        Thread t3 = new Thread(() -> {                               // (c) Lambda (Java 8)
            for (int i = 1; i <= 3; i++) {
                System.out.println("  Lambda-C: " + i);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    return;
                }
            }
        });
        System.out.println("  Zustand vor start(): " + t1.getState());   // NEW
        t1.start();
        t2.start();
        t3.start();
        System.out.println("  main laeuft weiter, waehrend die Threads zaehlen ...");

        // 2) join: auf das Ende warten
        t1.join();
        t2.join();
        t3.join();
        System.out.println("  alle fertig, Zustand: " + t1.getState() + ", alive? " + t1.isAlive());   // TERMINATED

        System.out.println("\n== 3) Race Condition");
        UnsichererZaehler unsicher = new UnsichererZaehler();
        SichererZaehler sicher = new SichererZaehler();
        AtomicInteger atomar = new AtomicInteger();
        Runnable hochzaehlen = () -> {
            for (int i = 0; i < 100_000; i++) {
                unsicher.inc();
                sicher.inc();
                atomar.incrementAndGet();
            }
        };
        Thread a = new Thread(hochzaehlen);
        Thread b = new Thread(hochzaehlen);
        a.start();
        b.start();
        a.join();
        b.join();
        System.out.println("  erwartet 200000 | unsicher: " + unsicher.get()
                + " (meist weniger!) | synchronized: " + sicher.get() + " | AtomicInteger: " + atomar.get());

        System.out.println("\n== 4) synchronized-Block auf gemeinsamer Liste");
        List<String> gemeinsam = new ArrayList<>();
        Object lock = gemeinsam;                    // Sperr-Objekt (Monitor)
        Thread s1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                synchronized (lock) {               // nur dieser Block ist gesperrt
                    gemeinsam.add("x");
                }
            }
        });
        Thread s2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                synchronized (lock) {
                    gemeinsam.add("y");
                }
            }
        });
        s1.start();
        s2.start();
        s1.join();
        s2.join();
        System.out.println("  Groesse: " + gemeinsam.size() + " (2000 erwartet)");

        System.out.println("\n== 5) Erzeuger/Verbraucher");
        Puffer puffer = new Puffer(2);
        Thread erzeuger = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    puffer.put(i);
                    System.out.println("  put " + i);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        Thread verbraucher = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    Thread.sleep(30);               // Verbraucher ist langsamer
                    System.out.println("  get " + puffer.get());
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        erzeuger.start();
        verbraucher.start();
        erzeuger.join();
        verbraucher.join();

        System.out.println("\n== 6) Thread beenden");
        Arbeiter arbeiter = new Arbeiter();
        Thread at = new Thread(arbeiter);
        at.start();
        Thread.sleep(150);
        arbeiter.stoppe();                          // Variante 1: Flag
        at.join();
        Thread schlaefer = new Thread(() -> {
            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                System.out.println("  Schlaefer wurde per interrupt() geweckt");
            }
        });
        schlaefer.start();
        schlaefer.interrupt();                      // Variante 2: interrupt (beendet sleep/wait sofort)
        schlaefer.join();
        // Daemon-Thread: hält das Programm nicht am Leben (z. B. Uhr-Thread)
        Thread daemon = new Thread(() -> { /* Endlosschleife ... */ });
        daemon.setDaemon(true);                     // VOR start() setzen

        System.out.println("\n== 7) Executor-Framework (Thread-Pool)");
        ExecutorService pool = Executors.newFixedThreadPool(3);
        List<Future<Integer>> ergebnisse = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            final int n = i;
            Callable<Integer> aufgabe = () -> {     // Callable: wie Runnable, aber mit Rückgabewert
                Thread.sleep(20);
                return n * n;
            };
            ergebnisse.add(pool.submit(aufgabe));
        }
        int summe = 0;
        for (Future<Integer> f : ergebnisse) {
            summe += f.get();                       // wartet, bis das Ergebnis da ist
        }
        pool.execute(() -> System.out.println("  Runnable im Pool: " + Thread.currentThread().getName()));
        pool.shutdown();                            // keine neuen Aufgaben mehr annehmen
        pool.awaitTermination(5, TimeUnit.SECONDS); // auf Ende warten
        System.out.println("  Summe der Quadrate 1..5 = " + summe);

        System.out.println("\n== 8) Listen fuer mehrere Threads");
        List<String> syncListe = Collections.synchronizedList(new ArrayList<>());   // jede Methode synchronized
        List<String> cowListe = new CopyOnWriteArrayList<>();   // ideal für Listener-Listen (viel lesen, wenig ändern)
        syncListe.add("a");
        cowListe.add("b");
        for (String s : cowListe) {                 // Iterieren ohne ConcurrentModificationException
            cowListe.add(s + "!");                  // ändert eine Kopie, Schleife läuft über den alten Stand
        }
        System.out.println("  " + syncListe + " " + cowListe);
    }
}
