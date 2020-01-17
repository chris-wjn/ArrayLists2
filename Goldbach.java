import java.util.ArrayList;
import java.util.Scanner;
public class Goldbach {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        Conjecture(number);
    }
    public static void Conjecture (int n) {
        int number = 0, q = 1;
        ArrayList<Integer> pnums = new ArrayList<Integer>();
        pnums = Sieve(n);
        for (int i = pnums.size()-q; i >= 0; i--) {
            if (number == 0) number = pnums.get(i);
            if (number + pnums.get(i) == n) {
                System.out.println(number + ", " + pnums.get(i));
                break;
            }
            if (pnums.get(i) == 2 && number + pnums.get(i) != n) {
                q++;
                number = 0;
                i = pnums.size()-q;
            }
        }
    }
    public static ArrayList<Integer> Sieve (int n) {
        ArrayList<Integer> newList = new ArrayList<Integer>();
        for (int i = 2; i <= n; i++) {
            newList.add(i);
        }
        for (int p = 2; p <= n; p++) {
            for (int i = newList.size()-1; i > -1; i--) {
                if (newList.get(i) % p == 0 && newList.get(i) > p) {
                    newList.remove(i);
                }
            }
        }
        return newList;
    }
}