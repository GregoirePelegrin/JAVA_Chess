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
    public void Move() {

    }

    @Override
    public ArrayList<Cell> possibleMove() {
        return new ArrayList<Cell>();
    }
}
