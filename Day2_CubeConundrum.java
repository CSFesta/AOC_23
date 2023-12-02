package snippet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Day2_CubeConundrum {
	public static void main(String[] args) {
		int total = 0;
		int cont = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		map.put('b', 14);
		map.put('r', 12);
		map.put('g', 13);
		try {
			Scanner scanner = new Scanner(new File("C:\\Users\\Windows\\Desktop\\inputs_natal\\input2.txt"));
			while (scanner.hasNextLine()) {

				String str = scanner.nextLine();
				for (int i = 0; i < 9; i++) { // pegar apenas informacoes importantes
					if (str.charAt(i) == ':') {
						str = str.substring(i + 2);
						break;
					}
				}

				cont++;
				str = str.replaceAll(" ", "");
				str = str.replaceAll(",", "");
				str = str.replaceAll(";", "");
				System.out.println(str);
				boolean res = false;
				for (int i = 0; i < str.length(); i++) {
					if (Character.isAlphabetic(str.charAt(i))) {
						if (i > 1) {
							if (Character.isDigit(str.charAt(i - 2))) {
								if (map.get(str.charAt(i)) < Integer
										.parseInt("" + str.charAt(i - 2) + str.charAt(i - 1))) {
									res = true;
									break;
								}
							} else if (map.get(str.charAt(i)) < Integer.parseInt("" + str.charAt(i - 1))) {
								res = true;
								break;
							}
						} else {
							if (map.get(str.charAt(i)) < Integer.parseInt("" + str.charAt(i - 1))) {
								res = true;
								break;
							}
						}
						i += switch (str.charAt(i)) {

						case 'b' -> 4;
						case 'r' -> 3;
						default -> 5;
						};
					}
				}
				if (!res) {
					total += cont;
				}
			}
			System.out.println(total);
			scanner.close();
		} catch (

		FileNotFoundException e) {
			System.err.println("Arquivo nao encontrado");
			e.printStackTrace();
		}
	}
}
