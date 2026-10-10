import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class Auktion {
    private final Ware ware;

    public Calendar getEnd() {
        return end;
    }

    public Gebot getCurrentHighestBid() {
        return currentHighestBid;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    private Gebot currentHighestBid;
    private double currentPrice;
    private Calendar end;
    private static final double increment = 1.0;

    public Auktion(Ware ware, Calendar end) {
        this.ware = ware;
        this.currentHighestBid = null;
        this.currentPrice = 0.0;
        this.end = end;
    }

    public Auktion(Ware ware, int dauer) {
        Calendar end = Calendar.getInstance();
        end.setTimeInMillis(System.currentTimeMillis() + 60000L * dauer);
        this(ware, end);
    }

    public boolean gebotAbgeben(Gebot g) {
        // Log bids to auktionen.txt
        System.out.println("Logging bid now...");
        try (FileWriter writer = new FileWriter("auktionen.txt", true)) {
            writer.write(String.format("[%s] Gebot von %s für %s: %s Euro%n",
                    Calendar.getInstance().getTime(),
                    g.bidder().getFullName(),
                    this.ware.getTitle(),
                    g.bid()));
            System.out.println("Logged bid successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Check outcome
        if (g.bid() < currentPrice + increment) {
            return false;
        } else if (currentHighestBid == null) {
            currentHighestBid = g;
            currentPrice = increment;
            return true;
        } else if (g.bidder().equals(currentHighestBid.bidder())) {
            currentHighestBid = g;
            return true;
        } else if (g.bid() >= currentPrice && g.bid() <= currentHighestBid.bid()) {
            currentPrice = Math.min(g.bid() + increment, currentHighestBid.bid());
            return false;
        } else if (g.bid() >= currentPrice + increment && g.bid() > currentHighestBid.bid()) {
            currentPrice = Math.min(g.bid(), currentHighestBid.bid() + increment);
            currentHighestBid = g;
            return true;
        }
        return false;
    }

    public Ware getWare() {
        return ware;
    }

    public double getIncrement() { return increment; }
}
