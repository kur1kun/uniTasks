import acm.program.*;
import acm.graphics.*;

public class BouncingFace extends GraphicsProgram {
	public static final int WINDOW_WIDTH = 300;
	public static final int WINDOW_HEIGHT = 300;
	private static final int DIAM_BALL = 10;
	private static final double GRAVITY = 3;
	private static final int DELAY = 30;
	private static final double X_START = DIAM_BALL / 2;
	private static final double Y_START = 100;
	private static final double X_VEL = 5;
	private static final double BOUNCE_REDUCE = 0.9;
	private double xVel = X_VEL;
	private double yVel = 0.0;



	/* private instance variable */
	private GOval ball;

	public void run() {
		setup();
		//�������� ���������� ���� �'���� ���������� �� ����� ���� ������
		while (ball.getX() < getWidth()) {
			moveBall();
			checkForCollision();
			pause(DELAY);
		}
	}

	/** ��������� � �������� �'���� */
	private void setup() {
		this.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
		ball = new GOval(X_START, Y_START, DIAM_BALL, DIAM_BALL);
		ball.setFilled(true);
		add(ball);
	}

	/** ��������� � ���������� �'����� */
	private void moveBall() {
		//��������� �������� � ����������� ���������
		yVel += GRAVITY;
		ball.move(xVel,yVel);
	}

	/** ���� �'���� ������������ �� ���, ��������� ���������� �
	 * ���� ������������*/
	private void checkForCollision() {
		// ��������� �� �� �������� �'���� ���� ����
		if (ball.getY() > getHeight() - DIAM_BALL) {
			// ������� �������� Y ��� ��������� �'���� �������� � ����
			yVel = -yVel * BOUNCE_REDUCE;

			double diff = ball.getY() - (getHeight() - DIAM_BALL);
			ball.move(0, -2 * diff);
		}
	}
}
