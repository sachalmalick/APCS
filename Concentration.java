import cs1.Keyboard;  //if comfortable with Scanner, you may comment this out

		
public class Concentration {
	
		

    //instance variables
    private Tile[][] _board;     //storage for 4x4 grid of Tiles.
    private int _numberFaceUp;   //count of Tiles with faces visible
    private String[] _words = {"apple","bob","casey","dog","elephant","frog","hello","igloo"};;     //list of unique Strings used for Tile vals
    private static int _numRows = 4;


    //insert constructor and methods here
    public Concentration () {
	_board = new Tile [4][4];
	_numberFaceUp = 0;
    }

    private void swap( int i, int j ) {
	String extra = _words[i];
	_words[i] = _words[j];
	_words[j] = extra;
    }
	
    public void randomize() {
	for (int i=0; i< _words.length;i++){
	    swap(i, (int)(Math.random()*(_words.length)));
	}
    }
		
    public void populate(){
	randomize();
	for(int j=0; j< 2; j++){ //does the first two rows
	    for(int k=0; k < this._board[j].length; k++){ //does the rows
		this._board[j][k] = new Tile (_words[j * k + 4]);
	    }	
	}
	randomize();
	for(int x=2; x< 4; x++){ //does the second two rows
	    for(int y=0; y < this._board[x].length; y++){ //does the rows
		this._board[x][y] = new Tile (_words[x * y + 4]);
	    }	
	}
    }
    
    public void play() {
    	
    }
		
		//DO NOT MODIFY main()
		public static void main(String[] args){
				Concentration game = new Concentration();
				game.play();
		}

}//end class Concentration

