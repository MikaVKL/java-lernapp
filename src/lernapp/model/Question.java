package lernapp.model;

// Eine Frage, die sowohl als Karteikarte als auch als Multiple-Choice-Frage
// verwendet werden kann. Karteikarten nutzen nur questionText + correctAnswer,
// das Quiz baut daraus zusätzlich 4 Antwort-Buttons (correctAnswer + distractors).
public class Question {

    private final String topic;
    private final String questionText;
    private final String correctAnswer;
    private final String explanation;
    private final String[] distractors;

    public Question(String topic, String questionText, String correctAnswer, String explanation, String[] distractors) {
        this.topic = topic;
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.explanation = explanation;
        this.distractors = distractors;
    }

    public String getTopic() {
        return topic;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getExplanation() {
        return explanation;
    }

    public String[] getDistractors() {
        return distractors;
    }
}
