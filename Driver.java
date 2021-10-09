public class Driver extends Captain {

    public int getLicense_number() {
        return license_number;
    }

    public void setLicense_number(int license_number) {
        this.license_number = license_number;
    }

    private int license_number;

    public Driver(String name, String gender, int corporate_id, int age, int years_worked) {
        super(name, gender, corporate_id, age, years_worked);
    }

    public Driver(String name, String gender, int corporate_id, int age, int years_worked, int license_number) {
        super(name, gender, corporate_id, age, years_worked);
        this.license_number = license_number;
    }

}
