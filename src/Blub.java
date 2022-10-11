
public class Blub extends Monster {
	private String axis;//creates variables
	private int dir=1;
	/**
	 * construbtor,. and initialize variables
	 * @param col
	 * @param row
	 * @param move
	 */
	public Blub(int col, int row, String move) {
		super(col,row);
		axis=move;
		
	}
	/**
	 * dance method for grink
	 */
	public void dance(MonsterMash mm) {
		int col =super.getCol();
		int row=super.getRow();
		int width=mm.getFloor().getWidth();
		int height=mm.getFloor().getHeight();
		
		if(axis.equals("horizontal")) {//checks if the dance is horizontal or vertical 
			
			if(col+1 < width && col>=0){//checks if inside board
				col+=dir;
				super.setCol(col);	
			}
		}
		else if (axis.equals("vertical")) {
			
			if( row+1 < height&&row>=0){
				row+=dir;
				super.setRow(row);	
			}
		}
	dir*=-1;//inverts dir
	}
}
