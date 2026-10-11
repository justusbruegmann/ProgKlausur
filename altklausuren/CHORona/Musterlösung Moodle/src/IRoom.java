public interface IRoom {

    public double getDose(int x, int y);

    public void setDose(int x, int y, double dose);

    public void addDose(int x, int y, double dose);

    public void step();

}
