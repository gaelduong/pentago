package student_player;

import java.util.ArrayList;
import java.util.Arrays;

import pentago_swap.PentagoBoardState;
import pentago_swap.PentagoBoardState.Piece;

public class MyTools1 {
	
	ArrayList<ArrayList<ArrayList<Integer>>> horizontalCoord = new ArrayList<ArrayList<ArrayList<Integer>>>();
	
	// < < < a,b,c > >, < <a,a> <b,b> <c,c> > >, 
	
	ArrayList<ArrayList<ArrayList<Integer>>> verticalCoord = new ArrayList<ArrayList<ArrayList<Integer>>>();
	ArrayList<ArrayList<ArrayList<Integer>>> longDiagonalCoord = new ArrayList<ArrayList<ArrayList<Integer>>>();
	ArrayList<ArrayList<ArrayList<Integer>>> shortDiagonalCoord = new ArrayList<ArrayList<ArrayList<Integer>>>();
	
	
	//change back constructor visibility
	//white to empty
	//or just copy paste original file
	public static void main(String[] args) {
		

		
//		PentagoBoardState board = new PentagoBoardState();
//		
//		long s = System.nanoTime();
//		double eval = eval(board,Piece.WHITE, Piece.BLACK);
//		long e = System.nanoTime();
//		System.out.println( (e-s)/1000000000.0);
		
		//long lStartTime = System.nanoTime();
//		
//		
//		System.out.println(board.toString());
//		
//long lEndTime = System.nanoTime();
//		
//
//		//time elapsed
//        System.out.println("Execution time: " + (lEndTime - lStartTime)/ 1000000000.0);
//        System.out.println("Max number of leafs: " + 2.0/ ((lEndTime - lStartTime)/ 1000000000.0));
//		//ArrayList<Integer> h = countHorizontal(board,Piece.WHITE, Piece.BLACK);
//	
//		//System.out.println(Arrays.toString(h.toArray()));
//		
////		
//		//ArrayList<Integer> v = countVertical(board,Piece.WHITE, Piece.BLACK);
//		
//		
//		
////		System.out.println(Arrays.toString(v.toArray()));
////		
////		int[][][] dleft = { {{0,0},{1,1},{2,2}}, { {3,0},{4,1}, {5,2}}, { {0,3},{1,4},{2,5} }, { {3,3},{4,4},{5,5} } };
////    	int[][][] dright = { {{0,5},{1,4},{2,3}}, { {0,2},{1,1},{2,0}}, { {3,5},{4,4},{5,3} }, { {3,2},{4,1},{5,0} } };
////		ArrayList<Integer> d = countLongDiagonal(board,Piece.WHITE, Piece.BLACK,dright);
////		
////		int[][][][] d1 = { {{ {0,1},{1,2}}, { {0,4},{1,5}}, { {3,1},{4,2} }, { {3,4},{4,5}} }, { { {2,0} }, { {5,0} }, { {2,3 } }, { {5,3 } }} };   	
////    	int[][][][] d2 = { {{ {1,0},{2,1}}, { {4,0},{5,1}}, { {1,3},{2,4} }, { {4,3},{5,4}} }, { { {0,2} }, { {0,5} }, { {3,2 } }, { {3,5 } }} };   	
////    	
////    	int[][][][] d3 = { {{ {0,1},{1,0}}, { {3,1},{4,0}}, { {0,4},{1,3} }, { {3,4},{4,3}} }, { { {2,2} }, { {2,5} }, { {5,2 } }, { {5,5 } }} };
////    	int[][][][] d4 = { {{ {1,2},{2,1}}, { {1,5},{2,4}}, { {4,2},{5,1} }, { {4,5},{5,4}} }, { { {0,0} }, { {3,0} }, { {0,3 } }, { {3,3 } }} };
////    	
////    	ArrayList<Integer> s = countShortDiagonal(board,Piece.WHITE, Piece.BLACK,d4);
//    	
//    	double value = eval(board);
//    	//System.out.println(Arrays.toString(s.toArray()));
//    	
//    	System.out.println(value);
    	
		//[2, 2, 2, 4, 5, 4, 4, 2, 2, 2, 2, 3, 3, 2, 3, 2, 2, 3]
		
		//end
        
		
	}
	
	public static double getRandom(PentagoBoardState board) {
        return Math.random();
    }
    
    public static double alphaBetaPruning(PentagoBoardState board) {
    	//board.processMove(m);
    	
    	
    	return 0;
    }
    
    public static ArrayList<Integer> countHorizontal(PentagoBoardState board, Piece turnPlayerPiece, Piece opponentPiece){
    	
    	 
    	//result store list of numbers of connected pieces
    	ArrayList<Integer> result = new ArrayList<Integer>();
	   	 for(int x = 0; x < 6; x ++)
	   	 {
	   		
	 		
	   		int currentQuadrant = getCurrentQuadrant(x,0);
	   		//System.out.println(currentQuadrant);
	   		
	       	int[] otherQuadrants = getOtherQuadrants(x,0);
	       	for(int q = 0; q < 3; q++) 
	       	{
		        	Piece p1 = board.getPieceAt(x,0);
		        	Piece p2 = board.getPieceAt(x,1);
		        	Piece p3 = board.getPieceAt(x,2);
		        	Piece p4 = null;
		        	Piece p5 = null;
		        	Piece p6 = null;
		        	
		        	if(otherQuadrants[q] == 0) 
		        	{
		        		 p4 = board.getPieceAt(x-3,0);
		        		 p5 = board.getPieceAt(x-3,1);
		        		 p6 = board.getPieceAt(x-3,2);
		        	}
		        	else if(otherQuadrants[q] == 2) 
		        	{
		        		 p4 = board.getPieceAt(x+3,0);
		        		 p5 = board.getPieceAt(x+3,1);
		        		 p6 = board.getPieceAt(x+3,2);
		        	}
		        	else if(otherQuadrants[q] == 1) 
		        	{
		        		if(currentQuadrant == 0) 
		        		{
		        			p4 = board.getPieceAt(x,3);
		        			p5 = board.getPieceAt(x,4);
		        			p6 = board.getPieceAt(x,5);
		        		}
		        		else if (currentQuadrant == 2)  
		        		{
		        			p4 = board.getPieceAt(x-3,3);
		        			p5 = board.getPieceAt(x-3,4);
		        			p6 = board.getPieceAt(x-3,5);
		        		}
		        	
		        	}
		        	else if(otherQuadrants[q] == 3) 
		        	{
		        		if(currentQuadrant == 0) 
		        		{
		        			p4 = board.getPieceAt(x+3,3);
		        			p5 = board.getPieceAt(x+3,4);
		        			p6 = board.getPieceAt(x+3,5);
		        		}
		        		else if (currentQuadrant == 2)
		        		{
		        			p4 = board.getPieceAt(x,3);
		        			p5 = board.getPieceAt(x,4);
		        			p6 = board.getPieceAt(x,5);
		        		}
		        	}
		        	
		        	//count pieces
		        	ArrayList<Piece> horizontalA = new ArrayList<Piece>(Arrays.asList(p1,p2,p3,p4,p5));
		        	ArrayList<Piece> horizontalB = new ArrayList<Piece>(Arrays.asList(p2,p3,p4,p5,p6));
		        	ArrayList<Piece> horizontalC = new ArrayList<Piece>(Arrays.asList(p4,p5,p6,p1,p2));
		        	ArrayList<Piece> horizontalD = new ArrayList<Piece>(Arrays.asList(p5,p6,p1,p2,p3));
		        	
		        	int numPiecesA = countPieces(horizontalA, turnPlayerPiece, opponentPiece);
		        	int numPiecesB = countPieces(horizontalB, turnPlayerPiece, opponentPiece);
		        	int numPiecesC = countPieces(horizontalC, turnPlayerPiece, opponentPiece);
		        	int numPiecesD = countPieces(horizontalD, turnPlayerPiece, opponentPiece);
		        	
		        	if(numPiecesA != 0) result.add(numPiecesA);
		        	if(numPiecesB != 0) result.add(numPiecesB);
		        	if(numPiecesC != 0) result.add(numPiecesC);
		        	if(numPiecesD != 0) result.add(numPiecesD);

	       	}
	       	
	       	
	   	 }
	   	 
	   
       	
	   	 
	   	for(int x = 3; x < 6; x++ ) {
	   		
	   		Piece p1 = board.getPieceAt(x,3);
	    	Piece p2 = board.getPieceAt(x,4);
	    	Piece p3 = board.getPieceAt(x,5);
	    	Piece p4 = board.getPieceAt(x-3,3);;
	    	Piece p5 = board.getPieceAt(x-3,4);;
	    	Piece p6 = board.getPieceAt(x-3,5);;
	    	ArrayList<Piece> horizontalA = new ArrayList<Piece>(Arrays.asList(p1,p2,p3,p4,p5));
        	ArrayList<Piece> horizontalB = new ArrayList<Piece>(Arrays.asList(p2,p3,p4,p5,p6));
        	ArrayList<Piece> horizontalC = new ArrayList<Piece>(Arrays.asList(p4,p5,p6,p1,p2));
        	ArrayList<Piece> horizontalD = new ArrayList<Piece>(Arrays.asList(p5,p6,p1,p2,p3));
	    	
	    	
	    	
	    	int numPiecesA = countPieces(horizontalA, turnPlayerPiece, opponentPiece);
	    	int numPiecesB = countPieces(horizontalB, turnPlayerPiece, opponentPiece);
	    	int numPiecesC = countPieces(horizontalC, turnPlayerPiece, opponentPiece);
	    	int numPiecesD = countPieces(horizontalD, turnPlayerPiece, opponentPiece);
	    	
	    	
	    	
	    	if(numPiecesA != 0) result.add(numPiecesA);
	    	if(numPiecesB != 0) result.add(numPiecesB);
	    	if(numPiecesC != 0) result.add(numPiecesC);
	    	if(numPiecesD != 0) result.add(numPiecesD);
	    	
	   		
	   	}
	   	
		
	   	System.out.println(result.size() );
	   	
	   	 return result;
    }
    
    
    
    public static ArrayList<Integer> countVertical(PentagoBoardState board, Piece turnPlayerPiece, Piece opponentPiece){
    	
    	
    	//result store list of numbers of connected pieces
    	ArrayList<Integer> result = new ArrayList<Integer>();
	   	 for(int y = 0; y < 6; y ++)
	   	 {
	   		int currentQuadrant = getCurrentQuadrant(0,y);
	       	int[] otherQuadrants = getOtherQuadrants(0,y);
	       	for(int q = 0; q < 3; q++) 
	       	{
		        	Piece p1 = board.getPieceAt(0,y);
		        	Piece p2 = board.getPieceAt(1,y);
		        	Piece p3 = board.getPieceAt(2,y);
		        	Piece p4 = null;
		        	Piece p5 = null;
		        	Piece p6 = null;
		        	
		        	if(otherQuadrants[q] == 0) 
		        	{
		        		 p4 = board.getPieceAt(0,y-3);
		        		 p5 = board.getPieceAt(1,y-3);
		        		 p6 = board.getPieceAt(2,y-3);
		        	}
		        	else if(otherQuadrants[q] == 1) 
		        	{
		        		 p4 = board.getPieceAt(0,y+3);
		        		 p5 = board.getPieceAt(1,y+3);
		        		 p6 = board.getPieceAt(2,y+3);
		        	}
		        	else if(otherQuadrants[q] == 2) 
		        	{
		        		if(currentQuadrant == 0) 
		        		{
		        			p4 = board.getPieceAt(3,y);
		        			p5 = board.getPieceAt(4,y);
		        			p6 = board.getPieceAt(5,y);
		        		}
		        		else if (currentQuadrant == 1)  
		        		{
		        			p4 = board.getPieceAt(3,y-3);
		        			p5 = board.getPieceAt(4,y-3);
		        			p6 = board.getPieceAt(5,y-3);
		        		}
		        	}
		        	else if(otherQuadrants[q] == 3) 
		        	{
		        		if(currentQuadrant == 0) 
		        		{
		        			p4 = board.getPieceAt(3,y+3);
		        			p5 = board.getPieceAt(4,y+3);
		        			p6 = board.getPieceAt(5,y+3);
		        		}
		        		else if (currentQuadrant == 1)
		        		{
		        			p4 = board.getPieceAt(3,y);
		        			p5 = board.getPieceAt(4,y);
		        			p6 = board.getPieceAt(5,y);
		        		}
		        	}
		        
		        	//count pieces
		        	ArrayList<Piece> verticalA = new ArrayList<Piece>(Arrays.asList(p1,p2,p3,p4,p5));
		        	ArrayList<Piece> verticalB = new ArrayList<Piece>(Arrays.asList(p2,p3,p4,p5,p6));
		        	ArrayList<Piece> verticalC = new ArrayList<Piece>(Arrays.asList(p4,p5,p6,p1,p2));
		        	ArrayList<Piece> verticalD = new ArrayList<Piece>(Arrays.asList(p5,p6,p1,p2,p3));
		        	
		        	System.out.println(Arrays.toString(verticalA.toArray()));
			    	System.out.println(Arrays.toString(verticalB.toArray()));
			    	System.out.println(Arrays.toString(verticalC.toArray()));
			    	System.out.println(Arrays.toString(verticalD.toArray()));
		        	
		        	int numPiecesA = countPieces(verticalA, turnPlayerPiece, opponentPiece);
		        	int numPiecesB = countPieces(verticalB, turnPlayerPiece, opponentPiece);
		        	int numPiecesC = countPieces(verticalC, turnPlayerPiece, opponentPiece);
		        	int numPiecesD = countPieces(verticalD, turnPlayerPiece, opponentPiece);
	
	
		        	if(numPiecesA != 0) result.add(numPiecesA);
		        	if(numPiecesB != 0) result.add(numPiecesB);
		        	if(numPiecesC != 0) result.add(numPiecesC);
		        	if(numPiecesD != 0) result.add(numPiecesD);

		        	
	       	}
	   	 }
	   	 
	   	 for(int y = 3; y < 6; y++ ) {
	   		
	   		Piece p1 = board.getPieceAt(3,y);
	    	Piece p2 = board.getPieceAt(4,y);
	    	Piece p3 = board.getPieceAt(5,y);
	    	Piece p4 = board.getPieceAt(3,y-3);;
	    	Piece p5 = board.getPieceAt(4,y-3);;
	    	Piece p6 = board.getPieceAt(5,y-3);;
	    	ArrayList<Piece> verticalA = new ArrayList<Piece>(Arrays.asList(p1,p2,p3,p4,p5));
        	ArrayList<Piece> verticalB = new ArrayList<Piece>(Arrays.asList(p2,p3,p4,p5,p6));
        	ArrayList<Piece> verticalC = new ArrayList<Piece>(Arrays.asList(p4,p5,p6,p1,p2));
        	ArrayList<Piece> verticalD = new ArrayList<Piece>(Arrays.asList(p5,p6,p1,p2,p3));
        	
	    	
	    	int numPiecesA = countPieces(verticalA, turnPlayerPiece, opponentPiece);
	    	int numPiecesB = countPieces(verticalB, turnPlayerPiece, opponentPiece);
	    	int numPiecesC = countPieces(verticalC, turnPlayerPiece, opponentPiece);
	    	int numPiecesD = countPieces(verticalD, turnPlayerPiece, opponentPiece);
	    	
	    	
	    	
	    	if(numPiecesA != 0) result.add(numPiecesA);
	    	if(numPiecesB != 0) result.add(numPiecesB);
	    	if(numPiecesC != 0) result.add(numPiecesC);
	    	if(numPiecesD != 0) result.add(numPiecesD);
	    	
	   		
	   	}
	   	System.out.println(result.size() );
	   	 return result;
    }
    
    public static ArrayList<Integer> countLongDiagonal(PentagoBoardState board, Piece turnPlayerPiece, Piece opponentPiece, int[][][] c){
    	
    	//result store list of numbers of connected pieces
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	//00 11 22, 30 41 52 , 03 14 25, 33 44 55
    	
    	
    	for(int i = 0; i < 4; i++) {
    		for(int j = i+1; j < 4; j++) {
    			
    			Piece p1 = board.getPieceAt(c[i][0][0],c[i][0][1]);
            	Piece p2 = board.getPieceAt(c[i][1][0],c[i][1][1]);
            	Piece p3 = board.getPieceAt(c[i][2][0],c[i][2][1]);
            	Piece p4 = board.getPieceAt(c[j][0][0],c[j][0][1]);
            	Piece p5 = board.getPieceAt(c[j][1][0],c[j][1][1]);
            	Piece p6 = board.getPieceAt(c[j][2][0],c[j][2][1]);
            	
            	//count pieces
            	ArrayList<Piece> diagonalA = new ArrayList<Piece>(Arrays.asList(p1,p2,p3,p4,p5));
            	ArrayList<Piece> diagonalB = new ArrayList<Piece>(Arrays.asList(p2,p3,p4,p5,p6));
            	ArrayList<Piece> diagonalC = new ArrayList<Piece>(Arrays.asList(p4,p5,p6,p1,p2));
            	ArrayList<Piece> diagonalD = new ArrayList<Piece>(Arrays.asList(p5,p6,p1,p2,p3));
            	
            	int numPiecesA = countPieces(diagonalA, turnPlayerPiece, opponentPiece);
            	int numPiecesB = countPieces(diagonalB, turnPlayerPiece, opponentPiece);
            	int numPiecesC = countPieces(diagonalC, turnPlayerPiece, opponentPiece);
            	int numPiecesD = countPieces(diagonalD, turnPlayerPiece, opponentPiece);


            	if(numPiecesA != 0) result.add(numPiecesA);
            	if(numPiecesB != 0) result.add(numPiecesB);
            	if(numPiecesC != 0) result.add(numPiecesC);
            	if(numPiecesD != 0) result.add(numPiecesD);
    			
    		}
  
    		
    	}
    	
    	
    	//System.out.println(result.size());
    	return result;
    }
    
    public static ArrayList<Integer> countShortDiagonal(PentagoBoardState board, Piece turnPlayerPiece, Piece opponentPiece, int [][][][] c){
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	
    	for(int i=0; i < 4; i++) {
    		for(int j =i+1; j < 4;j++) {
    			for(int k = 0; k < 4; k++) {
    				
    				int x_firstQ_cell_1 = c[0][i][0][0];
    				int y_firstQ_cell_1 = c[0][i][0][1];
    				int x_firstQ_cell_2 = c[0][i][1][0];
    				int y_firstQ_cell_2 = c[0][i][1][1];
    				
    				int x_secondQ_cell_1 = c[0][j][0][0];
    				int y_secondQ_cell_1 = c[0][j][0][1];
    				int x_secondQ_cell_2 = c[0][j][1][0];
    				int y_secondQ_cell_2 = c[0][j][1][1];
    				
    				int x_small_cell = c[1][k][0][0];
                	int y_small_cell = c[1][k][0][1];
                	
                	if(getCurrentQuadrant(x_small_cell,y_small_cell) == getCurrentQuadrant(x_firstQ_cell_1,y_firstQ_cell_1) 
                		|| getCurrentQuadrant(x_small_cell,y_small_cell) == getCurrentQuadrant(x_secondQ_cell_1,y_secondQ_cell_1)) 
                		{continue;}
    				
                	Piece p1 = board.getPieceAt(x_firstQ_cell_1,y_firstQ_cell_1);
                	Piece p2 = board.getPieceAt(x_firstQ_cell_2,y_firstQ_cell_2);
                	
                	Piece p3 = board.getPieceAt(x_small_cell,y_small_cell);
                	
                	Piece p4 = board.getPieceAt(x_secondQ_cell_1,y_secondQ_cell_1);
                	Piece p5 = board.getPieceAt(x_secondQ_cell_2,y_secondQ_cell_2);
                	
                	ArrayList<Piece> diagonal = new ArrayList<Piece>(Arrays.asList(p1,p2,p3,p4,p5));
                	
                	int numPieces = countPieces(diagonal, turnPlayerPiece, opponentPiece);
                	if(numPieces != 0) result.add(numPieces);
                	
    			}
    		}
    	}
    	//System.out.println(result.size());
    	
    	return result;
    }
    
    
    
    public static int countPieces(ArrayList<Piece> pieces, Piece turnPlayerPiece, Piece opponentPiece) {
    	
    	//variable to store #pieces
    	int numPieces = 0;
    	
    	//when numPieces = 2, check if 2 pieces are connected enough (at most 1 piece away)
		int f = -1;
		int s = -1;
    	for(int i = 0; i < 5; i++)
    	{
    		if(pieces.get(i).equals(opponentPiece)) {
    			numPieces = 0;
    			break;
    		};
    		if(pieces.get(i).equals(turnPlayerPiece)) {
    			
    			if(f !=-1) s = i;
    			else f = i;
    			numPieces++;	
    		}
    		
    	}
    	//if(numPieces == 5 && consecutive) 
    	if(numPieces == 1) numPieces = 0;
    	else if(numPieces ==2 && Math.abs(f-s) > 2) numPieces = 0;
    	return numPieces;
    	
    }
   
    
    
    public static double eval(PentagoBoardState board, Piece turnPlayerPiece, Piece opponentPiece) {
    	
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	
    	ArrayList<Integer> r1 = countHorizontal(board,turnPlayerPiece,opponentPiece);
    	System.out.println(Arrays.toString(r1.toArray()));
    	System.out.println(r1.size());
    	ArrayList<Integer> r2 = countVertical(board,turnPlayerPiece,opponentPiece);
    	
    	
    	//long diagonals
    	int[][][] dleft = { {{0,0},{1,1},{2,2}}, { {3,0},{4,1}, {5,2}}, { {0,3},{1,4},{2,5} }, { {3,3},{4,4},{5,5} } };
    	int[][][] dright = { {{0,5},{1,4},{2,3}}, { {0,2},{1,1},{2,0}}, { {3,5},{4,4},{5,3} }, { {3,2},{4,1},{5,0} } };
    	
    	ArrayList<Integer> r3 = countLongDiagonal(board,turnPlayerPiece,opponentPiece,dleft);
    	ArrayList<Integer> r4 = countLongDiagonal(board,turnPlayerPiece,opponentPiece,dright);
    	
    	
    	//short diagonals
    	int[][][][] d1 = { {{ {0,1},{1,2}}, { {0,4},{1,5}}, { {3,1},{4,2} }, { {3,4},{4,5}} }, { { {2,0} }, { {5,0} }, { {2,3 } }, { {5,3 } }} };   	
    	int[][][][] d2 = { {{ {1,0},{2,1}}, { {4,0},{5,1}}, { {1,3},{2,4} }, { {4,3},{5,4}} }, { { {0,2} }, { {0,5} }, { {3,2 } }, { {3,5 } }} };   	
    	
    	int[][][][] d3 = { {{ {0,1},{1,0}}, { {3,1},{4,0}}, { {0,4},{1,3} }, { {3,4},{4,3}} }, { { {2,2} }, { {2,5} }, { {5,2 } }, { {5,5 } }} };
    	int[][][][] d4 = { {{ {1,2},{2,1}}, { {1,5},{2,4}}, { {4,2},{5,1} }, { {4,5},{5,4}} }, { { {0,0} }, { {3,0} }, { {0,3 } }, { {3,3 } }} };
    	
    	ArrayList<Integer> r5 = countShortDiagonal(board,turnPlayerPiece,opponentPiece,d1);
    	ArrayList<Integer> r6 = countShortDiagonal(board,turnPlayerPiece,opponentPiece,d2);
    	ArrayList<Integer> r7 = countShortDiagonal(board,turnPlayerPiece,opponentPiece,d3);
    	ArrayList<Integer> r8 = countShortDiagonal(board,turnPlayerPiece,opponentPiece,d4);
    	
    	result.addAll(r1);
    	result.addAll(r2);
    	result.addAll(r3);
    	result.addAll(r4);
    	result.addAll(r5);
    	result.addAll(r6);
    	result.addAll(r7);
    	result.addAll(r8);
    	
    	System.out.println(result.size());
    	
    	System.out.println("Result: " + Arrays.toString(result.toArray()));
  
    	double value = 0;
    	
    	for(Integer v : result) {
    		value += (v == 1)? 1 : v == 2? 5.0*v : v == 3? 50.0*v : v == 4? 500.0*v : v == 5? 100000*v : 0;
    		
    	}
    	System.out.println("VALUE: " + value);

    	
    	return value;
    	
    }
    
    
    private static int getCurrentQuadrant(int x, int y) {
    	
    	return (x >= 0 && x <= 2)? (y >=0 && y <= 2) ? 0 : 1 : (y >=0 && y <= 2)? 2 : 3;
    }
    
    private static int[] getOtherQuadrants(int x, int y) {
    	
    	return (x >= 0 && x <= 2)? (y >=0 && y <= 2)? new int[] {1,2,3} : new int[] {0,2,3} : (y >=0 && y <= 2)? new int[] {0,1,3} : new int[] {0,1,2};
    	
    }
}