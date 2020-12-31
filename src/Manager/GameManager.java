package Manager;

import Board.Grid;
import Pieces.*;
import Utils.Side;

import java.util.ArrayList;

public class GameManager {
    public ArrayList<ChessPiece> pieces;
    public Grid grid;

    public GameManager(){
        // Initialize
        this.grid = new Grid(this);
        this.pieces = new ArrayList<ChessPiece>();

        // Create chess pieces in the list
        // Bishops
        this.pieces.add(new Bishop(this, Side.BLACK, this.grid.cells.get(0*this.grid.width + 2)));
        this.pieces.add(new Bishop(this, Side.BLACK, this.grid.cells.get(0*this.grid.width + 5)));
        this.pieces.add(new Bishop(this, Side.WHITE, this.grid.cells.get(7*this.grid.width + 2)));
        this.pieces.add(new Bishop(this, Side.WHITE, this.grid.cells.get(7*this.grid.width + 5)));
        // Kings
        this.pieces.add(new King(this, Side.BLACK, this.grid.cells.get(0*this.grid.width + 4)));
        this.pieces.add(new King(this, Side.WHITE, this.grid.cells.get(7*this.grid.width + 4)));
        // Knights
        this.pieces.add(new Knight(this, Side.BLACK, this.grid.cells.get(0*this.grid.width + 1)));
        this.pieces.add(new Knight(this, Side.BLACK, this.grid.cells.get(0*this.grid.width + 6)));
        this.pieces.add(new Knight(this, Side.WHITE, this.grid.cells.get(7*this.grid.width + 1)));
        this.pieces.add(new Knight(this, Side.WHITE, this.grid.cells.get(7*this.grid.width + 6)));
        // Pawns
        for(int i=0; i<this.grid.width; i++){
            this.pieces.add(new Pawn(this, Side.BLACK, this.grid.cells.get(1*this.grid.width + i)));
        }
        for(int i=0; i<this.grid.width; i++){
            this.pieces.add(new Pawn(this, Side.WHITE, this.grid.cells.get(6*this.grid.width + i)));
        }
        // Queens
        this.pieces.add(new Queen(this, Side.BLACK, this.grid.cells.get(0*this.grid.width + 3)));
        this.pieces.add(new Queen(this, Side.WHITE, this.grid.cells.get(7*this.grid.width + 3)));
        // Rooks
        this.pieces.add(new Rook(this, Side.BLACK, this.grid.cells.get(0*this.grid.width + 0)));
        this.pieces.add(new Rook(this, Side.BLACK, this.grid.cells.get(0*this.grid.width + 7)));
        this.pieces.add(new Rook(this, Side.WHITE, this.grid.cells.get(7*this.grid.width + 0)));
        this.pieces.add(new Rook(this, Side.WHITE, this.grid.cells.get(7*this.grid.width + 7)));
    }

    @Override
    public String toString() {
        return this.grid.display();
    }
}
