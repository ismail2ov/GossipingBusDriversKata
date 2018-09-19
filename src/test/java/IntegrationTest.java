import org.junit.jupiter.api.Test;

public class IntegrationTest {

    @Test
    public void allDriversKnowAllTheGossipTest() {
        BusDriver driver1 = buildBusDriver(1, buildRouteStops(3, 1, 2, 3));
        BusDriver driver2 = buildBusDriver(2, buildRouteStops(3, 2, 3, 1));
        BusDriver driver3 = buildBusDriver(3, buildRouteStops(4, 2, 3, 4, 5));

        LetsDrive drive = new LetsDrive();
        drive.add(driver1);
        drive.add(driver2);
        drive.add(driver3);

        Integer actual = drive.startWork();

        assert (actual).equals(5);
    }

    @Test
    public void theDriversWillNeverNnowAllTheGossipTest() {
        BusDriver driver1 = buildBusDriver(1, buildRouteStops(2, 1, 2));
        BusDriver driver2 = buildBusDriver(2, buildRouteStops(5, 2, 8));

        LetsDrive drive = new LetsDrive();
        drive.add(driver1);
        drive.add(driver2);

        Integer actual = drive.startWork();

        assert (actual).equals(-1);
    }

    private BusDriver buildBusDriver(int id, BusRoute busRoute) {
        return new BusDriver(id, busRoute);
    }

    private BusRoute buildRouteStops(int... routeStops) {
        return new BusRoute(routeStops);
    }
}
