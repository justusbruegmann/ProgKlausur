
import java.awt.Color;

public enum StopStatus {
    ON_SCHEDULE(Color.BLACK, new Color(0, 150, 0)),
    REASONABLE(Color.BLACK, new Color(150, 150, 255)),
    DELAYED(Color.WHITE, Color.RED);

    private Color textColor;
    private Color backgroundColor;

    public Color getTextColor() {
        return textColor;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    StopStatus(Color texColor, Color backgroundColor) {
        this.textColor = texColor;
        this.backgroundColor = backgroundColor;
    }

    public static StopStatus get(int delay) {
        if (delay <= 0) {
            return StopStatus.ON_SCHEDULE;
        } else if (delay < 6) {
            return StopStatus.REASONABLE;
        } else {
            return StopStatus.DELAYED;
        }
    }
}
