
public class Minimum {
	
	public static void main (String [] args){
		Integer p[] = new Integer[]{4,5,2,7,8,1,0,9};
		int n = 1;
		while(n < p.length){
			for(int i =0 ; i < p.length; i += n){
				p[i] = p[i] < p[i+n] ? p[i+n]: p[i];
			}
			n= n * 2;
		}
		System.out.println(p);
	}
}
