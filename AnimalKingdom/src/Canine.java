public abstract class Canine extends Canid {
    Canine(String gender,int age){
        super(gender, age);
    }

    @Override
    void sound() {
        super.sound();
        System.out.println("Woof!!");
    }
}
