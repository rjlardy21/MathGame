import java.util.Random;

public class GameNode {
  private int number;    // the number held within this node
  private GameNode next; // the next GameNode in the list, or null for the last node
   
  public GameNode(Random rng) {
    number = rng.nextInt(9) + 1;
    next = null;
  } // initializes number to random 1-9 value, and next to null
  
  public int getNumber() {
    return this.number;
  } // accessor for the number field
  public GameNode getNext() {
    return this.next;
  } // accessor for the next field
  public void setNext(GameNode next) {
    this.next = next;
  } // mutator for the next field
  public void applyOperator(GameOperator operator) {
   if (operator.equals(GameOperator.getFromChar('+'))) {
    this.number = this.number + this.next.number;
    this.next = this.next.next;
   }
    if (operator.equals(GameOperator.getFromChar('-'))) {
    this.number = this.number - this.next.number;
    this.next = this.next.next;
    }
    if (operator.equals(GameOperator.getFromChar('x'))) {
      this.number = this.number * this.next.number;
      this.next = this.next.next;
    }
    if (operator.equals(GameOperator.getFromChar('/'))) {
      this.number = this.number / this.next.number;
      this.next = this.next.next;
    }
    if (operator.equals(GameOperator.getFromChar('&'))) {
      this.number = Integer.parseInt(this.number + "" +  this.next.number);
      this.next = this.next.next;
    }
  } // (described below)
}
