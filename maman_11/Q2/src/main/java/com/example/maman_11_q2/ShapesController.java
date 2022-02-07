/*
 * The ShapesController class is
 */

package com.example.maman_11_q2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import java.util.Random;

public class ShapesController {
    Random rand = new Random();
    private int numOfShapes = 3;
    private final int BOUNDARY = 399;
    private final int QUARTER = 100;
    private GraphicsContext gc;
    private int sizeX, sizeY;

    @FXML
    private Button button1;
    @FXML
    private Canvas canvas;

    @FXML
    public void initialize() {
        gc = canvas.getGraphicsContext2D();
    }

    @FXML
    public void buttonPressed(ActionEvent event) {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (int i = 0; i < 10; i++) {
            switch (rand.nextInt(numOfShapes)) {
                case 0: //rectangle
                    gc.setFill(new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat(), rand.nextFloat()));
                    gc.fillRect(rand.nextInt(BOUNDARY), rand.nextInt(BOUNDARY), rand.nextInt(QUARTER), rand.nextInt(QUARTER));
                    break;
                case 1: //oval
                    gc.setFill(new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat(), rand.nextFloat()));
                    gc.fillOval(rand.nextInt(BOUNDARY), rand.nextInt(BOUNDARY), rand.nextInt(QUARTER), rand.nextInt(QUARTER));
                    break;
                case 2: //line
                    gc.setStroke(new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat(), rand.nextFloat()));
                    sizeX = rand.nextInt(BOUNDARY - QUARTER);
                    sizeY = rand.nextInt(BOUNDARY - QUARTER);
                    gc.strokeLine(sizeX, sizeY, rand.nextInt(sizeX) + QUARTER, rand.nextInt(sizeY) + QUARTER);
                    break;


            }
        }
    }


}