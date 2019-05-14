import javafx.beans.property.DoubleProperty;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import models.Car;
import models.Fox;
import view.ViewManager;

public class GameManager {

	int i = 0;
	int y = 0;
	public final double zbirPolusirina = 1.05d;
	private int life = 3;

	private ViewManager manager;

	public GameManager(ViewManager manager) {
		this.manager = manager;
	}

	public int getLife(){
		return life;
	}

	public boolean loseLife(){
		this.life--;
		if(life == 0){
			return false;
		}
		manager.setText1(life);
		return true;
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
			this.manager.exitStage();
		}
	}
}
