@echo off
setlocal

rem Falls javac/java nicht im PATH sind, das JDK von BlueJ dazu haengen.
set "JDK_BIN=C:\Program Files\BlueJ\jdk\bin"
set "PATH=%JDK_BIN%;%PATH%"

cd /d "%~dp0"

echo Kompiliere Java-Lernapp...
dir /s /b src\*.java > sources.txt
javac -d bin @sources.txt
del sources.txt

if errorlevel 1 (
    echo.
    echo Beim Kompilieren ist ein Fehler aufgetreten.
    pause
    exit /b 1
)

echo Starte Java-Lernapp...
java -cp bin lernapp.Main
