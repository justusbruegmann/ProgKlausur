
public class Time {
    private int hour;
    private int minute;

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public Time(int hour, int minute) throws DBException {
        if (((0 <= hour) && (hour <= 23)) && ((0 <= minute) && (minute <= 59))) {
            this.hour = hour;
            this.minute = minute;

        } else {
            throw new DBException("invalide time");
        }
    }

    @Override
    public String toString() {
        String result = hour + ":" + minute;
        return result;
    }
}
