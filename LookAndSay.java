import java.util.ArrayList;

public class Ex06 {

    public static void displaySeq(ArrayList seq) {
        StringBuilder sb = new StringBuilder();
        for (int i = seq.size() - 1; i >= 0; i--) {
            int num = (int) seq.get(i);
            sb.append(num);
        }
        String result = sb.toString();
        System.out.print(result + "\n");
    }

    public static ArrayList calculateNext(ArrayList previous) {

        ArrayList nextRes = new ArrayList();
        int current = (int) previous.get(0);
        int number = 1;

        for (int i = 1; i < previous.size(); i++) {

            if ((int) previous.get(i) == current) {
                number++;
            }
            else {
                nextRes.add(current);
                nextRes.add(number);

                current = (int) previous.get(i);
                number = 1;
            }

        }
        nextRes.add(current);
        nextRes.add(number);
        return nextRes;
    }

    public static void sequence(int n) {
        if (n < 0) {
            return ;
        }
        ArrayList previous = new ArrayList();
        ArrayList next = new ArrayList();

        previous.add(1);
        displaySeq(previous);
        for (int i = 1; i <= n; i++) {
            next = calculateNext(previous);
            displaySeq(next);
            previous = next;
        }
    }

    public static void main(String[] args) {
        sequence(10);
    }
}
