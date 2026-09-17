package lernapp.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JButton;

// Ein JButton mit abgerundeten Ecken statt der eckigen Standard-Optik.
// Wird an allen Stellen statt "new JButton(...)" verwendet.
public class RoundedButton extends JButton {

    private static final int ARC = 16;

    public RoundedButton(String text) {
        super(text);
        setContentAreaFilled(false); // Standard-Hintergrund aus, wir malen ihn selbst
        setFocusPainted(false);
        setBorderPainted(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Color background;
        if (!isEnabled()) {
            background = new Color(225, 225, 225);
        } else if (getModel().isPressed()) {
            background = new Color(175, 195, 230);
        } else if (getModel().isRollover()) {
            background = new Color(205, 220, 245);
        } else {
            background = new Color(225, 232, 245);
        }

        g2.setColor(background);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), ARC, ARC);
        g2.dispose();

        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(160, 175, 200));
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, ARC, ARC);
        g2.dispose();
    }
}
