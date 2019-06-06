public class Zoo {
    public static void main (String [] args) {

        Fish dory = new Fish(15, "Female", 6);
        Bird ieyago = new Bird(7,"Male", 5);
        Chicken foghornLeghorn = new Chicken(35, "Male", 150);
        Sparrow tweetyBird = new Sparrow(6, "Male", 3);

        moveAnimals(tweetyBird);
        moveAnimals(dory);
        moveAnimals(ieyago);
        moveAnimals(foghornLeghorn);
        System.out.println(foghornLeghorn.toString());
    }

    public static void moveAnimals (Animal animal){
        animal.move();
    }
}
