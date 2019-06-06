abstract class Mammal extends Vertibrate{
    Mammal(String gender, int age){
        super(gender, age);
    }

    @Override
    void move() {
        super.move();
        System.out.println("Walking...");
    }
}
