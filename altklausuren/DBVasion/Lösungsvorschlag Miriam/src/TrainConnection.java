
import java.util.ArrayList;
import java.util.List;

public class TrainConnection {
    private String name;
    private String start;
    private String end;
    private boolean regional;
    private double price;
    private List<Stop> stops;

    public String getName() {
        return name;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public boolean isRegional() {
        return regional;
    }

    public double getPrice() {
        return price;
    }

    public List<Stop> getStops() {
        return stops;
    }

    public TrainConnection(String name, String start, String end, boolean regional, double price) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.regional = regional;
        this.price = price;
    }

    public void setStops(List<Stop> stops) {
        this.stops = new ArrayList<>();
        for (Stop s : stops) {
            this.stops.add(s);
        }
    }
}
