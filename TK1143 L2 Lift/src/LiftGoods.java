
public class LiftGoods extends Lift{

	private int numofeachitem;
	private Goods ginLift;
	private Person pinLift;
	int totalweight = 0;
	
	public LiftGoods(int ld, int spd) {
		super(ld, spd);
	}
	
	public void setPersoninLift(Person c) {
		pinLift = c;
		totalweight += pinLift.getWeight();
		System.out.println(pinLift.toString() + "kg in the lift.");
	}
	
	public void setnumberEACHofbox(int numofitem) {
		numofeachitem = numofitem;
	}
	
	public void setGoodsinLift(Goods g) {
		ginLift = g;
		if((totalweight + (ginLift.getWeight() * numofeachitem)) > super.getLoad()) {
			System.out.println("Sorry, overloaded. Need to reduce number of boxes or try insert next lift!");
		}
		else {
			totalweight += (ginLift.getWeight() * numofeachitem);
			System.out.println(ginLift.toString() + "kg each box with " + numofeachitem +
					" box/es can insert into lift.");
		}
	}
}

