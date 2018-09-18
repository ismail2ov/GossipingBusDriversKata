import java.util.HashSet;
import java.util.Set;

public class BusDriver {
    private final BusRoute busRoute;
    private final int id;
    private int stop;
    private Set<Gossip> knowGossips = new HashSet<>();
    private Gossip myGossip;

    public BusDriver(int id, BusRoute busRoute) {
        this.id = id;
        this.busRoute = busRoute;
        this.stop = 1;
        this.myGossip = new Gossip(this.id);
        this.knowGossips.add(this.myGossip);
    }

    public void drive() {
        this.stop++;
        if (this.stop > this.busRoute.getNumStop()) {
            this.stop = 1;
        }
    }

    public Integer knowNumSecrets() {
        return this.knowGossips.size();
    }

    public boolean notSame(BusDriver busDriver) {
        return this.getId() != busDriver.getId();
    }

    private int getId() {
        return this.id;
    }

    public boolean inSameStop(BusDriver busDriver) {
        return this.getCurrentStop() == busDriver.getCurrentStop();
    }

    private int getCurrentStop() {
        return this.busRoute.getStopId(this.stop);
    }

    public void learnGossipOf(BusDriver busDriver) {
        for (Gossip gossip : busDriver.getKnownGossips()) {
            if (!this.knowGossips.contains(gossip)) {
                this.knowGossips.add(gossip);
            }
        }
    }

    private Set<Gossip> getKnownGossips() {
        return this.knowGossips;
    }

    private void addGossip(Gossip gossip) {
        this.knowGossips.add(gossip);

    }

    private Gossip getGossip() {
        return this.myGossip;
    }
}
