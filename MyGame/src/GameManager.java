import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import models.Car;
import models.Fox;
import view.ViewManager;

public class GameManager {

	int i = 0;
	private ViewManager manager;
	public GameManager(ViewManager manager) {
		this.manager = manager;
	}

	public void checkCrash(Fox fox, Car car){
		double foxX = manager.getFox().getXPosition();
		double foxZ = manager.getFox().getZPosition();
		double carX = manager.getCar().getXPosition();
		double carZ = manager.getCar().getZPosition();

		double minYArea = -10;
		double maxYArea = 10;

		if((foxX>=manager.getCar().getMinDangerArea()) && (foxX<=manager.getCar().getMaxDangerArea())) {
			if((foxZ>=minYArea) && (foxZ<=maxYArea)){
				System.out.println("Gine");
				i++;
				if(i>2){
					this.manager.exitStage();
				}

			}
		}
	}

	public void finishGame(Fox fox){
		if(fox.getZPosition()-5 > 30){
			System.out.println("presao nivo");
			this.manager.exitStage();
		}
	}
}
