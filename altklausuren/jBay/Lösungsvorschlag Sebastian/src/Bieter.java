public class Bieter {
    private final String first_name;
    private final String last_name;

    public Bieter(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public String getFullName() {
        return this.first_name + " " + this.last_name;
    }
}
