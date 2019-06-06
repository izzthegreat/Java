public abstract class Animal {
    private int ageInYears;
    int adultAt;
    private String gender;
    Animal(String gender,int age){
        this.gender = gender;
        ageInYears = age;
    }
    void eat(){
        System.out.println("Om nom nom...");
    }
    void sleep(){
        System.out.println("Zzzzzz...");
    }
    void move(){}
    void sound(){}
    void getBusy(){
        System.out.println("Bow chicka wow wow...");
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setAge(int yearsOld) {
        this.ageInYears = yearsOld;
    }

    public int getAge() {
        return ageInYears;
    }

    boolean isAdult(){
        return ageInYears >= adultAt;
    }

}
