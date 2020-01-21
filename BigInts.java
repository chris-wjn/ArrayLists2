import java.util.ArrayList;
public class BigInts {
    public static void main (String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();
        a.add(9);
        a.add(8);
        a.add(7);
        b.add(6);
        b.add(5);
        b = makeSame(a, b);
        System.out.println(add(a, b));
    }
    public static ArrayList<Integer> makeSame (ArrayList<Integer> a, ArrayList<Integer> b) {
        if (a.size() > b.size()) {
            for (int i = a.size()-1; i >= 0; i--) {
                if (b.size() < a.size()) b.add(0, 0);
            }
            return b;
        }
        if (b.size() > a.size()) {
            for (int i = a.size()-1; i >= 0; i--) {
                if (a.size() < b.size()) b.add(0, 0);
            }
            return a;
        }
        return a;
    }
    public static ArrayList<Integer> add (ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> newList = new ArrayList<Integer>();
        int number = 0, remainder = 0;
        newList.add(0);
        for (int i=0; i<list1.size(); i++) {
            remainder = 0;
            number = list1.get((list1.size()-1)-i) + list2.get((list2.size()-1)-i);
            if (number >= 10) {
                remainder = 1;
                number -= 10;
            } else {
                remainder=0;
            }
            if (newList.get(0) != -1) {
                newList.add(0, number);
            } else if (newList.get(0) == -1) {
                newList.set(0, number+1);
            }
            if (remainder == 1) newList.add(0, -1);
        }
        if (newList.get(0) == -1) newList.set(0, 1);
        newList.remove(newList.size()-1);
        return newList;
    }
}
