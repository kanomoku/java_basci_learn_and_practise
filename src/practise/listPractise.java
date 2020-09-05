package practise;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 */

/**
 * @author Administrator
 *
 */
public class listPractise {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> allList = new ArrayList<String>();
		List<String> allList2 = new ArrayList<String>();
		List<String> allList3 = new ArrayList<String>();
		List<String> allList4 = new ArrayList<String>();
		List<String> allList5 = new ArrayList<String>();
		Collection<String> allCollection = new ArrayList<String>();
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(55);
		list.add(9);
		list.add(0);
		list.add(2);
		allCollection.add("i am");
		allCollection.add("coming");
		allList.add("hello");
		allList.add("World");

		allList2.add("i am");
		allList2.add("coming");
		allList2.add("coming");

		allList3.add("coming");
		allList3.add("i am");

		allList5.add("i am");
		allList5.add("coming");

		// allList.add(2, "coming");
		// allList.add(3, "i am");
		allList.addAll(allList2);
		// allList.addAll(4,allCollection);
		// allList.addAll(0,allCollection);

		System.out.println(allList.contains("hello"));
		System.out.println(allList2.containsAll(allList3));
		// allList.remove("coming");
		// allList.remove(1);
		// allList.removeAll(allList3);
		System.out.println(allList.get(4));
		// allList.clear();
		System.out.println(allList.size());
		System.out.println(allList4.isEmpty());
		System.out.println(allList4);
		System.out.println(allList.toString() + " wahaha");
		System.out.println(allList.indexOf("coming"));
		System.out.println(allList.lastIndexOf("coming"));
		System.out.println(allList5.equals(allList3));
		System.out.println(allCollection.equals(allList5));

		System.out.println(allList.subList(0, 5));
		System.out.println(allList.subList(0, 0));
		System.out.println(allList.subList(1, 1));
		System.out.println(allList.subList(5, 5));

		Collections.replaceAll(allList, "coming", "go");
		// allList.removeIf(m -> m.contains("go"));

		list.sort(null);
		System.out.println(list);
		Collections.sort(list);// ����
		System.out.println(list);

		Collections.reverse(list);// ��ת
		System.out.println(list);

		list = listSort2(list);// ����
		System.out.println(list);
		for (int a : list) {
			System.out.println(a);
		}

		list.forEach(a -> {
			System.out.println(a);
		});
		list.stream().forEach(a -> {
			System.out.println(a);
		});
	}

	/**
	 * ����
	 */
	public static List<Integer> listSort2(List<Integer> list) {

		Collections.sort(list, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		return list;
	}
}
