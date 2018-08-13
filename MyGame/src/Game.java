
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Material;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Game extends Application {

	float i = 0.1f;
	Box prepreka, fox;


	@Override
	public void start(Stage primaryStage) {
		// Drawing a Box
		Box traka = new Box(15, 1, 5);
		traka.setTranslateX(7);

		prepreka = new Box(2, 2, 2);
		Material mat = new PhongMaterial(Color.RED);
		Material matFox = new PhongMaterial(Color.YELLOW);
		prepreka.setMaterial(mat);

		fox = new Box(1,1,1);

		// fox.setTranslateZ(-5);
		fox.setMaterial(matFox);

		// Creating a Group object
		Group root = new Group(traka);
		root.getChildren().add(prepreka);
		root.getChildren().add(fox);

		// Timeline
		Timeline time = new Timeline();

		//kretanje prepreke
		KeyValue kv = new KeyValue(prepreka.layoutXProperty(), 15);
		KeyFrame kf = new KeyFrame(Duration.seconds(2), kv);
		time.getKeyFrames().add(kf);
		time.setCycleCount(Timeline.INDEFINITE);
		time.play();

		// Creating camera
		PerspectiveCamera camera = new PerspectiveCamera(true);

		camera.setRotationAxis(Rotate.X_AXIS);
		camera.setRotate(-30);

		camera.setTranslateY(-20);
		camera.setTranslateZ(-30);
		// camera.setTranslateX(-20);

		camera.setFieldOfView(45);

		// Creating a scene object
		Scene scene = new Scene(root, 900, 400);
		scene.setCamera(camera);
		// Setting title to the Stage
		primaryStage.setTitle("Drawing a Box");

		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				switch (event.getCode()) {
				case LEFT:
					fox.setTranslateX(fox.getTranslateX()-1);
					break;
				case RIGHT:
					fox.setTranslateX(fox.getTranslateX()+1);
					break;
				case UP:
					fox.setTranslateZ(fox.getTranslateZ()+1);
					break;
				case DOWN:
					fox.setTranslateZ(fox.getTranslateZ()-1);
					break;
				case SPACE:
					fox.setTranslateY(fox.getTranslateX()+3);
					fox.setTranslateY(fox.getTranslateX()-3);
				default:
					break;
				}
			}
		});



		// Adding scene to the stage
		primaryStage.setScene(scene);

		// Displaying the contents of the stage
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
