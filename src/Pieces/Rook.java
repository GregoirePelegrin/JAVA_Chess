package Pieces;

import Board.Cell;
import Manager.GameManager;
import Utils.Side;

import java.util.ArrayList;

public class Rook extends ChessPiece {
    public Rook(GameManager _gm, Side _side, Cell _position){
        this.name = "R";
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
        while(xCurr > 0){
            xCurr --;
            currCell = this.gm.grid.cells.get(yCurr * this.gm.grid.width + xCurr);
            if(currCell.getOccupant() != null && currCell.getOccupant().getSide() == this.side) break;
            threatenedCells.add(currCell);
            if(currCell.getOccupant() != null && currCell.getOccupant().getSide() != this.side) break;
        }
        xCurr = this.position.getCol();
        while(xCurr < this.gm.grid.width-1){
            xCurr ++;
            currCell = this.gm.grid.cells.get(yCurr * this.gm.grid.width + xCurr);
            if(currCell.getOccupant() != null && currCell.getOccupant().getSide() == this.side) break;
            threatenedCells.add(currCell);
            if(currCell.getOccupant() != null && currCell.getOccupant().getSide() != this.side) break;
        }
        xCurr = this.position.getCol();
        while(yCurr > 0){
            yCurr --;
            currCell = this.gm.grid.cells.get(yCurr * this.gm.grid.width + xCurr);
            if(currCell.getOccupant() != null && currCell.getOccupant().getSide() == this.side) break;
            threatenedCells.add(currCell);
            if(currCell.getOccupant() != null && currCell.getOccupant().getSide() != this.side) break;
        }
        yCurr = this.position.getLine();
        while(yCurr < this.gm.grid.height-1){
            yCurr ++;
            currCell = this.gm.grid.cells.get(yCurr * this.gm.grid.width + xCurr);
            if(currCell.getOccupant() != null && currCell.getOccupant().getSide() == this.side) break;
            threatenedCells.add(currCell);
            if(currCell.getOccupant() != null && currCell.getOccupant().getSide() != this.side) break;
        }
        return threatenedCells;
    }

    @Override
    public ArrayList<Cell> possibleMove() {
        return this.possibleAttacks();
    }
}
