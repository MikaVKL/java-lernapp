package lernapp.data;

import java.util.ArrayList;
import java.util.List;
import lernapp.model.Question;

// Enthält alle Lernfragen als feste (hartcodierte) Liste.
// Willst du eigene Fragen ergänzen: einfach eine Zeile in getAllQuestions()
// kopieren und Text/Antworten/Erklärung anpassen.
public class QuestionBank {

    public List<Question> getAllQuestions() {
        List<Question> questions = new ArrayList<>();

        // --- Variablen & Datentypen ---
        questions.add(new Question("Variablen",
                "Wie deklariert man in Java eine Ganzzahl-Variable mit dem Wert 5?",
                "int zahl = 5;",
                "int ist der Datentyp für Ganzzahlen. Man schreibt Typ, Name, Gleichheitszeichen, Wert und ein Semikolon.",
                new String[] { "integer zahl = 5;", "int zahl == 5;", "Int zahl = 5" }));

        questions.add(new Question("Variablen",
                "Welcher Datentyp speichert Nachkommazahlen wie 3.14?",
                "double",
                "double speichert Kommazahlen mit doppelter Genauigkeit. int kann nur ganze Zahlen speichern.",
                new String[] { "int", "char", "boolean" }));

        questions.add(new Question("Variablen",
                "Welcher Datentyp speichert nur true oder false?",
                "boolean",
                "boolean hat genau zwei mögliche Werte: true oder false, z.B. für Ja/Nein-Zustände.",
                new String[] { "int", "String", "char" }));

        questions.add(new Question("Variablen",
                "Welcher Datentyp speichert Text wie \"Hallo\"?",
                "String",
                "String ist eine Zeichenkette (Text) und wird in Java immer mit doppelten Anführungszeichen geschrieben.",
                new String[] { "char", "text", "words" }));

        questions.add(new Question("Variablen",
                "Welcher Datentyp speichert genau ein einzelnes Zeichen wie 'A'?",
                "char",
                "char steht für 'character' und speichert genau ein Zeichen, geschrieben mit einfachen Anführungszeichen.",
                new String[] { "String", "int", "letter" }));

        // --- Operatoren & Typumwandlung ---
        questions.add(new Question("Operatoren",
                "Was ist das Ergebnis von 7 % 2 in Java?",
                "1",
                "% ist der Modulo-Operator und liefert den Rest einer Division. 7 geteilt durch 2 ist 3 Rest 1.",
                new String[] { "3", "0", "3.5" }));

        questions.add(new Question("Operatoren",
                "Welcher Operator prüft, ob zwei Werte gleich sind?",
                "==",
                "== vergleicht zwei Werte auf Gleichheit. Ein einzelnes = ist dagegen die Zuweisung eines Werts.",
                new String[] { "=", "!=", "equals" }));

        questions.add(new Question("Operatoren",
                "Wie nennt man es, wenn man einen double explizit in einen int umwandelt, z.B. (int) 3.9?",
                "Casting (Typumwandlung)",
                "Beim Casting schreibt man den Ziel-Typ in Klammern vor den Wert, um ihn in einen anderen Datentyp umzuwandeln.",
                new String[] { "Parsing", "Boxing", "Overloading" }));

        questions.add(new Question("Operatoren",
                "Was ist das Ergebnis von (int) 3.9 in Java?",
                "3",
                "Beim Casting von double zu int wird der Nachkommateil einfach abgeschnitten, nicht gerundet.",
                new String[] { "4", "3.9", "Fehler" }));

        // --- if/else & switch ---
        questions.add(new Question("Bedingungen",
                "Welches Schlüsselwort leitet eine Alternative zu if ein?",
                "else",
                "else führt den Codeblock aus, wenn die Bedingung im if nicht zutrifft.",
                new String[] { "elseif", "then", "otherwise" }));

        questions.add(new Question("Bedingungen",
                "Womit vergleicht man mehrere feste Werte einer Variable übersichtlich, statt vielen if/else?",
                "switch",
                "switch prüft eine Variable gegen mehrere case-Werte und ist übersichtlicher als viele verschachtelte if/else.",
                new String[] { "loop", "compare", "match" }));

        questions.add(new Question("Bedingungen",
                "Welches Schlüsselwort beendet einen switch-Fall, damit nicht der nächste Fall mitläuft?",
                "break",
                "Ohne break würde die Ausführung in den nächsten case-Block 'durchfallen' (fall-through).",
                new String[] { "stop", "end", "exit" }));

        // --- Schleifen ---
        questions.add(new Question("Schleifen",
                "Welche Schleife eignet sich am besten, wenn man die Anzahl der Durchläufe vorher kennt?",
                "for-Schleife",
                "Die for-Schleife bündelt Startwert, Bedingung und Schrittweite in einer Zeile - ideal bei bekannter Anzahl.",
                new String[] { "while-Schleife", "do-while-Schleife", "if-Schleife" }));

        questions.add(new Question("Schleifen",
                "Welche Schleife führt ihren Rumpf garantiert mindestens einmal aus?",
                "do-while-Schleife",
                "Bei do-while wird die Bedingung erst NACH dem ersten Durchlauf geprüft, daher läuft sie immer mindestens einmal.",
                new String[] { "for-Schleife", "while-Schleife", "switch-Schleife" }));

        questions.add(new Question("Schleifen",
                "Wie lautet der Kopf einer for-Schleife, die 5-mal läuft (i von 0 bis 4)?",
                "for (int i = 0; i < 5; i++)",
                "Start bei 0, Bedingung i < 5 (läuft solange wahr), i++ zählt nach jedem Durchlauf um 1 hoch.",
                new String[] { "for (int i = 0; i <= 5; i--)", "for (i = 0; i < 5)", "for (int i < 5; i++)" }));

        questions.add(new Question("Schleifen",
                "Welches Schlüsselwort bricht eine Schleife vorzeitig komplett ab?",
                "break",
                "break verlässt die Schleife sofort komplett, unabhängig davon wie viele Durchläufe noch übrig wären.",
                new String[] { "continue", "return", "stop" }));

        questions.add(new Question("Schleifen",
                "Welches Schlüsselwort überspringt nur den restlichen Durchlauf und macht mit dem nächsten weiter?",
                "continue",
                "continue springt direkt zur nächsten Runde der Schleife, ohne den restlichen Code im aktuellen Durchlauf auszuführen.",
                new String[] { "break", "skip", "next" }));

        // --- Arrays ---
        questions.add(new Question("Arrays",
                "Wie erstellt man in Java ein int-Array mit 5 Plätzen?",
                "int[] zahlen = new int[5];",
                "Typ mit eckigen Klammern, Name, dann new und nochmal Typ mit der gewünschten Größe in eckigen Klammern.",
                new String[] { "int zahlen[5];", "Array<int> zahlen = new Array(5);", "int[5] zahlen;" }));

        questions.add(new Question("Arrays",
                "Welchen Index hat das erste Element eines Java-Arrays?",
                "0",
                "Java-Arrays sind nullbasiert - das erste Element liegt an Index 0, das letzte an Index (length - 1).",
                new String[] { "1", "-1", "Es gibt keinen Index" }));

        questions.add(new Question("Arrays",
                "Wie ermittelt man die Länge eines Arrays namens zahlen?",
                "zahlen.length",
                "length ist bei Arrays ein Attribut (kein Methodenaufruf, also ohne Klammern) und liefert die Anzahl der Plätze.",
                new String[] { "zahlen.length()", "zahlen.size()", "length(zahlen)" }));

        // --- Methoden ---
        questions.add(new Question("Methoden",
                "Wie nennt man die Werte, die man beim Aufruf an eine Methode übergibt?",
                "Parameter",
                "Parameter sind die Eingabewerte, die eine Methode in Klammern entgegennimmt, um damit zu arbeiten.",
                new String[] { "Attribute", "Variablen", "Konstanten" }));

        questions.add(new Question("Methoden",
                "Welches Schlüsselwort gibt einen Wert aus einer Methode zurück?",
                "return",
                "return beendet die Methode sofort und übergibt den angegebenen Wert an die aufrufende Stelle zurück.",
                new String[] { "give", "yield", "output" }));

        questions.add(new Question("Methoden",
                "Was bedeutet es, wenn eine Methode den Rückgabetyp void hat?",
                "Sie gibt keinen Wert zurück",
                "void bedeutet 'leer' - die Methode führt Code aus, liefert aber keinen Wert an den Aufrufer zurück.",
                new String[] { "Sie gibt immer null zurück", "Sie gibt eine leere Zeichenkette zurück", "Sie ist fehlerhaft" }));

        // --- OOP-Grundlagen ---
        questions.add(new Question("OOP",
                "Wie nennt man die 'Blaupause', aus der Objekte erstellt werden?",
                "Klasse",
                "Eine Klasse beschreibt, welche Attribute und Methoden ihre Objekte haben - wie ein Bauplan.",
                new String[] { "Methode", "Instanz", "Paket" }));

        questions.add(new Question("OOP",
                "Wie nennt man ein konkretes Exemplar, das aus einer Klasse erzeugt wurde?",
                "Objekt (Instanz)",
                "Ein Objekt entsteht, wenn man mit new eine Klasse 'instanziiert' - es hat eigene Werte für die Attribute.",
                new String[] { "Konstruktor", "Attribut", "Interface" }));

        questions.add(new Question("OOP",
                "Wie heißt die spezielle Methode, die beim Erstellen eines Objekts mit new automatisch aufgerufen wird?",
                "Konstruktor",
                "Der Konstruktor hat denselben Namen wie die Klasse und initialisiert die Attribute des neuen Objekts.",
                new String[] { "Initialisierer", "Builder", "Starter" }));

        questions.add(new Question("OOP",
                "Mit welchem Schlüsselwort erstellt man ein neues Objekt?",
                "new",
                "new reserviert Speicher für ein neues Objekt und ruft dessen Konstruktor auf.",
                new String[] { "create", "instance", "make" }));

        // --- Grundsyntax ---
        questions.add(new Question("Grundsyntax",
                "Womit leitet man in Java einen einzeiligen Kommentar ein?",
                "//",
                "Alles nach // bis zum Zeilenende wird vom Compiler ignoriert - praktisch für kurze Erklärungen im Code.",
                new String[] { "#", "<!-- -->", "/*" }));

        questions.add(new Question("Grundsyntax",
                "Womit muss (fast) jede Java-Anweisung enden?",
                "Semikolon (;)",
                "Das Semikolon markiert in Java das Ende einer Anweisung - vergisst man es, gibt es einen Compilerfehler.",
                new String[] { "Doppelpunkt (:)", "Punkt (.)", "Komma (,)" }));

        return questions;
    }
}
