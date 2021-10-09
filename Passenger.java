public class Passenger extends Person implements Comparable  {
    private int id,age;
    private String name,gender,phoneNumber;

    public Passenger(int id, int age, String name, String gender, String phoneNumber) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Passenger){
            if (((Passenger) o).getId()>getId()){
                return 0;
            }
            else return 1;
        }
        return 0;
    }
}
