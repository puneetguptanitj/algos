public class Test {
	public enum Privilege {
	    READ,
	    WRITE,
	    EXECUTE
	}
	public static void main(String [] args){
		/*Gson gson = new Gson();
		List<Privilege> typeToken = gson.fromJson("[\"EXECUTE\"]", new TypeToken<ArrayList<Privilege>>(){}.getType());
		List<Privilege> getClass  = gson.fromJson("[null]", new ArrayList<String>().getClass());
		System.out.println(getClass.get(0).getClass());*/
	}
}
