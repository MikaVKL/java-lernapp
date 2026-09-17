@echo off
setlocal

cd /d "%~dp0"

where javac >nul 2>nul
if errorlevel 1 (
    echo Kein Java JDK gefunden ^(javac fehlt im PATH^).
    echo Bitte ein JDK installieren, z.B. von https://adoptium.net
    echo Beim Installieren "Add to PATH" auswaehlen.
    pause
    exit /b 1
)

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
