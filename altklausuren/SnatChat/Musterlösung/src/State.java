
public enum State {
    AVAILABLE("Available"), AWAY("Away"), DND("Do not disturb");

    private final String label;

    private State(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
