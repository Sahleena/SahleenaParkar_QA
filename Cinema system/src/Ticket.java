
public abstract class  Ticket {

	protected final float price;
	protected final String type; 
	
	protected Ticket(float p,String t){
		this.price = p;
		this.type = t;
	}
	
	
	public float getPrice(){
		//TODO take into account day of the week 
		return price;
	}
	
    public String getType(){
		return type;
	}
	
	
}
