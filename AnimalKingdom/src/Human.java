class Human extends Homo {
    private String name;
    Human(String name, String gender, int age){
        super(gender, age);
        this.name = name;
        this.adultAt = 21;
    }

    @Override
    void sound() {
        System.out.println("Hi, my name is " + name);
    }

    String getName() {
        return name;
    }
}
