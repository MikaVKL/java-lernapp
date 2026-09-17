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

        questions.add(new Question("Variablen",
                "Welcher Datentyp speichert sehr große Ganzzahlen, größer als int erlaubt?",
                "long",
                "long hat mehr Speicherplatz als int und kann daher deutlich größere Ganzzahlen speichern.",
                new String[] { "double", "bigint", "short" }));

        questions.add(new Question("Variablen",
                "Welcher Datentyp speichert Kommazahlen mit einfacher (geringerer) Genauigkeit als double?",
                "float",
                "float braucht weniger Speicher als double, ist dafür aber ungenauer bei sehr vielen Nachkommastellen.",
                new String[] { "single", "short", "int" }));

        questions.add(new Question("Variablen",
                "Welches Schlüsselwort macht eine Variable zu einer Konstante, die nicht mehr geändert werden kann?",
                "final",
                "final vor einer Variable bedeutet: der Wert wird einmal gesetzt und kann danach nicht mehr verändert werden.",
                new String[] { "const", "static", "fixed" }));

        questions.add(new Question("Variablen",
                "Welcher Datentyp ist der kleinste Ganzzahl-Typ in Java (Werte von -128 bis 127)?",
                "byte",
                "byte belegt nur 8 Bit Speicher und eignet sich für sehr kleine Zahlenbereiche.",
                new String[] { "short", "int", "char" }));

        questions.add(new Question("Variablen",
                "Welche Schreibweise ist die übliche Namenskonvention für Variablen in Java, z.B. meineZahl?",
                "camelCase",
                "Bei camelCase beginnt der Name klein und jedes weitere Wort startet mit einem Großbuchstaben.",
                new String[] { "snake_case", "PascalCase", "kebab-case" }));

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

        questions.add(new Question("Operatoren",
                "Welcher Operator verknüpft zwei Bedingungen so, dass BEIDE wahr sein müssen?",
                "&&",
                "&& (logisches UND) ergibt nur dann true, wenn beide Seiten true sind.",
                new String[] { "||", "!", "==" }));

        questions.add(new Question("Operatoren",
                "Welcher Operator verknüpft zwei Bedingungen so, dass MINDESTENS EINE wahr sein muss?",
                "||",
                "|| (logisches ODER) ergibt true, sobald mindestens eine der beiden Bedingungen true ist.",
                new String[] { "&&", "!", "==" }));

        questions.add(new Question("Operatoren",
                "Welcher Operator kehrt einen boolean-Wert ins Gegenteil um?",
                "!",
                "! (logische Negation) macht aus true false und aus false true.",
                new String[] { "~", "not", "!=" }));

        questions.add(new Question("Operatoren",
                "Welcher Operator prüft, ob zwei Werte NICHT gleich sind?",
                "!=",
                "!= ist das Gegenstück zu ==, es ergibt true, wenn die Werte unterschiedlich sind.",
                new String[] { "==", "<>", "!" }));

        questions.add(new Question("Operatoren",
                "Welcher Operator erhöht eine Variable um genau 1?",
                "++",
                "++ ist der Inkrement-Operator, z.B. macht zahl++ aus 5 eine 6.",
                new String[] { "+1", "+=", "->" }));

        questions.add(new Question("Operatoren",
                "Welcher Operator prüft 'kleiner oder gleich'?",
                "<=",
                "<= ist wahr, wenn der linke Wert kleiner als der rechte oder genau gleich groß ist.",
                new String[] { "<", "=<", ">=" }));

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

        questions.add(new Question("Bedingungen",
                "Wie nennt man den Operator, der eine if-else-Bedingung in einer Zeile abbildet, z.B. x > 0 ? \"positiv\" : \"negativ\"?",
                "Ternärer Operator (?:)",
                "Der ternäre Operator ist eine Kurzform für if-else: Bedingung ? Wert-wenn-wahr : Wert-wenn-falsch.",
                new String[] { "Boolescher Operator", "Kurzschluss-Operator", "Bedingungsschleife" }));

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

        questions.add(new Question("Schleifen",
                "Wie lautet die erweiterte for-Schleife (for-each), um über ein Array 'zahlen' zu iterieren?",
                "for (int zahl : zahlen)",
                "Die for-each-Schleife liest jedes Element nacheinander aus, ohne dass man selbst einen Index mitzählen muss.",
                new String[] { "for (zahlen : int zahl)", "foreach (zahlen as zahl)", "for (int zahl in zahlen)" }));

        questions.add(new Question("Schleifen",
                "Wie nennt man eine Schleife, die sich komplett innerhalb einer anderen Schleife befindet?",
                "Verschachtelte Schleife",
                "Bei verschachtelten Schleifen läuft die innere Schleife bei jedem einzelnen Durchlauf der äußeren komplett durch.",
                new String[] { "Parallele Schleife", "Rekursive Schleife", "Geteilte Schleife" }));

        questions.add(new Question("Schleifen",
                "Wie nennt man eine Schleife, deren Bedingung nie falsch wird und die daher nie von selbst endet?",
                "Endlosschleife",
                "Eine Endlosschleife läuft für immer weiter, z.B. bei while(true) ohne ein break darin.",
                new String[] { "Rekursionsfehler", "Bedingungsfehler", "Deadlock" }));

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

        questions.add(new Question("Arrays",
                "Wie initialisiert man ein Array direkt mit den Werten 1, 2 und 3?",
                "int[] zahlen = {1, 2, 3};",
                "Mit geschweiften Klammern kann man ein Array bei der Deklaration sofort mit Werten füllen.",
                new String[] { "int[] zahlen = [1, 2, 3];", "int[] zahlen = new int(1,2,3);", "int[] zahlen = (1,2,3);" }));

        questions.add(new Question("Arrays",
                "Wie deklariert man in Java ein zweidimensionales int-Array (z.B. für ein 3x3-Feld)?",
                "int[][] matrix = new int[3][3];",
                "Zwei Paar eckige Klammern stehen für zwei Dimensionen, z.B. Zeilen und Spalten.",
                new String[] { "int[2][2] matrix = new int[3][3];", "Array2D matrix = new Array2D(3,3);", "int[][] matrix = new int(3,3);" }));

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

        questions.add(new Question("Methoden",
                "Wie nennt man es, wenn eine Klasse mehrere Methoden mit demselben Namen, aber unterschiedlichen Parametern hat?",
                "Methodenüberladung (Overloading)",
                "Overloading erlaubt es, denselben Methodennamen mehrfach zu verwenden, solange sich die Parameter unterscheiden.",
                new String[] { "Overriding", "Vererbung", "Polymorphismus" }));

        questions.add(new Question("Methoden",
                "Wie nennt man es, wenn eine Methode sich selbst aufruft?",
                "Rekursion",
                "Bei Rekursion ruft sich eine Methode innerhalb ihres eigenen Codes selbst auf, meist mit einer Abbruchbedingung.",
                new String[] { "Iteration", "Reflexion", "Delegation" }));

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

        questions.add(new Question("OOP",
                "Welches Schlüsselwort nutzt man, damit eine Klasse von einer anderen erbt?",
                "extends",
                "Klasse B extends Klasse A bedeutet: B übernimmt alle Attribute und Methoden von A (Vererbung).",
                new String[] { "implements", "inherits", "super" }));

        questions.add(new Question("OOP",
                "Mit welchem Schlüsselwort ruft man in einer Unterklasse den Konstruktor der Oberklasse auf?",
                "super",
                "super() ruft gezielt den Konstruktor (oder Methoden) der Elternklasse auf.",
                new String[] { "this", "base", "parent" }));

        questions.add(new Question("OOP",
                "Welche Annotation kennzeichnet, dass eine Methode eine geerbte Methode überschreibt?",
                "@Override",
                "@Override ist kein Muss, hilft aber dem Compiler, Tippfehler beim Überschreiben zu erkennen.",
                new String[] { "@Overwrite", "@Inherit", "@Super" }));

        questions.add(new Question("OOP",
                "Welcher Zugriffsmodifizierer erlaubt den Zugriff nur innerhalb derselben Klasse?",
                "private",
                "private-Felder/Methoden sind von außerhalb der Klasse nicht direkt erreichbar - deshalb nutzt man Getter/Setter.",
                new String[] { "public", "protected", "static" }));

        questions.add(new Question("OOP",
                "Welcher Zugriffsmodifizierer erlaubt den Zugriff von überall im Programm?",
                "public",
                "public-Elemente sind uneingeschränkt von jeder anderen Klasse aus erreichbar.",
                new String[] { "private", "protected", "default" }));

        questions.add(new Question("OOP",
                "Was bedeutet das Schlüsselwort static bei einer Methode oder Variable?",
                "Sie gehört zur Klasse, nicht zu einem einzelnen Objekt",
                "static-Elemente existieren nur einmal pro Klasse und werden ohne ein konkretes Objekt aufgerufen, z.B. Klasse.methode().",
                new String[] { "Sie kann nicht mehr verändert werden", "Sie ist automatisch privat", "Sie wird nur einmal ausgeführt" }));

        questions.add(new Question("OOP",
                "Wofür wird das Schlüsselwort this innerhalb einer Klasse genutzt?",
                "Um auf das aktuelle Objekt zu verweisen",
                "this verweist auf das Objekt, in dessen Methode man sich gerade befindet - nützlich z.B. bei gleichnamigen Parametern.",
                new String[] { "Um eine neue Instanz zu erstellen", "Um eine Oberklasse aufzurufen", "Um eine Methode zu beenden" }));

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

        // --- Strings ---
        questions.add(new Question("Strings",
                "Wie vergleicht man in Java den INHALT zweier Strings korrekt?",
                "text1.equals(text2)",
                "== vergleicht bei Objekten (wie String) nur, ob es dieselbe Speicherstelle ist - für den Inhalt braucht man equals().",
                new String[] { "text1 == text2", "text1 = text2", "text1.compare(text2)" }));

        questions.add(new Question("Strings",
                "Wie ermittelt man die Länge eines Strings namens text?",
                "text.length()",
                "Bei String ist length() eine Methode (mit Klammern) - im Unterschied zu length bei Arrays.",
                new String[] { "text.length", "text.size()", "length(text)" }));

        questions.add(new Question("Strings",
                "Was macht text.substring(0, 3) bei einem String?",
                "Gibt die ersten 3 Zeichen des Strings zurück",
                "substring(start, ende) liefert den Teiltext ab Index 'start' bis (ausschließlich) Index 'ende'.",
                new String[] { "Löscht die ersten 3 Zeichen", "Gibt die letzten 3 Zeichen zurück", "Zählt die Zeichen im String" }));

        questions.add(new Question("Strings",
                "Welche Methode wandelt einen String komplett in Großbuchstaben um?",
                "toUpperCase()",
                "toUpperCase() gibt eine neue Version des Strings zurück, bei der alle Buchstaben groß geschrieben sind.",
                new String[] { "toCaps()", "upperCase()", "makeUpper()" }));

        questions.add(new Question("Strings",
                "Wie verbindet man in Java zwei Strings zu einem?",
                "Mit dem + Operator",
                "z.B. \"Hallo \" + \"Welt\" ergibt \"Hallo Welt\" - der + Operator verkettet Strings.",
                new String[] { "Mit dem & Operator", "Mit .merge()", "Mit dem . Operator" }));

        // --- Exceptions ---
        questions.add(new Question("Exceptions",
                "Womit fängt man in Java einen Laufzeitfehler ab, um den Programmabbruch zu verhindern?",
                "try/catch",
                "Riskanter Code steht im try-Block, im catch-Block steht, was bei einem Fehler stattdessen passieren soll.",
                new String[] { "if/else", "switch/case", "do/while" }));

        questions.add(new Question("Exceptions",
                "Wie nennt man in Java einen Fehler, der erst zur Laufzeit auftritt, z.B. eine Division durch 0?",
                "Exception",
                "Eine Exception ('Ausnahme') ist ein Laufzeitfehler-Objekt, das man mit try/catch behandeln kann.",
                new String[] { "Warning", "Bug", "Error-Code" }));

        // --- Collections ---
        questions.add(new Question("Collections",
                "Was ist der Hauptunterschied zwischen einem Array und einer ArrayList?",
                "Eine ArrayList kann ihre Größe dynamisch ändern, ein Array hat eine feste Größe",
                "Bei einem Array muss die Größe von Anfang an feststehen, eine ArrayList wächst und schrumpft automatisch.",
                new String[] { "Ein Array kann Text speichern, eine ArrayList nicht", "Eine ArrayList ist immer schneller", "Es gibt keinen Unterschied" }));

        questions.add(new Question("Collections",
                "Wie fügt man einer ArrayList namens liste ein neues Element hinzu?",
                "liste.add(element)",
                "add() ist die Standardmethode, um ein Element am Ende einer ArrayList einzufügen.",
                new String[] { "liste.push(element)", "liste.insert(element)", "liste + element" }));

        questions.add(new Question("Collections",
                "Wie liest man das Element an Index 0 einer ArrayList namens liste aus?",
                "liste.get(0)",
                "Im Gegensatz zum Array (zahlen[0]) nutzt man bei ArrayList die Methode get(index).",
                new String[] { "liste[0]", "liste.at(0)", "liste.getIndex(0)" }));

        // --- Ein-/Ausgabe ---
        questions.add(new Question("Ein-/Ausgabe",
                "Was ist der Unterschied zwischen System.out.println() und System.out.print()?",
                "println fügt am Ende automatisch einen Zeilenumbruch hinzu, print nicht",
                "Nach println() startet die nächste Ausgabe in einer neuen Zeile, nach print() direkt dahinter.",
                new String[] { "print ist schneller", "println kann keine Zahlen ausgeben", "Es gibt keinen Unterschied" }));

        questions.add(new Question("Ein-/Ausgabe",
                "Welche Klasse nutzt man typischerweise, um Tastatur-Eingaben des Nutzers einzulesen?",
                "Scanner",
                "Scanner (aus java.util) liest z.B. mit nextInt() oder nextLine() Eingaben von der Konsole ein.",
                new String[] { "Reader", "InputBox", "Keyboard" }));

        // --- Weitere Fragen: Variablen ---
        questions.add(new Question("Variablen",
                "Wie nennt man es, wenn ein int-Wert automatisch (ohne Cast) in einen double umgewandelt wird?",
                "Implizite Typumwandlung (Widening)",
                "Von einem kleineren zu einem groesseren Datentyp wandelt Java automatisch um, ohne dass man selbst casten muss.",
                new String[] { "Explizite Typumwandlung", "Autoboxing", "Downcasting" }));

        questions.add(new Question("Variablen",
                "Welchen ungefaehren Wertebereich deckt der Datentyp int in Java ab?",
                "-2,1 bis +2,1 Milliarden",
                "int belegt 32 Bit, dadurch ergibt sich dieser feste, recht grosse Wertebereich.",
                new String[] { "0 bis 255", "-128 bis 127", "unbegrenzt" }));

        questions.add(new Question("Variablen",
                "Wie nennt man eine Variable, die innerhalb einer Methode deklariert wird?",
                "Lokale Variable",
                "Lokale Variablen existieren nur waehrend die Methode laeuft und sind ausserhalb nicht sichtbar.",
                new String[] { "Attribut", "Parameter", "Globale Variable" }));

        // --- Weitere Fragen: Operatoren ---
        questions.add(new Question("Operatoren",
                "Was berechnet der Ausdruck 10 / 3, wenn beide Operanden vom Typ int sind?",
                "3",
                "Bei einer Ganzzahl-Division wird der Nachkommateil abgeschnitten - das Ergebnis bleibt ein int.",
                new String[] { "3.33", "1", "0" }));

        questions.add(new Question("Operatoren",
                "Welcher Operator weist einer Variable einen Wert zu UND addiert gleichzeitig dazu, z.B. zahl += 5?",
                "+=",
                "zahl += 5 ist eine Kurzschreibweise fuer zahl = zahl + 5.",
                new String[] { "=+", "++", "->" }));

        questions.add(new Question("Operatoren",
                "Was ist das Ergebnis von true && false?",
                "false",
                "Bei && (logisches UND) reicht schon eine falsche Seite, damit das Gesamtergebnis false ist.",
                new String[] { "true", "Fehler", "0" }));

        // --- Weitere Fragen: Bedingungen ---
        questions.add(new Question("Bedingungen",
                "Was passiert bei einem switch, wenn kein passender case gefunden wird und kein default vorhanden ist?",
                "Nichts, der switch-Block wird einfach uebersprungen",
                "Ohne passenden case und ohne default macht das Programm einfach nach dem switch-Block weiter.",
                new String[] { "Programmabsturz", "Der erste case wird ausgefuehrt", "Kompilierfehler" }));

        questions.add(new Question("Bedingungen",
                "Welches Schluesselwort im switch faengt alle nicht extra behandelten Faelle ab?",
                "default",
                "default ist optional und wirkt wie ein 'sonst alle anderen Faelle' am Ende des switch-Blocks.",
                new String[] { "else", "otherwise", "any" }));

        // --- Weitere Fragen: Schleifen ---
        questions.add(new Question("Schleifen",
                "Wie oft laeuft folgende Schleife: for (int i = 0; i < 0; i++) { ... }?",
                "0 mal",
                "Die Bedingung i < 0 ist mit i = 0 sofort falsch, daher wird der Schleifenrumpf kein einziges Mal ausgefuehrt.",
                new String[] { "1 mal", "unendlich oft", "Fehler beim Kompilieren" }));

        questions.add(new Question("Schleifen",
                "Was passiert bei while (true) { ... break; ... }?",
                "Die Schleife laeuft, bis break erreicht wird",
                "while(true) allein waere eine Endlosschleife, aber das break im Rumpf beendet sie gezielt an dieser Stelle.",
                new String[] { "Kompilierfehler, da true kein gueltiger Ausdruck ist", "Die Schleife laeuft nie", "break wird ignoriert" }));

        // --- Weitere Fragen: Arrays ---
        questions.add(new Question("Arrays",
                "Was passiert bei zahlen[zahlen.length], wenn zahlen 5 Elemente hat?",
                "Ein ArrayIndexOutOfBoundsException-Fehler",
                "Gueltige Indizes gehen nur bis length - 1. Der Index 'length' selbst liegt bereits ausserhalb des Arrays.",
                new String[] { "Gibt das letzte Element zurueck", "Gibt 0 zurueck", "Gibt null zurueck" }));

        questions.add(new Question("Arrays",
                "Kann ein Java-Array nach der Erstellung seine Groesse aendern?",
                "Nein, die Groesse ist fest",
                "Ein Array hat eine feste Laenge. Wer eine veraenderliche Groesse braucht, nutzt stattdessen z.B. eine ArrayList.",
                new String[] { "Ja, mit resize()", "Ja, automatisch bei Bedarf", "Nur bei int-Arrays" }));

        // --- Weitere Fragen: Methoden ---
        questions.add(new Question("Methoden",
                "Wie nennt man eine Methode, die keine Parameter entgegennimmt?",
                "Parameterlose Methode",
                "Eine Methode kann null, einen oder mehrere Parameter haben - ganz ohne ist ebenfalls erlaubt.",
                new String[] { "Void-Methode", "Leere Methode", "Statische Methode" }));

        questions.add(new Question("Methoden",
                "Was passiert, wenn eine Methode mit Rueckgabetyp int keinen return-Wert liefert?",
                "Kompilierfehler",
                "Java verlangt, dass jeder moegliche Codepfad einer nicht-void-Methode einen Wert zurueckgibt.",
                new String[] { "Sie gibt automatisch 0 zurueck", "Sie gibt null zurueck", "Laufzeitfehler erst beim Aufruf" }));

        // --- Weitere Fragen: OOP ---
        questions.add(new Question("OOP",
                "Wie nennt man es, wenn mehrere Klassen dieselbe Methode jeweils unterschiedlich umsetzen (z.B. durch Overriding)?",
                "Polymorphismus",
                "Polymorphismus erlaubt es, dieselbe Methode je nach tatsaechlichem Objekt-Typ unterschiedlich reagieren zu lassen.",
                new String[] { "Kapselung", "Abstraktion", "Vererbung" }));

        questions.add(new Question("OOP",
                "Wie nennt man das Verstecken interner Daten einer Klasse hinter privaten Feldern und oeffentlichen Methoden?",
                "Kapselung (Encapsulation)",
                "Kapselung schuetzt den internen Zustand eines Objekts vor direktem, unkontrolliertem Zugriff von aussen.",
                new String[] { "Vererbung", "Polymorphismus", "Abstraktion" }));

        questions.add(new Question("OOP",
                "Welche Methode ruft man typischerweise auf, um ein Objekt als lesbaren Text darzustellen (wird z.B. von println genutzt)?",
                "toString()",
                "Ueberschreibt man toString() in einer eigenen Klasse, zeigt println() automatisch eine sinnvolle Textdarstellung statt einer kryptischen Adresse.",
                new String[] { "print()", "asString()", "display()" }));

        // --- Enums ---
        questions.add(new Question("Enums",
                "Wofuer nutzt man in Java ein enum?",
                "Um eine feste Menge benannter Konstanten zu definieren, z.B. Wochentage",
                "enum eignet sich perfekt fuer Werte, die von vornherein feststehen, wie Wochentage oder Himmelsrichtungen.",
                new String[] { "Um Arrays zu speichern", "Um Methoden zu ueberladen", "Um Fehler abzufangen" }));

        questions.add(new Question("Enums",
                "Wie deklariert man ein einfaches enum mit den Werten MONTAG, DIENSTAG, MITTWOCH?",
                "enum Wochentag { MONTAG, DIENSTAG, MITTWOCH }",
                "Die Konstanten stehen kommagetrennt in geschweiften Klammern direkt nach dem enum-Namen.",
                new String[] { "enum Wochentag = [MONTAG, DIENSTAG, MITTWOCH];", "class Wochentag enum { ... }", "enum Wochentag(MONTAG, DIENSTAG, MITTWOCH);" }));

        questions.add(new Question("Enums",
                "Welche Schreibweise ist bei enum-Konstanten in Java ueblich, z.B. MONTAG?",
                "GROSSBUCHSTABEN",
                "Analog zu Konstanten (final-Variablen) schreibt man enum-Werte per Konvention komplett gross.",
                new String[] { "camelCase", "PascalCase", "kebab-case" }));

        // --- Interfaces ---
        questions.add(new Question("Interfaces",
                "Was ist ein Interface in Java?",
                "Ein Vertrag, der Methoden vorschreibt, die implementierende Klassen bereitstellen muessen",
                "Ein Interface legt fest WAS eine Klasse koennen muss, ohne selbst festzulegen WIE es umgesetzt wird.",
                new String[] { "Eine spezielle Art von Array", "Eine fertige Klasse zum direkten Verwenden", "Ein Kommentar-Format" }));

        questions.add(new Question("Interfaces",
                "Welches Schluesselwort nutzt eine Klasse, um ein Interface umzusetzen?",
                "implements",
                "Klasse X implements InterfaceY bedeutet: X verspricht, alle Methoden von InterfaceY bereitzustellen.",
                new String[] { "extends", "uses", "interfaces" }));

        questions.add(new Question("Interfaces",
                "Kann man von einem Interface direkt mit new ein Objekt erstellen?",
                "Nein, nur Klassen koennen instanziiert werden",
                "Ein Interface allein ist keine fertige Blaupause fuer Objekte - nur eine Klasse, die es implementiert, kann instanziiert werden.",
                new String[] { "Ja, genau wie bei Klassen", "Nur wenn es eine einzige Methode hat", "Ja, aber nur mit static" }));

        // --- Weitere Fragen: Strings ---
        questions.add(new Question("Strings",
                "Was macht text.trim() bei einem String?",
                "Entfernt Leerzeichen am Anfang und Ende",
                "trim() liefert eine neue Version des Strings ohne fuehrende/nachfolgende Leerzeichen, der Rest bleibt unveraendert.",
                new String[] { "Entfernt alle Leerzeichen im Text", "Kuerzt den Text auf eine feste Laenge", "Wandelt Gross- in Kleinbuchstaben um" }));

        questions.add(new Question("Strings",
                "Wie prueft man, ob ein String namens text leer ist (Laenge 0)?",
                "text.isEmpty()",
                "isEmpty() ist die uebliche, lesbare Methode dafuer - alternativ ginge auch text.length() == 0.",
                new String[] { "text.isNull()", "text == \"\"", "text.length = 0" }));

        // --- Weitere Fragen: Exceptions ---
        questions.add(new Question("Exceptions",
                "Welcher Block wird immer ausgefuehrt, egal ob eine Exception aufgetreten ist oder nicht?",
                "finally",
                "finally eignet sich z.B. zum Aufraeumen (Dateien schliessen), weil es garantiert ausgefuehrt wird.",
                new String[] { "catch", "throw", "always" }));

        questions.add(new Question("Exceptions",
                "Mit welchem Schluesselwort loest man selbst eine Exception aus?",
                "throw",
                "throw new IllegalArgumentException(...) erzeugt und wirft gezielt eine eigene Exception.",
                new String[] { "catch", "raise", "error" }));

        // --- Weitere Fragen: Collections ---
        questions.add(new Question("Collections",
                "Wie entfernt man das Element an Index 0 aus einer ArrayList namens liste?",
                "liste.remove(0)",
                "remove(index) loescht das Element an dieser Position und rueckt die folgenden Elemente automatisch nach.",
                new String[] { "liste.delete(0)", "liste.pop(0)", "liste[0] = null" }));

        questions.add(new Question("Collections",
                "Wie ermittelt man, wie viele Elemente eine ArrayList namens liste enthaelt?",
                "liste.size()",
                "size() ist bei ArrayList das Gegenstueck zu length bei Arrays - allerdings als Methode mit Klammern.",
                new String[] { "liste.length", "liste.length()", "liste.count()" }));

        // --- Weitere Fragen: Ein-/Ausgabe ---
        questions.add(new Question("Ein-/Ausgabe",
                "Welche Methode einer Scanner-Instanz liest eine ganze Zeile Text ein?",
                "nextLine()",
                "nextLine() liest bis zum naechsten Zeilenumbruch, waehrend next() nur bis zum naechsten Leerzeichen liest.",
                new String[] { "nextInt()", "readLine()", "next()" }));

        return questions;
    }
}
