# Java-Lernapp

Eine kleine Swing-App zum Lernen von Java-Grundlagen für die Schule – mit Karteikarten- und Quiz-Modus.

## Starten

Am einfachsten: Doppelklick auf `start.bat` im Projektordner. Das Skript kompiliert den Code und startet die App.

## Manuell starten (PowerShell)

```powershell
javac -d bin (Get-ChildItem -Path src -Recurse -Filter *.java | Select-Object -ExpandProperty FullName)
java -cp bin lernapp.Main
```

Falls `javac`/`java` nicht gefunden werden, liegt das BlueJ-JDK unter `C:\Program Files\BlueJ\jdk\bin` – diesen Pfad vorher zum PATH hinzufügen:

```powershell
$env:Path = "C:\Program Files\BlueJ\jdk\bin;" + $env:Path
```

## Eigene Fragen ergänzen

Fragen liegen in `src\lernapp\data\QuestionBank.java`. Einfach eine der `questions.add(new Question(...))`-Zeilen kopieren und Thema, Frage, richtige Antwort, Erklärung und die drei falschen Antworten anpassen.
