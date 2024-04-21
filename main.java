import java.util.ArrayList; //collection package
import java.text.SimpleDateFormat; //string->date format package
import java.util.*;
import java.text.ParseException; // for exception pakage


public class main {
	public static void main(String[] args) {
		ArrayList<Busdetails> buses = new ArrayList<Busdetails>();//Busdetails ArrayList
				buses.add(new Busdetails(1,true,1));  
				buses.add(new Busdetails(2,false,10)); 
		System.out.println("------Bus information-------");		
		for(Busdetails x : buses) {   //To access the busdetails ArrayList
			x.display();
		}
		System.out.println("-----------------------------");	
		ArrayList<Booking> bookings = new ArrayList<Booking>();//Booking ArraList	
		Scanner scan = new Scanner(System.in);
		int useroption = 1;
		while(useroption == 1) {
			System.out.println("If you want to book press 1 or to exit press 2 : ");	
			useroption = scan.nextInt();	
			if(useroption == 1) {
				System.out.println("Give your details");
				Booking pasenger1 = new Booking();	
				if(pasenger1.isAvailable(buses,bookings)) {
					bookings.add(pasenger1);
					System.out.println("Your booking is confirmed");
				}
				else {
					System.out.println("bus is full or try another date");
				}
			}
			else {
				System.out.println("Thanks for your response have a nice day");
			}			
		}		
}
}
class Busdetails {
	private int Bus_no;
	private boolean AC;
	private int capacity;
	//constructor
	Busdetails(int Bus_no,boolean AC,int capacity){
		this.Bus_no = Bus_no;
		this.AC = AC;
		this.capacity = capacity;
	}	
	public int getcapacity() {
		return capacity;
	}	
	public void setcapacity(int capacity) {
		this.capacity = capacity;
	}	
	public boolean getAC() {
		return AC;
	}	
	public void setAC(boolean AC) {
		this.AC = AC;
	}
	public int getbus_no() {
		return Bus_no;
	}	
	public void display() {
		System.out.println("Bus no : "+this.Bus_no+" AC : "+this.AC+" Bus capacity : "+this.capacity);
	}
}
class Booking {
	String name;
	int Bus_no;
	Date date;
	Booking(){
		Scanner scan = new Scanner(System.in);		
		System.out.print("Enter your name : "); name = scan.nextLine();		
		System.out.print("Enter the bus_no : "); Bus_no = scan.nextInt();		
		System.out.print("Enter the date (dd-MM-YYYY)");		
		String dateinput = scan.next();	
		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-YYYY");		
		try {
			date = dateformat.parse(dateinput);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}	
	public boolean isAvailable(ArrayList<Busdetails> buses,ArrayList<Booking> bookings) {
		int capacity=0;
		for(Busdetails bus:buses) {
			if(bus.getbus_no()==Bus_no) {
				capacity = bus.getcapacity();
			}
		}		
		int booked=0;
		for(Booking p : bookings) {
			if(p.Bus_no==Bus_no && p.date.equals(date)) {
				booked++;
			}
		}
		return booked < capacity ?true:false;		
	}
}

