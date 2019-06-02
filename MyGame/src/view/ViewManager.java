package view;

import javafx.collections.ObservableList;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Shape3D;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;
import mars.javafx.CameraController;
import models.Car;
import models.Fox;
import models.Road;

public class ViewManager {

	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private Stage mainStage;
	private Scene mainScene;

	private Group root;
	private Group rezGroup;
	private Fox fox;
	private Road road;
	private Car car, car1;
	private PerspectiveCamera camera;

	private Text life, lifeText, looseMsg, winMsg;

	public ViewManager() {
		this.camera = new PerspectiveCamera(true);
		this.root = new Group();

		this.rezGroup = new Group();

		SubScene game = new SubScene(root, WIDTH, HEIGHT, true, SceneAntialiasing.BALANCED);
		game.setCamera(camera);
		SubScene rezultat = new SubScene(rezGroup, WIDTH, HEIGHT, true, SceneAntialiasing.BALANCED);

		this.mainScene = new Scene(new Group(game, rezultat));

		this.mainStage = new Stage();
		this.mainStage.setScene(this.mainScene);
		new CameraController(mainScene, camera, new Point3D(20, -15, -10), new Point3D(-10, 10, 10));
	}

	public ObservableList<Transform> getTransforms() {
		return car.getTransforms();
	}

	public Text getText1() {
		return this.life;
	}

	public void setLife(int value) {
		this.life.setText(new Integer(value).toString());
	}

	public Text getLife() {
		return this.life;
	}

	public void setLooseMsg() {
		this.looseMsg.setText("You loose");
	}

	public void setWinMsg() {
		this.winMsg.setText("You win!!!");
	}

	public void setText() {
		Font font = new Font(20);
		life = new Text(55, 25, "");
		life.setText(new Integer(3).toString());
		life.setFill(Color.BLACK);
		life.setFont(font);

		lifeText = new Text(10, 25, "Life: ");
		lifeText.setFill(Color.BLACK);
		lifeText.setFont(font);

		looseMsg = new Text(10, 55, "");
		looseMsg.setFill(Color.RED);
		looseMsg.setFont(font);

		winMsg = new Text(10, 55, "");
		winMsg.setFill(Color.BLUE);
		winMsg.setFont(font);

		rezGroup.getChildren().add(life);
		rezGroup.getChildren().add(looseMsg);
		rezGroup.getChildren().add(lifeText);
		rezGroup.getChildren().add(winMsg);
	}

	public Stage getStage() {
		return this.mainStage;
	}

	public void exitStage() {
		this.mainStage.close();
	}

	public Scene getScene() {
		return this.mainScene;
	}

	public void addPath() {
		this.road = new Road();
		this.root.getChildren().add(road.getRoad());
	}

	public void addFox() {
		this.fox = new Fox();
		this.root.getChildren().add(fox.getFox());
	}

	public Fox getFox() {
		return this.fox;
	}

	public void addCar() {
		this.car = new Car();
		this.root.getChildren().add(car.getCar());
	}

	public void addCar1() {
		this.car1 = new Car();
		this.root.getChildren().add(car1.getCar());
	}

	public Car getCar() {
		return this.car;
	}

	public Car getCar1() {
		return this.car1;
	}


	public void addElement(Shape3D element) {
		this.root.getChildren().add(element);
	}

	public boolean checkCrash() {
		return false;
	}

}
