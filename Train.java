public class Train extends Vehicle {
    public Train(String name, String type, int age, int speed, int bedCapacity) {
        this.name = name;
        this.type = type;
        this.age = age;
        this.speed = speed;
        this.bedCapacity = bedCapacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public int getBedCapacity() {
        return bedCapacity;
    }

    public void setBedCapacity(int bedCapacity) {
        this.bedCapacity = bedCapacity;
    }

    private String name,type;
    private int age,speed,bedCapacity;
}
