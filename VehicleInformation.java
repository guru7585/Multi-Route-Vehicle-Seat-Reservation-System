package multiroutevehicleseatreservationsystem;

import java.util.HashSet;
import java.util.Set;

public class VehicleInformation 
{
	private int vehicleId;
	private String vehicleName;
	private int totalSeats;
	private int price;
	
	private Set <Integer> bookedSeats = new HashSet();
	
	
	
	public VehicleInformation(int vehicleId, String vehicleName, int totalSeats, int price)
	{
		super();
		this.vehicleId = vehicleId;
		this.vehicleName = vehicleName;
		this.totalSeats = totalSeats;
		this.price = price;
		
	}	
	
	public int getVehicleId() {
		return vehicleId;
	}


	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}


	public String getVehicleName() {
		return vehicleName;
	}


	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}


	public int getTotalSeats() {
		return totalSeats;
	}


	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}




	
	
	public int getAvailableSeats()
	{
		return totalSeats - bookedSeats.size();
	}
	
	
	
	
	
	public int bookSeat(int seatNo)
	{
		if(seatNo < 1 || seatNo > totalSeats || bookedSeats.contains(seatNo))
		{
			return -1;
		}
		
		bookedSeats.add(seatNo);
		return seatNo;
	}
	
	
	
	
	
	public void displayAvailableSeats()
	{
		
		System.out.print("Available Seat Numbers are : - ");
		int count = 0;
		
		for(int i = 1; i <= totalSeats; i++)
		{
			if(!bookedSeats.contains(i))
			{
				System.out.print(i+" ");
				count++;
			}
		}
		
		if(count == 0)
		{
			System.out.println("No Seats Available");
		}
		
		System.out.println();
		
		
	}
	
	
	
	

}
