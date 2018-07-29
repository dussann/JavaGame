
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class Game extends Application {

	@Override
	public void start(Stage primaryStage) {
		 //Drawing a Box
	      Box traka = new Box(5, 1, 15);
	      Box prepreka = new Box(2,2,2);



	      //Creating a Group object
	      Group root = new Group(traka);
	      root.getChildren().add(prepreka);

	      PerspectiveCamera camera = new PerspectiveCamera(true);

			camera.setRotationAxis(Rotate.X_AXIS);
			camera.setRotate(-30);

			camera.setTranslateY(-20);
			camera.setTranslateZ(-30);
			camera.setTranslateX(10);

			camera.setFieldOfView(45);

	      //Creating a scene object
	      Scene scene = new Scene(root, 600, 300);
	      scene.setCamera(camera);
	      //Setting title to the Stage
	      primaryStage.setTitle("Drawing a Box");

	      //Adding scene to the stage
	      primaryStage.setScene(scene);

	      //Displaying the contents of the stage
	      primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
