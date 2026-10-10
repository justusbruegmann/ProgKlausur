import java.util.LinkedList;
import java.util.List;

public class Auktionshaus {
    private final List<Auktion> auktionen;
    private final List<BieterTerminal> registeredTerminals;

    public Auktionshaus() {
        this.auktionen = new LinkedList<>();
        this.registeredTerminals = new LinkedList<>();
    }

    public void addAuktion(Auktion a) {
        this.auktionen.add(a);
    }

    public void removeAuktion(Auktion a) {
        this.auktionen.remove(a);
    }

    public List<Auktion> getAuktionen() {
        return this.auktionen;
    }

    public void registerTerminal(BieterTerminal terminal) {
        this.registeredTerminals.add(terminal);
    }

    public void updateTerminals() {
        for (BieterTerminal terminal : registeredTerminals) {
            terminal.updateUi();
        }
    }
}
