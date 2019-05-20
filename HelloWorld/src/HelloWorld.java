import java.awt.*;
import java.util.Random;

import static java.awt.Color.blue;

public class HelloWorld {
    public static void main(String[] args) throws InterruptedException {
        World erf = new World(1000,1000);
        Turtle bastian = new Turtle (erf);
//        Turtle thomas = new Turtle (erf);

//      all variables in Java
        int i = 0; // Number
        long l = 90001; //Long Number
        float k = 0.0f; // Number w/ Decimals
        double d = 0.0; // Number w/ Lots of Decimals
        char c = 'c'; // 1 Letter or Number or Punctuation
        String s = "new string"; // Many Letters, Numbers,and Punctuation
        boolean b = true; // True or False

//        do a barrel roll
//        bastian.forward();
//        bastian.turnLeft();
//        bastian.forward();
//        bastian.turnLeft();
//        bastian.forward();
//        bastian.turnLeft();
//        bastian.forward();


//      Tom
//        thomas.setBodyColor(Color.red);
//        thomas.setPenColor(Color.yellow);
//        thomas.penUp();
//        thomas.turnRight();
//        thomas.forward();
//        thomas.penDown();
//        thomas.setHeading(0);
//        thomas.forward();
//        thomas.turnRight();
//        thomas.forward();
//        thomas.turnRight();
//        thomas.forward();
//        thomas.turnRight();
//        thomas.forward();

        bastian.setBodyColor(Color.red);
        bastian.setPenColor(Color.blue);
        bastian.setHeading(90);
        bastian.forward(175);
        bastian.clearPath();
        for (int x = 0; x < 1000000; x++){
            Random r = new Random();
            bastian.turn(1);
            bastian.forward(3);
            Thread.sleep(1);
        };
    }
}
