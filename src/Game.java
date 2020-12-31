import Manager.GameManager;

public class Game {
    public static GameManager gameManager;

    public static void main(String args[]){
        test();
    }

    public static void test(){
        gameManager = new GameManager();
        System.out.println("Selected");
        gameManager.pieces.get(6).select();
        System.out.println(gameManager);
        System.out.println("Move to nowhere");
        gameManager.pieces.get(6).move(gameManager.grid.cells.get(0));
        gameManager.pieces.get(6).select();
        System.out.println(gameManager);
        System.out.println("Move to somewhere unoccupied");
        gameManager.pieces.get(6).move(gameManager.grid.cells.get(2*gameManager.grid.width));
        gameManager.pieces.get(6).select();
        System.out.println(gameManager);
        System.out.println("Next move");
        gameManager.pieces.get(6).move(gameManager.grid.cells.get(4*gameManager.grid.width+1));
        gameManager.pieces.get(6).select();
        System.out.println(gameManager);
        System.out.println("Move to somewhere occupied by opposed team");
        gameManager.pieces.get(6).move(gameManager.grid.cells.get(6*gameManager.grid.width));
        gameManager.pieces.get(6).select();
        System.out.println(gameManager);
    }
}
