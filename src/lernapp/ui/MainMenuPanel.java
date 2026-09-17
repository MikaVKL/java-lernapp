package lernapp.ui;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

// Der Startbildschirm: Titel, Themen-Filter und Buttons zur Auswahl des Modus.
public class MainMenuPanel extends JPanel {

    private static final String ALLE_THEMEN = "Alle Themen";

    public MainMenuPanel(AppWindow appWindow) {
        setLayout(new GridLayout(6, 1, 10, 10));

        JLabel title = new JLabel("Java-Lernapp", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(28f));

        JComboBox<String> topicSelector = new JComboBox<>();
        topicSelector.addItem(ALLE_THEMEN);
        for (String topic : appWindow.getAvailableTopics()) {
            topicSelector.addItem(topic);
        }

        JButton flashcardsButton = new JButton("Karteikarten");
        JButton quizButton = new JButton("Quiz");
        JButton progressButton = new JButton("Fortschritt");
        JButton exitButton = new JButton("Beenden");

        // ActionListener: der Code, der ausgeführt wird, sobald der Button geklickt wird.
        flashcardsButton.addActionListener(e -> {
            String selectedTopic = (String) topicSelector.getSelectedItem();
            if (ALLE_THEMEN.equals(selectedTopic)) {
                appWindow.showFlashcards();
            } else {
                appWindow.showFlashcardsFiltered(appWindow.getQuestionsByTopic(selectedTopic));
            }
        });
        quizButton.addActionListener(e -> {
            String selectedTopic = (String) topicSelector.getSelectedItem();
            if (ALLE_THEMEN.equals(selectedTopic)) {
                appWindow.showQuiz();
            } else {
                appWindow.showQuizFiltered(appWindow.getQuestionsByTopic(selectedTopic));
            }
        });
        progressButton.addActionListener(e -> appWindow.showProgress());
        exitButton.addActionListener(e -> System.exit(0));

        add(title);
        add(topicSelector);
        add(flashcardsButton);
        add(quizButton);
        add(progressButton);
        add(exitButton);
    }
}
