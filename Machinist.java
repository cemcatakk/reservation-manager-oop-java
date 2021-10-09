public class Machinist extends Captain implements Comparable {


    public Machinist(String name, String gender, int corporate_id, int age, int years_worked) {
        super(name, gender, corporate_id, age, years_worked);
    }

    @Override
    public String toString() {
        return getCorporate_id()+","+getName()+","+getGender()+","+getAge()+","+getYears_worked();
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Machinist){
            if(((Machinist) o).getYears_worked()<getYears_worked()){
                return 1;
            }
            else return 0;
        }
        else return 0;
    }
}
