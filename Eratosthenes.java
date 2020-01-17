import java.util.ArrayList;
import java.util.Scanner;
public class Eratosthenes {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        System.out.println("enter number: ");
        System.out.println(Sieve(i));
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