package package_o_bots;

public class Task {
	
	String description;
	int eta;
	
	public Task(int random_task) {
		switch (random_task) {
		case 0: this.description = "do the dishes";
				this.eta = 1000;
				break;
		case 1: this.description = "sweep the house";
				this.eta = 3000;
				break;
		case 2: this.description = "do the laundry";
				this.eta = 10000;
				break;
		case 3: this.description = "take out the recycling";
				this.eta = 4000;
				break;
		case 4: this.description = "make a sammich";
				this.eta = 7000;
				break;
		case 5: this.description = "mow the lawn";
				this.eta = 20000;
				break;
		case 6: this.description = "rake the leaves";
				this.eta = 18000;
				break;
		case 7: this.description = "give the dog a bath";
				this.eta = 14500;
				break;
		case 8: this.description = "bake some cookies";
				this.eta = 8000;
				break;
		case 9: this.description = "wash the car";
				this.eta = 20000;
				break;
		}
	}
	
	public int getEta() {
		return this.eta;
	}
	
	public String getDescription() {
		return this.description;
	}

}
