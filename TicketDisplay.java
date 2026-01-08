package multiroutevehicleseatreservationsystem;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

public class TicketDisplay 
{
	
	private String ticketId;
	private LocalDate bookingDate;
	
	
	private LocalTime bookingTime = LocalTime.now();	
	
	int hour = bookingTime.getHour();
	int minute = bookingTime.getMinute();
	int second = bookingTime.getSecond();
	
	
	public void ticket()
	{
		ticketId = UUID.randomUUID().toString().substring(0, 8);
		bookingDate = LocalDate.now();
		
	}
	
	
	public void display()
	{
		System.out.println("Ticket ID : - "+ticketId);
		System.out.println("Booked Date : - "+bookingDate);
		System.out.println("Booked At Time : - "+hour+":"+minute+":"+second);
		
	}

}
