//Enum used by the cell to indicate if it's been flagged with a question or a bomb. 
//If null it means the cell has not been flagged.

public enum Flag {
	QUESTION("?"), BOMB("*");

	String symbol;

	Flag(String symbol) {
		this.symbol = symbol;
	}
}
