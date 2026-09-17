package lernapp.progress;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lernapp.model.Question;

// Merkt sich pro Frage, wie oft sie in Folge richtig beantwortet wurde, und
// speichert das dauerhaft in einer Textdatei, damit der Fortschritt auch
// nach dem Schliessen der App erhalten bleibt.
public class ProgressTracker {

    private static final Path STORAGE_FILE = Paths.get("progress.txt");
    private static final int STREAK_FOR_GELERNT = 2;

    // Ein Eintrag pro Frage: wie oft in Folge richtig, und war die letzte Antwort richtig.
    private static class Entry {
        int streak;
        boolean lastCorrect;
    }

    private final Map<Integer, Entry> entries = new HashMap<>();

    public ProgressTracker() {
        load();
    }

    // questionText.hashCode() ist in Java fest definiert und bleibt zwischen
    // Programmstarts stabil - deshalb eignet es sich als einfache, stabile ID.
    private int idOf(Question question) {
        return question.getQuestionText().hashCode();
    }

    public void recordResult(Question question, boolean correct) {
        Entry entry = entries.computeIfAbsent(idOf(question), id -> new Entry());
        entry.lastCorrect = correct;
        entry.streak = correct ? entry.streak + 1 : 0;
        save();
    }

    public Category getCategory(Question question) {
        Entry entry = entries.get(idOf(question));
        if (entry == null) {
            return Category.NEU;
        }
        if (!entry.lastCorrect) {
            return Category.ZULETZT_FALSCH;
        }
        if (entry.streak >= STREAK_FOR_GELERNT) {
            return Category.GELERNT;
        }
        return Category.GESEHEN;
    }

    public Map<Category, Integer> countByCategory(List<Question> allQuestions) {
        Map<Category, Integer> counts = new EnumMap<>(Category.class);
        for (Category category : Category.values()) {
            counts.put(category, 0);
        }
        for (Question question : allQuestions) {
            Category category = getCategory(question);
            counts.put(category, counts.get(category) + 1);
        }
        return counts;
    }

    public List<Question> questionsInCategory(List<Question> allQuestions, Category category) {
        List<Question> result = new ArrayList<>();
        for (Question question : allQuestions) {
            if (getCategory(question) == category) {
                result.add(question);
            }
        }
        return result;
    }

    private void load() {
        if (!Files.exists(STORAGE_FILE)) {
            return;
        }
        try (BufferedReader reader = Files.newBufferedReader(STORAGE_FILE)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length != 3) {
                    continue;
                }
                Entry entry = new Entry();
                int id = Integer.parseInt(parts[0]);
                entry.streak = Integer.parseInt(parts[1]);
                entry.lastCorrect = parts[2].equals("1");
                entries.put(id, entry);
            }
        } catch (IOException e) {
            // Falls die Datei nicht lesbar ist, starten wir einfach ohne gespeicherten Fortschritt.
        }
    }

    private void save() {
        try (BufferedWriter writer = Files.newBufferedWriter(STORAGE_FILE)) {
            for (Map.Entry<Integer, Entry> mapEntry : entries.entrySet()) {
                Entry entry = mapEntry.getValue();
                writer.write(mapEntry.getKey() + ";" + entry.streak + ";" + (entry.lastCorrect ? "1" : "0"));
                writer.newLine();
            }
        } catch (IOException e) {
            // Speichern fehlgeschlagen - der Fortschritt bleibt dann nur fuer diese Sitzung erhalten.
        }
    }
}
