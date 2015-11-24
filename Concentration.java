/*  Team GitRektAgain - Sachal Malick, Vincent Alykin, Christopher Sherling
    APCS1 pd5
    HW36 -- Some Folks Call It a Memory
    2015-11-23 */

import java.util.Scanner;

//import cs1.Keyboard;  //if comfortable with Scanner, you may comment this out

		
public class Concentration {
	
		

    //instance variables
    private Tile[][] _board;     //storage for 4x4 grid of Tiles.
    private int _numberFaceUp;   //count of Tiles with faces visible
    private String[] _words = {"art", "art", "bob", "bob", "cat", "cat","dog","dog","eel","eel","fin","fin","get","get","ice","ice"};     //list of unique Strings used for Tile vals
    //private String[] _words = {"art","bob","cat","dog","eel","fin","get","ice"};
    private static int _numRows = 4;


    //insert constructor and methods here
    public Concentration () {
	_board = new Tile [4][4];
	_numberFaceUp = 0;
    }
    
    public void print2() {
    	Tile [] [] a = this._board;
    	for (Tile [] s: a) {
    	    for (Tile x: s) {
    		System.out.print(x);
    	    }
    		
    	    System.out.println();
    	} 
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
	// for(int j=0; j< 2; j++){ //does the first two rows
	//     for(int k=0; k < this._board[j].length; k++){ //does the rows
	// 	this._board[j][k] = new Tile (_words[j * 4 + k]);
	//     }	
	// }
	// randomize();
	// for(int x=2; x< 4; x++){ //does the second two rows
	//     for(int y=0; y < this._board[x].length; y++){ //does the rows
	// 	this._board[x][y] = new Tile (_words[(x-2) * 4 + y]);
	//     }	
	// }
	for(int i=0; i<_board.length; i++){
	    for(int j=0; j<_board[i].length; j++)
	 	this._board[i][j] = new Tile (_words[i * 4 + j]);	    
	}
    }
    
    public void play() {
    	populate();
    	while (_numberFaceUp < 16) {
    		
    	
	    this.print2();
	    Scanner s = new Scanner(System.in);
	    String firstcol = "";
	    String firstrow = "";
	    String seccol = "";
	    String secrow = "";

    	
	    System.out.println("Please enter the row of the first string");

	    if (s.hasNext() ) {
		firstrow = s.nextLine();

	    }

	    System.out.println("Please enter the column of the first string");

	    if (s.hasNext() ) {

		firstcol = s.nextLine();

	    }
	    System.out.println("Please enter the row of the second string");

	    if (s.hasNext() ) {

		secrow = s.nextLine();

	    }
	    System.out.println("Please enter the column of the second string");

	    if (s.hasNext() ) {

		seccol = s.nextLine();

	    }


	    int firsrow = Integer.parseInt(firstrow);
	    int secundorow = Integer.parseInt(secrow);
	    int firstcolo = Integer.parseInt(firstcol);
	    int secundocolo = Integer.parseInt(seccol);
	    Tile t = this._board[firsrow][firstcolo];
	    Tile j = this._board[secundorow][secundocolo];
    	
	    t.set_isFaceUp(true);
	    j.set_isFaceUp(true);

	    this.print2();
	    if (!t.equals(j)) {
    		t.set_isFaceUp(false);
        	j.set_isFaceUp(false);
	    }
	    else {
    		_numberFaceUp+=2;
	    }
	    System.out.println();
    	}
    	
    	System.out.println("game over");
    }
		
    //DO NOT MODIFY main()
    public static void main(String[] args){
	Concentration game = new Concentration();
	game.play();
    }

}//end class Concentration

