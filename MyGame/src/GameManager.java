import javafx.beans.property.DoubleProperty;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import models.Car;
import models.Fox;
import view.ViewManager;

public class GameManager {

	int i = 0;
	int y = 0;
	double zbirPolusirina = 1.05d;
	private ViewManager manager;

	public GameManager(ViewManager manager) {
		this.manager = manager;
	}

	public boolean collision(double xDiff, double yDiff){
		if(xDiff < zbirPolusirina){
			if(yDiff < zbirPolusirina){
				return false;
			}
		}
		return true;
	}

	public void checkFinishGame() {
		if (manager.getFox().getZPosition() > 3) {
			System.out.println("presao nivo");
			this.manager.exitStage();
		}
	}
}
