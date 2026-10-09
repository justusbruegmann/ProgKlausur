---
tags: ["typ/thema", "thema/junit", "kategorie/werkzeuge", "semester/2"]
aliases: ["JUnit-Tests", "Folien 31"]
semester: 2
kategorie: "Werkzeuge"
folien: "[[Material/Folien/31_JUnit-jupiter.pdf]]"
seiten: 31
---

# 31 JUnit-Tests

← [[30 JSON mit GSON]] · [[Start|🏠 Start]] · [[32 Maven]] →

> [!abstract] Worum geht's?
> Testgetriebene Entwicklung und Unit-Tests mit JUnit 5 (Jupiter): Test-Annotationen, Lebenszyklus-Methoden (@BeforeEach usw.) und assert-Methoden am Beispiel Bankkonto.

**Semester:** Programmieren II · **Bereich:** #kategorie/werkzeuge · **Folien:** [[Material/Folien/31_JUnit-jupiter.pdf|31_JUnit-jupiter.pdf]] (31 Seiten)

## Gliederung der Folien
- [[Material/Folien/31_JUnit-jupiter.pdf#page=2|S. 2]] Testgetriebene Entwicklung
- [[Material/Folien/31_JUnit-jupiter.pdf#page=3|S. 3]] Warum Testgetriebene Entwicklung?
- [[Material/Folien/31_JUnit-jupiter.pdf#page=4|S. 4]] Iteratives Testen und Programmieren
- [[Material/Folien/31_JUnit-jupiter.pdf#page=5|S. 5]] Zyklus des Testens und Programmierens
- [[Material/Folien/31_JUnit-jupiter.pdf#page=6|S. 6]] Projektarchitektur
- [[Material/Folien/31_JUnit-jupiter.pdf#page=7|S. 7]] JUnit – Erster Test in Eclipse
- [[Material/Folien/31_JUnit-jupiter.pdf#page=12|S. 12]] JUnit – Erster Test in IntelliJ
- [[Material/Folien/31_JUnit-jupiter.pdf#page=17|S. 17]] Die Annotationen und ihre Bedeutung
- [[Material/Folien/31_JUnit-jupiter.pdf#page=18|S. 18]] Beispiel: Bankkonto
- [[Material/Folien/31_JUnit-jupiter.pdf#page=19|S. 19]] Beispiel Bankkonto: Methoden testen
- [[Material/Folien/31_JUnit-jupiter.pdf#page=20|S. 20]] Test vorbereiten
- [[Material/Folien/31_JUnit-jupiter.pdf#page=21|S. 21]] @BeforeAll, @AfterAll
- [[Material/Folien/31_JUnit-jupiter.pdf#page=22|S. 22]] @BeforeEach, @AfterEach
- [[Material/Folien/31_JUnit-jupiter.pdf#page=23|S. 23]] Die Tests (Beispiel getBalance())
- [[Material/Folien/31_JUnit-jupiter.pdf#page=24|S. 24]] Die Tests (Beispiel inpayment())
- [[Material/Folien/31_JUnit-jupiter.pdf#page=25|S. 25]] assert-Methoden („Behauptungen“)
- [[Material/Folien/31_JUnit-jupiter.pdf#page=26|S. 26]] Wir erinnern uns: Die Tests für inpayment()
- [[Material/Folien/31_JUnit-jupiter.pdf#page=27|S. 27]] Beispiel: Implementierung von inpayment()
- [[Material/Folien/31_JUnit-jupiter.pdf#page=30|S. 30]] Aufgabe
- [[Material/Folien/31_JUnit-jupiter.pdf#page=31|S. 31]] Literatur

## Begriffe in diesem Kapitel
- [[Annotation]] (S. [[Material/Folien/31_JUnit-jupiter.pdf#page=11|11]], [[Material/Folien/31_JUnit-jupiter.pdf#page=17|17]], [[Material/Folien/31_JUnit-jupiter.pdf#page=21|21]], [[Material/Folien/31_JUnit-jupiter.pdf#page=22|22]], [[Material/Folien/31_JUnit-jupiter.pdf#page=23|23]], [[Material/Folien/31_JUnit-jupiter.pdf#page=24|24]])
- [[JUnit]] (S. [[Material/Folien/31_JUnit-jupiter.pdf#page=7|7]], [[Material/Folien/31_JUnit-jupiter.pdf#page=8|8]], [[Material/Folien/31_JUnit-jupiter.pdf#page=9|9]], [[Material/Folien/31_JUnit-jupiter.pdf#page=10|10]], [[Material/Folien/31_JUnit-jupiter.pdf#page=11|11]], [[Material/Folien/31_JUnit-jupiter.pdf#page=12|12]])
- [[Testgetriebene Entwicklung]] (S. [[Material/Folien/31_JUnit-jupiter.pdf#page=2|2]], [[Material/Folien/31_JUnit-jupiter.pdf#page=3|3]])

## Kommt hier auch vor
[[Exception]] · [[Binärbaum]]

## Verwandte Themen
[[32 Maven]] · [[14 Exceptions]] · [[02 Entwicklungsumgebungen Eclipse und IntelliJ]]

## Folien ansehen
![[Material/Folien/31_JUnit-jupiter.pdf]]

## Folientext (durchsuchbar)
> [!quote]- Kompletter Folientext – aufklappen
> ```text
> ── Seite 1 ──
> Programmieren
> JUnit-Tests
>    Heusch --
>    Ratz --
> 
> Institut für Automation und angewandte Informatik
> 
> KIT – Die Forschungsuniversität in der Helmholtz-Gemeinschaft www.kit.edu
> 
> ── Seite 2 ──
> Testgetriebene Entwicklung
> 
>    … (auch testgesteuerte Programmierung, engl. test first
>    development oder test-driven development (TDD))
>    ist eine Methode, die häufig bei der agilen Entwicklung
>    von Computerprogrammen eingesetzt wird.
> 
>    Bei der testgetriebenen Entwicklung erstellt der
>    Programmierer Software-Tests konsequent vor den zu
>    testenden Komponenten.
> 
>    Die Testfälle werden auch als Grey-Box-Tests bezeichnet.
> 
> 2 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 3 ──
> Warum Testgetriebene Entwicklung?
> 
>    Verbesserung der Code-Qualität
>    Steigerung der Produktivität
>    Überprüfbarkeit des Erreichens von Zielen
>    Leichtere Wartbarkeit
> 
>    Quelle: http://dilbert.com/strips/comic/2007-11-26/
> 
> 3 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 4 ──
> Iteratives Testen und Programmieren
> 
>    Der Zyklus des Testens und Programmierens:
>    1.   Entwirf zunächst (nur) einen Test.
>    (Es ist noch kein zugehöriger Code vorhanden.)
>    2.   Schreibe gerade soviel Code, dass der Test zwar abläuft, jedoch
>    noch fehlschlägt.
>    3.   Schreibe gerade soviel Code, dass dieser Test durchläuft.
>    Dieser Prozess wird so lange wiederholt, bis dem
>    Programmierer keine weiteren Tests mehr einfallen, die
>    unter Umständen fehlschlagen könnten, bis der Code also
>    seine durch die Tests spezifizierten Anforderungen erfüllt.
>    Anschließend wird der Code in die einfachstmögliche Form
>    refaktorisiert.
> 
> 4 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 5 ──
> Zyklus des Testens und Programmierens
> 
>    Füge einen
>    Test hinzu
> 
>    Neuer Test   Refaktorisiere
>    schlägt fehl   den Code
> 
>    Schreibe   Alle Tests
>    etwas Code   laufen durch
> 
> 5 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 6 ──
> Projektarchitektur
> 
>    Bisher zumeist ein Verzeichnis für Quellcode („src“)
>    Test-Klassen sollten jedoch nicht im gleichen Quell-
>    Verzeichnis wie „normaler“ Code abgelegt werden
>    Software muss bei der Entwicklung getestet werden
>    Auslieferung compilierter Versionen aber ohne Test-Klassen
> 
>    ➔ Java-Projekt mit separaten Quellcode-Baum für Test-Klassen
>    ➔ Ordner wird üblicherweise „test“ genannt;
> 
>    (In MAVEN-Projekten:
>    src/test/java/ bzw.
>    src/test/resources/ )
> 
>    Hier die „normalen“ Klassen
> 
>    Hier alle „Test“-Klassen
> 
> 6 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 7 ──
> JUnit – Erster Test in Eclipse (1)
> 
>    Projekt anlegen
>    Quellcode-Baum für Test-Klassen erzeugen
> 
> 7 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 8 ──
> JUnit – Erster Test in Eclipse (2)
> 
>    In das Projekt einen „JUnit Test Case“ einfügen
> 
> 8 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 9 ──
> JUnit – Erster Test in Eclipse (3)
> 
>    Neuen Test   JUnit-Version wählen
>    (hier: JUnit 5)
>    anlegen
>    Quellcode-Baum
>    („test“ auswählen!)
> 
>    Package für Test-Klasse
> 
>    Name der Test-Klasse
> 
>    Zu erstellende
>    Hilfsmethoden
> 
> 9 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 10 ──
> JUnit – Erster Test in Eclipse (4)
> 
>    JUnit benötigt die entsprechenden Bibliotheken im Projekt-
>    Classpath
>    Eclipse frägt beim Erstellen der Test-Klasse, ob diese dem
>    Projekt hinzugefügt werden sollen:
> 
> 10 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 11 ──
> JUnit – Erster Test in Eclipse (5)
> 
>    Durch den Assistent erzeugtes Grundgerüst
> 
>    JUnit-Imports
> 
>    „Einfache Klasse“,
>    keine Vererbung
> 
>    Annotationen vor
>    Methodennamen
> 
>    Erste Test-Methode
> 
> 11 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 12 ──
> JUnit – Erster Test in IntelliJ (1)
> 
>    Projekt anlegen
>    Neues Verzeichnis für den Test-Quellcode anlegen
> 
> 12 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 13 ──
> JUnit – Erster Test in IntelliJ (2)
> 
>    Verzeichnis als Test-Quellcode-Verzeichnis registrieren
> 
> 13 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 14 ──
> JUnit – Erster Test in IntelliJ (3)
> 
>    Klasse für Unit-Tests erstellen
> 
> 14 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 15 ──
> JUnit – Erster Test in IntelliJ (4)
> 
>    Beim ersten Verwenden von Test-Code IntelliJ das Test-
>    Framework einbinden lassen
> 
> 15 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 16 ──
> JUnit – Erster Test in IntelliJ (5)
> 
>    Einbindung bestätigen
> 
>    Alternative Vorgehensweise(n) siehe:
>    https://www.jetbrains.com/help/idea/tdd-with-intellij-idea.html
> 
> 16 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 17 ──
> Die Annotationen und ihre Bedeutung
> Annotation Beschreibung
> @Test
>    Identifiziert eine Methode als Test-Methode.
> public void method()
> @DisplayName("Some text to name it") Alternativer Name für den Test (Statt Default = Methodenname).
>    Diese Methode wird vor jedem (einzelnen) Test ausgeführt. Sie wird
> @BeforeEach
>    verwendet, um die Testumgebung vorzubereiten, z.B. Eingabewerte zu lesen
> public void init()
>    oder Klassen zu initialisieren.
>    Diese Methode wird nach jedem (einzelnen) Test ausgeführt. Sie wird zum
> @AfterEach „Aufräumen“ verwendet, z.B. temporäre Daten zu löschen oder Defaultwerte
> public void tearDown() wiederherzustellen. Sie kann auch zum expliziten Freigeben von reserviertem
>    Speicher verwendet werden.
> 
>    Diese Methode wird (einmalig) vor dem Start der Tests ausgeführt. Sie wird
> @BeforeAll insb. für zeitaufwändige Aktivitäten verwendet, z.B. das Herstellen einer
> public static void initAll() Datenbankverbindung und das Lesen großer Datenmengen. Die mit
>    @BeforeAll annotieren Methoden müssen static sein!
> 
>    Diese Methode wird (einmalig) nach Beendigung aller Tests ausgeführt. Sie
> @AfterAll wird zum „allgemeinen Aufräumen“ verwendet, z.B. das Schließen einer
> public static void tearDownAll() Datenbankverbindung. Die mit @AfterAll annotieren Methoden müssen
>    static sein!
>    Die mit @Disabled annotierten (Test-)Methoden werden bei Tests ignoriert.
> @Disabled("Just to demonstrate") Dies könnte nötig sein, wenn nach einer Codeänderung dieser Test noch nicht
> public void method() adaptiert wurde, oder wenn ein Test aufgrund seiner langen Ausführungszeit
>    (temporär) ausgeschlossen werden soll.
> 
> 20 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 18 ──
> Beispiel: Bankkonto
> 
>    Es soll ein einfaches Bankkonto (Klasse Account)
>    erstellt werden.
>    Die Methoden der Klasse sollen mit Hilfe von JUnit-Test
>    überprüft werden.
>    Klasse zu Beginn der Tests:
>    public class Account {
>    private long balance; // Kontostand in Eurocent
> 
>    public Account(long initialBalance) {
>    this.balance = initialBalance;
>    }
> 
>    public void setBalance(long balance) { // zum Testen
>    this.balance = balance;
>    }
>    }
> 
> 21 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 19 ──
> Beispiel Bankkonto: Methoden testen
> 
>    Es soll eine Klasse Account mit den folgende Methoden
>    implementiert und getestet werden, ungültige Eingaben
>    sollen jeweils zu einer AccountException führen.
> 
>    public long getBalance()
> 
>    public void inpayment(long amount) throws AccountException
> 
>    // diese Methode wird Gegenstand einer Übung
>    public long outpayment(long amount) throws AccountException
> 
>    // diese Methode wird Gegenstand einer Übung
>    public boolean isBalancePositive()
> 
> 22 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 20 ──
> Test vorbereiten
> 
>    Grundgerüst:
> 
>    import <package-name-of-account>.Account;
>    import <package-name-of-account>.AccountException; // vorsorglich
> 
>    public class AccountTest {
> 
>    private static Account account; // soll getestet werden
>    private static final long INIT_BALANCE = 4711;
> 
>    public AccountTest(){
> 
>    }
>    }
> 
> 23 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 21 ──
> @BeforeAll, @AfterAll
> 
>    Für diesen einfachen Fall ist das nicht unbedingt nötig.
>    Hier wird nur ein neues Konto-Objekt erzeugt und eine Info
>    auf der Konsole ausgegeben.
>    /**
>    * (Einmalige) Initialisierung, vor allen Tests.
>    * Ein Konto-Objekt wird erzeugt.   Methodennamen
>    */   frei wählbar
>    @BeforeAll
>    public static void setUpAccount() {
>    System.out.println("Create account.");
>    AccountTest.account = new Account(AccountTest.INIT_BALANCE);
>    }
> 
>    // @AfterAll wird hier nicht verwendet
> 
> 24 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 22 ──
> @BeforeEach, @AfterEach
> 
>    Hier wird der „Standard-Kontostand“ gesetzt.
>    //**
>    * Initialisieren vor jedem einzelnen Test.
>    * Der Kontostand wird auf einen definierten Betrag gesetzt.
>    *
>    * Man koennte hier auch (statt in @BeforeAll) ein ganz
>    * neues Konto anlegen.
>    */
>    Methodennamen
>    @BeforeEach
>    frei wählbar
>    public void setUp() {
>    AccountTest.account.setBalance(AccountTest.INIT_BALANCE);
>    }
> 
>    // @AfterEach wird hier nicht verwendet
> 
> 25 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 23 ──
> Die Tests (Beispiel getBalance())
> 
>    Testen, ob die Abfrage des Kontostands den richtigen
>    Betrag liefert
> 
>    // Nicht vergessen: Oben den Import einfügen!
>    import static org.junit.jupiter.api.Assertions.assertEquals;
> 
>    @Test
>    public void testAccountBalance() throws AccountException {
>    assertEquals(INIT_BALANCE, account.getBalance());
>    }
> 
> 26 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 24 ──
> Die Tests (Beispiel inpayment())
> 
>    Testen, ob zwei sequentielle Einzahlung als Summe gebucht werden
>    @Test
>    public void inpaymentTest() throws AccountException {
>    account.inpayment(500);
>    account.inpayment(200);
>    assertEquals(INIT_BALANCE + 500 + 200, account.getBalance());
>    }
> 
>    Testen, ob eine negative Einzahlung zu einer AccountException führt
>    @Test
>    public void inpaymentNegativeTest() throws AccountException {
>    assertThrows(AccountException.class, () -> {
>    account.inpayment(-200);
>    });
>    }
> 
>    Testen, ob eine Einzahlung von 0 den Kontostand nicht ändert
>    @Test
>    public void inpaymentZeroTest() throws AccountException {
>    long balanceBefore = account.getBalance();
>    account.inpayment(0);
>    assertEquals(balanceBefore, account.getBalance());
>    }
> 
> 27 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 25 ──
> assert-Methoden („Behauptungen“)
> 
>    Wertvergleich:
>    assertEquals, assertNotEquals
>    Bedingungen:
>    assertFalse, assertTrue
>    Null oder nicht:
>    assertNull, assertNotNull
>    Mehrere Werte vergleichen:
>    assertAll
>    Erwarteter Timeout:
>    assertTimeout, assertTimeoutPreemptively
>    Erwartete Exception:
>    assertThrows
> 
>    Auf jeden Fall fehlschlagen:
>    fail, z.B. fail("Not implemented yet.");
> 
> 28 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 26 ──
> Wir erinnern uns: Die Tests für inpayment()
> 
>    Testen, ob zwei sequentielle Einzahlung als Summe gebucht werden
>    @Test
>    public void inpaymentTest() throws AccountException {
>    account.inpayment(500);
>    account.inpayment(200);
>    assertEquals(INIT_BALANCE + 500 + 200, account.getBalance());
>    }
> 
>    Testen, ob eine negative Einzahlung zu einer AccountException führt
>    @Test
>    public void inpaymentNegativeTest() throws AccountException {
>    assertThrows(AccountException.class, () -> {
>    account.inpayment(-200);
>    });
>    }
> 
>    Testen, ob eine Einzahlung von 0 den Kontostand nicht ändert
>    @Test
>    public void inpaymentZeroTest() throws AccountException {
>    long balanceBefore = account.getBalance();
>    account.inpayment(0);
>    assertEquals(balanceBefore, account.getBalance());
>    }
> 
> 29 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 27 ──
> Beispiel: Implementierung von inpayment()
> 
>    Mit der „leeren“ Implementierung schlagen zwei Tests fehl:
>    public void inpayment(long amount) throws AccountException {
>    }
> 
>    Die Methode getBalance() sei hier schon korrekt implementiert
> 
> 30 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 28 ──
> Beispiel: Implementierung von inpayment()
> 
>    Mit dieser einfachen Implementierung laufen
>    drei der vier Tests durch:
>    public void inpayment(long amount) throws AccountException {
>    this.balance += amount;
>    }
> 
> 31 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 29 ──
> Beispiel: Implementierung von inpayment()
> 
>    Eine Erweiterung lässt auch den letzten Test bestehen:
>    public void inpayment(long amount) throws AccountException {
>    if ( amount >= 0 ){
>    this.balance += amount;
>    } else {
>    throw new AccountException("No negative inpayments!");
>    }
>    }
> 
> 32 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 30 ──
> Aufgabe
> 
>    Implementieren Sie die Klasse Account und die Tests aus
>    diesen Folien nach!
> 
>    Erweitern Sie die Klasse Account um die Methodenköpfe:
>    public long outpayment(long amount) throws AccountException
> 
>    public boolean isBalancePositive()
> 
>    Schreiben Sie (jeweils mehrere) Tests für diese Methoden!
> 
>    Implementieren Sie die Methoden!
> 
> 33 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> 
> ── Seite 31 ──
> Literatur
> 
>    JUnit 5 tutorial - Learn how to write unit tests
>    https://www.vogella.com/tutorials/JUnit/article.html
> 
>    JUnit User Guide
>    https://docs.junit.org/snapshot/user-guide/
> 
> 34 W. Süß, T. Schlachter, J. Sidler, M. A. Koubaa, C. Schmitt Institut für Automation und angewandte Informatik
> ```
