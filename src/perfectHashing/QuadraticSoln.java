package perfectHashing;

import java.util.ArrayList;

public class QuadraticSoln implements IPerfectHashing ,IHashing{
 Integer[]table;
 Integer[]hashFunction;
 
 
	@Override
	public void createTable(ArrayList<Integer> elements) {
		
	}

	@Override
	public boolean search(Integer key) {
		return false;
	}

	@Override
	public int numOfRecontruction() {
		// TODO Auto-generated method stub
		return 0;
	}

}
