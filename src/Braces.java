
public class Braces {

	public static void braces(int opening, int closing, String output){
		if(opening == 0 && closing == 0){
			System.out.println(output);
		}
		if(opening >0){
			braces(opening -1 ,closing, output + "(" );
		}
		if(closing >0 && opening < closing){
			braces(opening, closing -1 , output + ")" );
		}
		
	}
	public static void main(String []args){
		braces(3,3,"");
	}
}
