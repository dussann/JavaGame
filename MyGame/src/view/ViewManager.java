package view;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Box;
import javafx.stage.Stage;
import models.Car;
import models.Fox;
import models.Road;

public class ViewManager {

	private static final int WIDTH = 500;
	private static final int HEIGHT = 400;
	private Stage mainStage;
	private Scene mainScene;
	private Group root;
	private Fox fox;
	private Road road;
	private Car car;

	public ViewManager(){
		this.root = new Group();
		this.mainScene = new Scene(this.root,WIDTH,HEIGHT,true);
		this.mainStage = new Stage();
		this.mainStage.setScene(this.mainScene);
	}

	public Stage getStage() {
		return this.mainStage;
	}

	public void exitStage() {
		this.mainStage.close();
	}

	public Scene getScene(){
		return this.mainScene;
	}

	public void addPath() {
		this.road = new Road();
		this.root.getChildren().add(road.getRoad());
	}

	public void addFox(){
		this.fox = new Fox();
		this.root.getChildren().add(fox.getFox());
	}

	public Fox getFox(){
		return this.fox;
	}

	public void addCar(){
		this.car = new Car();
		this.root.getChildren().add(car.getCar());
	}

	public Car getCar() {
		return this.car;
	}

	public boolean checkCrash(){

		return false;
	}



}
