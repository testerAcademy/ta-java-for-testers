package cap04.breakContinue;

public class Ej03_BreakWhile {
    public static void main(String[] args) {
        int i = 1;

        while (i <= 5) {
            if (i == 3) {
                break;
            }
            System.out.println(i);
            i++;
        }

    }
}
