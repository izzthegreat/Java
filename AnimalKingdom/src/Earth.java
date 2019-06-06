public class Earth {
    public static void main (String [] args) {
        Human Bryant = new Human("Bryant", "Male", 30);
        makeSound(Bryant);
        System.out.println(Bryant.isAdult());

        Lion simba = new Lion("Male", 1);
        makeSound(simba);
        Bryant.thumbsUp();
        System.out.println(simba.isAdult());

    }

    private static void makeSound(Animal animal) {
        animal.sound();
    }
}
