package Board;

import Manager.GameManager;

import java.util.ArrayList;

public class Grid {
    private GameManager gm;
    public int height = 8;
    public int width = 8;
    public ArrayList<Cell> cells;

    public Grid(GameManager _gm){
        this.gm = _gm;
        this.cells = new ArrayList<Cell>();
        for(int _line=0; _line<this.height; _line++){
            for(int _col=0; _col<this.width; _col++){
                this.cells.add(new Cell(this.gm, _line, _col));
            }
        }
    }

    @Override
    public String toString() {
        String result = "|";
        for(int i=0; i<this.height*this.width; i++){
            if(i % this.width == 0 && i != 0){
                result += "\n|";
            }
            result += "\t" + this.cells.get(i) + "\t|";
        }
        return result;
    }
}
