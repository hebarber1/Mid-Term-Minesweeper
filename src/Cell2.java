
public class Cell2 {
	
	
	
	class cell{
	    //the cell object, representing a cell in the game board.
	    // it contains 2 fields, the actual value, and if the cell has been uncovered.
	    
	    private boolean revealed;
	    private char value;
	    
	    public cell(char x){
	        //constructor that sets value to parameter, and revealed to false.
	        revealed=false;
	        value=x;
	    }
	    public String toString(){
	        //public method to convert object to string for easy output
	        // the beauty of this is the cell object itself decides what
	        // to output because of the _revealed_ field.
	        if (revealed)
	            return (value+"");
	        else
	            return "-";
	    }
	    public char getValue(){
	        //public method to return value field.
	        return value;
	    }
	    public void setValue(char x){
	        //public method to set the value field.
	        value=x;
	    }
	    public void setRevealed(boolean r){
	        //public method to set the revealed flag.
	        revealed=r;
	    }
	    public boolean isRevealed(){
	        //public method to return the revealed field.
	        return revealed;
	    }
	    
	}

}
