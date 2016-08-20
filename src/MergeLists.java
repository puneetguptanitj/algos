
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeLists {
	public static class Entry implements Comparable<Entry>{
		public Entry(Integer integer, int i) {
			value = integer;
			index = i;
		}
		private int value;
		private int index;
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}
		@Override
		public int compareTo(Entry o) {
			return this.getValue() - o.getValue();
		}
		@Override
		public String toString(){
			return value +"," + index;
		}
	}

	public static void main(String []args){
		List<List<Integer>> sortedLists = new ArrayList<List<Integer>>();
		initialize(sortedLists);
		PriorityQueue<Entry>queue = new PriorityQueue<Entry>();
		initQueue(sortedLists, queue);
		while(!queue.isEmpty()){
			Entry entry = queue.remove();
			System.out.println(entry.getValue());
			int listIndex = entry.getIndex();
			if(!sortedLists.get(listIndex).isEmpty()){
				queue.add(new Entry(sortedLists.get(listIndex).remove(0),listIndex));
			}
		}
		
	}
	private static void initialize(List<List<Integer>> sortedLists) {
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);list1.add(4);list1.add(6);list1.add(8);list1.add(9);
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(10);list2.add(14);list2.add(26);list2.add(38);list2.add(43);
		List<Integer> list3 = new ArrayList<Integer>();
		list3.add(15);list3.add(17);list3.add(31);list3.add(48);list3.add(53);
		sortedLists.add(list1);
		sortedLists.add(list2);
		sortedLists.add(list3);
	}
	private static void initQueue(List<List<Integer>> sortedLists, PriorityQueue<Entry> queue) {
		for(int i = 0 ; i<sortedLists.size();i++){
			queue.add(new Entry(sortedLists.get(i).remove(0), i));
		}
	}
}
