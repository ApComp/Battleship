package pack;

public class Main {
	private static int playBoard;
	private static int compboard3;
	private static int randomRow = (int)((Math.random())*10);
	private static int randomColumn = (int)((Math.random())*10);
	private static int[][] board = new int[10][10];
	private static int[][] compboard = new int[10][10];
	private static int[][] dummy = new int[10][10];
	private static UserInput user = new UserInput();
	private static boolean game = true;
	private static int direction = (int) (Math.random()*10);
	//Boards
	public static int playerBoard(){
		
		
		for(int[] board1d : board){
			for(int boardInt : board1d){
				System.out.print(boardInt+ " ");
				playBoard = boardInt;
			}
		System.out.println();
		
		}
		System.out.println();
		return playBoard;
	}
	
	public static int compBoard(){
		
		
			for(int[] board1d : compboard){
				for(int boardInt : board1d){
					System.out.print(boardInt+ " ");
					compboard3 = boardInt;
				}
				System.out.println();
		
			}
			System.out.println();
	        return compboard3;
	}
	
	public static void compRandomShip(){
		compboard[randomRow][randomColumn] = 1;
		if(direction>=0 && direction <= 1){
			compboard[randomRow-1][randomColumn] = 1;
		}else if(direction >=2 && direction <=4){
			compboard[randomRow][randomColumn+1] = 1;
		}else if(direction >=5 && direction <=7){
			compboard[randomRow+1][randomColumn] = 1;
		}else if (direction >=8 && direction <=9){
			compboard[randomRow][randomColumn-1] = 1;
		}
	}
	
	public static void checkBound(int row, int col, int type) {
		if(row >= 10 || row < 0) {
			 if (type == 0){
				 playerShip();
			 }else if(type == 1) {
				 fire();
			 }
		
		}else{
			if(col >= 10 || col < 0) {
				if(type == 0){
					playerShip();
				}else if(type == 1) {
					fire();
				}
			}else{
				
			}
		}
	}
	public static void playerShip(){
		
		int shipRow =(int) user.getDoubleInput("Please input a row number: 0-9");
		int shipColumn = (int) user.getDoubleInput("Please input a column number: 0-9");
		if((shipRow <= 9 && shipColumn <= 9) && (shipRow >= 0 && shipColumn >= 0) ) {
			board[shipRow][shipColumn] = 1;
		}else{
			System.out.println("Question your intelligence.");
			playerShip();
		}
	}
		public static void fire(){
		int rowFire =(int) user.getDoubleInput("Please input a row to fire upon.");
		int columnFire =(int) user.getDoubleInput("Please input a column to fire upon.");
		checkBound(rowFire, columnFire, 1);
		if(compboard[rowFire][columnFire] == 1){
			compboard[rowFire][columnFire] =7;
			System.out.println("You are Winner!");
			game = false;
		}else if(compboard[rowFire][columnFire] != 1){
			System.out.println("You have missed the objective.");
		}
		
	
	}
	public static void main(String[] args){
		
		compRandomShip();
		compBoard();
		playerShip();
		playerBoard();
		while (game){
			fire();
		}
		
		
		
		
	
		
		
		
	}
}
