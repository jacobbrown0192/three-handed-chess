package threePlayerChessa;

public class Turn extends Thread {
	Game theGame;
	public Team gameTeam;
	
	public Turn(Game aGame,Team aTeam){
		theGame = aGame;
		gameTeam = aTeam;
	}
	
	
	@Override public void run(){
		while(theGame.gameController.isInProgress() == true){
			boolean validClick = false;
			Tile select1 = null;
			Tile select2 = null;
			if(((theGame.gameController.turnCount%3) + 1) == gameTeam.getNumber()){
				if(theGame.click1 != null){
					
					for(int i =0; i < 3; i++){
						for(int j =0; j<2;j++){
							for(int k=0; k<16;k++){
								if(theGame.theBoard.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k).getLetter() == theGame.click1.getLet() &&
									theGame.theBoard.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k).getLetter() == theGame.click1.getNum()){
									select1 = theGame.theBoard.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k);
								}
							}
						}
					}
					
					if( select1.getPiece().player == gameTeam){
						validClick = true;
					}
					
					
					//check valid click
					if(validClick){
						validClick = false;
						if(theGame.click2 != null){
							
							for(int i =0; i < 3; i++){
								for(int j =0; j<2;j++){
									for(int k=0; k<16;k++){
										if(theGame.theBoard.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k).getLetter() == theGame.click2.getLet() &&
											theGame.theBoard.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k).getLetter() == theGame.click2.getNum()){
											select2 = theGame.theBoard.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k);
										}
									}
								}
							}
					
							
							if( select2.getPiece().player != gameTeam){
								validClick = true;
							}
							else{
								theGame.click1 = theGame.click2;
								theGame.click2 = null;
							}
								
							
							if(theGame.click1 == theGame.click2){
								theGame.click1 = null;
								theGame.click2 = null;
							}
							

							if(validClick){
								select1.getPiece().move(select1, select2);								
							}							
						}
						else{
							try {
								Thread.currentThread().wait();
							}
							catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					
					
					
				}
				else{
					try {
						Thread.currentThread().wait();
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}			
			}
			else{
				try {
					Thread.currentThread().wait();
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}		
	}
}
