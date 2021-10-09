public class Captain extends Person {
    private String name,gender;
    private int corporate_id,age;
    private int years_worked;

    public Captain(String name, String gender, int corporate_id, int age, int years_worked) {
        this.name = name;
        this.gender = gender;
        this.corporate_id = corporate_id;
        this.age = age;
        this.years_worked = years_worked;
    }


    public int getYears_worked() {
        return years_worked;
    }

    public void setYears_worked(int years_worked) {
        this.years_worked = years_worked;
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

    public int getCorporate_id() {
        return corporate_id;
    }

    public void setCorporate_id(int corporate_id) {
        this.corporate_id = corporate_id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
