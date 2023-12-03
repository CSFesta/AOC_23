package snippet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Day2_CubeConundrum {
	public static void main(String[] args) {
		int total = 0;
		HashMap<Character, Integer> map = new HashMap<>();
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

				map.put('b', 0);
				map.put('r', 0);
				map.put('g', 0);

				str = str.replaceAll(" ", "");
				str = str.replaceAll(",", "");
				str = str.replaceAll(";", "");
				System.out.println(str);
				for (int i = 0; i < str.length(); i++) {
					if (Character.isAlphabetic(str.charAt(i))) {
						if (i > 1) {
							if (Character.isDigit(str.charAt(i - 2))) {
								if (map.get(str.charAt(i)) < Integer
										.parseInt("" + str.charAt(i - 2) + str.charAt(i - 1))) {
									map.put(str.charAt(i),
											Integer.parseInt(str.charAt(i - 2) + "" + str.charAt(i - 1)));
								}
							} else if (map.get(str.charAt(i)) < Integer.parseInt("" + str.charAt(i - 1))) {
								map.put(str.charAt(i), Integer.parseInt("" + str.charAt(i - 1)));
							}
						} else {
							if (map.get(str.charAt(i)) < Integer.parseInt("" + str.charAt(i - 1))) {
								map.put(str.charAt(i), Integer.parseInt("" + str.charAt(i - 1)));
								;
							}
						}
						i += switch (str.charAt(i)) {

						case 'b' -> 4;
						case 'r' -> 3;
						default -> 5;
						};
					}
					System.out.println(map.get('r'));
					System.out.println(map.get('b'));
					System.out.println(map.get('g'));
				}
				total += map.get('b') * map.get('r') * map.get('g');

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
