import javax.crypto.Mac;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class SystemManager {
    private String input,output;
    private ArrayList<Passenger> passengers;
    private ArrayList<Train> trains;
    private ArrayList<Bus> busses;
    private ArrayList<Station> stations;
    private ArrayList<Machinist> machinists;
    private ArrayList<Driver> drivers;
    private ArrayList<TrainTrip> trainTrips;
    private ArrayList<BusTrip> busTrips;
    private ArrayList<TrainTripReservation> trainTripReservations;
    private ArrayList<BusTripReservation> busTripReservations;

    public SystemManager(String input,String output){
        passengers = new ArrayList<Passenger>();
        trains = new ArrayList<Train>();
        busses = new ArrayList<Bus>();
        stations = new ArrayList<Station>();
        machinists = new ArrayList<Machinist>();
        drivers = new ArrayList<Driver>();
        trainTrips = new ArrayList<TrainTrip>();
        busTrips = new ArrayList<BusTrip>();
        trainTripReservations = new ArrayList<TrainTripReservation>();
        busTripReservations = new ArrayList<BusTripReservation>();
        this.input = input;
        this.output = output;
    }
    public void Run(){
        try {
            BufferedReader br = new BufferedReader(new FileReader(input));
            String line = br.readLine();
            while (line!=null){
                RunCommand(line);
                line = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean PassengerExists(int id){
        for (Passenger p:passengers){
            if(p.getId()==id){
                return true;
            }
        }
        return false;
    }
    private Passenger SearchPassenger(int id){
        for (Passenger p:passengers){
            if(p.getId()==id){
                return p;
            }
        }
        return null;
    }
    private boolean TrainExists(String name){
        for (Train t:trains){
            if(t.getName().equalsIgnoreCase(name)){
                return true;
            }
        }
        return false;
    }
    private boolean BusExists(String plate){
        for (Bus b: busses){
            if(b.getPlate().equalsIgnoreCase(plate)){
                return true;
            }
        }
        return false;
    }
    private boolean MachinistExists(int corporate_id){
        for (Machinist m: machinists){
            if (m.getCorporate_id()==corporate_id){
                return true;
            }
        }
        return false;
    }
    private Machinist SearchMachinist(int corporate_id){
        for (Machinist m: machinists){
            if (m.getCorporate_id()==corporate_id){
                return m;
            }
        }
        return null;
    }
    private boolean StationExists(String stationName){
        for (Station s:stations){
            if (s.getName().equalsIgnoreCase(stationName)){
                return true;
            }
        }
        return false;
    }
    private boolean DriverExists(int corporate_id){
        for (Driver d: drivers){
            if (d.getCorporate_id()==corporate_id){
                return true;
            }
        }
        return false;
    }
    private Driver SearchDriver(int corporate_id){
        for (Driver d: drivers){
            if (d.getCorporate_id()==corporate_id){
                return d;
            }
        }
        return null;
    }
    private boolean TrainTripExists(String trip_id,String train_name,String dep_time){
        for (TrainTrip t:trainTrips){
            if(t.getTrip_number().equalsIgnoreCase(trip_id)){
                return true;
            }
            if(t.getTrain_name().equalsIgnoreCase(train_name)&&t.getDeparture_time().equalsIgnoreCase(dep_time)){
                return true;
            }
        }
        return false;
    }
    private boolean TrainTripExists(String trip_id){
        for (TrainTrip t:trainTrips){
            if(t.getTrip_number().equalsIgnoreCase(trip_id)){
                return true;
            }
        }
        return false;
    }
    private TrainTrip SearchTrainTrip(String trip_id){
        for (TrainTrip trip:trainTrips){
            if(trip.getTrip_number().equalsIgnoreCase(trip_id)){
                return trip;
            }
        }
        return null;
    }

    private boolean BusTripExists(String trip_id,String plate,String dep_time){
        for (BusTrip t:busTrips){
            if(t.getTrip_number().equalsIgnoreCase(trip_id)){
                return true;
            }
            if(t.getBus_plate().equalsIgnoreCase(plate)&&t.getDeparture_time().equalsIgnoreCase(dep_time)){
                return true;
            }
        }
        return false;
    }
    private boolean BusTripExists(String trip_id){
        for (BusTrip t:busTrips){
            if(t.getTrip_number().equalsIgnoreCase(trip_id)){
                return true;
            }
        }
        return false;
    }
    private BusTrip SearchBusTrip(String trip_id){
        for (BusTrip trip:busTrips){
            if(trip.getTrip_number().equalsIgnoreCase(trip_id)){
                return trip;
            }
        }
        return null;
    }
    private TrainTripReservation SearchTrainTripReservation(String trip_id,int pas_id){
        for (TrainTripReservation res:trainTripReservations){
            if(res.getPassenger_id()==pas_id&&res.getTrip_number().equalsIgnoreCase(trip_id)){
                return res;
            }
        }
        return null;
    }

    private BusTripReservation SearchBusTripReservation(String trip_id,int pas_id){
        for (BusTripReservation res:busTripReservations){
            if(res.getPassenger_id()==pas_id&&res.getTrip_number().equalsIgnoreCase(trip_id)){
                return res;
            }
        }
        return null;
    }
    public void Print(String line,String command){
        try {
            FileOutputStream fos = new FileOutputStream(output,true);
            fos.write(command.replace(',',' ').getBytes("UTF-8"));
            fos.write(("\n\n"+line+"\n\n").getBytes("UTF-8"));
            fos.write("--------------------------------------------------------------------------------\n".getBytes("UTF-8"));
            fos.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(command.replace(',',' '));
        System.out.println();
        System.out.println(line);
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------");
    }
    public void RunCommand(String command){
        if(command.isEmpty()||command.isBlank()){
            return;
        }
        else{
            String[] data = command.split(",");
            if (command.startsWith("ADDPASSENGER")){
                int id = Integer.parseInt(data[1]);
                String name = data[2];
                String gender = data[3];
                int age = Integer.parseInt(data[4]);
                String phone = data[5];
                if(!PassengerExists(id)){
                    passengers.add(new Passenger(id,age,name,gender,phone));
                    Print(String.format("Added Passenger\nPassenger id : %d\nPassenger name : %s",id,name),command);
                }
                else{
                    Print(String.format("Command Failed\nPassenger id : %d",id),command);
                }
            }
            else if(command.startsWith("ADDTRAINTRIP")){
                String train_trip_number = (data[1]);
                String dep_station_name = data[2];
                String arr_station_name = data[3];
                String dep_Time = data[4];
                int machinist_corp_id = Integer.parseInt(data[5]);
                String train_name = data[6];
                if(!TrainTripExists(train_trip_number,train_name,dep_Time)&&MachinistExists(machinist_corp_id)&&TrainExists(train_name)&&!dep_station_name.equalsIgnoreCase(arr_station_name)
                        &&StationExists(dep_station_name)&&StationExists(arr_station_name)){
                    trainTrips.add(new TrainTrip(train_trip_number,dep_Time,dep_station_name,arr_station_name,train_name,machinist_corp_id));
                    Machinist m = SearchMachinist(machinist_corp_id);
                    Print(String.format("Added train trip\nTrip number : %s\nMachinist name : %s",train_trip_number,m.getName()),command);
                }
                else{
                    Print(String.format("Command Failed\nTrip number : %s",train_trip_number),command);
                }

            }
            else if(command.startsWith("ADDTRAIN")){
                String name = data[1];
                String type = data[2];
                int age = Integer.parseInt(data[3]);
                int speed = Integer.parseInt(data[4]);
                int bed_capacity = Integer.parseInt(data[5]);
                if(!TrainExists(name)){
                    trains.add(new Train(name,type,age,speed,bed_capacity));
                    Print(String.format("Added Train\nTrain name : %s",name),command);
                }
                else{
                    Print(String.format("Command Failed\nTrain name : %s",name),command);
                }
            }
            else if(command.startsWith("ADDBUSTRIP")){
                String trip_number = (data[1]);
                String dep_station_name = data[2];
                String arr_station_name = data[3];
                String dep_Time = data[4];
                int driver_corp_id = Integer.parseInt(data[5]);
                String bus_plate = data[6];
                if(!BusTripExists(trip_number,bus_plate,dep_Time)&&DriverExists(driver_corp_id)&&BusExists(bus_plate)&&!dep_station_name.equalsIgnoreCase(arr_station_name)
                &&StationExists(dep_station_name)&&StationExists(arr_station_name)){
                    busTrips.add(new BusTrip(trip_number,dep_Time,dep_station_name,arr_station_name,driver_corp_id,bus_plate));
                    Driver driver = SearchDriver(driver_corp_id);
                    Print(String.format("Added Bus Trip\nTrip number: %s\nDriver name : %s",trip_number,driver.getName()),command);
                }
                else{
                    Print(String.format("Command Failed\nTrip number : %s",trip_number),command);
                }

            }
            else if(command.startsWith("ADDBUS")){
                String plate = data[1];
                int age = Integer.parseInt(data[2]);
                int speed = Integer.parseInt(data[3]);
                int seat_capacity = Integer.parseInt(data[4]);
                if(!BusExists(plate)){
                    busses.add(new Bus(plate,age,speed,seat_capacity));
                    Print(String.format("Added Bus\nBus plate : %s",plate),command);
                }
                else{
                    Print(String.format("Command Failed\nBus Plate : %s",plate),command);
                }
            }
            else if(command.startsWith("ADDSTATION")){
                String name = data[1];
                stations.add(new Station(name));
                Print(String.format("Added Station\nStation name : %s",name),command);
            }
            else if(command.startsWith("ADDMACHINIST")){
                int corporate_id = Integer.parseInt(data[1]);
                String name = data[2];
                String gender = data[3];
                int age = Integer.parseInt(data[4]);
                int years_worked = Integer.parseInt(data[5]);
                if(!MachinistExists(corporate_id)){
                    machinists.add(new Machinist(name,gender,corporate_id,age,years_worked));
                    Print(String.format("Added Machinist\nMachinist corporate id : %d\nMachinist name : %s",corporate_id,name),command);
                }
                else{
                    Print(String.format("Command Failed\nMachinist corporate id : %d",corporate_id),command);
                }
            }
            else if(command.startsWith("SORTMACHINISTS")){
                Collections.sort(machinists);
                StringBuilder sb = new StringBuilder();
                for (Machinist m:machinists){
                    sb.append(m.toString()+"\n");
                }
                Print(sb.toString(),command);
            }
            else if(command.startsWith("ADDDRIVER")){
                int corporate_id = Integer.parseInt(data[1]);
                String name = data[2];
                String gender = data[3];
                int age = Integer.parseInt(data[4]);
                int years_worked = Integer.parseInt(data[5]);
                int license_number = Integer.parseInt(data[6]);
                if(!DriverExists(corporate_id)){
                    drivers.add(new Driver(name,gender,corporate_id,age,years_worked,license_number));
                    Print(String.format("Added Driver\nDriver corporate id : %d\nDriver name : %s",corporate_id,name),command);
                }
                else{
                    Print(String.format("Command Failed\nDriver corporate id : %d",corporate_id),command);
                }
            }
            else if(command.startsWith("SEARCHTRAINTRIP")){
                String trip_number = data[1];
                TrainTrip trip = SearchTrainTrip(trip_number);
                if(trip==null){
                    Print(String.format("Command Failed\nTrip number : %s",trip_number),command);
                }
                else{
                    Machinist m = SearchMachinist(trip.getMachinist_corporate_id());
                    Print(String.format("Trip number : %s\nDeparture station : %s\nArrival station : %s\nDeparture time : %s\nMachinist name : %s\nTrain name :%s",
                    trip.getTrip_number(),trip.getDeparture_station_name(),trip.getArrival_station_name(),trip.getDeparture_time(),m.getName(),trip.getTrain_name()),command);
                }
            }
            else if(command.startsWith("SEARCHBUSTRIP")){
                String trip_number = data[1];
                BusTrip trip = SearchBusTrip(trip_number);
                if(trip==null){
                    Print(String.format("Command Failed\nTrip number : %s",trip_number),command);
                }
                else{
                    Driver d = SearchDriver(trip.getDriver_corporate_time());
                    Print(String.format("Trip number : %s\nDeparture station : %s\nArrival station : %s\nDeparture time : %s\nDriver name : %s\nBus plate :%s",
                            trip.getTrip_number(),trip.getDeparture_station_name(),trip.getArrival_station_name(),trip.getDeparture_time(),d.getName(),trip.getBus_plate()),command);
                }
            }
            else if(command.startsWith("TRAINTRIPRESERVATION")){
                String trip_number = (data[1]);
                int pas_id = Integer.parseInt(data[2]);
                String type = data[3];
                if(PassengerExists(pas_id)&&TrainTripExists(trip_number)){
                    trainTripReservations.add(new TrainTripReservation(trip_number,pas_id,type));
                    Passenger p = SearchPassenger(pas_id);
                    TrainTrip trip = SearchTrainTrip(trip_number);
                    Print(String.format("Added train trip reservation\nTrip number : %s\nDeparture Date/Time : %s\n" +
                            "Departure Station : %s\nPassenger name : %s\n",trip_number,trip.getDeparture_time(),trip.getDeparture_station_name(),p.getName()),command);
                }
                else{
                    Print(String.format("Command Failed\nTrip number : %s",trip_number),command);
                }
            }
            else if(command.startsWith("BUSTRIPRESERVATION")){
                String trip_number = (data[1]);
                int pas_id = Integer.parseInt(data[2]);
                if(BusTripExists(trip_number)&&PassengerExists(pas_id)){
                    busTripReservations.add(new BusTripReservation(trip_number,pas_id));
                    Passenger p = SearchPassenger(pas_id);
                    BusTrip trip = SearchBusTrip(trip_number);
                    Print(String.format("Added bus trip reservation\nTrip number : %s\nDeparture Date/Time : %s\n" +
                            "Departure Station : %s\nPassenger name : %s\n",trip_number,trip.getDeparture_time(),trip.getDeparture_station_name(),p.getName()),command);
                }
                else{
                    Print(String.format("Command Failed\nTrip number : %s",trip_number),command);
                }
            }
            else if(command.startsWith("CANCELTRAINTRIPRESERVATION")){
                String trip_number = (data[1]);
                int pas_id = Integer.parseInt(data[2]);
                TrainTripReservation reservation = SearchTrainTripReservation(trip_number,pas_id);
                if(reservation!=null)
                {
                    trainTripReservations.remove(reservation);
                }
                else{

                }
            }
            else if(command.startsWith("CANCELBUSTRIPRESERVATION")){
                String trip_number = (data[1]);
                int pas_id = Integer.parseInt(data[2]);
                BusTripReservation reservation = SearchBusTripReservation(trip_number,pas_id);
                if(reservation!=null)
                {
                    busTripReservations.remove(reservation);
                }
                else{

                }
            }
            else if(command.startsWith("DELETEPASSENGER")){
                int pas_id = Integer.parseInt(data[1]);
                if(PassengerExists(pas_id)){
                    Passenger pas = SearchPassenger(pas_id);
                    passengers.remove(pas);
                    Print(String.format("Deleted Passenger\nPassenger id : %d",pas_id),command);
                }
                else{
                    Print(String.format("Command Failed\nPassenger id : %d",pas_id),command);
                }
            }
            else if(command.startsWith("LISTALLPASSENGERS")){
                Collections.sort(passengers);
                StringBuilder sb = new StringBuilder();
                for (Passenger p:passengers){
                    sb.append("Passenger id: "+p.getId()+"\n");
                }
                Print(sb.toString(),command);
            }
            else if(command.startsWith("DELETETRAINTRIP")){
                String trip_number = data[1];
                TrainTrip trip = SearchTrainTrip(trip_number);
                if(trip!=null){
                    trainTrips.remove(trip);
                    Print(String.format("Deleted Train Trip\nTrain Trip Number : %s",trip_number),command);
                }
                else{
                    Print(String.format("Command Failed\nTrain Trip Number : %s",trip_number),command);
                }
            }
            else if(command.startsWith("DELETEBUSTRIP")){
                String trip_number = data[1];
                BusTrip trip = SearchBusTrip(trip_number);
                if(trip!=null){
                    busTrips.remove(trip);
                    Print(String.format("Deleted Bus Trip\nBus Trip Number : %s",trip_number),command);
                }
                else{
                    Print(String.format("Command Failed\nBus Trip Number : %s",trip_number),command);
                }
            }
            else{
                Print("Command Failed\nInvalid Command.",command);
                return;
            }
        }
    }
}
