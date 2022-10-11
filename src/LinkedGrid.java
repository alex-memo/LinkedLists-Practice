import java.util.*;
public class LinkedGrid<T> {
	private int width;
	private int height;//create variables
	private ArrayList<LinearNode<T>> grid;
	//private LinearNode<T>[] grid;
	/**
	 * Gets the height and width of the grid (constructor) and initializes variablkezs
	 * @param width
	 * @param height
	 */
	public LinkedGrid(int w,int h) {
		width = w;
		height = h;
		grid = new ArrayList<>();

		int i=0; int j=1;
		while(i<width) {	//while there is a space in the array, fill it with a linear node
			grid.add(new LinearNode<T>());
			LinearNode<T> temp = grid.get(i);
			while(j<height) {

				temp.setNext(new LinearNode<T>());
				temp = temp.getNext();
				j++;
			}
			j=0;
			i++;
		}  
	}
	/**
	 * sets the element obtained into the grid and throws an exeption if it is outisde the grid
	 * @param col
	 * @param row
	 * @param data
	 */
	public void setElement(int col, int row, T data){
		if(col >= width || row >= height||row<0||col<0){
			throw new LinkedListException("Outside");
		}
		LinearNode<T> t = grid.get(col);
		int i=0;
		while(i<row) {
			t = t.getNext();
			i++;
		}

		t.setElement(data);
	}
/**
 * returns the element in the column and row inputted
 * @param col
 * @param row
 * @return
 */
	public LinearNode<T> getElement(int col, int row){
		if(col >= width || row >= height||row<0||col<0){//check for negative rows and col
			throw new LinkedListException("Outside");
		}
		LinearNode<T> t = grid.get(col);
		int i=0;
		while(i<row){
			t = t.getNext();
			i++;
		}
		return t;
	}
/**
 * return the width of the grid
 * @return width
 */
	public int getWidth(){
		return width;
	}
/**
 * returns the grid height
 * @return height
 */
	public int getHeight(){
		return height;
	}
	/**
	 * To string override
	 */
	public String toString(){
		ArrayList<LinearNode<T>> t = new ArrayList<>();
		for(int i=0;i<width;i++){
			t.add(grid.get(i));
		}

		String s = "";
		int i=0; int j=0;
		while(i<height) {
			while(j<width) {
				s += String.valueOf(t.get(j).getElement()) + "  ";
				t.set(j, t.get(j).getNext());
				j++;	
			}
			s+="\n";
			i++;
			j=0;
		}
		return s;
	}

}