package multiroutevehicleseatreservationsystem;

import java.util.ArrayList;

import mock.Vehicle;

public class VehicleRouteInformation 
{
	
	public static ArrayList<VehicleInformation> getVehicleByRoute(int routeId)
	{
		ArrayList<VehicleInformation> vehicles = new ArrayList();
		
		switch(routeId)
		{
			case 1: 
				vehicles.add(new VehicleInformation(1, "Shine Bike", 1, 300));
				vehicles.add(new VehicleInformation(2, "Innova Car", 7, 800));
				vehicles.add(new VehicleInformation(3, "TATA AC Seater Bus ", 40, 400));
				vehicles.add(new VehicleInformation(4, "BharatBenz AC Sleeper Bus", 30, 1200));
				break;
				
				
			case 2:
				vehicles.add(new VehicleInformation(1, "Innova Car", 7, 1800));
				vehicles.add(new VehicleInformation(2, "BharatBenz AC Sleeper Bus", 30, 2500));
				break;
				
				
			case 3:
				vehicles.add(new VehicleInformation(1, "TATA AC Seater Bus", 40, 900));
				vehicles.add(new VehicleInformation(2, "BharatBenz AC Sleeper Bus", 30, 1600));
				break;
				
				
			case 4:
				vehicles.add(new VehicleInformation(1, "TATA AC Seater Bus", 40, 900));
				break;
				
				
			default:
				System.out.println("No Vehicles Available for the Selected Route");
				
		}
		
		return vehicles;
	}

}
