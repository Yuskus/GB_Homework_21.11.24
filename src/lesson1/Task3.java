/* Напишите функцию countLetters, которая подсчитывает 
количество каждой буквы в строке и выводит их по порядку 
в алфавите. Функция должна игнорировать регистр букв.*/

package lesson1;

import java.util.SortedMap;
import java.util.TreeMap;

public class Task3 {
    public static void main(String[] args) {
        String text = "Hello World";
        countLetters(text);
    }

    public static void countLetters(String text) {
        SortedMap<Character, Integer> letters = new TreeMap<>();
        int[] alphabet = new int[26];
        String str = text.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isAlphabetic(str.charAt(i)))
                continue;
            int current = (int) str.charAt(i) - 'a';
            alphabet[current]++;
        }
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] != 0)
                letters.put((char) (i + 'a'), alphabet[i]);
        }
        for (var el : letters.entrySet()) {
            System.out.println("Буква: " + el.getKey() + ", встретилась раз: " + el.getValue());
        }
    }
}
