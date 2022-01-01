public class Sundae {		//creating a class that outlines the different aspects of the sundae, amount of scoops, if it has nuts on it, the flavour of the ice cream, the cost of the sundae and it keeps track the number of sundaes
    private String flavour;
    private int scoops;
    private boolean nuts;
    private double cost;
    private static int numberSundae = 0;

    public Sundae() {		//creating a constructor which initializes each variable within the class and sets it to the default of 0
        flavour = "Cookie Dough";
        scoops = 0;
        nuts = false;
        cost = 0;
        numberSundae++;
    }
    public Sundae(int s, String f, boolean n) {	//creating a constructor which initializes s, n and f and makes them equal to the preivous initilaized variables
        flavour = f;
        scoops = s;
        nuts = n;
        numberSundae++;
        cost = calcCost(s, n);
    }
    public int getScoops () { //Public accessor for scoop
        return scoops;
    }
    public String getFlavour () { //Public accessor for flavour
        return flavour;
    }
    public double getCost () {//Public accessor for cost
        return cost;
    }
    public boolean getNuts () {//Public accessor for nuts
        return nuts;
    }
    public static int getSundaeCount () {//Public accessor for countign sundaes
        return numberSundae;
    }
    public void setScoops (int s) {//Public mutator for scoop
        scoops = s;
    }
    public void setFlavour (String f) {//Public flavour for scoop
        flavour = f;
    }
    public void setNuts (boolean n) {//Public nuts for scoop
        nuts = n;

    }
    public void updateCost(int s, boolean n) { //method that call calcost
        cost = calcCost(s, n);
    }
    public double calcCost(int s, boolean n) { //calculates the cost, taking in to account if it has nut or no nuts
        double nutPrice = 0;
        if (n == true) {
            nutPrice = 1.25;}
        double price = s*1.5+nutPrice;
        return price;
    }
    public String toString() {	//format the printing in the driver, returns a String containing the value of all non-static instance variables in a descriptive message.
        String nutToping = "";
        if (nuts == false)
            nutToping = "no";
        return "the sundae flavour is " + flavour+ ", with " + scoops + " scoops and " +nutToping+ " nuts. This will cost: " + cost +"$.";}
    public boolean equals(Sundae other) { //tests the equality of two different objects
        return (flavour.equals(other.flavour))&&(scoops == other.scoops)&&(nuts == other.nuts);


    }
}
