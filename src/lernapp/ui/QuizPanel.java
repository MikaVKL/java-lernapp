package lernapp.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import lernapp.model.Question;
import lernapp.progress.ProgressTracker;

// Der Quiz-Modus: Frage mit 4 Antwort-Buttons (gemischt), sofortiges
// Feedback inkl. Erklaerung, laufender Punktestand, Abschluss-Screen.
public class QuizPanel extends JPanel {

    private final List<Question> fullDeck; // alle Fragen, fuer den normalen Modus
    private final ProgressTracker progressTracker;
    private List<Question> questions; // aktuell aktive Fragen (kann eine gefilterte Auswahl sein)

    private int currentIndex;
    private int correctCount;

    private final JLabel questionLabel;
    private final JLabel scoreLabel;
    private final JLabel feedbackLabel;
    private final JPanel answersPanel;
    private final JPanel actionArea;

    public QuizPanel(AppWindow appWindow, List<Question> allQuestions, ProgressTracker progressTracker) {
        this.fullDeck = new ArrayList<>(allQuestions);
        this.questions = fullDeck;
        this.progressTracker = progressTracker;

        setLayout(new BorderLayout(10, 10));

        JButton backButton = new JButton("Zurück zum Menü");
        backButton.addActionListener(e -> appWindow.showMenu());

        scoreLabel = new JLabel("", SwingConstants.RIGHT);

        JPanel topBar = new JPanel(new BorderLayout());
        topBar.add(backButton, BorderLayout.WEST);
        topBar.add(scoreLabel, BorderLayout.EAST);
        add(topBar, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new BorderLayout(10, 10));
        questionLabel = new JLabel("", SwingConstants.CENTER);
        questionLabel.setFont(questionLabel.getFont().deriveFont(20f));
        centerPanel.add(questionLabel, BorderLayout.NORTH);

        answersPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        centerPanel.add(answersPanel, BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);

        JPanel southPanel = new JPanel(new BorderLayout());
        feedbackLabel = new JLabel("", SwingConstants.CENTER);
        southPanel.add(feedbackLabel, BorderLayout.NORTH);

        actionArea = new JPanel();
        southPanel.add(actionArea, BorderLayout.SOUTH);
        add(southPanel, BorderLayout.SOUTH);
    }

    // Startet das Quiz mit allen Fragen neu.
    public void startQuiz() {
        startQuiz(fullDeck);
    }

    // Startet das Quiz nur mit den uebergebenen Fragen, z.B. fuer einen
    // Themen-Filter oder gezieltes Ueben einzelner Kategorien.
    public void startQuiz(List<Question> subset) {
        questions = new ArrayList<>(subset);
        Collections.shuffle(questions);
        currentIndex = 0;
        correctCount = 0;
        showQuestion();
    }

    private void showQuestion() {
        Question q = questions.get(currentIndex);
        questionLabel.setText(htmlCenter(q.getQuestionText()));
        feedbackLabel.setText("");
        updateScoreLabel();

        List<String> options = new ArrayList<>();
        options.add(q.getCorrectAnswer());
        options.addAll(Arrays.asList(q.getDistractors()));
        Collections.shuffle(options);

        answersPanel.removeAll();
        for (String option : options) {
            JButton optionButton = new JButton(option);
            optionButton.addActionListener(e -> checkAnswer(option, q));
            answersPanel.add(optionButton);
        }
        answersPanel.revalidate();
        answersPanel.repaint();

        actionArea.removeAll();
        actionArea.revalidate();
        actionArea.repaint();
    }

    private void checkAnswer(String selected, Question q) {
        // Alle Antwort-Buttons deaktivieren, damit pro Frage nur einmal geklickt werden kann.
        for (Component c : answersPanel.getComponents()) {
            c.setEnabled(false);
        }

        boolean isCorrect = selected.equals(q.getCorrectAnswer());
        progressTracker.recordResult(q, isCorrect);
        if (isCorrect) {
            correctCount++;
            feedbackLabel.setText(htmlCenter("<b>Richtig!</b><br>" + q.getExplanation()));
        } else {
            feedbackLabel.setText(htmlCenter("<b>Falsch.</b> Richtige Antwort: " + q.getCorrectAnswer()
                    + "<br>" + q.getExplanation()));
        }
        updateScoreLabel();

        boolean isLastQuestion = currentIndex + 1 >= questions.size();
        JButton nextButton = new JButton(isLastQuestion ? "Ergebnis anzeigen" : "Weiter");
        nextButton.addActionListener(e -> nextQuestion());
        JButton searchButton = new JButton("Mehr zum Thema suchen");
        searchButton.addActionListener(e -> WebLinks.searchTopic(q.getTopic()));
        actionArea.removeAll();
        actionArea.add(nextButton);
        actionArea.add(searchButton);
        actionArea.revalidate();
        actionArea.repaint();
    }

    private void nextQuestion() {
        currentIndex++;
        if (currentIndex >= questions.size()) {
            showSummary();
        } else {
            showQuestion();
        }
    }

    private void showSummary() {
        questionLabel.setText(htmlCenter("Ergebnis: " + correctCount + " von " + questions.size() + " richtig"));
        scoreLabel.setText("");
        feedbackLabel.setText("");

        answersPanel.removeAll();
        answersPanel.revalidate();
        answersPanel.repaint();

        JButton restartButton = new JButton("Nochmal");
        restartButton.addActionListener(e -> startQuiz());
        actionArea.removeAll();
        actionArea.add(restartButton);
        actionArea.revalidate();
        actionArea.repaint();
    }

    private void updateScoreLabel() {
        scoreLabel.setText("Frage " + (currentIndex + 1) + "/" + questions.size() + "  |  Punkte: " + correctCount);
    }

    private String htmlCenter(String text) {
        return "<html><div style='text-align:center; width:400px;'>" + text + "</div></html>";
    }
}
