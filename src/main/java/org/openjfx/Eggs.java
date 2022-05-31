package org.openjfx;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.Random;

public class Eggs extends Pane {
    private Image image;
    private int coordinateX;
    private int coordinateY;

    public Eggs(ArrayList<Image> kinds, int[][] eggCoord) {
        int kind = new Random().nextInt(3);
        image = kinds.get(kind);
        int cd = new Random().nextInt(4);
        coordinateX = eggCoord[cd][0];
        coordinateY = eggCoord[cd][1];
    }

    public Image getImage() {
        return image;
    }
    public void setImage(Image image) {
        this.image = image;
    }
    public int getСoordinateY() {
        return coordinateY;
    }
    public void setСoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }
    public int getСoordinateX() {
        return coordinateX;
    }
    public void setСoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }
}
