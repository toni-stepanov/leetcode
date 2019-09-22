package hashtable._top_K_frequent_elements_347;

import java.util.Comparator;

public class MyComparator implements Comparator<MyEntry> {

    @Override
    public int compare(MyEntry arg0, MyEntry arg1) {
        return arg1.count - arg0.count;
    }
}