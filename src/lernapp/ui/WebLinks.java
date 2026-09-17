package lernapp.ui;

import java.awt.Desktop;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

// Kleine Hilfsklasse, um bei Bedarf eine Google-Suche zu einem Thema im
// Standardbrowser zu oeffnen. Schlaegt einfach lautlos fehl (statt einer
// Fehlermeldung), falls kein Internet oder kein Standardbrowser verfuegbar ist.
final class WebLinks {

    private WebLinks() {
    }

    static void searchTopic(String topic) {
        try {
            String query = URLEncoder.encode("Java " + topic, StandardCharsets.UTF_8);
            Desktop.getDesktop().browse(new URI("https://www.google.com/search?q=" + query));
        } catch (Exception e) {
            // Kein Internet, kein Standardbrowser oder nicht unterstuetzt - dann passiert einfach nichts.
        }
    }
}
