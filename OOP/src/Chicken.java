public class Chicken extends Bird {
    public Chicken(int age, String gender, int weightInLbs) {
        super(age, gender, weightInLbs);
    }

    @Override
    public String toString() {
        return "Chicken{" +
                "age=" + age +
                ", gender='" + gender + '\'' +
                ", weightInLbs=" + weightInLbs +
                '}';
    }
}
