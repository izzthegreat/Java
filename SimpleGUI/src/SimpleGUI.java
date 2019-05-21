import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleGUI {
    private static class ThingPanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawString("This is a thing.", 20, 30);
        }
    }

    private static class ButtonThingy implements ActionListener {
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }

    public static void main (String [] args) {
        ThingPanel thingyDisplay = new ThingPanel();
        JButton okThingy = new JButton("You'll never defeat me!!!");
        ButtonThingy listenerThingy = new ButtonThingy();
        okThingy.addActionListener(listenerThingy);

        JPanel stuff = new JPanel();
        stuff.setLayout(new BorderLayout());
        stuff.add(thingyDisplay, BorderLayout.CENTER);
        stuff.add(okThingy, BorderLayout.SOUTH);

        JFrame thingWindow = new JFrame("New Thingy");
        thingWindow.setContentPane(stuff);
        thingWindow.setSize(250, 100);
        thingWindow.setLocation(100, 100);
        thingWindow.setVisible(true);
    }
}