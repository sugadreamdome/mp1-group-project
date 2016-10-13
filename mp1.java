/*
 * Computer Science AP       Period 4
 * Michelle Zhang, Michelle Chu, Jamie Nillas
 *
	COMPUTER SCIENCE MAJOR PROGRAM 1 --   Hangman
	    An example of the structure is below the requirements
	    You may use any or all of the examples.

	This program will be named MP1 and will count as a test grade.

	EXPLANATION:

	You are to implement the word game Hangman in which the player will
	guess the letters until the correct word is guessed or he/she has had 
	seven guesses.  The program will be  be implemented with a HangWord 
	class that is constructed with a String instance variables for the word 
	and for guessed word which will initially contain dummy characters like 
	_ _ or * *, and a variable for the number of guesses. 
	
	
	
	REQUIREMENTS:


	1. A driver to test all features of the HangWord class.  Get all aspects of
	   HangWord working before you do any graphics.  A user-friendly 
	   graphical opening screen will replace the driver.  (Comment out 
	   driver tests)  It includes the programmers' names and a copyright notice.   
	   Completely explain the program and the way the game is played.   (10)

    2. The class structure is correct including instance variables, 
       constructors, accessors, mutators and the toString method.       (20)  

	3. A member method that receives a guessed letter and changes  
	   the value of the guessed word (Ex. co_p_ter (for computer).  
	   and returns how many of the letter there are in the word.
	   Use the pseudocode below as your starting point.                 (20)
	    
	pseudocode for checkWord (letter for parameter)
	
	    	Define local variables for the letter location and the count
	    	if(the letter is NOT in the word -- indexOf returns -1)
	    		return -1
	    	Get the location of the input letter. 	
	    	Add one to count.
	    	Change guessed word variable (insert letters).  Use substring + 
	    	      letter + substring.	
	    	Add one to the location .
            Repeat for at least five of the same letter..
	    	Return  the count of letters.
	    	    	    
    4  A member method that determines if the word is the same as the 
       guessed word.	                                                (10)
       
    5. Get a random word from a data file.  First item in the file is 
       how many words there are.  Read it and then read the words like 
       this:
            howMany = input.nextInt();                                  (10)
            wordNumber = (int)(random() * howMany);
            while (lcv < wordNumber)
                {
                	wordToGuess = input.next();
                	
    6. Use JOptionPane or the graphics screen to input the guess and 
       output the the guessed word.                                     (10)
       
    7. Display parts of your hanged man (or other graphic) on the 
       graphics screen.                                                 (10) 

    8. Display the incorrect letters guessed on the screen from a  
       concatenated String on the graphics screen.                      (10) 

Check pseudocode below
*/
import static java.lang.System.*;
import static java.lang.Math.*;
import javax.swing.JOptionPane; 
import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Frame;
//import java.awt.KeyListener;

public class mp1 
{
	public static void main (String [] args) throws IOException
	{
		new PrettyScreen ();
		
		Scanner keyIn = new Scanner (in);
		
		HangWord hang = new HangWord ("test","~~~~~~~~~~~~~~~");
		HangWord test2 = new HangWord ("Suga", "++++");
		out.println (hang.getBlanks());
		hang.setBlanks ("???????");
		out.println (hang.getBlanks());
		String guess = "";
		
		out.println ("Enter your guess!");
		//guess = keyIn.findInLine(".").charAt(0);
		guess = keyIn.next();
		out.println (test2.checkLetter(guess));
	    out.println (guess);
	    out.println ("\n" + test2.getNumGuesses());
	    out.println(test2.getRightGuesses()); 
	    out.println(test2.getWrongGuesses());
	    out.println ("Enter your guess!");
		//guess = keyIn.findInLine(".").charAt(0);
		guess = keyIn.next();
		out.println (test2.checkLetter(guess));
	    out.println (guess);
	    out.println ("\n" + test2.getNumGuesses());
	    out.println(test2.getRightGuesses()); 
	    out.println(test2.getWrongGuesses());
	    
		// NOTE do not add PrettyScreen until the HangWord class is thoroughly tested to:
		// return the word to guess.
		// return a String of blanks the same length as the word to guess.

		//	new PrettyScreen();  // Instantiate the hangword object in PrettyScreen
	      // constructor.
	}
}

//You can do the graphics and input here. Put your gameloop in PrettyScreen.

class PrettyScreen extends Frame implements KeyListener
{
	boolean keyPressed = false;
	boolean gameNotOver = false;
	
	char letterGuessed;
	
	HangWord suga = new HangWord ("Suga", "++++");
	
	Logo nico = new Logo();
    final int BLACK =      0,  // color constants for setTurtleColor().
	 	      MAGENTA =    1,
	 	      BLUE =       2,
	 	      BRTBLUE =    3,
	 	      PINK =	      4,
              GREEN =      5,
	 	      BRTGREEN =	  6,
	 	      ORANGE =	  7,
	 	      RED =        8,
              GRAY =       9,
	 	      DARKGRAY =	 10,
 	  	      YELLOW =	 11,
	 	      CYAN =	     12,
	 	      LIGHTGRAY = 13,
	 	      BROWN = 	 14,
	 	      WHITE =	 15,
	 	      BRTPINK =   16,
	 	      FUSCHIA =   17,
			  OTHER =     18;
	
	public PrettyScreen()
	   {
	   	JOptionPane.showMessageDialog(null,"        Copyright. Nico.\n"+"\n"+
  									 "  This is a product of Nico.\n"+
  									 "   Made by Michelle Zhang, Jamie Nillas, and Michelle Chu :)");
  		JOptionPane.showMessageDialog(null,"     Hello. This is a game of Hangman. Simply type the letter you think\n"+
  							   			   			   "     is in the word being guessed. Your goal is to guess the whole word\n"+
										  			   "     but you only get 7 wrong guesses so pick wisely!!!\n" +
  							   			   			   "                         Good Luck!                        ");
//	   	    set window size
//	   	    set close window on
//	   	    instantiate a HangWord object
//	   	    setVisible
//	   	    message gameLoop

            setSize(1400, 935);
            addWindowListener(new WindowAdapter()
            {
                public void windowClosing(WindowEvent e)
                {
                  System.exit(0);
                }
            });
            
 	        this.setVisible (true);
 	        addKeyListener (this);
 	        gameLoop();
 	 
	   }
	   
	public void gameLoop()
	   {
	   	    if (suga.isWordGuessed () == true || suga.isGuessCountMax () == true)
	   	        gameNotOver = true;
	   	        
	   	    while (!gameNotOver)
	   	       {
	   	       	  if(keyPressed)
	   	       	      {
	   	       	      	  keyPressed = false;
	   	       	      	  this.repaint();
	   	       	      }	  
	   	       	      	  
	   	       }
	   }

public void paint(Graphics pen)
{
	Color brightPink = new Color (240, 80, 170);
	Color lightYellow = new Color (254, 250, 199);
	pen.setColor (lightYellow);
	pen.fillRect(0,0, 1400, 935);
	
	setTitle("MP1 HangMan Program~!");
	pen.setColor (Color.gray);
    pen.setFont(new Font("Timesroman",Font.ITALIC,48));
    pen.drawString("MP1 HangMan  Mitchellie Nilluang",150,60);
    
    pen.drawString (suga.getWordToGuess(), 150, 500);
    pen.drawString (suga.getBlanks(), 150, 700);
    pen.drawString ("Guess the word! You have 7 guesses left.", 150, 200);

}		   	
   
public void keyPressed(KeyEvent e)
{
    setTitle(""+ KeyEvent.getKeyText(e.getKeyCode()));  //This prints in the title (blue) bar
    System.out.println("hit + "+ KeyEvent.getKeyText(e.getKeyCode()));//This prints in the console
    keyPressed = true;
    letterGuessed = e.getKeyChar();

}

public void keyReleased(KeyEvent e)// not used but abstract methods must be overridden
{
}

public void keyTyped(KeyEvent e)
{
}
}

class HangWord
{
//	Four instance variables (one for the word to guess, one for the new string
//	and one for the number of guesses)
//	Another must be a numeric data type.  (Word score, difficulty, cost...) 
	
	private String wordToGuess;
	private String blanks;
    private int numGuesses = 0;
	private int numRightGuesses;
	private int numWrongGuesses;
	
	 
	public HangWord (String w, String blanks)
	{
		wordToGuess = w;
		this.blanks = blanks;
		//newWord = blankType.substring(0,word.length()); 
		
	}
	
	    // Accepts a a letter and replaces the appropriate blank with a correct letter.
		// return a String of blanks with the appropriate letters replaced.
		// checks the blank String to determine if the word to guess is the same.
		
	public int checkLetter (String letter)
	{
		//loop through wordToGuess
		//check if letter matches charAt
		//add to num of same\
		//replace blank at charAt with letter
		//not there? add to numWrongGuesses, add to wrong letter
		int numInWord = 0; 
			for (int c = 0; c < wordToGuess.length(); c++)
			{
				if (letter.equalsIgnoreCase ("" + wordToGuess.charAt(c)))
				{ 
			    	blanks = blanks.substring(0,c) + wordToGuess.charAt(c) + 
        	   	 	   	             blanks.substring(c + 1);
					out.println (blanks);
					numInWord ++;
					numRightGuesses ++;
				}
			}
				
		    if (numInWord == 0)
	    	   numWrongGuesses ++;
	      
	    	numGuesses ++;   
			return numInWord;
	}
			
    public boolean isWordGuessed ()
    {
    	if (wordToGuess.equals (blanks))
    	    return true;
    	
    	return false;
    }
    
    public boolean isGuessCountMax ()
    {
    	if (numGuesses >= 7)
    	   return true;
    	   
    	return false;
    }
    
//    accessors and mutators for the instance variables.

//    checkLetter method (gets a char, changes newWord and returns true or false 
//          that the letter is in the word.) 
     
    public void setBlanks (String b) 
    {
        blanks = b;
    } //mutator
    
    public String getBlanks () {return blanks;} //accessor
    
	public String getWordToGuess() // return the new word with spaces
	{
		String temp = "";
		for (int x = 0; x < wordToGuess.length();x++)
		    temp += wordToGuess.charAt(x) + " ";
		return temp;    
	}
	
	
	public int getRightGuesses() { return numRightGuesses; }
	
	public int getWrongGuesses() { return numWrongGuesses; }
	 
	public int getNumGuesses() { return numGuesses; }
	
//    a toString method returns the word and the newWord in a string.
     
public static void pause (long r)
{
    try
       {
       	   Thread.sleep(r);
       }
    catch (Exception e) 
       {
       	   out.println(" sleep error " + e);
    	}   	   
}
}  //end class
//Klein ISD Acceptable use policy:
//1.       Student developed games and other programming projects may not include profane references to a deity, 
//         obscene language, drug abuse or paraphernalia, images of suicide or criminal violence, suggested or 
//         explicit sexuality, partial/full/frontal nudity, or any subject matter inappropriate for young adults, 
//         and any content that may offend the moral standards of the community are strictly prohibited. Students 
//         must receive teacher approval on game and project design before developing content within a class 
//         assignment or project.  
//
//2.       All games developed, viewed, or shown/demonstrated on a Klein ISD computer, and/or as part of Klein ISD 
//         assignments and projects must meet the Entertainment Software Rating Board rating for Early Childhood or 
//         Everyone.
//			(ESRB: http://www.esrb.org/ratings/ratings_guide.jsp#rating_categories)
//
//3.       Additionally, student created games and projects may not contain content that is categorized by the 
//         following ESRB content descriptors: Alcohol Reference, Animated Blood, Blood, Blood and Gore, Crude Humor, 
//         Drug Reference, Fantasy Violence, Intense Violence, Language, Lyrics, Mature Humor, Nudity, Partial Nudity, 
//         Real Gambling, Sexual Content, Sexual Themes, Sexual Violence, Simulated Gambling, and Strong Language. 
//
