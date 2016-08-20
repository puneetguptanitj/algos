
public class Coins {
	static int [] coins  = new int [] {1,5,10,21,25};
	public static void main(String []args){
		int total     = 60;
		int [] memory = new int [total + 1];
		for(int i : coins){
			memory[i] = 1;
		}
		
		System.out.println(minCoins(total, memory));
	}
	
	public static int minCoins(int total,int [] memory){
		if(total <0 ) return -1;
		if(memory[total] >0 ) return memory[total];
		int min = Integer.MAX_VALUE;
 		for(int i: coins){
 			int cost = minCoins(total -i, memory);
			if (cost != -1 && (cost +1 )< min){
				min = cost + 1;
				
			}
		}
 		if(min == Integer.MAX_VALUE){
 			min = -1;
 		}
 		memory[total] = min;
		return min;
	}
}
