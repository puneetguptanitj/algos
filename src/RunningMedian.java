import java.util.Comparator;
import java.util.PriorityQueue;

public class RunningMedian {
	
	static PriorityQueue<Integer> minHeapValuesGreater = new PriorityQueue<>();
	static PriorityQueue<Integer> maxHeapValuesLess    = new PriorityQueue<>(new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
		
	});
	
	public static void main(String []args){
		
		int [] input = new int [] {15, 11,34, 20, 30, 23, 4, 6,90, 45};
		
		minHeapValuesGreater.add(10);
		maxHeapValuesLess.add(7);
		for(Integer i : input){
			int median = getCurrentMedian();
			System.out.println("Current Median = " + median);
			if (i > median){
				minHeapValuesGreater.add(i);
			}else{
				maxHeapValuesLess.add(i);
			}
			if(minHeapValuesGreater.size() > (maxHeapValuesLess.size() + 1)){
				maxHeapValuesLess.add(minHeapValuesGreater.remove());
			}
			
			if(maxHeapValuesLess.size() > (minHeapValuesGreater.size() + 1)){
				minHeapValuesGreater.add(maxHeapValuesLess.remove());
			}
			
		}
		
	}
	public static int getCurrentMedian(){
		if(minHeapValuesGreater.size() > maxHeapValuesLess.size())
			return minHeapValuesGreater.peek();
		else
			return maxHeapValuesLess.peek();
	}

}
