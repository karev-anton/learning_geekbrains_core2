package com.GeekBrains.l2l1;

import java.awt.*;

public class BackGround {
    private GameCanvas canvas;
    private double time = 0;

    BackGround(GameCanvas canvas) {
        this.canvas = canvas;
    }
    public void changeBackground(double dt) {
        time += dt;
        if (time > 1) {
            Color color = new Color(
                    (int) (Math.random() * 255),
                    (int) (Math.random() * 255),
                    (int) (Math.random() * 255)
            );
            canvas.setBackground(color);
            time = 0;
        }
    }
}