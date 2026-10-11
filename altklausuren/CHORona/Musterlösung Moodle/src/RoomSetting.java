import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RoomSetting {

    private Set<Point> polluters = new HashSet<>();
    private int width;
    private int height;

    public RoomSetting( int width, int height, int noOfPolluters ) throws AHAException {
        super();
        this.width = width;
        this.height = height;

        if ( width * height < noOfPolluters ) {
            throw new AHAException( "Insufficent singers" );
        }

        Random rnd = new Random();
        while ( this.polluters.size() < noOfPolluters ) {
            this.polluters.add( new Point( rnd.nextInt( width ), rnd.nextInt( height ) ) );
        }
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public Set<Point> getPolluters() {
        return this.polluters;
    }
}
