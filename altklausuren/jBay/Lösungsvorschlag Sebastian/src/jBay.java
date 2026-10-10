public class jBay {

    static BieterTerminal[] terminals = new BieterTerminal[2];
    void main(String[] args) {
        Auktionshaus jbay = new Auktionshaus();
        jbay.addAuktion(new Auktion(
                new Ware("Turnschuhe", "Tolle Turnschuhe, kaum getragen"), 2));
        jbay.addAuktion(new Auktion(
                new Ware("iPad", "Nagelneues iPad 3"), 4));
        jbay.addAuktion(new Auktion(
                new Ware("Currywurst", "Scharf, ohne Pommes"), 5));

        // Start the bieter terminals
        Bieter b1 = new Bieter("Micky", "Maus");
        Bieter b2 = new Bieter("Donald", "Duck");
        BieterTerminal t1 = new BieterTerminal(b1, jbay);
        BieterTerminal t2 = new BieterTerminal(b2, jbay);
        terminals[0] = t1;
        terminals[1] = t2;
    }

    public static void updateUi() {
        System.out.println("Updating UI for all terminals...");
        for (BieterTerminal t : terminals) {
            t.updateUi();
        }
    }
}
