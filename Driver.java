import java.util.Scanner;
public class Driver {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        System.out.println("Welcome to Nancy's Sundae Parlor, The best sundaes north of the border\n");		//welcome message to the program
        System.out.println("How many sundaes could you make today?");
        int maxToday = Input.nextInt();				//intilaizing an integer that will determine the max output for the day
        if (maxToday <= 0) {
            System.out.println("Thank you for using the program Nancy, you have the day off!!!!");
            System.exit(0);}			//exits program if the max output is 0, since no ice cream will be served
        int Orders = 0;			//initializes the amount of orders, which will be counted so more ice cream than the max can be made
        int option =0;			//initializes a variable that will be used to navigate the menus
        Sundae[] sundaes = new Sundae[maxToday];			//creates a 1D array to store the information of each sunday, the size being the max amount made that day
        do {			//do while loop which encompasses the whole program, so that the program can run until the user wants to exit the program
            System.out.println("What do you want to do?\n\t1. Enter a new sundae order\n\t2. Change information of a specific order\n\t"
                    + "3. Display details for all sundaes of a specific ice cream flavor\n\t4. Statistics on today’s sundaes\n\t5. Quit\nPlease enter your choice >");
            option= Input.nextInt();			//input for the navigation of the menus
            if (option > 5 || option < 1) {System.out.println("\nError, Invalid Choice, number must be between 1 and 5");}		//ensures that a valid input is made and will loop till theres a valid input on the menu

            else if (option == 1) {					//creates different sundaes
                if (Sundae.getSundaeCount() >= maxToday) { //Checks against the maximum for the day to ensure that there are enough ingredients to keep making sundaes
                    System.out.println("\nSorry we can't make anymore Sundaes");
                } else {
                    System.out.print("How many scoops? ");
                    int scoops = Input.nextInt();			//input for th eamount of scoops
                    System.out.print("What flavour? ");
                    String flavour = Input.nextLine(); 		//input for the flavour of the ice cream
                    flavour = Input.nextLine(); 			//the line above wasnt working so i added another, which allowed for the flavour input to be accepted
                    System.out.print("Any nuts? (y for yes anything else for no) ");
                    String nuts= Input.next();
                    boolean nut = false;			//boolean to state weather or not the sundae has nuts on it
                    if (nuts.equals("y")) nut= true;
                    sundaes[Orders] = new Sundae(scoops, flavour, nut); //stores the arguments in an array
                    Orders++;	//counts the amount of orders made, after each is made, to ensure the limit isnt broken
                }
            }
            else if (option == 2) {
                String ans="";
                if (Orders == 0) {	//wont allow for further browinsing since there are no sundaes made and no data available
                    System.out.println("there are no orders made");
                } else {
                    do {
                        System.out.println("Which sundae do you wish to modify? "); //propms the user if they would like to modify the sundae order
                        System.out.println("\t--> Valid sundae numbers are 0 to " + (Orders-1) +" inpput an invalid order to prompt an exit screen.");
                        int orderChange = Input.nextInt();
                        if ((0 > orderChange)||(orderChange >= Orders-1)) {		//ensures that the input sundae order exists
                            System.out.println("Sorry no such sundae.");
                            System.out.println("Do you want to enter another sundae number or return to the Main menu (quit to return)?");
                            ans = Input.next();
                        }
                        else {
                            System.out.println("the sundae" +sundaes[orderChange].getSundaeCount()+" "+sundaes[orderChange]); //states the sundae that is being changed
                            System.out.println("What would you like to change?\n\t1. Ice cream flavour\n\t2. Number of scoops\n\t3. Nuts or no nuts\n\t4. Quit\nEnter choice >");
                            int optionEdit = Input.nextInt();
                            while ((1 > optionEdit)||(optionEdit > 4)) { //ensures that a valid menu input is made
                                System.out.println("invalid input, please an integer that is between 1 and 4 including those numbers\n");
                                System.out.println("What would you like to change?\n\t1. Ice cream flavour\n\t2. Number of scoops\n\t3. Nuts or no nuts\n\t4. Quit\nEnter choice >");
                                optionEdit = Input.nextInt();	//initializes a value to browse the menu and make a selection
                            }
                            if (optionEdit == 1) {
                                System.out.println("what new flavour would you like?");
                                String flavour=Input.nextLine();
                                flavour=Input.nextLine();
                                System.out.println("the new flavour is "+flavour); //allows for input of a new flavour
                                sundaes[orderChange].setFlavour(flavour);} //sets the new flavour to the array
                            else if (optionEdit == 2)  {                //option to edit amount of scoops
                                System.out.print("How many scoops? ");
                                int scoops= Input.nextInt();			//changes the amount of scoops within an order
                                sundaes[orderChange].setScoops(scoops);}	//sets the new amount of scoops to the array
                            else if (optionEdit == 3) {		//option to edit nuts
                                if(sundaes[orderChange].getNuts()) {
                                    sundaes[orderChange].setNuts(false);		//will reverse your original nuts order without any input
                                }
                                else {
                                    sundaes[orderChange].setNuts(true);
                                }
                                System.out.println("your new order looks like: "+sundaes[orderChange]);	 //outputs your new sundae order
                            }
                        }
                    } while (!ans.equals("quit")); //exits the do while loop which edits the sundae input
                }
            }
            else if (option == 3) {  // option to display details for all sundaes of a specific ice cream flavor
                if (Orders == 0) {			//unavailable to display if no orders were made
                    System.out.println("there are no orders made");
                } else {
                    System.out.print("What flavour do you want to list of? ");
                    String flavourChoices = Input.nextLine();
                    flavourChoices= Input.nextLine();	//allows for input of a flavour
                    for(int a = 0; a < Orders; a++) {
                        if(sundaes[a].getFlavour().compareToIgnoreCase(flavourChoices)==0) {   //outputs sundae orders with the same ice cream, with thier cost and attributes
                            System.out.println("Sundae # "+sundaes[a].getSundaeCount()+"   "+sundaes[a-1]);}
                    }
                }
            }

            else if (option == 4) {  //Statistics on today’s sundaes
                int optionStat; //initialize variable to choose options within its menu
                if (Orders == 0) {	//unavailable to display if no orders were made
                    System.out.println("there are no orders made");
                } else {
                    do {
                        System.out.println("What information would you like?\n\t1. List all sundaes sold today\n\t2. Details of cheapest sundae\n\t3. Number of sundaes sold today\n\t"
                                + "4. Number of sundaes with a specific # of scoops\n\t5. Average cost of sundaes\n\t6. Quit\nEnter your choice >");
                        optionStat = Input.nextInt(); //give the variable the value of the input
                        while ((1 > optionStat)||(optionStat > 6)) {			//ensures that the input is valid
                            System.out.println("invalid input, please an integer that is between 1 and 6 including those numbers\n");
                            System.out.println("What information would you like?\n\t1. List all sundaes sold today\n\t2. Details of cheapest sundae\n\t3. Number of sundaes sold today\n\t"
                                    + "4. Number of sundaes with a specific # of scoops\n\t5. Average cost of sundaes\n\t6. Quit\nEnter your choice >");
                            optionStat = Input.nextInt();
                        }

                        if(optionStat == 1) {		//List all sundaes sold today
                            for(int a = 0; a < Orders; a++) {
                                System.out.println("Sundae # "+sundaes[a].getSundaeCount()+" "+sundaes[a]);
                            }
                        }
                        else if(optionStat == 2) {		// Details of cheapest sundae, sorts the sundaes by cost and outputs the sundae with the lowest cost
                            Sundae sundae=sundaes[0]; //initliazies a new array to store the order of cost
                            for(int a = 1; a < Orders;a++) {
                                if(sundae.getCost()>sundaes[a].getCost()) {
                                    sundae=sundaes[a];	//adds the cost of each sunday to an array
                                }
                            }
                            System.out.println("Sundae # "+sundae.getSundaeCount()+" "+sundae);
                        }
                        else if(optionStat == 3) {		//Number of sundaes sold today, outputs the total amount of sundays order, through the Orders++
                            System.out.println("Total sundaes sold today is "+Orders);
                        }
                        else if(optionStat == 4) {		//Number of sundaes with a specific # of scoops gives each sundae with the same amount of scoops input
                            System.out.print("Enter scoop: ");
                            int scoops=Input.nextInt();
                            for(int a = 0; a < Orders; a++) { //outputs each sundae with that many
                                if(sundaes[a].getScoops()==scoops) {
                                    System.out.println("Sundae # "+sundaes[a].getSundaeCount()+" "+sundaes[a]); //prints each individually as it goes throguh the for loop
                                }
                            }
                        }
                        else if(optionStat == 5) {		// Average cost of sundaes, adds all the costs of the sundaes and divideds by the amount orders
                            double average = 0;
                            for(int a = 0; a < Orders; a++) { //adds them one at a time as they go thorugh the for loop for each sundae
                                average += sundaes[a].getCost();
                            }
                            System.out.println("Average cost is $"+(average/Orders));
                        }
                    } while (optionStat!=6);	//exits the loop once 6 is input in optionStat
                }
            }
        } while (option != 5);	//exits loop and dispalys an exits message
        System.out.println("Thank you for using the program Nancy!!!!");
        Input.close();
    }
}
