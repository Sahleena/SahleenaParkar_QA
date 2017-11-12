import java.util.ArrayList;
import java.util.Calendar;

public class TicketMachine {
	ArrayList<Ticket> cart = new ArrayList<Ticket>();
	boolean discount = false;
	public void chooseTicket(String type){
		Ticket ticket;
		
		switch (type){
			case "child": ticket = new ChildTicket(); break; 
			case "student": ticket = new StudentTicket(); break; 
			case "OAP": ticket = new OAPTicket(); break; 
			case "standard": ticket = new StandardTicket(); break; 
			default: ticket = new StandardTicket(); break; 
		}
		
		cart.add(ticket);
	}
	
	public float calculatePrice(){
		float totalprice = 0; 
		Calendar calendar = Calendar.getInstance();
		int weekday =calendar.get(Calendar.DAY_OF_WEEK);
		
		for (int i = 0; i < cart.size(); i ++){
			Ticket t =cart.get(i) ;
			if (weekday == 4){
				totalprice += t.getPrice() - 2;
				discount = true;
			} else {
				totalprice += t.getPrice();
				discount = false; 
			}
		}
		return totalprice;
	}
	public void removeTicket(String type){
		for (int i = 0; i < cart.size(); i ++){
			Ticket t = cart.get(i);
			if (t.getType().equals(type)){
				cart.remove(i);
				break;
			}
		}
		
	}
}
