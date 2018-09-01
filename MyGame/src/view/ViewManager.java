package view;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewManager {

	private static final int WIDTH = 900;
	private static final int HEIGHT = 400;
	private Stage mainStage;
	private Scene mainScene;
	private Group root;

	public ViewManager(){
		this.root = new Group();
		this.mainScene = new Scene(this.root,WIDTH,HEIGHT);
		this.mainStage = new Stage();
		this.mainStage.setScene(this.mainScene);
	}
	public Stage getStage() {
		return this.mainStage;
	}
}
