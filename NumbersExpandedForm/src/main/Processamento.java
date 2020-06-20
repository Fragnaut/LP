package main;

/**
 *
 * @author Fragnaut
 */
public class Processamento {

    public static String expandedForm(int num) {
        String numbers = Integer.toString(num);
        String[] arrayString = numbers.split("");
        int j = arrayString.length;
        int[] arrayNumbers = new int[j];
        numbers = "";
        for (int i = 0; i < arrayString.length; i++) {
            j--;
            arrayNumbers[i] = Integer.parseInt(arrayString[i]) * (int) Math.pow(10, j);
            if (num % 10 == 0 && i < arrayString.length - 2) {
                numbers += arrayNumbers[i] + " + ";
            } else if (num % 10 != 0 && i < arrayString.length - 1) {
                numbers += arrayNumbers[i] + " + ";
            } else {
                numbers += arrayNumbers[i];
            }
        }
        return numbers;
    }

}
