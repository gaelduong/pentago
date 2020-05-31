package student_player;
import java.util.Comparator;

import java.util.ArrayList;
import java.util.Arrays;

import boardgame.Move;
import pentago_swap.PentagoBoardState;
import pentago_swap.PentagoMove;
import pentago_swap.PentagoBoardState.Piece;
import pentago_swap.PentagoBoardState.Quadrant;
//game 136
//game 175
//game 359
//game 364
//game 427
//464
//477 or 476
public class MyTools {
	
	static ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
	
	static Piece turnPlayerPiece;
	static Piece opponentPiece;
	static int i = 0;
	
	static boolean foundWinMove = false;
	static boolean h = false;
	
	
	static int[][][] h1 = { { {0,0}, {0,1}, {0,2} }, { {0,3}, {0,4}, {0,5} }, { {3,0}, {3,1}, {3,2} }, { {3,3}, {3,4}, {3,5} } };
	static int[][][] h2 = { { {1,0}, {1,1}, {1,2} }, { {1,3}, {1,4}, {1,5} }, { {4,0}, {4,1}, {4,2} }, { {4,3}, {4,4}, {4,5} } };
	static int[][][] h3 = { { {2,0}, {2,1}, {2,2} }, { {2,3}, {2,4}, {2,5} }, { {5,0}, {5,1}, {5,2} }, { {5,3}, {5,4}, {5,5} } };
	static int[][][][] horizontal = {h1,h2,h3};
	
	static int[][][] v1 = { { {0,0}, {1,0}, {2,0} }, { {0,3}, {1,3}, {2,3} }, { {3,0}, {4,0}, {5,0} }, { {3,3}, {4,3}, {5,3} } };
	static int[][][] v2 = { { {0,1}, {1,1}, {2,1} }, { {0,4}, {1,4}, {2,4} }, { {3,1}, {4,1}, {5,1} }, { {3,4}, {4,4}, {5,4} } };
	static int[][][] v3 = { { {0,2}, {1,2}, {2,2} }, { {0,5}, {1,5}, {2,5} }, { {3,2}, {4,2}, {5,2} }, { {3,5}, {4,5}, {5,5} } };
	static int[][][][] vertical = {v1,v2,v3};
	
	static int[][][] ld1 = { { {0,0}, {1,1}, {2,2} }, { {0,3}, {1,4}, {2,5} }, { {3,0}, {4,1}, {5,2} }, { {3,3}, {4,4}, {5,5} } };
	static int[][][] ld2 = { { {0,2}, {1,1}, {2,0} }, { {0,5}, {1,4}, {2,3} }, { {3,2}, {4,1}, {5,0} }, { {3,5}, {4,4}, {5,3} } };
	static int[][][][] longdiagonal = {ld1,ld2};
	
	static int[][][][] sd1 = { {{ {0,1},{1,2}}, { {0,4},{1,5}}, { {3,1},{4,2} }, { {3,4},{4,5}} }, { { {2,0} }, { {5,0} }, { {2,3 } }, { {5,3 } }} };   	
	static int[][][][] sd2 = { {{ {1,0},{2,1}}, { {4,0},{5,1}}, { {1,3},{2,4} }, { {4,3},{5,4}} }, { { {0,2} }, { {0,5} }, { {3,2 } }, { {3,5 } }} };   
	static int[][][][] sd3 = { {{ {0,1},{1,0}}, { {3,1},{4,0}}, { {0,4},{1,3} }, { {3,4},{4,3}} }, { { {2,2} }, { {2,5} }, { {5,2 } }, { {5,5 } }} };
	static int[][][][] sd4 = { {{ {1,2},{2,1}}, { {1,5},{2,4}}, { {4,2},{5,1} }, { {4,5},{5,4}} }, { { {0,0} }, { {3,0} }, { {0,3 } }, { {3,3 } }} };
	static int[][][][][] shortdiagonal = {sd1,sd2,sd3,sd4};
	
	public static void main(String[] args) {
		int[][] c = { {5,0},{4,1},{2,0},{1,1}, {3,2} };
		
		
		
		//System.out.println(Arrays.deepToString(c));
		//System.out.println(checkConsecutives(c));
		//System.out.println(oneSwapAwayFromWinning(c));
//		PentagoBoardState board = new PentagoBoardState();
//		
//	
//		opponentPiece = board.getOpponent() == 0 ? Piece.WHITE: Piece.BLACK;
//    	turnPlayerPiece = board.getTurnPlayer() == 0 ? Piece.WHITE: Piece.BLACK;
//    	
//    	
//    	System.out.println(eval(board));
//    	
//		//board4.processMove(m2);
//		long s = System.nanoTime();
//		double min = -9999999;
//		double max = 9999999;
//		System.out.println(eval(board));
//		System.out.println(alphaBeta(board, 0, min, max, 0).getMove().toPrettyString());
//		//double eval = getValue(board,Piece.WHITE, Piece.BLACK);
//		//double eval2 = eval(board,Piece.BLACK, Piece.WHITE);
//		long e = System.nanoTime();
//		System.out.println( "Time: "  +(e-s)/1000000000.0);
		
	}
	
	
	
	
    
    public static Result alphaBeta(PentagoBoardState board, int depth, double alpha, double beta, int player) {
    	//board.processMove(m);
    	
    	if(depth == 2) {
    		return new Result(eval(board) ,null);
    	}
    	
    	if(player == 0)
    	{
    		//System.out.println("gor");
    		double v = -999999999;
    		
    		ArrayList<PentagoMove> moves = board.getAllLegalMoves();
    		PentagoMove myMove = null;
    		double bestScore = -99999999;
    		for(PentagoMove m : moves)
    		{

    			PentagoBoardState child = (PentagoBoardState) board.clone();
    			child.processMove(m);
    			v = Math.max(v,alphaBeta(child, depth + 1, alpha, beta, 1).getScore());
    			alpha = Math.max(alpha, v);
    			
    			//find move
    			if(depth == 0) 
    			{
    				if(v == 9999999) 
    				{
    	    			System.out.println("Win move found" );
    	    			return new Result(v,m);
    	    		}
    				if(v > bestScore) 
					{
    					bestScore = v;
    					System.out.println("bestScore: " + bestScore);
    					myMove = m;
					}
    			}
    			
    			if(alpha >= beta) break;
    		}
    		System.out.println("Alphabeta max: " + bestScore);
    		
    		return new Result(v,myMove);
    		
    	}
    	else
    	{
    		double v = 999999999;
    		ArrayList<PentagoMove> moves = board.getAllLegalMoves();
    		for(PentagoMove m : moves)
    		{
    			i++;
    			PentagoBoardState child = (PentagoBoardState) board.clone();
    			child.processMove(m);
    			v = Math.min(v, alphaBeta(child, depth + 1, alpha, beta, 0).getScore());
    			//System.out.println("Value of leaf: " + v);
    			//System.out.println(Math.min(111, v));
    			beta = Math.min(beta, v);
    			if(alpha >= beta) break;
    		}
    		
    		System.out.println("number of children checked " + i);
    		i = 0;
    		return new Result(v,null);
    		
    	}
    	
    
    }
    
    static class Result{
    	double score;
    	PentagoMove move;
    	
    	Result(double score, PentagoMove move){
    		this.score = score;
    		this.move = move;
    	}
    	
    	 double getScore() {
    		return this.score;
    	}
    	
    	 PentagoMove getMove() {
    		return this.move;
    	}
    	
    	
    }
    
    public static ArrayList<ArrayList<Integer>> countHorizontal(PentagoBoardState board, Piece turnPlayerPiece, Piece opponentPiece){
    h=false;	
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	
    	for(int k = 0; k < horizontal.length; k++) 
    	{
    		for(int i = 0; i < h1.length; i++) 
        	{
    			int[][][] coord = horizontal[k];
    			
        		for(int j = i+1; j < h1.length; j++)
        		{
        			//first quadrant
    	        	int x1 = coord[i][0][0];
    	        	int y1 = coord[i][0][1];
    	        	int x2 = coord[i][1][0];
    	        	int y2 = coord[i][1][1];
    	        	int x3 = coord[i][2][0];
    	        	int y3 = coord[i][2][1];
    	        	//second quadrant
    	        	int x4 = coord[j][0][0];
    	        	int y4 = coord[j][0][1];
    	        	int x5 = coord[j][1][0];
    	        	int y5 = coord[j][1][1];
    	        	int x6 = coord[j][2][0];
    	        	int y6 = coord[j][2][1];
    	        	
    	        
    	        	
    	        	int [][] coords = { {x1,y1}, {x2,y2},{x3,y3}, {x4,y4}, {x5,y5}, {x6,y6} };
    	        	
    	        	ArrayList<ArrayList<Integer>> r = getConnectedList(board, coords, turnPlayerPiece, opponentPiece);
    	        	
    	        	result.addAll(r);
    	        	//System.out.println(Arrays.toString(result.toArray()));
    	        	
    	        	
        		}
        	}
    		
    	}
    	
    	
    	return result;
    	
    }
    
    public static ArrayList<ArrayList<Integer>> countVertical(PentagoBoardState board, Piece turnPlayerPiece, Piece opponentPiece){
    	h = false;
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	
    	for(int k = 0; k < vertical.length; k++) 
    	{
    		for(int i = 0; i < v1.length; i++) 
        	{
    			int[][][] coord = vertical[k];
    			
        		for(int j = i+1; j < v1.length; j++)
        		{
        			//first quadrant
    	        	int x1 = coord[i][0][0];
    	        	int y1 = coord[i][0][1];
    	        	int x2 = coord[i][1][0];
    	        	int y2 = coord[i][1][1];
    	        	int x3 = coord[i][2][0];
    	        	int y3 = coord[i][2][1];
    	        	//second quadrant
    	        	int x4 = coord[j][0][0];
    	        	int y4 = coord[j][0][1];
    	        	int x5 = coord[j][1][0];
    	        	int y5 = coord[j][1][1];
    	        	int x6 = coord[j][2][0];
    	        	int y6 = coord[j][2][1];
    	        	
    	        
    	        	
    	        	int [][] coords = { {x1,y1}, {x2,y2},{x3,y3}, {x4,y4}, {x5,y5}, {x6,y6} };
    	        	
    	        	ArrayList<ArrayList<Integer>> r = getConnectedList(board, coords, turnPlayerPiece, opponentPiece);
    	        	
    	        	result.addAll(r);

        		}
        	}
    		
    	}
    	
    	return result;
    	
    }

	public static ArrayList<ArrayList<Integer>> countLongDiagonal(PentagoBoardState board, Piece turnPlayerPiece, Piece opponentPiece){
		h=false;
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		for(int k = 0; k < longdiagonal.length; k++) 
		{
			for(int i = 0; i < ld1.length; i++) 
	    	{
				int[][][] coord = longdiagonal[k];
				
	    		for(int j = i+1; j < ld1.length; j++)
	    		{

		        	//first quadrant
    	        	int x1 = coord[i][0][0];
    	        	int y1 = coord[i][0][1];
    	        	int x2 = coord[i][1][0];
    	        	int y2 = coord[i][1][1];
    	        	int x3 = coord[i][2][0];
    	        	int y3 = coord[i][2][1];
    	        	//second quadrant
    	        	int x4 = coord[j][0][0];
    	        	int y4 = coord[j][0][1];
    	        	int x5 = coord[j][1][0];
    	        	int y5 = coord[j][1][1];
    	        	int x6 = coord[j][2][0];
    	        	int y6 = coord[j][2][1];
    	        	

    	        	int [][] coords = { {x1,y1}, {x2,y2},{x3,y3}, {x4,y4}, {x5,y5}, {x6,y6} };
    	        	
    	        	ArrayList<ArrayList<Integer>> r = getConnectedList(board, coords, turnPlayerPiece, opponentPiece);
		        	
		        	result.addAll(r);
	
	    		}
	    	}
			
		}
		
		return result;
	}
	
    public static ArrayList<ArrayList<Integer>> countShortDiagonal(PentagoBoardState board, Piece turnPlayerPiece, Piece opponentPiece){
    	h=true;
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	
    	for(int s=0; s < shortdiagonal.length; s++) {
	    	for(int i=0; i < 4; i++) {
	    		int[][][][] coord = shortdiagonal[s];
	    		for(int j =i+1; j < 4;j++) {
	    			for(int k = 0; k < 4; k++) {
	    				
	    				int x_q1_c1 = coord[0][i][0][0];
	    				int y_q1_c1 = coord[0][i][0][1];
	    				int x_q1_c2 = coord[0][i][1][0];
	    				int y_q1_c2 = coord[0][i][1][1];
	    				
	    				int x_q2_c1 = coord[0][j][0][0];
	    				int y_q2_c1 = coord[0][j][0][1];
	    				int x_q2_c2 = coord[0][j][1][0];
	    				int y_q2_c2 = coord[0][j][1][1];
	    				
	    				int x_small_cell = coord[1][k][0][0];
	                	int y_small_cell = coord[1][k][0][1];
	                	
	                	if(getCurrentQuadrant(x_small_cell,y_small_cell) == getCurrentQuadrant(x_q1_c1,y_q1_c1) 
	                		|| getCurrentQuadrant(x_small_cell,y_small_cell) == getCurrentQuadrant(x_q2_c1,y_q2_c1)) 
	                		{continue;}

	                	
	                	int [][] coords = { {x_q1_c1,y_q1_c1}, {x_q1_c2,y_q1_c2},{x_small_cell,y_small_cell}, {x_q2_c1,y_q2_c1}, {x_q2_c2,y_q2_c2} };
	                	
	                	ArrayList<Integer> tuple = countPieces(board, coords, turnPlayerPiece, opponentPiece);
	                	if(tuple.get(0) != 0) result.add(tuple);
	                	
	    			}
	    		}
	    	}
    	}
    	//System.out.println(result.size());
    	
    	return result;
    }
    
    public static double eval(PentagoBoardState board) {
    	double myVal = getValue(board, turnPlayerPiece, opponentPiece) ;
//		if(myVal == 9999999) {
//			return 9999999;
//		}
		double hisVal = getValue(board, opponentPiece, turnPlayerPiece);
//		if(myVal == 9999999) {
//			System.out.println("it did return -9999999");
//			return -9999999;
//		}
    	return myVal - hisVal;
    }
    
    
    public static double getValue(PentagoBoardState board, Piece playerAPiece, Piece playerBPiece) {
    	
    	ArrayList<ArrayList<Integer>> r1 = countHorizontal(board,playerAPiece,playerBPiece);
    	
    	
    	ArrayList<ArrayList<Integer>> r2 = countVertical(board,playerAPiece,playerBPiece);
    	
    
    	ArrayList<ArrayList<Integer>> r3 = countLongDiagonal(board,playerAPiece,playerBPiece);
    	

    	ArrayList<ArrayList<Integer>> r4 = countShortDiagonal(board,playerAPiece,playerBPiece);
    	
//    	System.out.println("horizontal: " + Arrays.toString(r1.toArray()) + " size: " + r1.size());
//    	System.out.println("vertical: " + Arrays.toString(r2.toArray()) + " size: " + r2.size());
//    	System.out.println("long diagonal: " + Arrays.toString(r3.toArray()) + " size: " + r3.size());
//    	System.out.println("short diagonal: " + Arrays.toString(r4.toArray()) + " size: " + r4.size());
    	
    	
    	if(foundWinMove) {
    		//System.out.println("Found it");
    		foundWinMove = false;
    		return 9999999;
    	}
    	
    	result.addAll(r1);
    	result.addAll(r2);
    	result.addAll(r3);
    	result.addAll(r4);

    	double value = 0;
    	
    	for(ArrayList<Integer> tup : result) {
    		int n = tup.get(0);
    		int v = tup.get(1);
    		value += n == 1? 1*v : n == 2? 5*v : n == 3? 700*v : n == 4? 12000*v : n == 5? 100000*v : 0;
    		
    	}
    	//System.out.println("Result: " + Arrays.toString(result.toArray()) + " size: " + result.size());
    	//System.out.println("Value " + turnPlayerPiece + ": " + value);
    	
    	result.clear();
    	
    	value = value*100;
    	value = Math.round(value);
    	value = value /100;
    	
    	return value;
    	
    }
    
    /*-----------------------------HELPER -----------------------------*/
    public static ArrayList<ArrayList<Integer>> getConnectedList(PentagoBoardState board, int[][] coords, Piece turnPlayerPiece, Piece opponentPiece){
    	
    	ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
    			
    	int[][] a = { coords[0], coords[1], coords[2], coords[3], coords[4] };
    	int[][] b = { coords[1], coords[2], coords[3], coords[4], coords[5] };
    	int[][] c = { coords[3], coords[4], coords[5], coords[0], coords[1] };
    	int[][] d = { coords[4], coords[5], coords[0], coords[1], coords[2] };
    	
    
    	ArrayList<Integer> tupleA = countPieces(board, a, turnPlayerPiece, opponentPiece);
    	ArrayList<Integer> tupleB = countPieces(board, b, turnPlayerPiece, opponentPiece);
    	ArrayList<Integer> tupleC = countPieces(board, c, turnPlayerPiece, opponentPiece);
    	ArrayList<Integer> tupleD = countPieces(board, d, turnPlayerPiece, opponentPiece);
    	
    	if(tupleA.get(0) != 0) r.add(tupleA);
    	if(tupleB.get(0) != 0) r.add(tupleB);
    	if(tupleC.get(0) != 0) r.add(tupleC);
    	if(tupleD.get(0) != 0) r.add(tupleD);

    	return r;
    	
    	
    }
    
    public static ArrayList<Integer> countPieces(PentagoBoardState board, int[][] coords, Piece turnPlayerPiece, Piece opponentPiece) {
    	
    	ArrayList<Integer> tuple = new ArrayList<Integer>(2);
    	//variable to store #pieces
    	int numPieces = 0;
    	int quality = 0;
    	
    	//when numPieces = 2, check if 2 pieces are connected enough (at most 1 piece away)
		int f = -1;
		int s = -1;
    	for(int i = 0; i < coords.length; i++)
    	{
    		Piece piece = board.getPieceAt(coords[i][0],coords[i][1]);
    		if(piece.equals(opponentPiece)) {
    			numPieces = 0;
    			
    			break;
    		};
    		if(piece.equals(turnPlayerPiece)) {
    			
    			if(f !=-1) s = i;
    			else f = i;
    			numPieces++;	
    		}
    		
    	}
    	quality = numPieces;
    	//if(numPieces == 4 && checkConsecutives(coords)) {
    	if(numPieces == 4) {
    		//quality += 9999;
    		ArrayList<Integer> l = new ArrayList<Integer>(Arrays.asList(numPieces,quality));
    		tuple.addAll(l);
    		return tuple;
    	}
    	else if(numPieces == 5) {
    		if(checkConsecutives(coords)) {
    			foundWinMove = true;
    			//System.out.println("HEY " + turnPlayerPiece);
        		//System.out.println(board.toString());
    		}
//    		else if(oneSwapAwayFromWinning(coords)) {
//    			quality = 7;
//    		}
    		
    		
    		ArrayList<Integer> l = new ArrayList<Integer>(Arrays.asList(numPieces,quality));
    		tuple.addAll(l);
    		return tuple;
    	}
    	//else if(numPieces == 1) numPieces = 0;
    	else if(numPieces ==2 && Math.abs(f-s) <= 2) {
    		//quality += 1;
    		ArrayList<Integer> l = new ArrayList<Integer>(Arrays.asList(numPieces,quality));
    		tuple.addAll(l);
    		//numPieces = 0;
    		return tuple;
    	}
    	
    	ArrayList<Integer> l = new ArrayList<Integer>(Arrays.asList(numPieces,quality));
    	tuple.addAll(l);
    	return tuple;
    	
    }
    
    
    private static int getCurrentQuadrant(int x, int y) {
    	
    	return (x >= 0 && x <= 2)? (y >=0 && y <= 2) ? 0 : 1 : (y >=0 && y <= 2)? 2 : 3;
    }
   
    private static boolean checkConsecutives(int[][] or_coords) {
    	//(x +- 1, y+-1)
    	
    	int[][] coords = sortCoordinates(or_coords);

    	
    	int deltaX = coords[1][0] - coords[0][0];
    	
    	int deltaY = coords[1][1] - coords[0][1];
    	
    	
    	if(Math.abs(deltaX) != 1 && Math.abs(deltaY) != 1 && Math.abs(deltaX) != 0 && Math.abs(deltaY) != 0) return false;
    	
    	for(int i = 1; i < coords.length; i++) {
    		
    		if(coords[i][0] - coords[i-1][0] != deltaX) return false;
    		if(coords[i][1] - coords[i-1][1] != deltaY) return false;
    	}
    	
    	return true;
    }
    
    
    
    private static boolean oneSwapAwayFromWinning(int[][]coords) {
    	return 	   checkConsecutivesAfterOneSwap(coords,0,1) 
    			|| checkConsecutivesAfterOneSwap(coords,0,2)
    			|| checkConsecutivesAfterOneSwap(coords,0,3)
    			|| checkConsecutivesAfterOneSwap(coords,1,2)
    			|| checkConsecutivesAfterOneSwap(coords,1,3)
    			|| checkConsecutivesAfterOneSwap(coords,2,3);
    }
    private static boolean  checkConsecutivesAfterOneSwap(int[][]or_coords, int q1, int q2) {
    	
    	int[][] coords = new int[5][];
    	for(int i = 0; i < coords.length; i++) {
    		coords[i] = new int[2];
    		coords[i][0] = or_coords[i][0];
    		coords[i][1] = or_coords[i][1];
    		
    	}
    	
    	for(int i = 0; i < coords.length; i++) {
    		int currQ = getCurrentQuadrant(coords[i][0],coords[i][1]);
    		//swap TL-TR
    		if(q1 == 0 && q2 == 1) {
    			coords[i][1] += currQ == 0? 3 : currQ == 1? -3 : 0;
    		}
    		//swap TL-BR
    		else if(q1 == 0 && q2 == 3) {
    			coords[i][0] += currQ == 0? 3 : currQ == 3? -3 : 0;
        		coords[i][1] += currQ == 0? 3 : currQ == 3? -3 : 0;
    		}
    		//swap TL-BL
    		else if(q1 == 0 && q2 == 2) {
    			
        		coords[i][0] += currQ == 0? 3 : currQ == 2? -3 : 0;
    		}
    		//swap TR-BL
    		else if(q1 == 1 && q2 == 2) {
    			coords[i][0] += currQ == 1? -3 : currQ == 2? 3 : 0;
    			coords[i][1] += currQ == 1? -3 : currQ == 2? 3 : 0;
    		}
    		//swap TR-BR
    		else if(q1 == 1 && q2 == 3) {
    			coords[i][0] += currQ == 1? 3 : currQ == 3? -3 : 0;
    		}
    		//swap BL-BR
    		else if(q1 == 2 && q2 == 3) {
    			coords[i][1] += currQ == 2? 3 : currQ == 3? -3 : 0;
    		}
    		
    	}
    	
    	//System.out.println(Arrays.deepToString(coords) + q1 + " " + q2);
    	
    	return checkConsecutives(coords);
    }
    
    private static int [][] sortCoordinates(int [][] coords) {
    	
    	int [][] sorted = new int[coords.length][];
    	
    	//sort by x
    	Arrays.sort(coords, new Comparator<int[]>() {
            @Override
            public int compare(int[] int1, int[] int2)
            {
                Integer number1 = int1[0];
                Integer number2 = int2[0];
                return number1.compareTo(number2);
            }
        });
    	
    	
    	//sort by y
    	Arrays.sort(coords, new Comparator<int[]>() {
            @Override
            public int compare(int[] int1, int[] int2)
            {
                Integer number1 = int1[1];
                Integer number2 = int2[1];
                return number1.compareTo(number2);
            }
        });
    	
    	for(int i = 0 ; i < sorted.length; i ++) {
    		sorted[i] = new int[2];
    		sorted[i][0] = coords[i][0];
    		sorted[i][01] = coords[i][1];
    	}
    	return sorted;
    }
    
    private static boolean inSameQuadrant(int[][] coords) {
    	for(int i = 1; i < coords.length; i++) {
    		if(getCurrentQuadrant(coords[i][0],coords[i][1]) != getCurrentQuadrant(coords[i-1][0],coords[i-1][1])) return false;
    	}
    	
    	return true;
    }
    /*-----------------------------------------------------------------*/
    
   
    

}