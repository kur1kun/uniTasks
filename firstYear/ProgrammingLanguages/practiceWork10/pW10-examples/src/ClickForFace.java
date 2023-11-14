package ua.com.glybovets.java1_1.lecture11;

import acm.program.*;
import acm.graphics.*;
import java.awt.event.*;

public class ClickForFace extends GraphicsProgram{
	
	public static final int FACE_DIAM = 50;
	
	public static final int WINDOW_WIDTH = 300;
	public static final int WINDOW_HEIGHT = 400;
	
	//в цій програмі немає методу run() нам нічого робити,
	//ми чекаємо на дію клієнта
	//єдине, що нам необхідно зробити це зареєструвати слухача подій
	
	//метод init автоматично запускається коли стартує програма
	public void init(){
		this.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
		addMouseListeners();
	}
	
	//асинхронний метод, що викликається при натисканні миші
	public void mouseClicked(MouseEvent e){
		GFace face = new GFace(FACE_DIAM,FACE_DIAM);
		add(face, e.getX(), e.getY());
	}
}
