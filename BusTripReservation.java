public class BusTripReservation {
    public BusTripReservation(String trip_number, int passenger_id) {
        this.trip_number = trip_number;
        this.passenger_id = passenger_id;
    }

    public String getTrip_number() {
        return trip_number;
    }

    public void setTrip_number(String trip_number) {
        this.trip_number = trip_number;
    }

    public int getPassenger_id() {
        return passenger_id;
    }

    public void setPassenger_id(int passenger_id) {
        this.passenger_id = passenger_id;
    }

    private String trip_number;
    private int passenger_id;
}
