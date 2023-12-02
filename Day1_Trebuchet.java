package snippet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1_Trebuchet {
	public static void main(String[] args) {
		System.out.println();
		ArrayList<String> list = new ArrayList<>();
		try {
			Scanner scanner = new Scanner(new File("C:\\Users\\Windows\\Desktop\\inputs_natal\\input1.txt"));
			while (scanner.hasNextLine()) {
				list.add(scanner.nextLine());
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo nao encontrado");
			e.printStackTrace();
		}

		int total = 0;
		for (int i = 0; i < list.size(); i++) {
			String str = "";
			String volta = arrumaNovo(list.get(i));
			list.set(i, arruma(list.get(i)));
			for (int j = 0; j < list.get(i).length(); j++) {
				if (Character.isDigit(list.get(i).charAt(j))) {
					str += list.get(i).charAt(j);
					break;
				}
			}
			for (int j = volta.length() - 1; j >= 0; j--) {
				if (Character.isDigit(volta.charAt(j))) {
					str += volta.charAt(j);
					break;
				}
			}
			total += Integer.parseInt(str);
		}
		System.out.println(total);
	}

	static String arruma(String str) {
		str = str.replace("eightwo", "8");
		str = str.replace("oneight", "1");
		str = str.replace("twone", "2");
		str = str.replace("nine", "9");
		str = str.replace("five", "5");
		str = str.replace("one", "1");
		str = str.replace("eight", "8");
		str = str.replace("two", "2");
		str = str.replace("three", "3");
		str = str.replace("four", "4");
		str = str.replace("six", "6");
		str = str.replace("seven", "7");
		return str;
	}

	static String arrumaNovo(String str) {
		str = str.replace("eightwo", "2");
		str = str.replace("twone", "1");
		str = str.replace("oneight", "8");
		str = str.replace("nine", "9");
		str = str.replace("five", "5");
		str = str.replace("one", "1");
		str = str.replace("eight", "8");
		str = str.replace("two", "2");
		str = str.replace("three", "3");
		str = str.replace("four", "4");
		str = str.replace("six", "6");
		str = str.replace("seven", "7");
		return str;
	}
}
