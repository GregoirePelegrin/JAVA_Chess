package Board;

import Manager.GameManager;
import Pieces.ChessPiece;
import Utils.CellColour;

public class Cell {
    private GameManager gm;
    private CellColour colour;
    private int line;
    private int col;
    private ChessPiece occupant;
    private boolean threatened;

    public Cell(GameManager _gm, int _line, int _col){
        this.gm = _gm;
        this.line = _line;
        this.col = _col;
        this.threatened = false;
        this.occupant = null;

        if((this.line + this.col) % 2 == 0) {
            this.colour = CellColour.BLACK;
        }
    }

    public String display(){
        String value = "";
        if(this.occupant != null){
            value += this.occupant.toString();
        }

        boolean out = false;
        for(ChessPiece cp : this.gm.pieces) {
            if (cp.isSelected()) {
                for (Cell c : cp.possibleMove()) {
                    if (this == c) {
                        value += "x";
                        out = true;
                        break;
                    }
                }
                if (out) break;
            }
        }
        if(value == "") return " ";
        return value;
    }

    public CellColour getColour(){
        return this.colour;
    }

    public int getCol(){
        return this.col;
    }

    public int getLine(){
        return this.line;
    }

    public ChessPiece getOccupant() {
        return this.occupant;
    }

    public void setOccupant(ChessPiece _occupant) {
        this.occupant = _occupant;
        this.occupant.setPosition(this);
    }

    public void setOccupantEmpty() {
        this.occupant = null;
    }

    public boolean getThreatened(){
        return this.threatened;
    }

    public void setThreatened(boolean _threatened){
        this.threatened = _threatened;
    }

    @Override
    public String toString() {
        return "Cell(" + this.getCol() + "," + this.getLine() + "," + this.getOccupant() + ")";
    }
}
