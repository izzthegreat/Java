package GUI;

import javax.swing.*;

public class WheelGUI {
    public static void main(String[] args) {
        newWindow();
    }

    private static void newWindow(){
        JFrame wofGUI = new JFrame();
        JMenuBar mainMenu = new JMenuBar();
        JMenu game = new JMenu("Game");
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(e -> System.exit(0));
        game.add(exit);
        mainMenu.add(game);
        wofGUI.setJMenuBar(mainMenu);
        wofGUI.setSize(400,500);
        wofGUI.setLayout(null);
        wofGUI.setVisible(true);
    }
}
