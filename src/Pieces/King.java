package Pieces;

import Board.Cell;
import Manager.GameManager;
import Utils.Side;

import java.util.ArrayList;

public class King extends ChessPiece {
    public King(GameManager _gm, Side _side, Cell _position){
        this.name = "Kg";
        this.gm = _gm;
        this.side = _side;
        this.position = _position;
        this.position.setOccupant(this);
    }

    @Override
    public void Move() {

    }

    @Override
    public ArrayList<Cell> possibleAttacks() {
        ArrayList<Cell> threatenedCells = new ArrayList<Cell>();
        int xCurr = this.position.getCol();
        int yCurr = this.position.getLine();
        Cell currCell;
        boolean[][] truthTable = new boolean[3][3];
        for(int i=0; i<truthTable.length; i++){
            for(int j=0; j<truthTable[i].length; j++){
                truthTable[i][j] = true;
            }
        }
        truthTable[1][1] = false;
        if(yCurr == 0){
            truthTable[0][0] = false;
            truthTable[0][1] = false;
            truthTable[0][2] = false;
        }
        if(xCurr == this.gm.grid.width-1){
            truthTable[0][2] = false;
            truthTable[1][2] = false;
            truthTable[2][2] = false;
        }
        if(yCurr == this.gm.grid.height-1){
            truthTable[2][0] = false;
            truthTable[2][1] = false;
            truthTable[2][2] = false;
        }
        if(xCurr == 0){
            truthTable[0][0] = false;
            truthTable[1][0] = false;
            truthTable[2][0] = false;
        }
        for(int i=0; i<truthTable.length; i++){
            for(int j=0; j<truthTable[i].length; j++){
                if(truthTable[i][j]){
                    currCell = this.gm.grid.cells.get((yCurr - 1 + i) * this.gm.grid.width + (xCurr - 1 + j));
                    if(currCell.getOccupant() != null && currCell.getOccupant().getSide() == this.side) continue;
                    threatenedCells.add(currCell);
                }
            }
        }
        return threatenedCells;
    }

    @Override
    public ArrayList<Cell> possibleMove() {
        // TODO: Verify if the cells really are accessible for the King
        return this.possibleAttacks();
    }
}
