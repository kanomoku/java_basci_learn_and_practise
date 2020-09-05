package sevenThunils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class quchong {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list.add(10);
        list.add(11);
        list.add(12);
        list.add(13);
        list2.add(20);
        list2.add(21);
        list2.add(22);
        list2.add(23);
        String a =EfsnStringTokenizer.listToDelimitedString(new Collection[]{list, list2}, ", ");
        

    }

}
