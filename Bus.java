public class Bus extends Vehicle {
    private String plate;
    private int age,speed,seatCapacity;

    public Bus(String plate, int age, int speed, int seatCapacity) {
        this.plate = plate;
        this.age = age;
        this.speed = speed;
        this.seatCapacity = seatCapacity;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(int seatCapacity) {
        this.seatCapacity = seatCapacity;
    }
}
