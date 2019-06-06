public class Earth {
    public static void main (String [] args) {
        Human tom;
        tom = new Human(5, "Male", 60);
        tom.setEyeColor("brown");
        tom.setHeightInInches(72);
        tom.setName("Tom Zsabo");
        tom.speak();

        Human joe = new Human(35, "Male", 240);
        joe.setName("Joe Namath");
        joe.setEyeColor("blue");
        joe.setHeightInInches(84);
        joe.speak();
        System.out.println(joe.isAdult());
    }
}
