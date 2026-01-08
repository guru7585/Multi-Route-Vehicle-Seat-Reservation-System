package multiroutevehicleseatreservationsystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class VehicleSeatReservationSystem {

	public static void main(String[] args) 
	{
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("*****************************************************");
		System.out.println("Welcome to Developers Traveller Company");
		System.out.println("Vehicle Seat Reservation System");
		System.out.println("*****************************************************");
		
		
		ArrayList <RouteInformation> routes = new ArrayList();
		routes.add(new RouteInformation(1, "Pune", "Mumbai"));
		routes.add(new RouteInformation(2, "Mumbai", "Delhi"));
		routes.add(new RouteInformation(3, "Pune", "Bangalore"));
		routes.add(new RouteInformation(4, "Nagpur", "Hyderabad"));
		
		System.out.println("======= Select Route =======");
		for(RouteInformation r : routes)
		{
			System.out.println(r.getRouteId() +" "+ r.getRouteName());
		}
		
		System.out.print("Enter Route Choice : - ");
		int routeChoice = sc.nextInt();
		
		
		if(routeChoice < 1 || routeChoice > routes.size())
		{
			throw new InvalidRouteException("Invalid Route Selection. Please Choose a Valid Route.");
		}
		
		
		RouteInformation selectedRoute = routes.get(routeChoice - 1);
		System.out.println("Route Selected : - "+selectedRoute.getRouteName());
		
		
		System.out.print("\nEnter Travel Date in Formate (dd-MM-yyyy) [Within next 8 days from Today] : - ");
		String travelDateOfPassanger = sc.next();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate travelDate = LocalDate.parse(travelDateOfPassanger, formatter);
		
		LocalDate today = LocalDate.now();
		LocalDate lastAllowedDate = today.plusDays(8);
		
		if(travelDate.isBefore(today) || travelDate.isAfter(lastAllowedDate))
		{
			System.out.println("Invalid Date. Please Enter a Date Within the Next 8 Days");
			
		}
			
		System.out.print("Enter Travel Time 7 OR 8 PM ONLY. Because Our Travels Operate in Night Only : - ");
		int travelTime = sc.nextInt();
		
		if(travelTime != 7 && travelTime != 8)
		{
			System.out.print("Vehicles Operate Only At 07 : 00 and 08 : 00 PM Only. Please Enter a Valid Integer Formate Time : - ");
		
		}
		
		
		ArrayList <VehicleInformation> vehicles = VehicleRouteInformation.getVehicleByRoute(routeChoice);
		
		if(vehicles.isEmpty())
		{
			System.out.println("No Vehicles Available for this Route");
			return;
		}
		
		while(true)
		{
			System.out.println("\n======= Reservation Menu =======");
			System.out.println("1 For View Vehicles & Seats");
			System.out.println("2 For Book Seat");
			System.out.println("3 For Exit");
			System.out.print("Enter Your Choice : - ");
			
			int choice = sc.nextInt();
			
			switch(choice)
			{
				case 1:
					for(VehicleInformation v : vehicles)
					{
						System.out.println("\n"+v.getVehicleId()+". For "+v.getVehicleName()+" | Available Seats : - "+v.getAvailableSeats()+ " | Price in Rupees : - "+v.getPrice());
						v.displayAvailableSeats();
					}
					break;
					
					
				case 2:
					System.out.print("Select Vehicle : - ");
					int vid = sc.nextInt();
					
					if(vid < 1 || vid > vehicles.size())
					{
						System.out.println("Invalid Vehicle Selection. Please Select a Valid Vehicle");
						break;
					}
					
					VehicleInformation selectedVehicle = vehicles.get(vid - 1);
					selectedVehicle.displayAvailableSeats();
					
					System.out.print("Choose Seat Number : - ");
					int seatNo = sc.nextInt();
					
					if(selectedVehicle.bookSeat(seatNo) == -1)
					{
						System.out.println("This Seat is Not Available. Select Another Seat");
						break;
					}
					
					sc.nextLine();
					System.out.print("Passanger Name : - ");
					String name = sc.nextLine();
					
					System.out.print("Age : - ");
					int age = sc.nextInt();
					
					sc.nextLine();
					System.out.print("Gender : - ");
					String gender = sc.nextLine();
					
					System.out.print("Mobile Number : - ");
					String mobileNo = sc.nextLine();
					
					PassangerInformation  p = new PassangerInformation(name, age, gender, mobileNo);
					TicketDisplay t = new TicketDisplay();
					
					System.out.println("\n------- Booking Confirmed -------");
					p.display();
					t.ticket();
					t.display();
					System.out.println("Route : - "+selectedRoute.getRouteName());
					System.out.println("Date : - "+travelDate);
					System.out.println("Time : - "+String.format("%02d:00 PM", travelTime));
					System.out.println("Vehicle : - "+selectedVehicle.getVehicleName());
					System.out.println("Seat No. : - "+seatNo);
					System.out.println("Amount Paid : - ₹ "+selectedVehicle.getPrice());
					
					break;
					
					
					
				case 3:
					System.out.println("Thank You for Choosing Developers Traveller Company! ");
					return;
					
				
					
				default:
					System.out.println("Invalid Choice.");
					
					
					
			}
		}
		
		
	}

}
