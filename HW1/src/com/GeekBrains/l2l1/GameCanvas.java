package com.GeekBrains.l2l1;



import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {

    long lastFrameTime;
    MainCircles gameController;
    BackGround bg;

    GameCanvas(MainCircles gameController) {
        lastFrameTime = System.nanoTime();
        this.gameController = gameController;
        bg = new BackGround(this);
    }

    @Override
    protected void paintComponent(Graphics g) {  // while (true) {
        super.paintComponent(g);

        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f;
        lastFrameTime = currentTime;
        gameController.onDrawFrame(this, g, deltaTime);
        bg.changeBackground(deltaTime);
        try {
            Thread.sleep(16);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();                               // }
    }

    public int getLeft() { return 0; }
    public int getRight() { return getWidth() - 1; }
    public int getTop() { return 0; }
    public int getBottom() { return getHeight() - 1; }

}
