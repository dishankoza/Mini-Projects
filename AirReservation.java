import java.util.*;
import java.lang.*;

class Plane
{
    String destination;
    int id;
    Double time;
    Plane(int id,Double time,String destination)
    {
        this.destination = destination;
        this.time = time;
        this.id = id;
    }

}

class CargoPlane extends Plane
{
    int i=0;
    Double w=0.00,weight,r;
    CargoPlane(String destination,int id,Double time,Double weight)
    {
        super(id, time, destination);
        this.weight = weight;
    }

    Double available_space()
    {
        r = weight-w;
        return r;
    }
    void Add_package(Double wt)
    {
        if(w <= weight)
        {
            i=i+1;
            w = w + wt;
            System.out.println("your package has been added successfully\n");
            System.out.println("Receipt no: "+i);
        }
        else
        {
            System.out.println("sorry there is no space ");
        }
    }
    Double get_time()
    {
        return time;
    }
    int get_id()
    {
        return id;
    }
    void Display()
    {
        System.out.println("\nSource: Mumbai\t        Destination: "+destination);
        System.out.println("\nFlight Id No: "+id+"\tDeparture Time: "+time);
        r= weight - w;
        System.out.println("Available space: "+r);
    }

}

class Flight extends Plane
{
	int flag=0,i=0,j=0,price_firstseat,price_Economyseat;
	 Flight (String destination,int id,Double time)
	 {
        super(id, time, destination);
     }

     boolean [] seating = new boolean[11];
     Scanner input = new Scanner(System.in);
 
     public int makeReservation(int price_firstseat,int price_Economyseat)
     {
         System.out.println("Please type 1 for First Class or 2 for Economy: ");
         int section = input.nextInt();
         if ( section == 1 )
         {
             firstClassSeat();
             return price_firstseat;
         }
         else
         {
             economySeat();
             return price_Economyseat;
         }
     }
                         
     public void firstClassSeat()
     {
         for ( int count = 1; count <= 5; count++ )
         {
             if ( seating[count] == false ) 
             {
                 seating[count] = true; 
                 System.out.println("------------------------------------------------------------------------------------------");
                 System.out.printf("First Class. Seat# %d\n", count);
                 i++;
                 break;
             }
             else if ( seating[5] == true ) 
             {
                 if ( seating[10] == true) 
                 {
                     System.out.println("Sorry, flight fully booked. Next flight is in 3 hours.");
                 }
                 else 
                 {
                     System.out.println("First Class is fully booked. Would you like Economy? 1 for Yes 2 for No");
                     int choice = input.nextInt();
                     if ( choice == 1 )
                     {
                         economySeat();
                     }
                    
                 }
             }
         }
     }   
 
     public void economySeat() 
     {
         for ( int count = 6; count <= 10; count++ )
         {
             if ( seating[count] == false )
             {
                 seating[count] = true;
                 System.out.println("------------------------------------------------------------------------------------------");
                 System.out.printf("Economy. Seat# %d\n", count);
                 j++;
                 break;
             }
             else if ( seating[10] == true ) 
             {
                 if ( seating[5] == true)
                 {
                     System.out.println("Sorry, flight fully booked.");
                     System.exit(0);
                 }
                 else
                 {
                     System.out.println("Economy is fully booked. Would you like First Class? 1 for Yes 2 for No");
                     int choice = input.nextInt();
                     if ( choice == 1 )
                     {
                         firstClassSeat();
                     }
                 }
             }
         }
     }
     Double get_time()
     {
         return time;
     }
     int get_id()
     {
         return id;
     }
	 
	 int seatcheck()
	 {
        if(seating[5]==true && seating[10]==true)
        {
            flag=1;
        }
	 return flag;
     }
     
     void Display()
     {
        System.out.println("\nSource: Mumbai\t        Destination: "+destination);
        System.out.println("\nFlight Id No: "+id+"\tDeparture Time: "+time);
        System.out.println("total no of seats booked in first class:"+i);
        System.out.println("total no of seats booked in Economy class:"+j);
     }
}

class Airline 
{
    Vector <Flight> FlightList = new Vector<>();
    Vector <CargoPlane> cargolist = new Vector<>();
}

class Passenger
{
	String name,emailid;
	int age;
	Passenger(String name,String emailid,int age)
	{
		this.name=name;
		this.age=age;
		this.emailid=emailid;
	}
	void display()
	{
		System.out.println("Name: "+name+"\tAge: "+age);
	}
}

public class AirReservation 
{

	public static void main(String[] args) 
	{
        Double time=0.00,b,u,d,r=0.00;
		String choice,name,emailid,password="dishank",pass,m;
		int book,k,j,age,q=1,id=0,i=1,x,y,z,price=0,o=0,c;
		Airline AirIndia = new Airline();
		Flight f1 = new Flight("delhi",2447,17.25);
		Flight f2 = new Flight("kanpur",2007,3.30);
        Flight f3 = new Flight("kerala",2769,22.28);
        CargoPlane c1 = new CargoPlane("nepal",1967,5.30,1000.00);
        CargoPlane c2 = new CargoPlane("europe", 1456,7.49,1000.00);
        AirIndia.FlightList.add(f1);
        AirIndia.FlightList.add(f3);
        AirIndia.FlightList.add(f2);
        AirIndia.cargolist.add(c1);
        AirIndia.cargolist.add(c2);
        x=f1.seatcheck();
        y=f2.seatcheck();
        z=f3.seatcheck();
        u = c1.available_space();
        d = c2.available_space();
            while(x!=1 && y!=1 && z!=1 && u>0 && d>=0)
		    {	
                Scanner s1 = new Scanner(System.in);
                System.out.println("enter 1 for administrator\t2 for passenger\t   3 to add package in cargo plane");
                k=s1.nextInt();

                
                if(k==2)
                {
                    System.out.println("\nWelcome to AirIndia ticket Reservation System\n");
                    System.out.println("\nEnter no of tickects you want to book\n");
                    book = s1.nextInt();
                    for(j=1;i<=book;j++)
                    {
                        Scanner s = new Scanner(System.in);
                        System.out.println("\nEnter your Name,Age and Email id\n");
			            name = s.nextLine();
			            age  = s.nextInt();
			            emailid= s.next();
			            Passenger pi = new Passenger(name,emailid,age);
			            System.out.println("choose your destination\n kerala\n delhi\n kanpur\n");
                        choice = s.next();

			            switch(choice)
			            {
                            case "kerala":  price = f3.makeReservation(5999,3101);
                                            time = f3.get_time();
                                            id = f3.get_id();
                                            choice="kerala";
                                            break;					                  
                            case "delhi" :  
                                            price = f1.makeReservation(7696,5569);
                                        time = f1.get_time();
                                        id = f1.get_id();
                                        choice="delhi"  ;
                                        break;
                            case "kanpur":  
                                        price = f2.makeReservation(3259,2329);
                                        time = f2.get_time();
                                        id = f2.get_id();
                                        choice="kanpur";
                                        break;
                            default:
                                        System.out.println("enter correct destination\n");
                                        break;
                        }
                        if(choice=="kerala"||choice=="delhi"||choice=="kanpur")
                        {
                            o=o+price;
                            pi.display();
                            System.out.println("\nSource: Mumbai\t        Destination: "+choice);
                            i++;
                            System.out.println("\nFlight Id No: "+id+"\tDeparture Time: "+time);
                            System.out.println("\nFare:"+price);
                            System.out.println("------------------------------------------------------------------------------------------");
                        } 
                    }
                }
                else if(k==3 )
                {
                    System.out.println("welcome to Air India post services\n");
                    System.out.println("enter weight of the parcel");
                    b = s1.nextDouble();
                    if(b<=100)
                    {
                        System.out.println("Enter Destination\nnepal\neurope");
                        m = s1.next();
                        switch(m)
                        {
                            case "nepal": 
                                            u = c1.available_space();
                                            System.out.println("\nAvailable space: "+u);
                                            c1.Add_package(b);
                                            time = c1.get_time();
                                            id = c1.get_id();
                                            r = b*4;
                                            break;
                            case "europe":
                                            u = c2.available_space();
                                            System.out.println("\nAvailable space: "+u);
                                            c2.Add_package(b);
                                            time = c2.get_time();
                                            id = c2.get_id();
                                            r = b*9;
                                            break;
                            default:
                                            System.out.println("\nenter correct destination");
                                            break;
                        }
                            
                            
                                System.out.println("\nSource: Mumbai\t        Destination: "+m);
                                System.out.println("\nweight of the courier: "+b);
                                System.out.println("\nFlight Id No: "+id+"\tDeparture Time: "+time);
                                System.out.println("\nAmount:"+r);
                            
                    }
                    else
                    {
                        System.out.println("\nMaximum capacity of the parcel is 100 kgs\n");
                    }
                }
                else
                {
                    System.out.println("enter password\n");
                    pass = s1.next();
                    if(pass.equals(password))
                    {
                        System.out.println("welcome\n");
                        System.out.println("enter\n1 to see the passenger flight list\n2 to see cargo plane list\n3 for money collected");
                        c = s1.nextInt();
                        switch(c)
                        {
                            case 1:
                                    f1.Display();
                                    System.out.println("\n");
                                    f2.Display();
                                    System.out.println("\n");
                                    f3.Display();
                                    System.out.println("\n");
                                    break;
                            case 2:
                                    c1.Display();
                                    System.out.println("\n");
                                    c2.Display();
                                    System.out.println("\n");
                                    break;
                            case 3 :
                                    System.out.println("total money:"+o);
                                    break;
                    }

                }
            }
        }
    }
}       