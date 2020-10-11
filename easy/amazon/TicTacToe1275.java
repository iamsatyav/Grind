package easy.amazon;

public class TicTacToe1275 {
	public static void main(String[] args) {
		int[][] moves = {{0,0},{1,1},{0,1},{0,2},{1,0},{2,0}};
		System.out.println(tictactoe(moves));
	}
	
	public static String tictactoe(int[][] moves) {
        int[] aRow = new int[3];
        int[] aCol = new int[3];
        int[] bRow = new int[3];
        int[] bCol = new int[3];
        int aD1 = 0, aD2 = 0, bD1 = 0, bD2 = 0;
        for(int i=0; i<moves.length; ++i) {
        	int r = moves[i][0], c = moves[i][1];
        	if(i%2==0) {
        		if(++aRow[r] == 3 || ++aCol[c] == 3 || r==c && ++aD1==3 || r+c==2 && ++aD2 == 3) return "A";
        	}else {
        		if(++bRow[r] == 3 || ++bCol[c] == 3 || r==c && ++bD1==3 || r+c==2 && ++bD2 == 3) return "B";
        	}
        }
        return moves.length == 9 ? "Draw" : "Pending";
    }
}
