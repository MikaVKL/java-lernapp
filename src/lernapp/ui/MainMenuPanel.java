package lernapp.ui;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

// Der Startbildschirm: Titel + drei Buttons zur Auswahl des Modus.
public class MainMenuPanel extends JPanel {

    public MainMenuPanel(AppWindow appWindow) {
        setLayout(new GridLayout(4, 1, 10, 10));

        JLabel title = new JLabel("Java-Lernapp", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(28f));

        JButton flashcardsButton = new JButton("Karteikarten");
        JButton quizButton = new JButton("Quiz");
        JButton exitButton = new JButton("Beenden");

        // ActionListener: der Code, der ausgeführt wird, sobald der Button geklickt wird.
        flashcardsButton.addActionListener(e -> appWindow.showFlashcards());
        quizButton.addActionListener(e -> appWindow.showQuiz());
        exitButton.addActionListener(e -> System.exit(0));

        add(title);
        add(flashcardsButton);
        add(quizButton);
        add(exitButton);
    }
}
