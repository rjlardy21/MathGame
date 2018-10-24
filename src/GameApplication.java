import java.util.Random;
import java.util.Scanner;

public class GameApplication {
  private int goalNum;
  static Random rand = new Random();
  private int movesTaken;
  GameList list;

  public GameApplication() {
    this.goalNum = rand.nextInt(90) + 10;
    this.movesTaken = 0;
    this.list = new GameList();
  }

  public void printApp(boolean gameWon) {
    if (gameWon == true) {
      System.out.println("Congratulations, you won in " + movesTaken + " moves.");
      System.out.println("Solution: " + list.toString());
    } else {
      System.out.println("Goal: " + goalNum + " Moves Taken: " + movesTaken);
      System.out.println("Puzzle: " + list.toString());
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    GameApplication game1 = new GameApplication();
    int i = 0;
    while (i < 7) {
      game1.list.addNode(new GameNode(rand));
      i++;
    }
    boolean gameWon = false;
    while (gameWon == false) {
      game1.printApp(gameWon);
      System.out.println("Number and Operation " + GameOperator.ALL_OPERATORS.toString() + " to Apply: ");
      String input = sc.nextLine();
      input = input.trim();
      input = input.toLowerCase();
      if (input.equals("quit")) {
        System.out.println("Goodbye.");
        break;
      }
      char operand = input.charAt(input.length() - 1);
      GameOperator operator = GameOperator.getFromChar(operand);
      input = input.substring(0, input.length() - 1);
      int usernum = Integer.parseInt(input);
      if (game1.list.contains(usernum)) {
        if (GameOperator.ALL_OPERATORS.contains(operator)) {
        game1.movesTaken++;
        game1.list.addNode(new GameNode(rand));
      game1.list.applyOperatorToNumber(usernum, operator);
        }
        else {
          System.out.println("Warning: " + operand + " is not a valid operator, try again.");
        }
      }
      else {
        System.out.println("Warning: " + usernum + " is not in the game list, try again.");
      }
      if (game1.list.contains(game1.goalNum)) {
        gameWon = true;
      }
    }
    if (gameWon == true) {
    game1.printApp(gameWon);
  }
    // After the user enter’s a number within the list, followed by a valid operator: track that
    // they have taken an extra move (ie turn), add a new random node to the end of the list, and
    // then call the applyOperatorToNumber() method to update the list according to the player’s
    // specification.
    // If the user ever types in the word “quit” (without quotes, but in any combination of
    // lower-case and upper-case letters), end the program with a goodbye message as a result.
    // If the user ever enters input that does not conform to the format described above (including
    // a number within the current list followed by a valid operator, or the word “quit”), print out
    // a descriptive warning message that starts with “WARNING: ” before printing out another prompt
    // for the user to try again. These kinds of bad in put should not be counted as moves. UPDATE
    // 10/22 – It appears that the parenthetical above has lead to some confusion. The examples in
    // parentheses describes valid inputs that conform to the write-up and do not require a warning
    // message in response. Other user inputs should result in a warning message.
    // When the target number appears within player’s list, they have won the game. This should lead
    // to the program ending after a congratulatory message is printed for the user. This message
    // must begin with the word: Congratulations

    sc.close();
  }

}
