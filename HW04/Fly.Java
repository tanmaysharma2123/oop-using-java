public class Fly {
    
    // instance variables
    private double mass;
    private double speed;
	
	private static final double DEFAULT_SPEED = 10.0;
	private static final double DEFAULT_MASS = 5.0;

    // constructor
    public Fly(double mass) {
		this (mass, DEFAULT_SPEED);
	}
	
	public Fly() {
		this (DEFAULT_MASS, DEFAULT_SPEED);
	}
	
	public Fly(double mass, double speed) {
		this.mass = mass;
		this.speed = speed;
	}
	
	// Getters
	public double getMass() {
		return mass;
	}
	
	public double getSpeed() {
		return speed;
	}
	
	// Setters
    public void setMass(double newMass) {
		if (isLegalMass(newMass)) {
			mass = newMass;
		}
	}
	
	public static boolean isLegalMass(double newMass) {
		return (newMass >= 0 ? true : false );
	}
    
    public void setSpeed(double newSpeed) {
        if (isLegalSpeed(newSpeed)) {
			speed = newSpeed;
		}			
	}
	
	public static boolean isLegalSpeed(double newSpeed) {
		return (newSpeed >= 0 ? true : false );
	}	
	
	public String toString() {
		if(mass > 0) {
			return "I’m dead, but I used to be a fly with a speed of " + speed + ".";
		}
		else {
			return "I’m a speedy fly with " + speed + " speed and " + mass + " mass.";
		}
	}
	
	public void grow(int addedMass) {
		mass += addedMass;
		if(mass < 20) {
			while(mass!=20)
			{
				speed += 1;
				mass += 1;
			}
		}
		else {
			while(mass != 20) {
				speed -= 0.5;
				mass -= 1;
			}
		}
	}
	
	public boolean isDead() {
		if(mass==0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		Fly fly1 = new Fly();
		System.out.println(fly1.toString());
	}
	
}