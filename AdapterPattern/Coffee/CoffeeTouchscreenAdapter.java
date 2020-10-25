package Coffee;

public class CoffeeTouchscreenAdapter implements CoffeeMachineInterface {
	OldCoffeeMachine old;
	
	public CoffeeTouchscreenAdapter(OldCoffeeMachine old) {
		this.old = old;
	}
	
	public void chooseFirstSelection() {
		this.old.selectA();
	}
	
	public void chooseSecondSelection() {
		this.old.selectB();
	}

	
	

	
}
