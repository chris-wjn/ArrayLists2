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
    public static ArrayList<Integer> add (ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> returnList = new ArrayList<Integer>();
        int remainder = 0, number = 0, oldRemainder = 0;
        for (int i = 0; i < a.size(); i++) {
            if ((a.get(i) + b.get(i)) > 9) {
                remainder = (a.get(i) + b.get(i)) - 10;
                number = (a.get(i) + b.get(i)) - remainder + oldRemainder - 9;
                returnList.add(i, number);
                oldRemainder = remainder;
                i++;
            }
            returnList.add(i, (a.get(i) + b.get(i)));
        }
        returnList.add(oldRemainder);
        return returnList;
    }
}