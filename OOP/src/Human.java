public class Human extends Animal {

    String name;
    int age;
    int heightInInches;
    String eyeColor;
    boolean adult;

    // constructor method
    public Human (int age, String gender, int weightInLbs){
        super(age,gender, weightInLbs);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeightInInches() {
        return heightInInches;
    }

    public void setHeightInInches(int heightInInches) {
        this.heightInInches = heightInInches;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public boolean isAdult() {
        if (age < 21) {
            adult = false;
        } else {
            adult = true;
        }
        return adult;
    }

    public void speak(){
        System.out.println("Hello my name is " + name);
        System.out.println("I am " + heightInInches + " inches tall.");
        System.out.println("I am " + age + " years old.");
        System.out.println("My eye color is " + eyeColor);
    }

    public void move (){
        System.out.println("walking...");
    }

    public void work (){
        System.out.println("working");
    }
}
