
import java.sql.Time;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
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
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;
import mars.javafx.CameraController;
import view.ViewManager;

public class Game extends Application {

	// float i = 0.1f;
	// Box prepreka, fox, traka;

	public ViewManager manager;
	public GameManager gameManager;
	double timeStart = Double.NaN;
	Point3D[] startAndPoints = new Point3D[] { new Point3D(-5, 0, 0), new Point3D(5, 0, 0) };

	AnimationTimer timer = new AnimationTimer() {

		@Override
		public void handle(long now) {

			double timeNow = now/1e9;

			if (Double.isNaN(timeStart)) {   // Ako smo prvi put ovde, postavljamo početno vreme.
				timeStart = timeNow;
			}

			double time = timeNow - timeStart;     // Vreme proteklo od starta programa.
			double tCycle = time % 3;              // Vreme proteklo od početka ciklusa (svaki deo ciklusa traje 1s).
			int i = (int) tCycle;                  // Faza ciklusa u kome smo trenutno.
			double t = tCycle % 1;                 // Gde smo unutar trenutne faze, vrednost iz [0, 1).
			Point3D s = startAndPoints[0];                    // PoÄ�etna taÄ�ka trenutne faze.
			Point3D d = startAndPoints[1]; // Krajnja taÄ�ka trenutne faze.

			Point3D p = s.multiply(1 - t).add(d.multiply(t));

			manager.getCar().getTransforms().setAll(new Translate(p.getX(), p.getY(), p.getZ()));

			double xDiff = Math.abs(manager.getFox().getXPosition()  - p.getX());
			double yDiff = Math.abs(manager.getFox().getZPosition()  - manager.getCar().getXPosition());

			double zbirPolusirina = 1.05d;
			System.out.println(manager.getFox().getZPosition());
			if(gameManager.collision(xDiff, yDiff)){
				System.out.println("live");
			}else{
				System.out.println("die");
			}
			gameManager.checkFinishGame();
		}
	};


	public void setCamera(ViewManager manager) {
		PerspectiveCamera camera = new PerspectiveCamera(true);
		manager.getScene().setCamera(camera);
		new CameraController(manager.getScene(), camera, new Point3D(20, -15, -10), new Point3D(-10, 10, 10));
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
					manager.getFox().setXPosition(manager.getFox().getXPosition() - 1);
					break;
				case D:
					manager.getFox().setXPosition(manager.getFox().getXPosition() + 1);
					break;
				case W:
					manager.getFox().setZPosition(manager.getFox().getZPosition() + 1);
					break;
				case S:
					manager.getFox().setZPosition(manager.getFox().getZPosition() - 1);
					break;
				}
			}
		});
		return primaryStage;
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage = this.initGame(primaryStage);

		Group root = new Group();
		Scene s = new Scene(root, 400, 400);
		timer.start();
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
