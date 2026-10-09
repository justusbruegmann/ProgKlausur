---
tags: ["typ/uebung", "thema/klassen", "kategorie/oop", "semester/1", "schwierigkeit/2", "hat/musterloesung"]
aliases: ["Account"]
thema: "[[09 Klassen und Objekte]]"
klasse: "Account"
package: "de.dhbwka.java.exercise.classes"
schwierigkeit: 2
status: "offen"
---

# Ü09 Bankkonto

**Thema:** [[09 Klassen und Objekte]] · **Bereich:** Klassen (1) · **Schwierigkeit:** ★★☆☆☆
**Klasse:** `Account` · **Package:** `de.dhbwka.java.exercise.classes`

📄 Aufgabe: [[Material/Aufgaben/09_Klassen_Aufgaben-1.pdf#page=5|09_Klassen_Aufgaben-1.pdf, S. 5]]
✅ Musterlösung: [[Material/Aufgaben/09_Klassen_Aufgaben-1_Muster.pdf#page=6|09_Klassen_Aufgaben-1_Muster.pdf, S. 6]]

> [!question] Kurz gesagt
> Schreiben Sie eine Klasse Account, die ein Bankkonto realisiert. Attribute für das Bankkonto sind die Kontonummer, der Name des Kontoinhabers, der Kontostand sowie ein Limit, bis zu dem das Konto überzogen werden darf. a) Erstellen Sie einen oder mehrere geeignete Konstruktoren! b) Erstellen Sie Instanzenmethoden für folgende Operationen:  String-Darstellung des Bankkontos  Einzahlung  …

## Aufgabenstellung
```text
Schreiben Sie eine Klasse Account, die ein Bankkonto realisiert.
Attribute für das Bankkonto sind die Kontonummer, der Name des Kontoinhabers, der Kontostand
sowie ein Limit, bis zu dem das Konto überzogen werden darf.

a) Erstellen Sie einen oder mehrere geeignete Konstruktoren!

b) Erstellen Sie Instanzenmethoden für folgende Operationen:
     String-Darstellung des Bankkontos
     Einzahlung
     Auszahlung
     Abfrage des Kontostandes

Machen Sie dabei auch Plausibilitätsprüfungen, z.B. kann nur ein positiver Betrag eingezahlt werden.

Beispiel für Testmethode und zugehörige Ausgabe:
public static void main(String[] args) {
    Account account = new Account(4711, "Donald Duck", 500, 1000);
    System.out.println(account);
    account.processDeposit(200);
    System.out.println(account);
    account.processPayment(400);
    System.out.println(account);
    account.processPayment(2000);
    System.out.println(account);
}

Konto Nr. 4711 (Donald Duck), Stand: 500 ct, Limit 1000 ct
Konto Nr. 4711 (Donald Duck), Stand: 700 ct, Limit 1000 ct
Konto Nr. 4711 (Donald Duck), Stand: 300 ct, Limit 1000 ct
Deckung nicht ausreichend!
Konto Nr. 4711 (Donald Duck), Stand: 300 ct, Limit 1000 ct
```

## Benötigte Begriffe
[[Konstruktor]] · [[this]] · [[toString]] · [[Kapselung]] · [[Überschreiben]] · [[super]]

## Weitere Übungen zum Thema
[[Ü09 Radio]] · [[Ü09 Zweidimensionaler Punkt]] · [[Ü09 Polynom 2. Grades]] · [[Ü09 Komplexe Zahlen]] · [[Ü09 Polynome und Horner-Schema]] · [[Ü09 Nimmspiel]] · [[Ü09 Lotto]] · [[Ü09 MasterMind]] · [[Ü09 Wechselspiel (1. Teil)]] · [[Ü09 Wechselspiel (2. Teil)]]

## Musterlösung
> [!success]- Musterlösung anzeigen (erst selbst versuchen!)
> ```java
> package de.dhbwka.java.exercise.classes;
> 
> public class Account {
> 
>     private int number;
>     private String holder;
>     private int balance;
>     private int limit; // limit is a positive value
> 
>     public Account() {
>         this(-1, "n/n", 0, 0);
>     }
> 
>     public Account(int number, String holder, int balance, int limit) {
>         super();
>         this.number = number;
>         this.holder = holder;
>         this.balance = balance;
>         this.limit = limit;
>     }
> 
>     public int getBalance() {
>         return balance;
>     }
> 
>     public void processDeposit(int amount) {
>         if (amount > 0)
>         this.balance += amount;
>     }
> 
>     public void processPayment(int amount) {
>         if (amount > 0 && balance-amount >= -limit)
>         this.balance -= amount;
>         else
>         System.err.println("Deckung nicht ausreichend!");
>     }
> 
>     @Override
>     public String toString() {
>         return "Konto Nr. " + number
>         + " (" + holder + "), "
>         + "Stand: " + balance + " ct, "
>         + "Limit " + limit + " ct";
>     }
> 
>     public static void main(String[] args) {
>         Account account = new Account(4711, "Donald Duck", 500, 1000);
>         System.out.println(account);
>         account.processDeposit(200);
>         System.out.println(account);
>         account.processPayment(400);
>         System.out.println(account);
>         account.processPayment(2000);
>         System.out.println(account);
>     }
> 
> }
> ```

## Meine Notizen

