package Task1;

import acm.graphics.*;
import acm.program.GraphicsProgram;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class Runner extends GraphicsProgram {
    public static final int WINDOWWIDTH = 400;
    public static final int WINDOWHEIGHT = 600;
    private final double playerStartX = (WINDOWWIDTH - Player.width) / 2;
    private final double playerY = (WINDOWHEIGHT - Player.height) * 0.85;
    private final ArrayList<Character> leftKey = new ArrayList<>(Arrays.asList('a', 'A', 'ф', 'Ф'));
    private final ArrayList<Character> rightKey = new ArrayList<>(Arrays.asList('d', 'D', 'в', 'В'));
    private final ArrayList<Bullet> allBullets = new ArrayList<>();
    private final ArrayList<Enemy> allEnemies = new ArrayList<>();
    Player player = new Player(playerStartX, playerY);
    private static int playerScore = 0;
    private boolean gameStop = false;
    private final Font winSansS = new Font("SansSerif", Font.BOLD, 25);
    private final Font playSansS = new Font("SansSerif", Font.BOLD, 14);
    private GLabel playLabel = new GLabel("Your score: " + playerScore);

    public void run() {
        this.setSize(WINDOWWIDTH, WINDOWHEIGHT);
        add(player);

        playLabel.setLocation(10, 20);
        playLabel.setFont(playSansS);
        add(playLabel);

        addKeyListeners();
        int time = 0;
        while (!gameStop) {
            moveBullets();
            moveEnemies();
            checkPlayerCollides();
            checkBulletCollides();
            if (time == 100) {
                Enemy en = new Enemy();
                allEnemies.add(en);
                add(en);
                time = 0;
            } else {
                time++;
            }
            pause(10);
        }
    }

    private void moveBullets() {
        for (Bullet bullet : allBullets) {
            bullet.move(0, -Bullet.moveSpeed);
        }
    }

    private void moveEnemies() {
        for (Enemy enemy : allEnemies) {
            if(enemy.getY() < WINDOWHEIGHT*0.85){
                enemy.move(0, Enemy.moveSpeed);
            } else if (enemy.getY() >= WINDOWHEIGHT*0.85){
                gameStop = true;
                gameFinish();
                break;
            }
        }
    }

    private void checkPlayerCollides() {
        for(Enemy enemy : allEnemies){
            if (player.getBounds().intersects(enemy.getBounds())) {
                allEnemies.remove(enemy);
                remove(enemy);
                remove(player);
                gameStop = true;
                gameFinish();
                break;
            }
        }
    }


    private void checkBulletCollides() {
        BulletLoop:
        for (ListIterator<Bullet> bullItr = allBullets.listIterator(); bullItr.hasNext(); ) {
            Bullet bullet = bullItr.next();
            for (ListIterator<Enemy> enemyItr = allEnemies.listIterator(); enemyItr.hasNext(); ) {
                Enemy enemy = enemyItr.next();
                if (bullet.getBounds().intersects(enemy.getBounds())) {
                    remove(enemy);
                    remove(bullet);
                    bullItr.remove();
                    enemyItr.remove();
                    playerScore++;
                    playLabel.setLabel("Your score: " + playerScore);
                    playGIF(enemy.getLocation());
                    continue BulletLoop;
                }
            }
        }
    }

    private void playGIF(GPoint gp){
        new Thread(() -> {
            GImage expAnim = new GImage("expAnim.gif");
            expAnim.setSize(Enemy.width, Enemy.height);
            expAnim.setLocation(gp);
            add(expAnim);
            pause(1300);
            remove(expAnim);
        }).start();
    }

    public void keyTyped(KeyEvent e) {
        if (!gameStop && e.getKeyChar() == ' ') {
            Bullet bullet = new Bullet(player.getX() + (Player.width - Bullet.bulletWidth) / 2, playerY - Bullet.bulletHeight);
            allBullets.add(bullet);
            add(bullet);
        }
    }

    public void keyPressed(KeyEvent e) {
        if(!gameStop) {
            char keyTyped = e.getKeyChar();
            if (leftKey.contains(keyTyped) && player.getX() > 0) {
                player.move(-Player.moveSpeed, 0);
            } else if (rightKey.contains(keyTyped) && player.getX() < WINDOWWIDTH - Player.width) {
                player.move(Player.moveSpeed, 0);
            }
        }
    }

    private void gameFinish() {
        GRect hideCanvas = new GRect(WINDOWWIDTH, WINDOWHEIGHT);
        hideCanvas.setFillColor(Color.WHITE);
        hideCanvas.setFilled(true);
        hideCanvas.setColor(Color.WHITE);
        add(hideCanvas);
        GLabel winLabel = new GLabel("Your final score : " + playerScore);
        Rectangle canvasBounds = getGCanvas().getBounds();
        winLabel.setLocation(75, (canvasBounds.getHeight()+winLabel.getAscent())/2);
        winLabel.setFont(winSansS);
        add(winLabel);
    }
}