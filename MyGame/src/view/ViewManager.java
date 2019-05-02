package view;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Box;
import javafx.scene.shape.Shape3D;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;
import models.Car;
import models.Fox;
import models.Road;

public class ViewManager {

	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private Stage mainStage;
	private Scene mainScene;
	private Group root;
	private Fox fox;
	private Road road;
	private Car car;

	public ViewManager() {
		this.root = new Group();
		this.mainScene = new Scene(this.root, WIDTH, HEIGHT, true);
		this.mainStage = new Stage();
		this.mainStage.setScene(this.mainScene);
	}

	public  ObservableList<Transform> getTransforms() {
		return car.getTransforms();
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

	public Car getCar() {
		return this.car;
	}

	public void addElement(Shape3D element){
		this.root.getChildren().add(element);
	}

	public boolean checkCrash() {
		return false;
	}

}
