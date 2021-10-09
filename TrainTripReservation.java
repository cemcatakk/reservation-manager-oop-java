public class TrainTripReservation {
    public TrainTripReservation(String trip_number, int passenger_id) {
        this.trip_number = trip_number;
        this.passenger_id = passenger_id;
    }
    public TrainTripReservation(String trip_number, int passenger_id,String type) {
        this.trip_number = trip_number;
        this.passenger_id = passenger_id;
        this.type=type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String type;

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
