package org.openjfx;

import javafx.animation.*;
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, 940, 680);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Wolf&Eggs");
        primaryStage.show();

        FileInputStream inputStream = new FileInputStream("C:\\Users\\Polina\\Documents\\GitHub\\MyFirstGame\\src\\images\\background.jpg");
        Image image = new Image(inputStream);
        ImageView background = new ImageView(image);
        root.getChildren().add(background);

        background.setFitHeight(680);
        background.setFitWidth(940);

        final Canvas canvas = new Canvas(940,680);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);

        FileInputStream inputStream_1 = new FileInputStream("C:\\Users\\Polina\\Documents\\GitHub\\MyFirstGame\\src\\images\\wolf_1.png");
        Image wolf_1 = new Image(inputStream_1);
        FileInputStream inputStream_2 = new FileInputStream("C:\\Users\\Polina\\Documents\\GitHub\\MyFirstGame\\src\\images\\wolf_2.png");
        Image wolf_2 = new Image(inputStream_2);
        FileInputStream inputStream_3 = new FileInputStream("C:\\Users\\Polina\\Documents\\GitHub\\MyFirstGame\\src\\images\\wolf_3.png");
        Image wolf_3 = new Image(inputStream_3);
        FileInputStream inputStream_4 = new FileInputStream("C:\\Users\\Polina\\Documents\\GitHub\\MyFirstGame\\src\\images\\wolf_4.png");
        Image wolf_4 = new Image(inputStream_4);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent keyEvent) {
                String content = keyEvent.getCode().toString();
                if (content.equals("Q")) {
                    gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                    gc.drawImage(wolf_1, 70, 60, 790, 550);
                }
                if (content.equals("E")) {
                    gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                    gc.drawImage(wolf_2, 78, 60, 790, 550);
                }
                if (content.equals("A")) {
                    gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                    gc.drawImage(wolf_3, 70, 60, 790, 550);
                }
                if (content.equals("D")) {
                    gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                    gc.drawImage(wolf_4, 78, 60, 790, 550);
                }
            }
        });

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

        int [][] eggCoord = {{197,256}, {690,256}, {197,370}, {690,370}};

        int width = 58;
        int height = 58;
        int i = 8;

        BooleanProperty b = new SimpleBooleanProperty();

        for (int k = 0; k < 2; k++) {
            Eggs eggs = new Eggs(kinds, eggCoord);
            Image imageEgg;
            imageEgg = eggs.getImage();
            ImageView egg = new ImageView(imageEgg);
            int coordinateX = eggs.getСoordinateX();
            int coordinateY = eggs.getСoordinateY();

            DoubleProperty x = new SimpleDoubleProperty();
            DoubleProperty y = new SimpleDoubleProperty();

            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.millis(0),
                            new KeyValue(x, coordinateX),
                            new KeyValue(y, coordinateY),
                            new KeyValue(b, false)
                    ),
                    new KeyFrame(Duration.millis(1000),
                            new KeyValue(x, coordinateX + i),
                            new KeyValue(y, coordinateY + i),
                            new KeyValue(b, false)
                    ),
                    new KeyFrame(Duration.millis(1500),
                            new KeyValue(x, coordinateX + i),
                            new KeyValue(y, coordinateY + i),
                            new KeyValue(b, false)
                    ),
                    new KeyFrame(Duration.millis(2000),
                            new KeyValue(x, coordinateX + 2*i),
                            new KeyValue(y, coordinateY + 2*i),
                            new KeyValue(b, false)
                    ),
                    new KeyFrame(Duration.millis(2500),
                            new KeyValue(x, coordinateX + 2*i),
                            new KeyValue(y, coordinateY + 2*i),
                            new KeyValue(b, false)
                    ),
                    new KeyFrame(Duration.millis(3000),
                            new KeyValue(x, coordinateX + 3*i),
                            new KeyValue(y, coordinateY + 3*i),
                            new KeyValue(b, false)
                    ),
                    new KeyFrame(Duration.millis(3500),
                            new KeyValue(x, coordinateX + 3*i),
                            new KeyValue(y, coordinateY + 3*i),
                            new KeyValue(b, false)
                    ),
                    new KeyFrame(Duration.millis(4000),
                            new KeyValue(x, coordinateX + 4*i),
                            new KeyValue(y, coordinateY + 4*i),
                            new KeyValue(b, false)
                    ),
                    new KeyFrame(Duration.millis(4500),
                            new KeyValue(x, coordinateX + 4*i),
                            new KeyValue(y, coordinateY + 4*i),
                            new KeyValue(b, true)
                    )
            );
            timeline.setCycleCount(1);
            timeline.setAutoReverse(true);

            AnimationTimer timer = new AnimationTimer() {
                @Override
                public void handle(long now) {
                    egg.setTranslateX(x.doubleValue());
                    egg.setTranslateY(y.doubleValue());
                    egg.setFitHeight(height);
                    egg.setFitWidth(width);
                    if (b.getValue()){
                        root.getChildren().remove(egg);
                    }
                }
            };
            root.getChildren().add(egg);
            timer.start();
            timeline.play();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

