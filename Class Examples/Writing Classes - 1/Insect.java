public class Insect {

    /*
     * instance variables here
     * 
     * An instance variable is not local to a specific method or block statement. It
     * is declared at the class level, and that's why instance variables are also
     * designated as class members.
     * 
     * ANY VARIABLE OR METHOD THAT IS DECLARED IN THIS SCOPE
     * 
     * IS CALLED A CLASS MEMEBER.
     * 
     * A class might have multiple methods that represent diffe- rent behaviours,
     * and these methods may need to change the state of an object when invoked.
     * Defining a variable in a class outside of a method gives all of the methods
     * in the class the ability to change it instead of just one.
     * 
     */

    /*
     * Visibility Modifiers (public & private)
     * 
     * Encapsulation - A class itself should govern how the instance variables of
     * its objects are manipulated so that the objects operate as they are intended.
     * 
     * Private Keyword - Enforces encapsulation by giving access to an instance
     * variable to just the methods within its class. These methods can be trusted
     * as they, like the instance variables, are members of the same class.
     * 
     * Public Keyword - does the opposite of private. When applied to a member of a
     * class, it allows an external class to have untethered access to that member.
     * 
     * Due to encapsulation, instance variables should not be public, becuase, for
     * e.g., to write a new class that creates an instance of Insect and does
     * something silly, accidental, or malicious like directly set the weight
     * variable of that instance to a negative number.
     * 
     */

    private double weight;
    private int x;
    private int y;

    /*
     * Static Modifiers - It turns a member into a shared entity across all objects
     * of a class. 
     */

    public static final double DIST_WEIGHT_LOSS_FACTOR = 0.0001;
    private static int population = 0;
    private static final String[] FACTS = {
        "The two main groups of insects are winged and wingless.",
        "There are more than one million insect species.",
        "Insects are cold-blooded.",
        "Spiders are not considered insects."
    };

    /*
     * Constructor - The 'new' operator first operator first creates an instance of
     * some class and then calls a special method, called the Constructor.
     * 
     * It's the Constructor job to initialize the data or state of the new instance
     * by giving values to its instance variables.
     * 
     * Whenever any class is written, it is given a default constructor & it
     * initializes each instance variable with default values: 
     * -----Instance Variable Type------|--------Default type---------
     *          numeric primitive types |             0
     *                 boolean          |           false
     *          class (object type)     |           null
     * 
     * 
     * When we write Constructor, it must declare form of parameter that will accept
     * these values from a caller of the constructor and then assign the values to
     * the instance variables accordingly.
     * 
     * The constructor is public since we ultimately want other classes to have the
     * ability to create instances of our class.
     * 
     * The Constructor has no return type, as they are the only kinds of methods
     * that can be declared without one, and they have to be. If provided one, it
     * will show compile error.
     * 
     * The name of the Constructor must be the same as the class.
     * 
     * The descriptive names we use in a constructor's formal parameters help
     * determine which order to put the actual parameter.
     * 
     * The soon we create our own constructor, the default one is no longer
     * available. So, this will create a compiler error: Insect bug1 = new Insect();
     * 
     */
    public Insect(double initWeight, int initX, int initY) {
        weight = initWeight;
        x = initX;
        y = initY;
        population++;
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

    /*
     * Methods
     *
     * Methods that represents behaviours or actions that we can invoke on a
     * specific object are called instance methods.
     * 
     * The public methods of a class are collectively called its interface, since
     * they represent the points of interaction a client has with a class and its
     * objects.
     * 
     * Methods that do not represent actions that would be performedon the specific
     * object of a class should be static.
     * 
     */

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

    /* Static Methods cannot directly access Static methods.
     * 
     * Static methods can be used without having to create an instance
     * as an object.
     *
     */
    
    private static double calculateDistance(int x1, int y1, int x2, int y2)
    {
        return Math.sqrt((y2-y1)*(y2-y1) * (x2-x1)*(x2-x1));
    }

    public static String produceRandomFact() {
        int index = (int) (Math.random() * ((FACTS.length - 1) + 1));
        return FACTS[index];
    }


}