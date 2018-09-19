public class BusRoute {
    private final int[] stops;

    public BusRoute(int[] stops) {
        this.stops = stops;
    }

    public int getNumStop() {
        return this.stops.length;
    }

    public int getStopId(int stop) {
        return this.stops[stop - 1];
    }

    public int getRouteLength() {
        return this.stops.length;
    }
}