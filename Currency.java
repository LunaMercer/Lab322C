// abstract base class called Currency with two integers attributes
public abstract class Currency {
	protected int noteValue;
	protected int coinValue;
	
	public Currency(){
		this.noteValue = 0;
		this.coinValue = 0;
	}
	public Currency(int noteValue, int coinValue){
		this.noteValue = noteValue;
		this.coinValue = coinValue;
	}
	public Currency(Currency currency){
		this.noteValue = currency.noteValue;
		this.coinValue = currency.coinValue;
	}
	
	public int getNoteValue(){
		return noteValue;	
	}
	public void setNoteValue(int noteValue){
		this.noteValue = noteValue;
	}
	public int getCoinValue(){
		return coinValue;
	}
	public void setCoinValue(int coinValue){
		this.coinValue = coinValue;
	}
	public abstract Currency addCurrency(Currency c);
	public abstract Currency subtractCurrency(Currency c);
	public abstract int compareCurrency(Currency c);
	public abstract void printCurrency();
}
