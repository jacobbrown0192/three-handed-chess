package threePlayerChessa;

public class TileRelations {
	public int relations[][][] = new int[96][13][2]; //number then letter
	
	
	
	Tile up,down,left,right,downleft,downright,upleft,upright,hop,specialup,specialdown,specialleft,specialright;
	
	
	
	public TileRelations(){
		relations[1][1][1] = 2;
		relations[1][1][2] = 1;
		relations[1][2][1] = 0;
		relations[1][2][2] = 0;
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
}
