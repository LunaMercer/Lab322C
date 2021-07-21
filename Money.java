public class Money extends Currency{
	private String currencyName;
	private String coinName;
	
	public Money(){
		super();
		this.currencyName = "Dollar";
		this.coinName = "Cent";
	}
	public Money(int noteValue, int coinValue){
		super(noteValue, coinValue);
		this.currencyName = "Dollar";
		this.coinName = "Cent";
	}
	public Currency addCurrency(Currency currency){
		//Cast the currency to be Money
		Money other = (Money) currency;
		//get notes and coins value
		int notes = super.getNoteValue() + other.getNoteValue();
		int coins = super.getCoinValue() + other.getCoinValue();
		//if coins is greater than 100
		if(coins >= 100){
			//increment the notes count
			notes++;
			//decrement 100 from coins
			coins -= 100;
		}
		return new Money(notes,coins);
	}
	public Currency subtractCurrency(Currency currency){
		//Cast the currency to be Money
		Money other = (Money) currency;
		// get ntoes and coins value
		int notes = super.getNoteValue() - other.getNoteValue();
		int coins = super.getCoinValue() - other.getCoinValue();
		//if no coins
		if(coins < 0){
			//increment the ntoes count
			notes --;
			//decrement 100 from coins
			coins += 100;
		}
		return new Money (notes,coins);
	}
	public int compareCurrency(Currency currency){
		Money other = (Money) currency;
		if(this.getNoteValue() > other.getNoteValue())
			return 1;
		else if(this.getNoteValue() < other.getNoteValue())
			return -1;
		else if(this.getCoinValue() > other.getCoinValue())
			return 1;
		else if(this.getCoinValue() < other.getCoinValue())
			return -1;
		else return 0;
	}
	public void printCurrency(){
		//coin value is greater than 10 cents
		if(super.getCoinValue() > 10){
			System.out.println(super.getNoteValue() + " " + currencyName + " " + super.getCoinValue() + " "+ coinName);
		} else{
			System.out.print(super.getNoteValue() + ".0" + currencyName + "" + super.getCoinValue()+ "" + coinName);
		}
	}
	@Override
	public String toString(){
		//coin value is greater than 10 cents
		if(super.getCoinValue() > 10){
			return(super.getNoteValue() + " " + currencyName + " " + super.getCoinValue() + " " + coinName );
		} else{
			return(super.getNoteValue() + ".0" + currencyName + " " + super.getCoinValue() + " " + coinName);
		}
	}
}


