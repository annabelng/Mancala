package Mancala;

import java.util.ArrayList;

public class Testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<ArrayList<Integer>> cells = new ArrayList<ArrayList<Integer>>();
		
		for(int i = 0; i<4; i++){
			cells.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<4; i++){
			ArrayList<Integer> cell = cells.get(i);
			for(int j=0; j<3; j++){
				cell.add(0);
			}
			System.out.print(cell.size()+" ");
		}
		//System.out.println(cell.size());
		System.out.println("");
		
		int x = 1;
		if (x==1){
			if(cells.get(x).size() >= cells.size()-x){
				
				for(int i=x+1; i<cells.size(); i++){
					ArrayList<Integer> cell = cells.get(i);
					cell.add(0,0);					
					cells.get(x).remove(0);
					
				}
				int temp = cells.get(x).size();
				for(int i=0; i<temp; i++){
					ArrayList<Integer> cell = cells.get(i);
					cell.add(0,0);
					cells.get(x).remove(0);
				}
			}else{
				int temp = cells.get(x).size();
				System.out.print("C temp = "+temp+" ");
				for(int i=x+1; i<=x+temp; i++){
					ArrayList<Integer> cell = cells.get(i);
					cell.add(0,0);
					cells.get(x).remove(0);
					
				}
				
			}
			
		}
		System.out.println("");
		System.out.println(cells);
		System.out.println("");

		
		
		x = 2;
		if (x==2){
			if(cells.get(x).size() >= cells.size()-x){
				for(int i=x+1; i<cells.size(); i++){
					ArrayList<Integer> cell = cells.get(i);
					cell.add(0,0);
					System.out.print(cell.size()+" ");

					cells.get(x).remove(0);
				}
				int temp = cells.get(x).size();
				for(int i=0; i<temp; i++){
					ArrayList<Integer> cell = cells.get(i);
					cell.add(0,0);
					System.out.print(cell.size()+" ");

					cells.get(x).remove(0);
				}
			}else{
				int temp = cells.get(x).size();
				for(int i=x+1; i<=x+temp; i++){
					ArrayList<Integer> cell = cells.get(i);
					cell.add(0,0);
					
					System.out.print(cell.size()+" ");

					cells.get(x).remove(0);
					System.out.println(cell.size());
				}
			}
		}
		System.out.println("");
		System.out.println("");
		System.out.println(cells);
	}

}