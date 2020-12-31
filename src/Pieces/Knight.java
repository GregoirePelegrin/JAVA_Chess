package Pieces;

import Board.Cell;
import Manager.GameManager;
import Utils.Side;

import java.util.ArrayList;

public class Knight extends ChessPiece {
    public Knight(GameManager _gm, Side _side, Cell _position){
        this.name = "Kn";
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
        if(xCurr >= 1 && yCurr >= 2){
            currCell = this.gm.grid.cells.get((yCurr-2) * this.gm.grid.width + (xCurr-1));
            if(currCell.getOccupant() == null || currCell.getOccupant().getSide() != this.side)
                threatenedCells.add(currCell);
        }
        if(xCurr <= this.gm.grid.width-2 && yCurr >= 2){
            currCell = this.gm.grid.cells.get((yCurr-2) * this.gm.grid.width + (xCurr+1));
            if(currCell.getOccupant() == null || currCell.getOccupant().getSide() != this.side)
                threatenedCells.add(currCell);
        }
        if(xCurr >= 2 && yCurr >= 1){
            currCell = this.gm.grid.cells.get((yCurr-1) * this.gm.grid.width + (xCurr-2));
            if(currCell.getOccupant() == null || currCell.getOccupant().getSide() != this.side)
                threatenedCells.add(currCell);
        }
        if(xCurr <= this.gm.grid.width-3 && yCurr >= 1){
            currCell = this.gm.grid.cells.get((yCurr-1) * this.gm.grid.width + (xCurr+2));
            if(currCell.getOccupant() == null || currCell.getOccupant().getSide() != this.side)
                threatenedCells.add(currCell);
        }
        if(xCurr >= 1 && yCurr <= this.gm.grid.height-3){
            currCell = this.gm.grid.cells.get((yCurr+2) * this.gm.grid.width + (xCurr-1));
            if(currCell.getOccupant() == null || currCell.getOccupant().getSide() != this.side)
                threatenedCells.add(currCell);
        }
        if(xCurr <= this.gm.grid.width-2 && yCurr <= this.gm.grid.height-3){
            currCell = this.gm.grid.cells.get((yCurr+2) * this.gm.grid.width + (xCurr+1));
            if(currCell.getOccupant() == null || currCell.getOccupant().getSide() != this.side)
                threatenedCells.add(currCell);
        }
        if(xCurr >= 2 && yCurr <= this.gm.grid.height-2){
            currCell = this.gm.grid.cells.get((yCurr+1) * this.gm.grid.width + (xCurr-2));
            if(currCell.getOccupant() == null || currCell.getOccupant().getSide() != this.side)
                threatenedCells.add(currCell);
        }
        if(xCurr <= this.gm.grid.width-3 && yCurr <= this.gm.grid.height-2){
            currCell = this.gm.grid.cells.get((yCurr+1) * this.gm.grid.width + (xCurr+2));
            if(currCell.getOccupant() == null || currCell.getOccupant().getSide() != this.side)
                threatenedCells.add(currCell);
        }
        return threatenedCells;
    }

    @Override
    public ArrayList<Cell> possibleMove() {
        return this.possibleAttacks();
    }
}
