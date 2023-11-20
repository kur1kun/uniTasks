package Task2;

import acm.graphics.GCompound;
import acm.graphics.GLabel;
import acm.graphics.GRect;

import java.awt.*;

public class Button extends GCompound {
    public static double buttonHeight = 50;
    public static double buttonWidth = 150;
    public static boolean isPressed = false;
    private double x, y;
    private final Color buttonColor = Color.BLACK;
    private final String buttonLabelText = "Reroll";
    private final Font buttonSansS = new Font("SansSerif", Font.BOLD, 20);

    public void draw(double x, double y) {
        GCompound button = new GCompound();
        this.x = x;
        this.y = y;

        GRect buttonBorder = new GRect(buttonWidth, buttonHeight);
        buttonBorder.setColor(buttonColor);
        buttonBorder.setFilled(true);
        buttonBorder.setFillColor(Color.WHITE);
        button.add(buttonBorder);

        GLabel buttonText = new GLabel(buttonLabelText);
        buttonText.setFont(buttonSansS);
        buttonText.setLocation((buttonWidth - buttonText.getWidth()) / 2, (buttonHeight + buttonText.getHeight()) / 2.30);
        button.add(buttonText);

        button.setLocation(x, y);
        add(button);
    }

    public void getPressed(Runner run) {
        run.finish();
    }
}
