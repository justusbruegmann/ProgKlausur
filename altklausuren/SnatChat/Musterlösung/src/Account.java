
import java.awt.Color;
import java.util.Random;

public class Account {
    private State state = State.AVAILABLE;
    private String name;
    private Color color;

    public Account(String name) {
        this.name = name;
        Random r = new Random();
        this.color = new Color(r.nextInt(201), r.nextInt(201), r.nextInt(201));
    }

    public String getName() {
        return this.name;
    }

    public Color getColor() {
        return this.color;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
