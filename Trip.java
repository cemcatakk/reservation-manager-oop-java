public abstract class Trip {
    public Trip(String trip_number, String departure_time, String departure_station_name, String arrival_station_name) {
        this.trip_number = trip_number;
        this.departure_time = departure_time;
        this.departure_station_name = departure_station_name;
        this.arrival_station_name = arrival_station_name;
    }

    public String getTrip_number() {
        return trip_number;
    }

    public void setTrip_number(String trip_number) {
        this.trip_number = trip_number;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }

    public String getDeparture_station_name() {
        return departure_station_name;
    }

    public void setDeparture_station_name(String departure_station_name) {
        this.departure_station_name = departure_station_name;
    }

    public String getArrival_station_name() {
        return arrival_station_name;
    }

    public void setArrival_station_name(String arrival_station_name) {
        this.arrival_station_name = arrival_station_name;
    }

    private String trip_number;
    private String departure_time,departure_station_name,arrival_station_name;
}
