import java.util.HashSet;
import java.util.Set;

public class LetsDrive {
    public static final int MAX_LAPS = 480;
    private Set<BusDriver> drivers = new HashSet<>();
    private Integer iterations = 0;

    public void add(BusDriver driver) {
        this.drivers.add(driver);
    }

    public Integer startWork() {
        do {
            driversTellGossips();
            bussesDrive();
            this.iterations++;
            if (isNoChanceDriversLearnAllGossip()) {
                return -1;
            }
        } while (allDriverDontKnowAllGosips());

        return this.iterations;
    }

    private boolean isNoChanceDriversLearnAllGossip() {
        boolean allDriversHaveRouteSameLength = allDriversHaveRouteSameLength();

        if (allDriversHaveRouteSameLength && this.iterations > getRouteLength()) {
            return true;
        }
        if (this.iterations > MAX_LAPS) {
            return true;
        }

        return false;
    }

    private Integer getRouteLength() {
        if (this.drivers.isEmpty()) {
            return 0;
        }
        return this.drivers.iterator().next().getRouteLength();
    }

    private boolean allDriversHaveRouteSameLength() {
        int routeLength = 0;

        for (BusDriver driver : this.drivers) {
            if (driver.getRouteLength() != routeLength) {
                if (routeLength == 0) {
                    routeLength = driver.getRouteLength();
                } else {
                    return false;
                }
            }

        }
        return true;
    }

    private void bussesDrive() {
        for (BusDriver driver : this.drivers) {
            driver.drive();
        }
    }

    private void driversTellGossips() {
        for (BusDriver driver : this.drivers) {
            for (BusDriver busDriver : this.drivers) {
                if (driver.notSame(busDriver) && driver.inSameStop(busDriver)) {
                    talk(driver, busDriver);
                }
            }
        }
    }

    private void talk(BusDriver driver, BusDriver busDriver) {
        driver.learnGossipOf(busDriver);
        busDriver.learnGossipOf(driver);
    }

    private boolean allDriverDontKnowAllGosips() {
        for (BusDriver driver : this.drivers) {
            if (driver.knowNumSecrets() != this.drivers.size()) {
                return true;
            }
        }
        return false;
    }
}
