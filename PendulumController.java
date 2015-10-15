package pendulumapp;

public class PendulumController {
	PendulumModel model;
	
	public PendulumController(PendulumModel model) {
		this.model = model;
	}
	
	public void faster() {
		int speed = model.getSpeed();
		if(speed > 5)
			model.setSpeed(speed - 3);
	}

	public void slower() {
		int speed = model.getSpeed();
		model.setSpeed(speed + 3);
	}

	public void shorter() {
		int len = model.getLength();
		if(len > 40)
			model.setLength(len - 10);
	}

	public void longer() {
		model.setLength(model.getLength() + 10);
	}

	public void moreResistance() {
		model.setResistance(model.getResistance() * 2);
	}

	public void lessResistance() {
		model.setResistance(model.getResistance() / 2);
	}
	
	public void restart() {
		model.restart();
	}

}
