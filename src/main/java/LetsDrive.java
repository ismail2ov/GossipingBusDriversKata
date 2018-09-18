import java.util.HashSet;
import java.util.Set;

public class LetsDrive {
    private Set<BusDriver> drivers = new HashSet<>();
    private Integer iterations = 0;

    public void add(BusDriver driver) {
        this.drivers.add(driver);
    }

    public Integer startWork() {
        do {
            driversTellGossips();
            bussesDrive();
            iterations++;
        } while (allDriverDontKnowAllGosips());

        return this.iterations;
    }

    private void bussesDrive() {
        for (BusDriver driver : drivers) {
            driver.drive();
        }
    }

    private void driversTellGossips() {
        for (BusDriver driver : drivers) {
            for (BusDriver busDriver : drivers) {
                if (driver.notSame(busDriver) && driver.inSameStop(busDriver)) {
                    talk(driver, busDriver);
                }
            }
        }
    }

    private void talk(BusDriver driver, BusDriver busDriver) {
        driver.learnGossipOf(busDriver);
    }

    private boolean allDriverDontKnowAllGosips() {
        for (BusDriver driver : drivers) {
            if (driver.knowNumSecrets() != drivers.size()) {
                return true;
            }
        }
        return false;
    }
}
