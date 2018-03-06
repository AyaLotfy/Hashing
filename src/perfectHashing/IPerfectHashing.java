package perfectHashing;

import java.util.ArrayList;

public interface IPerfectHashing {
	
	void createTable(ArrayList<Integer> elements);
	boolean search(Integer key);
	int numOfRecontruction();
	
	
}
