import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GossipBusTest {


    @Test
    public void gugu() {
        BusDriver driver1 = new BusDriver(1, new BusRoute(new int[]{3,1,2,3}));
        BusDriver driver2 = new BusDriver(2, new BusRoute(new int[]{3,2,3,1}));
        BusDriver driver3 = new BusDriver(3, new BusRoute(new int[]{4,2,3,4,5}));

        LetsDrive drive = new LetsDrive();
        drive.add(driver1);
        drive.add(driver2);
        drive.add(driver3);

        Integer actual = drive.startWork();

        assert(actual).equals(5);
    }
}
