import acm.program.GraphicsProgram;

import java.awt.event.MouseEvent;

public class Main extends GraphicsProgram {
    private final int WINDOW_HEIGHT = 100;
    private final int WINDOW_WIDTH = 200;
    private final int DELAY = 30;
    private boolean gameOver = false;

    public void run() {
        setup();
        while (!gameOver) {
            while (userTurn) {
                pause(DELAY);
            } else{
                moveAI();
            }
        }
    }

    public void setup() {
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        drawField();
    }

    private void drawField() {

    }
    
    private void drawCircle(){

    }

    private void drawCross(){

    }

    public void mouseClicked(MouseEvent e) {

    }
}