import javafx.beans.property.DoubleProperty;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import models.Car;
import models.Fox;
import view.ViewManager;

public class GameManager {

	int i = 0;
	int y = 0;
	private static final int levels = 2;
	private int currentLevel;
	public final double halfSumWidth = 1.05d;
	private int life = 3;

	private ViewManager manager;

	public GameManager(ViewManager manager) {
		this.manager = manager;
		this.currentLevel = 1;
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
		if(xDiff < halfSumWidth){
			if(yDiff < halfSumWidth){
				return true;
			}
		}
		return false;
	}

	public boolean checkFinishStage() {
		boolean finish = false;
		if (manager.getFox().getZPosition() > 3) {
			this.currentLevel++;
			if(this.currentLevel <= 2){
				manager.getFox().setZPosition(-5);
				manager.getCar().setZPosition(2);
				manager.addCar1();
				manager.getCar1().setZPosition(-2);
				finish = false;
			}else{
				finish = true;
			}
		}
		return finish;
	}
}
