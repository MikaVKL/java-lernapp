package lernapp.ui;

import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import javax.swing.JFrame;
import lernapp.data.QuestionBank;
import lernapp.model.Question;
import lernapp.progress.ProgressTracker;

// Das Hauptfenster der App. Nutzt ein CardLayout, um zwischen den Karten
// (Screens) Menü, Karteikarten, Quiz und Fortschritt umzuschalten, ohne
// mehrere Fenster öffnen zu müssen.
public class AppWindow extends JFrame {

    private static final String CARD_MENU = "menu";
    private static final String CARD_FLASHCARDS = "flashcards";
    private static final String CARD_QUIZ = "quiz";
    private static final String CARD_PROGRESS = "progress";

    private final CardLayout cardLayout;
    private final java.awt.Container cardContainer;
    private final QuestionBank questionBank;
    private final ProgressTracker progressTracker;
    private final List<Question> allQuestions;

    private FlashcardPanel flashcardPanel;
    private QuizPanel quizPanel;
    private ProgressPanel progressPanel;

    public AppWindow() {
        super("Java-Lernapp");

        this.questionBank = new QuestionBank();
        this.progressTracker = new ProgressTracker();
        this.allQuestions = questionBank.getAllQuestions();
        this.cardLayout = new CardLayout();
        this.cardContainer = getContentPane();
        cardContainer.setLayout(cardLayout);

        this.flashcardPanel = new FlashcardPanel(this, allQuestions, progressTracker);
        this.quizPanel = new QuizPanel(this, allQuestions, progressTracker);
        this.progressPanel = new ProgressPanel(this, allQuestions, progressTracker);

        cardContainer.add(new MainMenuPanel(this), CARD_MENU);
        cardContainer.add(flashcardPanel, CARD_FLASHCARDS);
        cardContainer.add(quizPanel, CARD_QUIZ);
        cardContainer.add(progressPanel, CARD_PROGRESS);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 450);
        setLocationRelativeTo(null); // Fenster mittig auf dem Bildschirm platzieren
    }

    public void showMenu() {
        cardLayout.show(cardContainer, CARD_MENU);
    }

    public void showFlashcards() {
        flashcardPanel.startDeck();
        cardLayout.show(cardContainer, CARD_FLASHCARDS);
    }

    public void showFlashcardsFiltered(List<Question> subset) {
        flashcardPanel.startDeck(subset);
        cardLayout.show(cardContainer, CARD_FLASHCARDS);
    }

    public void showQuiz() {
        quizPanel.startQuiz();
        cardLayout.show(cardContainer, CARD_QUIZ);
    }

    public void showQuizFiltered(List<Question> subset) {
        quizPanel.startQuiz(subset);
        cardLayout.show(cardContainer, CARD_QUIZ);
    }

    public void showProgress() {
        progressPanel.refresh();
        cardLayout.show(cardContainer, CARD_PROGRESS);
    }

    // Liefert alle vorkommenden Themen (z.B. "Schleifen", "OOP"), alphabetisch
    // sortiert und ohne Duplikate - fuer den Themen-Filter im Hauptmenue.
    public List<String> getAvailableTopics() {
        return new ArrayList<>(new TreeSet<>(allQuestions.stream().map(Question::getTopic).toList()));
    }

    // Liefert alle Fragen zu einem bestimmten Thema.
    public List<Question> getQuestionsByTopic(String topic) {
        List<Question> result = new ArrayList<>();
        for (Question question : allQuestions) {
            if (question.getTopic().equals(topic)) {
                result.add(question);
            }
        }
        return result;
    }
}
