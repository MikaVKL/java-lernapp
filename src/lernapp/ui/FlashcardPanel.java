package lernapp.ui;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import lernapp.model.Question;
import lernapp.progress.ProgressTracker;

// Der Karteikarten-Modus: Frage zeigen -> Antwort zeigen -> selbst bewerten
// (wusste ich / wusste ich nicht) -> naechste Karte -> Zusammenfassung.
public class FlashcardPanel extends JPanel {

    private final List<Question> fullDeck; // alle Fragen, fuer den normalen Modus
    private final ProgressTracker progressTracker;
    private List<Question> questions; // aktuell aktiver Stapel (kann eine gefilterte Auswahl sein)

    private int currentIndex;
    private int knownCount;

    private final JLabel questionLabel;
    private final JPanel actionArea; // wechselnder Bereich unten (Buttons je nach Zustand)

    public FlashcardPanel(AppWindow appWindow, List<Question> allQuestions, ProgressTracker progressTracker) {
        this.fullDeck = new ArrayList<>(allQuestions);
        this.progressTracker = progressTracker;
        this.questions = fullDeck;

        setLayout(new BorderLayout(10, 10));

        JButton backButton = new JButton("Zurück zum Menü");
        backButton.addActionListener(e -> appWindow.showMenu());
        add(backButton, BorderLayout.NORTH);

        questionLabel = new JLabel("", SwingConstants.CENTER);
        questionLabel.setFont(questionLabel.getFont().deriveFont(20f));
        add(questionLabel, BorderLayout.CENTER);

        actionArea = new JPanel();
        add(actionArea, BorderLayout.SOUTH);
    }

    // Startet den vollen Kartenstapel neu (normaler Karteikarten-Modus).
    public void startDeck() {
        startDeck(fullDeck);
    }

    // Startet einen Kartenstapel nur mit den uebergebenen Fragen, z.B. fuer
    // gezieltes Ueben einzelner Kategorien aus dem Fortschritts-Screen.
    public void startDeck(List<Question> subset) {
        questions = new ArrayList<>(subset);
        Collections.shuffle(questions);
        currentIndex = 0;
        knownCount = 0;
        showQuestion();
    }

    private void showQuestion() {
        Question q = questions.get(currentIndex);
        questionLabel.setText(htmlCenter(q.getQuestionText()));

        JButton showAnswerButton = new JButton("Antwort zeigen");
        showAnswerButton.addActionListener(e -> showAnswer());
        setActionArea(showAnswerButton);
    }

    private void showAnswer() {
        Question q = questions.get(currentIndex);
        questionLabel.setText(htmlCenter(q.getQuestionText()
                + "<br><br><b>Antwort:</b> " + q.getCorrectAnswer()
                + "<br><br><i>" + q.getExplanation() + "</i>"));

        JButton knewButton = new JButton("Wusste ich");
        JButton didNotKnowButton = new JButton("Wusste ich nicht");
        JButton searchButton = new JButton("Mehr zum Thema suchen");
        knewButton.addActionListener(e -> {
            knownCount++;
            progressTracker.recordResult(q, true);
            nextCard();
        });
        didNotKnowButton.addActionListener(e -> {
            progressTracker.recordResult(q, false);
            nextCard();
        });
        searchButton.addActionListener(e -> WebLinks.searchTopic(q.getTopic()));
        setActionArea(knewButton, didNotKnowButton, searchButton);
    }

    private void nextCard() {
        currentIndex++;
        if (currentIndex >= questions.size()) {
            showSummary();
        } else {
            showQuestion();
        }
    }

    private void showSummary() {
        questionLabel.setText(htmlCenter("Ergebnis: " + knownCount + " von " + questions.size() + " gewusst"));

        JButton restartButton = new JButton("Nochmal");
        restartButton.addActionListener(e -> startDeck());
        setActionArea(restartButton);
    }

    // Ersetzt die Buttons im unteren Bereich durch die uebergebenen.
    private void setActionArea(JButton... buttons) {
        actionArea.removeAll();
        for (JButton button : buttons) {
            actionArea.add(button);
        }
        actionArea.revalidate();
        actionArea.repaint();
    }

    private String htmlCenter(String text) {
        return "<html><div style='text-align:center; width:400px;'>" + text + "</div></html>";
    }
}
