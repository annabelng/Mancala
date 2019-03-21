package Mancala;

import java.util.ArrayList;

public class Algorithm {

	//declare variable that will be used in method
	int x;
	//declare and instantiate array that will hold the size of each respective arraylist
	int[] test = new int[9];
	//declare an arraylist called cells that will hold arrays
	ArrayList<ArrayList<Integer>> cells = new ArrayList<ArrayList<Integer>>();

	public Algorithm() {
		//traverse test array so that each cell starts with 3 pebbles
		for (int i = 0; i < 8; i++) {
			test[i] = 3;
		}

		//add 9 arraylists to the cells arraylist
		for (int i = 0; i < 9; i++) {
			cells.add(new ArrayList<Integer>());
		}

		//traverse the cells in the arraylist so that they each hold three elements (3 pebbles)
		for (int i = 0; i < 8; i++) {
			ArrayList<Integer> cell = cells.get(i);
			for (int j = 0; j < 3; j++) {
				cell.add(0);
			}
			//print out cell size in to aid us in testing
			System.out.print(cell.size() + " ");
		}
	}

	//method for when cells get clicked
	public void cellClicked(int n) {

		//the parameter correlates to a specific cell
		int x = n;

		//if a certain cell has been clicked...
		if (x == n) {
			//if the number of pebbles in the cell is larger
			//than the amount of cells left in the arraylist...
			if (cells.get(x).size() >= cells.size() - x) {
				//a pebble is dropped into every arraylist after the one clicked
				for (int i = x + 1; i < cells.size(); i++) {
					ArrayList<Integer> cell = cells.get(i);
					cell.add(0, 0);
					//a pebble is removed form the array clicked 
					//every single time a pebble is added elsewhere
					cells.get(x).remove(0);
					test[i] = cell.size();
				}
				//then we traverse from the beginning of the arraylist and add and remove pebbles
				//until no more pebbles are in the original cell clicked
				int temp = cells.get(x).size();
				for (int i = 0; i < temp; i++) {
					ArrayList<Integer> cell = cells.get(i);
					cell.add(0, 0);
					cells.get(x).remove(0);
					test[i] = cell.size();
				}
				//if the amount of pebbles will not run out 
				//by the end of the traversing the cells arraylist though
				//we just need to traverse until the end of the arraylist
			} else {
				int temp = cells.get(x).size();
				for (int i = x + 1; i <= x + temp; i++) {
					ArrayList<Integer> cell = cells.get(i);
					//removing and adding pebbles in the same way
					cell.add(0, 0);
					cells.get(x).remove(0);
					test[i] = cell.size();
				}
			}
			//the test array is used to determine how many pebbles to draw
			//the amount of pebbles to draw for the cell clicked turns to 0
			test[n] = 0;
		}
		//for testing purposes
		for(int i = 0; i < 9;i++) {
			System.out.print(test[i] + " ");
		}
	}
}
