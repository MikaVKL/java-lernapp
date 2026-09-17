package lernapp;

import javax.swing.SwingUtilities;
import lernapp.ui.AppWindow;

public class Main {

    public static void main(String[] args) {
        // SwingUtilities.invokeLater sorgt dafuer, dass die Oberflaeche im
        // richtigen Swing-Thread (Event Dispatch Thread) erstellt wird.
        // Das ist die uebliche, sichere Art, eine Swing-App zu starten.
        SwingUtilities.invokeLater(() -> {
            AppWindow window = new AppWindow();
            window.setVisible(true);
        });
    }
}
