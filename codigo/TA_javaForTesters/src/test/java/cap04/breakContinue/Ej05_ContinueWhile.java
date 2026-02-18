package cap04.breakContinue;

public class Ej05_ContinueWhile {
    public static void main(String[] args) {
        int i = 0;

        while (i < 5) {
            i++;
            if (i == 3) {
                continue;
            }
            System.out.println(i);
        }

    }
}
