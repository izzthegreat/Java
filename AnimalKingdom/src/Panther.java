abstract class Panther extends Feline {
    Panther(String gender,int age){
        super(gender, age);
    }

    @Override
    void sound() {
        super.sound();
        if (this.isAdult()) {
            System.out.println("Rawr!!!");
        } else {
            System.out.println("Meow");
        }
    }
}
