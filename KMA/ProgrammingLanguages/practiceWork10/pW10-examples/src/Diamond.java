package ua.com.glybovets.java1_1.lecture11;

import java.awt.Color;

import acm.program.*;
import acm.graphics.*;

public class Diamond extends GraphicsProgram{

	public void run(){
		GPolygon diamond = createDiamondE(100,75);
		diamond.setFilled(true);
		diamond.setFillColor(Color.MAGENTA);
		add(diamond,getWidth()/2,getHeight()/2);
	}
	
	/**
	 * Метод малює полігон - діамант
	 * @param width - ширина діаманту
	 * @param height - висота діаманту
	 * @return об'єкт типу GPolygon
	 */
	private GPolygon createDiamond(double width, double height){
		
		GPolygon diamond = new GPolygon();
		//ставимо першу точку
		//перша точка знаходиться в координаті половина ширини фігури зі знаком мінус (зліва від центра)
		//і в 0 тобто на осі ОХ
		diamond.addVertex(-width/2, 0);
		//друга точка знаходиться зверху 
		diamond.addVertex(0, -height/2);
		//третя точка справа
		diamond.addVertex(width/2, 0);
		//четверта знизу
		diamond.addVertex(0, height/2);
		return diamond;
	}
	
private GPolygon createDiamondE(double width, double height){
		
		GPolygon diamond = new GPolygon();
		//ставимо першу точку
		//перша точка знаходиться в координаті половина ширини фігури зі знаком мінус (зліва від центра)
		//і в 0 тобто на осі ОХ
		diamond.addVertex(-width/2, 0);
		//тепер положення наступної точки обраховуємо виходячи з попередньої 
		diamond.addEdge(width/2, -height/2);
		diamond.addEdge(width/2, height/2);
		diamond.addEdge(-width/2, height/2);
		diamond.addEdge(-width/2, -height/2);
		return diamond;
	}
	
}
