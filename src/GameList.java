
public class GameList {
  private GameNode list; // reference to the first GameNode in this list

  public GameList() {
    list = null;
  } // initializes list to start out empty

  public void addNode(GameNode newNode) {
    if (!(list == null)) {
      if (list.getNext() != null) {
        GameNode temp = list.getNext();
        while (temp.getNext() != null) {
          temp = temp.getNext();
        }
        temp.setNext(newNode);
      } else {
        list.setNext(newNode);
      }
    } else {
      list = newNode;
    }
  } // adds the new node to the end of this list

  public boolean contains(int number) {
    if (list.getNumber() == number) {
      return true;
    }
    if (list.getNext() != null) {
      GameNode temp = list.getNext();
      if (temp.getNumber() == number) {
        return true;
      }
      else {
      while (temp.getNext() != null) {
        temp = temp.getNext();
        if (temp.getNumber() == number) {
          return true;
        }
      }
      }
    }
    return false;
  } // only returns true when this list contains a node with the specified number

  public String toString() {
    String nodes;
    nodes = "" + list.getNumber();
    if (list.getNext() != null) {
      GameNode temp = list.getNext();
      nodes = nodes + " -> " + temp.getNumber();
      while (temp.getNext() != null) {
        temp = temp.getNext();
        nodes = nodes + " -> " + temp.getNumber();
      }
    }
    nodes = nodes + " -> END";
    return nodes;
  } // returns a string with each number in the list separated by " -> "s, and ending with " -> END"

  public void applyOperatorToNumber(int number, GameOperator operator) {// (described below)
    if (list.getNumber() == number) {
      list.applyOperator(operator);
    } else {
      if (list.getNext() != null) {
        GameNode temp = list.getNext();
        while (temp.getNext() != null) {
          if (temp.getNumber() != number) {
            temp = temp.getNext();
          } else {
            temp.applyOperator(operator);
            break;
          }
        }
      }
    }
  }
}
