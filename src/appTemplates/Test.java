package appTemplates;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public class Test {

    public static void main(String[] args) throws IOException {
        ArrayList<Object> arrayList = new ArrayList<>(5);
        LinkedList<Object> linkedList = new LinkedList<>();

        HashMap<Object, Object> hash_map = new HashMap<>();
        TreeMap<Object, Object> treeMap = new TreeMap<>();
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();

        TreeSet<Object> treeSet = new TreeSet<>();
        HashSet<Object> hashSet = new HashSet<>();

        PriorityQueue<Object> priorityQueue = new PriorityQueue<>();

        Test test = new Test();
//        int a = test.a();
//        System.out.println("a = " + a);

        ExecutorService e;
        ThreadLocal t;
        ThreadPoolExecutor threadPoolExecutor;
        Object a2 = "a1";
        test.a(a2);
        System.out.println("a2 = " + a2);
//        PriorityQueue;
    }

    synchronized void a() throws InterruptedException {
        Object o = new Object();
        o.wait();
    }

    void a(Object a) throws IOException {
        a = "S";
    }
}

class Next extends Test {

//    int a() throws IOException {
//        return 1;
//    }

}



