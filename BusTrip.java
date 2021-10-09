public class BusTrip extends Trip {
    private int driver_corporate_time;
    private String bus_plate;

    public BusTrip(String trip_number, String departure_time, String departure_station_name, String arrival_station_name) {
        super(trip_number, departure_time, departure_station_name, arrival_station_name);
    }

    public BusTrip(String trip_number, String departure_time, String departure_station_name, String arrival_station_name, int driver_corporate_time, String bus_plate) {
        super(trip_number, departure_time, departure_station_name, arrival_station_name);
        this.driver_corporate_time = driver_corporate_time;
        this.bus_plate = bus_plate;
    }

    public int getDriver_corporate_time() {
        return driver_corporate_time;
    }

    public void setDriver_corporate_time(int driver_corporate_time) {
        this.driver_corporate_time = driver_corporate_time;
    }

    public String getBus_plate() {
        return bus_plate;
    }

    public void setBus_plate(String bus_plate) {
        this.bus_plate = bus_plate;
    }
}
