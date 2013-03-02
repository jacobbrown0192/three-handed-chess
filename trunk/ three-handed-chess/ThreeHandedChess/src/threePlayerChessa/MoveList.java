package threePlayerChessa;

public class MoveList {
	int number;
	int letter;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getLetter() {
		return letter;
	}
	public void setLetter(int letter) {
		this.letter = letter;
	}
	public MoveList(int number, int letter) {
		this.number = number;
		this.letter = letter;
	}
	
}
