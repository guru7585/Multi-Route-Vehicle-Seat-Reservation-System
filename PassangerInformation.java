package multiroutevehicleseatreservationsystem;

public class PassangerInformation 
{
	
	private String name;
	private int age;
	private String gender;
	private String mobileNo;
	
	public PassangerInformation(String name, int age, String gender, String mobileNo)
	{
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.mobileNo = mobileNo;
	}
	
	
	public void display()
	{
		System.out.println("Passanger Name : - "+name);
		System.out.println("Age : - "+age);
		System.out.println("Gender : - "+gender);
		System.out.println("Mobile Number : - "+mobileNo);
	}
	

}
