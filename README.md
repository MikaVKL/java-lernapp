# Java-Lernapp

Eine kleine Swing-App zum Lernen von Java-Grundlagen für die Schule – mit Karteikarten- und Quiz-Modus.

## Voraussetzung

Ein installiertes Java JDK (Version 17 oder neuer), z.B. [Eclipse Temurin](https://adoptium.net) – beim Installieren "Add to PATH" auswählen.

## Starten

Am einfachsten: Doppelklick auf `start.bat` im Projektordner. Das Skript kompiliert den Code und startet die App. Falls kein JDK gefunden wird, zeigt es einen Hinweis mit Installationslink.

## Manuell starten (PowerShell)

```powershell
javac -d bin (Get-ChildItem -Path src -Recurse -Filter *.java | Select-Object -ExpandProperty FullName)
java -cp bin lernapp.Main
```

## Eigene Fragen ergänzen

Fragen liegen in `src\lernapp\data\QuestionBank.java`. Einfach eine der `questions.add(new Question(...))`-Zeilen kopieren und Thema, Frage, richtige Antwort, Erklärung und die drei falschen Antworten anpassen.
