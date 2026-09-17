package lernapp.ui;

import java.awt.CardLayout;
import javax.swing.JFrame;
import lernapp.data.QuestionBank;

// Das Hauptfenster der App. Nutzt ein CardLayout, um zwischen den drei
// "Karten" (Screens) Menü, Karteikarten und Quiz umzuschalten, ohne
// mehrere Fenster öffnen zu müssen.
public class AppWindow extends JFrame {

    private static final String CARD_MENU = "menu";
    private static final String CARD_FLASHCARDS = "flashcards";
    private static final String CARD_QUIZ = "quiz";

    private final CardLayout cardLayout;
    private final java.awt.Container cardContainer;
    private final QuestionBank questionBank;

    private FlashcardPanel flashcardPanel;
    private QuizPanel quizPanel;

    public AppWindow() {
        super("Java-Lernapp");

        this.questionBank = new QuestionBank();
        this.cardLayout = new CardLayout();
        this.cardContainer = getContentPane();
        cardContainer.setLayout(cardLayout);

        this.flashcardPanel = new FlashcardPanel(this, questionBank.getAllQuestions());
        this.quizPanel = new QuizPanel();

        cardContainer.add(new MainMenuPanel(this), CARD_MENU);
        cardContainer.add(flashcardPanel, CARD_FLASHCARDS);
        cardContainer.add(quizPanel, CARD_QUIZ);

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

    public void showQuiz() {
        cardLayout.show(cardContainer, CARD_QUIZ);
    }
}
