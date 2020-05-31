package greedy;

import java.util.ArrayList;

import boardgame.Move;
import pentago_swap.PentagoBoardState;
import pentago_swap.PentagoMove;
import pentago_swap.PentagoPlayer;
import pentago_swap.PentagoBoardState.Piece;

/** A player file submitted by a student. */
public class StudentPlayer extends PentagoPlayer {
	
	int r = 0;

    /**
     * You must modify this constructor to return your student number. This is
     * important, because this is what the code that runs the competition uses to
     * associate you with your agent. The constructor should do nothing else.
     */
    public StudentPlayer() {
        super("260691624Greedy");
    }

    /**
     * This is the primary method that you need to implement. The ``boardState``
     * object contains the current state of the game, which your agent must use to
     * make decisions.
     */
    public Move chooseMove(PentagoBoardState boardState) {
    	r++;
    	
    	Piece opponentPiece = boardState.getOpponent() == 0 ? Piece.WHITE: Piece.BLACK;
    	Piece turnPlayerPiece = boardState.getTurnPlayer() == 0 ? Piece.WHITE: Piece.BLACK;

    	long s = System.nanoTime();
		
    	ArrayList<PentagoMove> moves = boardState.getAllLegalMoves();
    
    	
    	PentagoMove myMove = null;

    	double max = -999999999;

    	for(PentagoMove m : moves) {
    		
    		PentagoBoardState board = (PentagoBoardState) boardState.clone();
    		
    		board.processMove(m);
    		
    		double myVal = MyTools.eval(board,turnPlayerPiece,opponentPiece);
    		
    		//if move first then choose max value
    		double value;
    		
    		if(board.getTurnNumber() == 0) {
    			value = myVal;
    		}
    		
    		//if found a win move
    		
    		else if(myVal == -260691624) {
    			System.out.println("Win move found" );
    			return m;
    		}
    		
    		//otherwise, find max difference between 2 players
    		
    		double hisVal = MyTools.eval(board,opponentPiece,turnPlayerPiece);
    		//System.out.println("hisVal: " + hisVal );
    		

			value = myVal  - hisVal;
			if(value >= max) {
    			max = value;
    			myMove = m;
    		}

    		//if(value > 0 ) System.out.println("HEY I'M WINNING!!!!!!");
    		//System.out.println("Diff: " + value);
    		//System.out.println("Move " + r + " X:" + m.getMoveCoord().getX() + " Y:" + m.getMoveCoord().getY() + " " + m.getASwap() + " " + m.getBSwap());
    		
    	}
    		System.out.println("MAX: " + max);
    		
    	//System.out.println("OFFICAL X:" + myMove.getMoveCoord().getX() + " Y:" + myMove.getMoveCoord().getY() + " " + myMove.getASwap() + " " + myMove.getBSwap());
    	//System.out.println("MAX VALUE: " + max);
    	
        
		long e = System.nanoTime();
		System.out.println( "Time execut: "  +(e-s)/1000000000.0);
   
        return myMove;
    }
}