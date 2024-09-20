import java.util.Scanner;

public class GuessGame{
    public static void main(String[] args) {
        // Generate a random number between 1 and 100
        int numberToGuess = (int) (Math.random() * 100) + 1;

        // Create a Scanner object to read user input
        Scanner sc = new Scanner(System.in);
        int chances= 10;
        int finals=0;
        boolean retryagain=true;
        
        System.out.println("welcome to the gussing game");
        System.out.println("you have chances of " +chances+"  to win the game");
        while (retryagain){
            int rand= getrandN(1,100);
            boolean guess= false;
            for(int i=0;i<chances;i++){
                System.out.println( " I'm thinking of a number between 1 and 100. Try to guess it!");
                System.out.println( "chance  "+(i+1)+"  Enter your guess: ");
                int userGuess = sc.nextInt();
                if (userGuess==rand){
                    guess=true;
                    finals+=1;
                    System.out.println(" Congratulations! You guessed it!");
                    break;
                } 
                else if(userGuess>rand){
                    System.out.println("Your guess is too high. Try again!");
            } 
            else {
                System.out.println("Your guess is too low. Try again!");
            }
                    // System.out.println(" Sorry, that's not correct. The number was " + numberToGuess);
                }
                if(guess==false){
                    System.out.println(" Sorry, that's not correct. The number was " + rand);
                 
                }
                System.out.println("Do You Want to Play Again(y/n)");
                 String PA=sc.next();
                 retryagain=PA.equalsIgnoreCase("y");
                }
                System.out.println("That's it Hope, You Enjoyed It");
                System.out.println("Here Is Your Score: "+finals);
            }
                public static int getrandN(int min,int max){
                    return(int)(Math.random()*(max-min+1)+min);
                }
                
            }

        

       