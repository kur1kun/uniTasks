import acm.program.*;
import acm.graphics.*;
import java.awt.event.*;

public class MouseTracker extends GraphicsProgram{

	public void run(){
		label = new GLabel("");
		label.setFont("Times New Roman-36");
		add(label,50,50);
		addMouseListeners();
	}
	
	public void mouseMoved(MouseEvent e){
		label.setLabel("Mouse: "+e.getX()+", "+e.getY());
	}
	
	private GLabel label;
}
