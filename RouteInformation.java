package multiroutevehicleseatreservationsystem;

public class RouteInformation 
{
	
	private int routeId;
	private String source;
	private String destination;
	
	
	public RouteInformation(int routeId, String source, String destination) 
	{
		super();
		this.routeId = routeId;
		this.source = source;
		this.destination = destination;
	}
	
	
	
	public int getRouteId()
	{
		return routeId;
	}
	
	public String getRouteName()
	{
		return source +" to "+ destination;
	}
	
	

}
