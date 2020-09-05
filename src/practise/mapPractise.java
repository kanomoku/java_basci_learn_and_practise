package practise;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * 
 */

/**
 * @author Administrator
 *
 */
public class mapPractise {

	/**
	 * 
	 */
	public mapPractise() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		BiFunction<String, String, String> biFunc = new BiFunction<String, String, String>() {
			@Override
			public String apply(String t, String u) {
				String result = t;
				if (t == null) {
					result = u;
				} else {
					result += "," + u;
				}
				return result;
			}
		};
		Map<String, String> map = new HashMap<String, String>();
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", "value3");

		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("key1", "value1");
		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("key1", "value1");

		System.out.println(map.toString());
		System.out.println(map.size());
		System.out.println(map.isEmpty());
		System.out.println(map.containsKey("key1"));
		System.out.println(map.containsValue("value1"));
		System.out.println(map.get("key1"));
		map.put("key4", "value4");
		System.out.println(map.keySet());
		System.out.println(map.values());
		System.out.println(map.entrySet());
		// map.remove("key4");
		System.out.println(map.remove("key4"));
		System.out.println(map.remove("key3", "value4"));
		System.out.println(map.toString());
		map.replace("key1", "Value1");
		map.replace("key2", "vaalue2", "Value2");
		map.replace("key2", "value2", "Value2");
		map.replaceAll((s1, s2) -> {
			if (s1.equals("key3")) {
				s2 = "Value3";
			}
			return s2;
		});
		System.out.println(map1.equals(map2));

		Map<Integer, String> map3 = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			map3.putIfAbsent(i, "val_" + i);
		}
		map3.put(1, "A");
		map3.computeIfAbsent(23, k -> "val" + k);
		System.out.println(map3.containsKey(23));

		map3.put(3, null);
		map3.computeIfAbsent(3, k -> "bam");
		System.err.println(map3.get(3));// bam

		map3.forEach((key, value) -> System.err.println(key + " : " + value));

		map3.computeIfPresent(3, (k, v) -> v + k * 10);
		System.err.println(map3.get(3)); // val_330

		map3.put(8, null);
		System.out.println(map3.containsKey(8));
		System.out.println(map3.computeIfPresent(8, (num, val) -> null));
		System.out.println(map3.computeIfPresent(9, (num, val) -> null));
		System.out.println(map3.get(9));
		System.out.println(map3.get(100));
		System.out.println(map3.containsKey(9));

		System.out.println(map3.remove(3, "val3"));
		System.out.println(map3.get(3));
		System.out.println(map3.remove(3, "bam30"));
		System.out.println(map3.get(3));

		System.out.println(map3.getOrDefault(44, "404 not found"));

		Map<String, String> myMap = new HashMap<>();
		String keyA = "A";
		String keyB = "B";
		String keyC = "C";
		String keyD = "D";
		String keyE = "E";
		String keyF = "F";
		String keyG = "G";
		String keyH = "H";
		myMap.put(keyA, "str01A");
		myMap.put(keyB, "str01B");
		myMap.put(keyC, "str01C");

		System.out.println("myMap initial content:");
		System.out.println(myMap);

		map3.merge(9, "val999", (value, newValue) -> value.concat(newValue));
		System.err.println(map3.get(9));

		map3.merge(9, "concat", (value, newValue) -> value.concat(newValue));
		System.err.println(map3.get(9));

		myMap.merge(keyA, "merge01", String::concat);
		myMap.merge(keyD, "merge01", String::concat);
		System.out.println("Map merge demo content:");
		System.out.println(myMap);

		myMap.merge(keyA, "BiFuncMerge01", biFunc);
		myMap.merge(keyE, "BiFuncMerge01", biFunc);
		System.out.println("Map customized BiFunction merge demo content:");
		System.out.println(myMap);

		String msg = "msgCompute";
		myMap.compute(keyB, (k, v) -> (v == null) ? msg : v.concat(msg));
		myMap.compute(keyF, (k, v) -> (v == null) ? msg : v.concat(msg));
		System.out.println("Map customized BiFunction compute demo content:");
		System.out.println(myMap);

		myMap.computeIfPresent(keyC, biFunc);
		myMap.computeIfPresent(keyH, biFunc);
		System.out.println("Map customized biFunc computeIfPresent demo content:");
		System.out.println(myMap);

		myMap.computeIfAbsent(keyC, k -> genValue(k));
		myMap.computeIfAbsent(keyG, k -> genValue(k));
		System.out.println("Map customized Function computeIfAbsent demo content:");
		System.out.println(myMap);

	}

	public static void output(Map<String, String> map2) {
		for (String key : map2.keySet()) {
			System.out.println("key= " + key + " and value= " + map2.get(key));
		}
	}

	static String genValue(String str) {
		System.out.println("===");
		return str + "2";
	}
}
