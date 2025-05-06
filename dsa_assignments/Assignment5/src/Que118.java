import java.util.ArrayList;
import java.util.List;

public class Que118 {
	
	public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> outer = new ArrayList<List<Integer>>();
		
        
		for(int row=0;row<numRows;row++) {
			List<Integer> innerList = new ArrayList<Integer>();
			for(int col=0;col<=row;col++) {
				if(col==0 || col==row) {
					innerList.add(col,1);
				}else {
					int left = outer.get(row-1).get(col-1);
					int right = outer.get(row-1).get(col);
					innerList.add(col,left+right);
				}
				
			}
			outer.add(innerList);
		}
		
		
		return outer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generate(5));

	}

}
