package Task2;

import acm.graphics.GCompound;
import acm.graphics.GLabel;
import acm.graphics.GRect;

import java.awt.*;

public class Button extends GCompound {
    private final int buttonHeight = 50;
    private final int buttonWidth = 150;
    private final Color buttonColor = Color.BLACK;
    private final String buttonLabelText = "Reroll";
    private final Font sansS = new Font("SansSerif", Font.BOLD, 20);
    public void draw(int x, int y){
        GCompound button = new GCompound();

        GRect buttonBorder = new GRect(buttonWidth, buttonHeight);
        buttonBorder.setColor(buttonColor);
        buttonBorder.setFilled(true);
        buttonBorder.setFillColor(Color.WHITE);
        button.add(buttonBorder);

        GLabel buttonText = new GLabel(buttonLabelText);
        buttonText.setFont(sansS);
        buttonText.setLocation((buttonWidth-buttonText.getWidth())/2,(buttonHeight+buttonText.getHeight())/2.30);
        button.add(buttonText);

        button.setLocation(x, y);
        add(button);
    }
    public void getPressed() {
    }
}
