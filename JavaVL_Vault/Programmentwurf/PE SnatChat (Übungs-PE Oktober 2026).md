---
tags: ["typ/programmentwurf", "kategorie/pruefung", "thema/operatoren", "thema/kontrollstrukturen", "thema/arrays", "thema/objektorientierung", "thema/klassen", "thema/strings", "thema/vererbung", "thema/exceptions", "thema/io", "thema/swing", "thema/interfaces", "thema/innere-klassen", "thema/events", "thema/zeichnen", "thema/datenstrukturen", "thema/enum", "thema/threads", "thema/programmentwurf"]
art: "Übungs-Programmentwurf (Vorbereitung 2026)"
datum: "Oktober 2026"
status: "offen"
bearbeitungszeit: "120 Minuten"
---

# PE SnatChat (Übungs-PE Oktober 2026)

[[Programmentwurf – Übersicht|⬆ Programmentwurf – Übersicht]] · [[Start|🏠 Start]]

**Art:** Übungs-Programmentwurf (Vorbereitung 2026) · **Stand:** Oktober 2026 · **Bearbeitungszeit:** 120 Minuten

> [!abstract] Worum geht's?
> Messenger für „geheime“ Kurznachrichten, die sich nach kurzer Zeit selbst zerstören. Gefordert sind das Interface `SnatChatFrontend`, ein Enum `State`, die Klassen `Account` und `Message`, ein `SnatChatRoom` zum Verteilen der Nachrichten und das Swing-Fenster `SnatChatWindow` mit Timer. Das ist die offizielle Übungsaufgabe zum Programmentwurf 2026.

📄 Aufgabenstellung: [[Material/Projekte/uebung26/43_UebungsPE_Oktober_SnatChat.pdf|43_UebungsPE_Oktober_SnatChat.pdf]]
✅ Musterlösung: [[Material/Programmentwurf_2026/43_UebungsPE_Oktober_SnatChat_Muster.pdf|43_UebungsPE_Oktober_SnatChat_Muster.pdf]]

## Teilaufgaben
- [ ] **a)** **[5 %]** Durch den absehbaren, enormen Erfolg von SnatChat (Kurznachrichtendienste sind ein kaum besetztes Geschäftsfeld!) soll zunächst die Funktionalität für Frontends (wie SnatChatWindow) über das Java-Interface SnatChatFrontend definiert werden. Das Interface hat die folgenden Methoden: • public void receiveMessage(Message msg) • public void receiveMessage(String text) • public Account getAccount()
- [ ] **b)** **[10 %]** Als Datenobjekte nutzt SnatChat Benutzerkonten (Klasse Account) sowie Nachrichten (Klasse Message). Schreiben Sie zunächst einen komplexen Aufzählungstyp State, mit den möglichen Werten AVAILABLE, AWAY und DND sowie den passenden, sprechenden Labels „Available“, „Away“ und „Do not disturb“!
- [ ] **c)** **[10 %]** Entwickeln Sie eine Klasse SnatChatRoom mit (mindestens) folgenden Methoden: • public String getRoomName() ermöglicht das Auslesen des Raum-Namens. Der Name des Raums soll in einer Instanz-Variablen (String roomName) gespeichert und im Konstruktor von SnatChatRoom übergeben werden! • public void register(SnatChatFrontend s) ermöglicht die Anmeldung eines Frontends (welches das Interface …
- [ ] **d)** **[10 %]** Schreiben Sie eine Klasse SnatChatWindow, welche das Interface SnatChatFrontend implementiert und eine grafische Benutzeroberfläche in einem eigenen Fenster erzeugt! In einem Konstruktor soll dem SnatChatWindow ein SnatChatRoom-Objekt sowie ein Account übergeben werden. (vgl.
- [ ] **e)** **[10 %]** Erweitern Sie die Klasse SnatChatWindow so, dass sie auf Benutzerinteraktionen reagiert: • Bei der Auswahl eines RadioButtons soll eine einfache Text-Nachricht in der Form „State of user 'username' is now 'statelabel' “ verschickt werden (vgl. Abbildung Vorderseite) sowie der Status im Account-Objekt aktualisiert werden. • Beim Drücken des Buttons „Send“ soll… o … bei leerem Nachrichtenfeld ein …
- [ ] **f)** **[10 %]** Erweitern Sie die Klasse SnatChatRoom so, dass alle Nachrichten, die über den Raum verschickt werden, auch in eine Textdatei geloggt werden. Hierfür soll jede Nachricht in eine Zeile der Datei „raumname.txt“ geschrieben werden (also „GansGeheim.txt“ für den Raumnamen aus der bereitgestellten main-Methode).
- [ ] **g)** **[10 %]** Der Nachrichtendienst SnatChat legt großen Wert auf Vertraulichkeit. Erweitern Sie die Klasse SnatChatWindow daher so, dass eingehende Nachrichten nach 30 Sekunden automatisch aus der Nachrichtenliste entfernt werden.
- [ ] **h)** **[10 %]** Vertraulichkeit ist der Markenkern von SnatChat – daher sollen die Log-Dateien nicht im Klartext gespeichert, sondern die Nachrichten verschlüsselt abgelegt werden. Hierfür wurde der Algorithmus „rot13“ ausgewählt.

## Benötigte Begriffe
[[Arithmetische Operatoren]] · [[Formatierte Ausgabe]] · [[Zufallszahlen]] · [[while-Schleife]] · [[for-Schleife]] · [[Array]] · [[Konstruktor]] · [[this]] · [[static]] · [[toString]] · [[Kapselung]] · [[Vererbung]] · [[Überschreiben]] · [[super]] · [[Interface]] · [[Anonyme innere Klasse]] · [[Enum]] · [[String]] · [[Exception]] · [[try-with-resources]] · [[Reader und Writer]] · [[BufferedReader und BufferedWriter]] · [[PrintWriter]] · [[Datei und Pfad]] · [[Swing]] · [[JFrame]] · [[JPanel]] · [[Swing-Komponenten]] · [[Layoutmanager]] · [[Dialoge]] · [[Farben und Schriften]] · [[Listener]] · [[Zeichnen mit Graphics]] · [[List]] · [[Thread]] · [[Timer]] · [[Programmentwurf]]

## Dafür wiederholen (Themen)
**Schwerpunkte:** [[08 Objektorientierung]] · [[09 Klassen und Objekte]] · [[13 Vererbung]] · [[14 Exceptions]] · [[15 Input und Output]] · [[20 Grafische Oberflächen mit Swing]] · [[21 Abstrakte Klassen und Interfaces]] · [[22 Innere Klassen]] · [[23 Events]] · [[24 Zeichnen in Swing]] · [[25 Datenstrukturen und Generics]] · [[26 Aufzählungstypen (Enums)]] · [[27 Threads]]

**Grundlagen:** [[05 Operatoren]] · [[06 Kontrollstrukturen]] · [[07 Arrays]] · [[10 Strings und Wrapperklassen]]

## Dateien
- [43_UebungsPE_Oktober_SnatChat.pdf](<Material/Projekte/uebung26/43_UebungsPE_Oktober_SnatChat.pdf>)
- [ChatMessagesComponent.java](<Material/Projekte/uebung26/ChatMessagesComponent.java>)
- [SnatChat.java](<Material/Projekte/uebung26/SnatChat.java>)
- [src/gans/Account.java (Code-Stand am Ende der Übung)](<Material/Projekte/2026_SnatChat_StandDerUebung/src/gans/Account.java>)
- [src/gans/ChatMessagesComponent.java (Code-Stand am Ende der Übung)](<Material/Projekte/2026_SnatChat_StandDerUebung/src/gans/ChatMessagesComponent.java>)
- [src/gans/Message.java (Code-Stand am Ende der Übung)](<Material/Projekte/2026_SnatChat_StandDerUebung/src/gans/Message.java>)
- [src/gans/SnatChat.java (Code-Stand am Ende der Übung)](<Material/Projekte/2026_SnatChat_StandDerUebung/src/gans/SnatChat.java>)
- [src/gans/SnatChatFrontend.java (Code-Stand am Ende der Übung)](<Material/Projekte/2026_SnatChat_StandDerUebung/src/gans/SnatChatFrontend.java>)
- [src/gans/SnatChatRoom.java (Code-Stand am Ende der Übung)](<Material/Projekte/2026_SnatChat_StandDerUebung/src/gans/SnatChatRoom.java>)
- [src/gans/SnatChatWindow.java (Code-Stand am Ende der Übung)](<Material/Projekte/2026_SnatChat_StandDerUebung/src/gans/SnatChatWindow.java>)
- [src/gans/State.java (Code-Stand am Ende der Übung)](<Material/Projekte/2026_SnatChat_StandDerUebung/src/gans/State.java>)
- [src/module-info.java (Code-Stand am Ende der Übung)](<Material/Projekte/2026_SnatChat_StandDerUebung/src/module-info.java>)

## Vorgegebener Code
> [!example]- ChatMessagesComponent.java
> ```java
> import java.awt.GridBagConstraints;
> import java.awt.GridBagLayout;
> import java.awt.Insets;
> 
> import javax.swing.BorderFactory;
> import javax.swing.JComponent;
> import javax.swing.JPanel;
> import javax.swing.JScrollPane;
> 
> /**
>  * Bereitgestelltes Oberflaechenelement zur Anzeige der Chat-Nachrichten auf Basis einer beliebigen Komponente.
>  * 
>  * Einfach wie ein Panel benutzen:
>  * <pre>
>  * ChatMessagesComponent chats = new ChatMessagesComponent();
>  * chats.add(...);
>  * (...)
>  * chats.remove(...);
>  * </pre>
>  */
> @SuppressWarnings("serial")
> public class ChatMessagesComponent extends JScrollPane {
>     
>     /**
>      * Anzahl der Nachtrichten
>      */
>     private int messagesCount = 0;
>     
>     /**
>      * Panel, zu dem die Komponenten hinzugefuegt werden
>      */
>     private JPanel messagesPanel = new JPanel(new GridBagLayout());
>     
>     /**
>      * Auffuellkomponente in Y-Richtung (damit Nachrichten oben stehen)
>      */
>     private JPanel fillerY = new JPanel();
>     
>     /**
>      * Erstelle die Komponente fuer die Chat-Nachrichten
>      */
>     public ChatMessagesComponent() {
>         this.setViewportView(this.messagesPanel);
>     }
>     
>     /**
>      * Fuege eine Komponente als Chat-Nachricht hinzu
>      * @param component Komponente zum hinzufuegen
>      */
>     public void add( JComponent component ){
>         this.messagesPanel.remove(this.fillerY);
>         component.setBorder(BorderFactory.createEmptyBorder(1, 0, 1, 0));
>         this.messagesPanel.add(component, new GridBagConstraints(0, this.messagesCount++, 1, 1, 1., 0., GridBagConstraints.BASELINE_LEADING, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
>         this.messagesPanel.add(this.fillerY, new GridBagConstraints(0, this.messagesCount, 1, 1, 1., 1., GridBagConstraints.BASELINE_LEADING, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
>         this.messagesPanel.revalidate();
>     }
>     
>     /**
>      * Entferne eine Komponente
>      * @param component Komponente die entfernt werden soll
>      */
>     public void remove( JComponent component ){
>         this.messagesPanel.remove(component);
>         this.messagesPanel.revalidate();
>         this.messagesPanel.repaint();
>     }
>     
> }
> ```

> [!example]- SnatChat.java
> ```java
> public class SnatChat {
>     
>     public static void main(String[] args) {
>         SnatChatRoom room = new SnatChatRoom("GansGeheim");
>         
>         room.register( new SnatChatWindow(room, new Account("Bob") ) );
>         room.register( new SnatChatWindow(room, new Account("Alice") ) );
>     }
>     
> }
> ```

## Code-Stand am Ende der Übung
> [!success]- src/gans/Account.java
> ```java
> package gans;
> 
> import java.awt.Color;
> import java.util.Random;
> 
> public class Account {
>     private String name;
>     private State state = State.AVAILABLE;
>     private Color color;
>     
>     public Account(String name) {
>         super();
>         this.name = name;
>         Random r = new Random();
>         this.color = new Color(r.nextInt(201), r.nextInt(201), r.nextInt(201));
>     }
> 
>     public String getName() {
>         return name;
>     }
> 
>     public void setName(String name) {
>         this.name = name;
>     }
> 
>     public State getState() {
>         return state;
>     }
> 
>     public void setState(State state) {
>         this.state = state;
>     }
> 
>     public Color getColor() {
>         return color;
>     }
> 
>     public void setColor(Color color) {
>         this.color = color;
>     }
>     
>     
>     
>     
> }
> ```

> [!success]- src/gans/ChatMessagesComponent.java
> ```java
> package gans;
> 
> import java.awt.GridBagConstraints;
> import java.awt.GridBagLayout;
> import java.awt.Insets;
> 
> import javax.swing.BorderFactory;
> import javax.swing.JComponent;
> import javax.swing.JPanel;
> import javax.swing.JScrollPane;
> 
> /**
>  * Bereitgestelltes Oberflaechenelement zur Anzeige der Chat-Nachrichten auf Basis einer beliebigen Komponente.
>  * 
>  * Einfach wie ein Panel benutzen:
>  * <pre>
>  * ChatMessagesComponent chats = new ChatMessagesComponent();
>  * chats.add(...);
>  * (...)
>  * chats.remove(...);
>  * </pre>
>  */
> @SuppressWarnings("serial")
> public class ChatMessagesComponent extends JScrollPane {
>     
>     /**
>      * Anzahl der Nachtrichten
>      */
>     private int messagesCount = 0;
>     
>     /**
>      * Panel, zu dem die Komponenten hinzugefuegt werden
>      */
>     private JPanel messagesPanel = new JPanel(new GridBagLayout());
>     
>     /**
>      * Auffuellkomponente in Y-Richtung (damit Nachrichten oben stehen)
>      */
>     private JPanel fillerY = new JPanel();
>     
>     /**
>      * Erstelle die Komponente fuer die Chat-Nachrichten
>      */
>     public ChatMessagesComponent() {
>         this.setViewportView(this.messagesPanel);
>     }
>     
>     /**
>      * Fuege eine Komponente als Chat-Nachricht hinzu
>      * @param component Komponente zum hinzufuegen
>      */
>     public void add( JComponent component ){
>         this.messagesPanel.remove(this.fillerY);
>         component.setBorder(BorderFactory.createEmptyBorder(1, 0, 1, 0));
>         this.messagesPanel.add(component, new GridBagConstraints(0, this.messagesCount++, 1, 1, 1., 0., GridBagConstraints.BASELINE_LEADING, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
>         this.messagesPanel.add(this.fillerY, new GridBagConstraints(0, this.messagesCount, 1, 1, 1., 1., GridBagConstraints.BASELINE_LEADING, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
>         this.messagesPanel.revalidate();
>     }
>     
>     /**
>      * Entferne eine Komponente
>      * @param component Komponente die entfernt werden soll
>      */
>     public void remove( JComponent component ){
>         this.messagesPanel.remove(component);
>         this.messagesPanel.revalidate();
>         this.messagesPanel.repaint();
>     }
>     
> }
> ```

> [!success]- src/gans/Message.java
> ```java
> package gans;
> 
> public class Message {
> 
>     private String text;
>     private Account sender;
>     public Message(String text, Account sender) {
>         super();
>         this.text = text;
>         this.sender = sender;
>     }
>     public String getText() {
>         return text;
>     }
>     public void setText(String text) {
>         this.text = text;
>     }
>     public Account getSender() {
>         return sender;
>     }
>     public void setSender(Account sender) {
>         this.sender = sender;
>     }
>     
>     
> }
> ```

> [!success]- src/gans/SnatChat.java
> ```java
> package gans;
> 
> public class SnatChat {
>     
>     public static void main(String[] args) {
>         SnatChatRoom room = new SnatChatRoom("GansGeheim");
>         
>         room.register( new SnatChatWindow(room, new Account("Bob") ) );
>         room.register( new SnatChatWindow(room, new Account("Alice") ) );
>     }
>     
> }
> ```

> [!success]- src/gans/SnatChatFrontend.java
> ```java
> package gans;
> 
> public interface SnatChatFrontend {
> 
>     void receiveMessage(Message msg);
>     void receiveMessage(String text);
>     Account getAccount();
> }
> ```

> [!success]- src/gans/SnatChatRoom.java
> ```java
> package gans;
> 
> import java.util.LinkedList;
> import java.util.List;
> 
> public class SnatChatRoom {
>     
>     private String name; // name statt roomName auch OK!
> 
>     private List<SnatChatFrontend> frontends = new LinkedList<>();
>     
>     public SnatChatRoom(String name) {
>         super();
>         this.name = name;
>     }
> 
>     public String getName() {
>         return name;
>     }
>     
>     public void register(SnatChatFrontend s) {
>         this.frontends.add(s);
>     }
>     public void unregister(SnatChatFrontend s) {
>         this.frontends.remove(s);
>     }
>     
>     public void sendMessage(Message m) {
>         for ( SnatChatFrontend f : this.frontends ) {
>             f.receiveMessage(m);
>         }
>     }
>     
>     public void sendMessage(String text) {
>         for ( SnatChatFrontend f : this.frontends ) {
>             f.receiveMessage(text);
>         }
>     }
> 
> }
> ```

> [!success]- src/gans/SnatChatWindow.java
> ```java
> package gans;
> 
> import java.awt.BorderLayout;
> import java.awt.Color;
> import java.awt.FlowLayout;
> import java.awt.event.ActionEvent;
> import java.awt.event.ActionListener;
> import java.awt.event.KeyAdapter;
> import java.awt.event.KeyEvent;
> 
> import javax.swing.ButtonGroup;
> import javax.swing.JButton;
> import javax.swing.JFrame;
> import javax.swing.JLabel;
> import javax.swing.JOptionPane;
> import javax.swing.JPanel;
> import javax.swing.JRadioButton;
> import javax.swing.JTextField;
> 
> @SuppressWarnings("serial")
> public class SnatChatWindow extends JFrame implements SnatChatFrontend {
> 
>     private ChatMessagesComponent chatMessagesComponent = new ChatMessagesComponent();
> 
>     private JTextField messageField = new JTextField();
> 
>     private JButton sendButton = new JButton("Send");
> 
>     private Account account;
>     private SnatChatRoom room;
> 
>     public SnatChatWindow(SnatChatRoom room, Account account) {
>         super(String.format("%s (%s)", account.getName(), room.getName()));
>         this.account = account;
>         this.room = room;
>         this.initUI(account);
> 
>         ActionListener al = new ActionListener() {
> 
>             @Override
>             public void actionPerformed(ActionEvent e) {
>                 if (messageField.getText().isBlank()) {
>                     JOptionPane.showMessageDialog(SnatChatWindow.this, "Empty text field :(");
>                 } else {
>                     Message m = new Message(messageField.getText(), account);
>                     room.sendMessage(m);
>                 }
> 
>             }
>         };
>         this.sendButton.addActionListener(al);
>         this.messageField.addActionListener(al);
>     }
> 
>     private void initUI(Account account) {
>         this.setLayout(new BorderLayout(5, 5));
> 
>         JLabel labelName = new JLabel(account.getName(), JLabel.CENTER);
>         labelName.setForeground(account.getColor());
> 
>         this.add(labelName, BorderLayout.NORTH);
>         this.add(this.chatMessagesComponent, BorderLayout.CENTER);
> 
>         JPanel panelSouth = new JPanel(new BorderLayout(5, 5));
> 
>         panelSouth.add(this.messageField, BorderLayout.CENTER);
>         panelSouth.add(this.sendButton, BorderLayout.EAST);
> 
>         ButtonGroup btnGrp = new ButtonGroup();
>         JPanel panStateRadios = new JPanel(new FlowLayout());
>         for (final State s : State.values()) {
>             JRadioButton radioButton = new JRadioButton(s.getLabel());
>             btnGrp.add(radioButton);
>             panStateRadios.add(radioButton);
> 
>             if (s == account.getState()) {
>                 radioButton.setSelected(true);
>             }
> 
>             radioButton.addActionListener(new ActionListener() {
> 
>                 @Override
>                 public void actionPerformed(ActionEvent e) {
>                     String txt = "state of user " + account.getName() + " is now " + s.getLabel();
>                     room.sendMessage(txt);
>                 }
>             });
>         }
>         panelSouth.add(panStateRadios, BorderLayout.NORTH);
> 
>         this.add(panelSouth, BorderLayout.SOUTH);
> 
>         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
>         this.setSize(325, 300);
>         this.setVisible(true);
>     }
> 
>     @Override
>     public void receiveMessage(Message msg) {
>         receiveMsg(msg.getSender().getName() + ": " + msg.getText(), msg.getSender().getColor());
>     }
> 
>     @Override
>     public void receiveMessage(String text) {
>         receiveMsg(text, Color.GRAY);
>     }
> 
>     private void receiveMsg(String text, Color c) {
>         JLabel lbl = new JLabel(text);
>         lbl.setForeground(c);
>         this.chatMessagesComponent.add(lbl);
>     }
> 
>     @Override
>     public Account getAccount() {
>         return account;
>     }
> 
> }
> ```

> [!success]- src/gans/State.java
> ```java
> package gans;
> 
> public enum State {
> 
>     AVAILABLE("Available"), AWAY("Away"), DND("Do not disturb!");
>     
>     private String label;
> 
>     private State(String label) {
>         this.label = label;
>     }
>     
>     public String getLabel() {
>         return label;
>     }
> }
> ```

> [!success]- src/module-info.java
> ```java
> module GansGeheim {
>     requires java.desktop;
> }
> ```

## Aufgabenstellung ansehen
![[Material/Projekte/uebung26/43_UebungsPE_Oktober_SnatChat.pdf]]

## Aufgabentext (durchsuchbar)
> [!quote]- Kompletter Aufgabentext – aufklappen
> ```text
> Download Zusatzdateien:
>             https://www.iai.kit.edu/javavl/pe/uebung26.zip
> 
> Hinweis zur Bewertung:
>    • 1/4 der Punkte (25%) wird nach Funktionstests Ihrer Lösung vergeben.
>    • 3/4 der Punkte (75%) werden entsprechend des in den Teilaufgaben angegebenen Schlüssels auf Basis des
>        Quellcodes vergeben.
> 
>                        DHBW Karlsruhe, Vorlesung Programmieren I+II
> 
>                              Übungsprogrammentwurf Oktober 2026
> 
>                                     Bearbeitungszeit: 120 Minuten
> Aufgabe
> Schreiben Sie eine Java-Anwendung „SnatChat“, die einen Messenger für „geheime“ Kurznachrichten implementiert!
> Nachrichten bei SnatChat zeichnen sich dadurch aus, dass sie für die Empfänger nur für kurze Zeit lesbar sind und
> sich danach – ähnlich wie in Mission: Impossible – „selbst zerstören“.
> Der Nachrichtenaustausch ist über eine spezielle, Java-basierte Nutzeroberfläche „SnatChatWindow“ möglich. Im
> Hintergrund nutzen alle SnatChatWindows zur Kommunikation einen SnatChatRoom um bspw. Nachrichten an alle
> Nutzer zu verteilen.
> 
> Teilaufgabe a)                                                                                                  [5%]
> Durch den absehbaren, enormen Erfolg von SnatChat (Kurznachrichtendienste sind ein kaum besetztes
> Geschäftsfeld!) soll zunächst die Funktionalität für Frontends (wie SnatChatWindow) über das Java-Interface
> SnatChatFrontend definiert werden. Das Interface hat die folgenden Methoden:
>     •   public void receiveMessage(Message msg)
>     •   public void receiveMessage(String text)
>     •   public Account getAccount()
> 
> Teilaufgabe b)                                                                                                 [10%]
> Als Datenobjekte nutzt SnatChat Benutzerkonten (Klasse Account) sowie Nachrichten (Klasse Message).
> Schreiben Sie zunächst einen komplexen Aufzählungstyp State, mit den möglichen Werten AVAILABLE, AWAY und
> DND sowie den passenden, sprechenden Labels „Available“, „Away“ und „Do not disturb“!
> Schreiben Sie eine Klasse Account, die zu jedem Konto den Benutzernamen (String name), den aktuellen Status
> (State state) und eine Farbe für dessen Nachrichten (Color color) speichert! Dabei soll der Name im
> Konstruktor übergeben und die Farbe für den Account zufällig und nicht zu hell (s. Hinweis) erzeugt werden. Initial ist
> jeder Account im Zustand State.AVAILABLE.
> Schreiben Sie eine Klasse Message, die zu jeder Nachricht deren Inhalt (text vom Typ String) sowie eine
> Referenz auf den Absender (Account-Instanz) speichert! Der Konstruktor von Message soll das Setzen beider
> Attribute ermöglichen.
> Machen Sie die Attribute beider Klassen „privat“ und über Getter/Setter-Methoden verfügbar!
> 
> Teilaufgabe c)                                                                                                 [10%]
> Entwickeln Sie eine Klasse SnatChatRoom mit (mindestens) folgenden Methoden:
>     •   public String getRoomName() ermöglicht das Auslesen des Raum-Namens. Der Name des Raums
>         soll in einer Instanz-Variablen (String roomName) gespeichert und im Konstruktor von SnatChatRoom
>         übergeben werden!
>     •   public void register(SnatChatFrontend s) ermöglicht die Anmeldung eines Frontends
>         (welches das Interface SnatChatFrontend implementiert).
>     •   public void unregister(SnatChatFrontend s) ermöglicht das Abmelden eines Frontends.
>     •   public void sendMessage(Message msg)schickt eine Nachricht msg an alle angemeldeten
>         Frontends.
>     •   public void sendMessage(String text) schickt den Nachrichtentext text an alle
>         angemeldeten Frontends.
> 
> Teilaufgabe d)                                                                                               [10%]
> Schreiben Sie eine Klasse SnatChatWindow, welche das Interface SnatChatFrontend implementiert und eine
> grafische Benutzeroberfläche in einem eigenen Fenster erzeugt!
> 
> In einem Konstruktor soll dem SnatChatWindow ein SnatChatRoom-Objekt sowie ein Account übergeben
> werden. (vgl. Beispiel-Code zum Starten / Hinweise)
> Die Benutzeroberfläche eines SnatChatWindows besteht aus der Titelzeile (Format: „Benutzername
> (Raumname)“), dem Benutzernamen in der entsprechenden Farbe des Accounts innerhalb des Fensters, einer
> ChatMessagesComponent (Klasse bereitgestellt auf USB-Stick) für die Anzeige der Nachrichten, Radio-Buttons
> für die Auswahl des aktuellen Status (der richtige Status ist passend zu der übergebenen Account-Instanz zu
> selektieren), einem einzeiligen Feld zur Eingabe von Nachrichten („Eingabe“, zunächst leer) und einem Button
> „Send“ zum Absenden der Nachrichten (zunächst keine Aktion, wird später ergänzt).
> Mit Hilfe der bereitgestellten ChatMessagesComponent sollen beim Aufruf von…
>     • … receiveMessage(String) eine Nachricht mit dem übergebenen Text und der Textfarbe Grau
>         (java.awt.Color.GRAY) hinzugefügt werden.
>     • … receiveMessage(Message) eine Nachricht in der Form „Absender: Nachrichtentext“ mit der Farbe
>         des Absenders als Textfarbe hinzugefügt werden.
> 
> Hinweis: In Teilaufgabe g) wird diese Funktionalität erweitert!
> 
> Teilaufgabe e)                                                                                               [10%]
> Erweitern Sie die Klasse SnatChatWindow so, dass sie auf Benutzerinteraktionen reagiert:
>    • Bei der Auswahl eines RadioButtons soll eine einfache Text-Nachricht in der Form
>        „State of user 'username' is now 'statelabel' “ verschickt werden (vgl. Abbildung Vorderseite) sowie der Status
>        im Account-Objekt aktualisiert werden.
>    • Beim Drücken des Buttons „Send“ soll…
>             o … bei leerem Nachrichtenfeld ein Dialog erscheinen, der den aktuellen Benutzer darauf hinweist, dass
>                 eine Nachricht eingeben muss. (vgl. Abbildung unten)
>             o … bei gefülltem Nachrichtenfeld ein Nachrichten-Objekt mit dem Inhalt des Textfelds als
>                 Nachrichtentext und dem Account der SnatChatWindow-Instanz als Absender generiert und
>                 verschickt werden. Im Anschluss soll das Textfeld geleert werden.
>    • 1 Zusatzpunkt: Auch das Drücken der Enter-Taste im Textfeld löst das Abschicken aus.
> 
> Teilaufgabe f)                                                                                               [10%]
> Erweitern Sie die Klasse SnatChatRoom so, dass alle Nachrichten, die über den Raum verschickt werden, auch in
> eine Textdatei geloggt werden. Hierfür soll jede Nachricht in eine Zeile der Datei „raumname.txt“ geschrieben
> werden (also „GansGeheim.txt“ für den Raumnamen aus der bereitgestellten main-Methode). Besteht die Datei
> bereits, sollen weitere Nachrichten angehängt werden.
> Darüber hinaus soll beim Registrieren einer SnatChatFrontend-Instanz die Textdatei eingelesen werden und jede
> Nachricht als einfache Text-Nachricht direkt an das Frontend geschickt werden.
> Erweitern Sie die Einlese-Routine für die Log-Datei anschließend so, dass nur maximal die letzten 10
> Nachrichten/Zeilen an das Frontend geschickt werden, nicht die komplette Historie.
> 
> Teilaufgabe g)                                                                                                 [10%]
> Der Nachrichtendienst SnatChat legt großen Wert auf Vertraulichkeit. Erweitern Sie die Klasse SnatChatWindow
> daher so, dass eingehende Nachrichten nach 30 Sekunden automatisch aus der Nachrichtenliste entfernt werden.
> Für jede Nachricht soll rechts des Nachrichtentextes ein Countdown heruntergezählt werden, wie viele Sekunden die
> Nachricht noch zu sehen ist.
> 
> Teilaufgabe h)                                                                                                 [10%]
> Vertraulichkeit ist der Markenkern von SnatChat – daher sollen die Log-Dateien nicht im Klartext gespeichert,
> sondern die Nachrichten verschlüsselt abgelegt werden. Hierfür wurde der Algorithmus „rot13“ ausgewählt.
> Implementieren Sie hierfür in der Klasse Message eine statische Methode
> public static String rot13(String message)
> welche die Zeichenkette message durchläuft und auf jedes Zeichen folgende Regeln anwendet und das Ergebnis
> zurückgibt:
>     • Ersetzt werden nur Zeichen von A-Z und a-z, alle anderen Zeichen bleiben gleich
>     • Alle Zeichen von A-M und a-m werden durch das Zeichen 13 Buchstaben später im Alphabet ersetzt
>     • Alle Zeichen von N-Z und n-z wird das Zeichen 13 Buchstaben früher im Alphabet ersetzt
> 
> Sorgen Sie dafür, dass vor dem Schreiben der Zeile in die Datei die „Verschlüsselung“ auf die zu schreibende
> Zeichenkette angewandt wird!
> Der große Vorteil von rot13 ist, dass durch doppeltes Anwenden alles wieder lesbar wird. Sorgen Sie dafür, dass
> beim Lesen aus der Log-Datei auf jede eingelesene Zeile wiederum der rot13-Algorithmus angewandt wird um die
> Zeilen wieder lesbar zu machen.
> 
> Hinweise:
> Starten:
> Starten Sie die Anwendung mit einer Klasse SnatChat (s. USB-Stick), etwa
> public class SnatChat {
>    public static void main(String[] args) {
>       SnatChatRoom room = new SnatChatRoom("GansGeheim");
>       room.register( new SnatChatWindow(room, new Account("Bob") ) );
>       room.register( new SnatChatWindow(room, new Account("Alice") ) );
>    }
> }
> 
> Erzeugen einer zufälligen, nicht zu hellen Farbe:
> Nutzen Sie hierfür new java.awt.Color(int r, int g, int b). Für r, g und b sind jeweils zufällige
> Werte von 0 bis 200 (beide inklusive) zu erzeugen.
> 
> Verwendung der bereitgestellten Klasse ChatMessagesComponent:
> Anstatt eines JPanels für das Hinzufügen der Nachrichten können Sie die Klasse ChatMessagesComponent
> verwenden, welche sich um das Layouten (inkl. Scroll-Balken) der Nachrichten kümmert. Die Verwendung kann
> beispielhaft so aussehen:
> ChatMessagesComponent chatMessages = new ChatMessagesComponent();
> JLabel myLabel = new JLabel("A Message for Bob"); // Label mit neuer Nachricht
> 
> chatMessages.add(myLabel); // Hinzufügen einer Nachricht
> chatMessages.remove(myLabel); // Entfernen einer Nachricht
> 
> frame.add(chatMessages);
> ```

## Meine Notizen

