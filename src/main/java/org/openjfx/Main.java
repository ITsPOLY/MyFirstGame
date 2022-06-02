package org.openjfx;

import javafx.animation.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Main extends Application {
    Group root = new Group();
    public List<String> list = new ArrayList<>();
    public int [][] eggCoord = {{197,256}, {690,256}, {197,370}, {690,370}};
    public int result = 0;

    private void eggsMove() throws FileNotFoundException {
        int random = new Random().nextInt(250);
        Text text = new Text(40, 100, "SCORE: ");
        text.setFill(Color.GREENYELLOW);
        text.setStroke(Color.OLIVEDRAB);
        text.setStrokeWidth(1.2);
        text.setFont(Font.font("Verdana, BOLD", 55));
        if (random == 0) {
            Eggs eggs = new Eggs(eggCoord);
            Image imageEgg;
            imageEgg = eggs.getImage();
            ImageView egg = new ImageView(imageEgg);
            int coordinateX = eggs.getСoordinateX();
            int coordinateY = eggs.getСoordinateY();
            int kindEgg = eggs.getKindEgg();
            egg.setFitHeight(58);
            egg.setFitWidth(58);
            egg.setTranslateY(coordinateY);
            egg.setTranslateX(coordinateX);
            int a = 8;
            int x = 0;
            int y = 0;
            for (int k = 0; k < 5; k++) {
                 if (Arrays.equals(new int[]{coordinateX, coordinateY}, eggCoord[1])
                        || Arrays.equals(new int[]{coordinateX, coordinateY}, eggCoord[3])) {
                    TranslateTransition translateTransition = new TranslateTransition(Duration.millis(2000), egg);
                    translateTransition.setFromX(coordinateX);
                    translateTransition.setToX(coordinateX - a);
                    translateTransition.setFromY(coordinateY);
                    translateTransition.setToY(coordinateY + a);
                    translateTransition.setCycleCount(1);
                    translateTransition.setAutoReverse(true);
                    translateTransition.play();
                    x = coordinateX - a;
                    y = coordinateY + a;
                } else {
                    TranslateTransition translateTransition = new TranslateTransition(Duration.millis(2000), egg);
                    translateTransition.setFromX(coordinateX);
                    translateTransition.setToX(coordinateX + a);
                    translateTransition.setFromY(coordinateY);
                    translateTransition.setToY(coordinateY + a);
                    translateTransition.setCycleCount(1);
                    translateTransition.setAutoReverse(true);
                    translateTransition.play();
                     x = coordinateX + a;
                     y = coordinateY + a;
                }
                a += 8;
            }
            root.getChildren().add(egg);
            root.getChildren().add(text);
            System.out.println(x);
            System.out.println(y);

            if (Objects.equals(list.get(0), "Q") && x == 237 && y == 296) {
                if (kindEgg == 0) {
                    result -= 1;
                } else if (kindEgg == 1) {
                    result += 2;
                } else if (kindEgg == 2) {
                    result++;
                }
                System.out.println(result);
            }
            if (Objects.equals(list.get(0), "E") && x == 650 && y == 296) {
                if (kindEgg == 0) {
                    result -= 1;
                } else if (kindEgg == 1) {
                    result += 2;
                } else if (kindEgg == 2) {
                    result++;
                }
                System.out.println(result);
            }
            if (Objects.equals(list.get(0), "A") && x == 237 && y == 410) {
                if (kindEgg == 0) {
                    result -= 1;
                } else if (kindEgg == 1) {
                    result += 2;
                } else if (kindEgg == 2) {
                    result++;
                }
                System.out.println(result);
            }
            if (Objects.equals(list.get(0), "D") && x == 650 && y == 410) {
                if (kindEgg == 0) {
                    result -= 1;
                } else if (kindEgg == 1) {
                    result += 2;
                } else if (kindEgg == 2) {
                    result++;
                }
                System.out.println(result);
            }
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
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

        final Canvas canvas = new Canvas(680,600);
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
                    if (!list.isEmpty()) {
                        list.remove(list.get(0));
                    }
                    list.add(content);
                    System.out.println(list);
                }
                if (content.equals("E")) {
                    gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                    gc.drawImage(wolf_2, 78, 60, 790, 550);
                    if (!list.isEmpty()) {
                        list.remove(list.get(0));
                    }
                    list.add(content);
                    System.out.println(list);
                }
                if (content.equals("A")) {
                    gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                    gc.drawImage(wolf_3, 70, 60, 790, 550);
                    if (!list.isEmpty()) {
                        list.remove(list.get(0));
                    }
                    list.add(content);
                    System.out.println(list);
                }
                if (content.equals("D")) {
                    gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                    gc.drawImage(wolf_4, 78, 60, 790, 550);
                    if (!list.isEmpty()) {
                        list.remove(list.get(0));
                    }
                    list.add(content);
                    System.out.println(list);
                }
            }
        });

        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                try {
                    eggsMove();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };
        animationTimer.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

