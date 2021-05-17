public class Insect {

    private double weight;
    private int x;
    private int y;

    public static final double DIST_WEIGHT_LOSS_FACTOR = 0.0001;
    private static int population = 0;
    private static final String[] FACTS = {
        "The two main groups of insects are winged and wingless.",
        "There are more than one million insect species.",
        "Insects are cold-blooded.",
        "Spiders are not considered insects."
    };

    public Insect(double initWeight, int initX, int initY) {
        weight = initWeight;
        x = initX;
        y = initY;
        population++;
    }
	
	public double getWeight() {
		return weight;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return Y;
	}

    public static void main(String[] args) {
        System.out.println("Insect population: " + population);
        Insect bug1 = new Insect(10, 100, 90);
        System.out.println("Insect population: " + population);
        Insect bug2 = new Insect(9.5, -300, 400);
        System.out.println("Insect population: " + population);

        bug1.move(1, 10);
        bug2.move(-300, 400);

        System.out.println(produceRandomFact());
    }

    public void eat(double amount) {
        System.out.println("Nibble! Nibble!");
        weight = weight + amount;
    }

    public void move(int newX, int newY) {
        double distance = calculateDistance(x, y, newX, newY);
        if (distance > 0) {
            x = newX;
            y = newY;
            weight = weight * DIST_WEIGHT_LOSS_FACTOR * distance;
            System.out.printf("Moved %.2f units\n", distance);
        }
        else
        {
            System.out.println("Staying put.");
        }
    }
    
    private static double calculateDistance(int x1, int y1, int x2, int y2)
    {
        return Math.sqrt((y2-y1)*(y2-y1) * (x2-x1)*(x2-x1));
    }

    public static String produceRandomFact() {
        int index = (int) (Math.random() * ((FACTS.length - 1) + 1));
        return FACTS[index];
    }


}