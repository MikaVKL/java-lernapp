package lernapp.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

// Der Startbildschirm: Titel, Themen-Filter und Buttons zur Auswahl des Modus.
// "Beenden" ist bewusst kleiner und von den Hauptaktionen abgesetzt.
public class MainMenuPanel extends JPanel {

    private static final String ALLE_THEMEN = "Alle Themen";

    public MainMenuPanel(AppWindow appWindow) {
        setLayout(new BorderLayout(10, 10));

        JLabel title = new JLabel("Java-Lernapp", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(28f));
        add(title, BorderLayout.NORTH);

        JComboBox<String> topicSelector = new JComboBox<>();
        topicSelector.addItem(ALLE_THEMEN);
        for (String topic : appWindow.getAvailableTopics()) {
            topicSelector.addItem(topic);
        }

        JButton flashcardsButton = new RoundedButton("Karteikarten");
        JButton quizButton = new RoundedButton("Quiz");
        JButton progressButton = new RoundedButton("Fortschritt");

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

        JPanel mainActions = new JPanel(new GridLayout(4, 1, 10, 10));
        mainActions.add(topicSelector);
        mainActions.add(flashcardsButton);
        mainActions.add(quizButton);
        mainActions.add(progressButton);
        add(mainActions, BorderLayout.CENTER);

        // "Beenden" bewusst nicht in der GridLayout-Reihe: klein, rechtsbuendig,
        // statt genauso gross wie die eigentlichen Hauptaktionen.
        JButton exitButton = new RoundedButton("Beenden");
        exitButton.addActionListener(e -> System.exit(0));
        JPanel exitRow = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        exitRow.add(exitButton);
        add(exitRow, BorderLayout.SOUTH);
    }
}
