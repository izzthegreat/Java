import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import static javax.sound.sampled.AudioSystem.getClip;

public class Main extends Application {
    Stage window;
    Button button;
    Image wheel, logo, arrow;
    Clip audio;
    private static ArrayList<String> wheelList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        loadWheel();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        audio = getClip();

        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(e -> System.exit(0));
        Menu game = new Menu("Game");
        game.getItems().add(exit);
        MenuBar mainMenu = new MenuBar(game);

        wheel = new Image("WoFWheel.png");
        ImageView wheelView = new ImageView();
        wheelView.setImage(wheel);
        wheelView.setPreserveRatio(true);
        wheelView.setFitHeight(250);

        arrow = new Image("arrow.png");
        ImageView arrowView = new ImageView();
        arrowView.setImage(arrow);
        arrowView.setPreserveRatio(true);
        arrowView.setFitHeight(50);



//        logo = new Image("WOFLogo.png");
//        ImageView logoView = new ImageView();
//        logoView.setImage(logo);
//        logoView.setPreserveRatio(true);
//        logoView.toFront();

        window = primaryStage;
        window.setTitle("Wheel Of Fortune");
        Text spinResult = new Text();
        spinResult.setTextAlignment(TextAlignment.CENTER);

        button = new Button();
        button.setText("Spin");
//        button.setOnAction(e->{
//            if (audio.isOpen()){audio.close();}
//            int degrees = new Random().nextInt(360);
//            try {
//                audio.open(AudioSystem.getAudioInputStream(new File("audio/WheelSpin.wav")));
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//            rotate.setByAngle(720+degrees);
//            audio.start();
//            rotate.play();
//            spinResult.setText(wheelList.get((int)Math.floor(degrees/15)));
//        });

        RotateTransition rotate = new RotateTransition(Duration.seconds(4), wheelView);
        rotate.setToAngle(0);
        rotate.setCycleCount(1);
        button.setOnAction(event -> {
            if (audio.isOpen()){audio.close();}
            try {
                audio.open(AudioSystem.getAudioInputStream(new File("audio/WheelSpin.wav")));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            double r = new Random().nextInt(24);
            rotate.setFromAngle(rotate.getToAngle() % 360);
            rotate.setToAngle(rotate.getFromAngle() + r * 15 + 1440);
            rotate.play();
            audio.start();
            System.out.println(rotate.getToAngle() % 360 / 15);
            spinResult.setText(wheelList.get((int)rotate.getToAngle() % 360 / 15));
        });

        GridPane layout = new GridPane();
        VBox box = new VBox(mainMenu, layout);
        layout.setAlignment(Pos.CENTER);
        layout.setGridLinesVisible(true);
        layout.add(button,2,5);
//        layout.add(logoView, 2,2);
        layout.add(arrowView, 2, 1);
        layout.add(wheelView,0,2,3,3);
        layout.add(spinResult, 1, 0,3,1);


        Scene scene = new Scene(box, 300, 400);
        window.setScene(scene);
        window.show();
    }
    private static void loadWheel() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Wheel.txt"));
        for(int i = 0; i < 24; i++) {
            wheelList.add(reader.readLine());
        }
    }
}
