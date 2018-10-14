
import java.sql.Time;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Material;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Path;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import mars.javafx.CameraController;
import models.Fox;
import view.ViewManager;

public class Game extends Application {

	// float i = 0.1f;
	// Box prepreka, fox, traka;

	public ViewManager manager;
	public GameManager gameManager;

	public void setCamera(ViewManager manager) {
		PerspectiveCamera camera = new PerspectiveCamera(true);
		camera.setTranslateZ(-200);
		camera.setTranslateY(-100);
		camera.setFarClip(2000);
		camera.setFieldOfView(40);
		manager.getScene().setCamera(camera);
		new CameraController(manager.getScene(), camera, new Point3D(0, -10, -20), new Point3D(0, 0, 0));
	}

	public Stage initGame(Stage primaryStage) {
		this.manager = new ViewManager();
		this.gameManager = new GameManager(manager);
		this.manager.addFox();
		this.manager.addPath();
		this.manager.addCar();
		this.setCamera(manager);
		primaryStage = manager.getStage();

		Scene scene = this.manager.getScene();
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				switch (event.getCode()) {
				case A:
					manager.getFox().setXPosition(manager.getFox().getXPosition() - 10);
					break;
				case D:
					manager.getFox().setXPosition(manager.getFox().getXPosition() + 10);
					break;
				case W:
					manager.getFox().setZPosition(manager.getFox().getZPosition() + 10);
					break;
				case S:
					manager.getFox().setZPosition(manager.getFox().getZPosition() - 10);
					break;
				}
			}
		});

		KeyValue kv = new KeyValue(manager.getCar().getLayuoutX(), 190);
		KeyFrame kf = new KeyFrame(Duration.seconds(3), kv);

		Timeline time = new Timeline();
		time.getKeyFrames().addAll(kf);
		time.setCycleCount(Timeline.INDEFINITE);
		//time.play();
		AnimationTimer timer = new AnimationTimer() {

			@Override
			public void handle(long now) {

				gameManager.checkCrash(manager.getFox(), manager.getCar());
				// System.out.println(manager.getFox().getZPosition());
				gameManager.checkFinishGame(manager.getFox());

			}
		};
		timer.start();

		return primaryStage;
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage = this.initGame(primaryStage);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
