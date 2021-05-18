public class Frog {
	// instances variables
	private String name;
	private int age;
	private double tongueSpeed;
	private boolean isFroglet;
	private static String species = "Rare Pepe";
	
	private static final int DEFAULT_AGE = 5;
	private static final int DEFAULT_TONGUESPEED = 5;
	
	// Constructor
	public Frog(String name, double ageInYears) {
		this.name = name;
		age = (int) (ageInYears * 12);
		tongueSpeed = DEFAULT_TONGUESPEED;
	}
	
	public Frog(String name) {
		this(name, DEFAULT_AGE, DEFAULT_TONGUESPEED);
	}
	
	public Frog(String name, int age, double tongueSpeed) {
		this.name = name;
		this.age = age;
		this.tongueSpeed = tongueSpeed;
	}
	
	public static void main(String[] args) {
		Frog frog1 = new Frog("hero");
	}
}