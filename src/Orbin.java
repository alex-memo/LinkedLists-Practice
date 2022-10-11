
public class Orbin extends Monster {
	private String dir;//creates variable dir
	/**
	 * constructor and initialze variablees
	 * @param col
	 * @param row
	 * @param direction
	 */
	public Orbin(int col, int row, String direction) {
		super(col,row);
		dir=direction;
	}
	/**
	 * dance method
	 */
	public void dance(MonsterMash mm) {
		int col =super.getCol();
		int row=super.getRow();
		int width=mm.getFloor().getWidth();
		int height=mm.getFloor().getHeight();
		if(dir.equals("north")) {//checks direction and does accordingly
			if(row-1>=0) {	
				row-=1;
				super.setRow(row);					 	
			}
			else{// if on border then turn 90*
				turn90();
				dance(mm);
			}
		}
		else if(dir.equals("south")) {
			if(row+1<height) {	
				row+=1;
				super.setRow(row);
			}		
			else{
				turn90();
				dance(mm);
			}
		}
		else if(dir.equals("east")) {
			if(col+1<width) {	
				col+=1;
				super.setCol(col);
			}	
			else{
				turn90();
				dance(mm);
			}
		}
		else if(dir.equals("west")) {
			if(col-1>=0) {	
				col-=1;
				super.setCol(col);
			}	
			else{
				turn90();
				dance(mm);
			}
		}

	


	}
	/**
	 * turn 90* method, turns 90* dir
	 */
	private void turn90() {
		if(dir.equals("north")) {//turn 90 degrees clockwise
			dir="east";
		}
		else if(dir.equals("east")) {
			dir="south";
		}
		else if(dir.equals("south")) {
			dir="west";
		}
		else if(dir.equals("west")) {
			dir="north";
		}
	}
}
