package lernapp.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import lernapp.model.Question;
import lernapp.progress.Category;
import lernapp.progress.ProgressTracker;

// Zeigt, wie viele Fragen in welcher Lern-Kategorie sind, und erlaubt es,
// gezielt nur die zuletzt falsch beantworteten Fragen zu ueben.
public class ProgressPanel extends JPanel {

    private final List<Question> allQuestions;
    private final ProgressTracker progressTracker;

    private final JLabel neuLabel;
    private final JLabel gesehenLabel;
    private final JLabel gelerntLabel;
    private final JLabel zuletztFalschLabel;
    private final JButton practiceWrongButton;

    public ProgressPanel(AppWindow appWindow, List<Question> allQuestions, ProgressTracker progressTracker) {
        this.allQuestions = allQuestions;
        this.progressTracker = progressTracker;

        setLayout(new BorderLayout(10, 10));

        JButton backButton = new RoundedButton("Zurück zum Menü");
        backButton.addActionListener(e -> appWindow.showMenu());
        add(backButton, BorderLayout.NORTH);

        JPanel countsPanel = new JPanel(new GridLayout(4, 1, 5, 5));
        neuLabel = new JLabel("", SwingConstants.CENTER);
        gesehenLabel = new JLabel("", SwingConstants.CENTER);
        gelerntLabel = new JLabel("", SwingConstants.CENTER);
        zuletztFalschLabel = new JLabel("", SwingConstants.CENTER);
        countsPanel.add(neuLabel);
        countsPanel.add(gesehenLabel);
        countsPanel.add(gelerntLabel);
        countsPanel.add(zuletztFalschLabel);
        add(countsPanel, BorderLayout.CENTER);

        practiceWrongButton = new RoundedButton("Zuletzt falsche üben");
        practiceWrongButton.addActionListener(e -> {
            List<Question> wrongQuestions = progressTracker.questionsInCategory(allQuestions, Category.ZULETZT_FALSCH);
            appWindow.showFlashcardsFiltered(wrongQuestions);
        });

        JButton resetButton = new RoundedButton("Fortschritt zurücksetzen");
        resetButton.addActionListener(e -> {
            int choice = JOptionPane.showConfirmDialog(this,
                    "Wirklich den gesamten Lernfortschritt löschen?",
                    "Fortschritt zurücksetzen",
                    JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                progressTracker.reset();
                refresh();
            }
        });

        JPanel southPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        southPanel.add(practiceWrongButton);
        southPanel.add(resetButton);
        add(southPanel, BorderLayout.SOUTH);
    }

    // Aktualisiert die Anzeige. Wird von AppWindow aufgerufen, bevor dieser
    // Screen sichtbar wird, damit die Zahlen immer aktuell sind.
    public void refresh() {
        Map<Category, Integer> counts = progressTracker.countByCategory(allQuestions);
        int total = allQuestions.size();

        neuLabel.setText("Neu: " + counts.get(Category.NEU) + " / " + total);
        gesehenLabel.setText("Gesehen: " + counts.get(Category.GESEHEN) + " / " + total);
        gelerntLabel.setText("Gelernt: " + counts.get(Category.GELERNT) + " / " + total);
        zuletztFalschLabel.setText("Zuletzt falsch: " + counts.get(Category.ZULETZT_FALSCH) + " / " + total);

        practiceWrongButton.setEnabled(counts.get(Category.ZULETZT_FALSCH) > 0);
    }
}
