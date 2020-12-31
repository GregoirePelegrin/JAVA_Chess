package Pieces;

import Board.*;
import Manager.GameManager;
import Utils.Side;

import java.util.ArrayList;

public class Pawn extends ChessPiece {
    public Pawn(GameManager _gm, Side _side, Cell _position){
        this.name = "P";
        this.gm = _gm;
        this.side = _side;
        this.position = _position;
        this.position.setOccupant(this);
    }

    @Override
    public ArrayList<Cell> possibleAttacks() {
        ArrayList<Cell> threatenedCells = new ArrayList<Cell>();
        int xCurr = this.position.getCol();
        int yCurr = this.position.getLine();
        Cell currCell;
        if(yCurr < this.gm.grid.height-1){
            if(xCurr > 0){
                currCell = this.gm.grid.cells.get((yCurr+1) * this.gm.grid.width + (xCurr-1));
                if(currCell.getOccupant() != null && currCell.getOccupant().getSide() != this.side)
                    threatenedCells.add(currCell);
            }
            if(xCurr < this.gm.grid.width-1){
                currCell = this.gm.grid.cells.get((yCurr+1) * this.gm.grid.width + (xCurr+1));
                if(currCell.getOccupant() != null && currCell.getOccupant().getSide() != this.side)
                    threatenedCells.add(currCell);
            }
        }
        return threatenedCells;
    }

    @Override
    public ArrayList<Cell> possibleMove() {
        ArrayList<Cell> possibleCells = new ArrayList<Cell>();
        int xCurr = this.position.getCol();
        int yCurr = this.position.getLine();
        Cell currCell;
        if(yCurr < this.gm.grid.height-1){
            currCell = this.gm.grid.cells.get((yCurr+1) * this.gm.grid.width + xCurr);
            if(currCell.getOccupant() == null)
                possibleCells.add(currCell);
        }
        return possibleCells;
    }
}
