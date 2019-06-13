import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            makeNoise();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void makeNoise() throws IOException, UnsupportedAudioFileException, LineUnavailableException, InterruptedException {
        Clip sound = AudioSystem.getClip();
        sound.open(AudioSystem.getAudioInputStream(new File("LOZ_Fanfare.wav")));
        sound.start();
        Thread.sleep(2000);
        sound.close();
    }
}
