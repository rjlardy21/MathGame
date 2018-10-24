import java.util.Random;

public class GameTests {
  public static boolean testGameNode1() {
    Random rand = new Random();
    GameNode t = new GameNode(rand);
    GameNode w = new GameNode(rand);
    w.setNext(t);
    if (w.getNext() == t) {
      return true;
    } else {
      return false;
    }
  }

  public static boolean testGameNode2() {
    Random rand = new Random();
    GameNode t = new GameNode(rand);
    GameNode w = new GameNode(rand);
    GameOperator plus = GameOperator.getFromChar('+');
    t.setNext(w);
    int tval = t.getNumber();
    int wval = w.getNumber();
    t.applyOperator(plus);
    int opval = t.getNumber();
    if (opval == tval + wval) {
      return true;
    } else {
      return false;
    }
  }

  public static boolean testGameList1() {
    Random rand = new Random();
    GameList t = new GameList();
    GameNode w = new GameNode(rand);
    GameNode d = new GameNode(rand);
    GameNode r = new GameNode(rand);
    t.addNode(w);
    t.addNode(d);
    t.addNode(r);
    if (t.contains(w.getNumber())){
      return true;
    } else {
      return false;
    }
  }

  public static boolean testGameList2() {
    Random rand = new Random();
    GameList t = new GameList();
    GameNode w = new GameNode(rand);
    GameNode d = new GameNode(rand);
    GameNode r = new GameNode(rand);
    t.addNode(w);
    int wval = w.getNumber();
    t.addNode(d);
    int dval = d.getNumber();
    t.addNode(r);
    int rval = r.getNumber();
    if (t.toString().equals("" + wval + " -> " + dval + " -> " + rval + " -> END")){
      return true;
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
    boolean x = true;
    if (!testGameNode1()) {
      x = false;
      System.out.println("TestGameNode1 failed");
    }
    if (!testGameNode2()) {
      x = false;
      System.out.println("TestGameNode2 failed");
    }
    if (!testGameList1()) {
      x = false;
      System.out.println("TestGameList1 failed");
    }
    if (!testGameList2()) {
      x = false;
      System.out.println("TestGameLis2 failed");
    }
    if (x == true) {
      System.out.println("All tests passed!");
    }
  }
}
