
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Game extends Application {

	float i = 0.1f;
	Box prepreka;

	@Override
	public void start(Stage primaryStage) {
		// Drawing a Box
		Box traka = new Box(15, 1, 5);
		traka.setTranslateX(7);

		prepreka = new Box(2, 2, 2);

		// Creating a Group object
		Group root = new Group(traka);
		root.getChildren().add(prepreka);

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
		camera.setTranslateX(10);

		camera.setFieldOfView(45);

		// Creating a scene object
		Scene scene = new Scene(root, 600, 300);
		scene.setCamera(camera);
		// Setting title to the Stage
		primaryStage.setTitle("Drawing a Box");

		// Adding scene to the stage
		primaryStage.setScene(scene);

		// Displaying the contents of the stage
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
