import Manager.GameManager;

public class Game {
    public static GameManager gameManager;

    public static void main(String args[]){
        gameManager = new GameManager();
        gameManager.pieces.get(1).select();
        System.out.println(gameManager);
    }
}
