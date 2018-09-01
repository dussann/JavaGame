
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

public class Game extends Application  {

	float i = 0.1f;
	Box prepreka, fox, traka;


	@Override
	public void start(Stage primaryStage) {
		AnimationTimer at = new AnimationTimer() {

			@Override
			public void handle(long now) {
//				System.out.println("lisica"+ fox.getLayoutX());
//				System.out.println("auto" + prepreka.getLayoutX());
				if(
						fox.getTranslateY() == prepreka.getTranslateY()  &&
						fox.getTranslateX() == prepreka.getTranslateX() &&
						fox.getTranslateZ() == prepreka.getTranslateZ()
				){
					System.out.println("===============================");
				}
//				System.out.println(fox.getLayoutX());
//				System.out.println(prepreka.getLayoutX());
//				traka.setLayoutX(-5);




			}
		};
		// Drawing a Box
		traka = new Box(15, 1, 5);
		traka.setTranslateX(7);

		prepreka = new Box(2, 2, 2);
		Material mat = new PhongMaterial(Color.RED);
		Material matFox = new PhongMaterial(Color.YELLOW);
		prepreka.setMaterial(mat);

		fox = new Box(1,1,1);


		fox.setTranslateZ(-2);
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
		camera.setTranslateZ(-40);
		// camera.setTranslateX(-20);

		camera.setFieldOfView(35);

		// Creating a scene object
		Scene scene = new Scene(root, 900, 400);
		scene.setCamera(camera);
		// Setting title to the Stage
		primaryStage.setTitle("Fox game");

		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				switch (event.getCode()) {
				case A:
					fox.setTranslateX(fox.getTranslateX()-1);
					break;
				case D:
					fox.setTranslateX(fox.getTranslateX()+1);
					break;
				case W:
					fox.setTranslateZ(fox.getTranslateZ()+1);
					break;
				case S:
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
		at.start();
		new CameraController(scene, camera, new Point3D(0, -20, -40), new Point3D(0, 0, 0));

	}

	public static void main(String[] args) {
		launch(args);
	}
}
