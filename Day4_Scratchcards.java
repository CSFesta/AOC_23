package snippet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Day4_Scratchcards {

	public static void main(String[] args) {
		int total = 0;
		try {
			Scanner scanner = new Scanner(new File("C:\\Users\\Windows\\Desktop\\inputs_natal\\input4.txt"));
			while (scanner.hasNextLine()) {
				int cont = 0;
				char[] charArray = scanner.nextLine().substring(10).toCharArray();
				HashSet<Integer> set = new HashSet<>();
				int i = 0;

				for (; charArray[i] != '|'; i++) {
					if (Character.isDigit(charArray[i])) {
						StringBuilder value = new StringBuilder();
						value.append(charArray[i]);
						if (Character.isDigit(charArray[i + 1])) {
							value.append(charArray[i + 1]);
							i++;
						}
						set.add(Integer.parseInt(value.toString()));
					}
				}
				for (; i < charArray.length - 1; i++) {
					if (Character.isDigit(charArray[i])) {
						StringBuilder value = new StringBuilder();
						value.append(charArray[i]);
						if (Character.isDigit(charArray[i + 1])) {
							value.append(charArray[i + 1]);
							i++;
						}
						if (set.contains(Integer.parseInt(value.toString()))) {
							cont++;
						}

					}
				}
				if (Character.isDigit(charArray[charArray.length - 1]) && charArray[i - 2] == ' ') {
					if (set.contains(Integer.parseInt("" + charArray[charArray.length - 1]))) {
						cont++;
					}
				}
				if (cont != 1)
					total += (int) (Math.pow(2, cont - 1));
				else {
					total++;
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo nao encontrado");
			e.printStackTrace();
		}
		System.out.println(total);
	}

}
