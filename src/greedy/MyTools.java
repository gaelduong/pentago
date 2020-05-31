package greedy;

import java.util.ArrayList;
import java.util.Arrays;

import pentago_swap.PentagoBoardState;
import pentago_swap.PentagoBoardState.Piece;
import pentago_swap.PentagoBoardState.Quadrant;
import pentago_swap.PentagoCoord;
import pentago_swap.PentagoMove;
//game 136
//game 175
//game 359
//game 364
//game 427
//464
//477 or 476
public class MyTools {
	
	static ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
	
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

//		//PentagoBoardState board = new PentagoBoardState();
//		//board4.processMove(m2);
//		long s = System.nanoTime();
//		
//		double eval = eval(board,Piece.WHITE, Piece.BLACK);
//		//double eval2 = eval(board,Piece.BLACK, Piece.WHITE);
//		long e = System.nanoTime();
//		System.out.println( "Time: "  +(e-s)/1000000000.0);
		
        
		
	}
    
    public static double alphaBetaPruning(PentagoBoardState board) {
    	//board.processMove(m);
    	
    	
    	return 0;
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
    
    
    public static double eval(PentagoBoardState board, Piece turnPlayerPiece, Piece opponentPiece) {
    	
    	ArrayList<ArrayList<Integer>> r1 = countHorizontal(board,turnPlayerPiece,opponentPiece);
    	
    	
    	ArrayList<ArrayList<Integer>> r2 = countVertical(board,turnPlayerPiece,opponentPiece);
    	
    
    	ArrayList<ArrayList<Integer>> r3 = countLongDiagonal(board,turnPlayerPiece,opponentPiece);
    	

    	ArrayList<ArrayList<Integer>> r4 = countShortDiagonal(board,turnPlayerPiece,opponentPiece);
    	
//    	System.out.println("horizontal: " + Arrays.toString(r1.toArray()) + " size: " + r1.size());
//    	System.out.println("vertical: " + Arrays.toString(r2.toArray()) + " size: " + r2.size());
//    	System.out.println("long diagonal: " + Arrays.toString(r3.toArray()) + " size: " + r3.size());
//    	System.out.println("short diagonal: " + Arrays.toString(r4.toArray()) + " size: " + r4.size());
    	
    	
    	if(foundWinMove) {
    		//System.out.println("Found it");
    		foundWinMove = false;
    		return -260691624;
    	}
    	
    	result.addAll(r1);
    	result.addAll(r2);
    	result.addAll(r3);
    	result.addAll(r4);

    	double value = 0;
    	
    	for(ArrayList<Integer> tup : result) {
    		int n = tup.get(0);
    		int v = tup.get(1);
    		value += n == 1? 1*v : n == 2? 5*v : n == 3? 700*v : n == 4? 12000*v : n == 5? 1000000*v : 0;
    		
    	}
    	//System.out.println("Result: " + Arrays.toString(result.toArray()) + " size: " + result.size());
    	//System.out.println("Value " + turnPlayerPiece + ": " + value);
    	
    	result.clear();
    	
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
    	if(numPieces == 4 && checkConsecutives(coords)) {
    		//quality += 9999;
    		ArrayList<Integer> l = new ArrayList<Integer>(Arrays.asList(numPieces,quality));
    		tuple.addAll(l);
    		return tuple;
    	}
    	else if(numPieces == 5 && checkConsecutives(coords)) {
    		foundWinMove = true;
    		
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
   
    private static boolean checkConsecutives(int[][] coords) {
    	//(x +- 1, y+-1)
    	
    	int deltaX = coords[1][0] - coords[0][0];
    	
    	int deltaY = coords[1][1] - coords[0][1];
    	
    	
    	if(Math.abs(deltaX) != 1 && Math.abs(deltaY) != 1 && Math.abs(deltaX) != 0 && Math.abs(deltaY) != 0) return false;
    	
    	for(int i = 1; i < coords.length; i++) {
    		
    		if(coords[i][0] - coords[i-1][0] != deltaX) return false;
    		if(coords[i][1] - coords[i-1][1] != deltaY) return false;
    	}
    	
    	return true;
    }
    
    private static boolean inSameQuadrant(int[][] coords) {
    	for(int i = 1; i < coords.length; i++) {
    		if(getCurrentQuadrant(coords[i][0],coords[i][1]) != getCurrentQuadrant(coords[i-1][0],coords[i-1][1])) return false;
    	}
    	
    	return true;
    }
    /*-----------------------------------------------------------------*/
    
   
    

}