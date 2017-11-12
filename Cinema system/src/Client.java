import java.util.Calendar;

public class Client {
	
	public static void main(String[] args){
		TicketMachine tm = new TicketMachine();
		tm.chooseTicket("child");
		tm.chooseTicket("OAP");
		tm.removeTicket("child");
		float total = tm.calculatePrice();
		System.out.println(tm.cart.toString());
		
		
		
		
		
	}


}
