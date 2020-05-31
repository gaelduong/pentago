package gael_student_player;

import java.util.ArrayList;

import boardgame.Move;
import pentago_swap.PentagoBoardState;
import pentago_swap.PentagoMove;
import pentago_swap.PentagoPlayer;
import pentago_swap.PentagoBoardState.Piece;
import pentago_swap.PentagoBoardState.Quadrant;

/** A player file submitted by a student. */
public class StudentPlayer extends PentagoPlayer {

    /**
     * You must modify this constructor to return your student number. This is
     * important, because this is what the code that runs the competition uses to
     * associate you with your agent. The constructor should do nothing else.
     */
    public StudentPlayer() {
        super("260691624");
    }

    /**
     * This is the primary method that you need to implement. The ``boardState``
     * object contains the current state of the game, which your agent must use to
     * make decisions.
     */
    public Move choseMove(PentagoBoardState boardState) {
    	
    	MyTools.turnPlayerPiece = boardState.getTurnPlayer() == 0 ? Piece.WHITE: Piece.BLACK;
    	MyTools.opponentPiece = boardState.getOpponent() == 0 ? Piece.WHITE: Piece.BLACK;
    	
    	double min = -9999999;
		double max = 9999999;
		
		//if(boardState.getTurnNumber() == 0) return new PentagoMove(1, 1, Quadrant.BL, Quadrant.BR, 0);
		
		Move myMove = MyTools.alphaBeta(boardState, 0, min, max, 0).getMove();
		//Move myMove = MyTools.test(boardState, 0);
		//System.out.println(myMove == null);
		//System.out.println("Right");
		
    	return myMove ;
    }
	    
	    
    public Move chooseMove(PentagoBoardState boardState) {
    	
    	long s = System.nanoTime();
//    	long total = Runtime.getRuntime().totalMemory();
//    	long used  = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
//    	System.out.println(used/ (double)(1024 * 1024));
    	//System.out.println("turn" +boardState.getTurnNumber());
    	if(boardState.getTurnNumber() == 0) {
    		PentagoMove m = new PentagoMove(1,1,Quadrant.BL,Quadrant.BR,boardState.getTurnPlayer());
    		if(boardState.isLegal(m)) return m;
    		
    		PentagoMove m1 = new PentagoMove(1,4,Quadrant.BL,Quadrant.BR,boardState.getTurnPlayer());
    		if(boardState.isLegal(m1)) return m1;
    		
    		PentagoMove m2 = new PentagoMove(4,1,Quadrant.BL,Quadrant.BR,boardState.getTurnPlayer());
    		if(boardState.isLegal(m2)) return m2;
    		
    		PentagoMove m3 = new PentagoMove(4,4,Quadrant.BL,Quadrant.BR,boardState.getTurnPlayer());
    		if(boardState.isLegal(m3)) return m3;
    	}
    	
    	MyTools.opponentPiece = boardState.getOpponent() == 0 ? Piece.WHITE: Piece.BLACK;
    	MyTools.turnPlayerPiece = boardState.getTurnPlayer() == 0 ? Piece.WHITE: Piece.BLACK;

    	
		
    	
    	PentagoMove myMove = null;

    	double max = -999999999;
 
    
    	ArrayList<PentagoMove> moves = boardState.getAllLegalMoves();
    	
    	for(PentagoMove m : moves) 
    	{
    		PentagoBoardState board = (PentagoBoardState) boardState.clone();
    		board.processMove(m);
    		
    		//if found win move, play the move immediately
    		double myVal = MyTools.getValue(board, MyTools.turnPlayerPiece, MyTools.opponentPiece);
    		//System.out.println("LOSE? " + myVal);
    		if(myVal == 9999999) {
    			System.out.println("Win move found" );
    			return m;
    		}
    		//if next move leads to opponent's win, ignore it (continue) and go to the next move
    		double hisVal = MyTools.getValue(board, MyTools.opponentPiece, MyTools.turnPlayerPiece);
    		if(hisVal == 9999999) {
    			continue;
    		}
    
    		
    		ArrayList<PentagoMove> moves2 = board.getAllLegalMoves();

    		double min = 999999999;
    		boolean goesThroughAllChildren = true;
    		for(PentagoMove m2 : moves2) 
    		{
    			PentagoBoardState board2 = (PentagoBoardState) board.clone();
    			
    			board2.processMove(m2);

        		double value = MyTools.eval(board2);

    			if(value < min) {
        			min = value;
        		}
    			
    			if(min <= max) {
    				goesThroughAllChildren = false;
    				//System.out.println("Break");
    				break;			
    			}
    		
    		}
    		
    		if(goesThroughAllChildren) {
    			max = min;
    			System.out.println("Current max: " + max);
    			myMove = m;
    		}
    		

    	}
    	long e = System.nanoTime();
    	System.out.println( "Time run: "  +(e-s)/1000000000.0);
    	return myMove;
    	//System.out.println("MAX: " + max);
    	
    	
   
        
    }
}

