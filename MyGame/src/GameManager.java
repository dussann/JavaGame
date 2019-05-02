import javafx.beans.property.DoubleProperty;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import models.Car;
import models.Fox;
import view.ViewManager;

public class GameManager {

	int i = 0;
	int y = 0;
	private ViewManager manager;

	public GameManager(ViewManager manager) {
		this.manager = manager;
	}

	public void checkCrash(Fox fox, Car car) {

		double foxLeftArea = fox.getLeftSideArea();
		double foxRightArea = fox.getRightSideArea();
		double foxFrontArea = fox.getFrontSideArea();
		double foxBackArea = fox.getBackSideArea();

		double carLeftArea = car.getLeftSideArea();
		double carRightArea = car.getRightSideArea();
		double carFrontArea = car.getFrontSideArea();
		double carBackArea = car.getBackSideArea();


//		System.out.println(fox.getXPosition());
		System.out.println(car.getXPosition());



	}

	public void checkFinishGame(Fox fox) {
		if (fox.getZPosition() - 5 > 30) {
			System.out.println("presao nivo");
			this.manager.exitStage();
		}
	}
}
