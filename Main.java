import java.util.Scanner;
/**
 * HW-03 Challenge -- Pattern Matcher
 *
 * This program allows a user to choose a level difficulty for
 * a pattern matcher. After which, they will enter a number
 * and be given four numbers (one being the original, and
 * the next three following a specific pattern). The user
 * will then enter the next three successive numbers. If
 * the user is correct, they will be told so. If the user
 * is incorrect, they are given a message. The pattern
 * matcher repeats until the user tells it to stop.
 *
 * @author Evan Borszem, lab sec 24
 *
 * @version February 12, 2022
 *
 */
public class Main {

    public static void main(String[] args) {

        String chooseLevel = "Choose Level Difficulty:" +
                "\n1. Easy\n2. Medium\n3. Hard";
        String startNumber = "Enter a number to start the pattern:";
        String nextThree = "Enter the next 3 numbers in the pattern:";
        String congratulations = "Congrats! Your answer was correct!";
        String sorry = "Sorry! Your answer was incorrect!";
        String again = "Play Game Again? (y/n)";
        String ending = "Ending Pattern Matcher...";

        //TODO: write your code below
        Scanner scanner = new Scanner(System.in);

        String repeat = ""; //allows user to continue going through the pattern matcher

        do {
            System.out.println(chooseLevel);

            int levelDifficulty = scanner.nextInt(); //determines the level difficulty
            scanner.nextLine();

            if (levelDifficulty == 1) {
                System.out.println(startNumber);
                int number = scanner.nextInt(); //the user-inputted number
                scanner.nextLine();
                System.out.println(nextThree);

                int numberTwo = number + 3; //user-inputted number added by three
                int numberThree = numberTwo + 3; //user-inputted number added by three again
                int numberFour = numberThree + 3; //user-inputted number added by three again

                System.out.println(number + " " + numberTwo + " " + numberThree + " " + numberFour);

                int nextDigitCorrect = numberFour + 3; //1st correct successive number
                int nextDigitTwoCorrect = nextDigitCorrect + 3; //2nd correct successive number
                int nextDigitThreeCorrect = nextDigitTwoCorrect + 3; //3rd correct successive number

                int nextDigit = scanner.nextInt(); //1st user-inputted successive number
                scanner.nextLine();
                int nextDigitTwo = scanner.nextInt(); //2nd user-inputted successive number
                scanner.nextLine();
                int nextDigitThree = scanner.nextInt(); //3rd user-inputted successive number
                scanner.nextLine();

                if(nextDigitCorrect == nextDigit && nextDigitTwoCorrect == nextDigitTwo && nextDigitThreeCorrect == nextDigitThree){
                    System.out.println(congratulations);
                }
                else{
                    System.out.println(sorry);
                }

            }

            if (levelDifficulty == 2) {
                System.out.println(startNumber);
                int number = scanner.nextInt(); //the user-inputted number
                scanner.nextLine();
                System.out.println(nextThree);

                int numberTwo = number * 7; //user-inputted number times 7
                int numberThree = numberTwo * 7; //user-inputted number times 7 again
                int numberFour = numberThree * 7; //user-inputted number times 7 again

                System.out.println(number + " " + numberTwo + " " + numberThree + " " + numberFour);

                int nextDigitCorrect = numberFour * 7; //1st correct successive number
                int nextDigitTwoCorrect = nextDigitCorrect * 7; //2nd correct successive number
                int nextDigitThreeCorrect = nextDigitTwoCorrect * 7; //3rd correct successive number

                int nextDigit = scanner.nextInt(); //1st user-inputted successive number
                scanner.nextLine();
                int nextDigitTwo = scanner.nextInt(); //2nd user-inputted successive number
                scanner.nextLine();
                int nextDigitThree = scanner.nextInt(); //3rd user-inputted successive number
                scanner.nextLine();

                if(nextDigitCorrect == nextDigit && nextDigitTwoCorrect == nextDigitTwo && nextDigitThreeCorrect == nextDigitThree){
                    System.out.println(congratulations);
                }
                else{
                    System.out.println(sorry);
                }

            }

            if (levelDifficulty == 3) {
                System.out.println(startNumber);
                int number = scanner.nextInt(); //the user-inputted number
                scanner.nextLine();
                System.out.println(nextThree);

                int numberCubed = number * number * number - 1; //user-inputted number cubed minus 1
                int numberTwo = (number + 1) * (number + 1) * (number + 1) - 1; //user-inputted number plus 1, cubed, and minus 1
                int numberThree = (number + 2) * (number + 2) * (number + 2) - 1; //user-inputted number plus 2, cubed, and minus 1
                int numberFour = (number + 3) * (number + 3) * (number + 3) - 1; //user-inputted number plus 3, cubed, and minus 1
                
                System.out.println(numberCubed + " " + numberTwo + " " + numberThree + " " + numberFour);

                int nextDigitCorrect = (number + 4) * (number + 4) * (number + 4) - 1; //1st correct successive number
                int nextDigitTwoCorrect = (number + 5) * (number + 5) * (number + 5) - 1; //2nd correct successive number
                int nextDigitThreeCorrect = (number + 6) * (number + 6) * (number + 6) - 1; //3rd correct successive number

                int nextDigit = scanner.nextInt(); //1st user-inputted successive number
                scanner.nextLine();
                int nextDigitTwo = scanner.nextInt(); //2nd user-inputted successive number
                scanner.nextLine();
                int nextDigitThree = scanner.nextInt(); //3rd user-inputted successive number
                scanner.nextLine();

                if(nextDigitCorrect == nextDigit && nextDigitTwoCorrect == nextDigitTwo && nextDigitThreeCorrect == nextDigitThree){
                    System.out.println(congratulations);
                }
                else{
                    System.out.println(sorry);
                }
            }

            if (levelDifficulty > 3 || levelDifficulty < 1) {
                repeat = "y";
                continue;
            }
            System.out.println(again);
            repeat = scanner.nextLine();
            repeat = repeat.toLowerCase(); //makes string lowercase

    } while (repeat.equals("y"));
        System.out.println(ending);
    }
}
