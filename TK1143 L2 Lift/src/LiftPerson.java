
public class LiftPerson extends Lift{

	private int maxperson;
	private Person pinlift;
	private int total = 0;
	private int i = 0;

	public LiftPerson(int ld, int spd, int maxp) {
		super(ld,spd);
		maxperson = maxp;
	}

	public void setPersoninLift(Person p) {
		i++;
		if(total + p.getWeight() <= super.getLoad()){
			if(i<=maxperson) {
				pinlift = p;
				System.out.println(pinlift + "kg is in the lift");
				total += p.getWeight();
			}
			else
				System.out.println(p.toString() + "kg cannot enter the lift because over limit person");
		}
		else
			System.out.println(p.toString() + "kg cannot enter the lift because overload");
	}

}
