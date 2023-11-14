import acm.graphics.GLabel;
import acm.program.GraphicsProgram;

import java.awt.event.MouseEvent;

//public class gameRun extends GraphicsProgram {
//    public void run() {
//        int i = 0;
//    }
//}

public class gameRun extends GraphicsProgram {

    public void run() {
        label = new GLabel("");
        label.setFont("Times New Roman-36");
        add(label, 50, 50);
        addMouseListeners();
    }

    public void mouseMoved(MouseEvent e) {
        label.setLabel("Mouse: " + e.getX() + ", " + e.getY());
    }

    private GLabel label;
}

