abstract class Carnivore extends Mammal{
    Carnivore(String gender,int age){
        super(gender, age);
    }
    void hunt() {
        this.sound();
        this.eat();
    }
}
