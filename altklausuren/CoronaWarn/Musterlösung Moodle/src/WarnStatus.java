
import java.awt.Color;

public enum WarnStatus {
    UNKNOWN("Unknown", new Color(175, 175, 175)),
    OK("OK", new Color(100, 200, 100)),
    ALARM("Possible encounter", new Color(255, 100, 100)),
    INFECTED("In quarantine", new Color(150, 150, 255));

    private final String label;
    private final Color color;

    private WarnStatus(String label, Color color) {
        this.label = label;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public String getLabel() {
        return label;
    }
}
