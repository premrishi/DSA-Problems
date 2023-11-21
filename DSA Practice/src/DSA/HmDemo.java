package DSA;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HmDemo {

	public static void main(String[] args) {
		//HashMap<Integer, Integer> hp = new HashMap<>();
		LinkedHashMap<Integer, Integer> hp = new LinkedHashMap<>();
		hp.put(1, 1);
		hp.put(2, 3);
		hp.put(5, 16);
		hp.put(100, 0);
		hp.put(20, 9);
		
		for(Map.Entry<Integer, Integer> entry : hp.entrySet()) {
			System.out.println(entry.getKey() + " -->" + entry.getValue());
		}
		
		boolean x = hp.containsKey(77);
		System.out.println(x);
		
		System.out.println(hp);

	}

}
