package array.range_module_715;

public class Main {
    public static void main(String[] args) {
        RangeModule rm = new RangeModule();
        rm.addRange(5,8);
        rm.queryRange(3,4);
        rm.removeRange(5, 6);
        rm.removeRange(3, 6);
        rm.addRange(1,3);
        rm.queryRange(2,3);
        rm.addRange(4,8);
        rm.queryRange(2,3);
        rm.removeRange(4,9);
    }
}