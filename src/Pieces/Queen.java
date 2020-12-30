package Pieces;

import Board.Cell;
import Manager.GameManager;
import Utils.Side;

import java.util.ArrayList;

public class Queen extends ChessPiece {
    public Queen(GameManager _gm, Side _side, Cell _position){
        this.name = "Q";
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
        return null;
    }

    @Override
    public ArrayList<Cell> possibleMove() {
        return new ArrayList<Cell>();
    }
}
