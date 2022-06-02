package org.openjfx;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class Eggs extends Pane {
    private Image image;
    private int coordinateX;
    private int coordinateY;
    private int kindEgg;

    public Eggs(int[][] eggCoord) throws FileNotFoundException {
        FileInputStream egg_1 = new FileInputStream("C:\\Users\\Polina\\Documents\\GitHub\\MyFirstGame\\src\\images\\egg_Addled_1.png");
        Image eggAddled = new Image(egg_1);
        FileInputStream egg_2 = new FileInputStream("C:\\Users\\Polina\\Documents\\GitHub\\MyFirstGame\\src\\images\\egg_Golden_1.png");
        Image eggGolden = new Image(egg_2);
        FileInputStream egg_3 = new FileInputStream("C:\\Users\\Polina\\Documents\\GitHub\\MyFirstGame\\src\\images\\egg_White_1.png");
        Image eggWhite = new Image(egg_3);
        ArrayList<Image> kinds = new ArrayList<>();
        kinds.add(eggAddled);
        kinds.add(eggGolden);
        kinds.add(eggWhite);
        int kind = new Random().nextInt(3);
        kindEgg = kind;
        image = kinds.get(kind);
        int cd = new Random().nextInt(4);
        coordinateX = eggCoord[cd][0];
        coordinateY = eggCoord[cd][1];
    }

    public Image getImage() {
        return image;
    }
    public int getKindEgg() {
        return kindEgg;
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
