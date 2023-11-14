package ua.com.glybovets.java1_1.lecture11;

import acm.program.*;
import acm.graphics.*;

public class DrawFace extends GraphicsProgram{

	public static final int FACE_WIDTH = 100;
	public static final int FACE_HEIGHT = 200;
	
	public static final int WINDOW_WIDTH = 300;
	public static final int WINDOW_HEIGHT = 400;
	
	public void run(){
		this.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
		
		GFace face = new GFace(FACE_WIDTH,FACE_HEIGHT);
		add(face,(WINDOW_WIDTH-FACE_WIDTH)/2, (WINDOW_HEIGHT-FACE_HEIGHT)/2);
		
	}
}
