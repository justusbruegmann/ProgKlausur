import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class CellButton extends JButton {

    private double dose;
    private boolean polluter = false;

    public CellButton() {
        this(0);
    }

    public CellButton(double dose) {
        this.setDose(dose);
    }

    public double getDose() {
        return this.dose;
    }

    public void setDose(double dose) {
        this.dose = dose;
        Chorona.updateButtonForDose( this, dose );
    }

    public boolean isPolluter() {
        return this.polluter;
    }

    public void setPolluter(boolean polluter) {
        this.polluter = polluter;
        if ( this.polluter ) {
            this.setBorder( BorderFactory.createLineBorder( Color.BLACK, 4 ) );
        } else {
            this.setBorder( null );
        }
    }
}
