
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

	public void setCamera(ViewManager manager) {
		PerspectiveCamera camera = new PerspectiveCamera(true);
		camera.setTranslateZ(-400);
		camera.setTranslateY(-200);
		// camera.setNearClip(0.1);
		camera.setFarClip(2000.0);
		camera.setFieldOfView(40);
		manager.getScene().setCamera(camera);
		new CameraController(manager.getScene(), camera, new Point3D(0, -10, -20), new Point3D(0, 0, 0));
	}

	public Stage initGame(Stage primaryStage) {
		this.manager = new ViewManager();
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
		 time.play();
		AnimationTimer timer = new AnimationTimer() {

			@Override
			public void handle(long now) {
				System.out.println("fox: x"+manager.getFox().getXPosition() +" z"+ manager.getFox().getZPosition());
				System.out.println("car: x"+manager.getCar().getXPosition() +" z"+ manager.getCar().getZPosition());
				if ((manager.getFox().getXPosition() == manager.getCar().getXPosition()) &&
					(manager.getFox().getZPosition() == manager.getCar().getZPosition())
				) {
					System.out.println("fox is killed!!!s");
				}
			}
		};
		timer.start();

		return primaryStage;
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage = this.initGame(primaryStage);
		primaryStage.show();

		// Group g = new Group();
		// Scene s = new Scene(g,500,500);
		// Box bb = new Box(500,500,500);
		// g.getChildren().add(bb);
		// primaryStage.setScene(s);
		// primaryStage.show();

		// AnimationTimer at = new AnimationTimer() {
		//
		// @Override
		// public void handle(long now) {
		//// System.out.println("lisica"+ fox.getLayoutX());
		//// System.out.println("auto" + prepreka.getLayoutX());
		// if(
		// fox.getTranslateY() == prepreka.getTranslateY() &&
		// fox.getTranslateX() == prepreka.getTranslateX() &&
		// fox.getTranslateZ() == prepreka.getTranslateZ()
		// ){
		// System.out.println("===============================");
		// }
		//// System.out.println(fox.getLayoutX());
		//// System.out.println(prepreka.getLayoutX());
		//// traka.setLayoutX(-5);
		// }
		// };
		// // Drawing a Box
		// traka = new Box(15, 1, 5);
		// traka.setTranslateX(7);
		//
		// prepreka = new Box(2, 2, 2);
		// Material mat = new PhongMaterial(Color.RED);
		// Material matFox = new PhongMaterial(Color.YELLOW);
		// prepreka.setMaterial(mat);
		//
		// fox = new Box(1,1,1);
		//
		//
		// fox.setTranslateZ(-2);
		// fox.setMaterial(matFox);
		//
		// // Creating a Group object
		// Group root = new Group(traka);
		// root.getChildren().add(prepreka);
		// root.getChildren().add(fox);
		//
		// // Timeline
		// Timeline time = new Timeline();
		//
		//
		//
		// //kretanje prepreke
		// KeyValue kv = new KeyValue(prepreka.layoutXProperty(), 15);
		// KeyFrame kf = new KeyFrame(Duration.seconds(2), kv);
		// time.getKeyFrames().add(kf);
		// time.setCycleCount(Timeline.INDEFINITE);
		// time.play();
		// // Creating camera

		// // Creating a scene object
		// Scene scene = new Scene(root, 900, 400);
		// scene.setCamera(camera);
		// // Setting title to the Stage
		// primaryStage.setTitle("Fox game");
		//
		// scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
		//
		// @Override
		// public void handle(KeyEvent event) {
		// switch (event.getCode()) {
		// case A:
		// fox.setTranslateX(fox.getTranslateX()-1);
		// break;
		// case D:
		// fox.setTranslateX(fox.getTranslateX()+1);
		// break;
		// case W:
		// fox.setTranslateZ(fox.getTranslateZ()+1);
		// break;
		// case S:
		// fox.setTranslateZ(fox.getTranslateZ()-1);
		// break;
		// case SPACE:
		// fox.setTranslateY(fox.getTranslateX()+3);
		// fox.setTranslateY(fox.getTranslateX()-3);
		// default:
		// break;
		// }
		// }
		// });
		// // Adding scene to the stage
		// primaryStage.setScene(scene);
		// // Displaying the contents of the stage

		// at.start();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
