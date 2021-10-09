public class TrainTrip extends Trip {
    public TrainTrip(String trip_number, String departure_time, String departure_station_name, String arrival_station_name) {
        super(trip_number, departure_time, departure_station_name, arrival_station_name);
    }

    public TrainTrip(String trip_number, String departure_time, String departure_station_name, String arrival_station_name, String train_name, int machinist_corporate_id) {
        super(trip_number, departure_time, departure_station_name, arrival_station_name);
        this.train_name = train_name;
        this.machinist_corporate_id = machinist_corporate_id;
    }

    public String getTrain_name() {
        return train_name;
    }

    public void setTrain_name(String train_name) {
        this.train_name = train_name;
    }

    public int getMachinist_corporate_id() {
        return machinist_corporate_id;
    }

    public void setMachinist_corporate_id(int machinist_corporate_id) {
        this.machinist_corporate_id = machinist_corporate_id;
    }

    private String train_name;
    private int machinist_corporate_id;

}
