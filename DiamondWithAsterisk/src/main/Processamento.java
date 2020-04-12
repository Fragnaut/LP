package main;

/**
 *
 * @author Fragnaut
 */
public class Processamento {

    public static String diamondWithAsterisk(int n) {
        String answer = "";
        int spaces = n / 2;
        while (Math.abs(spaces) <= n / 2) {
            for (int i = 0; i < Math.abs(spaces); i++) {
                answer += " ";
            }
            for (int i = 0; i < n - 2 * Math.abs(spaces); i++) {
                answer += "*";
            }
            answer += "\n";
            spaces--;
        }
        return answer;
    }

}
