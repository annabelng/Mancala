package Mancala;

import java.util.ArrayList;

public class Algorithm {

	int x;
	int[] test = new int[9];
	ArrayList<ArrayList<Integer>> cells = new ArrayList<ArrayList<Integer>>();

	public Algorithm() {
		for (int i = 0; i < 8; i++) {
			test[i] = 3;
		}

		for (int i = 0; i < 9; i++) {
			cells.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < 8; i++) {
			ArrayList<Integer> cell = cells.get(i);
			for (int j = 0; j < 3; j++) {
				cell.add(0);
			}
			System.out.print(cell.size() + " ");
		}
	}

	public void cellClicked(int n) {

		int x = n;

		if (x == n) {
			if (cells.get(x).size() >= cells.size() - x) {
				for (int i = x + 1; i < cells.size(); i++) {
					ArrayList<Integer> cell = cells.get(i);
					cell.add(0, 0);
					cells.get(x).remove(0);
					test[i] = cell.size();
				}
				int temp = cells.get(x).size();
				for (int i = 0; i < temp; i++) {
					ArrayList<Integer> cell = cells.get(i);
					cell.add(0, 0);
					cells.get(x).remove(0);
					test[i] = cell.size();
				}
			} else {
				int temp = cells.get(x).size();
				for (int i = x + 1; i <= x + temp; i++) {
					ArrayList<Integer> cell = cells.get(i);
					cell.add(0, 0);
					cells.get(x).remove(0);
					test[i] = cell.size();
				}
			}
			test[n] = 0;
			//System.out.println(test[1]);
		}
		for(int i = 0; i < 9;i++) {
			System.out.print(test[i] + " ");
		}
	}
}
