import java.util.Scanner;

//APCS1 pd5
//HW38 -- keep guessing
//2015-30-11

public class GuessNumber {
	
public static int genNumber(int start, int end) {
	int diff = start - end;
	int ranpick = (int)((Math.random()*diff)+start);
	return ranpick;
}
	

public static String guessNumberHelpIt(int actval, int input) {
	int start = 1;
	int end = 100;
	int inputval = input;
	int count = 0;
	Scanner s = new Scanner(System.in);
	while (inputval != actval) {
		
		if (inputval < actval) {
			System.out.println("too low try again");
			start = ++inputval;
			System.out.println("Please pick a number between " + start + " and " + end);
			if (s.hasNext()) {
				String hey = s.nextLine();
				inputval = Integer.parseInt(hey);
			}
		
		}
		if (inputval > actval) {
			System.out.println("too high try again");
			end = --inputval;
			System.out.println("Please pick a number between " + start + " and " + end);
			if (s.hasNext()) {
				String hey = s.nextLine();
				inputval = Integer.parseInt(hey);
			}
		
		}
		count++;
	}
	String rs = "Congrats, you got it! It took you " + count + " tries";
	System.out.println(rs);
	return rs;
} 
	
public static String guessNumberHelp(int inputval, int count, int start, int end, int actval) {
	if (inputval == actval) {
		String s = "Correct! It took you " + count + " tries";
		System.out.println(s);
		return s;
	}
	else {
		if (inputval < actval) {
		start = inputval + 1;
		System.out.println("too low try again");

		System.out.println("Pick a number between " + start + " and " + end);
		Scanner s = new Scanner(System.in);
		String userinp = "";
		if (s.hasNext()) {
			userinp = s.nextLine();
		}
		int pickedvalue = Integer.parseInt(userinp);
		guessNumberHelp(pickedvalue,count + 1, start,end,actval);
		}
		if (inputval > actval) {
			end = inputval - 1;
			System.out.println("too high try again");

			System.out.println("Pick a number between " + start + " and " + end);
			Scanner s = new Scanner(System.in);
			String userinp = "";
			if (s.hasNext()) {
				userinp = s.nextLine();
			}
			int pickedvalue = Integer.parseInt(userinp);
			guessNumberHelp(pickedvalue,count + 1, start,end,actval);
			}
		
		return "";
	}
	
}
public static void guessNumber() {
	int ranpick = (int)((Math.random()*99)+1);
	Scanner s = new Scanner(System.in);
	String userinp = "";
	System.out.println("Pick a number between 0 and 100");
	if (s.hasNext()) {
		userinp = s.nextLine();
	}
	int pickedvalue = Integer.parseInt(userinp);
	if (pickedvalue == ranpick) {
		System.out.println("Correct! It took you 1 try");
	}
	else {
		guessNumberHelpIt(ranpick,pickedvalue);
	}
	
	System.out.println(ranpick);
}

public static void main (String [] args) {
	guessNumber();
}
	
}
