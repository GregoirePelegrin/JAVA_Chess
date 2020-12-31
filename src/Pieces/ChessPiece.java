package Pieces;

import Board.Cell;
import Manager.GameManager;
import Utils.Side;

import java.util.ArrayList;

public abstract class ChessPiece {
    protected boolean dead = false;
    protected GameManager gm;
    protected String name;
    protected Cell position;
    protected boolean selected = false;
    protected Side side;

    public abstract ArrayList<Cell> possibleAttacks();
    public abstract ArrayList<Cell> possibleMove();

    public Side getSide(){
        return this.side;
    }
    public boolean isSelected() {
        return this.selected;
    }
    public void move(Cell nextCell) {
        if(this.selected){
            if(this.possibleMove().contains(nextCell)){
                this.position.setOccupantEmpty();
                nextCell.setOccupant(this);
            }
            this.selected = false;
        }
    }
    public void select(){
        this.selected = !this.selected;
    }
    public void setPosition(Cell cell){
        this.position = cell;
    }
    public String toString(){
        if(this.side == Side.BLACK)
            return this.name.toLowerCase();
        return this.name;
    }
}


