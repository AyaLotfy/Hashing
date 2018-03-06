package perfectHashing;

import java.util.ArrayList;

public class LinearSoln implements IPerfectHashing, IHashing {
	QuadraticSoln[] table;
	Integer[][] hashFunction;
	int reconstuctionNumb;
	UniversalHashing universalOb;
	ArrayList<Integer>[] tempTable;

	public LinearSoln(ArrayList<Integer> elements) {
		table = new QuadraticSoln[elements.size()];
		tempTable = new ArrayList[elements.size()];
		for (int i = 0; i < tempTable.length; i++) {
			tempTable[i] = new ArrayList<>();
		}
		universalOb = new UniversalHashing(elements.size());
		reconstuctionNumb = 0;
		createTable(elements);
	}

	@Override
	public void createTable(ArrayList<Integer> elements) {
		hashFunction = universalOb.randomMatrix(elements.size());
		for (int i = 0; i < elements.size(); i++) {
			Integer[][] xMatx = universalOb.XMatrix(elements.get(i));
			int address = universalOb.addressMatrix(hashFunction, xMatx);
			tempTable[address].add(elements.get(i));

		}
		for (int i = 0; i < tempTable.length; i++) {
			if (tempTable[i].size() == 0) {
				continue;
			}
			QuadraticSoln subTable = new QuadraticSoln();
			subTable.createTable(tempTable[i]);
			reconstuctionNumb += subTable.numOfRecontruction();
			table[i] = subTable;
		}

	}

	@Override
	public boolean search(Integer key) {
		Integer[][] xMatx = universalOb.XMatrix(key);

		int address = universalOb.addressMatrix(hashFunction, xMatx);

		return table[address].search(key);
	}

	@Override
	public int numOfRecontruction() {
		return reconstuctionNumb;
	}

}
