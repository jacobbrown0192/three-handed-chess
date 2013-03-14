package threePlayerChessa;

public class Turn extends Thread {
	private Game theGame;
	public Team gameTeam;
	public boolean check;
	
	public Turn(Game aGame,Team aTeam){
		setTheGame(aGame);
		gameTeam = aTeam;
	}
	
	
	@Override public void run(){
		while(getTheGame().gameController.isInProgress() == true){
			boolean validClick = false;
			check = getTheGame().gameController.inCheck();
			if (check){
				//check for checkamte
			}
			Tile select1 = null;
			Tile select2 = null;
			if(((getTheGame().gameController.turnCount%3) + 1) == gameTeam.getNumber()){
				if(getTheGame().click1 != null){
					
					for(int i =0; i < 3; i++){
						for(int j =0; j<2;j++){
							for(int k=0; k<16;k++){
								if(getTheGame().theBoard.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k).getLetter() == getTheGame().click1.getLet() &&
									getTheGame().theBoard.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k).getLetter() == getTheGame().click1.getNum()){
									select1 = getTheGame().theBoard.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k);
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
						if(getTheGame().click2 != null){
							
							for(int i =0; i < 3; i++){
								for(int j =0; j<2;j++){
									for(int k=0; k<16;k++){
										if(getTheGame().theBoard.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k).getLetter() == getTheGame().click2.getLet() &&
											getTheGame().theBoard.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k).getLetter() == getTheGame().click2.getNum()){
											select2 = getTheGame().theBoard.sections.elementAt(i).segments.elementAt(j).tiles.elementAt(k);
										}
									}
								}
							}
					
							
							if( select2.getPiece().player != gameTeam){
								validClick = true;
							}
							else{
								getTheGame().click1 = getTheGame().click2;
								getTheGame().click2 = null;
							}
								
							
							if(getTheGame().click1 == getTheGame().click2){
								getTheGame().click1 = null;
								getTheGame().click2 = null;
							}
							

							if(validClick){
								select1.getPiece().move(select1, select2,this);								
							}							
						}
						else{
							suspendMe();
						}
					}
					
					
					
				}
				else{
					suspendMe();
				}			
			}
			else{
				suspendMe();
			}
		}		
	}
	
	
	
	synchronized void suspendMe(){
		try {
			Thread.currentThread().wait();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	synchronized void unsuspendMe(){
		Thread.currentThread().notify();
	}


	public Game getTheGame() {
		return theGame;
	}


	public void setTheGame(Game theGame) {
		this.theGame = theGame;
	}
}
