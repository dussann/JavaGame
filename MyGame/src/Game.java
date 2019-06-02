
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
import javafx.scene.SubScene;
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

	public ViewManager manager;
	public GameManager gameManager;
	double timeStart = Double.NaN;
	Point3D[] startAndPoints = new Point3D[] { new Point3D(-10, 0, 0), new Point3D(10, 0, 0) };

	AnimationTimer timer = new AnimationTimer() {

		@Override
		public void handle(long now) {

			double timeNow = now / 1e9;

			if (Double.isNaN(timeStart)) {
				timeStart = timeNow;
			}

			double time = timeNow - timeStart;
			double tCycle = time % 3;
			int i = (int) tCycle;
			double t = tCycle % 1;
			Point3D s = startAndPoints[0];
			Point3D d = startAndPoints[1];

			Point3D p = s.multiply(1 - t).add(d.multiply(t));

			manager.getCar().getTransforms().setAll(new Translate(p.getX(), p.getY(), p.getZ()));

			double xDiff = Math.abs(manager.getFox().getXPosition() - p.getX());
			double yDiff = Math.abs(manager.getFox().getZPosition() - manager.getCar().getZPosition());

			if (manager.getCar1() != null) {
				Point3D s1 = startAndPoints[1];
				Point3D d1 = startAndPoints[0];

				Point3D p1 = s1.multiply(1 - t).add(d1.multiply(t));

				manager.getCar1().getTransforms().setAll(new Translate(p1.getX(), p1.getY(), p1.getZ()));
				double xDiff1 = Math.abs(manager.getFox().getXPosition() - p1.getX());
				double yDiff1 = Math.abs(manager.getFox().getZPosition() - manager.getCar1().getZPosition());

				if (gameManager.collision(xDiff1, yDiff1)) {
					manager.getFox().setZPosition(-5);
					if (!gameManager.loseLife()) {
						manager.setLooseMsg();
						timer.stop();
					}
				}
			}
			if (gameManager.collision(xDiff, yDiff)) {
				manager.getFox().setZPosition(-5);
				if (!gameManager.loseLife()) {
					manager.setLooseMsg();
					timer.stop();
				}
			}
			if(gameManager.checkFinishStage()){
				manager.setWinMsg();
				timer.stop();
			}
		}
	};

	public Stage initGame(Stage primaryStage) {
		this.manager = new ViewManager();
		this.gameManager = new GameManager(manager);
		this.manager.addFox();
		this.manager.addPath();
		this.manager.addCar();
		this.manager.setText();
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

		timer.start();
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
