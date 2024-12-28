package phase2;
import java.util.Scanner;
public class main {
static int currentYear=2024, currentMonth= 10, currentDay=10;//global variables
	public static void main(String[] args) {
Scanner input=new Scanner(System.in);

System.out.println("_____________________________");
System.out.println("Welcome to  car rental shop");	
System.out.println("_____________________________");	

boolean validDate;
int bookingMonth;
int bookingYear;

do {//Checking valid month and year
	validDate = true;
	System.out.println("Enter vaild Month And Year:");
	bookingMonth=input.nextInt();
	bookingYear=input.nextInt();
	
	if (bookingMonth < 1 || bookingMonth > 12 ) {
		validDate=false;
		continue;	
	}	
	
	if (bookingYear < currentYear ) {
		validDate = false;
		continue;
	}
	
	if ( bookingYear == currentYear && bookingMonth < currentMonth) {
		validDate = false;
		continue;
	}
	
	validDate = true;
	} while ( validDate == false );//end do

//declare all items we need for the car rental
Item item1= new Item("Tesla model x","10001",500.0);
Item item2= new Item("Porshe 911","10002",2000.0);
Item item3= new Item("Range rover vilar","10003",1700.0);
Item item4= new Item("Gmc yukun","10004",800.0);

//declare to read menu choices	
		int choice1 = 0;
		int customerChoice = 0;
		int managerchoice;
		
		do {// main menu
			System.out.println("Please choose your prefernce");
			System.out.println("1. Manager menu");
			System.out.println("2. Customer menu");
			System.out.println("3. Exit");
			System.out.println("Choose an option:");
			choice1 = input.nextInt();	
			
			switch(choice1) {
			case 1: // manager
			
			do {
					//manager menu
			        System.out.println("Manger Menu:");
					System.out.println("1. All rental information");
					System.out.println("2. Booking information for a specific car");
					System.out.println("3.Overall profit from all rentals");
					System.out.println("4.Profit for a specific car");
					System.out.println("5.Return to main menu");
					System.out.println("Choose an option:");
					 managerchoice=input.nextInt();
						
					switch(managerchoice) {
					case 1:
					//print all rental information	
                    System.out.println("\n--------All booking information--------");
                    item1.printInfo();
                    item2.printInfo();
                    item3.printInfo();
                    item4.printInfo();
                    break;
                    
					case 2://needs checking
						// print booking information for a specific car
						System.out.printf("%-15s , Id: %-5s \n",item1.getName() + item1.getId());//check
						System.out.printf("%-15s , Id: %-5s \n",item2.getName() + item2.getId());
						System.out.printf("%-15s , Id: %-5s \n",item3.getName() + item3.getId());
						System.out.printf("%-15s , Id: %-5s \n",item4.getName() + item4.getId());
						System.out.println("Enter car id:");
                        String id=input.next();
                    
                    if(id.equals(item1.getId() ))
                        item1.printInfo();
                    else if(id.equals(item2.getId() ))
                        item2.printInfo();
                    else if(id.equals(item3.getId() ))
                        item3.printInfo();
                    else if(id.equals(item4.getId() ))
                        item4.printInfo();
                    else
                    	System.out.println("Invalid id.");
                    break;
                    
					case 3:// print overall profit from all rentals
						double totalProfit= item1.getProfit() +item2.getProfit() +item3.getProfit() +item4.getProfit();
						System.out.println("\n --------Overall profit--------");
						System.out.printf("Total profit: %.2f \n",totalProfit);
					break;
                    
					case 4://print profit for a specific car
						System.out.printf("%-15s , Id: %-5s \n", item1.getName() + item1.getId());//check
						System.out.printf("%-15s , Id: %-5s \n", item2.getName() + item2.getId());
						System.out.printf("%-15s , Id: %-5s \n",item3.getName() + item3.getId());
						System.out.printf("%-15s , Id: %-5s \n",item4.getName() + item4.getId());
						System.out.println("Enter car id:");
                         id=input.next();
                         if(id.equals(item1.getId() ))
                        System.out.println("The profit for this car is:" + item1.getProfit());
                         else if(id.equals(item2.getId() ))
                        System.out.println("The profit for this car is:" + item2.getProfit());
                         else if(id.equals(item3.getId() ))
                        System.out.println("The profit for this car is:" + item3.getProfit());
                         else if(id.equals(item4.getId() ))
                        System.out.println("The profit for this car is:" + item4.getProfit());
                         else
                         	System.out.println("Invalid id.");
                         break;
                         
					case 5 :
						System.out.println("Return to main menu.");	
                    break;
                    default:
                    	System.out.println("Invalid option, please try again.");
                    	}//switch manager
			}while(managerchoice != 5);// end manager menu
			
			break;//end case 1 manager
			
			case 2 ://customer menu
				boolean Booked=false;
				do {
				
				System.out.println("\n Customer Menu:");
                System.out.println("1. Book a car");
                System.out.println("2. Cancel a booking");
                System.out.println("3. View popular car");
                System.out.println("4. Return to Main Menu");
                System.out.println("Choose an option: ");
                customerChoice = input.nextInt();	
                
                switch(customerChoice) {
              
                String CarId="";//variable to store the car id that the customer will choose
                
                case 1 :// Booking Process
                	System.out.printf("%-15s , Id: %-5s, Price: %-8.2f\n", item1.getName() , item1.getId(), item1.getPrice());//check
                	System.out.printf("%-15s , Id: %-5s, Price: %-8.2f\n", item2.getName() , item2.getId(), item2.getPrice());
                	System.out.printf("%-15s , Id: %-5s, Price: %-8.2f\n", item3.getName() , item3.getId(), item3.getPrice());
                	System.out.printf("%-15s , Id: %-5s, Price: %-8.2f\n", item4.getName() , item4.getId(), item4.getPrice());
                
                	System.out.print("Enter the car id you wish to book : ");
                	CarId= input.next();
                	
                	//validate the car id
                	while(!CarId.equals(item1.getId()) && !CarId.equals(item2.getId()) && CarId.equals(item3.getId()) && CarId.equals(item4.getId())) {
                	System.out.println("Invalid id, please try again");
                	System.out.println("Enter the car id you wish to book : ");
                	CarId= input.next();
                	}//end while
                	
                	int day;
                	do {
                		System.out.println("Enter a day to book:");//checking the day validation	
                	day=input.nextInt();
                	}while(!isValid(day,BookingMonth,BookingYear));
                	
                	String customerId;
                	boolean validId;
                	do {// checking the id length
                	 System.out.print("Enter Your ID (10 Digits) : ");
                     customerId = input.next();
                    
                     int numberOfDigits=0;
                     for(int i=0;i<customerId.length(); i++)
                     if(customerId.charAt(i)>='0' && customerId.charAt(i)<='9')
                    	 numberOfDigits++;
                     if(numberOfDigits==10 && customerId.lenght()==10)
                    	 validId=true;
                     else
                    	 validId=false;
                     
                	}while(validId==false);
                	
                	 System.out.print("Enter your name: ");//reading the customer name
                	 input.nextLine();//leftover
                     String customerName = input.nextLine();
                    
                     if(CarId.equals(item1.getId())&& item1.book(customerId, customerName, day, bookingMonth, bookingYear) )
                	 Booked=true;
                	
                     else if(CarId.equals(item2.getId())&& item2.book(customerId, customerName, day, bookingMonth, bookingYear) )
                    	 Booked=true;
                     
                     else if(CarId.equals(item3.getId())&& item3.book(customerId, customerName, day, bookingMonth, bookingYear) )
                    	 Booked=true;
                     else if(CarId.equals(item4.getId())&& item4.book(customerId, customerName, day, bookingMonth, bookingYear) )
                    	 Booked=true;
                 	if(Booked==true)
                 		 System.out.println("Booking is successful ");
                 	else
                 		 System.out.println("Couldn't book");
                     break;//end booking
                     
                case 2://not done yet
                	
                	
                	
                case 3://most popular
                	//calling method getPoplatItem
                	getPopulatItem(item1, item2,item3,item4);
                	break;
                	
                case 4:	//exiting customer menu
                	 System.out.println("Exit customer menu");
               break;
               
               default:
            	   System.out.println("Invalid option, please try again.");
                     
                }//end switch customer choice
                	
            
				
				}while(customerChoice!=4);//end customer menu
				break;//end case 2 customer
				
				case 3 :
					//Exit the program	
            		System.out.println("Thank you for visiting.");
            		break;
            		
				default:
       			 System.out.println("Invalid option, please try again.");
			}//end switch choise1
			
		}while(choice1!= 3);//end main menu
			
			
			
			
			
                   
	}//end main	
	

public static boolean isLeap(int year) {
	// will return true or false depends on the condition
        return (year % 4 == 0 && year % 100 != 0 || (year % 400 == 0));  
	
}

public static boolean isValid(int day, int month, int year) {
	// check if the month and day valid or not
	if (month < 1 || month > 12 || day < 1) 
        return false;
         
        int maxDay=getNumberOfDays(month, year);
        if(day> maxDay)
        	return false;
        
        if (year== currentYear && month==currentMonth && day <currentDay)
        return false;
        
        return true;
        
	}//end isValid

public static int getNumberOfDays(int month , int year) {
	// switch for the months
	switch (month) {
	// April , June , September , November -> those months have 30 days
	case 4 : case 6 : case 9 : case 11 :
		return 30;
	// February 
	case 2 :
		{
			// if the year is leap February will have 29 days
			if(isLeap(year))
			return 29;
			// if not will have 28 days 
		else
			return 28;}
		// January , March , May, July, August , October , December -> have 31 days
		default:
			return 31;
	}

	
}
public static void getPopularItem(Item item1, Item item2, Item item3, Item item4){
	// Checks if there is any booking
			if(item1.getNumberOfBooking()==0 &&item2.getNumberOfBooking()==0 &&item3.getNumberOfBooking()==0 &&item4.getNumberOfBooking()==0 )
				  System.out.println("There is no popular item at this moment.");
			
			
			// Checks which item has most booking
			else
			{	int maxBookings = Math.max(
		            Math.max(item1.getNumberOfBooking(), item2.getNumberOfBooking()),
		            Math.max(item3.getNumberOfBooking(), item4.getNumberOfBooking())
		        );

		        // Print items that match the maximum booking count
		        System.out.println("Most Popular Item(s):");
		        if (item1.getNumberOfBooking() == maxBookings) {
		            System.out.println("Name: " + item1.getName());
		            System.out.println("ID: " + item1.getId());
		            System.out.println("Price: " + item1.getPrice());
		            System.out.println("Profit: " + item1.getProfit());
		            System.out.println("Bookings: " + item1.getNumberOfBooking());
		            System.out.println();
		        }
		        if (item2.getNumberOfBooking() == maxBookings) {
		            System.out.println("Name: " + item2.getName());
		            System.out.println("ID: " + item2.getId());
		            System.out.println("Price: " + item2.getPrice());
		            System.out.println("Profit: " + item2.getProfit());
		            System.out.println("Bookings: " + item2.getNumberOfBooking());
		            System.out.println();
		        }
		        if (item3.getNumberOfBooking() == maxBookings) {
		            System.out.println("Name: " + item3.getName());
		            System.out.println("ID: " + item3.getId());
		            System.out.println("Price: " + item3.getPrice());
		            System.out.println("Profit: " + item3.getProfit());
		            System.out.println("Bookings: " + item3.getNumberOfBooking());
		            System.out.println();
		        }
		        if (item4.getNumberOfBooking() == maxBookings) {
		            System.out.println("Name: " + item4.getName());
		            System.out.println("ID: " + item4.getId());
		            System.out.println("Price: " + item4.getPrice());
		            System.out.println("Profit: " + item4.getProfit());
		            System.out.println("Bookings: " + item4.getNumberOfBooking());
		            System.out.println();
		        }
				
				
			}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}}//end class


	
	
