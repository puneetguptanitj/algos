import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;


public class Streams {

	public static void main(String []args){
		List<Integer> values = Arrays.asList(new Integer[]{1,2,3,4,5,6,7,1,2,3,4,5,6,7,1,2,3,4,5,6,7,1,2,3,4,5,6,7,1,2,3,4,5,6,7,1,2,3,4,5,6,7});
		System.out.println(Instant.now());
		values.parallelStream().forEach(System.out::println);
		System.out.println(Instant.now());
		values.stream().forEach(System.out::println);
		System.out.println(Instant.now());
	}
}
