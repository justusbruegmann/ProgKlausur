
public class Stop {
    private String name;
    private Time arrival;
    private int StayPeriod;
    private int stage;

    public String getName() {
        return name;
    }

    public Time getArrival() {
        return arrival;
    }

    public int getStayPeriod() {
        return StayPeriod;
    }

    public int getStage() {
        return stage;
    }

    public Stop(String name, Time arrival, int stayPeriod, int stage) {
        this.name = name;
        this.arrival = arrival;
        StayPeriod = stayPeriod;
        this.stage = stage;
    }

}
