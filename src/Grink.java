
public class Grink extends Monster{
	private  LinearNode<String> actions;//create variabels
	private  LinearNode<String> currAction;
/**
 * constructor and initialize variables
 * @param col
 * @param row
 * @param act
 */
	public Grink(int col, int row, String[] act) {
		super(col,row);
		//currAction=this.actions;
		if(act!=null ) {
			createActionList(act);
		}

	}
/**
 * creates a linkedlist from an array, also initializes curraction
 * @param act
 */
	private void createActionList(String[] act) {
		LinearNode<String>node,pnode;
		node=new LinearNode<String>(act[0]);
		pnode=actions=node;
		int i=1;
		while(i<act.length) {
			node=new LinearNode<String>(act[i]);
			pnode.setNext(node);
			pnode=pnode.getNext();
			i++;
		}
		currAction=actions;//link
	}
/**
 * dance method, this just checks if currAction is null
 */
	public void dance(MonsterMash mm) {
		if(currAction!=null) {
			actualDance(mm);
		}	
		else {
			currAction=actions;
			actualDance(mm);
		}
	}
	/**
	 * thius is the actual dance method, it handles the dance, as well as uses recursion for the algorith
	 * @param mm
	 */
	private void actualDance(MonsterMash mm) {
		int col =super.getCol();
		int row=super.getRow();
		int width=mm.getFloor().getWidth();
		int height=mm.getFloor().getHeight();
		//if(currAction!=null) {//
			if(currAction.getElement().equals("north")) {//checks direction
				row-=1;
				if( row <= height&&row>=0){//checks if desired position is on gird, else then dont do anything
					super.setRow(row);	
				}
				currAction=currAction.getNext();		
			}
			else if(currAction.getElement().equals("east")) {
				col+=1;
				if(col <= width && col>=0){
					super.setCol(col);	
				}
				currAction=currAction.getNext();
			}
			else if(currAction.getElement().equals("south")) {
				row+=1;
				if( row <= height&&row>=0){
					super.setRow(row);	
				}
				currAction=currAction.getNext();
			}
			else if(currAction.getElement().equals("west")) {
				col-=1;
				if(col <= width && col>=0){
					super.setCol(col);	
				}
				currAction=currAction.getNext();
			}
			else if(currAction.getElement().equals("repeat")) {
				currAction=actions;
				actualDance(mm);//recursion if repeat
			}

	}




}
